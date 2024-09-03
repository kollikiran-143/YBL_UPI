
package in.fl.los.mandate.upimandate.ybl;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pgMerchantId", "pspRefNo", "txnDate" })
@Generated("jsonschema2pojo")
public class RequestInfo {

	@JsonProperty("pgMerchantId")
	private String pgMerchantId;
	@JsonProperty("pspRefNo")
	private String pspRefNo;
	@JsonProperty("txnDate")
	private String txnDate;

	@JsonProperty("pgMerchantId")
	public String getPgMerchantId() {
		return pgMerchantId;
	}

	@JsonProperty("pgMerchantId")
	public void setPgMerchantId(String pgMerchantId) {
		this.pgMerchantId = pgMerchantId;
	}

	@JsonProperty("pspRefNo")
	public String getPspRefNo() {
		return pspRefNo;
	}

	@JsonProperty("pspRefNo")
	public void setPspRefNo(String pspRefNo) {
		this.pspRefNo = pspRefNo;
	}

	@JsonProperty("txnDate")
	public String getTxnDate() {
		return txnDate;
	}

	@JsonProperty("txnDate")
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	@Override
	public String toString() {
		return String.format(
				"RequestInfo [pgMerchantId=%s, pspRefNo=%s, txnDate=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				pgMerchantId, pspRefNo, txnDate, getClass(), hashCode(), super.toString());
	}

}
