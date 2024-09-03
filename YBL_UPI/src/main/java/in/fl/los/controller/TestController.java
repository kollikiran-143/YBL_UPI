package in.fl.los.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.fl.los.mandate.upimandate.ybl.ExecuteMandateYblRequest;
import in.fl.los.mandate.upimandate.ybl.ExecuteMandateYblResponse;
import in.fl.los.mandate.upimandate.ybl.PreDebitYblRequest;
import in.fl.los.mandate.upimandate.ybl.PreDebitYblResponse;
import in.fl.los.mandate.upimandate.ybl.RequestInfo;
import in.fl.los.mandate.upimandate.ybl.UPIMandateYblService;
import in.fl.los.util.CommonUtils;
import in.fl.los.ybl.util.YblUtil;

@RestController
@RequestMapping("/test/ybl")
public class TestController {

	@Autowired
	private UPIMandateYblService upiMandateYblService;

	private final Logger log = Logger.getLogger(TestController.class);

	@RequestMapping(value = "/preDebit", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody PreDebitYblResponse preDebitNotification(@RequestBody PreDebitYblRequest request)
			throws Exception {
		CommonUtils.mdcPut("CustomerId", "");

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(upiMandateYblService.generatePSPRefNo());

		request.setRequestInfo(requestInfo);

		log.info("Entering TestController preDebitNotification : " + request);
		PreDebitYblResponse response = YblUtil.executeRequest(request, "/msupimer/upi/mandate/notifyMandate",
				PreDebitYblResponse.class);
		log.info(" TestController preDebitNotification Response : " + response);
		MDC.remove("CustomerId");
		return response;
	}

	@RequestMapping(value = "/debit", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ExecuteMandateYblResponse mandateExecution(@RequestBody ExecuteMandateYblRequest request)
			throws Exception {
		CommonUtils.mdcPut("CustomerId", "");

		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setPgMerchantId(YblUtil.merchId);
		requestInfo.setPspRefNo(upiMandateYblService.generatePSPRefNo());

		request.setRequestInfo(requestInfo);

		log.info("Entering TestController mandateExecution : " + request);
		ExecuteMandateYblResponse response = YblUtil.executeRequest(request, "/msupimer/upi/mandate/recurrPayment",
				ExecuteMandateYblResponse.class);
		log.info(" TestController mandateExecution Response : " + response);
		MDC.remove("CustomerId");
		return response;
	}
}
