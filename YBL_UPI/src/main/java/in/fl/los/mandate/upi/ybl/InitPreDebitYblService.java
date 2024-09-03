package in.fl.los.mandate.upi.ybl;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import in.fl.los.model.Registry;
import in.fl.los.repository.LoanRepository;
import in.fl.los.repository.RegistryRepository;

@Service
public class InitPreDebitYblService {

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private RegistryRepository registryRepository;

	private final Logger log = Logger.getLogger(InitPreDebitYblService.class);

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

	@Scheduled(fixedDelay = 30 * 60 * 1000)
	public void createPreDebits() {
		try {
			long preDebitStartTime = System.currentTimeMillis();
			log.info("UPIMandateServiceImpl  create predebit profile : " + activeProfile);
			Registry registry = registryRepository.findByconfigKey("UPI_PDEBIT_START");
			int pDebitStartHour = Integer.parseInt(registry.getConfigValue());
			registry = registryRepository.findByconfigKey("UPI_PDEBIT_END");
			int pDebitEndHour = Integer.parseInt(registry.getConfigValue());
			Calendar calendar = Calendar.getInstance();
			int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
			boolean isPreDebitEnabled = false;
			if (hourOfDay >= pDebitStartHour && hourOfDay < pDebitEndHour) {
				isPreDebitEnabled = true;
				log.info("Predebit scheduling window open : " + hourOfDay);
			} else {
				log.info("Predebit scheduling window closed : " + hourOfDay);
			}

			if (activeProfile.equalsIgnoreCase("uat") && isPreDebitEnabled) {
				chunkSize = Integer.parseInt(registryRepository.findByconfigKey("UPI_PREDEBIT_CHUNK").getConfigValue());
				int noOfThreads = Integer
						.parseInt(registryRepository.findByconfigKey("UPI_PREDEBIT_THREADS").getConfigValue());
				if (nextStartId == -1) {
					int minRecordId = loanRepository.getMinRecordId();
					nextStartId = minRecordId - 1;
				}
				if (endId == -1) {
					int maxRecordId = loanRepository.getMaxRecordId();
					endId = maxRecordId;
				}
				log.info("Starting predebits with === NextStart id : " + nextStartId + "  End Id :  " + endId);
				InitPredebitThreadYbl[] preDebitThreadsYbl = new InitPredebitThreadYbl[noOfThreads];
				for (int threadId = 0; threadId < noOfThreads; threadId++) {
					preDebitThreadsYbl[threadId] = beanFactory.getBean(InitPredebitThreadYbl.class);
					preDebitThreadsYbl[threadId].setChunkSize(chunkSize);
					preDebitThreadsYbl[threadId].setThreadId(threadId);
					preDebitThreadsYbl[threadId].start();
				}

				// Wait for ALL threads to complete work and join
				for (int threadId = 0; threadId < noOfThreads; threadId++) {
					preDebitThreadsYbl[threadId].join();
					log.info("========= [" + threadId + "] ==> Completed");
				}
				nextStartId = -1;
				endId = -1;
			}
			log.info("TIme take for initializing predebits is : " + (System.currentTimeMillis() - preDebitStartTime));
		} catch (Exception ex) {
			log.info("Exception occured in predebit thread : ", ex);
		}
	}
}
