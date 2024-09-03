package in.fl.los.request;

public class CreateUpiMandateYblRequestDTO extends BaseRequestDTO {

	private String scheduleTime;

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	@Override
	public String toString() {
		return String.format(
				"CreateUpiMandateYblRequestDTO [scheduleTime=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				scheduleTime, getClass(), hashCode(), super.toString());
	}

}
