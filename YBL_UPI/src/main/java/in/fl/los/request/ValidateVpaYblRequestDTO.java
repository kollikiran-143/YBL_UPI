package in.fl.los.request;

public class ValidateVpaYblRequestDTO extends BaseRequestDTO {
	String vpa;

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	@Override
	public String toString() {
		return "ValidateVPARequestDTO [vpa=" + vpa + ", getFreshpassword()=" + getFreshpassword() + ", getAndroidId()="
				+ getAndroidId() + ", getCustomerId()=" + getCustomerId() + ", getImei()=" + getImei()
				+ ", getRandom()=" + getRandom() + ", getRequestCreatedAt()=" + getRequestCreatedAt()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getVersion()=" + getVersion() + ", getAppName()="
				+ getAppName() + ", getAgentId()=" + getAgentId() + ", getDeviceMake()=" + getDeviceMake()
				+ ", getOsBuild()=" + getOsBuild() + ", getNetwork()=" + getNetwork() + ", getPhoneModel()="
				+ getPhoneModel() + "]";
	}
	
}
