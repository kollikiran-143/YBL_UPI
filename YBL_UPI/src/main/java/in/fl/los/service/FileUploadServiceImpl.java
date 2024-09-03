package in.fl.los.service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlCustomerStateStatus;
import in.fl.los.repository.ConfigRepository;
import in.fl.los.repository.CustomerRepository;
import in.fl.los.request.FileUploadRequestDTO;
import in.fl.los.request.IDPVRequestDTO;
import in.fl.los.response.BSResponseDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.CompareTwoFacesResponse;
import in.fl.los.response.IDPVResponseDTO;
import in.fl.los.util.CommonUtils;
import in.fl.los.util.WebConstants;

@Component
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	private CustomerLocationService customerLocationService;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AwsS3ServiceImpl awsS3ServiceImpl;
	
	@Autowired
	private IDValidationService idValidationService; 
	
	@Autowired
	ImageVerificationService imageVerificationService;
	
	@Autowired
	private ConfigRepository configRepository;
	
	@Value("${s3.bucket.name}")
	private String s3BucketName;

	@Value("${s3.access.key.id}")
	private String s3AccessKeyID;

	@Value("${s3.secret.access.key}")
	private String s3SecretAccessKey;

	private final Logger log = Logger.getLogger(FileUploadServiceImpl.class);

	/***
	 * This api is used to save file
	 * 
	 * @param fileUploadRequestDTO
	 * @return
	 * @throws IOException VKYC PAN INTERIOR NAMEBOARD FRONT OWNERSHIP HOME QR1 QR2
	 *                     QR3
	 */
	@Override
	public IDPVResponseDTO saveFile(FileUploadRequestDTO fileUploadRequestDTO) throws IOException {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering FileUploadServiceImpl saveFile UPLIFT:" + fileUploadRequestDTO);
		String fileType = fileUploadRequestDTO.getFileType();
		String fileExtension = "jpg";
		if(fileUploadRequestDTO.getFileExtension()!=null && !fileUploadRequestDTO.getFileExtension().equals("")) {
			fileExtension = fileUploadRequestDTO.getFileExtension();
		}
		int custId = Integer.parseInt(fileUploadRequestDTO.getCustomerId());
		UlCustomerDetails customerDetails = customerRepository.findById(custId).get();
		UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
		
		byte[] fileBytes = DatatypeConverter.parseBase64Binary(fileUploadRequestDTO.getFileData());

		IDPVResponseDTO response = new IDPVResponseDTO();
		IDPVRequestDTO idpvRequestDTO = new IDPVRequestDTO();
		idpvRequestDTO.setCustomerId(fileUploadRequestDTO.getCustomerId());
		idpvRequestDTO.setImageContents(fileBytes);
		try {
			if (fileType.equalsIgnoreCase("VKYC")) {
				/*
				 * saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(),
				 * "mp4"); response.setUsable(true); customerStateStatus.setVkycImage(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "VKYCI"));
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "VKYCIS")); customerStateStatus.setVkycStatus(true);
				 * ModelMapper modelMapper = new ModelMapper(); CustomerLocationLog
				 * customerLocationLog =
				 * modelMapper.map(fileUploadRequestDTO.getLocationRequestDTO(),
				 * CustomerLocationLog.class);
				 * customerLocationLog.setCustomerDetails(customerDetails);
				 * customerLocationLog.setEventType("VKYC");
				 * customerLocationLog.setCreateTime(new Date());
				 * customerLocationLog.setUpdateTime(new Date());
				 * customerDetails.getCustomerLocationLog().add(customerLocationLog);
				 */
			} else if (fileType.equalsIgnoreCase("PAN")) {
				idpvRequestDTO.setFileType("PAN");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setPanImageStatus(true);
				try {
					response = idValidationService.validatePic(idpvRequestDTO);
					response.setUsable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
				// "PANIMG"));
			} else if (fileType.equalsIgnoreCase("SELFIE")) {

				/*
				 * idpvRequestDTO.setFileType("SELFIE"); response =
				 * idValidationService.validatePic(idpvRequestDTO); String[] olderVerSnapShots =
				 * fileUploadRequestDTO.getExtraFiles(); if(olderVerSnapShots != null){ for (int
				 * i=0; i<olderVerSnapShots.length; i++) { byte[] imageBytes =
				 * DatatypeConverter.parseBase64Binary(olderVerSnapShots[i]);
				 * saveFileToDisk(imageBytes, "SNAP_SHOT_" + (i + 1)
				 * ,fileUploadRequestDTO.getCustomerId(), "jpg"); } } SnapShotMetaDataDetails[]
				 * selfieSnapShots = fileUploadRequestDTO.getExtraFileDetails();
				 * if(selfieSnapShots != null){ for (int i=0; i<selfieSnapShots.length; i++) {
				 * int frameOrder = selfieSnapShots[i].getFrameOrder(); byte[] imageBytes =
				 * DatatypeConverter.parseBase64Binary(selfieSnapShots[i].getPhotoData());
				 * String snapShotName = "SNAP_SHOT_" + (i + 1) + "_" + (frameOrder) + "_" +
				 * selfieSnapShots[i].getDayMillis(); String fileName =
				 * saveFileToDisk(imageBytes, snapShotName,fileUploadRequestDTO.getCustomerId(),
				 * "jpg"); SelfieSnapshotDetails selfieSnapshotDetails = new
				 * SelfieSnapshotDetails(); ModelMapper modelMapper = new ModelMapper(); Gson
				 * gson = new Gson(); selfieSnapshotDetails =
				 * modelMapper.map(selfieSnapShots[i], SelfieSnapshotDetails.class);
				 * selfieSnapshotDetails.setCustId(custId);
				 * selfieSnapshotDetails.setOrderId((short)(i + 1));
				 * selfieSnapshotDetails.setConFace(gson.toJson(selfieSnapShots[i].getConFace())
				 * ); selfieSnapshotDetails.setConLeftEye(gson.toJson(selfieSnapShots[i].
				 * getConLeftEye()));
				 * selfieSnapshotDetails.setConLeftEyebrowBottom(gson.toJson(selfieSnapShots[i].
				 * getConLeftEyebrowBottom()));
				 * selfieSnapshotDetails.setConLeftEyebrowTop(gson.toJson(selfieSnapShots[i].
				 * getConLeftEyebrowTop()));
				 * selfieSnapshotDetails.setConLowerLipBottom(gson.toJson(selfieSnapShots[i].
				 * getConLowerLipBottom()));
				 * selfieSnapshotDetails.setConLowerLipTop(gson.toJson(selfieSnapShots[i].
				 * getConLowerLipTop()));
				 * selfieSnapshotDetails.setConNoseBottom(gson.toJson(selfieSnapShots[i].
				 * getConNoseBottom()));
				 * selfieSnapshotDetails.setConNoseBridge(gson.toJson(selfieSnapShots[i].
				 * getConNoseBridge()));
				 * selfieSnapshotDetails.setConRightEye(gson.toJson(selfieSnapShots[i].
				 * getConRightEye()));
				 * selfieSnapshotDetails.setConRightEyebrowBottom(gson.toJson(selfieSnapShots[i]
				 * .getConRightEyebrowBottom()));
				 * selfieSnapshotDetails.setConRightEyebrowTop(gson.toJson(selfieSnapShots[i].
				 * getConRightEyebrowTop()));
				 * selfieSnapshotDetails.setConUpperLipBottom(gson.toJson(selfieSnapShots[i].
				 * getConUpperLipBottom()));
				 * selfieSnapshotDetails.setConUpperLipTop(gson.toJson(selfieSnapShots[i].
				 * getConUpperLipTop())); gson = new GsonBuilder() .serializeNulls()
				 * .addSerializationExclusionStrategy(new ExclusionStrategy() {
				 * 
				 * @Override public boolean shouldSkipField(FieldAttributes f) { return
				 * f.getName().equals("photoData"); }
				 * 
				 * @Override public boolean shouldSkipClass(Class<?> aClass) { return false; }
				 * }) .create(); String imageJson = gson.toJson(selfieSnapShots[i]);
				 * selfieSnapshotDetails.setImageData(imageJson);
				 * selfieSnapshotDetails.setImageName(fileName); String userFilePath =
				 * String.format("%03d", custId % 1000) + "/" + custId + "/"; String s3Folder =
				 * "/FRNDLN/ImageFiles/" + userFilePath;
				 * selfieSnapshotDetails.setImageLocation(s3Folder);
				 * selfieSnapshotDetailsRepository.save(selfieSnapshotDetails); } }
				 * //if(response.isUsable()){ customerStateStatus.setSelfieStatus(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "SLFEIMGSTS")); //}
				 * customerStateStatus.setSelfieImage(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "SELFIEIMG"));
				 */
			} else if (fileType.equalsIgnoreCase("POAF")) {
				/*
				 * if
				 * (fileUploadRequestDTO.getExtraData().trim().equalsIgnoreCase("Aadhaar card"))
				 * { idpvRequestDTO.setFileType("AADHAAR"); response =
				 * idValidationService.validatePic(idpvRequestDTO); } else {
				 * saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(),
				 * "jpg"); customerStateStatus.setPoaFrontImageStatus(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "POAFIMGSTS")); response.setUsable(true); }
				 * customerDetails.setPoaType(fileUploadRequestDTO.getExtraData());
				 * customerStateStatus.setPoaFrontImage(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "POAFIMG"));
				 */
			} else if (fileType.equalsIgnoreCase("POAB")) {
				/*
				 * if
				 * (fileUploadRequestDTO.getExtraData().trim().equalsIgnoreCase("Aadhaar card"))
				 * { idpvRequestDTO.setFileType("AADHAARBACK"); response =
				 * idValidationService.validatePic(idpvRequestDTO); } else {
				 * saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(),
				 * "jpg"); customerStateStatus.setPoaBackImageStatus(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "POABIMGSTS")); response.setUsable(true); }
				 * customerDetails.setPoaType(fileUploadRequestDTO.getExtraData());
				 * customerStateStatus.setPoaBackImage(true);
				 * customerDetails.getStateStatus().add(CommonUtils.getStateObject(
				 * customerDetails, "POABIMG"));
				 */
			} else if (fileType.equalsIgnoreCase("LAPPLY")) {

				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
				// "LAPPLYIMG"));
				response.setUsable(true);

			} else if (fileType.equalsIgnoreCase("AGMNTOTPESIGN")) {

				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				// customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails,
				// "AGTOESIGNI"));
				response.setUsable(true);

			} else if (fileType.equalsIgnoreCase("OKYC")) {
				/*
				 * UploadOKYCDocRequestDTO uploadOKYCDocRequestDTO = new
				 * UploadOKYCDocRequestDTO();
				 * uploadOKYCDocRequestDTO.setAadhaarNo(fileUploadRequestDTO.getExtraData());
				 * uploadOKYCDocRequestDTO.setFileData(fileUploadRequestDTO.getFileData());
				 * uploadOKYCDocRequestDTO.setCustomerId(fileUploadRequestDTO.getCustomerId());
				 * uploadOKYCDocRequestDTO.setAppName(fileUploadRequestDTO.getAppName());
				 * uploadOKYCDocRequestDTO.setImei(fileUploadRequestDTO.getImei());
				 * uploadOKYCDocRequestDTO.setPhoneNumber(fileUploadRequestDTO.getPhoneNumber())
				 * ; uploadOKYCDocRequestDTO.setRandom(fileUploadRequestDTO.getRandom());
				 * uploadOKYCDocRequestDTO.setRequestCreatedAt(fileUploadRequestDTO.
				 * getRequestCreatedAt());
				 * uploadOKYCDocRequestDTO.setVersion(fileUploadRequestDTO.getVersion());
				 * BaseResponseDTO uploadOKYCDocResponse =
				 * kycService.uploadOKYCDoc(uploadOKYCDocRequestDTO);
				 * response.setStatusCode(uploadOKYCDocResponse.getStatusCode());
				 * response.setStatusMessage(uploadOKYCDocResponse.getStatusMessage());
				 */
			} else if (fileType.equalsIgnoreCase("INTERIOR")) {
				idpvRequestDTO.setFileType("INTERIOR");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setInteriorImageStatus(true);
			} else if (fileType.equalsIgnoreCase("NAMEBOARD")) {
				idpvRequestDTO.setFileType("NAMEBOARD");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setBoardImageStatus(true);
			} else if (fileType.equalsIgnoreCase("FRONT")) {
				idpvRequestDTO.setFileType("FRONT");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setFrontImageStatus(true);
			} else if (fileType.equalsIgnoreCase("HOME")) {
				idpvRequestDTO.setFileType("HOME");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setHomeImageStatus(true);
			} else if (fileType.equalsIgnoreCase("QR1")) {
				idpvRequestDTO.setFileType("QR1");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQr1ImageStatus(true);
			} else if (fileType.equalsIgnoreCase("QR2")) {
				idpvRequestDTO.setFileType("QR2");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQr2ImageStatus(true);
			} else if (fileType.equalsIgnoreCase("QR3")) {
				idpvRequestDTO.setFileType("QR3");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQr3ImageStatus(true);
			} else if (fileType.equalsIgnoreCase("CUSTOMER")) {
				idpvRequestDTO.setFileType("CUSTOMER");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setSelfieImageStatus(true);
				//Compare Customer photo with Aadhaar Photo			
				try {
					String VerifyRes = verifyCustPhotWithAddhaarPhoto(Integer.parseInt(fileUploadRequestDTO.getCustomerId()), "AADHAAR_PIC", fileBytes);				
					if(VerifyRes.equals("Match")){
						log.info("FileUploadServiceImpl : Customer Photo Matched with Aadhar Photo");
					}else {
						customerStateStatus.setSelfieImageStatus(false);
						log.info("FileUploadServiceImpl : Customer Photo Mismatch with Aadhar Photo");
					}
				} catch (Exception e) {
					log.error("FileUploadServiceImpl : Customer photo comparison with aadhaar Photo exception" ,e);
				}				
				
			} else if (fileType.equalsIgnoreCase("RATION_CARD")) {
				idpvRequestDTO.setFileType("RATION_CARD");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setRationcardImageStatus(true);
			} else if (fileType.equalsIgnoreCase("GAS_BILL")) {
				idpvRequestDTO.setFileType("GAS_BILL");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setGasbillImageStatus(true);
			} else if (fileType.equalsIgnoreCase("OWNERSHIP")) {
				idpvRequestDTO.setFileType("OWNERSHIP");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setOwnershipStatus(true);
			} else if (fileType.equalsIgnoreCase("ATTENDANCE")) {
				idpvRequestDTO.setFileType(fileType);
				saveSelfieImage(fileBytes, fileType, fileUploadRequestDTO.getAgentId(), "jpg");
			} else if (fileType.equalsIgnoreCase("PAYTM_MERCHANT_UPI_TRANS")) {
				idpvRequestDTO.setFileType("PAYTM_MERCHANT_UPI_TRANS");
				int cnt = customerStateStatus.getQrpayPaytmmerchPhcnt() + 1;
				customerStateStatus.setQrpayPaytmmerchPhcnt(cnt);
				customerStateStatus.setQrpayPaytmmerchPhstatus(true);
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			} else if (fileType.equalsIgnoreCase("GPAY_MERCHANT_UPI_TRANS")) {
				idpvRequestDTO.setFileType("GPAY_MERCHANT_UPI_TRANS");
				int cnt = customerStateStatus.getQrpayGpaymerchPhcnt() + 1;
				customerStateStatus.setQrpayGpaymerchPhcnt(cnt);
				customerStateStatus.setQrpayGpaymerchPhstatus(true);
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			} else if (fileType.equalsIgnoreCase("PHONEPE_MERCHANT_UPI_TRANS")) {
				idpvRequestDTO.setFileType("PHONEPE_MERCHANT_UPI_TRANS");
				int cnt = customerStateStatus.getQrpayPhonepemerchPhcnt() + 1;
				customerStateStatus.setQrpayPhonepemerchPhcnt(cnt);
				customerStateStatus.setQrpayPhonepemerchPhstatus(true);
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			} else if (fileType.equalsIgnoreCase("BHARATPE_MERCHANT_UPI_TRANS")) {
				idpvRequestDTO.setFileType("BHARATPE_MERCHANT_UPI_TRANS");
				int cnt = customerStateStatus.getQrpayBharatpemerchPhcnt() + 1;
				customerStateStatus.setQrpayBharatpemerchPhcnt(cnt);
				customerStateStatus.setQrpayBharatpemerchPhstatus(true);
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			}else if(fileType.equalsIgnoreCase("GPAY_DOC")) {
				idpvRequestDTO.setFileType("GPAY_DOC");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				customerStateStatus.setQrpayGpayDoc(true);
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			}else if(fileType.equalsIgnoreCase("PHONEPE_DOC")) {
				idpvRequestDTO.setFileType("PHONEPE_DOC");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				customerStateStatus.setQrpayPhonepeDoc(true);
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			}else if(fileType.equalsIgnoreCase("BHARATPE_DOC")) {
				idpvRequestDTO.setFileType("BHARATPE_DOC");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				customerStateStatus.setQrpayBharatpeDoc(true);
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			}else if(fileType.equalsIgnoreCase("PAYTM_DOC")) {
				idpvRequestDTO.setFileType("PAYTM_DOC");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				customerStateStatus.setQrpayPaytmDoc(true);
				if(!customerDetails.isManualCreditFlag()) {
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			}else if(fileType.equalsIgnoreCase("BANK_STMNT_DOC")) {
				idpvRequestDTO.setFileType("BANK_STMNT_DOC");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
				customerStateStatus.setStmntDocStatus(true);
				if(!customerDetails.isManualCreditFlag()) {
					customerStateStatus.setMosStatus(false);
					customerStateStatus.setManualdocTxnStatus(false);
					customerDetails.setLeadStatus("MOS_WAIT");
					customerDetails.getStateStatus().add(CommonUtils.getStateObject(customerDetails, "MOS_WAIT"));
				}
			} else if (fileType.equalsIgnoreCase("QRPAY_GPAY_BANKLIST")) {				
				idpvRequestDTO.setFileType("QRPAY_GPAY_BANKLIST");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayGpayBanklist(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_GPAY_PROFILE")) {				
				idpvRequestDTO.setFileType("QRPAY_GPAY_PROFILE");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayGpayProfile(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_GPAY_BANKDETAILS")) {				
				idpvRequestDTO.setFileType("QRPAY_GPAY_BANKDETAILS");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayGpayBankdetails(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PHONEPE_BANKLIST")) {				
				idpvRequestDTO.setFileType("QRPAY_PHONEPE_BANKLIST");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPhonepeBanklist(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PHONEPE_PROFILE")) {				
				idpvRequestDTO.setFileType("QRPAY_PHONEPE_PROFILE");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPhonepeProfile(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PHONEPE_BANKDETAILS")) {				
				idpvRequestDTO.setFileType("QRPAY_PHONEPE_BANKDETAILS");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPhonepeBankdetails(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PAYTM_BANKLIST")) {				
				idpvRequestDTO.setFileType("QRPAY_PAYTM_BANKLIST");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPaytmBanklist(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PAYTM_PROFILE")) {							
				idpvRequestDTO.setFileType("QRPAY_PAYTM_PROFILE");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPaytmProfile(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_PAYTM_BANKDETAILS")) {				
				idpvRequestDTO.setFileType("QRPAY_PAYTM_BANKDETAILS");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayPaytmBankdetails(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_BHARATPE_BANKLIST")) {				
				idpvRequestDTO.setFileType("QRPAY_BHARATPE_BANKLIST");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayBharatpeBanklist(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_BHARATPE_PROFILE")) {				
				idpvRequestDTO.setFileType("QRPAY_BHARATPE_PROFILE");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayBharatpeProfile(true);
			} else if (fileType.equalsIgnoreCase("QRPAY_BHARATPE_BANKDETAILS")) {				
				idpvRequestDTO.setFileType("QRPAY_BHARATPE_BANKDETAILS");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setQrpayBharatpeBankdetails(true);
			} else if (fileType.equalsIgnoreCase("BILL_BOOK")) {
				idpvRequestDTO.setFileType("BILL_BOOK");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setBillbookImage(true);
			} else if (fileType.equalsIgnoreCase("EB_BILL")) {				
				idpvRequestDTO.setFileType("EB_BILL");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
				customerStateStatus.setEbbillImage(true);
			} else if (fileType.equalsIgnoreCase("FI_INTERIOR")) {				
				idpvRequestDTO.setFileType("FI_INTERIOR");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
			} else if (fileType.equalsIgnoreCase("FI_EXTERIOR")) {				
				idpvRequestDTO.setFileType("FI_EXTERIOR");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
			} else if (fileType.equalsIgnoreCase("FI_ADDRESS_PROOF")) {				
				idpvRequestDTO.setFileType("FI_ADDRESS_PROOF");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
			} else if (fileType.equalsIgnoreCase("FI_STREET_NAME")) {				
				idpvRequestDTO.setFileType("FI_STREET_NAME");
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), "jpg");
			} else {// Upload Files without updating the flag
				idpvRequestDTO.setFileType(fileType);
				saveFileToDisk(fileBytes, fileType, fileUploadRequestDTO.getCustomerId(), fileExtension);
			}

			fileUploadRequestDTO.getLocationRequestDTO().setEventType(fileType);			
			customerLocationService.saveCustomerLocationLog(fileUploadRequestDTO);

			if (!fileType.equalsIgnoreCase("OKYC")) {
				response.setStatusCode(WebConstants.SUCCESS_CODE);
				response.setStatusMessage(WebConstants.SUCCESS_MSG);
			}
			if (fileType.equalsIgnoreCase("CUSTOMER")) {
				if(customerStateStatus.isSelfieImageStatus()) {
					response.setStatusCode(WebConstants.SUCCESS_CODE);
					response.setStatusMessage(WebConstants.SUCCESS_MSG);
				}else {
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage("Customer Photo Mismatch!!!");
				}
			}
			
			if(fileType.equalsIgnoreCase("NAMEBOARD")) {
				if(customerDetails != null) {
					if(fileUploadRequestDTO.getLocationRequestDTO() != null ) {
					customerDetails.setBusinessLatitude(fileUploadRequestDTO.getLocationRequestDTO().getLatitude());
					customerDetails.setBusinessLongitude(fileUploadRequestDTO.getLocationRequestDTO().getLongitude());
					}
				}
			}
			
			customerDetails.setCustomerStateStatus(customerStateStatus);
			customerRepository.save(customerDetails);
		} catch (Exception e) {
			log.error("Exeception occured in file save: " + e);
			e.printStackTrace();
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage(WebConstants.FAILURE_MSG);
		}

		response.setRandom(fileUploadRequestDTO.getRandom());

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for get User FileUploadServiceImpl saveFile is ==>" + timeTaken);
		return response;
	}

	private String verifyCustPhotWithAddhaarPhoto(int custId, String photoName, byte[] fileBytes) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("FileUploadServiceImpl  verifyCustPhotWithAddhaarPhoto:" + custId +","+ photoName);
		String response = "Server Error";
		String thresholdStr  = "50";
		thresholdStr = configRepository.findByconfigKey(WebConstants.CUSTPHOTO_MATCH_THRESHOLD).getConfigValue();
		float threshold = Float.parseFloat(thresholdStr);
		try {
			String photoData = getCustPhoto(custId, photoName);
			
			if(!photoData.equals("")) {
				byte[] photoBytes = DatatypeConverter.parseBase64Binary(photoData);
				CompareTwoFacesResponse compResp = imageVerificationService.compare(photoBytes, fileBytes);
				
				if(compResp.getTargetFaceCount()==1) {
					log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto CompareTwoFacesResponse :" + compResp );
					if(compResp.getMatchPercetage()>threshold) {
						response = "Match";
					}else {
						response = "Mismatch";
					}
				}else {
					if(compResp.getTargetFaceCount()<1) {
						response = "No Face";
					}else {
						response = "Multiple Faces";
					}
				}
			}else { //Photo Not Found
				log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto no Search Photo, returning match");
				response = "Match";
			}
		} catch (Exception e) {
			log.error("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhotoError in verifiying selfie!:",e);
			response = "Server Error";
		}
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto: Time Taken =>" + timeTaken+" Response :" + response);
		return response;
	}

	/***
	 * This api is used to save file in disk
	 * 
	 * @param fileContents
	 * @param fileType
	 * @param customerId
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	@Override
	public String saveStamentJson(BSResponseDTO bsResponseDTO, int custId)
			throws JsonGenerationException, JsonMappingException, IOException {
		DateFormat collectionDateFormat = new SimpleDateFormat("yyyy-MM-dd'_'HH:mm:ss");
		Calendar calendar = new GregorianCalendar();
		String currentDate = collectionDateFormat.format(calendar.getTime());

		String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
		String s3Folder = userFilePath;
		String fileName = custId + "_txn_" + currentDate + ".json";

		ObjectMapper mapper = new ObjectMapper();
		byte[] fileContents = mapper.writeValueAsBytes( bsResponseDTO);

		String s3FileName = s3Folder + fileName;
		awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, "json");
		
		log.info("Statement File for Customer : " + custId + " File Name : " + fileName);
		return fileName;
	}

	/***
	 * This api is used to save the statement JSON in file
	 * 
	 * @param bsResponseDTO
	 * @param custId
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Override
	public String saveFileToDisk(byte[] fileContents, String fileType, String customerId, String extension)
			throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
			String s3Folder = userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;

			String s3FileName = s3Folder + fileDetails;
			awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, extension);

		}
		return fileDetails;
	}
	@Override
	public String saveFileToDiskOld(byte[] fileContents, String fileType, String customerId, String extension)
			throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileName = "";
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
			String filePath = "/FRNDLN/ImageFiles_EBS/" + userFilePath;
			String s3Folder = "/FRNDLN/ImageFiles/" + userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;

			fileName = filePath + fileDetails;
			File finalFile = new File(fileName);
			log.info("saveFile File Name:" + finalFile);
			Path path = Paths.get(filePath);
			Path s3FilePath = Paths.get(s3Folder);

			// creating structured folders if doesn't exist
			if (!Files.exists(path)) {
				Files.createDirectories(path);
				Files.createDirectories(s3FilePath);
			}

			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				fos.write(fileContents);
				fos.close();
			} catch (Exception e) {
				log.error("Error writing img file to EBS disk", e);
			}

			String s3FileName = s3Folder + fileDetails;
			Files.copy(Paths.get(fileName), Paths.get(s3FileName));
		}
		return fileDetails;
	}

	/***
	 * This api is used to save the statement JSON in file
	 * 
	 * @param bsResponseDTO
	 * @param custId
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Override
	public String saveFileToDiskWithUnderScore(byte[] fileContents, String fileType, String customerId,
			String extension) throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
			String s3Folder = userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;

			String s3FileName = s3Folder + fileDetails;
			awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, extension);
		}
		return fileDetails;
	}
	
	@Override
	public String saveFileToDiskInFolder(byte[] fileContents, String fileType, String customerId,
			String extension, String folder) throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/" +folder+ "/";
			String s3Folder = userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;

			String s3FileName = s3Folder + fileDetails;
			awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, extension);
		}
		return fileDetails;
	}
	@Override
	public String savePayload(String payload, String folder, String name, String extension) {

		log.info("entering savePayload : ");
		long startTimeInMillis = System.currentTimeMillis();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss.SSS");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = now.format(formatter);

		String s3Folder = folder + "/";
		String fileName = name + currentDate + "." + extension;

		byte[] fileContents = payload.getBytes();
		String s3FileName = s3Folder + fileName;
		awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, extension);

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for savePayload is ==>" + timeTaken);

		return fileName;

	}

	/***
	 * 
	 */
	/*
	@Override
	public String unZip(String fileName, String customerId, String password) throws Exception {
		int custId = Integer.parseInt(customerId);
		String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
		String cleanFileName = fileName.replace("'", "");
		cleanFileName = cleanFileName.replace(" ", "_");
		String zipFolder = cleanFileName.substring(0, cleanFileName.length() - 4);
		String filePath = "/FRNDLN/ImageFiles_EBS/" + userFilePath;
		String s3Folder = "/FRNDLN/ImageFiles/" + userFilePath;
		String zipFilePath = filePath + zipFolder;
		String zipS3FilePath = s3Folder + zipFolder;

		String sourceFile = filePath + fileName;
		Path path = Paths.get(filePath);
		Path s3FilePath = Paths.get(s3Folder);
		// creating structured folders if doesn't exist
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			Files.createDirectories(s3FilePath);
		}
		ZipFile zipFile = new ZipFile(sourceFile);
		if (zipFile.isEncrypted()) {
			zipFile.setPassword(password);
		}
		zipFile.extractAll(zipFilePath);
		Files.copy(Paths.get(zipFilePath), Paths.get(zipS3FilePath));
		File sourceFolder = new File(zipFilePath);
		File destinationFolder = new File(zipS3FilePath);
		copyFolder(sourceFolder, destinationFolder);
		// zipFile.extractAll(zipS3Folder);
		return zipFilePath;
	}
	*/

	/**
	 * This function recursively copy all the sub folder and files from sourceFolder
	 * to destinationFolder
	 */
	/*
	public void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
		// Check if sourceFolder is a directory or file
		// If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory()) {
			// Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists()) {
				destinationFolder.mkdir();
				System.out.println("Directory created :: " + destinationFolder);
			}

			// Get all files from source directory
			String files[] = sourceFolder.list();

			// Iterate over all files and copy them to destinationFolder one by one
			for (String file : files) {
				File srcFile = new File(sourceFolder, file);
				File destFile = new File(destinationFolder, file);

				// Recursive function call
				copyFolder(srcFile, destFile);
			}
		} else {
			// Copy the file content from one place to another
			Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File copied :: " + destinationFolder);
		}
	}
	*/
	
	/***
	 * This api is used to save file in s3 using aws sdk
	 * 
	 * @param fileContents
	 * @param fileType
	 * @param customerId
	 * @param extension
	 * @return
	 * @throws Exception
	 */
	@Override
	public String saveFileToS3(byte[] fileContents, String fileType, String customerId, String extension)
			throws Exception {
		Regions clientRegion = Regions.AP_SOUTH_1;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileName = "";
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {
			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
			String s3Folder = "/FRNDLN/ImageFiles/" + userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;
			fileName = s3Folder + fileDetails;
			BasicAWSCredentials awsCreds = new BasicAWSCredentials(s3AccessKeyID, s3SecretAccessKey);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion)
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
			InputStream stream = new ByteArrayInputStream(fileContents);
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(fileContents.length);
			meta.setContentType("image/*");

			s3Client.putObject(new PutObjectRequest(s3BucketName, fileName, stream, meta)
					.withCannedAcl(CannedAccessControlList.Private));

			stream.close();

		}
		return fileDetails;
	}

	/***
	 * 
	 * @param custId
	 * @param imgType
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getCustImage(int custId, String imgType) throws Exception {
		String imageData = "";
		String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
		String custFileLoc = "/FRNDLN/ImageFiles/" + userFilePath;
		File dir = new File(custFileLoc);
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String fileName) {
				return fileName.toLowerCase().contains(imgType);
			}
		});
		long lastMod = Long.MIN_VALUE;
		File image = null;
		if (files != null) {
			for (File file : files) {
				if (file.lastModified() > lastMod) {
					image = file;
					lastMod = file.lastModified();
				}
			}
		}
		if (image != null) {
			byte[] bytes = loadFile(image);
			byte[] encoded = Base64.encode(bytes);
			imageData = new String(encoded);
		}
		return imageData;
	}

	@Override
	public String getSelfie(String agentId, String imgType) throws Exception {
		String imageData = "";
		String userFilePath = agentId;
		String custFileLoc = "/FRNDLN/ImageFiles/UPLIFT/ATTENDANCE/" + userFilePath + "/";
		log.info("getSelfie =>" + custFileLoc);
		File dir = new File(custFileLoc);
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String fileName) {
				return fileName.contains(imgType);
			}
		});
		long lastMod = Long.MIN_VALUE;
		File image = null;
		if (files != null) {
			for (File file : files) {

				if (file.lastModified() > lastMod) {
					image = file;
					lastMod = file.lastModified();
				}
			}
		}
		if (image != null) {
			byte[] bytes = loadFile(image);
			byte[] encoded = Base64.encode(bytes);
			imageData = new String(encoded);
		}
		return imageData;
	}
	
	@Override
	public String getFirstSelfie(String agentId, String imgType) throws Exception {
		String imageData = "";
		String userFilePath = agentId;
		String custFileLoc = "/FRNDLN/ImageFiles/UPLIFT/ATTENDANCE/" + userFilePath + "/";
		log.info("getFirstSelfie =>" + custFileLoc);
		File dir = new File(custFileLoc);
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String fileName) {
				return fileName.contains(imgType);
			}
		});
		long firstFileTime = System.currentTimeMillis();
		File image = null;
		if (files != null) {
			for (File file : files) {
				
				if (file.lastModified() < firstFileTime) {
					image = file;
					firstFileTime = file.lastModified();
				}
			}
		}
		if (image != null) {
			log.info("found Image :"+image.getPath());
			byte[] bytes = loadFile(image);
			byte[] encoded = Base64.encode(bytes);
			imageData = new String(encoded);
		}
		return imageData;
	}

	/***
	 * This method is used to fetch file from path
	 * 
	 * @param file
	 * @return bytes
	 * @throws IOException
	 */
	private byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		is.close();
		return bytes;
	}

	@Override
	public BaseResponseDTO saveVideo(String videoType, MultipartFile file, String customerId) throws IOException {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering FileUploadServiceImpl uploadVideo UPLIFT:" + customerId);
		int custId = Integer.parseInt(customerId);
		UlCustomerDetails customerDetails = customerRepository.findById(custId).get();
		UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
		BaseResponseDTO response = new BaseResponseDTO();
		
		if (videoType == null || videoType.equalsIgnoreCase("")) {
			videoType = "SHOP";
		}
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String fileName = "";
		String strDate = sdfDate.format(now);

		if (file.isEmpty()) {
			log.info("Entering FileUploadServiceImpl uploadVideo file is empty");
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage(WebConstants.FAILURE_MSG);
		} else {
				strDate = sdfDate.format(now);
				// fileName = custId + "_SHOP_" + strDate + ".mp4";
				fileName = custId + "_" + videoType + "_" + strDate + ".mp4";
				log.info("Entering FileUploadServiceImpl uploadVideo fileName:" + fileName);
				String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
				String s3Folder = userFilePath;

				String s3FileName = s3Folder + fileName;
				boolean success = awsS3ServiceImpl.saveFileToS3(s3FileName,  file.getBytes(), "mp4");
				if(success) {
					response.setStatusCode(WebConstants.SUCCESS_CODE);
					response.setStatusMessage(WebConstants.SUCCESS_MSG);
					if (videoType.equalsIgnoreCase("SHOP")) {
						customerStateStatus.setVideoStatus(true);
					}else if (videoType.equalsIgnoreCase("360")) {
						customerStateStatus.setVideo360Status(true);
					} else if (videoType.equalsIgnoreCase("FI_RESI_STREET_360")) {
						
					} else if (videoType.equalsIgnoreCase("FI_SHOP_360_VIDEO")) {
						
					}
					customerDetails.setCustomerStateStatus(customerStateStatus);
					customerRepository.save(customerDetails);
				}else {
					response.setStatusCode(WebConstants.FAILURE_CODE);
					response.setStatusMessage(WebConstants.FAILURE_MSG);
				}
		}
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for get User FileUploadServiceImpl saveVideo is ==>" + timeTaken);
		return response;
	}

	public BaseResponseDTO saveVideoOld(String videoType, MultipartFile file, String customerId) throws IOException {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering FileUploadServiceImpl uploadVideo UPLIFT:" + customerId);
		int custId = Integer.parseInt(customerId);
		UlCustomerDetails customerDetails = customerRepository.findById(custId).get();
		UlCustomerStateStatus customerStateStatus = customerDetails.getCustomerStateStatus();
		BaseResponseDTO response = new BaseResponseDTO();
		if (videoType == null || videoType.equalsIgnoreCase("")) {
			videoType = "SHOP";
		}
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String fileFullName = "";
		String fileName = "";
		String strDate = sdfDate.format(now);

		if (file.isEmpty()) {
			log.info("Entering FileUploadServiceImpl uploadVideo file is empty");
			response.setStatusCode(WebConstants.FAILURE_CODE);
			response.setStatusMessage(WebConstants.FAILURE_MSG);
		} else {
			try {
				strDate = sdfDate.format(now);
				// fileName = custId + "_SHOP_" + strDate + ".mp4";
				fileName = custId + "_" + videoType + "_" + strDate + ".mp4";
				log.info("Entering FileUploadServiceImpl uploadVideo fileName:" + fileName);
				String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
				String filePath = "/FRNDLN/ImageFiles_EBS/" + userFilePath;
				String s3Folder = "/FRNDLN/ImageFiles/" + userFilePath;

				Path path = Paths.get(filePath);
				Path s3FilePath = Paths.get(s3Folder);
				// creating structured folders if doesn't exist
				if (!Files.exists(path)) {
					Files.createDirectories(path);
					Files.createDirectories(s3FilePath);
				}

				// Save the file to the upload directory
				String filePath1 = filePath + fileName;
				File dest1 = new File(filePath1);
				file.transferTo(dest1);

				// Copy File from ImageFiles_EBS to ImageFiles
				fileFullName = filePath + fileName;
				String s3FileName = s3Folder + fileName;
				Files.copy(Paths.get(fileFullName), Paths.get(s3FileName));

				response.setStatusCode(WebConstants.SUCCESS_CODE);
				response.setStatusMessage(WebConstants.SUCCESS_MSG);

				if (videoType.equalsIgnoreCase("SHOP")) {
					customerStateStatus.setVideoStatus(true);
				} else {
					customerStateStatus.setVideo360Status(true);
				}
				customerDetails.setCustomerStateStatus(customerStateStatus);
				customerRepository.save(customerDetails);

			} catch (IOException e) {
				log.error("Exeception occured in file save: " + e);
				e.printStackTrace();
				response.setStatusCode(WebConstants.FAILURE_CODE);
				response.setStatusMessage(WebConstants.FAILURE_MSG);
			}
		}
		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for get User FileUploadServiceImpl saveVideo is ==>" + timeTaken);
		return response;
	}

	/***
	 * 
	 * @param custId
	 * @param fileName
	 * @return contents of file as String
	 * @throws Exception
	 */
	@Override
	public String getCustFile(int custId, String fileName) throws Exception {
		log.info("Entering getCustFile : filename" + fileName);
		String fileData = null;
		String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
		String custFileLoc = "/FRNDLN/ImageFiles/" + userFilePath + fileName;
		File file = new File(custFileLoc);

		if (file != null) {
			byte[] bytes = loadFile(file);
			fileData = new String(bytes);
		}
		log.info("Exiting getCustFile : filepath " + custFileLoc);
		return fileData;
	}
	
	
	public String getCustPhoto(int custId, String fileName) throws Exception {
		log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto : getCustPhoto :" + custId +", " + fileName);
		String imageData = "";
		String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
		String custFileLoc = "/FRNDLN/ImageFiles/" + userFilePath;
		log.info("getCustPhoto =>" + custFileLoc);
		File dir = new File(custFileLoc);
		File[] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//return name.contains(fileName);
				String filenamestart = ""+custId+"_"+fileName;
				log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto : :DIR | NAME | filenamestart :" + dir + "," + name+","+filenamestart);
				return name.startsWith(filenamestart);
			}
		});
		long firstFileTime = System.currentTimeMillis();
		File image = null;
		if (files != null) {
			for (File file : files) {
				log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto : file :" + file);
				if (file.lastModified() < firstFileTime) {
					image = file;
					firstFileTime = file.lastModified();
				}
			}
		}
		if (image != null) {
			log.info("FileUploadServiceImpl : verifyCustPhotWithAddhaarPhoto : getCustPhoto : found Image :"+image.getPath());
			byte[] bytes = loadFile(image);
			byte[] encoded = Base64.encode(bytes);
			imageData = new String(encoded);
		}
		return imageData;
	}

	/***
	 * This api is used to save the selfie Image of Agent
	 * 
	 * @param bsResponseDTO
	 * @param custId
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */

	@Override
	public String saveSelfieImage(byte[] fileContents, String fileType, String agentCode, String extension)
			throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			String agentCodeint = agentCode;
			String s3Folder = "UPLIFT/ATTENDANCE/" + agentCodeint + "/";
			fileDetails = agentCodeint + "_" + fileType + "_" + strDate + "." + extension;

			String s3FileName = s3Folder + fileDetails;
			awsS3ServiceImpl.saveFileToS3(s3FileName, fileContents, extension);
		}
		return fileDetails;
	}
	
	public String saveSelfieImageOld(byte[] fileContents, String fileType, String agentCode, String extension)
			throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileName = "";
		String fileDetails = "";
		if (fileContents != null && fileContents.length > 0) {

			strDate = sdfDate.format(now);
			String agentCodeint = agentCode;
			String filePath = "/FRNDLN/ImageFiles_EBS/UPLIFT/ATTENDANCE/" + agentCodeint + "/";
			fileDetails = agentCodeint + "_" + fileType + "_" + strDate + "." + extension;

			fileName = filePath + fileDetails;
			File finalFile = new File(fileName);
			log.info("saveFile File Name:" + finalFile);
			Path path = Paths.get(filePath);

			// creating structured folders if doesn't exist
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}
			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				fos.write(fileContents);
				fos.close();
			} catch (Exception e) {
				log.error("Error writing img file to EBS disk", e);
			}
		}
		return fileDetails;
	}

	/***
	 * This api is used to save the remote file
	 */
	@Override
	public String saveRemoteFileToDisk(String url, String fileType, String customerId, String extension)
			throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String fileDetails = "";
		if (url != null && url.length() > 0) {

			strDate = sdfDate.format(now);
			int custId = Integer.parseInt(customerId);
			String userFilePath = String.format("%03d", custId % 1000) + "/" + custId + "/";
			String s3Folder = userFilePath;
			fileDetails = custId + "_" + fileType + "_" + strDate + "." + extension;

			ByteArrayOutputStream buffer = null;
			try {
				BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
				buffer = new ByteArrayOutputStream();
				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					buffer.write(dataBuffer, 0, bytesRead);
				}

				buffer.flush();
			} catch (Exception e) {
				log.error("Error writing remote file to buffered stream", e);
			}
			byte[] fileContents = buffer.toByteArray();
			String s3FileName = s3Folder + fileDetails;
			awsS3ServiceImpl.saveFileToS3(s3FileName,  fileContents, extension);
			log.info("exiting saveRemoteFileToDisk, File Name:" + s3FileName);

		}
		return fileDetails;
	}

	
}
