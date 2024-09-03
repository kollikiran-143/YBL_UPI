package in.fl.los.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This is base class for all request
 *
 * @author Rajesh
 * @version 1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRequestDTO {

	private String customerId;
	private String imei;
	private String random;
	private String requestCreatedAt;
	private String phoneNumber;
	private String version;
	private String appName;
	private String agentId;
	private String androidId;
	private String deviceMake;
	private String osBuild;
	private String network;
	private String phoneModel;
	private String taskType;
	private CustomerLocationRequestDTO locationRequestDTO;

//for Android ID Update	
private int freshpassword;
	
   public int getFreshpassword() {
		return freshpassword;
	}
	public void setFreshpassword(int freshpassword) {
		this.freshpassword = freshpassword;
	}
//----------------------------------------------------	
	public String getAndroidId() {
		return androidId;
	}

	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getRequestCreatedAt() {
		return requestCreatedAt;
	}

	public void setRequestCreatedAt(String requestCreatedAt) {
		this.requestCreatedAt = requestCreatedAt;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getDeviceMake() {
		return deviceMake;
	}

	public void setDeviceMake(String deviceMake) {
		this.deviceMake = deviceMake;
	}

	public String getOsBuild() {
		return osBuild;
	}

	public void setOsBuild(String osBuild) {
		this.osBuild = osBuild;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}
	
	public CustomerLocationRequestDTO getLocationRequestDTO() {
		return locationRequestDTO;
	}
	public void setLocationRequestDTO(CustomerLocationRequestDTO locationRequestDTO) {
		this.locationRequestDTO = locationRequestDTO;
	}
	
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	@Override
	public String toString() {
		return String.format(
				"BaseRequestDTO [customerId=%s, imei=%s, random=%s, requestCreatedAt=%s, phoneNumber=%s, version=%s, appName=%s, agentId=%s, androidId=%s, deviceMake=%s, osBuild=%s, network=%s, phoneModel=%s, taskType=%s, locationRequestDTO=%s, freshpassword=%s]",
				customerId, imei, random, requestCreatedAt, phoneNumber, version, appName, agentId, androidId,
				deviceMake, osBuild, network, phoneModel, taskType, locationRequestDTO, freshpassword);
	}

}
