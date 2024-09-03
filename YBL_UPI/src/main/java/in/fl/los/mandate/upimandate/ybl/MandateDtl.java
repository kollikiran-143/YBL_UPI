
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "custRefNo", "requestDate", "referenceNumber", "txnId", "remarks", "name", "mandateType",
		"frequency", "amount", "startDate", "endDate", "UMN", "isRevokeable", "payerVPA", "payerName", "payeeVPA",
		"payeeName", "status", "statusDesc", "debitIfsc", "debitAccount", "creditIfsc", "crediAccount", "mndregrefno",
		"noOfDebit", "onBehalf_Of", "amt_rule", "ruleType", "ruleValue", "has_update_authority", "create_date_time",
		"ref_url", "errCode", "respCode", "payType", "show_QR", "callback_type", "purpose_code", "expire_time", "mcc",
		"merchantType", "expiry_date_time", "message", "is_verified", "blockFund", "initiatedBy", "nextRecurDate",
		"remRecuCount", "isPause", "seqNo", "pauseStartDate", "pauseEndDate", "orgTxnId", "voucher_UUID", "pydMobile",
		"initiationMode", "errorCode", "refId", "responseCode" })
@Generated("jsonschema2pojo")
public class MandateDtl {

	@JsonProperty("custRefNo")
	private Long custRefNo;
	@JsonProperty("requestDate")
	private String requestDate;
	@JsonProperty("referenceNumber")
	private String referenceNumber;
	@JsonProperty("txnId")
	private String txnId;
	@JsonProperty("remarks")
	private String remarks;
	@JsonProperty("name")
	private String name;
	@JsonProperty("mandateType")
	private String mandateType;
	@JsonProperty("frequency")
	private String frequency;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("startDate")
	private String startDate;
	@JsonProperty("endDate")
	private String endDate;
	@JsonProperty("UMN")
	private String umn;
	@JsonProperty("isRevokeable")
	private String isRevokeable;
	@JsonProperty("payerVPA")
	private String payerVPA;
	@JsonProperty("payerName")
	private String payerName;
	@JsonProperty("payeeVPA")
	private String payeeVPA;
	@JsonProperty("payeeName")
	private String payeeName;
	@JsonProperty("status")
	private String status;
	@JsonProperty("statusDesc")
	private String statusDesc;
	@JsonProperty("debitIfsc")
	private String debitIfsc;
	@JsonProperty("debitAccount")
	private String debitAccount;
	@JsonProperty("creditIfsc")
	private String creditIfsc;
	@JsonProperty("crediAccount")
	private Long crediAccount;
	@JsonProperty("mndregrefno")
	private Integer mndregrefno;
	@JsonProperty("noOfDebit")
	private Integer noOfDebit;
	@JsonProperty("onBehalf_Of")
	private String onBehalfOf;
	@JsonProperty("amt_rule")
	private String amtRule;
	@JsonProperty("ruleType")
	private String ruleType;
	@JsonProperty("ruleValue")
	private String ruleValue;
	@JsonProperty("has_update_authority")
	private String hasUpdateAuthority;
	@JsonProperty("create_date_time")
	private String createDateTime;
	@JsonProperty("ref_url")
	private String refUrl;
	@JsonProperty("errCode")
	private String errCode;
	@JsonProperty("respCode")
	private String respCode;
	@JsonProperty("payType")
	private String payType;
	@JsonProperty("show_QR")
	private String showQR;
	@JsonProperty("callback_type")
	private String callbackType;
	@JsonProperty("purpose_code")
	private Integer purposeCode;
	@JsonProperty("expire_time")
	private Integer expireTime;
	@JsonProperty("mcc")
	private Integer mcc;
	@JsonProperty("merchantType")
	private String merchantType;
	@JsonProperty("expiry_date_time")
	private String expiryDateTime;
	@JsonProperty("message")
	private String message;
	@JsonProperty("is_verified")
	private String isVerified;
	@JsonProperty("blockFund")
	private String blockFund;
	@JsonProperty("initiatedBy")
	private String initiatedBy;
	@JsonProperty("nextRecurDate")
	private String nextRecurDate;
	@JsonProperty("remRecuCount")
	private Integer remRecuCount;
	@JsonProperty("isPause")
	private String isPause;
	@JsonProperty("seqNo")
	private String seqNo;
	@JsonProperty("pauseStartDate")
	private String pauseStartDate;
	@JsonProperty("pauseEndDate")
	private String pauseEndDate;
	@JsonProperty("orgTxnId")
	private String orgTxnId;
	@JsonProperty("voucher_UUID")
	private String voucherUUID;
	@JsonProperty("pydMobile")
	private String pydMobile;
	@JsonProperty("initiationMode")
	private String initiationMode;
	@JsonProperty("errorCode")
	private String errorCode;
	@JsonProperty("refId")
	private String refId;
	@JsonProperty("responseCode")
	private String responseCode;

	@JsonProperty("custRefNo")
	public Long getCustRefNo() {
		return custRefNo;
	}

	@JsonProperty("custRefNo")
	public void setCustRefNo(Long custRefNo) {
		this.custRefNo = custRefNo;
	}

	@JsonProperty("requestDate")
	public String getRequestDate() {
		return requestDate;
	}

	@JsonProperty("requestDate")
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	@JsonProperty("referenceNumber")
	public String getReferenceNumber() {
		return referenceNumber;
	}

	@JsonProperty("referenceNumber")
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@JsonProperty("txnId")
	public String getTxnId() {
		return txnId;
	}

	@JsonProperty("txnId")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@JsonProperty("remarks")
	public String getRemarks() {
		return remarks;
	}

	@JsonProperty("remarks")
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("mandateType")
	public String getMandateType() {
		return mandateType;
	}

	@JsonProperty("mandateType")
	public void setMandateType(String mandateType) {
		this.mandateType = mandateType;
	}

	@JsonProperty("frequency")
	public String getFrequency() {
		return frequency;
	}

	@JsonProperty("frequency")
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("startDate")
	public String getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("endDate")
	public String getEndDate() {
		return endDate;
	}

	@JsonProperty("endDate")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("isRevokeable")
	public String getIsRevokeable() {
		return isRevokeable;
	}

	@JsonProperty("isRevokeable")
	public void setIsRevokeable(String isRevokeable) {
		this.isRevokeable = isRevokeable;
	}

	@JsonProperty("payerVPA")
	public String getPayerVPA() {
		return payerVPA;
	}

	@JsonProperty("payerVPA")
	public void setPayerVPA(String payerVPA) {
		this.payerVPA = payerVPA;
	}

	@JsonProperty("payerName")
	public String getPayerName() {
		return payerName;
	}

	@JsonProperty("payerName")
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	@JsonProperty("payeeVPA")
	public String getPayeeVPA() {
		return payeeVPA;
	}

	@JsonProperty("payeeVPA")
	public void setPayeeVPA(String payeeVPA) {
		this.payeeVPA = payeeVPA;
	}

	@JsonProperty("payeeName")
	public String getPayeeName() {
		return payeeName;
	}

	@JsonProperty("payeeName")
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("debitAccount")
	public String getDebitAccount() {
		return debitAccount;
	}

	@JsonProperty("debitAccount")
	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	@JsonProperty("creditIfsc")
	public String getCreditIfsc() {
		return creditIfsc;
	}

	@JsonProperty("creditIfsc")
	public void setCreditIfsc(String creditIfsc) {
		this.creditIfsc = creditIfsc;
	}

	@JsonProperty("crediAccount")
	public Long getCrediAccount() {
		return crediAccount;
	}

	@JsonProperty("crediAccount")
	public void setCrediAccount(Long crediAccount) {
		this.crediAccount = crediAccount;
	}

	@JsonProperty("mndregrefno")
	public Integer getMndregrefno() {
		return mndregrefno;
	}

	@JsonProperty("mndregrefno")
	public void setMndregrefno(Integer mndregrefno) {
		this.mndregrefno = mndregrefno;
	}

	@JsonProperty("noOfDebit")
	public Integer getNoOfDebit() {
		return noOfDebit;
	}

	@JsonProperty("noOfDebit")
	public void setNoOfDebit(Integer noOfDebit) {
		this.noOfDebit = noOfDebit;
	}

	@JsonProperty("onBehalf_Of")
	public String getOnBehalfOf() {
		return onBehalfOf;
	}

	@JsonProperty("onBehalf_Of")
	public void setOnBehalfOf(String onBehalfOf) {
		this.onBehalfOf = onBehalfOf;
	}

	@JsonProperty("amt_rule")
	public String getAmtRule() {
		return amtRule;
	}

	@JsonProperty("amt_rule")
	public void setAmtRule(String amtRule) {
		this.amtRule = amtRule;
	}

	@JsonProperty("ruleType")
	public String getRuleType() {
		return ruleType;
	}

	@JsonProperty("ruleType")
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	@JsonProperty("ruleValue")
	public String getRuleValue() {
		return ruleValue;
	}

	@JsonProperty("ruleValue")
	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	@JsonProperty("create_date_time")
	public String getCreateDateTime() {
		return createDateTime;
	}

	@JsonProperty("create_date_time")
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	@JsonProperty("ref_url")
	public String getRefUrl() {
		return refUrl;
	}

	@JsonProperty("ref_url")
	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}

	@JsonProperty("errCode")
	public String getErrCode() {
		return errCode;
	}

	@JsonProperty("errCode")
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@JsonProperty("payType")
	public String getPayType() {
		return payType;
	}

	@JsonProperty("payType")
	public void setPayType(String payType) {
		this.payType = payType;
	}

	@JsonProperty("show_QR")
	public String getShowQR() {
		return showQR;
	}

	@JsonProperty("show_QR")
	public void setShowQR(String showQR) {
		this.showQR = showQR;
	}

	@JsonProperty("purpose_code")
	public Integer getPurposeCode() {
		return purposeCode;
	}

	@JsonProperty("purpose_code")
	public void setPurposeCode(Integer purposeCode) {
		this.purposeCode = purposeCode;
	}

	@JsonProperty("expire_time")
	public Integer getExpireTime() {
		return expireTime;
	}

	@JsonProperty("expire_time")
	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	@JsonProperty("mcc")
	public Integer getMcc() {
		return mcc;
	}

	@JsonProperty("mcc")
	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	@JsonProperty("expiry_date_time")
	public String getExpiryDateTime() {
		return expiryDateTime;
	}

	@JsonProperty("expiry_date_time")
	public void setExpiryDateTime(String expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("is_verified")
	public String getIsVerified() {
		return isVerified;
	}

	@JsonProperty("is_verified")
	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	@JsonProperty("blockFund")
	public String getBlockFund() {
		return blockFund;
	}

	@JsonProperty("blockFund")
	public void setBlockFund(String blockFund) {
		this.blockFund = blockFund;
	}

	@JsonProperty("initiatedBy")
	public String getInitiatedBy() {
		return initiatedBy;
	}

	@JsonProperty("initiatedBy")
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	@JsonProperty("nextRecurDate")
	public String getNextRecurDate() {
		return nextRecurDate;
	}

	@JsonProperty("nextRecurDate")
	public void setNextRecurDate(String nextRecurDate) {
		this.nextRecurDate = nextRecurDate;
	}

	@JsonProperty("remRecuCount")
	public Integer getRemRecuCount() {
		return remRecuCount;
	}

	@JsonProperty("remRecuCount")
	public void setRemRecuCount(Integer remRecuCount) {
		this.remRecuCount = remRecuCount;
	}

	@JsonProperty("pauseStartDate")
	public String getPauseStartDate() {
		return pauseStartDate;
	}

	@JsonProperty("pauseStartDate")
	public void setPauseStartDate(String pauseStartDate) {
		this.pauseStartDate = pauseStartDate;
	}

	@JsonProperty("pauseEndDate")
	public String getPauseEndDate() {
		return pauseEndDate;
	}

	@JsonProperty("pauseEndDate")
	public void setPauseEndDate(String pauseEndDate) {
		this.pauseEndDate = pauseEndDate;
	}

	@JsonProperty("pydMobile")
	public String getPydMobile() {
		return pydMobile;
	}

	@JsonProperty("pydMobile")
	public void setPydMobile(String pydMobile) {
		this.pydMobile = pydMobile;
	}

	@JsonProperty("initiationMode")
	public String getInitiationMode() {
		return initiationMode;
	}

	@JsonProperty("initiationMode")
	public void setInitiationMode(String initiationMode) {
		this.initiationMode = initiationMode;
	}

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("UMN")
	public String getUmn() {
		return umn;
	}

	@JsonProperty("UMN")
	public void setUmn(String umn) {
		this.umn = umn;
	}

	@JsonProperty("has_update_authority")
	public String getHasUpdateAuthority() {
		return hasUpdateAuthority;
	}

	@JsonProperty("has_update_authority")
	public void setHasUpdateAuthority(String hasUpdateAuthority) {
		this.hasUpdateAuthority = hasUpdateAuthority;
	}

	@JsonProperty("merchantType")
	public String getMerchantType() {
		return merchantType;
	}

	@JsonProperty("merchantType")
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	@JsonProperty("orgTxnId")
	public String getOrgTxnId() {
		return orgTxnId;
	}

	@JsonProperty("orgTxnId")
	public void setOrgTxnId(String orgTxnId) {
		this.orgTxnId = orgTxnId;
	}

	@JsonProperty("statusDesc")
	public String getStatusDesc() {
		return statusDesc;
	}

	@JsonProperty("statusDesc")
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@JsonProperty("debitIfsc")
	public String getDebitIfsc() {
		return debitIfsc;
	}

	@JsonProperty("debitIfsc")
	public void setDebitIfsc(String debitIfsc) {
		this.debitIfsc = debitIfsc;
	}

	@JsonProperty("respCode")
	public String getRespCode() {
		return respCode;
	}

	@JsonProperty("respCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	@JsonProperty("callback_type")
	public String getCallbackType() {
		return callbackType;
	}

	@JsonProperty("callback_type")
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	@JsonProperty("voucher_UUID")
	public String getVoucherUUID() {
		return voucherUUID;
	}

	@JsonProperty("voucher_UUID")
	public void setVoucherUUID(String voucherUUID) {
		this.voucherUUID = voucherUUID;
	}

	@JsonProperty("isPause")
	public String getIsPause() {
		return isPause;
	}

	@JsonProperty("isPause")
	public void setIsPause(String isPause) {
		this.isPause = isPause;
	}

	@JsonProperty("responseCode")
	public String getResponseCode() {
		return responseCode;
	}

	@JsonProperty("responseCode")
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@JsonProperty("refId")
	public String getRefId() {
		return refId;
	}

	@JsonProperty("refId")
	public void setRefId(String refId) {
		this.refId = refId;
	}

	@JsonProperty("seqNo")
	public String getSeqNo() {
		return seqNo;
	}

	@JsonProperty("seqNo")
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		return String.format(
				"MandateDtl [custRefNo=%s, requestDate=%s, referenceNumber=%s, txnId=%s, remarks=%s, name=%s, mandateType=%s, frequency=%s, amount=%s, startDate=%s, endDate=%s, umn=%s, isRevokeable=%s, payerVPA=%s, payerName=%s, payeeVPA=%s, payeeName=%s, status=%s, statusDesc=%s, debitIfsc=%s, debitAccount=%s, creditIfsc=%s, crediAccount=%s, mndregrefno=%s, noOfDebit=%s, onBehalfOf=%s, amtRule=%s, ruleType=%s, ruleValue=%s, hasUpdateAuthority=%s, createDateTime=%s, refUrl=%s, errCode=%s, respCode=%s, payType=%s, showQR=%s, callbackType=%s, purposeCode=%s, expireTime=%s, mcc=%s, merchantType=%s, expiryDateTime=%s, message=%s, isVerified=%s, blockFund=%s, initiatedBy=%s, nextRecurDate=%s, remRecuCount=%s, isPause=%s, seqNo=%s, pauseStartDate=%s, pauseEndDate=%s, orgTxnId=%s, voucherUUID=%s, pydMobile=%s, initiationMode=%s, errorCode=%s, refId=%s, responseCode=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				custRefNo, requestDate, referenceNumber, txnId, remarks, name, mandateType, frequency, amount,
				startDate, endDate, umn, isRevokeable, payerVPA, payerName, payeeVPA, payeeName, status, statusDesc,
				debitIfsc, debitAccount, creditIfsc, crediAccount, mndregrefno, noOfDebit, onBehalfOf, amtRule,
				ruleType, ruleValue, hasUpdateAuthority, createDateTime, refUrl, errCode, respCode, payType, showQR,
				callbackType, purposeCode, expireTime, mcc, merchantType, expiryDateTime, message, isVerified,
				blockFund, initiatedBy, nextRecurDate, remRecuCount, isPause, seqNo, pauseStartDate, pauseEndDate,
				orgTxnId, voucherUUID, pydMobile, initiationMode, errorCode, refId, responseCode, getClass(),
				hashCode(), super.toString());
	}

}