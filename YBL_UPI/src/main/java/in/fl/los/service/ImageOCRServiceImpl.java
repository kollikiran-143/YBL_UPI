package in.fl.los.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetection.WebEntity;
import com.google.cloud.vision.v1.WebDetection.WebLabel;
import com.google.protobuf.ByteString;

import in.fl.los.model.VisionRawResult;
import in.fl.los.repository.VisionRawRepository;
import in.fl.los.response.IDPVResponseDTO;
import in.fl.los.util.CommonUtils;
import in.fl.los.util.FLNameChecker;

@Component
public class ImageOCRServiceImpl implements ImageOCRService {

	@Autowired
	private VisionRawRepository visionRaw;

	private final Logger log = Logger.getLogger(ImageOCRServiceImpl.class);
	public static final int docTypePAN = 1;
	public static final int docTypeAADHAR = 2;
	public static final int docTypeAADHARBack = 3;
	public static final int docTypeSelfie = 4;
	public static final String[] docType = { "PAN", "AADHAR", "AADHARBACK", "SELFIE" };

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
	@Override
	public IDPVResponseDTO getImageData(byte[] imgData, int documentType, int customerID)
			throws IOException, Exception {
		CredentialsProvider credentialsProvider = FixedCredentialsProvider.create(ServiceAccountCredentials
				.fromStream(new FileInputStream("/FRNDLN/Config/VISIONOCR-67c1d7c13bcf.json")));
		ImageAnnotatorSettings annotateSettings = ImageAnnotatorSettings.newBuilder()
				.setCredentialsProvider(credentialsProvider).build();

		IDPVResponseDTO idpvResponseDTO = null;

		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create(annotateSettings)) {
			ByteString imgBytes = ByteString.copyFrom(imgData);

			// Builds the image annotation request
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feature = null;
			/*Feature feature1 = Feature.newBuilder().setType(Type.TEXT_DETECTION).setMaxResults(10).build();
			Feature feature2 = Feature.newBuilder().setType(Type.LABEL_DETECTION).setMaxResults(10).build();
			Feature feature3 = Feature.newBuilder().setType(Type.FACE_DETECTION).setMaxResults(10).build();
			Feature feature4 = Feature.newBuilder().setType(Type.WEB_DETECTION).setMaxResults(10).build();*/

			switch (documentType) {
			case docTypePAN:
				feature =  Feature.newBuilder().setType(Type.TEXT_DETECTION).setMaxResults(10).build();
				break;
			case docTypeAADHAR:
				feature =  Feature.newBuilder().setType(Type.TEXT_DETECTION).setMaxResults(10).build();
				break;
			case docTypeAADHARBack:
				feature =  Feature.newBuilder().setType(Type.TEXT_DETECTION).setMaxResults(10).build();
				break;
			case docTypeSelfie:
				feature =  Feature.newBuilder().setType(Type.FACE_DETECTION).setMaxResults(10).build();
				break;
			}

			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feature).setImage(img).build();
			requests.add(request);

			BatchAnnotateImagesResponse responses = vision.batchAnnotateImages(requests);
			if (responses.getResponsesList().isEmpty()) {
				return null;
			}
			AnnotateImageResponse response = responses.getResponses(0);
			log.info("======>" + response.getFullTextAnnotation().getText());

			// persist in S3
			/*
			 * try { //byte[] jsonContents = new
			 * ObjectMapper().writeValueAsString(response).getBytes();
			 * //fileUploadService.saveCompressedFileToS3(""+customerID,
			 * docType[documentType], "json", jsonContents); }catch(Exception e)
			 * { log.error("S3 Upload failed", e); }
			 */
			log.info("TEXT ===> " + response.getFullTextAnnotation().getText());
			log.info("LABELS===> " + response.getWebDetection().getBestGuessLabelsList());
			log.info("Web Entities===> " + response.getWebDetection().getWebEntitiesList());

			switch (documentType) {
			case docTypePAN:
				idpvResponseDTO = detectPAN(response, customerID);
				break;
			case docTypeAADHAR:
				idpvResponseDTO = detectAadharFront(response, customerID);
				break;
			case docTypeAADHARBack:
				idpvResponseDTO = detectAadharBack(response, customerID);
				break;
			case docTypeSelfie:
				idpvResponseDTO = detectFace(response, customerID);
				break;
			}
		}

		return idpvResponseDTO;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("hello");
		// for(int i=1; i<=5; i++){
		// Path path = Paths.get("/Users/vij/Desktop/visionapi/aadhaar" + i +
		// ".png");
		// Path path =
		// Paths.get("/Users/vij/Desktop/visionapi/IMG_20180522_124006.jpg");
		// Path path = Paths.get("/Users/vij/Downloads/dinabandhu.png");
		Path path = Paths.get("/home/etp/Desktop/hari.jpeg");
		byte[] imgData = Files.readAllBytes(path);
		IDPVResponseDTO attributes = new ImageOCRServiceImpl().getImageData(imgData, ImageOCRServiceImpl.docTypeSelfie,
				1);
		System.out.println(attributes);
		// }
	}

	/***
	 * This method is used to read Aadhaar front
	 * 
	 * @param response
	 * @param customerID
	 * @return
	 */
	private IDPVResponseDTO detectAadharFront(AnnotateImageResponse response, int customerID) {
		float confidence = 0;
		IDPVResponseDTO idpvResponseDTO = null;

		if (response.hasError()) {
			System.out.println("Error: " + response.getError().getMessage());
			return null;
		}

		WebDetection wd = response.getWebDetection();
		// Check bestGuessLabels
		String[] matchStrings = { "aadhaar", "uidai" };
		for (WebLabel label : wd.getBestGuessLabelsList()) {
			String labelStr = label.getLabel();
			if (labelStr != null && labelStr.trim().length() > 0) {
				labelStr = cleanStripString(labelStr);
				for (String ms : matchStrings) {
					if (labelStr.contains(ms)) {
						confidence += 0.2;
					}
				}
			}
		}
		// Check web entities
		List<WebEntity> webEntities = wd.getWebEntitiesList();
		for (WebEntity webEntity : webEntities) {
			float score = webEntity.getScore();
			String desc = webEntity.getDescription();
			if (desc != null && desc.trim().length() > 0) {
				desc = cleanStripString(desc);
				for (String ms : matchStrings) {
					if (desc.contains(ms) && score > 0.2) {
						confidence += score * 2;
					}
				}
			}
		}

		// Extract data from it.
		TextAnnotation fullTextAnnotation = response.getFullTextAnnotation();
		String annotationText = fullTextAnnotation.getText();
		// "भारत सरकार\nGOVERNMENT OF INDIA\nபிரதீப் ஈரோடு தங்கராஜ்\nPradeep
		// Erode Thangaraj\nபிறந்த நாள்! DOB: 24/01/1987\nஆண் / MALE\n2140
		// 67118035\n"
		annotationText = annotationText.replaceAll("[^\\x00-\\x7F]", "");
		// "\nGOVERNMENT OF INDIA\n\nPradeep Erode Thangaraj\n! DOB:
		// 24/01/1987\n/ MALE\n2140 67118035\n"
		List<String> textComponents = new ArrayList<String>();
		String[] textSplit = annotationText.split("\n");
		String[] ignorePatterns = { "GOVERNMENT OF INDIA" };
		String[] matchPatterns = { "DOB", "MALE", "Year of Birth", "YoB" };
		float toleranceMatch = 60;
		for (int i = 0; i < textSplit.length; i++) {
			String line = textSplit[i].trim(); // cleanStripString(textSplit[i]);
			if (line.length() == 0)
				continue;
			boolean ignoreMatched = false;
			for (int j = 0; j < ignorePatterns.length; j++) {
				float match = FLNameChecker.nameMatchPct(line, ignorePatterns[j]);
				if (match > toleranceMatch && Math.abs(line.length() - ignorePatterns[j].length()) < 5) {
					confidence += 0.2 * (match / 100);
					ignoreMatched = true;
					break;
				}
			}
			for (int j = 0; j < matchPatterns.length; j++) {
				String pattern = matchPatterns[j];
				float lcslen = FLNameChecker.lcsleni(pattern, line);
				float lcsmatch = lcslen / pattern.length();
				if (lcsmatch >= 0.6) {
					confidence += 0.25 * lcsmatch;
				}
			}
			if (!ignoreMatched) {
				textComponents.add(line);
			}
		}

		idpvResponseDTO = new IDPVResponseDTO();
		idpvResponseDTO.setIdType("AADHAAR");
		idpvResponseDTO.setHumanFace(false);
		String aadhaar = null, name = null, gender = null, dob = null;
		for (String line : textComponents) {
			// Detect AADHAAR
			String regex = "[0-9][0-9][0-9][0-9] *[0-9][0-9][0-9][0-9] *[0-9][0-9][0-9][0-9]";
			if (Pattern.matches(regex, line)) {
				aadhaar = line.replace("[^0-9]", "");
				aadhaar = aadhaar.replace(" ", "");
				idpvResponseDTO.setIdNumber(aadhaar);
				confidence += .4;
				continue;
			}

			// Detect DoB
			regex = ".*[0-3][0-9]/[0-1][0-9]/[1-2][0-9][0-9][0-9].*";
			if (Pattern.matches(regex, line)) {
				dob = line.toLowerCase().replaceAll(".*dob *:? *", "");
				dob = dob.replace("[^0-9/]", "");
				idpvResponseDTO.setDob(dob);
				confidence += .25;

				continue;
			}

			// Detect "Year of Birth" model aadhaar cards
			// line = "/Year of Birth: 1991"
			regex = ".*Year *of.*[1-2][0-9][0-9][0-9].*";
			String regex2 = "YoB.*[1-2][0-9][0-9][0-9].*";
			if (Pattern.matches(regex, line) || Pattern.matches(regex2, line)) {
				dob = line.toLowerCase().replaceAll(".*year *of *", "");
				String[] dobparts = dob.split(" ");
				dob = null;
				for (String dobpart : dobparts) {
					if (Pattern.matches("[1-2][0-9][0-9][0-9]", dobpart)) {
						dob = dobpart;
						break;
					}
				}
				if (dob == null || dob.length() != 4) {
					dob = null;
				} else {
					dob = "01/01/" + dob; // add 01-jan as day-month to the date
					idpvResponseDTO.setDob(dob);
					confidence += .25;
					continue;
				}
			}

			// Detect gender
			if (Pattern.matches(".*FEMALE.*", line)) {
				gender = "FEMALE";
				idpvResponseDTO.setGender(gender);
				confidence += .25;
			} else if (Pattern.matches(".*MALE.*", line)) {
				gender = "MALE";
				idpvResponseDTO.setGender(gender);
				confidence += .25;
			}

			// Any number is ignored after the above two
			regex = ".*[0-9].*";
			if (Pattern.matches(regex, line)) { // ignore
				continue;
			}

			// remove all non alpa and space
			regex = "[^A-Za-z ]";
			line = line.replaceAll(regex, "");
			if (line.contains("  ")) { // contains multiple spaces!!
				continue;
			}
			if (line.replace(" ", "").length() < 3) {
				// name can't be just 1 or 2 characters long
				continue;
			}

			// pure string after this
			// first line should be name
			if (name == null) {
				name = line;
				idpvResponseDTO.setIdName(name);
				continue;
			}
		}

		idpvResponseDTO.setConfidence(confidence);

		// All items parsed. Now lets see if every item is present
		idpvResponseDTO.setUsable(true);// default
		idpvResponseDTO.setRejectReason("");// default
		if (name == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason() + "Name not readable \n");
		}
		if (gender == null) {
			// Override to MALE, as it is common error and the segment is male
			// dominated.
			// If a female gets MALE classification, she can re-trigger scan.
			gender = "MALE";
			/*
			 * idpvResponseDTO.setUsable(false);
			 * idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason()
			 * + "Gender not readable \n");
			 */
		}
		if (aadhaar == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO
			.setRejectReason(idpvResponseDTO.getRejectReason() + "AADHAAR number not clearly readable \n");
		}
		if (dob == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO
			.setRejectReason(idpvResponseDTO.getRejectReason() + "Date of birth not clearly readable \n");
		}

		persistString(customerID, annotationText, idpvResponseDTO.isUsable(), "AADHAR");

		return idpvResponseDTO;
	}

	/***
	 * This method is used to read Aadhaar back
	 * 
	 * @param response
	 * @param customerID
	 * @return
	 */
	private IDPVResponseDTO detectAadharBack(AnnotateImageResponse response, int customerID) {
		float confidence = 0;
		IDPVResponseDTO idpvResponseDTO = null;

		if (response.hasError()) {
			System.out.println("Error: " + response.getError().getMessage());
			return null;
		}

		WebDetection wd = response.getWebDetection();
		// Check bestGuessLabels
		String[] matchStrings = { "unique identification authority of india", "uidai", "aadhaar", "download date",
		"generation date" };
		for (WebLabel label : wd.getBestGuessLabelsList()) {
			String labelStr = label.getLabel();
			if (labelStr != null && labelStr.trim().length() > 0) {
				labelStr = cleanStripString(labelStr);
				for (String ms : matchStrings) {
					if (labelStr.contains(ms)) {
						confidence += 0.2;
					}
				}
			}
		}
		// Check web entities
		List<WebEntity> webEntities = wd.getWebEntitiesList();
		for (WebEntity webEntity : webEntities) {
			float score = webEntity.getScore();
			String desc = webEntity.getDescription();
			if (desc != null && desc.trim().length() > 0) {
				desc = cleanStripString(desc);
				for (String ms : matchStrings) {
					if (desc.contains(ms) && score > 0.2) {
						confidence += score * 2;
					}
				}
			}
		}

		// Extract data from it.
		TextAnnotation fullTextAnnotation = response.getFullTextAnnotation();
		String annotationText = fullTextAnnotation.getText();
		// "भारतीय विशिष्ट पहचान प्राधिकरण\nUNIQUE IDENTIFICATION AUTHORITY OF
		// INDIA\nAADHAAR\nமுகவரி:\nதந்தை / தாய் பெயர்:\nதங்கராஜ், 285/2,
		// புதுநகர்,\nபுதுப்பாளையம்,\nஆலாம்பாளையம்,\nநாமக்கல்,\nதமிழ் நாடு -
		// 638008\nAddress:\nS/o: Thangaraj, 28552,\nPUDHUNAGAR,\nPUDHUPALAYAM,
		// Aampalayam,\nNamakkal,\nTamil Nadu - 638008\n2140 6711 8035\n"
		annotationText = annotationText.replaceAll("[^\\x00-\\x7F]", "");
		// "\nUNIQUE IDENTIFICATION AUTHORITY OF INDIA\nAADHAAR\n:\n / :\n,
		// 285/2, ,\n,\n,\n,\n - 638008\nAddress:\nS/o: Thangaraj,
		// 28552,\nPUDHUNAGAR,\nPUDHUPALAYAM, Aampalayam,\nNamakkal,\nTamil Nadu
		// - 638008\n2140 6711 8035\n"
		List<String> textComponents = new ArrayList<String>();
		String[] textSplit = annotationText.split("\n");
		String[] ignorePatterns = { "UNIQUE IDENTIFICATION AUTHORITY OF INDIA", "AADHAR", "Download Date",
		"Generation Date" };
		float toleranceMatch = 60;
		for (int i = 0; i < textSplit.length; i++) {
			String line = textSplit[i].trim(); // cleanStripString(textSplit[i]);
			if (line.length() == 0)
				continue;
			boolean ignoreMatched = false;
			for (int j = 0; j < ignorePatterns.length; j++) {
				float match = FLNameChecker.nameMatchPct(line, ignorePatterns[j]);
				if (match > toleranceMatch && Math.abs(line.length() - ignorePatterns[j].length()) < 5) {
					confidence += 0.2 * (match / 100);
					ignoreMatched = true;
					break;
				}
			}
			if (!ignoreMatched) {
				textComponents.add(line);
			}
		}

		idpvResponseDTO = new IDPVResponseDTO();
		idpvResponseDTO.setIdType("AADHAARBACK");
		idpvResponseDTO.setHumanFace(false);
		String aadhaar = null, address = "";
		boolean addressSeen = false;
		for (String line : textComponents) {
			// Detect AADHAAR
			String regex = "[0-9][0-9][0-9][0-9] *[0-9][0-9][0-9][0-9] *[0-9][0-9][0-9][0-9]";
			if (Pattern.matches(regex, line)) {
				aadhaar = line.replace("[^0-9]", "");
				aadhaar = aadhaar.replace(" ", "");
				idpvResponseDTO.setIdNumber(aadhaar);
				confidence += .4;
				continue;
			}

			// Detect pincode
			regex = ".*[1-9][0-9][0-9] *[0-9][0-9][0-9].*";
			if (Pattern.matches(regex, line)) {
				confidence += .8;
				log.info("PINCODE detected in aadhaar back image");
			}

			if (line.toLowerCase().contains("address")) {
				confidence += 0.4;
				addressSeen = true;
				continue;
			}

			boolean endDetected = false;
			if (addressSeen && line.trim().length() > 0) {
				String[] ignoreAllAfterThis = { "p.o.boxno.1947", "uidai.gov.in" };
				String linelower = line.toLowerCase().replace(" ", "");
				for (String ignorePat : ignoreAllAfterThis) { // "P.O. Box No.
					// 1947", "1947"
					if (linelower.contains(ignorePat)) {
						// Uidai footer has begun. Ignore all else
						endDetected = true;
						break;
					}
				}
				if (endDetected) {
					break;
				}

				String regex1 = ".*[a-zA-Z].*"; // Contains some english
				// character
				if (Pattern.matches(regex1, line)) {
					address += line.trim();
					if (!address.endsWith(",")) {
						address = address + ", ";
					}
				}
			}
		}

		idpvResponseDTO.setConfidence(confidence);
		if (addressSeen) {
			address = address.replaceAll(", $", "");
			idpvResponseDTO.setAddress(address.trim());
		}

		// All items parsed. Now lets see if every item is present
		idpvResponseDTO.setUsable(true);// default
		idpvResponseDTO.setRejectReason("");// default
		if (!addressSeen) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason() + "Address not readable \n");
		}
		if (aadhaar == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO
			.setRejectReason(idpvResponseDTO.getRejectReason() + "AADHAAR number not clearly readable \n");
		}

		persistString(customerID, annotationText, idpvResponseDTO.isUsable(), "AADHARB");

		return idpvResponseDTO;
	}

	/***
	 * This method is used to read PAN card
	 * 
	 * @param response
	 * @param customerID
	 * @return
	 */
	private IDPVResponseDTO detectPAN(AnnotateImageResponse response, int customerID) {
		float confidence = 0;
		IDPVResponseDTO idpvResponseDTO = null;

		if (response.hasError()) {
			System.out.println("Error: " + response.getError().getMessage());
			return null;
		}

		WebDetection wd = response.getWebDetection();
		// Check bestGuessLabels
		String[] matchStrings = { "pancard", "permanentaccountnumber", "pan" };
		for (WebLabel label : wd.getBestGuessLabelsList()) {
			String labelStr = label.getLabel();
			if (labelStr != null && labelStr.trim().length() > 0) {
				labelStr = cleanStripString(labelStr);
				for (String ms : matchStrings) {
					if (labelStr.contains(ms)) {
						confidence += 0.2;
					}
				}
			}
		}
		// Check web entities
		List<WebEntity> webEntities = wd.getWebEntitiesList();
		for (WebEntity webEntity : webEntities) {
			float score = webEntity.getScore();
			String desc = webEntity.getDescription();
			if (desc != null && desc.trim().length() > 0) {
				desc = cleanStripString(desc);
				for (String ms : matchStrings) {
					if (desc.contains(ms) && score > 0.4) {
						confidence += score;
					}
				}
			}
		}

		// PAN detected. Extract data from it.
		TextAnnotation fullTextAnnotation = response.getFullTextAnnotation();
		String annotationText = fullTextAnnotation.getText();
		// "आयकर विभाग\nINCOME TAX DEPARTMENT\nभारत सरकार\nGOVT. OF INDIA\n*\nET
		// PRADEEP\nTHANGARAJ\n211987\nPermanent Account
		// Number\nACPP2053N\n=\n2rs\n"
		annotationText = annotationText.replaceAll("[^\\x00-\\x7F]", "");
		// "\nINCOME TAX DEPARTMENT\n\nGOVT. OF INDIA\n*\nET
		// PRADEEP\nTHANGARAJ\n211987\nPermanent Account
		// Number\nACPP2053N\n=\n2rs\n"
		List<String> textComponents = new ArrayList<String>();
		String[] textSplit = annotationText.split("\n");
		String[] ignorePatterns = { "INCOME TAX DEPARTMENT", "GOVT. OF INDIA", "INCOME TAX DEPARTMENT GOVT. OF INDIA",
				"Permanent Account Number", "Permanent Account Number Card", "Name", "Fathers Name", "Date of Birth",
		"Signature" };
		float toleranceMatch = 60;
		for (int i = 0; i < textSplit.length; i++) {
			String line = textSplit[i].trim(); // cleanStripString(textSplit[i]);
			if (line.length() == 0)
				continue;
			boolean ignoreMatched = false;
			for (int j = 0; j < ignorePatterns.length; j++) {
				float match = FLNameChecker.nameMatchPct(line, ignorePatterns[j]);
				if (match > toleranceMatch && Math.abs(line.length() - ignorePatterns[j].length()) < 5) { // To
					// remove
					// "name"
					// matched
					// to
					// "aruN
					// sitarAM
					// shindE"!!!
					// and
					// the
					// like
					confidence += 0.2 * (match / 100);
					ignoreMatched = true;
				}
			}
			if (!ignoreMatched) {
				textComponents.add(line);
			}
		}

		idpvResponseDTO = new IDPVResponseDTO();
		idpvResponseDTO.setIdType("PAN");
		idpvResponseDTO.setHumanFace(false);
		String pan = null, name = null, fatherName = null, dob = null;
		for (String line : textComponents) {
			// Detect PAN
			String regex = "[A-Z][A-Z][A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][A-Z]";
			if (Pattern.matches(regex, line)) {
				pan = line;
				idpvResponseDTO.setIdNumber(pan);
				continue;
			}

			// Detect DoB
			regex = "[0-3][0-9]/[0-1][0-9]/[1-2][0-9][0-9][0-9]";
			if (Pattern.matches(regex, line)) {
				dob = line;
				idpvResponseDTO.setDob(dob);
				continue;
			}

			// Any number is ignored after the above two
			regex = ".*[0-9].*";
			if (Pattern.matches(regex, line)) { // ignore
				continue;
			}

			// remove all non alpa and space
			regex = "[^A-Za-z ]";
			line = line.replaceAll(regex, "");
			if (line.contains("  ")) { // contains multiple spaces!!
				continue;
			}
			if (line.replace(" ", "").length() < 3) {
				// name can't be just 1 or 2 characters long
				continue;
			}

			// pure string after this
			// first line should be name
			if (name == null) {
				name = line;
				idpvResponseDTO.setIdName(name);
				continue;
			}

			// second line should be father's name
			if (fatherName == null) {
				fatherName = line;
				idpvResponseDTO.setIdFatherName(fatherName);
				continue;
			}
		}

		idpvResponseDTO.setConfidence(confidence);

		// All items parsed. Now lets see if every item is present
		idpvResponseDTO.setUsable(true);// default
		idpvResponseDTO.setRejectReason("");// default
		if (name == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason() + "Name not readable \n");
		}
		if (fatherName == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason() + "Father Name not readable \n");
		}
		if (pan == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setRejectReason(idpvResponseDTO.getRejectReason() + "PAN number not clearly readable \n");
		}
		if (dob == null) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO
			.setRejectReason(idpvResponseDTO.getRejectReason() + "Date of birth not clearly readable \n");
		}

		persistString(customerID, annotationText, idpvResponseDTO.isUsable(), "PAN");

		return idpvResponseDTO;
	}

	/***
	 * This method is used to detect face from image
	 * 
	 * @param response
	 * @param customerID
	 * @return
	 */
	private IDPVResponseDTO detectFace(AnnotateImageResponse response, int customerID) {
		float confidence = 0;
		IDPVResponseDTO idpvResponseDTO = new IDPVResponseDTO();

		if (response.hasError()) {
			System.out.println("Error: " + response.getError().getMessage());
			return null;
		}

		int noOfFacesDetected = response.getFaceAnnotationsCount();
		if (noOfFacesDetected == 0) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setConfidence(0);
			idpvResponseDTO.setHumanFace(false);
			idpvResponseDTO.setIdType("SELFIE");
			idpvResponseDTO.setRejectReason("Face not detected");
			return idpvResponseDTO;
		}

		if (noOfFacesDetected > 1) {
			idpvResponseDTO.setUsable(false);
			idpvResponseDTO.setConfidence(0);
			idpvResponseDTO.setHumanFace(false);
			idpvResponseDTO.setIdType("SELFIE");
			idpvResponseDTO.setRejectReason("Multiple faces detected");
			return idpvResponseDTO;
		}

		String[] goodLabels = { "person", "face", "head", "forehead" };
		int matchCount = 0;
		List<EntityAnnotation> labelList = response.getLabelAnnotationsList();
		for (EntityAnnotation label : labelList) {
			String description = label.getDescription();
			float score = label.getScore();
			for (String goodLabel : goodLabels) {
				if (goodLabel.equalsIgnoreCase(description)) {
					matchCount++;
					confidence += score;
					break;
				}
			}
		}
		if (matchCount >= 2 && confidence >= 1) {
			idpvResponseDTO.setUsable(true);
			idpvResponseDTO.setHumanFace(true);
			idpvResponseDTO.setConfidence(confidence);
			idpvResponseDTO.setIdType("SELFIE");
			return idpvResponseDTO;
		}

		idpvResponseDTO.setUsable(false);
		idpvResponseDTO.setConfidence(confidence);
		idpvResponseDTO.setHumanFace(true);
		idpvResponseDTO.setIdType("SELFIE");
		idpvResponseDTO.setRejectReason("Face detected but low confidence");
		return idpvResponseDTO;

	}

	/***
	 * This method is used to remove space from string and change all char to
	 * LowerCase
	 * 
	 * @param string
	 * @return
	 */
	private String cleanStripString(String string) {
		return string.toLowerCase().replace(" ", "");
	}

	/***
	 * This method is used to store vision raw result in database
	 * 
	 * @param customerID
	 * @param annotation
	 * @param usable
	 * @param imgType
	 */
	private void persistString(int customerID, String annotation, boolean usable, String imgType) {
		VisionRawResult rawResult = new VisionRawResult();
		rawResult.setCustId(customerID);
		rawResult.setResult(CommonUtils.truncate(annotation, 199));
		rawResult.setIdType(imgType);
		rawResult.setUsable(usable);
		visionRaw.save(rawResult);
	}

}
