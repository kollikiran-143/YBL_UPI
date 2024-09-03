package in.fl.los.service;

import in.fl.los.response.CompareTwoFacesResponse;

public interface ImageVerificationService {
	
	/*
	 * This method verifies two images belongs to same person.
	 * @param sourceImage source image as byte array
	 * @param targetImage target image as byte array
	 * @return 
	 */

	CompareTwoFacesResponse compare(byte[] sourceImage, byte[] targetImage);
	
	/*
	 * This method verifies if image has single face in it
	 * @param ImageValidateRequestDTO. it contains path to source image
	 * @return ImageValidateResponseDTO contains flag indicating if image has single face.
	 */
	//public ImageValidateResponseDTO ValidateImage(ImageValidateRequestDTO request);
}
