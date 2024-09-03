package in.fl.los.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.fl.los.mandate.upimandate.ybl.UPIMandateYblService;
import in.fl.los.request.BaseRequestDTO;
import in.fl.los.request.CreateUpiMandateYblRequestDTO;
import in.fl.los.request.RevokeMandateRequestDTO;
import in.fl.los.request.ValidateVpaYblRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.CreateUpiMandateYblResponseDTO;
import in.fl.los.response.UpiMandateStatusResponseDTO;
import in.fl.los.response.ValidateVpaYblResponseDTO;
import in.fl.los.response.VersionCheckResponseDTO;
import in.fl.los.service.VersionService;
import in.fl.los.service.YblCustomerService;
import in.fl.los.util.CommonUtils;
import in.fl.los.ybl.util.RequestYblDTO;

@RestController
@RequestMapping("/ybl")
public class YblMandateController {

	@Autowired
	private YblCustomerService yblCustomerService;

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	@Autowired
	private VersionService versionService;

	private final Logger log = Logger.getLogger(YblMandateController.class);

	@RequestMapping(value = "/validateVPA", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ValidateVpaYblResponseDTO validateVPA(
			@RequestBody ValidateVpaYblRequestDTO validateVpaYblRequestDTO) throws Exception {
		CommonUtils.mdcPut("CustomerId", validateVpaYblRequestDTO.getCustomerId());
		log.info("Entering YblMandateController validateVPA : " + validateVpaYblRequestDTO);

		VersionCheckResponseDTO versionCheckResponse = versionService.getVersion(validateVpaYblRequestDTO.getVersion(),
				validateVpaYblRequestDTO.getAppName(), validateVpaYblRequestDTO.getAgentId());
		ValidateVpaYblResponseDTO response = null;

		if (versionCheckResponse.getStatusCode().equalsIgnoreCase("2")) {
			response = new ValidateVpaYblResponseDTO();
			response.setStatusCode(versionCheckResponse.getStatusCode());
			response.setStatusMessage(versionCheckResponse.getStatusMessage());
		} else {
			response = yblCustomerService.validateVPA(validateVpaYblRequestDTO);
		}
		log.info("YblMandateController validateVPA Response:" + response);
		MDC.remove("CustomerId");
		return response;
	}

	@RequestMapping(value = "/callBackYbl", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody String yblPayUpiCallBack(@RequestBody RequestYblDTO requestYblDTO) throws Exception {
		CommonUtils.mdcPut("CustomerId", "1234");
		log.info("Entering YblMandateController yblPayUpiCallBack UPLIFT: \n" + requestYblDTO);
		String response = null;
		response = upiMandateYblService.processCallBackYbl(requestYblDTO);
		log.info("YblMandateController yblPayUpiCallBack Response :" + response);
		MDC.remove("CustomerId");
		return response;
	}

	@RequestMapping(value = "/createUpiMandate", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody CreateUpiMandateYblResponseDTO createUpiMandate(
			@RequestBody CreateUpiMandateYblRequestDTO createUpiMandateYblRequestDTO) throws Exception {
		CommonUtils.mdcPut("CustomerId", createUpiMandateYblRequestDTO.getCustomerId());
		log.info("Entering YblMandateController createUpiMandate : " + createUpiMandateYblRequestDTO);

		VersionCheckResponseDTO versionCheckResponse = versionService.getVersion(
				createUpiMandateYblRequestDTO.getVersion(), createUpiMandateYblRequestDTO.getAppName(),
				createUpiMandateYblRequestDTO.getAgentId());
		CreateUpiMandateYblResponseDTO response = null;

		if (versionCheckResponse.getStatusCode().equalsIgnoreCase("2")) {
			response = new CreateUpiMandateYblResponseDTO();
			response.setStatusCode(versionCheckResponse.getStatusCode());
			response.setStatusMessage(versionCheckResponse.getStatusMessage());
		} else {
			response = upiMandateYblService.createUpiMandate(createUpiMandateYblRequestDTO);
		}
		log.info("YblMandateController createUpiMandate Response:" + response);
		MDC.remove("CustomerId");
		return response;
	}

	@RequestMapping(value = "/getUpiMandateStatus", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody UpiMandateStatusResponseDTO getUpiMandateStatus(@RequestBody BaseRequestDTO baseRequestDTO)
			throws Exception {
		CommonUtils.mdcPut("CustomerId", baseRequestDTO.getCustomerId());
		log.info("Entering YblMandateController getUpiMandateStatus :" + baseRequestDTO);

		VersionCheckResponseDTO versionCheckResponse = versionService.getVersion(baseRequestDTO.getVersion(),
				baseRequestDTO.getAppName(), baseRequestDTO.getAgentId());
		UpiMandateStatusResponseDTO response = null;

		if (versionCheckResponse.getStatusCode().equalsIgnoreCase("2")) {
			response = new UpiMandateStatusResponseDTO();
			response.setStatusCode(versionCheckResponse.getStatusCode());
			response.setStatusMessage(versionCheckResponse.getStatusMessage());
		} else {
			response = upiMandateYblService.getUpiMandateStatus(baseRequestDTO);
		}
		log.info("YblMandateController getUpiMandateStatus Response:" + response);
		MDC.remove("CustomerId");
		return response;
	}

	@RequestMapping(value = "/revokeMandate", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody BaseResponseDTO revokeMandate(@RequestBody RevokeMandateRequestDTO requestDTO)
			throws Exception {
		CommonUtils.mdcPut("CustomerId", requestDTO.getCustomerId());
		log.info("Entering YblMandateController revokeMandate :" + requestDTO);

		VersionCheckResponseDTO versionCheckResponse = versionService.getVersion(requestDTO.getVersion(),
				requestDTO.getAppName(), requestDTO.getAgentId());
		BaseResponseDTO response = null;

		if (versionCheckResponse.getStatusCode().equalsIgnoreCase("2")) {
			response = new UpiMandateStatusResponseDTO();
			response.setStatusCode(versionCheckResponse.getStatusCode());
			response.setStatusMessage(versionCheckResponse.getStatusMessage());
		} else {
			response = upiMandateYblService.revokeMandate(requestDTO);
		}
		log.info("YblMandateController revokeMandate Response:" + response);
		MDC.remove("CustomerId");
		return response;
	}

}
