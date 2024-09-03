/**
 * 
 */
package in.fl.los.request;

/**
 * 
 *
 * @author ragavan 11-Jun-2019
 * @version 1
 */
public class CustomerLocationRequestDTO {

	private double latitude;
	private double longitude;
	private double altitude;
	private String locationDetails;
	private String eventType;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public String getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "CustomerLocationRequestDTO [latitude=" + latitude + ", longitude=" + longitude + ", altitude="
				+ altitude + ", locationDetails=" + locationDetails + ", eventType=" + eventType + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
