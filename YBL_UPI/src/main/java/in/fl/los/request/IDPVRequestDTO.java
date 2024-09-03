package in.fl.los.request;

/**
 * validatePic request class
 * 
 * @class IDValidationServiceImpl
 * @function validatePic
 *
 * @author ragavan 22-May-2019
 * @version 1
 */
public class IDPVRequestDTO extends BaseRequestDTO {

	private byte[] imageContents;
	private String fileType;

	public byte[] getImageContents() {
		return imageContents;
	}

	public void setImageContents(byte[] imageContents) {
		this.imageContents = imageContents;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "IDPVRequestDTO [fileType=" + fileType + ", getCustomerId()=" + getCustomerId() + ", getImei()="
				+ getImei() + ", getRandom()=" + getRandom() + ", getRequestCreatedAt()=" + getRequestCreatedAt()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getVersion()=" + getVersion() + ", getAppName()="
				+ getAppName() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
