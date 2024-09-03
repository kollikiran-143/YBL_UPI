package in.fl.los.response;

public class UpiMandateStatusResponseDTO extends BaseResponseDTO {
	private String MandateStatus;

	public String getMandateStatus() {
		return MandateStatus;
	}

	public void setMandateStatus(String mandateStatus) {
		MandateStatus = mandateStatus;
	}

	@Override
	public String toString() {
		return String.format(
				"UpiMandateStatusResponseDTO [MandateStatus=%s, getStatusCode()=%s, getStatusMessage()=%s, getRandom()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
				MandateStatus, getStatusCode(), getStatusMessage(), getRandom(), super.toString(), getClass(),
				hashCode());
	}

}
