/**
 * 
 */
package in.fl.los.request;

/**
 * 
 *
 * @author Rajesh
 * @version 1
 */
public class SnapShotMetaDataDetails {
	private short orderId;
	private short frameOrder;
	private Float orientationPitch;
	private String mobileModel;
	private int cameraWidth;
	private int cameraHeight;
	private int originalWidth;
	private int originalHeight;
	private int dayMillis;
	private Float latitude;
	private Float longitude;
	private Float faceX;
	private Float faceY;
	private Float eulerY;
	private Float eulerZ;
	private Float smilingProbability;
	private Float rightEyeOpen;
	private Float leftEyeOpen;
	private int width;
	private int height;
	private Float lanLeftCheekX;
	private Float lanLeftCheekY;
	private Float lanLeftEarTipX;
	private Float lanLeftEarTipY;
	private Float lanLeftEarX;
	private Float lanLeftEarY;
	private Float lanLeftEyeX;
	private Float lanLeftEyeY;
	private Float lanLeftMouthX;
	private Float lanLeftMouthY;
	private Float lanNoseBaseX;
	private Float lanNoseBaseY;
	private Float lanRightCheekX;
	private Float lanRightCheekY;
	private Float lanRightEarTipX;
	private Float lanRightEarTipY;
	private Float lanRightEarX;
	private Float lanRightEarY;
	private Float lanRightEyeX;
	private Float lanRightEyeY;
	private Float lanRightMouthX;
	private Float lanRightMouthY;
	private SnapShotContourDetails[] conFace;
	private SnapShotContourDetails[] conLeftEyebrowTop;
	private SnapShotContourDetails[] conLeftEyebrowBottom;
	private SnapShotContourDetails[] conRightEyebrowTop;
	private SnapShotContourDetails[] conRightEyebrowBottom;
	private SnapShotContourDetails[] conLeftEye;
	private SnapShotContourDetails[] conRightEye;
	private SnapShotContourDetails[] conUpperLipTop;
	private SnapShotContourDetails[] conUpperLipBottom;
	private SnapShotContourDetails[] conLowerLipTop;
	private SnapShotContourDetails[] conLowerLipBottom;
	private SnapShotContourDetails[] conNoseBridge;
	private SnapShotContourDetails[] conNoseBottom;
	private String photoData;
	
	
	/**
	 * @return the orderId
	 */
	public short getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(short orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the frameOrder
	 */
	public short getFrameOrder() {
		return frameOrder;
	}
	/**
	 * @param frameOrder the frameOrder to set
	 */
	public void setFrameOrder(short frameOrder) {
		this.frameOrder = frameOrder;
	}
	/**
	 * @return the orientationPitch
	 */
	public Float getOrientationPitch() {
		return orientationPitch;
	}
	/**
	 * @param orientationPitch the orientationPitch to set
	 */
	public void setOrientationPitch(Float orientationPitch) {
		this.orientationPitch = orientationPitch;
	}
	/**
	 * @return the mobileModel
	 */
	public String getMobileModel() {
		return mobileModel;
	}
	/**
	 * @param mobileModel the mobileModel to set
	 */
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	/**
	 * @return the cameraWidth
	 */
	public int getCameraWidth() {
		return cameraWidth;
	}
	/**
	 * @param cameraWidth the cameraWidth to set
	 */
	public void setCameraWidth(int cameraWidth) {
		this.cameraWidth = cameraWidth;
	}
	/**
	 * @return the cameraHeight
	 */
	public int getCameraHeight() {
		return cameraHeight;
	}
	/**
	 * @param cameraHeight the cameraHeight to set
	 */
	public void setCameraHeight(int cameraHeight) {
		this.cameraHeight = cameraHeight;
	}
	/**
	 * @return the originalWidth
	 */
	public int getOriginalWidth() {
		return originalWidth;
	}
	/**
	 * @param originalWidth the originalWidth to set
	 */
	public void setOriginalWidth(int originalWidth) {
		this.originalWidth = originalWidth;
	}
	/**
	 * @return the originalHeight
	 */
	public int getOriginalHeight() {
		return originalHeight;
	}
	/**
	 * @param originalHeight the originalHeight to set
	 */
	public void setOriginalHeight(int originalHeight) {
		this.originalHeight = originalHeight;
	}
	/**
	 * @return the dayMillis
	 */
	public int getDayMillis() {
		return dayMillis;
	}
	/**
	 * @param dayMillis the dayMillis to set
	 */
	public void setDayMillis(int dayMillis) {
		this.dayMillis = dayMillis;
	}
	/**
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the faceX
	 */
	public Float getFaceX() {
		return faceX;
	}
	/**
	 * @param faceX the faceX to set
	 */
	public void setFaceX(Float faceX) {
		this.faceX = faceX;
	}
	/**
	 * @return the faceY
	 */
	public Float getFaceY() {
		return faceY;
	}
	/**
	 * @param faceY the faceY to set
	 */
	public void setFaceY(Float faceY) {
		this.faceY = faceY;
	}
	/**
	 * @return the eulerY
	 */
	public Float getEulerY() {
		return eulerY;
	}
	/**
	 * @param eulerY the eulerY to set
	 */
	public void setEulerY(Float eulerY) {
		this.eulerY = eulerY;
	}
	/**
	 * @return the eulerZ
	 */
	public Float getEulerZ() {
		return eulerZ;
	}
	/**
	 * @param eulerZ the eulerZ to set
	 */
	public void setEulerZ(Float eulerZ) {
		this.eulerZ = eulerZ;
	}
	/**
	 * @return the smilingProbability
	 */
	public Float getSmilingProbability() {
		return smilingProbability;
	}
	/**
	 * @param smilingProbability the smilingProbability to set
	 */
	public void setSmilingProbability(Float smilingProbability) {
		this.smilingProbability = smilingProbability;
	}
	/**
	 * @return the rightEyeOpen
	 */
	public Float getRightEyeOpen() {
		return rightEyeOpen;
	}
	/**
	 * @param rightEyeOpen the rightEyeOpen to set
	 */
	public void setRightEyeOpen(Float rightEyeOpen) {
		this.rightEyeOpen = rightEyeOpen;
	}
	/**
	 * @return the leftEyeOpen
	 */
	public Float getLeftEyeOpen() {
		return leftEyeOpen;
	}
	/**
	 * @param leftEyeOpen the leftEyeOpen to set
	 */
	public void setLeftEyeOpen(Float leftEyeOpen) {
		this.leftEyeOpen = leftEyeOpen;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the lanLeftCheekX
	 */
	public Float getLanLeftCheekX() {
		return lanLeftCheekX;
	}
	/**
	 * @param lanLeftCheekX the lanLeftCheekX to set
	 */
	public void setLanLeftCheekX(Float lanLeftCheekX) {
		this.lanLeftCheekX = lanLeftCheekX;
	}
	/**
	 * @return the lanLeftCheekY
	 */
	public Float getLanLeftCheekY() {
		return lanLeftCheekY;
	}
	/**
	 * @param lanLeftCheekY the lanLeftCheekY to set
	 */
	public void setLanLeftCheekY(Float lanLeftCheekY) {
		this.lanLeftCheekY = lanLeftCheekY;
	}
	/**
	 * @return the lanLeftEarTipX
	 */
	public Float getLanLeftEarTipX() {
		return lanLeftEarTipX;
	}
	/**
	 * @param lanLeftEarTipX the lanLeftEarTipX to set
	 */
	public void setLanLeftEarTipX(Float lanLeftEarTipX) {
		this.lanLeftEarTipX = lanLeftEarTipX;
	}
	/**
	 * @return the lanLeftEarTipY
	 */
	public Float getLanLeftEarTipY() {
		return lanLeftEarTipY;
	}
	/**
	 * @param lanLeftEarTipY the lanLeftEarTipY to set
	 */
	public void setLanLeftEarTipY(Float lanLeftEarTipY) {
		this.lanLeftEarTipY = lanLeftEarTipY;
	}
	/**
	 * @return the lanLeftEarX
	 */
	public Float getLanLeftEarX() {
		return lanLeftEarX;
	}
	/**
	 * @param lanLeftEarX the lanLeftEarX to set
	 */
	public void setLanLeftEarX(Float lanLeftEarX) {
		this.lanLeftEarX = lanLeftEarX;
	}
	/**
	 * @return the lanLeftEarY
	 */
	public Float getLanLeftEarY() {
		return lanLeftEarY;
	}
	/**
	 * @param lanLeftEarY the lanLeftEarY to set
	 */
	public void setLanLeftEarY(Float lanLeftEarY) {
		this.lanLeftEarY = lanLeftEarY;
	}
	/**
	 * @return the lanLeftEyeX
	 */
	public Float getLanLeftEyeX() {
		return lanLeftEyeX;
	}
	/**
	 * @param lanLeftEyeX the lanLeftEyeX to set
	 */
	public void setLanLeftEyeX(Float lanLeftEyeX) {
		this.lanLeftEyeX = lanLeftEyeX;
	}
	/**
	 * @return the lanLeftEyeY
	 */
	public Float getLanLeftEyeY() {
		return lanLeftEyeY;
	}
	/**
	 * @param lanLeftEyeY the lanLeftEyeY to set
	 */
	public void setLanLeftEyeY(Float lanLeftEyeY) {
		this.lanLeftEyeY = lanLeftEyeY;
	}
	/**
	 * @return the lanLeftMouthX
	 */
	public Float getLanLeftMouthX() {
		return lanLeftMouthX;
	}
	/**
	 * @param lanLeftMouthX the lanLeftMouthX to set
	 */
	public void setLanLeftMouthX(Float lanLeftMouthX) {
		this.lanLeftMouthX = lanLeftMouthX;
	}
	/**
	 * @return the lanLeftMouthY
	 */
	public Float getLanLeftMouthY() {
		return lanLeftMouthY;
	}
	/**
	 * @param lanLeftMouthY the lanLeftMouthY to set
	 */
	public void setLanLeftMouthY(Float lanLeftMouthY) {
		this.lanLeftMouthY = lanLeftMouthY;
	}
	/**
	 * @return the lanNoseBaseX
	 */
	public Float getLanNoseBaseX() {
		return lanNoseBaseX;
	}
	/**
	 * @param lanNoseBaseX the lanNoseBaseX to set
	 */
	public void setLanNoseBaseX(Float lanNoseBaseX) {
		this.lanNoseBaseX = lanNoseBaseX;
	}
	/**
	 * @return the lanNoseBaseY
	 */
	public Float getLanNoseBaseY() {
		return lanNoseBaseY;
	}
	/**
	 * @param lanNoseBaseY the lanNoseBaseY to set
	 */
	public void setLanNoseBaseY(Float lanNoseBaseY) {
		this.lanNoseBaseY = lanNoseBaseY;
	}
	/**
	 * @return the lanRightCheekX
	 */
	public Float getLanRightCheekX() {
		return lanRightCheekX;
	}
	/**
	 * @param lanRightCheekX the lanRightCheekX to set
	 */
	public void setLanRightCheekX(Float lanRightCheekX) {
		this.lanRightCheekX = lanRightCheekX;
	}
	/**
	 * @return the lanRightCheekY
	 */
	public Float getLanRightCheekY() {
		return lanRightCheekY;
	}
	/**
	 * @param lanRightCheekY the lanRightCheekY to set
	 */
	public void setLanRightCheekY(Float lanRightCheekY) {
		this.lanRightCheekY = lanRightCheekY;
	}
	/**
	 * @return the lanRightEarTipX
	 */
	public Float getLanRightEarTipX() {
		return lanRightEarTipX;
	}
	/**
	 * @param lanRightEarTipX the lanRightEarTipX to set
	 */
	public void setLanRightEarTipX(Float lanRightEarTipX) {
		this.lanRightEarTipX = lanRightEarTipX;
	}
	/**
	 * @return the lanRightEarTipY
	 */
	public Float getLanRightEarTipY() {
		return lanRightEarTipY;
	}
	/**
	 * @param lanRightEarTipY the lanRightEarTipY to set
	 */
	public void setLanRightEarTipY(Float lanRightEarTipY) {
		this.lanRightEarTipY = lanRightEarTipY;
	}
	/**
	 * @return the lanRightEarX
	 */
	public Float getLanRightEarX() {
		return lanRightEarX;
	}
	/**
	 * @param lanRightEarX the lanRightEarX to set
	 */
	public void setLanRightEarX(Float lanRightEarX) {
		this.lanRightEarX = lanRightEarX;
	}
	/**
	 * @return the lanRightEarY
	 */
	public Float getLanRightEarY() {
		return lanRightEarY;
	}
	/**
	 * @param lanRightEarY the lanRightEarY to set
	 */
	public void setLanRightEarY(Float lanRightEarY) {
		this.lanRightEarY = lanRightEarY;
	}
	/**
	 * @return the lanRightEyeX
	 */
	public Float getLanRightEyeX() {
		return lanRightEyeX;
	}
	/**
	 * @param lanRightEyeX the lanRightEyeX to set
	 */
	public void setLanRightEyeX(Float lanRightEyeX) {
		this.lanRightEyeX = lanRightEyeX;
	}
	/**
	 * @return the lanRightEyeY
	 */
	public Float getLanRightEyeY() {
		return lanRightEyeY;
	}
	/**
	 * @param lanRightEyeY the lanRightEyeY to set
	 */
	public void setLanRightEyeY(Float lanRightEyeY) {
		this.lanRightEyeY = lanRightEyeY;
	}
	/**
	 * @return the lanRightMouthX
	 */
	public Float getLanRightMouthX() {
		return lanRightMouthX;
	}
	/**
	 * @param lanRightMouthX the lanRightMouthX to set
	 */
	public void setLanRightMouthX(Float lanRightMouthX) {
		this.lanRightMouthX = lanRightMouthX;
	}
	/**
	 * @return the lanRightMouthY
	 */
	public Float getLanRightMouthY() {
		return lanRightMouthY;
	}
	/**
	 * @param lanRightMouthY the lanRightMouthY to set
	 */
	public void setLanRightMouthY(Float lanRightMouthY) {
		this.lanRightMouthY = lanRightMouthY;
	}
	/**
	 * @return the conFace
	 */
	public SnapShotContourDetails[] getConFace() {
		return conFace;
	}
	/**
	 * @param conFace the conFace to set
	 */
	public void setConFace(SnapShotContourDetails[] conFace) {
		this.conFace = conFace;
	}
	/**
	 * @return the conLeftEyebrowTop
	 */
	public SnapShotContourDetails[] getConLeftEyebrowTop() {
		return conLeftEyebrowTop;
	}
	/**
	 * @param conLeftEyebrowTop the conLeftEyebrowTop to set
	 */
	public void setConLeftEyebrowTop(SnapShotContourDetails[] conLeftEyebrowTop) {
		this.conLeftEyebrowTop = conLeftEyebrowTop;
	}
	/**
	 * @return the conLeftEyebrowBottom
	 */
	public SnapShotContourDetails[] getConLeftEyebrowBottom() {
		return conLeftEyebrowBottom;
	}
	/**
	 * @param conLeftEyebrowBottom the conLeftEyebrowBottom to set
	 */
	public void setConLeftEyebrowBottom(SnapShotContourDetails[] conLeftEyebrowBottom) {
		this.conLeftEyebrowBottom = conLeftEyebrowBottom;
	}
	/**
	 * @return the conRightEyebrowTop
	 */
	public SnapShotContourDetails[] getConRightEyebrowTop() {
		return conRightEyebrowTop;
	}
	/**
	 * @param conRightEyebrowTop the conRightEyebrowTop to set
	 */
	public void setConRightEyebrowTop(SnapShotContourDetails[] conRightEyebrowTop) {
		this.conRightEyebrowTop = conRightEyebrowTop;
	}
	/**
	 * @return the conRightEyebrowBottom
	 */
	public SnapShotContourDetails[] getConRightEyebrowBottom() {
		return conRightEyebrowBottom;
	}
	/**
	 * @param conRightEyebrowBottom the conRightEyebrowBottom to set
	 */
	public void setConRightEyebrowBottom(SnapShotContourDetails[] conRightEyebrowBottom) {
		this.conRightEyebrowBottom = conRightEyebrowBottom;
	}
	/**
	 * @return the conLeftEye
	 */
	public SnapShotContourDetails[] getConLeftEye() {
		return conLeftEye;
	}
	/**
	 * @param conLeftEye the conLeftEye to set
	 */
	public void setConLeftEye(SnapShotContourDetails[] conLeftEye) {
		this.conLeftEye = conLeftEye;
	}
	/**
	 * @return the conRightEye
	 */
	public SnapShotContourDetails[] getConRightEye() {
		return conRightEye;
	}
	/**
	 * @param conRightEye the conRightEye to set
	 */
	public void setConRightEye(SnapShotContourDetails[] conRightEye) {
		this.conRightEye = conRightEye;
	}
	/**
	 * @return the conUpperLipTop
	 */
	public SnapShotContourDetails[] getConUpperLipTop() {
		return conUpperLipTop;
	}
	/**
	 * @param conUpperLipTop the conUpperLipTop to set
	 */
	public void setConUpperLipTop(SnapShotContourDetails[] conUpperLipTop) {
		this.conUpperLipTop = conUpperLipTop;
	}
	/**
	 * @return the conUpperLipBottom
	 */
	public SnapShotContourDetails[] getConUpperLipBottom() {
		return conUpperLipBottom;
	}
	/**
	 * @param conUpperLipBottom the conUpperLipBottom to set
	 */
	public void setConUpperLipBottom(SnapShotContourDetails[] conUpperLipBottom) {
		this.conUpperLipBottom = conUpperLipBottom;
	}
	/**
	 * @return the conLowerLipTop
	 */
	public SnapShotContourDetails[] getConLowerLipTop() {
		return conLowerLipTop;
	}
	/**
	 * @param conLowerLipTop the conLowerLipTop to set
	 */
	public void setConLowerLipTop(SnapShotContourDetails[] conLowerLipTop) {
		this.conLowerLipTop = conLowerLipTop;
	}
	/**
	 * @return the conLowerLipBottom
	 */
	public SnapShotContourDetails[] getConLowerLipBottom() {
		return conLowerLipBottom;
	}
	/**
	 * @param conLowerLipBottom the conLowerLipBottom to set
	 */
	public void setConLowerLipBottom(SnapShotContourDetails[] conLowerLipBottom) {
		this.conLowerLipBottom = conLowerLipBottom;
	}
	/**
	 * @return the conNoseBridge
	 */
	public SnapShotContourDetails[] getConNoseBridge() {
		return conNoseBridge;
	}
	/**
	 * @param conNoseBridge the conNoseBridge to set
	 */
	public void setConNoseBridge(SnapShotContourDetails[] conNoseBridge) {
		this.conNoseBridge = conNoseBridge;
	}
	/**
	 * @return the conNoseBottom
	 */
	public SnapShotContourDetails[] getConNoseBottom() {
		return conNoseBottom;
	}
	/**
	 * @param conNoseBottom the conNoseBottom to set
	 */
	public void setConNoseBottom(SnapShotContourDetails[] conNoseBottom) {
		this.conNoseBottom = conNoseBottom;
	}
	/**
	 * @return the imageData
	 */
	public String getPhotoData() {
		return photoData;
	}
	/**
	 * @param imageData the imageData to set
	 */
	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}
	

	
	@Override
	public String toString() {
		return String.format(
				"SnapShotMetaDataDetails [orderId=%s, frameOrder=%s, orientationPitch=%s, mobileModel=%s, cameraWidth=%s, cameraHeight=%s, originalWidth=%s, originalHeight=%s, dayMillis=%s, latitude=%s, longitude=%s, faceX=%s, faceY=%s, eulerY=%s, eulerZ=%s, smilingProbability=%s, rightEyeOpen=%s, leftEyeOpen=%s, width=%s, height=%s, lanLeftCheekX=%s, lanLeftCheekY=%s, lanLeftEarTipX=%s, lanLeftEarTipY=%s, lanLeftEarX=%s, lanLeftEarY=%s, lanLeftEyeX=%s, lanLeftEyeY=%s, lanLeftMouthX=%s, lanLeftMouthY=%s, lanNoseBaseX=%s, lanNoseBaseY=%s, lanRightCheekX=%s, lanRightCheekY=%s, lanRightEarTipX=%s, lanRightEarTipY=%s, lanRightEarX=%s, lanRightEarY=%s, lanRightEyeX=%s, lanRightEyeY=%s, lanRightMouthX=%s, lanRightMouthY=%s, conFace=%s, conLeftEyebrowTop=%s, conLeftEyebrowBottom=%s, conRightEyebrowTop=%s, conRightEyebrowBottom=%s, conLeftEye=%s, conRightEye=%s, conUpperLipTop=%s, conUpperLipBottom=%s, conLowerLipTop=%s, conLowerLipBottom=%s, conNoseBridge=%s, conNoseBottom=%s, photoDataLength=%s]",
				orderId, frameOrder, orientationPitch, mobileModel, cameraWidth, cameraHeight, originalWidth,
				originalHeight, dayMillis, latitude, longitude, faceX, faceY, eulerY, eulerZ,
				smilingProbability, rightEyeOpen, leftEyeOpen, width, height, lanLeftCheekX, lanLeftCheekY,
				lanLeftEarTipX, lanLeftEarTipY, lanLeftEarX, lanLeftEarY, lanLeftEyeX, lanLeftEyeY, lanLeftMouthX,
				lanLeftMouthY, lanNoseBaseX, lanNoseBaseY, lanRightCheekX, lanRightCheekY, lanRightEarTipX,
				lanRightEarTipY, lanRightEarX, lanRightEarY, lanRightEyeX, lanRightEyeY, lanRightMouthX, lanRightMouthY,
				conFace, conLeftEyebrowTop, conLeftEyebrowBottom, conRightEyebrowTop, conRightEyebrowBottom, conLeftEye,
				conRightEye, conUpperLipTop, conUpperLipBottom, conLowerLipTop, conLowerLipBottom, conNoseBridge,
				conNoseBottom, photoData.length());
	}
}
