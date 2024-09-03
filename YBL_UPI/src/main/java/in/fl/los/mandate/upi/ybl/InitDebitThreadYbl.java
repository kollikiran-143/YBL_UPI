package in.fl.los.mandate.upi.ybl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.fl.los.mandate.upimandate.ybl.ExecuteMandateYblRequest;
import in.fl.los.mandate.upimandate.ybl.ExecuteMandateYblResponse;
import in.fl.los.mandate.upimandate.ybl.Mandate;
import in.fl.los.mandate.upimandate.ybl.MandateDtl;
import in.fl.los.mandate.upimandate.ybl.RequestInfo;
import in.fl.los.mandate.upimandate.ybl.UPIMandateYblService;
import in.fl.los.model.Charges;
import in.fl.los.model.Loan;
import in.fl.los.model.ReceiptsYblUpi;
import in.fl.los.model.ReceiptsYblUpiLog;
import in.fl.los.model.Receivable;
import in.fl.los.model.Registry;
import in.fl.los.repository.ChargesRepository;
import in.fl.los.repository.LmsOdcDailyRepository;
import in.fl.los.repository.LoanRepository;
import in.fl.los.repository.ReceiptsYblUpiLogRepository;
import in.fl.los.repository.ReceiptsYblUpiRepository;
import in.fl.los.repository.ReceivableRepository;
import in.fl.los.repository.RegistryRepository;
import in.fl.los.util.CommonUtils;
import in.fl.los.ybl.util.YblUtil;

@Component
@Scope("prototype")
public class InitDebitThreadYbl extends Thread {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private ReceivableRepository receivableRepository;

	@Autowired
	private ReceiptsYblUpiRepository receiptsYblUpiRepository;

	@Autowired
	ReceiptsYblUpiLogRepository receiptsYblUpiLogRepository;

	@Autowired
	private ChargesRepository chargesRepository;

	@Autowired
	private RegistryRepository registryRepository;

	@Autowired
	private LmsOdcDailyRepository lmsOdcDailyRepository;

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	private int startIndex, chunkSize, threadId;

	private boolean delinquentRun;

	private final Logger log = Logger.getLogger(InitDebitThreadYbl.class);

	public void run() {
		CommonUtils.mdcPut("CustomerId", "DEBIT_" + threadId);
		while (true) {
			startIndex = InitDebitYblService.getNextStartId();
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
		long startTimeInMillis = System.currentTimeMillis();
		try {
			int endIndex = (startIndex + chunkSize);
			log.info("========= Starting Debit Thread : StartIndex : " + startIndex + " End Index : " + endIndex
					+ " Thread Id : " + threadId);
			List<Loan> activeLoans = null;
			if (!delinquentRun) {
				activeLoans = loanRepository.getLoanList(startIndex, endIndex);
			} else {
				log.info("Querying Delinquent Active loans for debit ");
				activeLoans = loanRepository.getDelinquentLoanList(startIndex, endIndex, 4);
			}
			LocalDate today = LocalDate.now();
			for (Loan loan : activeLoans) {
				long loanStartTime = System.currentTimeMillis();
				String debitResponse = "FAILURE";
				do {
					debitResponse = invokeDebitEDI(loan, today);
				} while (debitResponse.equals("DEBIT_SUCCESS"));
				log.info("[" + threadId + "] " + "Time taken for debit Loan : " + loan.getLoanNo() + " is : "
						+ (System.currentTimeMillis() - loanStartTime));

				// Invoke Debits For charges
				Registry registry = registryRepository.findByconfigKey("UPI_DEBIT_CHARGES");
				if (registry.getConfigValue().equals("true")) {
					debitResponse = "FAILURE";
					do {
						debitResponse = invokeDebitCharges(loan, today);
					} while (debitResponse.equals("DEBIT_SUCCESS"));
					log.info("[" + threadId + "] " + "Time taken for debit Loan Charges : " + loan.getLoanNo()
							+ " is : " + (System.currentTimeMillis() - loanStartTime));
				}
			}
		} catch (Exception e) {
			log.error("Error occured in thread for invoke debit ybl : ", e);
		}
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'_'HH:mm:ss");
		String logStmnt = sdfDate.format(new Date()) + " [" + threadId + "] Start Index : " + startIndex
				+ " End Index : " + (startIndex + chunkSize) + " Debit Query Status : " + "Done" + " Time Taken : "
				+ timeTaken;
		log.info("========= :: " + logStmnt);
	}

	private synchronized String invokeDebitEDI(Loan loan, LocalDate today) {
		log.info("Invoking debit for loan : EDI : " + loan.getLoanNo() + " for " + today);
		String response = "FAILURE";
		List<Receivable> dues = receivableRepository.getLoanDues(loan.getLoanNo(), today);
		int successfulDebits = 0;

		List<ReceiptsYblUpi> debitedReceiptsYbl = receiptsYblUpiRepository
				.getDebitSuccessReceiptsByRcptType(loan.getLoanNo(), today, "EDI");
		if (debitedReceiptsYbl != null) {
			successfulDebits = debitedReceiptsYbl.size();
			if (dues != null) {
				log.info("Loan due count : " + dues.size());
			}
			log.info("Successful debit receipt count : " + successfulDebits);
		}
		if (dues == null || dues.isEmpty() || successfulDebits >= dues.size()) {
			log.info("No Dues for Loan No => " + loan.getLoanNo() + " for : " + today + " Successful Debits : "
					+ successfulDebits);
			response = "NODUES";
		} else {
			response = initDebitYbl(loan, today, response, "EDI");
		}

		return response;
	}

	private String invokeDebitCharges(Loan loan, LocalDate today) {
		log.info("Invoking debit for loan : CHARGES : " + loan.getLoanNo() + " for " + today);
		String response = "FAILURE";

		List<Charges> unpaidBC = chargesRepository.getUnpaidChargesListByType(loan.getLoanNo(), "BC");
		List<Charges> unpaidFVC = chargesRepository.getUnpaidChargesListByType(loan.getLoanNo(), "FVC");
		float unpaidODC = lmsOdcDailyRepository.getTotalOdcAmt(loan.getLoanNo());

		if ((unpaidBC == null || unpaidBC.size() == 0) && (unpaidFVC == null || unpaidFVC.size() == 0)
				&& unpaidODC == 0) {
			log.info("No Charges Dues for Loan No => " + loan.getLoanNo() + " for : " + today);
			response = "NODUES";
		} else {
			// BC
			int successfulDebits = 0;
			if (unpaidBC != null && unpaidBC.size() > 0) {
				successfulDebits = 0;
				int bcMaxCount = Integer
						.parseInt(registryRepository.findByconfigKey("UPI_PREDBIT_BCMAX").getConfigValue());
				List<ReceiptsYblUpi> bcDebitedReceipts = receiptsYblUpiRepository
						.getDebitSuccessReceiptsByRcptType(loan.getLoanNo(), today, "BC");
				if (bcDebitedReceipts != null) {
					successfulDebits = bcDebitedReceipts.size();
				}
				if (successfulDebits < bcMaxCount) {
					response = initDebitYbl(loan, today, response, "BC");
				}
			}

			// FVC
			if (unpaidFVC != null && unpaidFVC.size() > 0) {
				successfulDebits = 0;
				int fvcMaxCount = Integer
						.parseInt(registryRepository.findByconfigKey("UPI_PREDBIT_FVCMAX").getConfigValue());
				List<ReceiptsYblUpi> fvcDebitedReceipts = receiptsYblUpiRepository
						.getDebitSuccessReceiptsByRcptType(loan.getLoanNo(), today, "FVC");
				if (fvcDebitedReceipts != null) {
					successfulDebits = fvcDebitedReceipts.size();
				}
				if (successfulDebits < fvcMaxCount) {
					response = initDebitYbl(loan, today, response, "FVC");
				}
			}

			// ODC
			if (unpaidODC > 0) {
				successfulDebits = 0;
				int odcMaxCount = Integer
						.parseInt(registryRepository.findByconfigKey("UPI_PREDBIT_ODCMAX").getConfigValue());
				List<ReceiptsYblUpi> odcDebitedReceipts = receiptsYblUpiRepository
						.getDebitSuccessReceiptsByRcptType(loan.getLoanNo(), today, "ODC");
				if (odcDebitedReceipts != null) {
					successfulDebits = odcDebitedReceipts.size();
				}
				if (successfulDebits < odcMaxCount) {
					response = initDebitYbl(loan, today, response, "ODC");
				}
			}
		}
		return response;
	}

	private String initDebitYbl(Loan loan, LocalDate today, String response, String rcptType) {
		ReceiptsYblUpi receipt = receiptsYblUpiRepository.getPredebitReceiptByRcptType(loan.getLoanNo(), today,
				rcptType);
		if (receipt != null && !receipt.getStatus().equalsIgnoreCase("DEBIT_SUCCESS")) {
			try {
				long executionStartMillis = System.currentTimeMillis();
				log.info("RCPT : " + receipt.getId() + " Loan No : " + loan.getLoanNo() + " Mandate : "
						+ receipt.getCpMdtRefNo() + ", Rcpt Type : " + rcptType);

				ExecuteMandateYblRequest debitYblRequest = new ExecuteMandateYblRequest();
				DecimalFormat decimalFormat = new DecimalFormat();
				decimalFormat.setMinimumFractionDigits(2);
				decimalFormat.setMaximumFractionDigits(2);
				decimalFormat.setGroupingUsed(false);
				ExecuteMandateYblResponse debitYblResponse = null;

				if (loan.isUpiDebit()) {
					RequestInfo requestInfo = new RequestInfo();
					requestInfo.setPgMerchantId(YblUtil.merchId);
					requestInfo.setPspRefNo(upiMandateYblService.generatePSPRefNo());

					Mandate mandate = new Mandate();
					String ediDecimal = decimalFormat.format(receipt.getEdi());
					mandate.setAmount(ediDecimal);
					mandate.setActionType("RECUR_PAY");
					mandate.setOnBehalfOf("PAYEE");
					mandate.setUmn(receipt.getUmn());
					mandate.setRecurringSeqNo(Integer.parseInt(receipt.getSeqNo()));

					debitYblRequest.setRequestInfo(requestInfo);
					debitYblRequest.setMandate(mandate);
					log.info(debitYblRequest);

					try {
						log.info("Executing debit Loan No : " + loan.getLoanNo() + "  Request => " + debitYblRequest);
						debitYblResponse = YblUtil.executeRequest(debitYblRequest,
								"/msupimer/upi/mandate/recurrPayment", ExecuteMandateYblResponse.class);
					} catch (Exception e) {
						log.error("Error in executing debit", e);
					}
					log.info("Execute debit Response : " + debitYblResponse);

					MandateDtl debitYblResponseMandateDtl = null;
					if (debitYblResponse.getMandateDtls() != null) {
						debitYblResponseMandateDtl = debitYblResponse.getMandateDtls().get(0);
					}
					if (debitYblResponseMandateDtl != null) {
						receipt.setExecTrxnNo(debitYblResponseMandateDtl.getTxnId());
						receipt.setExecutionRefNo(debitYblResponseMandateDtl.getReferenceNumber());
					}
					receipt.setMndtExecDesc(debitYblResponse.getStatusDesc());
					receipt.setMndtExecStatus(debitYblResponse.getStatus());
					// TODO ask about BankResDesc and BankErrorCode
					if (debitYblResponse.getStatus().equalsIgnoreCase("S")) {
						receipt.setStatus("DEBIT_SUCCESS");
						response = "DEBIT_SUCCESS";
					} else {
						receipt.setStatus("DEBIT_INIT_SUCCESS");
						response = "DEBIT_INIT_SUCCESS";
					}

					ObjectMapper objectMapper = new ObjectMapper();
					String responseString = objectMapper.writeValueAsString(debitYblResponse);
					receipt.setDebitResponse(responseString);
					receipt.setMndtExecTime(receipt.getMndtExecStarttime());
					if (debitYblResponseMandateDtl != null) {
						receipt.setBankRrn(debitYblResponseMandateDtl.getCustRefNo().toString());
					}
					receipt.setDebitTryCount(receipt.getDebitTryCount() + 1);
					receipt.setMndtExecTimetaken(System.currentTimeMillis() - executionStartMillis);
					receipt.setMndtExecEndtime(new Date());

				} else {
					log.info("Debits disabled for loan No :" + loan.getLoanNo());
					receipt.setStatus("DEBIT_DISABLE");
				}
				receipt = receiptsYblUpiRepository.save(receipt);

				try {
					saveDebitYblLog(receipt, response, debitYblResponse);
				} catch (Exception e) {
					log.info("Exception while YBL UPI Log Save Option : InitDebitThread : ", e);
				}
			} catch (Exception ex) {
				log.error("Exception occured while executing debits =>", ex);
			}
		} else {
			log.info("All debits handled for loan no :" + loan.getLoanNo());
			response = "NODUES";
		}
		return response;
	}

	private void saveDebitYblLog(ReceiptsYblUpi receipt, String response, ExecuteMandateYblResponse debitYblResponse) {
		ObjectMapper objectMapper = new ObjectMapper();

		ReceiptsYblUpiLog upiReceiptLogYbl = new ReceiptsYblUpiLog();
		// PreDebit Result
		upiReceiptLogYbl.setCamsUpiId(receipt.getId());
		upiReceiptLogYbl.setLoanNo(receipt.getLoanNo());
		upiReceiptLogYbl.setLoanId(receipt.getLoanId());
		upiReceiptLogYbl.setEdi(receipt.getEdi());
		upiReceiptLogYbl.setCustId(receipt.getCustId());
		upiReceiptLogYbl.setCpMdtRefNo(receipt.getCpMdtRefNo());
		upiReceiptLogYbl.setPredebitDate(receipt.getPredebitDate());
		upiReceiptLogYbl.setDebitDate(receipt.getDebitDate());
		upiReceiptLogYbl.setSeqNo(receipt.getSeqNo());
		upiReceiptLogYbl.setPreDebitDesc(receipt.getPreDebitDesc());
		upiReceiptLogYbl.setPreDebitStatus(receipt.getPreDebitStatus());
		upiReceiptLogYbl.setPredebitResponse(receipt.getPredebitResponse());
		upiReceiptLogYbl.setReceiptType(receipt.getReceiptType());
		upiReceiptLogYbl.setExecTrxnNo(receipt.getExecTrxnNo());

		// Mandate Execution Response
		if (debitYblResponse != null) {
			upiReceiptLogYbl.setMndtExecDesc(debitYblResponse.getStatusDesc());
			upiReceiptLogYbl.setMndtExecStatus(debitYblResponse.getStatus());
			MandateDtl mandateDtlYbl = debitYblResponse.getMandateDtls().get(0);
			if (mandateDtlYbl != null) {
				upiReceiptLogYbl.setExecutionRefNo(mandateDtlYbl.getReferenceNumber());
				upiReceiptLogYbl.setBankRrn(mandateDtlYbl.getCustRefNo().toString());
			}
			// TODO ask about BankResDesc and BankErrorCode
			String responseString = null;
			try {
				responseString = objectMapper.writeValueAsString(debitYblResponse);
			} catch (JsonProcessingException e) {
				log.error("Error occured while converting object into a string", e);
			}
			upiReceiptLogYbl.setDebitResponse(responseString);
			upiReceiptLogYbl.setMndtExecTime(new Date());
			upiReceiptLogYbl.setStatus(response);
			upiReceiptLogYbl.setSource("DEBIT_EXEC");
		}

		upiReceiptLogYbl = receiptsYblUpiLogRepository.save(upiReceiptLogYbl);

		receipt.setReceiptLogId(upiReceiptLogYbl.getId());
		receiptsYblUpiRepository.save(receipt);
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

	public boolean isDelinquentRun() {
		return delinquentRun;
	}

	public void setDelinquentRun(boolean delinquentRun) {
		this.delinquentRun = delinquentRun;
	}
}
