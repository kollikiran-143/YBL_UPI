// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

/**
 * Data model class of lms_receivable table Consists access methods for columns
 * present in the lms_receivable table
 * 
 * @author Ashwin Kumar V
 *
 */
@Entity
@Table(name = "lms_receivable", indexes = {
		@Index(name = "receivableILmsReceivableLoannoDueno", columnList = "loan_no,due_no"),
		@Index(name = "receivableILmsReceivableLoanidDueno", columnList = "loan_id,due_no") })
public class Receivable implements Serializable, Comparable<Receivable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4968382717406517459L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "loan_no", nullable = false, length = 32)
	private String loanNo;
	@Column(name = "due_no", nullable = false, precision = 5)
	private short dueNo;
	@Column(name = "due_date", nullable = false)
	private Date dueDate;
	@Column(nullable = false, precision = 12)
	private float emi;
	@Column(precision = 12)
	private float principal;
	@Column(precision = 12)
	private float interest;
	@Column(name = "prin_paid", precision = 12)
	private float prinPaid;
	@Column(name = "int_paid", precision = 12)
	private float intPaid;
	@Column(name = "prin_remaining", precision = 12)
	private float prinRemaining;
	@Column(name = "trycount", precision = 10)
	private int trycount;
	@Column(length = 15)
	private String status;
	@Column(name = "txn_date")
	private Date txnDate;
	@Column(name = "value_date")
	private Date valueDate;
	@Column(name = "book_no", length = 10)
	private String bookNo;
	@Column(name = "receipt_no", length = 40)
	private String receiptNo;
	@Column(name = "inst_status", length = 20)
	private String instStatus;
	@Column(name = "inst_time")
	private Date instTime;
	@Column(name = "create_user", length = 10)
	private String createUser;

	@Column(name = "predebit_date")
	private Date predebitDate;
	@Column(name = "predebit_day")
	private String predebitDay;
	@Column(name = "duedate_day")
	private String duedateDay;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_user", length = 10)
	private String modifyUser;
	@Column(name = "modify_time")
	private Date modifyTime;
	@ManyToOne(optional = false)
	@JoinColumn(name = "loan_id", nullable = false)
	private Loan loan;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "receivable", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<DueFollowUpLog> dueFollowUpLog;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	/** Default constructor. */
	public Receivable() {
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
	 * Access method for dueNo.
	 *
	 * @return the current value of dueNo
	 */
	public short getDueNo() {
		return dueNo;
	}

	/**
	 * Setter method for dueNo.
	 *
	 * @param aDueNo the new value for dueNo
	 */
	public void setDueNo(short aDueNo) {
		dueNo = aDueNo;
	}

	/**
	 * Access method for dueDate.
	 *
	 * @return the current value of dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Setter method for dueDate.
	 *
	 * @param aDueDate the new value for dueDate
	 */
	public void setDueDate(Date aDueDate) {
		dueDate = aDueDate;
	}

	/**
	 * Access method for emi.
	 *
	 * @return the current value of emi
	 */
	public float getEmi() {
		return emi;
	}

	/**
	 * Setter method for emi.
	 *
	 * @param aEmi the new value for emi
	 */
	public void setEmi(float aEmi) {
		emi = aEmi;
	}

	/**
	 * Access method for principal.
	 *
	 * @return the current value of principal
	 */
	public float getPrincipal() {
		return principal;
	}

	/**
	 * Setter method for principal.
	 *
	 * @param aPrincipal the new value for principal
	 */
	public void setPrincipal(float aPrincipal) {
		principal = aPrincipal;
	}

	/**
	 * Access method for interest.
	 *
	 * @return the current value of interest
	 */
	public float getInterest() {
		return interest;
	}

	/**
	 * Setter method for interest.
	 *
	 * @param aInterest the new value for interest
	 */
	public void setInterest(float aInterest) {
		interest = aInterest;
	}

	/**
	 * Access method for prinPaid.
	 *
	 * @return the current value of prinPaid
	 */
	public float getPrinPaid() {
		return prinPaid;
	}

	/**
	 * Setter method for prinPaid.
	 *
	 * @param aPrinPaid the new value for prinPaid
	 */
	public void setPrinPaid(float aPrinPaid) {
		prinPaid = aPrinPaid;
	}

	/**
	 * Access method for intPaid.
	 *
	 * @return the current value of intPaid
	 */
	public float getIntPaid() {
		return intPaid;
	}

	/**
	 * Setter method for intPaid.
	 *
	 * @param aIntPaid the new value for intPaid
	 */
	public void setIntPaid(float aIntPaid) {
		intPaid = aIntPaid;
	}

	/**
	 * Access method for prinPaid.
	 *
	 * @return the current value of prinPaid
	 */
	public float getPrinRemaining() {
		return prinRemaining;
	}

	/**
	 * Setter method for prinPaid.
	 *
	 * @param aPrinPaid the new value for prinPaid
	 */
	public void setPrinRemaining(float aPrinRemaining) {
		prinRemaining = aPrinRemaining;
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
	 * Access method for txnDate.
	 *
	 * @return the current value of txnDate
	 */
	public Date getTxnDate() {
		return txnDate;
	}

	/**
	 * Setter method for txnDate.
	 *
	 * @param aTxnDate the new value for txnDate
	 */
	public void setTxnDate(Date aTxnDate) {
		txnDate = aTxnDate;
	}

	/**
	 * Access method for valueDate.
	 *
	 * @return the current value of valueDate
	 */
	public Date getValueDate() {
		return valueDate;
	}

	/**
	 * Setter method for valueDate.
	 *
	 * @param aValueDate the new value for valueDate
	 */
	public void setValueDate(Date aValueDate) {
		valueDate = aValueDate;
	}

	/**
	 * Access method for bookNo.
	 *
	 * @return the current value of bookNo
	 */
	public String getBookNo() {
		return bookNo;
	}

	/**
	 * Setter method for bookNo.
	 *
	 * @param aBookNo the new value for bookNo
	 */
	public void setBookNo(String aBookNo) {
		bookNo = aBookNo;
	}

	/**
	 * Access method for receiptNo.
	 *
	 * @return the current value of receiptNo
	 */
	public String getReceiptNo() {
		return receiptNo;
	}

	/**
	 * Setter method for receiptNo.
	 *
	 * @param aReceiptNo the new value for receiptNo
	 */
	public void setReceiptNo(String aReceiptNo) {
		receiptNo = aReceiptNo;
	}

	/**
	 * Access method for instStatus.
	 *
	 * @return the current value of instStatus
	 */
	public String getInstStatus() {
		return instStatus;
	}

	/**
	 * Setter method for instStatus.
	 *
	 * @param aInstStatus the new value for instStatus
	 */
	public void setInstStatus(String aInstStatus) {
		instStatus = aInstStatus;
	}

	/**
	 * Access method for instTime.
	 *
	 * @return the current value of instTime
	 */
	public Date getInstTime() {
		return instTime;
	}

	/**
	 * Setter method for instTime.
	 *
	 * @param aInstTime the new value for instTime
	 */
	public void setInstTime(Date aInstTime) {
		instTime = aInstTime;
	}

	/**
	 * Access method for createUser.
	 *
	 * @return the current value of createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * Setter method for createUser.
	 *
	 * @param aCreateUser the new value for createUser
	 */
	public void setCreateUser(String aCreateUser) {
		createUser = aCreateUser;
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
	 * Access method for modifyUser.
	 *
	 * @return the current value of modifyUser
	 */
	public String getModifyUser() {
		return modifyUser;
	}

	/**
	 * Setter method for modifyUser.
	 *
	 * @param aModifyUser the new value for modifyUser
	 */
	public void setModifyUser(String aModifyUser) {
		modifyUser = aModifyUser;
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

	/**
	 * Access method for loan.
	 *
	 * @return the current value of loan
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * Setter method for loan.
	 *
	 * @param aLoan the new value for loan
	 */
	public void setLoan(Loan aLoan) {
		loan = aLoan;
	}

	/**
	 * Gets the group fragment id for member loan.
	 *
	 * @return Current value of the group fragment
	 * @see Loan
	 */
	public int getLoanId() {
		return (getLoan() == null ? null : getLoan().getId());
	}

	/**
	 * Sets the group fragment id from member loan.
	 *
	 * @param aId New value for the group fragment
	 * @see Loan
	 */
	public void setLoanId(int aId) {
		if (getLoan() != null) {
			getLoan().setId(aId);
		}
	}

	public Set<DueFollowUpLog> getDueFollowUpLog() {
		return dueFollowUpLog;
	}

	public void setDueFollowUpLog(Set<DueFollowUpLog> dueFollowUpLog) {
		this.dueFollowUpLog = dueFollowUpLog;
	}

	public int getTrycount() {
		return trycount;
	}

	public void setTrycount(int trycount) {
		this.trycount = trycount;
	}

	public Date getPredebitDate() {
		return predebitDate;
	}

	public void setPredebitDate(Date predebitDate) {
		this.predebitDate = predebitDate;
	}

	public String getPredebitDay() {
		return predebitDay;
	}

	public void setPredebitDay(String predebitDay) {
		this.predebitDay = predebitDay;
	}

	public String getDuedateDay() {
		return duedateDay;
	}

	public void setDuedateDay(String duedateDay) {
		this.duedateDay = duedateDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookNo == null) ? 0 : bookNo.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + dueNo;
		result = prime * result + Float.floatToIntBits(emi);
		result = prime * result + id;
		result = prime * result + ((instStatus == null) ? 0 : instStatus.hashCode());
		result = prime * result + ((instTime == null) ? 0 : instTime.hashCode());
		result = prime * result + Float.floatToIntBits(prinRemaining);
		result = prime * result + Float.floatToIntBits(intPaid);
		result = prime * result + Float.floatToIntBits(interest);
		result = prime * result + ((loanNo == null) ? 0 : loanNo.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((modifyUser == null) ? 0 : modifyUser.hashCode());
		result = prime * result + Float.floatToIntBits(prinPaid);
		result = prime * result + Float.floatToIntBits(principal);
		result = prime * result + ((receiptNo == null) ? 0 : receiptNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + trycount;
		result = prime * result + ((txnDate == null) ? 0 : txnDate.hashCode());
		result = prime * result + ((valueDate == null) ? 0 : valueDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receivable other = (Receivable) obj;
		if (bookNo == null) {
			if (other.bookNo != null)
				return false;
		} else if (!bookNo.equals(other.bookNo))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (dueNo != other.dueNo)
			return false;
		if (Float.floatToIntBits(emi) != Float.floatToIntBits(other.emi))
			return false;
		if (id != other.id)
			return false;
		if (instStatus == null) {
			if (other.instStatus != null)
				return false;
		} else if (!instStatus.equals(other.instStatus))
			return false;
		if (instTime == null) {
			if (other.instTime != null)
				return false;
		} else if (!instTime.equals(other.instTime))
			return false;
		if (Float.floatToIntBits(intPaid) != Float.floatToIntBits(other.intPaid))
			return false;
		if (Float.floatToIntBits(interest) != Float.floatToIntBits(other.interest))
			return false;
		if (loanNo == null) {
			if (other.loanNo != null)
				return false;
		} else if (!loanNo.equals(other.loanNo))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (modifyUser == null) {
			if (other.modifyUser != null)
				return false;
		} else if (!modifyUser.equals(other.modifyUser))
			return false;
		if (Float.floatToIntBits(prinRemaining) != Float.floatToIntBits(other.prinRemaining))
			return false;
		if (Float.floatToIntBits(prinPaid) != Float.floatToIntBits(other.prinPaid))
			return false;
		if (Float.floatToIntBits(principal) != Float.floatToIntBits(other.principal))
			return false;
		if (receiptNo == null) {
			if (other.receiptNo != null)
				return false;
		} else if (!receiptNo.equals(other.receiptNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (trycount != other.trycount)
			return false;
		if (txnDate == null) {
			if (other.txnDate != null)
				return false;
		} else if (!txnDate.equals(other.txnDate))
			return false;
		if (valueDate == null) {
			if (other.valueDate != null)
				return false;
		} else if (!valueDate.equals(other.valueDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Receivable [id=" + id + ", loanNo=" + loanNo + ", dueNo=" + dueNo + ", dueDate=" + dueDate + ", emi="
				+ emi + ", principal=" + principal + ", interest=" + interest + ", prinPaid=" + prinPaid + ", intPaid="
				+ intPaid + ", prinRemaining=" + prinRemaining + ", trycount=" + trycount + ", status=" + status
				+ ", txnDate=" + txnDate + ", valueDate=" + valueDate + ", bookNo=" + bookNo + ", receiptNo="
				+ receiptNo + ", instStatus=" + instStatus + ", instTime=" + instTime + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", loan="
				+ loan + "]";
	}

	@Override
	public int compareTo(Receivable compareObj) {
		return this.dueNo - compareObj.getDueNo();
	}

}
