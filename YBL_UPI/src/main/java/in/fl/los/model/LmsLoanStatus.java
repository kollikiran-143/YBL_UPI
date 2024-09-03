// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Data model class of lms_loan_status table Consists access methods for columns
 * present in the lms_loan_status table
 * 
 * @author Ashwin Kumar V
 *
 */

@Entity(name = "lms_loan_status")
public class LmsLoanStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	/*
	 * @Column(name="loan_id", nullable=false, precision=10) private int loanId;
	 */
	@Column(name = "loan_no", length = 25)
	private String loanNo;
	@Column(length = 25)
	private String status;
	@Column(name = "status_disposition", length = 50)
	private String statusDisposition;
	@Column(name = "status_remarks", length = 250)
	private String statusRemarks;
	@Column(name = "status_time")
	private Timestamp statusTime;
	@Column(name = "created_by", length = 30)
	private String createdBy;
	@Column(name = "create_time", nullable = false)
	private Timestamp createTime;
	@Column(name = "modified_by", length = 30)
	private String modifiedBy;
	@Column(name = "modified_time")
	private Timestamp modifiedTime;

	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	/** Default constructor. */
	public LmsLoanStatus() {
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
	 * Access method for statusDisposition.
	 *
	 * @return the current value of statusDisposition
	 */
	public String getStatusDisposition() {
		return statusDisposition;
	}

	/**
	 * Setter method for statusDisposition.
	 *
	 * @param aStatusDisposition the new value for statusDisposition
	 */
	public void setStatusDisposition(String aStatusDisposition) {
		statusDisposition = aStatusDisposition;
	}

	/**
	 * Access method for statusRemarks.
	 *
	 * @return the current value of statusRemarks
	 */
	public String getStatusRemarks() {
		return statusRemarks;
	}

	/**
	 * Setter method for statusRemarks.
	 *
	 * @param aStatusRemarks the new value for statusRemarks
	 */
	public void setStatusRemarks(String aStatusRemarks) {
		statusRemarks = aStatusRemarks;
	}

	/**
	 * Access method for statusTime.
	 *
	 * @return the current value of statusTime
	 */
	public Timestamp getStatusTime() {
		return statusTime;
	}

	/**
	 * Setter method for statusTime.
	 *
	 * @param aStatusTime the new value for statusTime
	 */
	public void setStatusTime(Timestamp aStatusTime) {
		statusTime = aStatusTime;
	}

	/**
	 * Access method for createdBy.
	 *
	 * @return the current value of createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter method for createdBy.
	 *
	 * @param aCreatedBy the new value for createdBy
	 */
	public void setCreatedBy(String aCreatedBy) {
		createdBy = aCreatedBy;
	}

	/**
	 * Access method for createTime.
	 *
	 * @return the current value of createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * Setter method for createTime.
	 *
	 * @param aCreateTime the new value for createTime
	 */
	public void setCreateTime(Timestamp aCreateTime) {
		createTime = aCreateTime;
	}

	/**
	 * Access method for modifiedBy.
	 *
	 * @return the current value of modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Setter method for modifiedBy.
	 *
	 * @param aModifiedBy the new value for modifiedBy
	 */
	public void setModifiedBy(String aModifiedBy) {
		modifiedBy = aModifiedBy;
	}

	/**
	 * Access method for modifiedTime.
	 *
	 * @return the current value of modifiedTime
	 */
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * Setter method for modifiedTime.
	 *
	 * @param aModifiedTime the new value for modifiedTime
	 */
	public void setModifiedTime(Timestamp aModifiedTime) {
		modifiedTime = aModifiedTime;
	}

	/**
	 * Compares the key for this instance with another LmsLoanStatus.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class LmsLoanStatus and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LmsLoanStatus)) {
			return false;
		}
		LmsLoanStatus that = (LmsLoanStatus) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another LmsLoanStatus.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof LmsLoanStatus))
			return false;
		return this.equalKeys(other) && ((LmsLoanStatus) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[LmsLoanStatus |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}

}
