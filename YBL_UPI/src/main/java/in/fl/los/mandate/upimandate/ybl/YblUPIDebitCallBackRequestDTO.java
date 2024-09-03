
package in.fl.los.mandate.upimandate.ybl;

public class YblUPIDebitCallBackRequestDTO {

	private String callbackType;
	private String status;
	private String statusDesc;
	private String cpMandateRefNo;
	private String umn;
	private String trxnNo;
	private String accountno;
	private String ifsc;
	private String bankname;
	private String accholdername;
	private String payerVpa;
	private String bankrrn;
	private String executionrefno;
	private String sipTrxnNo;
	private String payload;

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getCpMandateRefNo() {
		return cpMandateRefNo;
	}

	public void setCpMandateRefNo(String cpMandateRefNo) {
		this.cpMandateRefNo = cpMandateRefNo;
	}

	public String getUmn() {
		return umn;
	}

	public void setUmn(String umn) {
		this.umn = umn;
	}

	public String getTrxnNo() {
		return trxnNo;
	}

	public void setTrxnNo(String trxnNo) {
		this.trxnNo = trxnNo;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccholdername() {
		return accholdername;
	}

	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}

	public String getPayerVpa() {
		return payerVpa;
	}

	public void setPayerVpa(String payerVpa) {
		this.payerVpa = payerVpa;
	}

	public String getBankrrn() {
		return bankrrn;
	}

	public void setBankrrn(String bankrrn) {
		this.bankrrn = bankrrn;
	}

	public String getExecutionrefno() {
		return executionrefno;
	}

	public void setExecutionrefno(String executionrefno) {
		this.executionrefno = executionrefno;
	}

	public String getSipTrxnNo() {
		return sipTrxnNo;
	}

	public void setSipTrxnNo(String sipTrxnNo) {
		this.sipTrxnNo = sipTrxnNo;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return String.format(
				"YblUPIDebitCallBackRequestDTO [callbackType=%s, status=%s, statusDesc=%s, cpMandateRefNo=%s, umn=%s, trxnNo=%s, accountno=%s, ifsc=%s, bankname=%s, accholdername=%s, payerVpa=%s, bankrrn=%s, executionrefno=%s, sipTrxnNo=%s, payload=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				callbackType, status, statusDesc, cpMandateRefNo, umn, trxnNo, accountno, ifsc, bankname, accholdername,
				payerVpa, bankrrn, executionrefno, sipTrxnNo, payload, getClass(), hashCode(), super.toString());
	}

}