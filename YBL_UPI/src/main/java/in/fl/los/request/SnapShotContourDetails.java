/**
 * 
 */
package in.fl.los.request;

/**
 * 
 *
 * @author ragavan
 * 23-Jan-2020
 * @version 1
 */
public class SnapShotContourDetails {

	private float x;
	private float y;
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	

	@Override
	public String toString() {
		return String.format("SnapShotContourDetails [x=%s, y=%s]", x, y);
	}
}
