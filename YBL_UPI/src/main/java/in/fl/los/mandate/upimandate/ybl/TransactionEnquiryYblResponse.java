package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errCode", "message", "status", "payerRespCode", "payeeRespCode", "txnId", "custRefNo", "amount",
		"txnAuthDate", "payerVPA", "payeeVPA", "pspRefNo", "upiTransRefNo", "txnType", "txnNote", "payerName",
		"statusCode", "payerAccNo", "payerifsc", "payerAccType" })
@Generated("jsonschema2pojo")
public class TransactionEnquiryYblResponse {

	@JsonProperty("errCode")
	private String errCode;
	@JsonProperty("message")
	private String message;
	@JsonProperty("status")
	private String status;
	@JsonProperty("payerRespCode")
	private String payerRespCode;
	@JsonProperty("payeeRespCode")
	private String payeeRespCode;
	@JsonProperty("txnId")
	private String txnId;
	@JsonProperty("custRefNo")
	private Long custRefNo;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("txnAuthDate")
	private String txnAuthDate;
	@JsonProperty("payerVPA")
	private String payerVPA;
	@JsonProperty("payeeVPA")
	private String payeeVPA;
	@JsonProperty("pspRefNo")
	private String pspRefNo;
	@JsonProperty("upiTransRefNo")
	private Integer upiTransRefNo;
	@JsonProperty("txnType")
	private String txnType;
	@JsonProperty("txnNote")
	private String txnNote;
	@JsonProperty("payerName")
	private String payerName;
	@JsonProperty("statusCode")
	private String statusCode;
	@JsonProperty("payerAccNo")
	private String payerAccNo;
	@JsonProperty("payerifsc")
	private String payerifsc;
	@JsonProperty("payerAccType")
	private String payerAccType;

	@JsonProperty("errCode")
	public String getErrCode() {
		return errCode;
	}

	@JsonProperty("errCode")
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("payerRespCode")
	public String getPayerRespCode() {
		return payerRespCode;
	}

	@JsonProperty("payerRespCode")
	public void setPayerRespCode(String payerRespCode) {
		this.payerRespCode = payerRespCode;
	}

	@JsonProperty("payeeRespCode")
	public String getPayeeRespCode() {
		return payeeRespCode;
	}

	@JsonProperty("payeeRespCode")
	public void setPayeeRespCode(String payeeRespCode) {
		this.payeeRespCode = payeeRespCode;
	}

	@JsonProperty("txnId")
	public String getTxnId() {
		return txnId;
	}

	@JsonProperty("txnId")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@JsonProperty("custRefNo")
	public Long getCustRefNo() {
		return custRefNo;
	}

	@JsonProperty("custRefNo")
	public void setCustRefNo(Long custRefNo) {
		this.custRefNo = custRefNo;
	}

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("txnAuthDate")
	public String getTxnAuthDate() {
		return txnAuthDate;
	}

	@JsonProperty("txnAuthDate")
	public void setTxnAuthDate(String txnAuthDate) {
		this.txnAuthDate = txnAuthDate;
	}

	@JsonProperty("payerVPA")
	public String getPayerVPA() {
		return payerVPA;
	}

	@JsonProperty("payerVPA")
	public void setPayerVPA(String payerVPA) {
		this.payerVPA = payerVPA;
	}

	@JsonProperty("payeeVPA")
	public String getPayeeVPA() {
		return payeeVPA;
	}

	@JsonProperty("payeeVPA")
	public void setPayeeVPA(String payeeVPA) {
		this.payeeVPA = payeeVPA;
	}

	@JsonProperty("pspRefNo")
	public String getPspRefNo() {
		return pspRefNo;
	}

	@JsonProperty("pspRefNo")
	public void setPspRefNo(String pspRefNo) {
		this.pspRefNo = pspRefNo;
	}

	@JsonProperty("upiTransRefNo")
	public Integer getUpiTransRefNo() {
		return upiTransRefNo;
	}

	@JsonProperty("upiTransRefNo")
	public void setUpiTransRefNo(Integer upiTransRefNo) {
		this.upiTransRefNo = upiTransRefNo;
	}

	@JsonProperty("txnType")
	public String getTxnType() {
		return txnType;
	}

	@JsonProperty("txnType")
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	@JsonProperty("txnNote")
	public String getTxnNote() {
		return txnNote;
	}

	@JsonProperty("txnNote")
	public void setTxnNote(String txnNote) {
		this.txnNote = txnNote;
	}

	@JsonProperty("payerName")
	public String getPayerName() {
		return payerName;
	}

	@JsonProperty("payerName")
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	@JsonProperty("statusCode")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("payerAccNo")
	public String getPayerAccNo() {
		return payerAccNo;
	}

	@JsonProperty("payerAccNo")
	public void setPayerAccNo(String payerAccNo) {
		this.payerAccNo = payerAccNo;
	}

	@JsonProperty("payerifsc")
	public String getPayerifsc() {
		return payerifsc;
	}

	@JsonProperty("payerifsc")
	public void setPayerifsc(String payerifsc) {
		this.payerifsc = payerifsc;
	}

	@JsonProperty("payerAccType")
	public String getPayerAccType() {
		return payerAccType;
	}

	@JsonProperty("payerAccType")
	public void setPayerAccType(String payerAccType) {
		this.payerAccType = payerAccType;
	}

	@Override
	public String toString() {
		return String.format(
				"TransactionEnquiryYblResponse [errCode=%s, message=%s, status=%s, payerRespCode=%s, payeeRespCode=%s, txnId=%s, custRefNo=%s, amount=%s, txnAuthDate=%s, payerVPA=%s, payeeVPA=%s, pspRefNo=%s, upiTransRefNo=%s, txnType=%s, txnNote=%s, payerName=%s, statusCode=%s, payerAccNo=%s, payerifsc=%s, payerAccType=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				errCode, message, status, payerRespCode, payeeRespCode, txnId, custRefNo, amount, txnAuthDate, payerVPA,
				payeeVPA, pspRefNo, upiTransRefNo, txnType, txnNote, payerName, statusCode, payerAccNo, payerifsc,
				payerAccType, getClass(), hashCode(), super.toString());
	}

}