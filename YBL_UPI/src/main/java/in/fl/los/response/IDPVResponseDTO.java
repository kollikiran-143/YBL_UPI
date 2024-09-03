package in.fl.los.response;

public class IDPVResponseDTO extends BaseResponseDTO {

	private String idType, idNumber, idName, idFatherName, gender, address, rejectReason, dob;
	private boolean humanFace, usable;
	private float confidence;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdFatherName() {
		return idFatherName;
	}

	public void setIdFatherName(String idFatherName) {
		this.idFatherName = idFatherName;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	public boolean isUsable() {
		return usable;
	}

	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public boolean isHumanFace() {
		return humanFace;
	}

	public void setHumanFace(boolean humanFace) {
		this.humanFace = humanFace;
	}

	@Override
	public String toString() {
		return String.format(
				"IDPVResponseDTO [idType=%s, idNumber=%s, idName=%s, idFatherName=%s, gender=%s, address=%s, rejectReason=%s, dob=%s, humanFace=%s, usable=%s, confidence=%s, getStatusCode()=%s, getStatusMessage()=%s, getRandom()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
				idType, idNumber, idName, idFatherName, gender, address, rejectReason, dob, humanFace, usable,
				confidence, getStatusCode(), getStatusMessage(), getRandom(), super.toString(), getClass(), hashCode());
	}

}
