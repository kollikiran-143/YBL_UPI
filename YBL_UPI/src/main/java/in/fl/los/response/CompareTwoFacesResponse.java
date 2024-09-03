package in.fl.los.response;

public class CompareTwoFacesResponse extends BaseResponseDTO {
	float matchPercetage;
	int targetFaceCount;

	public float getMatchPercetage() {
		return matchPercetage;
	}

	public void setMatchPercetage(float matchPercetage) {
		this.matchPercetage = matchPercetage;
	}

	public int getTargetFaceCount() {
		return targetFaceCount;
	}

	public void setTargetFaceCount(int targetFaceCount) {
		this.targetFaceCount = targetFaceCount;
	}

	@Override
	public String toString() {
		return "CompareTwoFacesResponse [matchPercetage=" + matchPercetage + ", targetFaceCount=" + targetFaceCount
				+ ", getStatusCode()=" + getStatusCode() + ", getStatusMessage()=" + getStatusMessage() + "]";
	}

}
