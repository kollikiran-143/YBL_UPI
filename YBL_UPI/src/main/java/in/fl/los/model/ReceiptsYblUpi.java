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
import jakarta.persistence.Table;

@Entity
@Table(name = "receipts_ybl_upi", indexes = {
		@Index(name = "receiptsYblUpiIdxBankNameMndtExecDescStatus", columnList = "bank_name,mndt_exec_desc,mndt_exec_status"),
		@Index(name = "receiptsYblUpiIdxMndtexecStatusDate", columnList = "mndt_exec_status,status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiMandt", columnList = "status,mndt_exec_status,mndt_exec_time"),
		@Index(name = "receiptsYblUpiIdxPredebitMndtexecStatusDate", columnList = "pre_debit_status,mndt_exec_status,status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxPredebitdate", columnList = "loan_no,status,pre_debit_time,predebit_date"),
		@Index(name = "receiptsYblUpiIdxReceiptsStatusLoanid", columnList = "loan_id,status"),
		@Index(name = "receiptsYblUpiIdxDebitDateMndtExecDesc", columnList = "debit_date,mndt_exec_desc"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiLoan", columnList = "loan_no,status,mndt_exec_status,mndt_exec_time"),
		@Index(name = "receiptsYblUpiIdxReceiptsLoan", columnList = "loan_no,predebit_date,status"),
		@Index(name = "receiptsYblUpiIdxRcptLnMndtCustLoan", columnList = "cust_id,loan_id"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiPredebitstatus", columnList = "status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxDebitDateMndtExecDescStatus", columnList = "debit_date,mndt_exec_desc,mndt_exec_status"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiDebitDate", columnList = "loan_no,status,bank_error,debit_try_count,debit_date"),
		@Index(name = "receiptsYblUpiIdxPredebitStatus", columnList = "pre_debit_status,status"),
		@Index(name = "receiptsYblUpiIdxReceiptsPredebit", columnList = "predebit_date,pre_debit_status,status"),
		@Index(name = "receiptsYblUpiIdxLoannoStatus", columnList = "loan_no,status"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiReceivable", columnList = "receivable_id,cp_mdt_ref_no,status"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiBank", columnList = "loan_no,status,bank_error,debit_try_count,mndt_exec_time"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpiFilter", columnList = "loan_no,status,pre_debit_time"),
		@Index(name = "receiptsYblUpiIdxMndtexecStatus", columnList = "mndt_exec_status,status"),
		@Index(name = "receiptsYblUpiIdxPredebitMndtexecDate", columnList = "pre_debit_status,mndt_exec_status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxPredebitStatusDate", columnList = "pre_debit_status,status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxBankNameMndtExecDesc", columnList = "bank_name,mndt_exec_desc"),
		@Index(name = "receiptsYblUpiIdxMndtExecDescStatus", columnList = "mndt_exec_desc,mndt_exec_status"),
		@Index(name = "receiptsYblUpiIdxReceiptsCamsUpi", columnList = "cp_mdt_ref_no,status,predebit_date"),
		@Index(name = "receiptsYblUpiIdxLnMndtRefTxn", columnList = "cp_mdt_ref_no,exec_trxn_no") })
public class ReceiptsYblUpi implements Serializable {

	private static final long serialVersionUID = 2264502722972961197L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 11)
	private int id;
	@Column(name = "loan_id", precision = 10)
	private int loanId;
	@Column(name = "receipt_log_id", precision = 11)
	private int receiptLogId;
	@Column(name = "loan_no", length = 20)
	private String loanNo;
	@Column(name = "cust_id", precision = 10)
	private int custId;
	@Column(name = "bank_name", length = 100)
	private String bankName;
	@Column(name = "cp_mdt_ref_no", length = 50)
	private String cpMdtRefNo;
	@Column(precision = 10)
	private double edi;
	@Column(name = "predebit_date")
	private Date predebitDate;
	@Column(name = "debit_date")
	private Date debitDate;
	@Column(name = "pre_debit_time")
	private Date preDebitTime;
	@Column(name = "seq_no", length = 15)
	private String seqNo;
	@Column(name = "receivable_id", precision = 11)
	private int receivableId;
	@Column(name = "pre_debit_status", length = 10)
	private String preDebitStatus;
	@Column(name = "pre_debit_desc", length = 100)
	private String preDebitDesc;
	@Column(name = "predebit_response")
	private String predebitResponse;
	@Column(name = "exec_trxn_no", length = 50)
	private String execTrxnNo;
	@Column(name = "mndt_exec_time")
	private Date mndtExecTime;
	@Column(name = "mndt_exec_timetaken", precision = 20)
	private long mndtExecTimetaken;
	@Column(name = "mndt_exec_starttime")
	private Date mndtExecStarttime;
	@Column(name = "mndt_exec_endtime")
	private Date mndtExecEndtime;
	@Column(name = "mndt_exec_status", length = 15)
	private String mndtExecStatus;
	@Column(name = "mndt_exec_desc", length = 150)
	private String mndtExecDesc;
	@Column(name = "execution_ref_no", length = 15)
	private String executionRefNo;
	@Column(name = "bank_rrn", length = 50)
	private String bankRrn;
	@Column(name = "sip_trxn_no", length = 50)
	private String sipTrxnNo;
	@Column(length = 100)
	private String umn;
	@Column(name = "debit_try_count", precision = 11)
	private int debitTryCount;
	private String callback;
	@Column(name = "callback_time")
	private Date callbackTime;
	@Column(name = "debit_response")
	private String debitResponse;
	@Column(name = "debit_status_response")
	private String debitStatusResponse;
	@Column(name = "debit_status_trycount", precision = 11)
	private int debitStatusTrycount;
	@Column(name = "bank_error", length = 200)
	private String bankError;
	@Column(name = "bank_error_code", length = 50)
	private String bankErrorCode;
	@Column(name = "receipt_mode", length = 30)
	private String receiptMode;
	@Column(name = "receipt_type", length = 30)
	private String receiptType;
	@Column(length = 50)
	private String status;
	@Column(name = "lms_absorb_time")
	private Date lmsAbsorbTime;
	@Column(name = "lms_reject_reason", length = 40)
	private String lmsRejectReason;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;

	/** Default constructor. */
	public ReceiptsYblUpi() {
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
	 * Access method for receiptLogId.
	 *
	 * @return the current value of receiptLogId
	 */
	public int getReceiptLogId() {
		return receiptLogId;
	}

	/**
	 * Setter method for receiptLogId.
	 *
	 * @param aReceiptLogId the new value for receiptLogId
	 */
	public void setReceiptLogId(int aReceiptLogId) {
		receiptLogId = aReceiptLogId;
	}

	/**
	 * Access method for loanNo.
	 *
	 * @return the current value of loanNo
	 */
	public String getLoanNo() {
		return loanNo;
	}

	/**
	 * Setter method for loanNo.
	 *
	 * @param aLoanNo the new value for loanNo
	 */
	public void setLoanNo(String aLoanNo) {
		loanNo = aLoanNo;
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
	 * Access method for edi.
	 *
	 * @return the current value of edi
	 */
	public double getEdi() {
		return edi;
	}

	/**
	 * Setter method for edi.
	 *
	 * @param aEdi the new value for edi
	 */
	public void setEdi(double aEdi) {
		edi = aEdi;
	}

	/**
	 * Access method for predebitDate.
	 *
	 * @return the current value of predebitDate
	 */
	public Date getPredebitDate() {
		return predebitDate;
	}

	/**
	 * Setter method for predebitDate.
	 *
	 * @param aPredebitDate the new value for predebitDate
	 */
	public void setPredebitDate(Date aPredebitDate) {
		predebitDate = aPredebitDate;
	}

	/**
	 * Access method for debitDate.
	 *
	 * @return the current value of debitDate
	 */
	public Date getDebitDate() {
		return debitDate;
	}

	/**
	 * Setter method for debitDate.
	 *
	 * @param aDebitDate the new value for debitDate
	 */
	public void setDebitDate(Date aDebitDate) {
		debitDate = aDebitDate;
	}

	/**
	 * Access method for preDebitTime.
	 *
	 * @return the current value of preDebitTime
	 */
	public Date getPreDebitTime() {
		return preDebitTime;
	}

	/**
	 * Setter method for preDebitTime.
	 *
	 * @param aPreDebitTime the new value for preDebitTime
	 */
	public void setPreDebitTime(Date aPreDebitTime) {
		preDebitTime = aPreDebitTime;
	}

	/**
	 * Access method for seqNo.
	 *
	 * @return the current value of seqNo
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * Setter method for seqNo.
	 *
	 * @param aSeqNo the new value for seqNo
	 */
	public void setSeqNo(String aSeqNo) {
		seqNo = aSeqNo;
	}

	/**
	 * Access method for receivableId.
	 *
	 * @return the current value of receivableId
	 */
	public int getReceivableId() {
		return receivableId;
	}

	/**
	 * Setter method for receivableId.
	 *
	 * @param aReceivableId the new value for receivableId
	 */
	public void setReceivableId(int aReceivableId) {
		receivableId = aReceivableId;
	}

	/**
	 * Access method for preDebitStatus.
	 *
	 * @return the current value of preDebitStatus
	 */
	public String getPreDebitStatus() {
		return preDebitStatus;
	}

	/**
	 * Setter method for preDebitStatus.
	 *
	 * @param aPreDebitStatus the new value for preDebitStatus
	 */
	public void setPreDebitStatus(String aPreDebitStatus) {
		preDebitStatus = aPreDebitStatus;
	}

	/**
	 * Access method for preDebitDesc.
	 *
	 * @return the current value of preDebitDesc
	 */
	public String getPreDebitDesc() {
		return preDebitDesc;
	}

	/**
	 * Setter method for preDebitDesc.
	 *
	 * @param aPreDebitDesc the new value for preDebitDesc
	 */
	public void setPreDebitDesc(String aPreDebitDesc) {
		preDebitDesc = aPreDebitDesc;
	}

	/**
	 * Access method for predebitResponse.
	 *
	 * @return the current value of predebitResponse
	 */
	public String getPredebitResponse() {
		return predebitResponse;
	}

	/**
	 * Setter method for predebitResponse.
	 *
	 * @param aPredebitResponse the new value for predebitResponse
	 */
	public void setPredebitResponse(String aPredebitResponse) {
		predebitResponse = aPredebitResponse;
	}

	/**
	 * Access method for execTrxnNo.
	 *
	 * @return the current value of execTrxnNo
	 */
	public String getExecTrxnNo() {
		return execTrxnNo;
	}

	/**
	 * Setter method for execTrxnNo.
	 *
	 * @param aExecTrxnNo the new value for execTrxnNo
	 */
	public void setExecTrxnNo(String aExecTrxnNo) {
		execTrxnNo = aExecTrxnNo;
	}

	/**
	 * Access method for mndtExecTime.
	 *
	 * @return the current value of mndtExecTime
	 */
	public Date getMndtExecTime() {
		return mndtExecTime;
	}

	/**
	 * Setter method for mndtExecTime.
	 *
	 * @param aMndtExecTime the new value for mndtExecTime
	 */
	public void setMndtExecTime(Date aMndtExecTime) {
		mndtExecTime = aMndtExecTime;
	}

	/**
	 * Access method for mndtExecTimetaken.
	 *
	 * @return the current value of mndtExecTimetaken
	 */
	public long getMndtExecTimetaken() {
		return mndtExecTimetaken;
	}

	/**
	 * Setter method for mndtExecTimetaken.
	 *
	 * @param aMndtExecTimetaken the new value for mndtExecTimetaken
	 */
	public void setMndtExecTimetaken(long aMndtExecTimetaken) {
		mndtExecTimetaken = aMndtExecTimetaken;
	}

	/**
	 * Access method for mndtExecStarttime.
	 *
	 * @return the current value of mndtExecStarttime
	 */
	public Date getMndtExecStarttime() {
		return mndtExecStarttime;
	}

	/**
	 * Setter method for mndtExecStarttime.
	 *
	 * @param aMndtExecStarttime the new value for mndtExecStarttime
	 */
	public void setMndtExecStarttime(Date aMndtExecStarttime) {
		mndtExecStarttime = aMndtExecStarttime;
	}

	/**
	 * Access method for mndtExecEndtime.
	 *
	 * @return the current value of mndtExecEndtime
	 */
	public Date getMndtExecEndtime() {
		return mndtExecEndtime;
	}

	/**
	 * Setter method for mndtExecEndtime.
	 *
	 * @param aMndtExecEndtime the new value for mndtExecEndtime
	 */
	public void setMndtExecEndtime(Date aMndtExecEndtime) {
		mndtExecEndtime = aMndtExecEndtime;
	}

	/**
	 * Access method for mndtExecStatus.
	 *
	 * @return the current value of mndtExecStatus
	 */
	public String getMndtExecStatus() {
		return mndtExecStatus;
	}

	/**
	 * Setter method for mndtExecStatus.
	 *
	 * @param aMndtExecStatus the new value for mndtExecStatus
	 */
	public void setMndtExecStatus(String aMndtExecStatus) {
		mndtExecStatus = aMndtExecStatus;
	}

	/**
	 * Access method for mndtExecDesc.
	 *
	 * @return the current value of mndtExecDesc
	 */
	public String getMndtExecDesc() {
		return mndtExecDesc;
	}

	/**
	 * Setter method for mndtExecDesc.
	 *
	 * @param aMndtExecDesc the new value for mndtExecDesc
	 */
	public void setMndtExecDesc(String aMndtExecDesc) {
		mndtExecDesc = aMndtExecDesc;
	}

	/**
	 * Access method for executionRefNo.
	 *
	 * @return the current value of executionRefNo
	 */
	public String getExecutionRefNo() {
		return executionRefNo;
	}

	/**
	 * Setter method for executionRefNo.
	 *
	 * @param aExecutionRefNo the new value for executionRefNo
	 */
	public void setExecutionRefNo(String aExecutionRefNo) {
		executionRefNo = aExecutionRefNo;
	}

	/**
	 * Access method for bankRrn.
	 *
	 * @return the current value of bankRrn
	 */
	public String getBankRrn() {
		return bankRrn;
	}

	/**
	 * Setter method for bankRrn.
	 *
	 * @param aBankRrn the new value for bankRrn
	 */
	public void setBankRrn(String aBankRrn) {
		bankRrn = aBankRrn;
	}

	/**
	 * Access method for sipTrxnNo.
	 *
	 * @return the current value of sipTrxnNo
	 */
	public String getSipTrxnNo() {
		return sipTrxnNo;
	}

	/**
	 * Setter method for sipTrxnNo.
	 *
	 * @param aSipTrxnNo the new value for sipTrxnNo
	 */
	public void setSipTrxnNo(String aSipTrxnNo) {
		sipTrxnNo = aSipTrxnNo;
	}

	/**
	 * Access method for umn.
	 *
	 * @return the current value of umn
	 */
	public String getUmn() {
		return umn;
	}

	/**
	 * Setter method for umn.
	 *
	 * @param aUmn the new value for umn
	 */
	public void setUmn(String aUmn) {
		umn = aUmn;
	}

	/**
	 * Access method for debitTryCount.
	 *
	 * @return the current value of debitTryCount
	 */
	public int getDebitTryCount() {
		return debitTryCount;
	}

	/**
	 * Setter method for debitTryCount.
	 *
	 * @param aDebitTryCount the new value for debitTryCount
	 */
	public void setDebitTryCount(int aDebitTryCount) {
		debitTryCount = aDebitTryCount;
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
	 * Access method for callbackTime.
	 *
	 * @return the current value of callbackTime
	 */
	public Date getCallbackTime() {
		return callbackTime;
	}

	/**
	 * Setter method for callbackTime.
	 *
	 * @param aCallbackTime the new value for callbackTime
	 */
	public void setCallbackTime(Date aCallbackTime) {
		callbackTime = aCallbackTime;
	}

	/**
	 * Access method for debitResponse.
	 *
	 * @return the current value of debitResponse
	 */
	public String getDebitResponse() {
		return debitResponse;
	}

	/**
	 * Setter method for debitResponse.
	 *
	 * @param aDebitResponse the new value for debitResponse
	 */
	public void setDebitResponse(String aDebitResponse) {
		debitResponse = aDebitResponse;
	}

	/**
	 * Access method for debitStatusResponse.
	 *
	 * @return the current value of debitStatusResponse
	 */
	public String getDebitStatusResponse() {
		return debitStatusResponse;
	}

	/**
	 * Setter method for debitStatusResponse.
	 *
	 * @param aDebitStatusResponse the new value for debitStatusResponse
	 */
	public void setDebitStatusResponse(String aDebitStatusResponse) {
		debitStatusResponse = aDebitStatusResponse;
	}

	/**
	 * Access method for debitStatusTrycount.
	 *
	 * @return the current value of debitStatusTrycount
	 */
	public int getDebitStatusTrycount() {
		return debitStatusTrycount;
	}

	/**
	 * Setter method for debitStatusTrycount.
	 *
	 * @param aDebitStatusTrycount the new value for debitStatusTrycount
	 */
	public void setDebitStatusTrycount(int aDebitStatusTrycount) {
		debitStatusTrycount = aDebitStatusTrycount;
	}

	/**
	 * Access method for bankError.
	 *
	 * @return the current value of bankError
	 */
	public String getBankError() {
		return bankError;
	}

	/**
	 * Setter method for bankError.
	 *
	 * @param aBankError the new value for bankError
	 */
	public void setBankError(String aBankError) {
		bankError = aBankError;
	}

	/**
	 * Access method for bankErrorCode.
	 *
	 * @return the current value of bankErrorCode
	 */
	public String getBankErrorCode() {
		return bankErrorCode;
	}

	/**
	 * Setter method for bankErrorCode.
	 *
	 * @param aBankErrorCode the new value for bankErrorCode
	 */
	public void setBankErrorCode(String aBankErrorCode) {
		bankErrorCode = aBankErrorCode;
	}

	/**
	 * Access method for receiptMode.
	 *
	 * @return the current value of receiptMode
	 */
	public String getReceiptMode() {
		return receiptMode;
	}

	/**
	 * Setter method for receiptMode.
	 *
	 * @param aReceiptMode the new value for receiptMode
	 */
	public void setReceiptMode(String aReceiptMode) {
		receiptMode = aReceiptMode;
	}

	/**
	 * Access method for receiptType.
	 *
	 * @return the current value of receiptType
	 */
	public String getReceiptType() {
		return receiptType;
	}

	/**
	 * Setter method for receiptType.
	 *
	 * @param aReceiptType the new value for receiptType
	 */
	public void setReceiptType(String aReceiptType) {
		receiptType = aReceiptType;
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
	 * Access method for lmsAbsorbTime.
	 *
	 * @return the current value of lmsAbsorbTime
	 */
	public Date getLmsAbsorbTime() {
		return lmsAbsorbTime;
	}

	/**
	 * Setter method for lmsAbsorbTime.
	 *
	 * @param aLmsAbsorbTime the new value for lmsAbsorbTime
	 */
	public void setLmsAbsorbTime(Date aLmsAbsorbTime) {
		lmsAbsorbTime = aLmsAbsorbTime;
	}

	/**
	 * Access method for lmsRejectReason.
	 *
	 * @return the current value of lmsRejectReason
	 */
	public String getLmsRejectReason() {
		return lmsRejectReason;
	}

	/**
	 * Setter method for lmsRejectReason.
	 *
	 * @param aLmsRejectReason the new value for lmsRejectReason
	 */
	public void setLmsRejectReason(String aLmsRejectReason) {
		lmsRejectReason = aLmsRejectReason;
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
	 * Access method for modifyTime.
	 *
	 * @return the current value of modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * Setter method for modifyTime.
	 *
	 * @param aModifyTime the new value for modifyTime
	 */
	public void setModifyTime(Date aModifyTime) {
		modifyTime = aModifyTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankError, bankErrorCode, bankName, bankRrn, callback, callbackTime, cpMdtRefNo, createTime,
				custId, debitDate, debitResponse, debitStatusResponse, debitStatusTrycount, debitTryCount, edi,
				execTrxnNo, executionRefNo, id, lmsAbsorbTime, lmsRejectReason, loanId, loanNo, mndtExecDesc,
				mndtExecEndtime, mndtExecStarttime, mndtExecStatus, mndtExecTime, mndtExecTimetaken, modifyTime,
				preDebitDesc, preDebitStatus, preDebitTime, predebitDate, predebitResponse, receiptLogId, receiptMode,
				receiptType, receivableId, seqNo, sipTrxnNo, status, umn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiptsYblUpi other = (ReceiptsYblUpi) obj;
		return Objects.equals(bankError, other.bankError) && Objects.equals(bankErrorCode, other.bankErrorCode)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(bankRrn, other.bankRrn)
				&& Objects.equals(callback, other.callback) && Objects.equals(callbackTime, other.callbackTime)
				&& Objects.equals(cpMdtRefNo, other.cpMdtRefNo) && Objects.equals(createTime, other.createTime)
				&& custId == other.custId && Objects.equals(debitDate, other.debitDate)
				&& Objects.equals(debitResponse, other.debitResponse)
				&& Objects.equals(debitStatusResponse, other.debitStatusResponse)
				&& debitStatusTrycount == other.debitStatusTrycount && debitTryCount == other.debitTryCount
				&& Double.doubleToLongBits(edi) == Double.doubleToLongBits(other.edi)
				&& Objects.equals(execTrxnNo, other.execTrxnNo) && Objects.equals(executionRefNo, other.executionRefNo)
				&& id == other.id && Objects.equals(lmsAbsorbTime, other.lmsAbsorbTime)
				&& Objects.equals(lmsRejectReason, other.lmsRejectReason) && loanId == other.loanId
				&& Objects.equals(loanNo, other.loanNo) && Objects.equals(mndtExecDesc, other.mndtExecDesc)
				&& Objects.equals(mndtExecEndtime, other.mndtExecEndtime)
				&& Objects.equals(mndtExecStarttime, other.mndtExecStarttime)
				&& Objects.equals(mndtExecStatus, other.mndtExecStatus)
				&& Objects.equals(mndtExecTime, other.mndtExecTime) && mndtExecTimetaken == other.mndtExecTimetaken
				&& Objects.equals(modifyTime, other.modifyTime) && Objects.equals(preDebitDesc, other.preDebitDesc)
				&& Objects.equals(preDebitStatus, other.preDebitStatus)
				&& Objects.equals(preDebitTime, other.preDebitTime) && Objects.equals(predebitDate, other.predebitDate)
				&& Objects.equals(predebitResponse, other.predebitResponse) && receiptLogId == other.receiptLogId
				&& Objects.equals(receiptMode, other.receiptMode) && Objects.equals(receiptType, other.receiptType)
				&& receivableId == other.receivableId && Objects.equals(seqNo, other.seqNo)
				&& Objects.equals(sipTrxnNo, other.sipTrxnNo) && Objects.equals(status, other.status)
				&& Objects.equals(umn, other.umn);
	}

	@Override
	public String toString() {
		return String.format(
				"ReceiptsYblUpi [id=%s, loanId=%s, receiptLogId=%s, loanNo=%s, custId=%s, bankName=%s, cpMdtRefNo=%s, edi=%s, predebitDate=%s, debitDate=%s, preDebitTime=%s, seqNo=%s, receivableId=%s, preDebitStatus=%s, preDebitDesc=%s, predebitResponse=%s, execTrxnNo=%s, mndtExecTime=%s, mndtExecTimetaken=%s, mndtExecStarttime=%s, mndtExecEndtime=%s, mndtExecStatus=%s, mndtExecDesc=%s, executionRefNo=%s, bankRrn=%s, sipTrxnNo=%s, umn=%s, debitTryCount=%s, callback=%s, callbackTime=%s, debitResponse=%s, debitStatusResponse=%s, debitStatusTrycount=%s, bankError=%s, bankErrorCode=%s, receiptMode=%s, receiptType=%s, status=%s, lmsAbsorbTime=%s, lmsRejectReason=%s, createTime=%s, modifyTime=%s, getClass()=%s, toString()=%s]",
				id, loanId, receiptLogId, loanNo, custId, bankName, cpMdtRefNo, edi, predebitDate, debitDate,
				preDebitTime, seqNo, receivableId, preDebitStatus, preDebitDesc, predebitResponse, execTrxnNo,
				mndtExecTime, mndtExecTimetaken, mndtExecStarttime, mndtExecEndtime, mndtExecStatus, mndtExecDesc,
				executionRefNo, bankRrn, sipTrxnNo, umn, debitTryCount, callback, callbackTime, debitResponse,
				debitStatusResponse, debitStatusTrycount, bankError, bankErrorCode, receiptMode, receiptType, status,
				lmsAbsorbTime, lmsRejectReason, createTime, modifyTime, getClass(), super.toString());
	}

}
