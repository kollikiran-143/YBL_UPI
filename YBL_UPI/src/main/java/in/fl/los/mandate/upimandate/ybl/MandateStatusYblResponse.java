
package in.fl.los.mandate.upimandate.ybl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "status", "statusDesc", "mandateDtls" })
@Generated("jsonschema2pojo")
public class MandateStatusYblResponse {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statusDesc")
	private String statusDesc;
	@JsonProperty("mandateDtls")
	private List<MandateDtl> mandateDtls;

	@JsonProperty("requestInfo")
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	@JsonProperty("requestInfo")
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
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

	@JsonProperty("mandateDtls")
	public List<MandateDtl> getMandateDtls() {
		return mandateDtls;
	}

	@JsonProperty("mandateDtls")
	public void setMandateDtls(List<MandateDtl> mandateDtls) {
		this.mandateDtls = mandateDtls;
	}

	@Override
	public String toString() {
		return String.format(
				"MandateStatusYblResponse [requestInfo=%s, status=%s, statusDesc=%s, mandateDtls=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, status, statusDesc, mandateDtls, getClass(), hashCode(), super.toString());
	}

}