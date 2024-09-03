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

@Entity(name = "ul_personal_asset")
public class UlPersonalAsset implements Serializable {

	private static final long serialVersionUID = -6617950946175004401L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(precision = 1)
	private boolean tv;
	@Column(precision = 1)
	private boolean ac;
	@Column(precision = 1)
	private boolean fan;
	@Column(precision = 1)
	private boolean fridge;
	@Column(name = "dish_washer", precision = 1)
	private boolean dishWasher;
	@Column(name = "microwave_oven", precision = 1)
	private boolean microwaveOven;
	@Column(name = "washing_machine", precision = 1)
	private boolean washingMachine;
	@Column(name = "mixer_grinder", precision = 1)
	private boolean mixerGrinder;
	@Column(precision = 1)
	private boolean grinder;
	@Column(precision = 1)
	private boolean sofa;
	@Column(precision = 1)
	private boolean induction;
	@Column(precision = 1)
	private boolean car;
	@Column(name = "two_wheeler", precision = 1)
	private boolean twoWheeler;
	@Column(precision = 1)
	private boolean auto;
	@Column(precision = 1)
	private boolean ace;
	@Column(precision = 1)
	private boolean laptop;
	@Column(name = "smartphone", precision = 1)
	private boolean smartphone;
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

	public UlCustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(UlCustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	/** Default constructor. */
	public UlPersonalAsset() {
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
	 * Access method for dishWasher.
	 *
	 * @return true if and only if dishWasher is currently true
	 */
	public boolean getDishWasher() {
		return dishWasher;
	}

	/**
	 * Setter method for dishWasher.
	 *
	 * @param aDishWasher the new value for dishWasher
	 */
	public void setDishWasher(boolean aDishWasher) {
		dishWasher = aDishWasher;
	}

	/**
	 * Access method for microwaveOven.
	 *
	 * @return true if and only if microwaveOven is currently true
	 */
	public boolean getMicrowaveOven() {
		return microwaveOven;
	}

	/**
	 * Setter method for microwaveOven.
	 *
	 * @param aMicrowaveOven the new value for microwaveOven
	 */
	public void setMicrowaveOven(boolean aMicrowaveOven) {
		microwaveOven = aMicrowaveOven;
	}

	/**
	 * Access method for washingMachine.
	 *
	 * @return true if and only if washingMachine is currently true
	 */
	public boolean getWashingMachine() {
		return washingMachine;
	}

	/**
	 * Setter method for washingMachine.
	 *
	 * @param aWashingMachine the new value for washingMachine
	 */
	public void setWashingMachine(boolean aWashingMachine) {
		washingMachine = aWashingMachine;
	}

	/**
	 * Access method for mixerGrinder.
	 *
	 * @return true if and only if mixerGrinder is currently true
	 */
	public boolean getMixerGrinder() {
		return mixerGrinder;
	}

	/**
	 * Setter method for mixerGrinder.
	 *
	 * @param aMixerGrinder the new value for mixerGrinder
	 */
	public void setMixerGrinder(boolean aMixerGrinder) {
		mixerGrinder = aMixerGrinder;
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
	 * Access method for sofa.
	 *
	 * @return true if and only if sofa is currently true
	 */
	public boolean getSofa() {
		return sofa;
	}

	/**
	 * Setter method for sofa.
	 *
	 * @param aSofa the new value for sofa
	 */
	public void setSofa(boolean aSofa) {
		sofa = aSofa;
	}

	/**
	 * Access method for induction.
	 *
	 * @return true if and only if induction is currently true
	 */
	public boolean getInduction() {
		return induction;
	}

	/**
	 * Setter method for induction.
	 *
	 * @param aInduction the new value for induction
	 */
	public void setInduction(boolean aInduction) {
		induction = aInduction;
	}

	/**
	 * Access method for car.
	 *
	 * @return true if and only if car is currently true
	 */
	public boolean getCar() {
		return car;
	}

	/**
	 * Setter method for car.
	 *
	 * @param aCar the new value for car
	 */
	public void setCar(boolean aCar) {
		car = aCar;
	}

	/**
	 * Access method for twoWheeler.
	 *
	 * @return true if and only if twoWheeler is currently true
	 */
	public boolean getTwoWheeler() {
		return twoWheeler;
	}

	/**
	 * Setter method for twoWheeler.
	 *
	 * @param aTwoWheeler the new value for twoWheeler
	 */
	public void setTwoWheeler(boolean aTwoWheeler) {
		twoWheeler = aTwoWheeler;
	}

	/**
	 * Access method for auto.
	 *
	 * @return true if and only if auto is currently true
	 */
	public boolean getAuto() {
		return auto;
	}

	/**
	 * Setter method for auto.
	 *
	 * @param aAuto the new value for auto
	 */
	public void setAuto(boolean aAuto) {
		auto = aAuto;
	}

	/**
	 * Access method for ace.
	 *
	 * @return true if and only if ace is currently true
	 */
	public boolean getAce() {
		return ace;
	}

	/**
	 * Setter method for ace.
	 *
	 * @param aAce the new value for ace
	 */
	public void setAce(boolean aAce) {
		ace = aAce;
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

	public boolean isLaptop() {
		return laptop;
	}

	public void setLaptop(boolean laptop) {
		this.laptop = laptop;
	}

	public boolean isSmartphone() {
		return smartphone;
	}

	public void setSmartphone(boolean smartphone) {
		this.smartphone = smartphone;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ac ? 1231 : 1237);
		result = prime * result + (ace ? 1231 : 1237);
		result = prime * result + (auto ? 1231 : 1237);
		result = prime * result + (car ? 1231 : 1237);
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (dishWasher ? 1231 : 1237);
		result = prime * result + (fan ? 1231 : 1237);
		result = prime * result + (fridge ? 1231 : 1237);
		result = prime * result + (grinder ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (induction ? 1231 : 1237);
		result = prime * result + (laptop ? 1231 : 1237);
		result = prime * result + (microwaveOven ? 1231 : 1237);
		result = prime * result + (mixerGrinder ? 1231 : 1237);
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + (smartphone ? 1231 : 1237);
		result = prime * result + (sofa ? 1231 : 1237);
		result = prime * result + (tv ? 1231 : 1237);
		result = prime * result + (twoWheeler ? 1231 : 1237);
		result = prime * result + (washingMachine ? 1231 : 1237);
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
		UlPersonalAsset other = (UlPersonalAsset) obj;
		if (ac != other.ac)
			return false;
		if (ace != other.ace)
			return false;
		if (auto != other.auto)
			return false;
		if (car != other.car)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (dishWasher != other.dishWasher)
			return false;
		if (fan != other.fan)
			return false;
		if (fridge != other.fridge)
			return false;
		if (grinder != other.grinder)
			return false;
		if (id != other.id)
			return false;
		if (induction != other.induction)
			return false;
		if (laptop != other.laptop)
			return false;
		if (microwaveOven != other.microwaveOven)
			return false;
		if (mixerGrinder != other.mixerGrinder)
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (smartphone != other.smartphone)
			return false;
		if (sofa != other.sofa)
			return false;
		if (tv != other.tv)
			return false;
		if (twoWheeler != other.twoWheeler)
			return false;
		if (washingMachine != other.washingMachine)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlPersonalAsset [id=%s, tv=%s, ac=%s, fan=%s, fridge=%s, dishWasher=%s, microwaveOven=%s, washingMachine=%s, mixerGrinder=%s, grinder=%s, sofa=%s, induction=%s, car=%s, twoWheeler=%s, auto=%s, ace=%s, laptop=%s, smartphone=%s, createTime=%s, modifyTime=%s]",
				id, tv, ac, fan, fridge, dishWasher, microwaveOven, washingMachine, mixerGrinder, grinder, sofa,
				induction, car, twoWheeler, auto, ace, laptop, smartphone, createTime, modifyTime);
	}

}
