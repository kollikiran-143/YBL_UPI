
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "mandate", "payerType", "ref_id", "ref_url" })
@Generated("jsonschema2pojo")
public class CreateMandateYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("mandate")
	private Mandate mandate;
	@JsonProperty("payerType")
	private PayerType payerType;
	@JsonProperty("ref_id")
	private String refId;
	@JsonProperty("ref_url")
	private String refUrl;

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

	@JsonProperty("payerType")
	public PayerType getPayerType() {
		return payerType;
	}

	@JsonProperty("payerType")
	public void setPayerType(PayerType payerType) {
		this.payerType = payerType;
	}

	@JsonProperty("ref_id")
	public String getRefId() {
		return refId;
	}

	@JsonProperty("ref_id")
	public void setRefId(String refId) {
		this.refId = refId;
	}

	@JsonProperty("ref_url")
	public String getRefUrl() {
		return refUrl;
	}

	@JsonProperty("ref_url")
	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}

	@Override
	public String toString() {
		return String.format(
				"CreateMandateYblRequest [requestInfo=%s, mandate=%s, payerType=%s, refId=%s, refUrl=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, mandate, payerType, refId, refUrl, getClass(), hashCode(), super.toString());
	}

}