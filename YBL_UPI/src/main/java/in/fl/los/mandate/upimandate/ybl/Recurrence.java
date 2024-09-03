
package in.fl.los.mandate.upimandate.ybl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pattern", "ruleType", "ruleValue", "startDate", "endDate", "nextRecurDate", "seqNo" })
@Generated("jsonschema2pojo")
public class Recurrence {

	@JsonProperty("pattern")
	private String pattern;
	@JsonProperty("ruleType")
	private String ruleType;
	@JsonProperty("ruleValue")
	private Integer ruleValue;
	@JsonProperty("startDate")
	private String startDate;
	@JsonProperty("endDate")
	private String endDate;
	@JsonProperty("nextRecurDate")
	private String nextRecurDate;
	@JsonProperty("seqNo")
	private String seqNo;

	@JsonProperty("pattern")
	public String getPattern() {
		return pattern;
	}

	@JsonProperty("pattern")
	public void setPattern(String pattern) {
		this.pattern = pattern;
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
	public Integer getRuleValue() {
		return ruleValue;
	}

	@JsonProperty("ruleValue")
	public void setRuleValue(Integer ruleValue) {
		this.ruleValue = ruleValue;
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

	@JsonProperty("nextRecurDate")
	public String getNextRecurDate() {
		return nextRecurDate;
	}

	@JsonProperty("nextRecurDate")
	public void setNextRecurDate(String nextRecurDate) {
		this.nextRecurDate = nextRecurDate;
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
				"Recurrence [pattern=%s, ruleType=%s, ruleValue=%s, startDate=%s, endDate=%s, nextRecurDate=%s, seqNo=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				pattern, ruleType, ruleValue, startDate, endDate, nextRecurDate, seqNo, getClass(), hashCode(),
				super.toString());
	}

}