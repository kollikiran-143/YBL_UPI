package in.fl.los.ybl.util;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "requestMsg", "pgMerchantId" })
@Generated("jsonschema2pojo")
public class CheckVpaRequestYblDTO {

	@JsonProperty("requestMsg")
	private String requestMsg;
	@JsonProperty("pgMerchantId")
	private String pgMerchantId;

	@JsonProperty("requestMsg")
	public String getRequestMsg() {
		return requestMsg;
	}

	@JsonProperty("requestMsg")
	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	@JsonProperty("pgMerchantId")
	public String getPgMerchantId() {
		return pgMerchantId;
	}

	@JsonProperty("pgMerchantId")
	public void setPgMerchantId(String pgMerchantId) {
		this.pgMerchantId = pgMerchantId;
	}

	@Override
	public String toString() {
		return String.format(
				"CheckVpaRequestDTO [requestMsg=%s, pgMerchantId=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				requestMsg, pgMerchantId, getClass(), hashCode(), super.toString());
	}

}
