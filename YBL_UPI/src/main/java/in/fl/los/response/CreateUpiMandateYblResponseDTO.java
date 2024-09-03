package in.fl.los.response;

public class CreateUpiMandateYblResponseDTO extends BaseResponseDTO {

	private String pspRefNo;

	public String getPspRefNo() {
		return pspRefNo;
	}

	public void setPspRefNo(String pspRefNo) {
		this.pspRefNo = pspRefNo;
	}

	@Override
	public String toString() {
		return String.format(
				"CreateUpiMandateYblResponseDTO [pspRefNo=%s, getStatusCode()=%s, getStatusMessage()=%s, getRandom()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
				pspRefNo, getStatusCode(), getStatusMessage(), getRandom(), super.toString(), getClass(), hashCode());
	}

}
