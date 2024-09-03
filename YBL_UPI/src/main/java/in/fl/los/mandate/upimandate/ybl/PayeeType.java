
package in.fl.los.mandate.upimandate.ybl;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "virtualAddress", "name", "merchantInfo" })
@Generated("jsonschema2pojo")
public class PayeeType {

	@JsonProperty("virtualAddress")
	private String virtualAddress;
	@JsonProperty("name")
	private String name;
	@JsonProperty("merchantInfo")
	private MerchantInfo merchantInfo;

	@JsonProperty("virtualAddress")
	public String getVirtualAddress() {
		return virtualAddress;
	}

	@JsonProperty("virtualAddress")
	public void setVirtualAddress(String virtualAddress) {
		this.virtualAddress = virtualAddress;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("merchantInfo")
	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	@JsonProperty("merchantInfo")
	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	@Override
	public String toString() {
		return String.format(
				"PayeeType [virtualAddress=%s, name=%s, merchantInfo=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				virtualAddress, name, merchantInfo, getClass(), hashCode(), super.toString());
	}

}
