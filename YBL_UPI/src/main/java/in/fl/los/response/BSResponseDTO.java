package in.fl.los.response;

import java.util.List;

public class BSResponseDTO {

	private String status;
	private Statements statementData;
	private List<String> taxFiles;
	private String mobileData;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Statements getStatementData() {
		return statementData;
	}

	public void setStatementData(Statements statementData) {
		this.statementData = statementData;
	}

	public String getMobileData() {
		return mobileData;
	}

	public void setMobileData(String mobileData) {
		this.mobileData = mobileData;
	}

	public List<String> getTaxFiles() {
		return taxFiles;
	}

	public void setTaxFiles(List<String> taxFiles) {
		this.taxFiles = taxFiles;
	}

	@Override
	public String toString() {
		return "BSResponseDTO [status=" + status + ", statementData=" + statementData + ", mobileData=" + mobileData
				+ "]";
	}

}
