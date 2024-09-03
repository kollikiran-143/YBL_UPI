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
 * vision_results table model class
 *
 * @author ragavan 21-May-2019
 * @version 1
 */
@Entity(name = "vision_results")
public class VisionResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5729648003070855505L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "cust_id", nullable = false, precision = 10)
	private int custId;
	@Column(name = "id_type", length = 10)
	private String idType;
	@Column(name = "id_number", length = 12)
	private String idNumber;
	@Column(name = "id_name", length = 100)
	private String idName;
	@Column(length = 10)
	private String dob;
	@Column(name = "id_father_name", length = 100)
	private String idFatherName;
	@Column(length = 10)
	private String gender;
	@Column(length = 250)
	private String address;
	@Column(name = "reject_reason", length = 50)
	private String rejectReason;
	@Column(name = "human_face", nullable = false, length = 3)
	private boolean humanFace;
	@Column(nullable = false, length = 3)
	private boolean usable;
	@Column(precision = 5)
	private float confidence;
	@Column(name = "file_name", length = 50)
	private String fileName;
	@Column(name = "create_time")
	private Date createTime;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	/** Default constructor. */
	public VisionResults() {
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
	 * Access method for idNumber.
	 *
	 * @return the current value of idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Setter method for idNumber.
	 *
	 * @param aIdNumber the new value for idNumber
	 */
	public void setIdNumber(String aIdNumber) {
		idNumber = aIdNumber;
	}

	/**
	 * Access method for idName.
	 *
	 * @return the current value of idName
	 */
	public String getIdName() {
		return idName;
	}

	/**
	 * Setter method for idName.
	 *
	 * @param aIdName the new value for idName
	 */
	public void setIdName(String aIdName) {
		idName = aIdName;
	}

	/**
	 * Access method for dob.
	 *
	 * @return the current value of dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Setter method for dob.
	 *
	 * @param aDob the new value for dob
	 */
	public void setDob(String aDob) {
		dob = aDob;
	}

	/**
	 * Access method for idFatherName.
	 *
	 * @return the current value of idFatherName
	 */
	public String getIdFatherName() {
		return idFatherName;
	}

	/**
	 * Setter method for idFatherName.
	 *
	 * @param aIdFatherName the new value for idFatherName
	 */
	public void setIdFatherName(String aIdFatherName) {
		idFatherName = aIdFatherName;
	}

	/**
	 * Access method for gender.
	 *
	 * @return the current value of gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter method for gender.
	 *
	 * @param aGender the new value for gender
	 */
	public void setGender(String aGender) {
		gender = aGender;
	}

	/**
	 * Access method for address.
	 *
	 * @return the current value of address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for address.
	 *
	 * @param aAddress the new value for address
	 */
	public void setAddress(String aAddress) {
		address = aAddress;
	}

	/**
	 * Access method for rejectReason.
	 *
	 * @return the current value of rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * Setter method for rejectReason.
	 *
	 * @param aRejectReason the new value for rejectReason
	 */
	public void setRejectReason(String aRejectReason) {
		rejectReason = aRejectReason;
	}

	/**
	 * Access method for humanFace.
	 *
	 * @return true if and only if humanFace is currently true
	 */
	public boolean isHumanFace() {
		return humanFace;
	}

	/**
	 * Setter method for humanFace.
	 *
	 * @param aHumanFace the new value for humanFace
	 */
	public void setHumanFace(boolean aHumanFace) {
		humanFace = aHumanFace;
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
	 * Access method for confidence.
	 *
	 * @return the current value of confidence
	 */
	public float getConfidence() {
		return confidence;
	}

	/**
	 * Setter method for confidence.
	 *
	 * @param aConfidence the new value for confidence
	 */
	public void setConfidence(float aConfidence) {
		confidence = aConfidence;
	}

	/**
	 * Access method for fileName.
	 *
	 * @return the current value of fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Setter method for fileName.
	 *
	 * @param aFileName the new value for fileName
	 */
	public void setFileName(String aFileName) {
		fileName = aFileName;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Float.floatToIntBits(confidence);
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + custId;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (humanFace ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((idFatherName == null) ? 0 : idFatherName.hashCode());
		result = prime * result + ((idName == null) ? 0 : idName.hashCode());
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((rejectReason == null) ? 0 : rejectReason.hashCode());
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
		VisionResults other = (VisionResults) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Float.floatToIntBits(confidence) != Float.floatToIntBits(other.confidence))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (custId != other.custId)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (humanFace != other.humanFace)
			return false;
		if (id != other.id)
			return false;
		if (idFatherName == null) {
			if (other.idFatherName != null)
				return false;
		} else if (!idFatherName.equals(other.idFatherName))
			return false;
		if (idName == null) {
			if (other.idName != null)
				return false;
		} else if (!idName.equals(other.idName))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (rejectReason == null) {
			if (other.rejectReason != null)
				return false;
		} else if (!rejectReason.equals(other.rejectReason))
			return false;
		if (usable != other.usable)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisionResults [id=" + id + ", custId=" + custId + ", idType=" + idType + ", idNumber=" + idNumber
				+ ", idName=" + idName + ", dob=" + dob + ", idFatherName=" + idFatherName + ", gender=" + gender
				+ ", address=" + address + ", rejectReason=" + rejectReason + ", humanFace=" + humanFace + ", usable="
				+ usable + ", confidence=" + confidence + ", fileName=" + fileName + ", createTime=" + createTime + "]";
	}

}
