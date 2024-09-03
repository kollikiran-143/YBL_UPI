
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "txn_id", "amount", "amt_rule", "recurrence", "name", "revokeable", "action_type", "onBehalf_Of",
		"expiryTime", "blockFund", "purpose_code", "account_validation", "revokeFlag", "orgPspRefNo", "UMN",
		"recurringSeqNo" })
@Generated("jsonschema2pojo")
public class Mandate {

	@JsonProperty("txn_id")
	private String txnId;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("amt_rule")
	private String amtRule;
	@JsonProperty("recurrence")
	private Recurrence recurrence;
	@JsonProperty("name")
	private String name;
	@JsonProperty("revokeable")
	private String revokeable;
	@JsonProperty("action_type")
	private String actionType;
	@JsonProperty("onBehalf_Of")
	private String onBehalfOf;
	@JsonProperty("expiryTime")
	private String expiryTime;
	@JsonProperty("blockFund")
	private String blockFund;
	@JsonProperty("purpose_code")
	private String purposeCode;
	@JsonProperty("account_validation")
	private String accountValidation;
	@JsonProperty("revokeFlag")
	private String revokeFlag;
	@JsonProperty("orgPspRefNo")
	private String orgPspRefNo;
	@JsonProperty("UMN")
	private String umn;
	@JsonProperty("recurringSeqNo")
	private Integer recurringSeqNo;

	@JsonProperty("txn_id")
	public String getTxnId() {
		return txnId;
	}

	@JsonProperty("txn_id")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("amt_rule")
	public String getAmtRule() {
		return amtRule;
	}

	@JsonProperty("amt_rule")
	public void setAmtRule(String amtRule) {
		this.amtRule = amtRule;
	}

	@JsonProperty("recurrence")
	public Recurrence getRecurrence() {
		return recurrence;
	}

	@JsonProperty("recurrence")
	public void setRecurrence(Recurrence recurrence) {
		this.recurrence = recurrence;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("revokeable")
	public String getRevokeable() {
		return revokeable;
	}

	@JsonProperty("revokeable")
	public void setRevokeable(String revokeable) {
		this.revokeable = revokeable;
	}

	@JsonProperty("action_type")
	public String getActionType() {
		return actionType;
	}

	@JsonProperty("action_type")
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@JsonProperty("onBehalf_Of")
	public String getOnBehalfOf() {
		return onBehalfOf;
	}

	@JsonProperty("onBehalf_Of")
	public void setOnBehalfOf(String onBehalfOf) {
		this.onBehalfOf = onBehalfOf;
	}

	@JsonProperty("expiryTime")
	public String getExpiryTime() {
		return expiryTime;
	}

	@JsonProperty("expiryTime")
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	@JsonProperty("blockFund")
	public String getBlockFund() {
		return blockFund;
	}

	@JsonProperty("blockFund")
	public void setBlockFund(String blockFund) {
		this.blockFund = blockFund;
	}

	@JsonProperty("purpose_code")
	public String getPurposeCode() {
		return purposeCode;
	}

	@JsonProperty("purpose_code")
	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	@JsonProperty("account_validation")
	public String getAccountValidation() {
		return accountValidation;
	}

	@JsonProperty("account_validation")
	public void setAccountValidation(String accountValidation) {
		this.accountValidation = accountValidation;
	}

	@JsonProperty("revokeFlag")
	public String getRevokeFlag() {
		return revokeFlag;
	}

	@JsonProperty("revokeFlag")
	public void setRevokeFlag(String revokeFlag) {
		this.revokeFlag = revokeFlag;
	}

	@JsonProperty("orgPspRefNo")
	public String getOrgPspRefNo() {
		return orgPspRefNo;
	}

	@JsonProperty("orgPspRefNo")
	public void setOrgPspRefNo(String orgPspRefNo) {
		this.orgPspRefNo = orgPspRefNo;
	}

	@JsonProperty("UMN")
	public String getUmn() {
		return umn;
	}

	@JsonProperty("UMN")
	public void setUmn(String umn) {
		this.umn = umn;
	}

	@JsonProperty("recurringSeqNo")
	public Integer getRecurringSeqNo() {
		return recurringSeqNo;
	}

	@JsonProperty("recurringSeqNo")
	public void setRecurringSeqNo(Integer recurringSeqNo) {
		this.recurringSeqNo = recurringSeqNo;
	}

	@Override
	public String toString() {
		return String.format(
				"Mandate [txnId=%s, amount=%s, amtRule=%s, recurrence=%s, name=%s, revokeable=%s, actionType=%s, onBehalfOf=%s, expiryTime=%s, blockFund=%s, purposeCode=%s, accountValidation=%s, revokeFlag=%s, orgPspRefNo=%s, umn=%s, recurringSeqNo=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				txnId, amount, amtRule, recurrence, name, revokeable, actionType, onBehalfOf, expiryTime, blockFund,
				purposeCode, accountValidation, revokeFlag, orgPspRefNo, umn, recurringSeqNo, getClass(), hashCode(),
				super.toString());
	}

}