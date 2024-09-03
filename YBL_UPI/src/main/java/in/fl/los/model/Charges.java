// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * Data model class of lms_charges table Consists access methods for columns
 * present in the lms_charges table
 * 
 * @author Ashwin Kumar V
 *
 */
@Entity(name = "lms_charges")
public class Charges implements Serializable {

	private static final long serialVersionUID = 3592237728515885260L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "loan_id", precision = 10)
	private int loanId;
	@Column(name = "ChargeID", length = 15)
	private String chargeID;
	@Column(name = "loan_no", length = 30)
	private String loanNo;
	@Column(name = "charge_amount", precision = 15)
	private float chargeAmount;
	@Column(name = "tax_amount", precision = 15)
	private float taxAmount;

	@Column(name = "status", length = 50)
	private String status;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "charge_collected", precision = 15)
	private float chargeCollected;
	@Column(name = "tax_collected", precision = 15)
	private float taxCollected;
	@Column(name = "createdBy", length = 10)
	private String createUser;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modifiedBy", length = 10)
	private String modifyUser;
	@Column(name = "update_time")
	private Date modifyTime;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	/** Default constructor. */
	public Charges() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getloanId() {
		return loanId;
	}

	public void setloanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getChargeID() {
		return chargeID;
	}

	public void setChargeID(String chargeID) {
		this.chargeID = chargeID;
	}

	public float getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(float chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public float getChargeCollected() {
		return chargeCollected;
	}

	public void setChargeCollected(float chargeCollected) {
		this.chargeCollected = chargeCollected;
	}

	public float getTaxCollected() {
		return taxCollected;
	}

	public void setTaxCollected(float taxCollected) {
		this.taxCollected = taxCollected;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(chargeAmount);
		result = prime * result + Float.floatToIntBits(chargeCollected);
		result = prime * result + ((chargeID == null) ? 0 : chargeID.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((loanNo == null) ? 0 : loanNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Float.floatToIntBits(taxAmount);
		result = prime * result + Float.floatToIntBits(taxCollected);
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
		Charges other = (Charges) obj;
		if (Float.floatToIntBits(chargeAmount) != Float.floatToIntBits(other.chargeAmount))
			return false;
		if (Float.floatToIntBits(chargeCollected) != Float.floatToIntBits(other.chargeCollected))
			return false;
		if (chargeID == null) {
			if (other.chargeID != null)
				return false;
		} else if (!chargeID.equals(other.chargeID))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (loanNo == null) {
			if (other.loanNo != null)
				return false;
		} else if (!loanNo.equals(other.loanNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Float.floatToIntBits(taxAmount) != Float.floatToIntBits(other.taxAmount))
			return false;
		if (Float.floatToIntBits(taxCollected) != Float.floatToIntBits(other.taxCollected))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Charges [id=" + id + ", chargeID=" + chargeID + ", loanNo=" + loanNo + ", chargeAmount=" + chargeAmount
				+ ", taxAmount=" + taxAmount + ", status=" + status + ", dueDate=" + dueDate + ", chargeCollected="
				+ chargeCollected + ", taxCollected=" + taxCollected + "]";
	}

}
