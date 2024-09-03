package in.fl.los.response;

public class VersionCheckResponseDTO extends BaseResponseDTO {

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VersionCheckResponseDTO [version=" + version + ", getStatusCode()=" + getStatusCode()
				+ ", getStatusMessage()=" + getStatusMessage() + ", getRandom()=" + getRandom() + "]";
	}

}
