
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "mandate" })
@Generated("jsonschema2pojo")
public class RevokeMandateYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("mandate")
	private Mandate mandate;

	@JsonProperty("requestInfo")
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	@JsonProperty("requestInfo")
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	@JsonProperty("mandate")
	public Mandate getMandate() {
		return mandate;
	}

	@JsonProperty("mandate")
	public void setMandate(Mandate mandate) {
		this.mandate = mandate;
	}

	@Override
	public String toString() {
		return String.format(
				"RevokeMandateYblRequest [requestInfo=%s, mandate=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, mandate, getClass(), hashCode(), super.toString());
	}

}