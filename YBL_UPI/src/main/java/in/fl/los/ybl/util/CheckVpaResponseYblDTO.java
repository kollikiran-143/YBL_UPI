
package in.fl.los.ybl.util;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pgMerchantId", "pspId", "requestMsg", "ipAddress", "apiName", "error_code", "error_message",
		"resp", "key_data", "device_digest", "digi_sign", "pspRefNo", "jvmId", "mndApiName", "logApiName", "payload" })
@Generated("jsonschema2pojo")
public class CheckVpaResponseYblDTO {

	@JsonProperty("pgMerchantId")
	private String pgMerchantId;
	@JsonProperty("pspId")
	private Object pspId;
	@JsonProperty("requestMsg")
	private Object requestMsg;
	@JsonProperty("ipAddress")
	private Object ipAddress;
	@JsonProperty("apiName")
	private Object apiName;
	@JsonProperty("error_code")
	private Object errorCode;
	@JsonProperty("error_message")
	private Object errorMessage;
	@JsonProperty("resp")
	private String resp;
	@JsonProperty("key_data")
	private KeyData keyData;
	@JsonProperty("device_digest")
	private Object deviceDigest;
	@JsonProperty("digi_sign")
	private String digiSign;
	@JsonProperty("pspRefNo")
	private String pspRefNo;
	@JsonProperty("jvmId")
	private Object jvmId;
	@JsonProperty("mndApiName")
	private Object mndApiName;
	@JsonProperty("logApiName")
	private Object logApiName;
	@JsonProperty("payload")
	private Object payload;

	@JsonProperty("pgMerchantId")
	public String getPgMerchantId() {
		return pgMerchantId;
	}

	@JsonProperty("pgMerchantId")
	public void setPgMerchantId(String pgMerchantId) {
		this.pgMerchantId = pgMerchantId;
	}

	@JsonProperty("pspId")
	public Object getPspId() {
		return pspId;
	}

	@JsonProperty("pspId")
	public void setPspId(Object pspId) {
		this.pspId = pspId;
	}

	@JsonProperty("requestMsg")
	public Object getRequestMsg() {
		return requestMsg;
	}

	@JsonProperty("requestMsg")
	public void setRequestMsg(Object requestMsg) {
		this.requestMsg = requestMsg;
	}

	@JsonProperty("ipAddress")
	public Object getIpAddress() {
		return ipAddress;
	}

	@JsonProperty("ipAddress")
	public void setIpAddress(Object ipAddress) {
		this.ipAddress = ipAddress;
	}

	@JsonProperty("apiName")
	public Object getApiName() {
		return apiName;
	}

	@JsonProperty("apiName")
	public void setApiName(Object apiName) {
		this.apiName = apiName;
	}

	@JsonProperty("error_code")
	public Object getErrorCode() {
		return errorCode;
	}

	@JsonProperty("error_code")
	public void setErrorCode(Object errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("error_message")
	public Object getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("error_message")
	public void setErrorMessage(Object errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("resp")
	public String getResp() {
		return resp;
	}

	@JsonProperty("resp")
	public void setResp(String resp) {
		this.resp = resp;
	}

	@JsonProperty("key_data")
	public KeyData getKeyData() {
		return keyData;
	}

	@JsonProperty("key_data")
	public void setKeyData(KeyData keyData) {
		this.keyData = keyData;
	}

	@JsonProperty("device_digest")
	public Object getDeviceDigest() {
		return deviceDigest;
	}

	@JsonProperty("device_digest")
	public void setDeviceDigest(Object deviceDigest) {
		this.deviceDigest = deviceDigest;
	}

	@JsonProperty("digi_sign")
	public String getDigiSign() {
		return digiSign;
	}

	@JsonProperty("digi_sign")
	public void setDigiSign(String digiSign) {
		this.digiSign = digiSign;
	}

	@JsonProperty("pspRefNo")
	public String getPspRefNo() {
		return pspRefNo;
	}

	@JsonProperty("pspRefNo")
	public void setPspRefNo(String pspRefNo) {
		this.pspRefNo = pspRefNo;
	}

	@JsonProperty("jvmId")
	public Object getJvmId() {
		return jvmId;
	}

	@JsonProperty("jvmId")
	public void setJvmId(Object jvmId) {
		this.jvmId = jvmId;
	}

	@JsonProperty("mndApiName")
	public Object getMndApiName() {
		return mndApiName;
	}

	@JsonProperty("mndApiName")
	public void setMndApiName(Object mndApiName) {
		this.mndApiName = mndApiName;
	}

	@JsonProperty("logApiName")
	public Object getLogApiName() {
		return logApiName;
	}

	@JsonProperty("logApiName")
	public void setLogApiName(Object logApiName) {
		this.logApiName = logApiName;
	}

	@JsonProperty("payload")
	public Object getPayload() {
		return payload;
	}

	@JsonProperty("payload")
	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return String.format(
				"CheckVpaResponseDTO [pgMerchantId=%s, pspId=%s, requestMsg=%s, ipAddress=%s, apiName=%s, errorCode=%s, errorMessage=%s, resp=%s, keyData=%s, deviceDigest=%s, digiSign=%s, pspRefNo=%s, jvmId=%s, mndApiName=%s, logApiName=%s, payload=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				pgMerchantId, pspId, requestMsg, ipAddress, apiName, errorCode, errorMessage, resp, keyData,
				deviceDigest, digiSign, pspRefNo, jvmId, mndApiName, logApiName, payload, getClass(), hashCode(),
				super.toString());
	}

}
