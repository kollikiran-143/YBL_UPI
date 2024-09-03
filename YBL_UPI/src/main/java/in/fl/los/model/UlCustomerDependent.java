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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_customer_dependent")
public class UlCustomerDependent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5911821054007498248L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(length = 15)
	private String phoneno;
	@Column(length = 50)
	private String relationship;
	private Date dob;
	@Column(length = 100)
	private String education;
	@Column(length = 50)
	private String job;
	@Column(name = "annual_income", precision = 15)
	private float annualIncome;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;

	@OneToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

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
	public UlCustomerDependent() {
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
	 * Access method for name.
	 *
	 * @return the current value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 *
	 * @param aName the new value for name
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Access method for phoneno.
	 *
	 * @return the current value of phoneno
	 */
	public String getPhoneno() {
		return phoneno;
	}

	/**
	 * Setter method for phoneno.
	 *
	 * @param aPhoneno the new value for phoneno
	 */
	public void setPhoneno(String aPhoneno) {
		phoneno = aPhoneno;
	}

	/**
	 * Access method for relationship.
	 *
	 * @return the current value of relationship
	 */
	public String getRelationship() {
		return relationship;
	}

	/**
	 * Setter method for relationship.
	 *
	 * @param aRelationship the new value for relationship
	 */
	public void setRelationship(String aRelationship) {
		relationship = aRelationship;
	}

	/**
	 * Access method for dob.
	 *
	 * @return the current value of dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Setter method for dob.
	 *
	 * @param aDob the new value for dob
	 */
	public void setDob(Date aDob) {
		dob = aDob;
	}

	/**
	 * Access method for education.
	 *
	 * @return the current value of education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * Setter method for education.
	 *
	 * @param aEducation the new value for education
	 */
	public void setEducation(String aEducation) {
		education = aEducation;
	}

	/**
	 * Access method for job.
	 *
	 * @return the current value of job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Setter method for job.
	 *
	 * @param aJob the new value for job
	 */
	public void setJob(String aJob) {
		job = aJob;
	}

	/**
	 * Access method for annualIncome.
	 *
	 * @return the current value of annualIncome
	 */
	public float getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * Setter method for annualIncome.
	 *
	 * @param aAnnualIncome the new value for annualIncome
	 */
	public void setAnnualIncome(float aAnnualIncome) {
		annualIncome = aAnnualIncome;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(annualIncome);
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneno == null) ? 0 : phoneno.hashCode());
		result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
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
		UlCustomerDependent other = (UlCustomerDependent) obj;
		if (Float.floatToIntBits(annualIncome) != Float.floatToIntBits(other.annualIncome))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id != other.id)
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneno == null) {
			if (other.phoneno != null)
				return false;
		} else if (!phoneno.equals(other.phoneno))
			return false;
		if (relationship == null) {
			if (other.relationship != null)
				return false;
		} else if (!relationship.equals(other.relationship))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlCustomerDependent [id=%s, name=%s, phoneno=%s, relationship=%s, dob=%s, education=%s, job=%s, annualIncome=%s, createTime=%s, modifyTime=%s, customerDetails=%s]",
				id, name, phoneno, relationship, dob, education, job, annualIncome, createTime, modifyTime,
				customerDetails);
	}

}
