package in.fl.los.response;

public class ValidateVpaYblResponseDTO extends BaseResponseDTO {

	String payeeName;
	String ifsc;
	String accountType;

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return String.format(
				"ValidateVpaYblResponseDTO [payeeName=%s, ifsc=%s, accountType=%s, getStatusCode()=%s, getStatusMessage()=%s, getRandom()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
				payeeName, ifsc, accountType, getStatusCode(), getStatusMessage(), getRandom(), super.toString(),
				getClass(), hashCode());
	}

}
