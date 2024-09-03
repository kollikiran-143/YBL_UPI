package in.fl.los.mandate.upi.ybl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.fl.los.mandate.upimandate.ybl.Mandate;
import in.fl.los.mandate.upimandate.ybl.PreDebitYblRequest;
import in.fl.los.mandate.upimandate.ybl.PreDebitYblResponse;
import in.fl.los.mandate.upimandate.ybl.Recurrence;
import in.fl.los.mandate.upimandate.ybl.RequestInfo;
import in.fl.los.mandate.upimandate.ybl.UPIMandateYblService;
import in.fl.los.model.Charges;
import in.fl.los.model.Loan;
import in.fl.los.model.ReceiptsYblUpi;
import in.fl.los.model.Receivable;
import in.fl.los.model.Registry;
import in.fl.los.repository.ChargesRepository;
import in.fl.los.repository.LmsOdcDailyRepository;
import in.fl.los.repository.LoanRepository;
import in.fl.los.repository.ReceiptsYblUpiRepository;
import in.fl.los.repository.ReceivableRepository;
import in.fl.los.repository.RegistryRepository;
import in.fl.los.util.CommonUtils;
import in.fl.los.ybl.util.YblUtil;

@Component
@Scope("prototype")
public class InitPredebitThreadYbl extends Thread {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private ReceivableRepository receivableRepository;

	@Autowired
	private ReceiptsYblUpiRepository receiptsYblUpiRepository;

	@Autowired
	private ChargesRepository chargesRepository;

	@Autowired
	private RegistryRepository registryRepository;

	@Autowired
	private LmsOdcDailyRepository lmsOdcDailyRepository;

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	private int startIndex, chunkSize, threadId;

	private final Logger log = Logger.getLogger(InitPredebitThreadYbl.class);

	public void run() {
		CommonUtils.mdcPut("CustomerId", "PDEBIT_" + threadId);
		while (true) {
			startIndex = InitPreDebitYblService.getNextStartId();
			log.info("========= Initialising Thread : StartIndex : " + startIndex + " End Index : "
					+ (startIndex + chunkSize) + " Thread Id : " + threadId);
			if (startIndex == -1) {
				log.info("Loans Exhausted and exiting : Thread Id : " + threadId);
				break; // Exhausted ALL leads => STOP
			}
			doWork();
		}
		MDC.remove("CustomerId");
	}

	private void doWork() {
		int endIndex = (startIndex + chunkSize);
		log.info("========= Starting Predebit Ybl Thread : StartIndex : " + startIndex + " End Index : " + endIndex
				+ " Thread Id : " + threadId);
		long startTimeInMillis = System.currentTimeMillis();
		List<Loan> loans = loanRepository.getLoanList(startIndex, endIndex);
		if (loans.size() != 0) {
			log.info("Number of Loans : " + loans.size() + " with : StartIndex : " + startIndex + " End Index : "
					+ endIndex + " Thread Id : " + threadId);
		}

		LocalDate today = LocalDate.now();
		LocalDate dueDate = today.plusDays(1);
		for (Loan loan : loans) {
			try {
				long loanStartTime = System.currentTimeMillis();
				// initpreDebit(loan, today, dueDate);

				log.info("Creating pre debits for loan no : " + loan.getLoanNo() + " Due Date : " + dueDate);
				if (!loan.isUpiPredebit()) {
					log.info("pre debits for loan No :" + loan.getLoanNo() + "is disabled!!!");
					continue;
				}
				List<Receivable> dues = receivableRepository.getLoanDues(loan.getLoanNo(), dueDate);
				if (dues == null || dues.isEmpty()) {
					log.info("No Dues for Loan No => " + loan.getLoanNo() + " for : " + dueDate);
					continue;
				} else {
					int dueCount = Math.min(5, dues.size());
					log.info("Due count for loan no : " + loan.getLoanNo() + " is  : " + dueCount);

					List<ReceiptsYblUpi> receipts = receiptsYblUpiRepository
							.getSuccessPredebitsByRcptType(loan.getLoanNo(), dueDate, "EDI");
					if (receipts == null || !receipts.isEmpty()) {
						log.info("Successful Predebits for Loan No=>" + loan.getLoanNo() + "  is : " + receipts.size());
					}
					int preDebitCount = dueCount - receipts.size();

					if (preDebitCount == 0) {
						log.info("Predebits created succesfully for Loan No => " + loan.getLoanNo() + "  for : "
								+ dueDate);
					} else {
						float edi = loan.getEdi();
						for (int index = 0; index < preDebitCount; index++) {
							if (index < dues.size()) {
								Receivable due = dues.get(index);
								edi = due.getEmi() - due.getPrinPaid() - due.getIntPaid();
							}
							initpreDebitYbl(loan, "EDI", edi, today, dueDate, index);
						}
					}

					Registry registry = registryRepository.findByconfigKey("UPI_PREDEBIT_CHARGES");
					if (registry.getConfigValue().equals("true") && loan.getDpd() >= 4) {

						List<Charges> unpaidBC = chargesRepository.getUnpaidChargesListByType(loan.getLoanNo(), "BC");
						List<Charges> unpaidFVC = chargesRepository.getUnpaidChargesListByType(loan.getLoanNo(), "FVC");
						float unpaidODC = lmsOdcDailyRepository.getTotalOdcAmt(loan.getLoanNo());

						if ((unpaidBC == null || unpaidBC.size() == 0) && (unpaidFVC == null || unpaidFVC.size() == 0)
								&& unpaidODC == 0) {
							log.info("Charges Predebits created succesfully for Loan No => " + loan.getLoanNo()
									+ "  for : " + dueDate);
							continue;
						}

						// BC Charges Pre Debits
						if (unpaidBC != null && unpaidBC.size() > 0) {
							int bcPreDebitMaxCount = Integer
									.parseInt(registryRepository.findByconfigKey("UPI_PREDBIT_BCMAX").getConfigValue());
							List<ReceiptsYblUpi> bcReceipts = receiptsYblUpiRepository
									.getSuccessPredebitsByRcptType(loan.getLoanNo(), dueDate, "BC");

							int bcPreDebitCount = bcPreDebitMaxCount - bcReceipts.size();
							if (bcPreDebitCount > 0) {
								for (int index = 0; index < bcPreDebitCount; index++) {
									Charges charge = unpaidBC.get(endIndex);
									float predebitAmt = charge.getChargeAmount() + charge.getTaxAmount()
											- charge.getChargeCollected() - charge.getTaxCollected();
									initpreDebitYbl(loan, "BC", predebitAmt, today, dueDate, index);
								}
							}
						}

						// FVC Charges Pre Debits
						if (unpaidFVC != null && unpaidFVC.size() > 0) {
							int fvcPreDebitMaxCount = Integer.parseInt(
									registryRepository.findByconfigKey("UPI_PREDBIT_FVCMAX").getConfigValue());
							List<ReceiptsYblUpi> fvcReceipts = receiptsYblUpiRepository
									.getSuccessPredebitsByRcptType(loan.getLoanNo(), dueDate, "FVC");
							int fvcPreDebitCount = fvcPreDebitMaxCount - fvcReceipts.size();
							if (fvcPreDebitCount > 0) {
								for (int index = 0; index < fvcPreDebitCount; index++) {
									Charges charge = unpaidFVC.get(index);
									float predebitAmt = charge.getChargeAmount() + charge.getTaxAmount()
											- charge.getChargeCollected() - charge.getTaxCollected();
									initpreDebitYbl(loan, "FVC", predebitAmt, today, dueDate, index);
								}
							}
						}

						// ODC Charges Pre debits
						int odcPreDebitMaxCount = Integer
								.parseInt(registryRepository.findByconfigKey("UPI_PREDBIT_ODCMAX").getConfigValue());
						List<ReceiptsYblUpi> odcReceipts = receiptsYblUpiRepository
								.getSuccessPredebitsByRcptType(loan.getLoanNo(), dueDate, "ODC");
						if (odcReceipts == null || odcReceipts.isEmpty()) {
							int chrgPreDebitCount = odcPreDebitMaxCount - odcReceipts.size();
							float odcTotalCharges = unpaidODC;
							for (int index = 0; index < chrgPreDebitCount; index++) {
								if (odcTotalCharges >= 10) {
									float odc = odcTotalCharges;
									if (odc > 20) {
										odc = 20;
									}
									initpreDebitYbl(loan, "ODC", odc, today, dueDate, index);
									odcTotalCharges = odcTotalCharges - odc;
								}
							}
						}
					}
				}

				log.info("[" + threadId + "] " + "Time taken for Loan : " + loan.getLoanNo() + " is : "
						+ (System.currentTimeMillis() - loanStartTime));
			} catch (Exception e) {
				log.error("Error occured in Ybl thread for date : " + loan.getId(), e);
			}
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'_'HH:mm:ss");
		String logStmnt = sdfDate.format(new Date()) + " [" + threadId + "] Start Index : " + startIndex
				+ " End Index : " + (startIndex + chunkSize) + " Predebit Status : " + "Done" + " Time Taken : "
				+ timeTaken;
		log.info("========= :: " + logStmnt);
	}

	private void initpreDebitYbl(Loan loan, String rcptType, float predebitAmt, LocalDate today, LocalDate dueDate,
			int index) {
		long startTimeInMillisPre = System.currentTimeMillis();
		log.info("Creating pre debit for Loan No => " + loan.getLoanNo() + ", rcptType : " + rcptType + ", Amount : "
				+ predebitAmt + ", Count : " + index);

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(upiMandateYblService.generatePSPRefNo());

		Recurrence recurrence = new Recurrence();
		DateFormat collectionDateFormat = new SimpleDateFormat("ddMMyyyy");
		recurrence.setNextRecurDate(collectionDateFormat
				.format(Date.from(dueDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
		recurrence.setSeqNo("1");

		Mandate mandate = new Mandate();
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setGroupingUsed(false);
		String predebitAmtDecimal = decimalFormat.format(predebitAmt);
		mandate.setAmount(predebitAmtDecimal);
		mandate.setRecurrence(recurrence);
		mandate.setActionType("MANDATE_NOTIFY");
		mandate.setOnBehalfOf("PAYEE");
		mandate.setUmn(loan.getUmrn());

		PreDebitYblRequest preDebitYblRequest = new PreDebitYblRequest();
		preDebitYblRequest.setRequestInfo(requestInfo);
		preDebitYblRequest.setMandate(mandate);

		ReceiptsYblUpi receipt = new ReceiptsYblUpi();
		receipt.setLoanId(loan.getId());
		receipt.setLoanNo(loan.getLoanNo());
		receipt.setCustId(loan.getLosCustId());
		receipt.setCpMdtRefNo(loan.getUpiUmrn());
		receipt.setEdi(predebitAmt);
		receipt.setPreDebitTime(new Date());
		receipt.setStatus("INIT");
		receipt.setBankName(loan.getUpiBankName());
		receiptsYblUpiRepository.save(receipt);
		PreDebitYblResponse preDebitYblResponse = null;
		try {
			log.info("Predebit request for Loan No => " + loan.getLoanNo() + ", Rcpt Type : " + rcptType + ", Count : "
					+ index + ", LOS Cust Id  : " + loan.getLosCustId() + ", Request : " + preDebitYblRequest);
			preDebitYblResponse = YblUtil.executeRequest(preDebitYblRequest, "/msupimer/upi/mandate/notifyMandate",
					PreDebitYblResponse.class);
			log.info("Create Predebit Ybl Response => " + loan.getLoanNo() + ", Response : " + preDebitYblResponse);
			receipt.setPreDebitDesc(preDebitYblResponse.getStatusDesc());
			receipt.setPreDebitStatus(preDebitYblResponse.getStatus());
			if (preDebitYblResponse.getMandateDtls() != null) {
				receipt.setSeqNo(preDebitYblResponse.getMandateDtls().get(0).getSeqNo());
			}
			receipt.setPredebitDate(Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			receipt.setDebitDate(Date.from(dueDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			receipt.setReceiptMode("ETP");
			receipt.setReceiptType(rcptType);
			if (preDebitYblResponse.getStatus() != null && preDebitYblResponse.getStatus().equalsIgnoreCase("S")) {
				receipt.setStatus("PREDEBIT_SUCCESS");
			} else {
				receipt.setStatus("PREDEBIT_FAILURE");
			}

			ObjectMapper objectMapper = new ObjectMapper();
			String responseYblString = objectMapper.writeValueAsString(preDebitYblResponse);
			receipt.setPredebitResponse(responseYblString);
			receiptsYblUpiRepository.save(receipt);
			log.info("Creating predebit for Loan No=>" + loan.getLoanNo() + ", Rcpt Type : " + rcptType + " : Success");

		} catch (Exception e) {
			log.info("Create PreDebit for Loan No => " + loan.getLoanNo() + ", Rcpt Type : " + rcptType + " : Failure");
			log.error("Error in creating predebit : ", e);
		}
		log.info("Time taken for predebit creation for loan no : " + loan.getLoanNo() + ", Rcpt Type : " + rcptType
				+ ", Count : " + index + " : " + (System.currentTimeMillis() - startTimeInMillisPre));
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
}
