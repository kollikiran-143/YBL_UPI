package in.fl.los.mandate.upimandate.ybl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "status", "statusDesc", "errCode", "errCodeDesc", "mandateDtls", "errorCode" })
@Generated("jsonschema2pojo")
public class PreDebitYblResponse {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statusDesc")
	private String statusDesc;
	@JsonProperty("errCode")
	private String errCode;
	@JsonProperty("errCodeDesc")
	private String errCodeDesc;
	@JsonProperty("mandateDtls")
	private List<MandateDtl> mandateDtls;
	@JsonProperty("errorCode")
	private String errorCode;

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

	@JsonProperty("errCodeDesc")
	public String getErrCodeDesc() {
		return errCodeDesc;
	}

	@JsonProperty("errCodeDesc")
	public void setErrCodeDesc(String errCodeDesc) {
		this.errCodeDesc = errCodeDesc;
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

	@Override
	public String toString() {
		return String.format(
				"PreDebitYblResponse [requestInfo=%s, status=%s, statusDesc=%s, errCode=%s, errCodeDesc=%s, mandateDtls=%s, errorCode=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, status, statusDesc, errCode, errCodeDesc, mandateDtls, errorCode, getClass(), hashCode(),
				super.toString());
	}

}