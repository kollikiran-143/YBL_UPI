package in.fl.los.mandate.upimandate.ybl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.fl.los.model.Loan;
import in.fl.los.model.MandateApiAuditYblUpi;
import in.fl.los.model.ReceiptsYblUpi;
import in.fl.los.model.ReceiptsYblUpiLog;
import in.fl.los.model.Receivable;
import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlCustomerStateStatus;
import in.fl.los.model.UlLoans;
import in.fl.los.repository.APIMandateYblUpiRepository;
import in.fl.los.repository.CustomerRepository;
import in.fl.los.repository.LmsLoanRepository;
import in.fl.los.repository.LoanRepository;
import in.fl.los.repository.LosLoanRepository;
import in.fl.los.repository.ReceiptsYblUpiLogRepository;
import in.fl.los.repository.ReceiptsYblUpiRepository;
import in.fl.los.repository.ReceivableRepository;
import in.fl.los.request.BaseRequestDTO;
import in.fl.los.request.CreateUpiMandateYblRequestDTO;
import in.fl.los.request.RevokeMandateRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.CreateUpiMandateYblResponseDTO;
import in.fl.los.response.UpiMandateStatusResponseDTO;
import in.fl.los.service.FileUploadService;
import in.fl.los.util.CommonUtils;
import in.fl.los.util.WebConstants;
import in.fl.los.ybl.util.RequestYblDTO;
import in.fl.los.ybl.util.YblUtil;

@Service
public class UPIMandateYblServiceImpl implements UPIMandateYblService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private LosLoanRepository losLoanRepository;

	@Autowired
	private APIMandateYblUpiRepository upiMandateYblRepository;

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private ReceiptsYblUpiRepository receiptsYblUpiRepository;

	@Autowired
	private ReceiptsYblUpiLogRepository receiptsYblUpiLogRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private ReceivableRepository receivableRepository;

	@Autowired
	private LmsLoanRepository lmsLoanRepository;

	@Value("${spring.profiles.active}")
	private String activeProfile;

	private final Logger log = Logger.getLogger(UPIMandateYblServiceImpl.class);

	@Override
	public ValidateVpaYblResponse validateVPA(String vpa) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl validateVPA UPLIFT : " + vpa);

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(generatePSPRefNo());
//		requestInfo.setTxnDate("");

		PayeeType payeeType = new PayeeType();
		payeeType.setVirtualAddress(vpa);

		ValidateVpaYblRequest request = new ValidateVpaYblRequest();
		request.setRequestInfo(requestInfo);
		request.setPayeeType(payeeType);

		log.info("UPIMandateYblServiceImpl validateVPA Request :" + request);
		ValidateVpaYblResponse response = new ValidateVpaYblResponse();
		try {
			response = YblUtil.executeCheckVpaRequest(request, "/chkvpa", ValidateVpaYblResponse.class);
		} catch (Exception e) {
			log.error("Error in executeRequest of YblUtil" + e);
		}
		log.info("UPIMandateYblServiceImpl validateVPA Response UPLIFT : " + response);
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for validateVPA UPLIFT is ==>" + timeTaken);
		return response;
	}

	@Override
	public String generatePSPRefNo() {

		Random random = new Random();
		int length = 10 + random.nextInt(26);
		StringBuilder refNo = new StringBuilder(length);
		String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		for (int i = 0; i < length; i++)
			refNo.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));

		return refNo.toString();
	}

	@Override
	public CreateUpiMandateYblResponseDTO createUpiMandate(
			CreateUpiMandateYblRequestDTO createUpiMandateYblRequestDTO) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl createUpiMandate UPLIFT :" + createUpiMandateYblRequestDTO);

		CreateUpiMandateYblResponseDTO response = new CreateUpiMandateYblResponseDTO();
		response.setRandom(createUpiMandateYblRequestDTO.getRandom());

		UlCustomerDetails customerDetails = customerRepository
				.findById(Integer.parseInt(createUpiMandateYblRequestDTO.getCustomerId())).get();

		Set<UlLoans> loans = null;
		if (customerDetails.getApplicantType().equalsIgnoreCase("APP")) {
			loans = customerDetails.getLoans();
		} else {// Co Applicant
			int applicantId = customerDetails.getCoapplicantOf();
			loans = losLoanRepository.getAllLoan(applicantId);
		}

		UlLoans appliedLoan = loans.stream()
				.filter(loan -> "APPLIED".equals(loan.getLoanStatus()) || "ACTIVE".equals(loan.getLoanStatus()))
				.findFirst().get();

		BaseResponseDTO validateSessionResponse = validateSession(customerDetails, appliedLoan);
		if (validateSessionResponse.getStatusCode().trim().equalsIgnoreCase(WebConstants.SUCCESS_CODE)) {
			String payer_name = customerDetails.getVpaPayerName();
			String vpa = customerDetails.getVpa();
			if (payer_name != null && !payer_name.trim().equals("") && vpa != null && !vpa.trim().equals("")) {

				float mandateAmount = appliedLoan.getAmount();
				if (appliedLoan.getTenure() == 1) {
					mandateAmount = appliedLoan.getEmi();
				}
				log.info("actual mandate amount:" + mandateAmount);
				mandateAmount = Math.min(mandateAmount, 12000f);
				if (customerDetails.getCustId() == 100000053 || customerDetails.getCustId() == 100000025
						|| customerDetails.getCustId() == 100000136 || customerDetails.getCustId() == 100000170
						|| customerDetails.getCustId() == 100000092 || customerDetails.getCustId() == 100000174
						|| customerDetails.getCustId() == 100000193 || customerDetails.getCustId() == 100000165
						|| customerDetails.getCustId() == 100000108 || customerDetails.getCustId() == 100000299
						|| customerDetails.getCustId() == 100000224 || customerDetails.getCustId() == 100000304
						|| customerDetails.getCustId() == 100000628 || customerDetails.getCustId() == 100000630) {// 12k
																													// Failed
																													// for
																													// this
																													// customer.
					mandateAmount = 5000f;
					log.info("createUpiMandate Customer  Revised mandate amount:" + mandateAmount);
				}

				if (mandateAmount > 12000f) {
					mandateAmount = 12000f;
				}
				mandateAmount = Math.min(appliedLoan.getEdi() * 10, 10000f);
				mandateAmount = Math.max(mandateAmount, appliedLoan.getEdi());

				appliedLoan.setUpiMandateAmount(mandateAmount);
				if (createUpiMandateYblRequestDTO.getScheduleTime() == null
						|| createUpiMandateYblRequestDTO.getScheduleTime().contains("Select")) {
					appliedLoan.setUpidebitSheduledTime(18);
				} else {
					SimpleDateFormat displayFormat = new SimpleDateFormat("HH");
					SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
					Date date = null;
					try {
						date = parseFormat.parse(createUpiMandateYblRequestDTO.getScheduleTime());
					} catch (ParseException e1) {
						log.error("Debit schedule time format exception :" + e1);
					}
					int debitTime = Integer.parseInt(displayFormat.format(date));
					appliedLoan.setUpidebitSheduledTime(debitTime);
				}

				losLoanRepository.save(appliedLoan);

				CreateMandateYblRequest mandateYblRequest = createMandateYblRequest(vpa, payer_name, mandateAmount);
				MandateApiAuditYblUpi audit = saveMandateYblReqAudit(mandateYblRequest, customerDetails.getCustId(),
						appliedLoan.getLoanId());
				try {
					CreateMandateYblResponse resp = YblUtil.executeRequest(mandateYblRequest,
							"/msupimer/upi/mandate/createMandate", CreateMandateYblResponse.class);
					saveMandateYblRespAudit(resp, audit);
					if (resp != null && resp.getErrCode() != null && resp.getErrCode().equalsIgnoreCase("MD200")
							&& audit.getStatus().toUpperCase().equals("PENDING")) {
						response.setStatusCode(WebConstants.SUCCESS_CODE);
						response.setStatusMessage(resp.getStatusDesc());
						if (resp.getRequestInfo().getPspRefNo() != null) {
							response.setPspRefNo(resp.getRequestInfo().getPspRefNo());
						}
					} else {
						response.setStatusCode(WebConstants.FAILURE_CODE);
						if (resp == null) {
							response.setStatusMessage(WebConstants.FAILURE_MSG);
						} else if (resp.getStatusDesc() != null) {
							response.setStatusMessage(resp.getStatusDesc());
						}
					}
				} catch (Exception e) {
					log.error("Error in creating Mandate YBL :", e);
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage(e.getMessage());
				}

			} else {
				response.setStatusCode(WebConstants.FAILURE_CODE);
				response.setStatusMessage("VPA Details are missing");
			}
		} else {
			response.setStatusCode(validateSessionResponse.getStatusCode());
			response.setStatusMessage(validateSessionResponse.getStatusMessage());
		}
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for createUpiMandate UPLIFT is ==>" + timeTaken);
		log.info("UPIMandateYblServiceImpl createUpiMandate response UPLIFT: " + response);

		return response;
	}

	public BaseResponseDTO validateSession(UlCustomerDetails customerDetails, UlLoans appliedLoan) {
		long startTimeInMillis = System.currentTimeMillis();
		int custId = customerDetails.getCustId(), loanId = appliedLoan.getLoanId();
		log.info("Entering  UPIMandateYblServiceImpl - validateSession CustId: " + custId + " LoanId:" + loanId);
		BaseResponseDTO response = new BaseResponseDTO();
		List<MandateApiAuditYblUpi> mandateList = upiMandateYblRepository.findBycustIdAndLoanIdOrderByIdDesc(custId,
				loanId);
		if (mandateList != null && !mandateList.isEmpty()) {
			MandateApiAuditYblUpi successMandate = mandateList.stream()
					.filter(mandate -> "ACTIVE".equals(mandate.getStatus())).findFirst().orElse(null);
			if (successMandate != null && successMandate.getStatus().trim().equalsIgnoreCase("ACTIVE")) {
				response.setStatusCode("6");
				response.setStatusMessage("You already have a signed mandate.");
			} else {
				response.setStatusCode(WebConstants.SUCCESS_CODE);
				response.setStatusMessage(WebConstants.SUCCESS_MSG);
				response.setRandom("12345678");
			}
		} else { // no earlier sessions
			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
		}
		log.info("UPIMandateYblServiceImpl - validateSession Response:" + response + " Time Taken : "
				+ (System.currentTimeMillis() - startTimeInMillis));
		return response;
	}

	private CreateMandateYblRequest createMandateYblRequest(String vpa, String payerName, float mandateAmount) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl-createMandateYblRequest :vpa:" + vpa + " payer_name:" + payerName
				+ " mandateAmount:" + mandateAmount);

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(generatePSPRefNo());

		PayerType payerType = new PayerType();
		payerType.setName(payerName);
		payerType.setVirtualAddress(vpa);
		payerType.setAccountNo("");

		Recurrence recurrence = new Recurrence();
		DateFormat collectionDateFormat = new SimpleDateFormat("ddMMyyyy");
		Calendar calendar = new GregorianCalendar();
		Date mandateStartDate = calendar.getTime();
		recurrence.setStartDate(collectionDateFormat.format(mandateStartDate));
		calendar.add(Calendar.MONTH, 4); // added 4 months to current date
		Date mandateEndDate = calendar.getTime();
		recurrence.setEndDate(collectionDateFormat.format(mandateEndDate));
		recurrence.setPattern("DAILY");
		recurrence.setSeqNo("0");

		Mandate mandate = new Mandate();
		mandate.setTxnId(generatePSPRefNo());
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setGroupingUsed(false);
		String mandateDecimal = decimalFormat.format(mandateAmount); // needs exactly 2 decimal digits. 5000.0 not ok.
		mandate.setAmount(mandateDecimal);
		mandate.setAmtRule("MAX");
		mandate.setRecurrence(recurrence);
		mandate.setName("CREATE Mandate");
		mandate.setRevokeable("Y");
		mandate.setActionType("CREATE");
		mandate.setOnBehalfOf("PAYEE");
		mandate.setExpiryTime("100"); // TODO how much it should be?
		mandate.setBlockFund("N");
		mandate.setPurposeCode("14");
		mandate.setAccountValidation("N");
		mandate.setRevokeFlag("Y");

		CreateMandateYblRequest mandateYblRequest = new CreateMandateYblRequest();
		mandateYblRequest.setRequestInfo(requestInfo);
		mandateYblRequest.setMandate(mandate);
		mandateYblRequest.setPayerType(payerType);

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time taken for createMandateYblRequest is ==>" + timeTaken);
		log.info("UPIMandateYblServiceImpl createMandateYblRequest response " + mandateYblRequest);
		return mandateYblRequest;
	}

	private MandateApiAuditYblUpi saveMandateYblReqAudit(CreateMandateYblRequest mandateYblRequest, int custId,
			int loanId) {
		log.info("Entering UPIMandateYblServiceImpl - saveMandateYblReqAudit: " + mandateYblRequest);
		MandateApiAuditYblUpi mandateYblAudit = new MandateApiAuditYblUpi();
		try {
			mandateYblAudit.setLoanId(loanId);
			mandateYblAudit.setCustId(custId);
			mandateYblAudit.setPspRefNo(mandateYblRequest.getRequestInfo().getPspRefNo());
			mandateYblAudit.setTrxnNo(mandateYblRequest.getMandate().getTxnId());
			mandateYblAudit.setAmount(Float.parseFloat(mandateYblRequest.getMandate().getAmount()));
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			Date startDate = dateFormat.parse(mandateYblRequest.getMandate().getRecurrence().getStartDate());
			mandateYblAudit.setMandateStartDate(startDate);
			mandateYblAudit.setPayerName(mandateYblRequest.getPayerType().getName());
			mandateYblAudit.setPayerVpa(mandateYblRequest.getPayerType().getVirtualAddress());
		} catch (Exception e) {
			log.error("UPIMandateYblServiceImpl saveMandateYblReqAudit exception :", e);
		}
		log.info("Exiting UPIMandateYblServiceImpl saveMandateYblReqAudit mandateYblAudit :" + mandateYblAudit);
		return upiMandateYblRepository.save(mandateYblAudit);
	}

	private void saveMandateYblRespAudit(CreateMandateYblResponse resp, MandateApiAuditYblUpi mandateYblAudit) {
		log.info("Entering UPIMandateYblServiceImpl - saveMandateYblRespAudit: " + resp);
		if (resp != null && resp.getStatus().equalsIgnoreCase("S") && resp.getMandateDtls() != null) {
			if (resp.getStatusDesc() != null) {
				mandateYblAudit.setStatusDesc(resp.getStatusDesc());
				mandateYblAudit.setErrorDesc(resp.getStatusDesc());
			}
			List<MandateDtl> listOfMandateDtls = resp.getMandateDtls();
			for (MandateDtl eachDtl : listOfMandateDtls) {
				if (eachDtl.getCustRefNo() != null)
					mandateYblAudit.setRrnNo(eachDtl.getCustRefNo().toString());
				if (eachDtl.getTxnId() != null)
					mandateYblAudit.setTrxnNo(eachDtl.getTxnId());
				if (eachDtl.getAmount() != null)
					mandateYblAudit.setAmount(Double.parseDouble(eachDtl.getAmount()));
				if (eachDtl.getStatus() != null)
					mandateYblAudit.setStatus(eachDtl.getStatus());
				if (eachDtl.getCreditIfsc() != null)
					mandateYblAudit.setIfsc(eachDtl.getCreditIfsc());
				if (eachDtl.getCrediAccount() != null)
					mandateYblAudit.setAccountNo(eachDtl.getCrediAccount().toString());
				if (eachDtl.getMndregrefno() != null)
					mandateYblAudit.setCpMdtRefNo(eachDtl.getMndregrefno().toString());
				if (eachDtl.getErrCode() != null)
					mandateYblAudit.setErrorCode(eachDtl.getErrCode());
				if (eachDtl.getMessage() != null)
					mandateYblAudit.setMsg(eachDtl.getMessage());

				upiMandateYblRepository.save(mandateYblAudit);
			}
		}

	}

	@Scheduled(fixedDelay = 60 * 1000) // Every 15 seconds
	public void mandateStatusThread() {
		if (activeProfile.equalsIgnoreCase("uat")) {
			MDC.put("CustomerId", "-1248");

			long startTimeInMillis = System.currentTimeMillis();
			log.info("Entering  UPIMandateYblServiceImpl - mandateStatusYblThread : " + activeProfile);
			try {
				List<MandateApiAuditYblUpi> allPendingMandateDetailsList = upiMandateYblRepository
						.getPendingMandateDetails();
				for (MandateApiAuditYblUpi eachPendingMandate : allPendingMandateDetailsList) {

					RequestInfo requestInfo = new RequestInfo();
					requestInfo.setPgMerchantId(YblUtil.merchId);
					requestInfo.setPspRefNo(generatePSPRefNo());

					Mandate mandate = new Mandate();
					mandate.setOnBehalfOf("PAYEE");
					mandate.setActionType("MANDATE_STATUS");
					mandate.setOrgPspRefNo(eachPendingMandate.getPspRefNo());
					if (eachPendingMandate.getUmrn() != null) {
						mandate.setUmn(eachPendingMandate.getUmrn());
					}
					MandateStatusYblRequest mandateStatusRequest = new MandateStatusYblRequest();
					mandateStatusRequest.setRequestInfo(requestInfo);
					mandateStatusRequest.setMandate(mandate);

					try {
						MandateStatusYblResponse mandateStatusResp = YblUtil.executeRequest(mandateStatusRequest,
								"/msupimer/upi/mandate/mandateStatus", MandateStatusYblResponse.class);

						if (mandateStatusResp != null && mandateStatusResp.getStatus().equalsIgnoreCase("S")
								&& mandateStatusResp.getMandateDtls() != null) {
							List<MandateDtl> listOfMandateDtls = mandateStatusResp.getMandateDtls();
							for (MandateDtl eachDtl : listOfMandateDtls) {
								if (eachDtl.getStatus() != null)
									eachPendingMandate.setStatus(eachDtl.getStatus());
								if (eachDtl.getUmn() != null)
									eachPendingMandate.setUmrn(eachDtl.getUmn());

								upiMandateYblRepository.save(eachPendingMandate);
							}
						}
					} catch (Exception e1) {
						log.error("Error in External Check Mandate Status:", e1);
					}
				}
			} catch (Exception e) {
				log.error("Error in fetching the Pending Mandate Details from MandateAuditUpiYbl Table: ", e);
			}
			long timeTaken = System.currentTimeMillis() - startTimeInMillis;
			log.info("Time taken for mandateStatusYblThread is ==>" + timeTaken);

			MDC.remove("CustomerId");
		}

	}

	@Override
	public UpiMandateStatusResponseDTO getUpiMandateStatus(BaseRequestDTO baseRequestDTO) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl getUpiMandateStatus :" + baseRequestDTO);

		String upiMandateStatus = "";
		int custId = Integer.parseInt(baseRequestDTO.getCustomerId());
		UlCustomerDetails customerDetails = customerRepository.findById(custId).get();

		Set<UlLoans> loans = null;
		if (customerDetails.getApplicantType().equalsIgnoreCase("APP")) {
			loans = customerDetails.getLoans();
		} else {// Co Applicant
			int applicantId = customerDetails.getCoapplicantOf();
			loans = losLoanRepository.getAllLoan(applicantId);
		}

		UlLoans appliedLoan = loans.stream()
				.filter(loan -> "APPLIED".equals(loan.getLoanStatus()) || "ACTIVE".equals(loan.getLoanStatus()))
				.findFirst().get();

		int loanId = appliedLoan.getLoanId();

		UpiMandateStatusResponseDTO response = new UpiMandateStatusResponseDTO();
		List<MandateApiAuditYblUpi> mandateList = upiMandateYblRepository.findBycustIdAndLoanIdOrderByIdDesc(custId,
				loanId);
		MandateApiAuditYblUpi successsMandate = mandateList.stream()
				.filter(mandate -> "ACTIVE".equals(mandate.getStatus())).findFirst().orElse(null);
		if (successsMandate != null && successsMandate.getStatus().trim().equalsIgnoreCase("ACTIVE")) {
			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
			response.setMandateStatus(successsMandate.getStatus());
			upiMandateStatus = "UPI_SUCCESS";
		} else if (mandateList.size() > 0) {
			response.setMandateStatus(mandateList.get(0).getStatus());
			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
			upiMandateStatus = "UPI_SUCCESS";
		} else {
			upiMandateStatus = "UPI_FAILURE";
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage("No mandates exist for this cust_id = " + custId + " loan_id = " + loanId);
		}
		customerDetails.setLeadStatus(upiMandateStatus);
		customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, upiMandateStatus));
		customerRepository.save(customerDetails);
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for getUpiMandateStatus is ==>" + timeTaken);
		log.info("Exiting UPIMandateYblServiceImpl getUpiMandateStatus response :" + response);
		return response;
	}

	@Override
	public BaseResponseDTO revokeMandate(RevokeMandateRequestDTO request) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl revokeMandate :" + request);

		int custId = Integer.parseInt(request.getCustomerId());
		BaseResponseDTO response = new BaseResponseDTO();
		MandateApiAuditYblUpi upiMandate = upiMandateYblRepository.getUpiMandateDetails(custId, request.getUpiUmrnNo());

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(generatePSPRefNo());

		Mandate mandate = new Mandate();
		mandate.setActionType("REVOKE");
		mandate.setOnBehalfOf("PAYEE");
		mandate.setExpiryTime("100");
		mandate.setUmn(request.getUpiUmrnNo());

		RevokeMandateYblRequest revokeMandateRequest = new RevokeMandateYblRequest();
		revokeMandateRequest.setRequestInfo(requestInfo);
		revokeMandateRequest.setMandate(mandate);

		RevokeMandateYblResponse revokeMandateResponse = null;

		if (upiMandate != null && !upiMandate.equals("")) {
			try {
				revokeMandateResponse = YblUtil.executeRequest(revokeMandateRequest,
						"/msupimer/upi/mandate/mandateRevoke", RevokeMandateYblResponse.class);
			} catch (Exception e) {
				log.error("error in executing revokeMandate : " + request.getUpiUmrnNo(), e);
			}

			if (revokeMandateResponse != null && !revokeMandateResponse.equals("")) {
				if (revokeMandateResponse.getStatus() != null && !revokeMandateResponse.getStatus().equals("")
						&& revokeMandateResponse.getStatus().equalsIgnoreCase("S")) {
					if (revokeMandateResponse.getMandateDtls() != null
							&& revokeMandateResponse.getMandateDtls().get(0).getStatus().equalsIgnoreCase("REVOKED")) {
						response.setStatusCode(WebConstants.SUCCESS_CODE);
						response.setStatusMessage(WebConstants.SUCCESS_MSG);
						upiMandate.setRevokeTime(new Date());
						upiMandate.setStatus("ACTIVE_REVOKE");
						upiMandateYblRepository.save(upiMandate);
					} else {
						response.setStatusCode(WebConstants.FAILURE_CODE);
						response.setStatusMessage(revokeMandateResponse.getStatusDesc());
					}
				} else {
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage(revokeMandateResponse.getStatusDesc());
				}
			} else {
				response.setStatusCode(WebConstants.FAILURE_CODE);
				response.setStatusMessage(WebConstants.FAILURE_MSG);
			}
		} else {
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage("Invalid Details");
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for revokeMandate is ==>" + timeTaken);
		log.info("Exiting UPIMandateYblServiceImpl revokeMandate response :" + response);
		return response;
	}

	@Scheduled(fixedDelay = 30 * 60 * 1000) // once in 30 mins
	public void checkDebitStatusThread() {
		log.info("Entering  UPIMandateYblServiceImpl - checkDebitStatusThread : " + activeProfile);
		if (activeProfile.equalsIgnoreCase("uat")) {
			List<ReceiptsYblUpi> receiptYblList = receiptsYblUpiRepository.getDebitUnknownCases();
			if (receiptYblList != null && !receiptYblList.isEmpty()) {
				log.info("CheckDebitStatus for status unknown receipts " + receiptYblList);
				for (int index = 0; index < receiptYblList.size(); index++) {
					ReceiptsYblUpi receipt = receiptYblList.get(index);
					log.info("Check Debit Status for Receipt :" + index + "," + receipt);
					checkDebitExecutionStatusYbl(receipt);
				}
			}
		}
	}

	@Override
	public String processCallBackYbl(RequestYblDTO requestYblDTO) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl - processCallBackYbl :" + requestYblDTO);
		try {
			String payload = requestYblDTO.getPayload();
			String callBackStr = YblUtil.decrypt(payload);
			CallBackYblRequest callBackDTO = YblUtil.Extract(callBackStr, CallBackYblRequest.class);
			log.info("decrypted callBack :" + callBackDTO);
			List<MandateDtl> listOfMandateDtls = callBackDTO.getMandateDtls();
			for (MandateDtl callBackMndtDtl : listOfMandateDtls) {
				if (callBackMndtDtl.getCallbackType().toUpperCase().equals("MANDATE_STATUS")) {
					MandateApiAuditYblUpi audit = upiMandateYblRepository
							.findByRrnNo(callBackMndtDtl.getCustRefNo().toString());
					if (audit != null) {
						if (!audit.getStatus().equals(callBackMndtDtl.getStatus())) {
							String encPlusDecPayload = payload + "\n" + callBackStr;
							fileUploadService.saveFileToDiskWithUnderScore(encPlusDecPayload.getBytes(),
									"UPIMandateCreatePayload", audit.getCustId() + "", "txt");
						}
						audit.setStatus(callBackMndtDtl.getStatus());
						audit.setStatusDesc(callBackMndtDtl.getStatusDesc());
						audit.setUmrn(callBackMndtDtl.getUmn());
						// TODO approvedAccNo
						audit.setAccountNo(callBackMndtDtl.getCrediAccount().toString());
						audit.setIfsc(callBackMndtDtl.getCreditIfsc());
						audit.setAccHolderName(callBackMndtDtl.getName());
						audit.setCallback(callBackStr);
						audit = upiMandateYblRepository.save(audit);
						if (callBackMndtDtl.getStatus().equalsIgnoreCase("ACTIVE")) {
							UlCustomerDetails customerDetails = customerRepository.findById(audit.getCustId()).get();
							UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
							customerStateStatus.setUpiMandateStatus(true);
							customerDetails.setCustomerStateStatus(customerStateStatus);
							customerRepository.save(customerDetails);

							// Update upi umrn in an lms_loan table
							Set<UlLoans> loans = customerDetails.getLoans();

							UlLoans appliedLoan = loans.stream().filter(loan -> "APPLIED".equals(loan.getLoanStatus())
									|| "ACTIVE".equals(loan.getLoanStatus())).findFirst().get();

							if (appliedLoan != null && appliedLoan.getLoanId() > 0) {
								int loanId = appliedLoan.getLoanId();
								Loan loan = lmsLoanRepository.findBylosId(loanId);
								if (loan != null) {
									log.info(
											"UPIMandateYblServiceImpl-processCallback payload: LMS LOAN UPI UMRN UPDATION : LOAN NO : "
													+ loan.getLoanNo() + "," + audit.getCpMdtRefNo());
									loan.setUpiUmrn(audit.getCpMdtRefNo());
									loan.setUpiBankName(audit.getBankName());
									loan.setUpiMandateId(audit.getId());
									loan.setUpiMandateAmount((float) audit.getAmount());
									loan.setUpiBankAccountNo(audit.getAccountNo());
									try {
										Date upiMandateExpiryDate = null;
										Calendar calendar = new GregorianCalendar();
										DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
										SimpleDateFormat requiredFormat = new SimpleDateFormat("yyyy-MM-dd");
										String mandateDate = audit.getCreateTime().toInstant()
												.atZone(ZoneId.systemDefault()).toLocalDateTime().format(dtFormat);
										Date mandateDt = requiredFormat.parse(mandateDate);
										calendar.setTime(mandateDt);
										calendar.add(Calendar.YEAR, 10);// 10 Years from Now
										upiMandateExpiryDate = calendar.getTime();
										loan.setUpiMandateExpiryDate(upiMandateExpiryDate);
									} catch (Exception e) {
										log.error("Error parsing the Mandate Expiry Date:", e);
									}
									lmsLoanRepository.save(loan);
								}
							}
							// Check UPI Registered Bank Acc is Validated by peenydrop or not
						}
					} else {
						throw new Exception("RrnNo not found" + callBackMndtDtl.getCustRefNo().toString());
					}
				} else if (callBackMndtDtl.getCallbackType().toUpperCase().equals("MANDATE_EXCECUTION")) {
					log.info("Entering UPIMandateYblServiceImpl - processCallBackYbl MANDATE_EXECUTION : "
							+ callBackMndtDtl);
					BaseResponseDTO lmsResponse = null;

					String uri = "http://localhost:8080/YBL_UPI/ybl/LMS/updateYBLUPIDebitStatus";
					YblUPIDebitCallBackRequestDTO upiDebitRequest = new YblUPIDebitCallBackRequestDTO();
					upiDebitRequest.setCallbackType(callBackMndtDtl.getCallbackType());
					upiDebitRequest.setStatus(callBackMndtDtl.getStatus());
					upiDebitRequest.setStatusDesc(callBackMndtDtl.getStatusDesc());
					// TODO CpMandateRefNo
					upiDebitRequest.setUmn(callBackMndtDtl.getUmn());
					upiDebitRequest.setTrxnNo(callBackMndtDtl.getTxnId());
					upiDebitRequest.setAccountno(callBackMndtDtl.getCrediAccount().toString());
					upiDebitRequest.setAccholdername(callBackMndtDtl.getName());
					upiDebitRequest.setPayerVpa(callBackMndtDtl.getPayerVPA());
					upiDebitRequest.setBankrrn(callBackMndtDtl.getCustRefNo().toString());
					upiDebitRequest.setExecutionrefno(callBackMndtDtl.getReferenceNumber());
					upiDebitRequest.setPayload(payload);
					log.info("Entering UPIMandateYblServiceImpl - processCallBackYbl MANDATE_EXECUTION. LMS Request : "
							+ upiDebitRequest.toString());

					RestTemplate restTemplate = new RestTemplate();
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					// headers.add(HttpHeaders.CONNECTION, "close");
					HttpEntity<Object> debitCallbackEntity = new HttpEntity<Object>(upiDebitRequest, headers);
					((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000 * 30);
					((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 30);
					lmsResponse = restTemplate.postForObject(uri, debitCallbackEntity, BaseResponseDTO.class);
					log.info("Entering UPIMandateYblServiceImpl-processCallBackYbl MANDATE_EXECUTION. LMS Response : "
							+ lmsResponse.toString());
				}
			}

		} catch (Exception e) {
			log.error("Error in decrypting and extracting callBack payload", e);
			fileUploadService.savePayload(requestYblDTO.getPayload(), "YblUPIFailedPayload", "UpiCallbackPayload",
					"json");
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for processCallBackYbl is ==>" + timeTaken);
		log.info("UPIMandateYblServiceImpl processCallBackYbl Response : success");
		return "success";
	}

	@Override
	public synchronized BaseResponseDTO debitStatusCallBackYbl(YblUPIDebitCallBackRequestDTO callBackRequest) {
		log.debug("Entering UPIMandateYblServiceImpl - debitStatusCallBackYbl : " + callBackRequest);
		long startTimeInMillis = System.currentTimeMillis();
		BaseResponseDTO response = new BaseResponseDTO();
		if (callBackRequest != null) {

			String callBackStr = "";
			try {
				callBackStr = YblUtil.decrypt(callBackRequest.getPayload());
			} catch (Exception e) {
				log.error("Error occured while decrypting payload ", e);
			}

			ReceiptsYblUpi receiptsYblUpi = receiptsYblUpiRepository.findByExecTrxnNo(callBackRequest.getTrxnNo());
			log.info("Call Back for UPI receipt : " + receiptsYblUpi);
			if (receiptsYblUpi != null) {
				if (!receiptsYblUpi.getMndtExecStatus().equals(callBackRequest.getStatus())) {
					String encPlusDecPayload = callBackRequest.getPayload() + "\n" + callBackRequest;
					try {
						fileUploadService.saveFileToDisk(encPlusDecPayload.getBytes(), "UPIMandateExecutePayload",
								receiptsYblUpi.getCustId() + "", "txt");
					} catch (IOException e) {
						log.error("Error occured while saving payload ", e);
					}
				}

				if (receiptsYblUpi.getStatus().equalsIgnoreCase("DEBIT_SUCCESS")) {
					log.info("DEBIT Status updated for receipt before callback : " + receiptsYblUpi);
				} else {
					receiptsYblUpi.setMndtExecDesc(callBackRequest.getStatusDesc());
					receiptsYblUpi.setMndtExecStatus(callBackRequest.getStatus());
					receiptsYblUpi.setBankRrn(callBackRequest.getBankrrn());
					receiptsYblUpi.setSipTrxnNo(callBackRequest.getSipTrxnNo());
					receiptsYblUpi.setUmn(callBackRequest.getUmn());
					receiptsYblUpi.setCallbackTime(new Date());
					receiptsYblUpi.setCallback(callBackStr);

					if (callBackRequest.getStatus().equalsIgnoreCase("SUCCESS")) {
						receiptsYblUpi.setStatus("DEBIT_SUCCESS");
					} else if (callBackRequest.getStatus().equalsIgnoreCase("FAILURE")
							|| callBackRequest.getStatusDesc().contains("Error: ETIMEDOUT")) {
						receiptsYblUpi.setStatus("DEBIT_FAILURE");
					}
					receiptsYblUpi = receiptsYblUpiRepository.save(receiptsYblUpi);

					// Invoking next debit for successful debit
					if (receiptsYblUpi.getStatus().equals("DEBIT_SUCCESS")) {
						Loan loan = loanRepository.findByloanNo(receiptsYblUpi.getLoanNo());
						// TODO invokeDebit was commented
//						invokeDebitYbl(loan,
//								receiptsYblUpi.getDebitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					}

					log.info("CallBack receiptYblUpi : " + receiptsYblUpi);
					try {
						TransactionEnquiryYblResponse mndtExecResponse = null;
						updateDebitYblLog(receiptsYblUpi, callBackRequest, callBackStr, mndtExecResponse);
					} catch (Exception e) {
						log.info("Exception while YBL UPI Log Save Option : Callback : ", e);
					}
				}
			} else {
				log.error("Receipt for call back => TrxnNo : " + callBackRequest.getTrxnNo() + " not found");
			}
		} else {
			response.setStatusCode("0");
			response.setStatusMessage(
					"UPIMandateYblServiceImpl - debitStatusCallBackYbl YBL UPI DEBIT CALLBACK is empty");
		}

		log.info(" UPIMandateYblServiceImpl - debitStatusCallBackYbl Time Takne : "
				+ (System.currentTimeMillis() - startTimeInMillis));
		return response;
	}

	private synchronized void checkDebitExecutionStatusYbl(ReceiptsYblUpi receipt) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering UPIMandateYblServiceImpl - checkDebitExecutionStatusYbl :" + receipt);

		ReceiptsYblUpi receiptYblUpiNew = receiptsYblUpiRepository.findById(receipt.getId()).get();
		if (receiptYblUpiNew != null && receiptYblUpiNew.getStatus().equalsIgnoreCase("DEBIT_SUCCESS")) {
			log.info("DEBIT status updated for receipt before API : " + receiptYblUpiNew);
			return;
		}

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(generatePSPRefNo());
		Date txnDate = receipt.getMndtExecTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		requestInfo.setTxnDate(formatter.format(txnDate));

		TransactionEnquiryYblRequest request = new TransactionEnquiryYblRequest();
		request.setRequestInfo(requestInfo);
		request.setTransactionNote("Test");
		request.setOrgTxnID(receipt.getExecTrxnNo());
		request.setOrgTxnDate(requestInfo.getTxnDate());
		try {
			TransactionEnquiryYblResponse response = YblUtil.executeRequest(request, "/chktnx",
					TransactionEnquiryYblResponse.class);
			if (response != null && receiptYblUpiNew != null) {
				receiptYblUpiNew.setMndtExecStatus(response.getStatus());
				receiptYblUpiNew.setMndtExecDesc(response.getMessage());
				receiptYblUpiNew.setBankRrn(response.getCustRefNo().toString());
				int statusCheckCnt = receiptYblUpiNew.getDebitStatusTrycount();
				statusCheckCnt = statusCheckCnt + 1;
				receiptYblUpiNew.setDebitStatusTrycount(statusCheckCnt);
				if (response.getStatus().equalsIgnoreCase("S")) {
					receiptYblUpiNew.setStatus("DEBIT_SUCCESS");
				} else if (response.getStatus().equalsIgnoreCase("F")
						|| response.getMessage().contains("Error: ETIMEDOUT")) {
					receiptYblUpiNew.setStatus("DEBIT_FAILURE");
				}
				LocalDateTime now = LocalDateTime.now();
				ObjectMapper objectMapper = new ObjectMapper();
				String responseString = "Time : " + now + " || " + objectMapper.writeValueAsString(response);
				receiptYblUpiNew.setDebitStatusResponse(responseString);
				receiptYblUpiNew = receiptsYblUpiRepository.save(receiptYblUpiNew);

				try {
					YblUPIDebitCallBackRequestDTO callBackRequest = null;
					String callBackStr = null;
					updateDebitYblLog(receiptYblUpiNew, callBackRequest, callBackStr, response);
				} catch (Exception ex) {
					log.info("Exception while YBL UPI Log Save Option : Debit Status : ", ex);
				}

				// Invoking next debit for successful debit
				if (receiptYblUpiNew.getStatus().equals("DEBIT_SUCCESS")) {
					Loan loan = loanRepository.findByloanNo(receiptYblUpiNew.getLoanNo());
					invokeDebitYbl(loan,
							receiptYblUpiNew.getDebitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				}
			}
		} catch (Exception e) {
			log.error("error in checking status of upi ybl execution receipt id:" + receipt.getId() + " cust_id:"
					+ receipt.getCustId() + " mandate ref no:" + receipt.getCpMdtRefNo(), e);
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for checkDebitExecutionStatusYbl is ==>" + timeTaken);
	}

	private void updateDebitYblLog(ReceiptsYblUpi receiptsYblUpi, YblUPIDebitCallBackRequestDTO callBackRequest,
			String callBackStr, TransactionEnquiryYblResponse debitStatus) {

		log.info("Entering updateDebitYblLog==>" + receiptsYblUpi + " | " + callBackRequest + " | " + callBackStr
				+ " | " + debitStatus);

		ObjectMapper objectMapper = new ObjectMapper();
		ReceiptsYblUpiLog upiReceiptLog = null;
		if (upiReceiptLog == null && receiptsYblUpi.getReceiptLogId() > 0) {
			upiReceiptLog = receiptsYblUpiLogRepository.findByid(receiptsYblUpi.getReceiptLogId());
		}

		if (upiReceiptLog == null && receiptsYblUpi.getExecTrxnNo() != null) {
			upiReceiptLog = receiptsYblUpiLogRepository.findFirstByExecTrxnNo(receiptsYblUpi.getExecTrxnNo());
		}

		if (upiReceiptLog != null) {
			// Callback Result
			if (callBackRequest != null && callBackStr != null) {
				upiReceiptLog.setMndtExecDesc(callBackRequest.getStatusDesc());
				upiReceiptLog.setMndtExecStatus(callBackRequest.getStatus());
				upiReceiptLog.setBankRrn(callBackRequest.getBankrrn());
				upiReceiptLog.setSipTrxnNo(callBackRequest.getSipTrxnNo());
				upiReceiptLog.setUmn(callBackRequest.getUmn());
				upiReceiptLog.setCallbackTime(new Date());
				callBackStr = "Time : " + receiptsYblUpi.getCallbackTime() + " : " + callBackStr;
				receiptsYblUpi.setCallback(callBackStr);
				upiReceiptLog.setSource("CALLBACK");
				log.info("Entering updateDebitLog==>CALLBACK");
			}

			// Debit Status Check Api Result
			if (debitStatus != null) {
				upiReceiptLog.setMndtExecStatus(debitStatus.getStatus());
				upiReceiptLog.setMndtExecDesc(debitStatus.getMessage());
				upiReceiptLog.setBankRrn(debitStatus.getCustRefNo().toString()); // TODO about umn

				String responseString = "";
				try {
					responseString = objectMapper.writeValueAsString(debitStatus);
				} catch (JsonProcessingException e) {
				}
				upiReceiptLog.setDebitStatusResponse(responseString);
				upiReceiptLog.setSource("DEBIT_STATUS");
				log.info("Entering updateDebitLog==>DEBIT_STATUS");
			}

			upiReceiptLog.setStatus(receiptsYblUpi.getStatus());
			upiReceiptLog.setModifyTime(new Date());
			receiptsYblUpiLogRepository.save(upiReceiptLog);
		}
		log.info("Exiting updateDebitYblLog==>Res :" + upiReceiptLog);
	}

	private synchronized String invokeDebitYbl(Loan loan, LocalDate today) {
		log.info("Invoking debit for loan : " + loan.getLoanNo() + " for " + today);
		String response = "FAILURE";
		List<Receivable> dues = receivableRepository.getLoanDues(loan.getLoanNo(), today);
		int successfulDebits = 0;
		List<ReceiptsYblUpi> debitedReceipts = receiptsYblUpiRepository
				.getDebitSuccessReceiptsByRcptType(loan.getLoanNo(), today, "EDI");
		if (debitedReceipts != null) {
			successfulDebits = debitedReceipts.size();
			if (dues != null) {
				log.info("Loan due count : " + dues.size());
			}
			log.info("Successful debit receipt count : " + successfulDebits);
		}
		if (dues == null || dues.isEmpty() || (successfulDebits >= dues.size())) {
			log.info("No Dues for Loan No => " + loan.getLoanNo() + " for : " + today + " Successful Debits : "
					+ successfulDebits);
			response = "NODUES";
		} else {
			ReceiptsYblUpi receipt = receiptsYblUpiRepository.getPredebitReceiptByRcptType(loan.getLoanNo(), today,
					"EDI");
			if (receipt != null && !receipt.getStatus().equalsIgnoreCase("DEBIT_SUCCESS")) {
				try {
					long executionStartMillis = System.currentTimeMillis();
					log.info("RCPT : " + receipt.getId() + " Loan No : " + loan.getLoanNo() + " Mandate : "
							+ receipt.getCpMdtRefNo());

					ExecuteMandateYblRequest debitYblRequest = new ExecuteMandateYblRequest();
					DecimalFormat decimalFormat = new DecimalFormat();
					decimalFormat.setMinimumFractionDigits(2);
					decimalFormat.setMaximumFractionDigits(2);
					decimalFormat.setGroupingUsed(false);
					ExecuteMandateYblResponse debitYblResponse = null;

					if (loan.isUpiDebit()) {
						RequestInfo requestInfo = new RequestInfo();
						requestInfo.setPgMerchantId(YblUtil.merchId);
						requestInfo.setPspRefNo(generatePSPRefNo());

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
							log.info("Executing debit Loan No : " + loan.getLoanNo() + "  Request => "
									+ debitYblRequest);
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
					receiptsYblUpiRepository.save(receipt);

					try {
						YblUPIDebitCallBackRequestDTO callBackRequest = null;
						TransactionEnquiryYblResponse debitStatus = null;
						String callBackStr = null;
						saveDebitYblLog(receipt, callBackRequest, callBackStr, debitStatus, debitYblResponse);
					} catch (Exception e) {
						log.info("Exception while YBL UPI Log Save Option : Debit Status : ", e);
					}
				} catch (Exception ex) {
					log.error("Exception occured while executing debits =>", ex);
				}
			} else {
				log.info("All debits handled for loan no :" + loan.getLoanNo());
				response = "NODUES";
			}
		}
		return response;
	}

	private void saveDebitYblLog(ReceiptsYblUpi receiptYblUpi, YblUPIDebitCallBackRequestDTO callBackRequest,
			String callBackStr, TransactionEnquiryYblResponse debitStatus, ExecuteMandateYblResponse debitYblResponse) {

		ObjectMapper objectMapper = new ObjectMapper();

		ReceiptsYblUpiLog upiReceiptLog = new ReceiptsYblUpiLog();
		// Predebit Result
		upiReceiptLog.setCamsUpiId(receiptYblUpi.getId());
		upiReceiptLog.setLoanNo(receiptYblUpi.getLoanNo());
		upiReceiptLog.setLoanId(receiptYblUpi.getLoanId());
		upiReceiptLog.setCustId(receiptYblUpi.getCustId());
		upiReceiptLog.setEdi(receiptYblUpi.getEdi());
		upiReceiptLog.setCpMdtRefNo(receiptYblUpi.getCpMdtRefNo());
		upiReceiptLog.setPredebitDate(receiptYblUpi.getPredebitDate());
		upiReceiptLog.setDebitDate(receiptYblUpi.getDebitDate());
		upiReceiptLog.setSeqNo(receiptYblUpi.getSeqNo());
		upiReceiptLog.setPreDebitDesc(receiptYblUpi.getPreDebitDesc());
		upiReceiptLog.setPreDebitStatus(receiptYblUpi.getPreDebitStatus());
		upiReceiptLog.setPredebitResponse(receiptYblUpi.getPredebitResponse());
		upiReceiptLog.setReceiptType(receiptYblUpi.getReceiptType());

		upiReceiptLog.setExecTrxnNo(receiptYblUpi.getExecTrxnNo());
		upiReceiptLog.setExecutionRefNo(receiptYblUpi.getExecutionRefNo());

		// CallBack Result
		if (callBackRequest != null && callBackStr != null) {
			upiReceiptLog.setMndtExecDesc(callBackRequest.getStatusDesc());
			upiReceiptLog.setMndtExecStatus(callBackRequest.getStatus());
			upiReceiptLog.setBankRrn(callBackRequest.getBankrrn());
			upiReceiptLog.setSipTrxnNo(callBackRequest.getSipTrxnNo());
			upiReceiptLog.setUmn(callBackRequest.getUmn());
			upiReceiptLog.setCallbackTime(new Date());
			callBackStr = "Time : " + receiptYblUpi.getCallbackTime() + " : " + callBackStr;
			receiptYblUpi.setCallback(callBackStr);
			upiReceiptLog.setSource("CALLBACK");
		}

		// Debit Status Check API Result
		if (debitStatus != null) {
			upiReceiptLog.setMndtExecStatus(debitStatus.getStatus());
			upiReceiptLog.setMndtExecDesc(debitStatus.getMessage());
			upiReceiptLog.setBankRrn(debitStatus.getCustRefNo().toString()); // TODO about umn

			String responseString = "";
			try {
				responseString = objectMapper.writeValueAsString(debitStatus);
			} catch (JsonProcessingException e) {
			}
			upiReceiptLog.setDebitStatusResponse(responseString);
			upiReceiptLog.setSource("DEBIT_STATUS");
		}

		// Mandate Execution Response
		if (debitYblResponse != null) {
			upiReceiptLog.setMndtExecDesc(debitYblResponse.getStatusDesc());
			upiReceiptLog.setMndtExecStatus(debitYblResponse.getStatus());
			upiReceiptLog.setMndtExecTime(new Date());
			// TODO ask about BankResDesc and BankErrorCode
			if (debitYblResponse.getMandateDtls() != null) {
				MandateDtl mandateDtl = debitYblResponse.getMandateDtls().get(0);
				if (mandateDtl != null) {
					upiReceiptLog.setExecutionRefNo(mandateDtl.getReferenceNumber());
					upiReceiptLog.setBankRrn(mandateDtl.getCustRefNo().toString());
					upiReceiptLog.setSipTrxnNo(mandateDtl.getTxnId());
				}
			}

			String responseString = null;
			try {
				responseString = objectMapper.writeValueAsString(debitYblResponse);
			} catch (JsonProcessingException e) {
			}
			upiReceiptLog.setDebitResponse(responseString);
			upiReceiptLog.setSource("DEBIT_EXEC");
		}
		upiReceiptLog.setStatus(receiptYblUpi.getStatus());
		upiReceiptLog.setCreateTime(new Date());
		receiptsYblUpiLogRepository.save(upiReceiptLog);
	}

}
