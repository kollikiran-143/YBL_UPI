// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_other_income")
public class UlOtherIncome implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7969886839842355347L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(length = 50)
	private String type1;
	@Column(name = "monthlyIncome1", precision = 15)
	private double monthlyIncome1;
	@Column(length = 50)
	private String type2;
	@Column(name = "monthlyIncome2", precision = 15)
	private double monthlyIncome2;
	@Column(length = 50)
	private String type3;
	@Column(name = "monthlyIncome3", precision = 15)
	private double monthlyIncome3;
	@Column(name = "modify_time")
	private Date modifyTime;
	@Column(length = 50)
	private String other;
	@Column(name = "other_income", precision = 15)
	private double otherIncome;

	@OneToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	public UlCustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(UlCustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	/** Default constructor. */
	public UlOtherIncome() {
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

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public double getMonthlyIncome1() {
		return monthlyIncome1;
	}

	public void setMonthlyIncome1(double monthlyIncome1) {
		this.monthlyIncome1 = monthlyIncome1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public double getMonthlyIncome2() {
		return monthlyIncome2;
	}

	public void setMonthlyIncome2(double monthlyIncome2) {
		this.monthlyIncome2 = monthlyIncome2;
	}

	public String getType3() {
		return type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public double getMonthlyIncome3() {
		return monthlyIncome3;
	}

	public void setMonthlyIncome3(double monthlyIncome3) {
		this.monthlyIncome3 = monthlyIncome3;
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

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monthlyIncome1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyIncome2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyIncome3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		temp = Double.doubleToLongBits(otherIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
		result = prime * result + ((type3 == null) ? 0 : type3.hashCode());
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
		UlOtherIncome other = (UlOtherIncome) obj;
		if (id != other.id)
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (Double.doubleToLongBits(monthlyIncome1) != Double.doubleToLongBits(other.monthlyIncome1))
			return false;
		if (Double.doubleToLongBits(monthlyIncome2) != Double.doubleToLongBits(other.monthlyIncome2))
			return false;
		if (Double.doubleToLongBits(monthlyIncome3) != Double.doubleToLongBits(other.monthlyIncome3))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (Double.doubleToLongBits(otherIncome) != Double.doubleToLongBits(other.otherIncome))
			return false;
		if (type1 == null) {
			if (other.type1 != null)
				return false;
		} else if (!type1.equals(other.type1))
			return false;
		if (type2 == null) {
			if (other.type2 != null)
				return false;
		} else if (!type2.equals(other.type2))
			return false;
		if (type3 == null) {
			if (other.type3 != null)
				return false;
		} else if (!type3.equals(other.type3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlOtherIncome [id=%s, type1=%s, monthlyIncome1=%s, type2=%s, monthlyIncome2=%s, type3=%s, monthlyIncome3=%s, modifyTime=%s, other=%s, otherIncome=%s, customerDetails=%s]",
				id, type1, monthlyIncome1, type2, monthlyIncome2, type3, monthlyIncome3, modifyTime, other, otherIncome,
				customerDetails);
	}

}