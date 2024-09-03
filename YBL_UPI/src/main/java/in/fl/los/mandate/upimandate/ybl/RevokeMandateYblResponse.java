
package in.fl.los.mandate.upimandate.ybl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "status", "statusDesc", "errCode", "mandateDtls", "errorCode", "respCode",
		"responseCode" })
@Generated("jsonschema2pojo")
public class RevokeMandateYblResponse {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statusDesc")
	private String statusDesc;
	@JsonProperty("errCode")
	private String errCode;
	@JsonProperty("mandateDtls")
	private List<MandateDtl> mandateDtls;
	@JsonProperty("errorCode")
	private String errorCode;
	@JsonProperty("respCode")
	private String respCode;
	@JsonProperty("responseCode")
	private String responseCode;

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

	@JsonProperty("errCode")
	public String getErrCode() {
		return errCode;
	}

	@JsonProperty("errCode")
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@JsonProperty("mandateDtls")
	public List<MandateDtl> getMandateDtls() {
		return mandateDtls;
	}

	@JsonProperty("mandateDtls")
	public void setMandateDtls(List<MandateDtl> mandateDtls) {
		this.mandateDtls = mandateDtls;
	}

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("respCode")
	public String getRespCode() {
		return respCode;
	}

	@JsonProperty("respCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	@JsonProperty("responseCode")
	public String getResponseCode() {
		return responseCode;
	}

	@JsonProperty("responseCode")
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		return String.format(
				"RevokeMandateYblResponse [requestInfo=%s, status=%s, statusDesc=%s, errCode=%s, mandateDtls=%s, errorCode=%s, respCode=%s, responseCode=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, status, statusDesc, errCode, mandateDtls, errorCode, respCode, responseCode, getClass(),
				hashCode(), super.toString());
	}

}