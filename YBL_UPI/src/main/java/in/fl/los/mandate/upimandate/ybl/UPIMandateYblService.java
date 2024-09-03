package in.fl.los.mandate.upimandate.ybl;

import in.fl.los.request.BaseRequestDTO;
import in.fl.los.request.CreateUpiMandateYblRequestDTO;
import in.fl.los.request.RevokeMandateRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.CreateUpiMandateYblResponseDTO;
import in.fl.los.response.UpiMandateStatusResponseDTO;
import in.fl.los.ybl.util.RequestYblDTO;

public interface UPIMandateYblService {

	ValidateVpaYblResponse validateVPA(String vpa);

	String generatePSPRefNo();

	CreateUpiMandateYblResponseDTO createUpiMandate(CreateUpiMandateYblRequestDTO createUpiMandateYblRequestDTO);

	UpiMandateStatusResponseDTO getUpiMandateStatus(BaseRequestDTO baseRequestDTO);

	BaseResponseDTO revokeMandate(RevokeMandateRequestDTO requestDTO);

	String processCallBackYbl(RequestYblDTO requestYblDTO);

	BaseResponseDTO debitStatusCallBackYbl(YblUPIDebitCallBackRequestDTO callBackRequest);

}
