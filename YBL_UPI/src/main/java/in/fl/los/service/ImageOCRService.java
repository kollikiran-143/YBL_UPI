package in.fl.los.service;

import java.io.IOException;

import in.fl.los.response.IDPVResponseDTO;

public interface ImageOCRService {

	/***
	 * This api is used to read text from image
	 * 
	 * @param imgData
	 * @param documentType
	 * @param customerID
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public IDPVResponseDTO getImageData(byte[] imgData, int documentType, int customerID) throws IOException, Exception;

}
