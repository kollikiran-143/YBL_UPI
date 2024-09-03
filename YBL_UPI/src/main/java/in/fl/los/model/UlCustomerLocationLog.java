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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/***
 * customer_location_log table model class
 * 
 *
 * @author Rajesh
 * @version 1
 */
@Entity(name = "ul_customer_location_log")
public class UlCustomerLocationLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6153518799372016175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "event_type", length = 200)
	private String eventType;
	@Column(precision = 11)
	private double latitude;
	@Column(precision = 11)
	private double longitude;
	@Column(precision = 11)
	private double altitude;
	@Column(name = "location_details")
	private String locationDetails;
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	@Column(name = "update_time", nullable = false)
	private Date updateTime;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updateTime = new Date();
	}

	/** Default constructor. */
	public UlCustomerLocationLog() {
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
	 * Access method for eventType.
	 *
	 * @return the current value of eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * Setter method for eventType.
	 *
	 * @param aEventType the new value for eventType
	 */
	public void setEventType(String aEventType) {
		eventType = aEventType;
	}

	/**
	 * Access method for latitude.
	 *
	 * @return the current value of latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Setter method for latitude.
	 *
	 * @param aLatitude the new value for latitude
	 */
	public void setLatitude(double aLatitude) {
		latitude = aLatitude;
	}

	/**
	 * Access method for longitude.
	 *
	 * @return the current value of longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Setter method for longitude.
	 *
	 * @param aLongitude the new value for longitude
	 */
	public void setLongitude(double aLongitude) {
		longitude = aLongitude;
	}

	/**
	 * Access method for altitude.
	 *
	 * @return the current value of altitude
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * Setter method for altitude.
	 *
	 * @param aAltitude the new value for altitude
	 */
	public void setAltitude(double aAltitude) {
		altitude = aAltitude;
	}

	/**
	 * Access method for locationDetails.
	 *
	 * @return the current value of locationDetails
	 */
	public String getLocationDetails() {
		return locationDetails;
	}

	/**
	 * Setter method for locationDetails.
	 *
	 * @param aLocationDetails the new value for locationDetails
	 */
	public void setLocationDetails(String aLocationDetails) {
		locationDetails = aLocationDetails;
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
	 * Access method for updateTime.
	 *
	 * @return the current value of updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * Setter method for updateTime.
	 *
	 * @param aUpdateTime the new value for updateTime
	 */
	public void setUpdateTime(Date aUpdateTime) {
		updateTime = aUpdateTime;
	}

	/**
	 * Access method for customerDetails.
	 *
	 * @return the current value of customerDetails
	 */
	public UlCustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * Setter method for customerDetails.
	 *
	 * @param aCustomerDetails the new value for customerDetails
	 */
	public void setCustomerDetails(UlCustomerDetails aCustomerDetails) {
		customerDetails = aCustomerDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altitude, createTime, customerDetails, eventType, id, latitude, locationDetails, longitude,
				updateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UlCustomerLocationLog other = (UlCustomerLocationLog) obj;
		return Double.doubleToLongBits(altitude) == Double.doubleToLongBits(other.altitude)
				&& Objects.equals(createTime, other.createTime)
				&& Objects.equals(customerDetails, other.customerDetails) && Objects.equals(eventType, other.eventType)
				&& id == other.id && Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Objects.equals(locationDetails, other.locationDetails)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
				&& Objects.equals(updateTime, other.updateTime);
	}

	@Override
	public String toString() {
		return String.format(
				"UlCustomerLocationLog [id=%s, eventType=%s, latitude=%s, longitude=%s, altitude=%s, locationDetails=%s, createTime=%s, updateTime=%s, customerDetails=%s, getClass()=%s, toString()=%s]",
				id, eventType, latitude, longitude, altitude, locationDetails, createTime, updateTime, customerDetails,
				getClass(), super.toString());
	}

}
