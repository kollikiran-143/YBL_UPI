package in.fl.los.service;

import in.fl.los.mandate.upimandate.ybl.CallBackYblRequest;
import in.fl.los.request.ValidateVpaYblRequestDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.ValidateVpaYblResponseDTO;

public interface YblCustomerService {

	public BaseResponseDTO payUpiCallBackYbl(CallBackYblRequest callBackYblRequest);

	public ValidateVpaYblResponseDTO validateVPA(ValidateVpaYblRequestDTO validateVpaYblRequestDTO);
}
