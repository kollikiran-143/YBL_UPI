package in.fl.los.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.fl.los.response.CompareTwoFacesResponse;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.Attribute;
import software.amazon.awssdk.services.rekognition.model.CompareFacesMatch;
import software.amazon.awssdk.services.rekognition.model.CompareFacesRequest;
import software.amazon.awssdk.services.rekognition.model.CompareFacesResponse;
import software.amazon.awssdk.services.rekognition.model.ComparedFace;
import software.amazon.awssdk.services.rekognition.model.DetectFacesRequest;
import software.amazon.awssdk.services.rekognition.model.DetectFacesResponse;
import software.amazon.awssdk.services.rekognition.model.FaceDetail;
import software.amazon.awssdk.services.rekognition.model.Image;
import software.amazon.awssdk.services.rekognition.model.RekognitionException;

@Component
public class ImageVerificationServiceImpl implements ImageVerificationService {

	private final Logger log = Logger.getLogger(ImageVerificationServiceImpl.class);

	@Value("${rekognition.access.key.id}")
	private String s3AccessKeyID;

	@Value("${rekognition.secret.access.key}")
	private String s3SecretAccessKey;
//	@Value("${compareFace.similarityThreshold}")
	Float similarityThreshold = 0.7f;

	/*
	 * Create an Image object for the source image.
	 * 
	 * @param imageBytes. byte array of image
	 * 
	 * @return Image object require for the aws Rekognition APIs
	 */
	private Image getImageForRekognition(byte[] imageBytes) {
		SdkBytes imageSDKBytes = SdkBytes.fromByteArray(imageBytes);

		// Create an Image object for the source image.
		Image image = Image.builder().bytes(imageSDKBytes).build();
		return image;
	}

	/*
	 * get RekognitionClient to call aws API on
	 */
	private RekognitionClient getRekognitionClient() {
		Region region = Region.AP_SOUTH_1;
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(s3AccessKeyID, s3SecretAccessKey);
		RekognitionClient rekClient = RekognitionClient.builder().region(region)
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds)).build();
		return rekClient;
	}

	/*
	 * Compares the two images for face match.
	 * 
	 * @param rekClient. RekognitionClient
	 * 
	 * @param similarityThreshold. Minimum confidence percentage with which the
	 * images should be matched
	 * 
	 * @param souImage. Image object of source image
	 * 
	 * @param tarImage. Image object of target image
	 * 
	 * @return confidence percentage with which the images matched
	 */
	private float compareTwoFaces(RekognitionClient rekClient, Float similarityThreshold, Image souImage,
			Image tarImage) throws Exception {

		log.info("compareTwoFaces :: start");
		CompareFacesRequest facesRequest = CompareFacesRequest.builder().sourceImage(souImage).targetImage(tarImage)
				.similarityThreshold(similarityThreshold).build();

		// Compare the two images.
		float matchPercetage = 0.0f;
		CompareFacesResponse compareFacesResult = rekClient.compareFaces(facesRequest);
		log.info("compareTwoFaces : response:" + compareFacesResult.toString());
		List<CompareFacesMatch> faceDetails = compareFacesResult.faceMatches();
		if (faceDetails.size() == 0) {
			matchPercetage = 0.0f;
		} else if (faceDetails.size() > 1) { // just to double check. It should never happen as we only call this
												// function if one face in image
			throw new Exception("Multiple Faces");
		}
		int i=0;
		for (CompareFacesMatch match : faceDetails) {
			log.info("compareTwoFaces : match : " + i + " : " +  match.toString());
			ComparedFace face = match.face();
			log.info("compareTwoFaces : match.similarity : " + i + " : " +  match.similarity());
			log.info("compareTwoFaces : face.confidence : " + i + " : " +  face.confidence());
			//matchPercetage = face.confidence();
			matchPercetage = match.similarity();
			i++;
		}
		log.info("exiting compareTwoFaces : matchPercetage:" + matchPercetage);
		return matchPercetage;
	}

	/*
	 * Detects number of faces in a picture
	 * 
	 * @param rekClient. RekognitionClient
	 * 
	 * @param souImage. Image object of the image in which faces to be detected
	 * 
	 * @return number of faces detected
	 */
	private int detectNumberOfFacesinImage(RekognitionClient rekClient, Image souImage)
			throws FileNotFoundException, RekognitionException {
		log.info("detectNumberOfFacesinImage :: start");

		DetectFacesRequest facesRequest = DetectFacesRequest.builder().attributes(Attribute.ALL).image(souImage)
				.build();

		DetectFacesResponse facesResponse = rekClient.detectFaces(facesRequest);
		List<FaceDetail> faceDetails = facesResponse.faceDetails();
		log.info("detectNumberOfFacesinImage :: ends : no of faces:" + faceDetails.size());
		return faceDetails.size();

	}

	/*
	 * This method compares two images
	 * 
	 * @param sourceImage. byteArray of source image
	 * 
	 * @param targetImage. byteArray of target image
	 * 
	 * @param similarityThreshold. Minimum confidence percentage with which the
	 * images should be matched
	 * 
	 * @return matchpercentage
	 */
	@Override
	public CompareTwoFacesResponse compare(byte[] sourceImage, byte[] targetImage) {
		log.info("Entering Compare ");
		CompareTwoFacesResponse response = new CompareTwoFacesResponse();
		float percentage = 0f;

		RekognitionClient rekClient = getRekognitionClient();
		try {
			Image souImage = getImageForRekognition(sourceImage);
			Image tarImage = getImageForRekognition(targetImage);
			int faceCount = detectNumberOfFacesinImage(rekClient, tarImage);
			response.setTargetFaceCount(faceCount);
			if (faceCount == 1) {
				percentage = compareTwoFaces(rekClient, similarityThreshold, souImage, tarImage);
				response.setMatchPercetage(percentage);
				response.setStatusCode("1");
				response.setStatusMessage("SUCCESS");
			} else {
				response.setStatusCode("0");
				response.setStatusMessage("Need Single Face");
			}
		} catch (Exception e) {
			response.setStatusCode("0");
			response.setStatusMessage("FAILURE :" + e.getMessage());
			log.error("error in comparing face :", e);
		}
		rekClient.close();
		log.info("Exiting Compare :: response:" + response);
		return response;

	}

}
