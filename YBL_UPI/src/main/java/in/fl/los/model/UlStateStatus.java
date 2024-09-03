// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ul_state_status")
public class UlStateStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3085191613731688456L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, precision = 15)
	private int pid;
	@Column(name = "visit_id")
	private int visitId;
	@Column(length = 10)
	private String state;
	@Column(name = "username")
	private String username;
	@Column(name = "agent_id")
	private int agentId;
	@CreationTimestamp
	@Column(name = "create_time")
	private Date createTime;
	@UpdateTimestamp
	@Column(name = "modify_time")
	private Date modifyTime;
	@Column(name = "time_taken")
	private long timeTaken;
	@ManyToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public UlCustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(UlCustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agentId;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + pid;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + (int) (timeTaken ^ (timeTaken >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + visitId;
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
		UlStateStatus other = (UlStateStatus) obj;
		if (agentId != other.agentId)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id != other.id)
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (pid != other.pid)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (timeTaken != other.timeTaken)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (visitId != other.visitId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlStateStatus [id=%s, pid=%s, visitId=%s, state=%s, username=%s, agentId=%s, createTime=%s, modifyTime=%s, timeTaken=%s, customerDetails=%s]",
				id, pid, visitId, state, username, agentId, createTime, modifyTime, timeTaken, customerDetails);
	}

}
