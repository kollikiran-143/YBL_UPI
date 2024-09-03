// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Data model class of lms_registry table Consists access methods for columns
 * present in the lms_registry table
 * 
 * @author Ashwin Kumar V
 *
 */
@Entity(name = "lms_registry")
public class Registry implements Serializable {

	private static final long serialVersionUID = -7962925232509124861L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "config_key", length = 50)
	private String configKey;
	@Column(name = "config_value", length = 200)
	private String configValue;

	/** Default constructor. */
	public Registry() {
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
	 * Access method for configKey.
	 *
	 * @return the current value of configKey
	 */
	public String getConfigKey() {
		return configKey;
	}

	/**
	 * Setter method for configKey.
	 *
	 * @param aConfigKey the new value for configKey
	 */
	public void setConfigKey(String aConfigKey) {
		configKey = aConfigKey;
	}

	/**
	 * Access method for configValue.
	 *
	 * @return the current value of configValue
	 */
	public String getConfigValue() {
		return configValue;
	}

	/**
	 * Setter method for configValue.
	 *
	 * @param aConfigValue the new value for configValue
	 */
	public void setConfigValue(String aConfigValue) {
		configValue = aConfigValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configKey == null) ? 0 : configKey.hashCode());
		result = prime * result + ((configValue == null) ? 0 : configValue.hashCode());
		result = prime * result + id;
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
		Registry other = (Registry) obj;
		if (configKey == null) {
			if (other.configKey != null)
				return false;
		} else if (!configKey.equals(other.configKey))
			return false;
		if (configValue == null) {
			if (other.configValue != null)
				return false;
		} else if (!configValue.equals(other.configValue))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LmsRegistry [id=" + id + ", configKey=" + configKey + ", configValue=" + configValue + "]";
	}

}
