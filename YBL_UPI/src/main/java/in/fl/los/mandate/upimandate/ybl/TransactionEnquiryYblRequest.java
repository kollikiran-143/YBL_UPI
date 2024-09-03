
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestInfo", "transactionNote", "orgPspRefNo", "orgTxnID", "orgTxnDate" })
@Generated("jsonschema2pojo")
public class TransactionEnquiryYblRequest {

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;
	@JsonProperty("transactionNote")
	private String transactionNote;
	@JsonProperty("orgPspRefNo")
	private String orgPspRefNo;
	@JsonProperty("orgTxnID")
	private String orgTxnID;
	@JsonProperty("orgTxnDate")
	private String orgTxnDate;

	@JsonProperty("requestInfo")
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	@JsonProperty("requestInfo")
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	@JsonProperty("transactionNote")
	public String getTransactionNote() {
		return transactionNote;
	}

	@JsonProperty("transactionNote")
	public void setTransactionNote(String transactionNote) {
		this.transactionNote = transactionNote;
	}

	@JsonProperty("orgPspRefNo")
	public String getOrgPspRefNo() {
		return orgPspRefNo;
	}

	@JsonProperty("orgPspRefNo")
	public void setOrgPspRefNo(String orgPspRefNo) {
		this.orgPspRefNo = orgPspRefNo;
	}

	@JsonProperty("orgTxnID")
	public String getOrgTxnID() {
		return orgTxnID;
	}

	@JsonProperty("orgTxnID")
	public void setOrgTxnID(String orgTxnID) {
		this.orgTxnID = orgTxnID;
	}

	@JsonProperty("orgTxnDate")
	public String getOrgTxnDate() {
		return orgTxnDate;
	}

	@JsonProperty("orgTxnDate")
	public void setOrgTxnDate(String orgTxnDate) {
		this.orgTxnDate = orgTxnDate;
	}

	@Override
	public String toString() {
		return String.format(
				"TransactionEnquiryYblRequest [requestInfo=%s, transactionNote=%s, orgPspRefNo=%s, orgTxnID=%s, orgTxnDate=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestInfo, transactionNote, orgPspRefNo, orgTxnID, orgTxnDate, getClass(), hashCode(),
				super.toString());
	}

}