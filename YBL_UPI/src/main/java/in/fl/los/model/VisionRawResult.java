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

/**
 * vision_raw_result table model class
 *
 * @author ragavan 21-May-2019
 * @version 1
 */
@Entity(name = "vision_raw_result")
public class VisionRawResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -246332045806910029L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "cust_id", nullable = false, precision = 10)
	private int custId;
	@Column(name = "id_type", length = 10)
	private String idType;
	@Column(length = 200)
	private String result;
	@Column(nullable = false, length = 3)
	private boolean usable;
	@Column(name = "create_time")
	private Date createTime;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	/** Default constructor. */
	public VisionRawResult() {
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
	 * Access method for idType.
	 *
	 * @return the current value of idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * Setter method for idType.
	 *
	 * @param aIdType the new value for idType
	 */
	public void setIdType(String aIdType) {
		idType = aIdType;
	}

	/**
	 * Access method for result.
	 *
	 * @return the current value of result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Setter method for result.
	 *
	 * @param aResult the new value for result
	 */
	public void setResult(String aResult) {
		result = aResult;
	}

	/**
	 * Access method for usable.
	 *
	 * @return true if and only if usable is currently true
	 */
	public boolean isUsable() {
		return usable;
	}

	/**
	 * Setter method for usable.
	 *
	 * @param aUsable the new value for usable
	 */
	public void setUsable(boolean aUsable) {
		usable = aUsable;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + custId;
		result = prime * result + id;
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + (usable ? 1231 : 1237);
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
		VisionRawResult other = (VisionRawResult) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (custId != other.custId)
			return false;
		if (id != other.id)
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (usable != other.usable)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisionRawResult [id=" + id + ", custId=" + custId + ", idType=" + idType + ", result=" + result
				+ ", usable=" + usable + ", createTime=" + createTime + "]";
	}

}
