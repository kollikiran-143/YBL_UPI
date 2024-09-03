// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "lms_odc_daily")
public class LmsOdcDaily implements Serializable {

	private static final long serialVersionUID = -6417119274305156117L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 11)
	private int id;
	@Column(name = "loan_id", nullable = false, precision = 11)
	private int loanId;
	@Column(name = "loan_no", nullable = false, length = 40)
	private String loanNo;
	@Column(name = "od_amount", precision = 10)
	private float odAmount;
	@Column(precision = 10)
	private float odc;
	@Column(nullable = false, length = 25)
	private String type;
	@Column(name = "value_date")
	private Date valueDate;
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	@Column(name = "created_by", length = 24)
	private String createdBy;

	/** Default constructor. */
	public LmsOdcDaily() {
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
	 * Access method for odAmount.
	 *
	 * @return the current value of odAmount
	 */
	public float getOdAmount() {
		return odAmount;
	}

	/**
	 * Setter method for odAmount.
	 *
	 * @param aOdAmount the new value for odAmount
	 */
	public void setOdAmount(float aOdAmount) {
		odAmount = aOdAmount;
	}

	/**
	 * Access method for odc.
	 *
	 * @return the current value of odc
	 */
	public float getOdc() {
		return odc;
	}

	/**
	 * Setter method for odc.
	 *
	 * @param aOdc the new value for odc
	 */
	public void setOdc(float aOdc) {
		odc = aOdc;
	}

	/**
	 * Access method for type.
	 *
	 * @return the current value of type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter method for type.
	 *
	 * @param aType the new value for type
	 */
	public void setType(String aType) {
		type = aType;
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
	 * Compares the key for this instance with another LmsOdcDaily.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class LmsOdcDaily and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LmsOdcDaily)) {
			return false;
		}
		LmsOdcDaily that = (LmsOdcDaily) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another LmsOdcDaily.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof LmsOdcDaily))
			return false;
		return this.equalKeys(other) && ((LmsOdcDaily) other).equalKeys(this);
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
		StringBuffer sb = new StringBuffer("[LmsOdcDaily |");
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
