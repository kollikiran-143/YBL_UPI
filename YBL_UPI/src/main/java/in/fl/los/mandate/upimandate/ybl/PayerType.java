
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "virtualAddress", "name", "accountNo" })
@Generated("jsonschema2pojo")
public class PayerType {

	@JsonProperty("virtualAddress")
	private String virtualAddress;
	@JsonProperty("name")
	private String name;
	@JsonProperty("accountNo")
	private String accountNo;

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

	@JsonProperty("accountNo")
	public String getAccountNo() {
		return accountNo;
	}

	@JsonProperty("accountNo")
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return String.format(
				"PayerType [virtualAddress=%s, name=%s, accountNo=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				virtualAddress, name, accountNo, getClass(), hashCode(), super.toString());
	}

}