package in.fl.los.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlCustomerStateStatus;
import in.fl.los.model.VisionResults;
import in.fl.los.repository.CustomerRepository;
import in.fl.los.repository.VisionRepository;
import in.fl.los.request.IDPVRequestDTO;
import in.fl.los.response.IDPVResponseDTO;
import in.fl.los.util.CommonUtils;
import in.fl.los.util.WebConstants;

@Component
public class IDValidationServiceImpl implements IDValidationService {

//	@Autowired
//	private FileUploadService fileUploadService;

	@Autowired
	private ImageOCRService imageOCRService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VisionRepository visionRepository;

	private final Logger log = Logger.getLogger(IDValidationServiceImpl.class);

	/***
	 * This api is used to validate the images using OCR
	 * 
	 * @param idpvRequestDTO
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@Override
	public IDPVResponseDTO validatePic(IDPVRequestDTO idpvRequestDTO) throws Exception {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering IDValidationServiceImpl validatePic UPLIFT:" + idpvRequestDTO);

		FileUploadService fileUploadService = new FileUploadServiceImpl();
		String fileName = fileUploadService.saveFileToDisk(idpvRequestDTO.getImageContents(),
				idpvRequestDTO.getFileType(), idpvRequestDTO.getCustomerId(), "jpg");
		int customerID = Integer.parseInt(idpvRequestDTO.getCustomerId());

		int imgType = 1;
		switch (idpvRequestDTO.getFileType().toUpperCase()) {
		case "PAN":
			imgType = 1;
			break;
		case "AADHAAR":
			imgType = 2;
			break;
		case "AADHAARBACK":
			imgType = 3;
			break;
		case "SELFIE":
			imgType = 4;
			break;
		}
		byte[] imgData = idpvRequestDTO.getImageContents();
		IDPVResponseDTO response = imageOCRService.getImageData(imgData, imgType, customerID);

		if (response == null) {
			response = new IDPVResponseDTO();
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage(WebConstants.FAILURE_MSG);
		} else {
			UlCustomerDetails customerDetails = customerRepository.findById(customerID).get();
			UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
			if (response.getIdType().equals("PAN")) {
				if (response.isUsable()) {
					if (response.getIdNumber().trim().equalsIgnoreCase(customerDetails.getUserPan().trim())) {
						customerDetails.setUserPan(response.getIdNumber());
						customerDetails.setPanFirstName(response.getIdName());
						customerDetails.setPanLastName(response.getIdFatherName());

						customerStateStatus.setPanImageStatus(true);
						// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
						// "PANIMGSTS"));
					}
				}
			} else if (response.getIdType().equals("AADHAAR")) {
				if (response.isUsable()) {
					// customerDetails.setAadharNo(response.getIdNumber());
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date ddob = format.parse(response.getDob());

						// If dob is 1st jan, it may mean that AAdhaar is of
						// "Year of birth" format and hence doesn't have date
						// and month. Fill with PAN's values
						if (ddob.getDate() == 1 && ddob.getMonth() == 0) { // month
																			// range
																			// 0-11.
																			// January
																			// is
																			// 0
							// fetch day and month from PAN dob
							Date pandob = customerDetails.getDob();
							ddob.setDate(pandob.getDate());
							ddob.setMonth(pandob.getMonth());
						}
						response.setDob(format.format(ddob));

						// customerDetails.setAadharDob(ddob);
					} catch (ParseException e) {
						log.error("DOB parsing Failed", e);
					}
					// customerDetails.setAadharName(response.getIdName());
					// customerDetails.setAadharGender(response.getGender());
				}
				customerStateStatus.setPanImageStatus(true);
				// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
				// "POAFIMGSTS"));

			} else if (response.getIdType().equals("AADHAARBACK")) {
				if (!response.isUsable()
						&& response.getRejectReason().equals("AADHAAR number not clearly readable \n")) {
					// Barcode instead of aadhar number. Copy aadhar number from
					// previous scan and set usable to true
					response.setUsable(true);
					// response.setIdNumber(customerDetails.getAadharNo());
				}
				if (response.isUsable()) {
					// customerDetails.setAadharNo(response.getIdNumber());
					// customerDetails.setAadharAddress(response.getAddress());
				}
				// customerStateStatus.setPoaBackImageStatus(true);
				// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
				// "POABIMGSTS"));
			} else if (response.getIdType().equals("SELFIE")) {
				/*
				 * Ignore Incase of any failures while saving snapshots need to retake
				 */
				/*
				 * customerStateStatus.setSelfieStatus(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "SLFEIMGSTS"));
				 */
			}
			customerDetails.setCustomerStateStatus(customerStateStatus);
			customerRepository.save(customerDetails);

			saveOCRResponse(response, fileName, customerID);

			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
		}
		response.setRandom(idpvRequestDTO.getRandom());

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for get User IDValidationServiceImpl validatePic is ==>" + timeTaken);
		return response;
	}

	/***
	 * This method is used to save OCR response in database
	 * 
	 * @param response   IDPVResponseDTO
	 * @param fileName
	 * @param customerID
	 */
	private void saveOCRResponse(IDPVResponseDTO response, String fileName, int customerID) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering IDValidationServiceImpl saveOCRResponse UPLIFT");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		VisionResults visonResult = modelMapper.map(response, VisionResults.class);
		visonResult.setFileName(fileName);
		visonResult.setRejectReason(CommonUtils.truncate(visonResult.getRejectReason(), 75));
		String idType = visonResult.getIdType();
		switch (idType) {
		case "PAN":
			idType = "PAN";
			break;
		case "AADHAAR":
			idType = "AADHAARF";
			break;
		case "AADHAARBACK":
			idType = "AADHAARB";
			break;
		case "SELFIE":
			idType = "SELFIE";
			break;
		}
		visonResult.setIdType(idType);
		visonResult.setCustId(customerID);
		visionRepository.save(visonResult);
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for get User IDValidationServiceImpl saveOCRResponse is ==>" + timeTaken);
	}

}
