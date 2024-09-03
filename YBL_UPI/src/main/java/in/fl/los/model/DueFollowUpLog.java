// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "due_follow_up_log")
public class DueFollowUpLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8900415990796158249L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "cust_id", precision = 10)
	private int custId;
	@Column(name = "loan_no", length = 20)
	private String loanNo;
	@Column(name = "receivable_id", precision = 10, nullable = false, insertable = false, updatable = false)
	private int receivableId;
	@Column(length = 50)
	private String status;
	@Column(length = 200)
	private String comments;
	@Column(length = 20)
	private String user;
	@Column(name = "reminder_time")
	private Date reminderTime;
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	@Column(name = "update_time", nullable = false)
	private Date updateTime;
	@ManyToOne(optional = false)
	@JoinColumn(name = "receivable_id", nullable = false, referencedColumnName = "id")
	private Receivable receivable;

	/** Default constructor. */
	public DueFollowUpLog() {
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
	 * Access method for loanNo.
	 *
	 * @return the current value of loanNo
	 */
	public String getLoanNo() {
		return loanNo;
	}

	/**
	 * Setter method for loanNo.
	 *
	 * @param aLoanNo the new value for loanNo
	 */
	public void setLoanNo(String aLoanNo) {
		loanNo = aLoanNo;
	}

	/**
	 * Access method for receivableId.
	 *
	 * @return the current value of receivableId
	 */
	public int getReceivableId() {
		return receivableId;
	}

	/**
	 * Setter method for receivableId.
	 *
	 * @param aReceivableId the new value for receivableId
	 */
	public void setReceivableId(int aReceivableId) {
		receivableId = aReceivableId;
	}

	/**
	 * Access method for status.
	 *
	 * @return the current value of status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Setter method for status.
	 *
	 * @param aStatus the new value for status
	 */
	public void setStatus(String aStatus) {
		status = aStatus;
	}

	/**
	 * Access method for comments.
	 *
	 * @return the current value of comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Setter method for comments.
	 *
	 * @param aComments the new value for comments
	 */
	public void setComments(String aComments) {
		comments = aComments;
	}

	/**
	 * Access method for user.
	 *
	 * @return the current value of user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Setter method for user.
	 *
	 * @param aUser the new value for user
	 */
	public void setUser(String aUser) {
		user = aUser;
	}

	public Date getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
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

	public Receivable getReceivable() {
		return receivable;
	}

	public void setReceivable(Receivable receivable) {
		this.receivable = receivable;
	}

	/**
	 * Compares the key for this instance with another DueFollowUpLog.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class DueFollowUpLog and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DueFollowUpLog)) {
			return false;
		}
		DueFollowUpLog that = (DueFollowUpLog) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another DueFollowUpLog.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof DueFollowUpLog))
			return false;
		return this.equalKeys(other) && ((DueFollowUpLog) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[DueFollowUpLog |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}

}
