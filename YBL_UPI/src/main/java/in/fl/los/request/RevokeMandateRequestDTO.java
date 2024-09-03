package in.fl.los.request;

public class RevokeMandateRequestDTO extends BaseRequestDTO {
	private String upiUmrnNo;

	public String getUpiUmrnNo() {
		return upiUmrnNo;
	}

	public void setUpiUmrnNo(String upiUmrnNo) {
		this.upiUmrnNo = upiUmrnNo;
	}

	@Override
	public String toString() {
		return String.format(
				"RevokeMandateRequestDTO [upiUmrnNo=%s, getFreshpassword()=%s, getAndroidId()=%s, getCustomerId()=%s, getImei()=%s, getRandom()=%s, getRequestCreatedAt()=%s, getPhoneNumber()=%s, getVersion()=%s, getAppName()=%s, getAgentId()=%s, getDeviceMake()=%s, getOsBuild()=%s, getNetwork()=%s, getPhoneModel()=%s, getLocationRequestDTO()=%s, getTaskType()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
				upiUmrnNo, getFreshpassword(), getAndroidId(), getCustomerId(), getImei(), getRandom(),
				getRequestCreatedAt(), getPhoneNumber(), getVersion(), getAppName(), getAgentId(), getDeviceMake(),
				getOsBuild(), getNetwork(), getPhoneModel(), getLocationRequestDTO(), getTaskType(), super.toString(),
				getClass(), hashCode());
	}

}
