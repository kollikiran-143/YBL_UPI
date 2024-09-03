package in.fl.los.ybl.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pgMerchantId", "payload" })
@Generated("jsonschema2pojo")
public class ResponseYblDTO {

	@JsonProperty("pgMerchantId")
	private String pgMerchantId;
	@JsonProperty("payload")
	private String payload;

	@JsonProperty("pgMerchantId")
	public String getPgMerchantId() {
		return pgMerchantId;
	}

	@JsonProperty("pgMerchantId")
	public void setPgMerchantId(String pgMerchantId) {
		this.pgMerchantId = pgMerchantId;
	}

	@JsonProperty("payload")
	public String getPayload() {
		return payload;
	}

	@JsonProperty("payload")
	public void setPayload(String payload) {
		this.payload = payload;
	}

}
