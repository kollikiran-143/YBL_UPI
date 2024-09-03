package in.fl.los.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import in.fl.los.request.FileUploadRequestDTO;
import in.fl.los.response.BSResponseDTO;
import in.fl.los.response.BaseResponseDTO;
import in.fl.los.response.IDPVResponseDTO;

public interface FileUploadService {

	/***
	 * This api is used to save file
	 * 
	 * @param fileUploadRequestDTO
	 * @return
	 * @throws IOException
	 */
	public IDPVResponseDTO saveFile(FileUploadRequestDTO fileUploadRequestDTO) throws IOException;

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
	public String saveFileToDisk(byte[] fileContents, String fileType, String customerId, String extension)
			throws IOException;

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
	public String saveStamentJson(BSResponseDTO bsResponseDTO, int custId)
			throws JsonGenerationException, JsonMappingException, IOException;

	// public String unZip(String fileName, String customerId, String password)
	// throws Exception;

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
	public String saveFileToS3(byte[] fileContents, String fileType, String customerId, String extension)
			throws Exception;

	/***
	 * 
	 * @param custId
	 * @param imgType
	 * @return
	 * @throws Exception
	 */
	public String getCustImage(int custId, String imgType) throws Exception;

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
	public String saveFileToDiskWithUnderScore(byte[] fileContents, String fileType, String customerId,
			String extension) throws IOException;

	public String savePayload(String payload, String folder, String name, String extension);

	/***
	 * This api is used to save video
	 * 
	 * @param file
	 * 
	 * @param fileUploadRequestDTO
	 * @return
	 * @throws IOException
	 */
	public BaseResponseDTO saveVideo(String videoType, MultipartFile file, String custId) throws IOException;

	/***
	 * 
	 * @param custId
	 * @param fileName
	 * @return contents of file as String
	 * @throws Exception
	 */
	public String getCustFile(int custId, String fileName) throws Exception;

	/***
	 * This api is used to save the remote file
	 */
	String saveRemoteFileToDisk(String url, String fileType, String customerId, String extension) throws IOException;

	String getSelfie(String agentId, String imgType) throws Exception;

	String getFirstSelfie(String agentId, String imgType) throws Exception;

	String saveFileToDiskOld(byte[] fileContents, String fileType, String customerId, String extension)
			throws IOException;

	String saveFileToDiskInFolder(byte[] fileContents, String fileType, String customerId, String extension,
			String folder) throws IOException;

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
	String saveSelfieImage(byte[] fileContents, String fileType, String agentCode, String extension) throws IOException;
}
