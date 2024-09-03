package in.fl.los.mandate.upi.ybl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.api.client.util.Value;

import in.fl.los.model.Registry;
import in.fl.los.repository.LoanRepository;
import in.fl.los.repository.RegistryRepository;

@Service
public class InitDebitYblService {

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private RegistryRepository registryRepository;

	private final Logger log = Logger.getLogger(InitDebitYblService.class);

	@Value("${spring.profiles.active}")
	private String activeProfile;

	private static int nextStartId = -1;
	private static int endId = -1;
	private static int chunkSize = 50;

	public static synchronized int getNextStartId() {
		if (nextStartId > endId)
			return -1; // ALL loans exhausted

		int ret = nextStartId;
		nextStartId += chunkSize;
		return ret;
	}

	// @Scheduled(fixedDelay = 30 * 60 * 1000)
	@Scheduled(cron = "0 1 6,8,11,15,17,19,21 * * *")
	public void invokeDebits() {
		log.info("Triggering debits on fixed interval");
		triggerDebits(false);
	}

	@Scheduled(fixedDelay = 60 * 60 * 1000)
	public void invokeDelinquentDebits() {
		log.info("Triggering delinquent debits on fixed interval");
		int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		List<Integer> debitHours = getDelinquentDebitHours();
		if (debitHours.contains(hourOfDay)) {
			log.info("Triggering delinquent debits at hour of day :: " + hourOfDay);
			triggerDebits(true);
		}
	}

	private synchronized void triggerDebits(boolean isDelinquentRun) {
		try {
			long startTimeInMillis = System.currentTimeMillis();
			log.info("InitDebitYblService invokeUPIDebit profile : " + activeProfile);
			if (activeProfile == null || activeProfile.equalsIgnoreCase("uat")) { // TODO
				Registry registry = registryRepository.findByconfigKey("UPI_DEBIT_ENABLE");

				if (registry.getConfigValue().equalsIgnoreCase("true")) {
					log.info("Invoke UPI debits enabled and executing :: " + isDelinquentRun);
					chunkSize = Integer
							.parseInt(registryRepository.findByconfigKey("UPI_DEBIT_CHUNK").getConfigValue());
					int noOfThreads = Integer
							.parseInt(registryRepository.findByconfigKey("UPI_DEBIT_THREADS").getConfigValue());
					if (nextStartId == -1) {
						int minRecordId = loanRepository.getMinRecordId();
						nextStartId = minRecordId;
					}
					if (endId == -1) {
						int maxRecordId = loanRepository.getMaxRecordId();
						endId = maxRecordId;
					}
					log.info("Starting debits with === NextStart id : " + nextStartId + "  End Id :  " + endId);
					InitDebitThreadYbl[] debitThreadsYbl = new InitDebitThreadYbl[noOfThreads];
					for (int threadId = 0; threadId < noOfThreads; threadId++) {
						debitThreadsYbl[threadId] = beanFactory.getBean(InitDebitThreadYbl.class);
						debitThreadsYbl[threadId].setChunkSize(chunkSize);
						debitThreadsYbl[threadId].setThreadId(threadId);
						debitThreadsYbl[threadId].setDelinquentRun(isDelinquentRun);
						debitThreadsYbl[threadId].start();
					}

					// Wait for ALL threads to complete work and join
					for (int threadId = 0; threadId < noOfThreads; threadId++) {
						debitThreadsYbl[threadId].join();
						log.info("========= [" + threadId + "] ==> Completed");
					}
					nextStartId = -1;
					endId = -1;
				}
			}
			log.info("Time taken for invoking Debits is : " + (System.currentTimeMillis() - startTimeInMillis));
		} catch (Exception e) {
			log.info("Exception occured in debit thread Ybl : ", e);
		}
	}

	private List<Integer> getDelinquentDebitHours() {
		Integer[] debitHours = { 7, 9, 10, 12, 13, 14, 16, 18, 20 }; // TODO { 7, 9, 10, 12, 13, 14, 16, 18, 20 };
		return Arrays.asList(debitHours);
	}
}
