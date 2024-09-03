package in.fl.los.mandate.upimandate.ybl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "mandateDtls" })
@Generated("jsonschema2pojo")
public class CallBackYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
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
				"CallBackYblRequestDTO [requestInfo=%s, mandateDtls=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, mandateDtls, getClass(), hashCode(), super.toString());
	}

}
