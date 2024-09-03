
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "mandate", "remarks" })
@Generated("jsonschema2pojo")
public class ExecuteMandateYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("mandate")
	private Mandate mandate;
	@JsonProperty("remarks")
	private String remarks;

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

	@JsonProperty("remarks")
	public String getRemarks() {
		return remarks;
	}

	@JsonProperty("remarks")
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return String.format(
				"ExecuteMandateYblRequest [requestInfo=%s, mandate=%s, remarks=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, mandate, remarks, getClass(), hashCode(), super.toString());
	}

}