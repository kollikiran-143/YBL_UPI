
package in.fl.los.mandate.upimandate.ybl;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "payeeType" })
@Generated("jsonschema2pojo")
public class ValidateVpaYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("payeeType")
	private PayeeType payeeType;

	@JsonProperty("requestInfo")
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	@JsonProperty("requestInfo")
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	@JsonProperty("payeeType")
	public PayeeType getPayeeType() {
		return payeeType;
	}

	@JsonProperty("payeeType")
	public void setPayeeType(PayeeType payeeType) {
		this.payeeType = payeeType;
	}

	@Override
	public String toString() {
		return String.format(
				"YblValidateVPARequest [requestInfo=%s, payeeType=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, payeeType, getClass(), hashCode(), super.toString());
	}

}
