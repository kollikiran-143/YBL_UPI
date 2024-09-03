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
import in.fl.los.mandate.upimandate.ybl.YblUPIDebitCallBackRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.util.CommonUtils;

@RestController
@RequestMapping("/ybl/LMS")
public class LOSController {

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	private final Logger log = Logger.getLogger(LOSController.class);

	@RequestMapping(value = "/updateYBLUPIDebitStatus", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody BaseResponseDTO updateYblUPIDebitStatus(
			@RequestBody YblUPIDebitCallBackRequestDTO callBackRequest) throws Exception {
		CommonUtils.mdcPut("CustomerId", "");
		log.debug("Entering LOSController - updateYblUPIDebitStatus : " + callBackRequest);
		BaseResponseDTO response = upiMandateYblService.debitStatusCallBackYbl(callBackRequest);
		log.debug(" LOSController updateYblUPIDebitStatus Response : " + response);
		MDC.remove("CustomerId");
		return response;
	}
}
