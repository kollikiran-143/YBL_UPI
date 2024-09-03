
package in.fl.los.mandate.upimandate.ybl;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "ifsc", "accType" })
@Generated("jsonschema2pojo")
public class MerchantInfo {

	@JsonProperty("code")
	private String code;
	@JsonProperty("ifsc")
	private String ifsc;
	@JsonProperty("accType")
	private String accType;

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("ifsc")
	public String getIfsc() {
		return ifsc;
	}

	@JsonProperty("ifsc")
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@JsonProperty("accType")
	public String getAccType() {
		return accType;
	}

	@JsonProperty("accType")
	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return String.format("MerchantInfo [code=%s, ifsc=%s, accType=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				code, ifsc, accType, getClass(), hashCode(), super.toString());
	}

}
