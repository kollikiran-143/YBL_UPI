// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_business_asset")
public class UlBusinessAsset implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(precision = 1)
	private boolean fridge;
	@Column(precision = 1)
	private boolean ac;
	@Column(precision = 1)
	private boolean fan;
	@Column(precision = 1)
	private boolean cooler;
	@Column(precision = 1)
	private boolean tv;
	@Column(precision = 1)
	private boolean boiler;
	@Column(precision = 1)
	private boolean microven;
	@Column(precision = 1)
	private boolean machines;
	@Column(name = "beauty_equipments", precision = 1)
	private boolean beautyEquipments;
	@Column(precision = 1)
	private boolean chair;
	@Column(name = "table_avail", precision = 1)
	private boolean tableAvail;
	@Column(name = "billing_system", precision = 1)
	private boolean billingSystem;
	@Column(precision = 1)
	private boolean board;
	@Column(precision = 1)
	private boolean grinder;
	@Column(name = "mixier_grinder", precision = 1)
	private boolean mixierGrinder;
	@Column(precision = 1)
	private boolean stove;
	@Column(precision = 1)
	private boolean vehicle;
	@Column(precision = 1)
	private boolean accessories;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;

	@OneToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	/** Default constructor. */
	public UlBusinessAsset() {
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
	 * Access method for fridge.
	 *
	 * @return true if and only if fridge is currently true
	 */
	public boolean getFridge() {
		return fridge;
	}

	/**
	 * Setter method for fridge.
	 *
	 * @param aFridge the new value for fridge
	 */
	public void setFridge(boolean aFridge) {
		fridge = aFridge;
	}

	/**
	 * Access method for ac.
	 *
	 * @return true if and only if ac is currently true
	 */
	public boolean getAc() {
		return ac;
	}

	/**
	 * Setter method for ac.
	 *
	 * @param aAc the new value for ac
	 */
	public void setAc(boolean aAc) {
		ac = aAc;
	}

	/**
	 * Access method for fan.
	 *
	 * @return true if and only if fan is currently true
	 */
	public boolean getFan() {
		return fan;
	}

	/**
	 * Setter method for fan.
	 *
	 * @param aFan the new value for fan
	 */
	public void setFan(boolean aFan) {
		fan = aFan;
	}

	/**
	 * Access method for cooler.
	 *
	 * @return true if and only if cooler is currently true
	 */
	public boolean getCooler() {
		return cooler;
	}

	/**
	 * Setter method for cooler.
	 *
	 * @param aCooler the new value for cooler
	 */
	public void setCooler(boolean aCooler) {
		cooler = aCooler;
	}

	/**
	 * Access method for tv.
	 *
	 * @return true if and only if tv is currently true
	 */
	public boolean getTv() {
		return tv;
	}

	/**
	 * Setter method for tv.
	 *
	 * @param aTv the new value for tv
	 */
	public void setTv(boolean aTv) {
		tv = aTv;
	}

	/**
	 * Access method for boiler.
	 *
	 * @return true if and only if boiler is currently true
	 */
	public boolean getBoiler() {
		return boiler;
	}

	/**
	 * Setter method for boiler.
	 *
	 * @param aBoiler the new value for boiler
	 */
	public void setBoiler(boolean aBoiler) {
		boiler = aBoiler;
	}

	/**
	 * Access method for microven.
	 *
	 * @return true if and only if microven is currently true
	 */
	public boolean getMicroven() {
		return microven;
	}

	/**
	 * Setter method for microven.
	 *
	 * @param aMicroven the new value for microven
	 */
	public void setMicroven(boolean aMicroven) {
		microven = aMicroven;
	}

	/**
	 * Access method for machines.
	 *
	 * @return true if and only if machines is currently true
	 */
	public boolean getMachines() {
		return machines;
	}

	/**
	 * Setter method for machines.
	 *
	 * @param aMachines the new value for machines
	 */
	public void setMachines(boolean aMachines) {
		machines = aMachines;
	}

	/**
	 * Access method for beautyEquipments.
	 *
	 * @return true if and only if beautyEquipments is currently true
	 */
	public boolean getBeautyEquipments() {
		return beautyEquipments;
	}

	/**
	 * Setter method for beautyEquipments.
	 *
	 * @param aBeautyEquipments the new value for beautyEquipments
	 */
	public void setBeautyEquipments(boolean aBeautyEquipments) {
		beautyEquipments = aBeautyEquipments;
	}

	/**
	 * Access method for chair.
	 *
	 * @return true if and only if chair is currently true
	 */
	public boolean getChair() {
		return chair;
	}

	/**
	 * Setter method for chair.
	 *
	 * @param aChair the new value for chair
	 */
	public void setChair(boolean aChair) {
		chair = aChair;
	}

	/**
	 * Access method for tableAvail.
	 *
	 * @return true if and only if tableAvail is currently true
	 */
	public boolean getTableAvail() {
		return tableAvail;
	}

	/**
	 * Setter method for tableAvail.
	 *
	 * @param aTableAvail the new value for tableAvail
	 */
	public void setTableAvail(boolean aTableAvail) {
		tableAvail = aTableAvail;
	}

	/**
	 * Access method for billingSystem.
	 *
	 * @return true if and only if billingSystem is currently true
	 */
	public boolean getBillingSystem() {
		return billingSystem;
	}

	/**
	 * Setter method for billingSystem.
	 *
	 * @param aBillingSystem the new value for billingSystem
	 */
	public void setBillingSystem(boolean aBillingSystem) {
		billingSystem = aBillingSystem;
	}

	/**
	 * Access method for board.
	 *
	 * @return true if and only if board is currently true
	 */
	public boolean getBoard() {
		return board;
	}

	/**
	 * Setter method for board.
	 *
	 * @param aBoard the new value for board
	 */
	public void setBoard(boolean aBoard) {
		board = aBoard;
	}

	/**
	 * Access method for grinder.
	 *
	 * @return true if and only if grinder is currently true
	 */
	public boolean getGrinder() {
		return grinder;
	}

	/**
	 * Setter method for grinder.
	 *
	 * @param aGrinder the new value for grinder
	 */
	public void setGrinder(boolean aGrinder) {
		grinder = aGrinder;
	}

	/**
	 * Access method for mixierGrinder.
	 *
	 * @return true if and only if mixierGrinder is currently true
	 */
	public boolean getMixierGrinder() {
		return mixierGrinder;
	}

	/**
	 * Setter method for mixierGrinder.
	 *
	 * @param aMixierGrinder the new value for mixierGrinder
	 */
	public void setMixierGrinder(boolean aMixierGrinder) {
		mixierGrinder = aMixierGrinder;
	}

	/**
	 * Access method for stove.
	 *
	 * @return true if and only if stove is currently true
	 */
	public boolean getStove() {
		return stove;
	}

	/**
	 * Setter method for stove.
	 *
	 * @param aStove the new value for stove
	 */
	public void setStove(boolean aStove) {
		stove = aStove;
	}

	/**
	 * Access method for vehicle.
	 *
	 * @return true if and only if vehicle is currently true
	 */
	public boolean getVehicle() {
		return vehicle;
	}

	/**
	 * Setter method for vehicle.
	 *
	 * @param aVehicle the new value for vehicle
	 */
	public void setVehicle(boolean aVehicle) {
		vehicle = aVehicle;
	}

	/**
	 * Access method for accessories.
	 *
	 * @return true if and only if accessories is currently true
	 */
	public boolean getAccessories() {
		return accessories;
	}

	/**
	 * Setter method for accessories.
	 *
	 * @param aAccessories the new value for accessories
	 */
	public void setAccessories(boolean aAccessories) {
		accessories = aAccessories;
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
	 * Access method for modifyTime.
	 *
	 * @return the current value of modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * Setter method for modifyTime.
	 *
	 * @param aModifyTime the new value for modifyTime
	 */
	public void setModifyTime(Date aModifyTime) {
		modifyTime = aModifyTime;
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
		result = prime * result + (ac ? 1231 : 1237);
		result = prime * result + (accessories ? 1231 : 1237);
		result = prime * result + (beautyEquipments ? 1231 : 1237);
		result = prime * result + (billingSystem ? 1231 : 1237);
		result = prime * result + (board ? 1231 : 1237);
		result = prime * result + (boiler ? 1231 : 1237);
		result = prime * result + (chair ? 1231 : 1237);
		result = prime * result + (cooler ? 1231 : 1237);
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (fan ? 1231 : 1237);
		result = prime * result + (fridge ? 1231 : 1237);
		result = prime * result + (grinder ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (machines ? 1231 : 1237);
		result = prime * result + (microven ? 1231 : 1237);
		result = prime * result + (mixierGrinder ? 1231 : 1237);
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + (stove ? 1231 : 1237);
		result = prime * result + (tableAvail ? 1231 : 1237);
		result = prime * result + (tv ? 1231 : 1237);
		result = prime * result + (vehicle ? 1231 : 1237);
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
		UlBusinessAsset other = (UlBusinessAsset) obj;
		if (ac != other.ac)
			return false;
		if (accessories != other.accessories)
			return false;
		if (beautyEquipments != other.beautyEquipments)
			return false;
		if (billingSystem != other.billingSystem)
			return false;
		if (board != other.board)
			return false;
		if (boiler != other.boiler)
			return false;
		if (chair != other.chair)
			return false;
		if (cooler != other.cooler)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (fan != other.fan)
			return false;
		if (fridge != other.fridge)
			return false;
		if (grinder != other.grinder)
			return false;
		if (id != other.id)
			return false;
		if (machines != other.machines)
			return false;
		if (microven != other.microven)
			return false;
		if (mixierGrinder != other.mixierGrinder)
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (stove != other.stove)
			return false;
		if (tableAvail != other.tableAvail)
			return false;
		if (tv != other.tv)
			return false;
		if (vehicle != other.vehicle)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlBusinessAsset [id=%s, fridge=%s, ac=%s, fan=%s, cooler=%s, tv=%s, boiler=%s, microven=%s, machines=%s, beautyEquipments=%s, chair=%s, tableAvail=%s, billingSystem=%s, board=%s, grinder=%s, mixierGrinder=%s, stove=%s, vehicle=%s, accessories=%s, createTime=%s, modifyTime=%s, customerDetails=%s]",
				id, fridge, ac, fan, cooler, tv, boiler, microven, machines, beautyEquipments, chair, tableAvail,
				billingSystem, board, grinder, mixierGrinder, stove, vehicle, accessories, createTime, modifyTime,
				customerDetails);
	}

}
