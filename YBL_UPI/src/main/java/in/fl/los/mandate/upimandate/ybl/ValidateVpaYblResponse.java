
package in.fl.los.mandate.upimandate.ybl;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errCode", "payer_type", "payeeType", "status", "statusDesc", "statusCode", "verificationFlag" })
@Generated("jsonschema2pojo")
public class ValidateVpaYblResponse {

	@JsonProperty("errCode")
	private String errCode;
	@JsonProperty("payer_type")
	private PayerType payerType;
	@JsonProperty("payeeType")
	private PayeeType payeeType;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statusDesc")
	private String statusDesc;
	@JsonProperty("statusCode")
	private Integer statusCode;
	@JsonProperty("verificationFlag")
	private Boolean verificationFlag;

	@JsonProperty("errCode")
	public String getErrCode() {
		return errCode;
	}

	@JsonProperty("errCode")
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@JsonProperty("payer_type")
	public PayerType getPayerType() {
		return payerType;
	}

	@JsonProperty("payer_type")
	public void setPayerType(PayerType payerType) {
		this.payerType = payerType;
	}

	@JsonProperty("payeeType")
	public PayeeType getPayeeType() {
		return payeeType;
	}

	@JsonProperty("payeeType")
	public void setPayeeType(PayeeType payeeType) {
		this.payeeType = payeeType;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("statusDesc")
	public String getStatusDesc() {
		return statusDesc;
	}

	@JsonProperty("statusDesc")
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@JsonProperty("statusCode")
	public Integer getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("verificationFlag")
	public Boolean getVerificationFlag() {
		return verificationFlag;
	}

	@JsonProperty("verificationFlag")
	public void setVerificationFlag(Boolean verificationFlag) {
		this.verificationFlag = verificationFlag;
	}

	@Override
	public String toString() {
		return String.format(
				"YblValidateVPAResponse [errCode=%s, payerType=%s, payeeType=%s, status=%s, statusDesc=%s, statusCode=%s, verificationFlag=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				errCode, payerType, payeeType, status, statusDesc, statusCode, verificationFlag, getClass(), hashCode(),
				super.toString());
	}

}
