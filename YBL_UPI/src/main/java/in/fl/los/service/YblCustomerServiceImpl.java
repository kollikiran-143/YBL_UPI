package in.fl.los.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.fl.los.mandate.upimandate.ybl.MandateDtl;
import in.fl.los.mandate.upimandate.ybl.UPIMandateYblService;
import in.fl.los.mandate.upimandate.ybl.ValidateVpaYblResponse;
import in.fl.los.mandate.upimandate.ybl.CallBackYblRequest;
import in.fl.los.model.MandateApiAuditYblUpi;
import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlCustomerStateStatus;
import in.fl.los.repository.APIMandateYblUpiRepository;
import in.fl.los.repository.CustomerRepository;
import in.fl.los.request.ValidateVpaYblRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.ValidateVpaYblResponseDTO;
import in.fl.los.util.WebConstants;

@Service
public class YblCustomerServiceImpl implements YblCustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerLocationService customerLocationService;

	@Autowired
	private APIMandateYblUpiRepository upiMandateYblRepository;

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	private final Logger log = Logger.getLogger(YblCustomerServiceImpl.class);

	@Override
	public BaseResponseDTO payUpiCallBackYbl(CallBackYblRequest request) {

		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering YblCustomerServiceImpl  payUpiCallBackYbl UPLIFT:" + request);

		BaseResponseDTO response = new BaseResponseDTO();

		if (request.getMandateDtls() != null) {
			try {
				List<MandateDtl> listOfMandateDetails = request.getMandateDtls();
				for (MandateDtl eachMandateDetails : listOfMandateDetails) {
					String rrnNo = eachMandateDetails.getCustRefNo().toString();
					MandateApiAuditYblUpi mandateDetailResp = upiMandateYblRepository.findByRrnNo(rrnNo);
					mandateDetailResp.setUmrn(eachMandateDetails.getUmn());
					upiMandateYblRepository.save(mandateDetailResp);
				}
				response.setStatusCode(WebConstants.SUCCESS_CODE);
				response.setStatusMessage(WebConstants.SUCCESS_MSG);
			} catch (Exception e) {
				response.setStatusCode(WebConstants.FAILURE_CODE);
				response.setStatusMessage(WebConstants.FAILURE_MSG);
				log.error("Error while saving Mandate Details into MandateAuditUpiYbl table :", e);
			}
		} else {
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage("MandateDtls list is null in your request");
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for saveMandateDetails is ==>" + timeTaken);
		log.info("Exiting YblCustomerServiceImpl payUpiCallBackYbl with response: " + response);
		return response;
	}

	@Override
	public ValidateVpaYblResponseDTO validateVPA(ValidateVpaYblRequestDTO request) {

		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering YblCustomerServiceImpl validateVPA UPLIFT: " + request);
		request.getLocationRequestDTO().setEventType("VALIDATE VPA");
		customerLocationService.saveCustomerLocationLog(request);
		int customerId = Integer.parseInt(request.getCustomerId());
		UlCustomerDetails customerDetails = customerRepository.findById(customerId).get();

		ValidateVpaYblResponseDTO response = new ValidateVpaYblResponseDTO();

		ValidateVpaYblResponse valideVpaYblResponse = null;
		try {
			valideVpaYblResponse = upiMandateYblService.validateVPA(request.getVpa());
			if (valideVpaYblResponse != null) {
				if (valideVpaYblResponse.getStatus().equals("S") && valideVpaYblResponse.getVerificationFlag()) {
					response.setStatusCode(WebConstants.SUCCESS_CODE);
					response.setStatusMessage(WebConstants.SUCCESS_MSG);
					response.setPayeeName(valideVpaYblResponse.getPayeeType().getName());
					response.setIfsc(valideVpaYblResponse.getPayeeType().getMerchantInfo().getIfsc());
					response.setAccountType(valideVpaYblResponse.getPayeeType().getMerchantInfo().getAccType());

					UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
					customerStateStatus.setVpaStatus(true);
					customerDetails.setCustomerStateStatus(customerStateStatus);
					customerDetails.setVpaPayerName(valideVpaYblResponse.getPayeeType().getName()); // TODO have to ask
					customerDetails.setVpaIfsc(valideVpaYblResponse.getPayeeType().getMerchantInfo().getIfsc());
					customerDetails.setVpa(valideVpaYblResponse.getPayeeType().getVirtualAddress());
					customerRepository.save(customerDetails);
				} else if (valideVpaYblResponse.getStatus().equals("S")
						&& !valideVpaYblResponse.getVerificationFlag()) {
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage("Merchant is not verified");
				} else {
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage("VPA is not valid");
				}
			} else {
				response.setStatusCode(WebConstants.FAILURE_CODE);
				response.setStatusMessage(WebConstants.FAILURE_MSG);
			}
		} catch (Exception e) {
			log.error("error in validating VPA Ybl", e);
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage(WebConstants.FAILURE_MSG);
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for validateVPA is ==>" + timeTaken);
		log.info("Exiting YblCustomerServiceImpl validateVPA with response: " + response);
		return response;
	}

}
