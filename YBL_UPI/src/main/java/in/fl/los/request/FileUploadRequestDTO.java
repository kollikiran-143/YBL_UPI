package in.fl.los.request;

/**
 * uploadFile api request class
 * 
 * @class FileController
 * @function
 *
 * @author ragavan 22-May-2019
 * @version 1
 */
public class FileUploadRequestDTO extends BaseRequestDTO {
	private String fileType;
	private String fileExtension;
	private String fileData;
	private String extraData;
	private String[] extraFiles;
	private SnapShotMetaDataDetails[] extraFileDetails;
	private CustomerLocationRequestDTO locationRequestDTO;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	/**
	 * @return the extraFiles
	 */
	public String[] getExtraFiles() {
		return extraFiles;
	}

	/**
	 * @param extraFiles the extraFiles to set
	 */
	public void setExtraFiles(String[] extraFiles) {
		this.extraFiles = extraFiles;
	}

	public CustomerLocationRequestDTO getLocationRequestDTO() {
		return locationRequestDTO;
	}

	public void setLocationRequestDTO(CustomerLocationRequestDTO locationRequestDTO) {
		this.locationRequestDTO = locationRequestDTO;
	}

	/**
	 * @return the extraFileDetails
	 */
	public SnapShotMetaDataDetails[] getExtraFileDetails() {
		return extraFileDetails;
	}

	/**
	 * @param extraFileDetails the extraFileDetails to set
	 */
	public void setExtraFileDetails(SnapShotMetaDataDetails[] extraFileDetails) {
		this.extraFileDetails = extraFileDetails;
	}
	
	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@Override
	public String toString() {
		return String.format(
				"FileUploadRequestDTO [fileType=%s, fileData=%s, extraData=%s, extraFilesCount=%s, locationRequestDTO=%s, getCustomerId()=%s, getImei()=%s, getRandom()=%s, getRequestCreatedAt()=%s, getPhoneNumber()=%s, getVersion()=%s, getAppName()=%s]",
				fileType, fileData.length(), extraData, (extraFileDetails!=null) ? extraFileDetails.length : 0 , locationRequestDTO, getCustomerId(), getImei(), getRandom(), getRequestCreatedAt(), getPhoneNumber(),
				getVersion(), getAppName());
	}

}
