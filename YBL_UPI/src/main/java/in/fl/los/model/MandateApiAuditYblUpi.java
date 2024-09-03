// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "mandate_audit_upi_ybl", indexes = {
		@Index(name = "mandateAuditUpiYblIdxUpiMndtCustLoan", columnList = "cust_id,loan_id") })
public class MandateApiAuditYblUpi implements Serializable {

	private static final long serialVersionUID = -4978237946794601689L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 11)
	private int id;
	@Column(name = "loan_id", precision = 10)
	private int loanId;
	@Column(name = "cust_id", precision = 10)
	private int custId;
	@Column(name = "trxn_no", length = 50)
	private String trxnNo;
	@Column(precision = 10)
	private double amount;
	@Column(name = "mandate_start_date")
	private Date mandateStartDate;
	@Column(name = "payer_name", length = 100)
	private String payerName;
	@Column(name = "payer_vpa", length = 100)
	private String payerVpa;
	@Column(length = 20)
	private String status;
	@Column(length = 100)
	private String msg;
	@Column(name = "error_code", length = 5)
	private String errorCode;
	@Column(name = "error_desc", length = 100)
	private String errorDesc;
	@Column(name = "cp_mdt_ref_no", length = 50)
	private String cpMdtRefNo;
	@Column(name = "status_desc", length = 100)
	private String statusDesc;
	@Column(length = 100)
	private String umrn;
	@Column(name = "account_no", length = 20)
	private String accountNo;
	@Column(name = "approved_acc_no", length = 20)
	private String approvedAccNo;
	@Column(length = 15)
	private String ifsc;
	@Column(name = "bank_name", length = 100)
	private String bankName;
	@Column(name = "acc_holder_name", length = 100)
	private String accHolderName;
	private String req;
	private String callback;
	@Column(name = "rrn_no", length = 12)
	private String rrnNo;
	@Column(name = "psp_ref_no", length = 36)
	private String pspRefNo;
	@Column(name = "revoke_time")
	private Date revokeTime;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modified_time")
	private Date modifiedTime;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedTime = new Date();
	}

	/** Default constructor. */
	public MandateApiAuditYblUpi() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for loanId.
	 *
	 * @return the current value of loanId
	 */
	public int getLoanId() {
		return loanId;
	}

	/**
	 * Setter method for loanId.
	 *
	 * @param aLoanId the new value for loanId
	 */
	public void setLoanId(int aLoanId) {
		loanId = aLoanId;
	}

	/**
	 * Access method for custId.
	 *
	 * @return the current value of custId
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * Setter method for custId.
	 *
	 * @param aCustId the new value for custId
	 */
	public void setCustId(int aCustId) {
		custId = aCustId;
	}

	/**
	 * Access method for trxnNo.
	 *
	 * @return the current value of trxnNo
	 */
	public String getTrxnNo() {
		return trxnNo;
	}

	/**
	 * Setter method for trxnNo.
	 *
	 * @param aTrxnNo the new value for trxnNo
	 */
	public void setTrxnNo(String aTrxnNo) {
		trxnNo = aTrxnNo;
	}

	/**
	 * Access method for amount.
	 *
	 * @return the current value of amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Setter method for amount.
	 *
	 * @param aAmount the new value for amount
	 */
	public void setAmount(double aAmount) {
		amount = aAmount;
	}

	/**
	 * Access method for mandateStartDate.
	 *
	 * @return the current value of mandateStartDate
	 */
	public Date getMandateStartDate() {
		return mandateStartDate;
	}

	/**
	 * Setter method for mandateStartDate.
	 *
	 * @param aMandateStartDate the new value for mandateStartDate
	 */
	public void setMandateStartDate(Date aMandateStartDate) {
		mandateStartDate = aMandateStartDate;
	}

	/**
	 * Access method for payerName.
	 *
	 * @return the current value of payerName
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * Setter method for payerName.
	 *
	 * @param aPayerName the new value for payerName
	 */
	public void setPayerName(String aPayerName) {
		payerName = aPayerName;
	}

	/**
	 * Access method for payerVpa.
	 *
	 * @return the current value of payerVpa
	 */
	public String getPayerVpa() {
		return payerVpa;
	}

	/**
	 * Setter method for payerVpa.
	 *
	 * @param aPayerVpa the new value for payerVpa
	 */
	public void setPayerVpa(String aPayerVpa) {
		payerVpa = aPayerVpa;
	}

	/**
	 * Access method for status.
	 *
	 * @return the current value of status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Setter method for status.
	 *
	 * @param aStatus the new value for status
	 */
	public void setStatus(String aStatus) {
		status = aStatus;
	}

	/**
	 * Access method for msg.
	 *
	 * @return the current value of msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Setter method for msg.
	 *
	 * @param aMsg the new value for msg
	 */
	public void setMsg(String aMsg) {
		msg = aMsg;
	}

	/**
	 * Access method for errorCode.
	 *
	 * @return the current value of errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Setter method for errorCode.
	 *
	 * @param aErrorCode the new value for errorCode
	 */
	public void setErrorCode(String aErrorCode) {
		errorCode = aErrorCode;
	}

	/**
	 * Access method for errorDesc.
	 *
	 * @return the current value of errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * Setter method for errorDesc.
	 *
	 * @param aErrorDesc the new value for errorDesc
	 */
	public void setErrorDesc(String aErrorDesc) {
		errorDesc = aErrorDesc;
	}

	/**
	 * Access method for cpMdtRefNo.
	 *
	 * @return the current value of cpMdtRefNo
	 */
	public String getCpMdtRefNo() {
		return cpMdtRefNo;
	}

	/**
	 * Setter method for cpMdtRefNo.
	 *
	 * @param aCpMdtRefNo the new value for cpMdtRefNo
	 */
	public void setCpMdtRefNo(String aCpMdtRefNo) {
		cpMdtRefNo = aCpMdtRefNo;
	}

	/**
	 * Access method for statusDesc.
	 *
	 * @return the current value of statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Setter method for statusDesc.
	 *
	 * @param aStatusDesc the new value for statusDesc
	 */
	public void setStatusDesc(String aStatusDesc) {
		statusDesc = aStatusDesc;
	}

	/**
	 * Access method for umrn.
	 *
	 * @return the current value of umrn
	 */
	public String getUmrn() {
		return umrn;
	}

	/**
	 * Setter method for umrn.
	 *
	 * @param aUmrn the new value for umrn
	 */
	public void setUmrn(String aUmrn) {
		umrn = aUmrn;
	}

	/**
	 * Access method for accountNo.
	 *
	 * @return the current value of accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * Setter method for accountNo.
	 *
	 * @param aAccountNo the new value for accountNo
	 */
	public void setAccountNo(String aAccountNo) {
		accountNo = aAccountNo;
	}

	/**
	 * Access method for approvedAccNo.
	 *
	 * @return the current value of approvedAccNo
	 */
	public String getApprovedAccNo() {
		return approvedAccNo;
	}

	/**
	 * Setter method for approvedAccNo.
	 *
	 * @param aApprovedAccNo the new value for approvedAccNo
	 */
	public void setApprovedAccNo(String aApprovedAccNo) {
		approvedAccNo = aApprovedAccNo;
	}

	/**
	 * Access method for ifsc.
	 *
	 * @return the current value of ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * Setter method for ifsc.
	 *
	 * @param aIfsc the new value for ifsc
	 */
	public void setIfsc(String aIfsc) {
		ifsc = aIfsc;
	}

	/**
	 * Access method for bankName.
	 *
	 * @return the current value of bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Setter method for bankName.
	 *
	 * @param aBankName the new value for bankName
	 */
	public void setBankName(String aBankName) {
		bankName = aBankName;
	}

	/**
	 * Access method for accHolderName.
	 *
	 * @return the current value of accHolderName
	 */
	public String getAccHolderName() {
		return accHolderName;
	}

	/**
	 * Setter method for accHolderName.
	 *
	 * @param aAccHolderName the new value for accHolderName
	 */
	public void setAccHolderName(String aAccHolderName) {
		accHolderName = aAccHolderName;
	}

	/**
	 * Access method for req.
	 *
	 * @return the current value of req
	 */
	public String getReq() {
		return req;
	}

	/**
	 * Setter method for req.
	 *
	 * @param aReq the new value for req
	 */
	public void setReq(String aReq) {
		req = aReq;
	}

	/**
	 * Access method for callback.
	 *
	 * @return the current value of callback
	 */
	public String getCallback() {
		return callback;
	}

	/**
	 * Setter method for callback.
	 *
	 * @param aCallback the new value for callback
	 */
	public void setCallback(String aCallback) {
		callback = aCallback;
	}

	/**
	 * Access method for rrnNo.
	 *
	 * @return the current value of rrnNo
	 */
	public String getRrnNo() {
		return rrnNo;
	}

	/**
	 * Setter method for rrnNo.
	 *
	 * @param aRrnNo the new value for rrnNo
	 */
	public void setRrnNo(String aRrnNo) {
		rrnNo = aRrnNo;
	}

	/**
	 * Access method for pspRefNo.
	 *
	 * @return the current value of pspRefNo
	 */
	public String getPspRefNo() {
		return pspRefNo;
	}

	/**
	 * Setter method for pspRefNo.
	 *
	 * @param aPspRefNo the new value for pspRefNo
	 */
	public void setPspRefNo(String aPspRefNo) {
		pspRefNo = aPspRefNo;
	}

	/**
	 * Access method for revokeTime.
	 *
	 * @return the current value of revokeTime
	 */
	public Date getRevokeTime() {
		return revokeTime;
	}

	/**
	 * Setter method for revokeTime.
	 *
	 * @param aRevokeTime the new value for revokeTime
	 */
	public void setRevokeTime(Date aRevokeTime) {
		revokeTime = aRevokeTime;
	}

	/**
	 * Access method for createTime.
	 *
	 * @return the current value of createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Setter method for createTime.
	 *
	 * @param aCreateTime the new value for createTime
	 */
	public void setCreateTime(Date aCreateTime) {
		createTime = aCreateTime;
	}

	/**
	 * Access method for modifiedTime.
	 *
	 * @return the current value of modifiedTime
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * Setter method for modifiedTime.
	 *
	 * @param aModifiedTime the new value for modifiedTime
	 */
	public void setModifiedTime(Date aModifiedTime) {
		modifiedTime = aModifiedTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accHolderName, accountNo, amount, approvedAccNo, bankName, callback, cpMdtRefNo, createTime,
				custId, errorCode, errorDesc, id, ifsc, loanId, mandateStartDate, modifiedTime, msg, payerName,
				payerVpa, pspRefNo, req, revokeTime, rrnNo, status, statusDesc, trxnNo, umrn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MandateApiAuditYblUpi other = (MandateApiAuditYblUpi) obj;
		return Objects.equals(accHolderName, other.accHolderName) && Objects.equals(accountNo, other.accountNo)
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(approvedAccNo, other.approvedAccNo) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(callback, other.callback) && Objects.equals(cpMdtRefNo, other.cpMdtRefNo)
				&& Objects.equals(createTime, other.createTime) && custId == other.custId
				&& Objects.equals(errorCode, other.errorCode) && Objects.equals(errorDesc, other.errorDesc)
				&& id == other.id && Objects.equals(ifsc, other.ifsc) && loanId == other.loanId
				&& Objects.equals(mandateStartDate, other.mandateStartDate)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(msg, other.msg)
				&& Objects.equals(payerName, other.payerName) && Objects.equals(payerVpa, other.payerVpa)
				&& Objects.equals(pspRefNo, other.pspRefNo) && Objects.equals(req, other.req)
				&& Objects.equals(revokeTime, other.revokeTime) && Objects.equals(rrnNo, other.rrnNo)
				&& Objects.equals(status, other.status) && Objects.equals(statusDesc, other.statusDesc)
				&& Objects.equals(trxnNo, other.trxnNo) && Objects.equals(umrn, other.umrn);
	}

	@Override
	public String toString() {
		return String.format(
				"MandateApiAuditYblUpi [id=%s, loanId=%s, custId=%s, trxnNo=%s, amount=%s, mandateStartDate=%s, payerName=%s, payerVpa=%s, status=%s, msg=%s, errorCode=%s, errorDesc=%s, cpMdtRefNo=%s, statusDesc=%s, umrn=%s, accountNo=%s, approvedAccNo=%s, ifsc=%s, bankName=%s, accHolderName=%s, req=%s, callback=%s, rrnNo=%s, pspRefNo=%s, revokeTime=%s, createTime=%s, modifiedTime=%s, getClass()=%s, toString()=%s]",
				id, loanId, custId, trxnNo, amount, mandateStartDate, payerName, payerVpa, status, msg, errorCode,
				errorDesc, cpMdtRefNo, statusDesc, umrn, accountNo, approvedAccNo, ifsc, bankName, accHolderName, req,
				callback, rrnNo, pspRefNo, revokeTime, createTime, modifiedTime, getClass(), super.toString());
	}

}
