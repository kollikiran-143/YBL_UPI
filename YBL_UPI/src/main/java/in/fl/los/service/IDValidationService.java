package in.fl.los.service;

import java.io.IOException;

import in.fl.los.request.IDPVRequestDTO;
import in.fl.los.response.IDPVResponseDTO;

public interface IDValidationService {

	/***
	 * This api is used to validate the images using OCR
	 * 
	 * @param idpvRequestDTO
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public IDPVResponseDTO validatePic(IDPVRequestDTO idpvRequestDTO) throws IOException, Exception;

}
