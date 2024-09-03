// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * Data model class of lms_customer table Consists access methods for columns
 * present in the lms_customer table
 * 
 * @author Ashwin Kumar V
 *
 */
@Entity(name = "lms_customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 709478873495958475L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "los_id", precision = 10)
	private int losId;
	@Column(precision = 10)
	private int pid;
	@Column(name = "disp_name", length = 100)
	private String dispName;
	@Column(length = 10)
	private String phone1;
	@Column(length = 10)
	private String phone2;
	@Column(length = 10)
	private String phone3;
	@Column(length = 50)
	private String email;
	@Column(name = "door_no", length = 100)
	private String doorNo;
	@Column(length = 100)
	private String area;
	@Column(length = 100)
	private String landmark;
	@Column(length = 100)
	private String city;
	@Column(length = 100)
	private String state;
	@Column(length = 6)
	private String pincode;
	@Column(name = "state_code", length = 4)
	private String stateCode;
	@Column(name = "marital_status", length = 8)
	private String maritalStatus;
	@Column(name = "gender", length = 1)
	private String gender;
	@Column(name = "job_type", length = 22)
	private String jobType;
	@Column(name = "annual_income", precision = 10)
	private float annualIncome;
	@Column(length = 11)
	private String education;
	@Column(name = "current_emi", length = 31)
	private String currentEmi;
	@Column(name = "loan_reason", length = 20)
	private String loanReason;
	@Column(name = "own_house", length = 3)
	private boolean ownHouse;
	@Column(name = "own_twowheel", length = 3)
	private boolean ownTwowheel;
	@Column(name = "own_fourwheel", length = 3)
	private boolean ownFourwheel;
	@Column(name = "soc_bank_code", length = 12)
	private String socBankCode;
	@Column(name = "soc_bank_account", length = 20)
	private String socBankAccount;
	@Column(name = "soc_bank_name", length = 50)
	private String socBankName;
	@Column(name = "soc_bank_ifsc", length = 11)
	private String socBankIfsc;
	@Column(name = "soc_bank_cust_name", length = 50)
	private String socBankCustName;
	@Column(name = "pan_fname", length = 50)
	private String panFname;
	@Column(name = "pan_lname", length = 50)
	private String panLname;
	@Column(name = "pan_no", length = 10)
	private String panNo;
	@Column(name = "pan_dob")
	private Date panDob;
	@Column(name = "pan_name", length = 100)
	private String panName;
	@Column(name = "pan_father_name", length = 100)
	private String panFatherName;
	@Column(name = "id_md5", length = 32)
	private String idMd5;
	@Column(name = "id_sha1", length = 200)
	private String idSha1;
	@Column(name = "id_suffix", length = 12)
	private String idSuffix;
	@Column(name = "aadhar_name", length = 200)
	private String aadharName;
	@Column(name = "aadhar_phone_hash", length = 200)
	private String aadharPhoneHash;
	@Column(name = "aadhar_email_hash", length = 200)
	private String aadharEmailHash;
	@Column(name = "aadhar_co", length = 200)
	private String aadharCo;
	@Column(name = "aadhar_house", length = 100)
	private String aadharHouse;
	@Column(name = "aadhar_street", length = 200)
	private String aadharStreet;
	@Column(name = "aadhar_lm", length = 200)
	private String aadharLm;
	@Column(name = "aadhar_loc", length = 200)
	private String aadharLoc;
	@Column(name = "aadhar_vtc", length = 200)
	private String aadharVtc;
	@Column(name = "aadhar_subdistrict", length = 100)
	private String aadharSubdistrict;
	@Column(name = "aadhar_district", length = 100)
	private String aadharDistrict;
	@Column(name = "aadhar_state", length = 100)
	private String aadharState;
	@Column(name = "aadhar_po", length = 100)
	private String aadharPo;
	@Column(name = "aadhar_gender", length = 10)
	private String aadharGender;
	@Column(name = "aadhar_dob")
	private Date aadharDob;
	@Column(name = "aadhar_pincode", length = 10)
	private String aadharPincode;
	@Column(name = "aadhar_address", length = 250)
	private String aadharAddress;
	@Column(name = "create_user", length = 10)
	private String createUser;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_user", length = 10)
	private String modifyUser;
	@Column(name = "modify_time")
	private Date modifyTime;

	@OneToMany(mappedBy = "customer")
	private Set<Loan> loan;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	/** Default constructor. */
	public Customer() {
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
	 * Access method for losId.
	 *
	 * @return the current value of losId
	 */
	public int getLosId() {
		return losId;
	}

	/**
	 * Setter method for losId.
	 *
	 * @param aLosId the new value for losId
	 */
	public void setLosId(int aLosId) {
		losId = aLosId;
	}

	/**
	 * Access method for pid.
	 *
	 * @return the current value of pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * Setter method for pid.
	 *
	 * @param aPid the new value for pid
	 */
	public void setPid(int aPid) {
		pid = aPid;
	}

	/**
	 * Access method for dispName.
	 *
	 * @return the current value of dispName
	 */
	public String getDispName() {
		return dispName;
	}

	/**
	 * Setter method for dispName.
	 *
	 * @param aDispName the new value for dispName
	 */
	public void setDispName(String aDispName) {
		dispName = aDispName;
	}

	/**
	 * Access method for phone1.
	 *
	 * @return the current value of phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * Setter method for phone1.
	 *
	 * @param aPhone1 the new value for phone1
	 */
	public void setPhone1(String aPhone1) {
		phone1 = aPhone1;
	}

	/**
	 * Access method for phone2.
	 *
	 * @return the current value of phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * Setter method for phone2.
	 *
	 * @param aPhone2 the new value for phone2
	 */
	public void setPhone2(String aPhone2) {
		phone2 = aPhone2;
	}

	/**
	 * Access method for phone3.
	 *
	 * @return the current value of phone3
	 */
	public String getPhone3() {
		return phone3;
	}

	/**
	 * Setter method for phone3.
	 *
	 * @param aPhone3 the new value for phone3
	 */
	public void setPhone3(String aPhone3) {
		phone3 = aPhone3;
	}

	/**
	 * Access method for email.
	 *
	 * @return the current value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 *
	 * @param aEmail the new value for email
	 */
	public void setEmail(String aEmail) {
		email = aEmail;
	}

	/**
	 * Access method for doorNo.
	 *
	 * @return the current value of doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * Setter method for doorNo.
	 *
	 * @param aDoorNo the new value for doorNo
	 */
	public void setDoorNo(String aDoorNo) {
		doorNo = aDoorNo;
	}

	/**
	 * Access method for area.
	 *
	 * @return the current value of area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Setter method for area.
	 *
	 * @param aArea the new value for area
	 */
	public void setArea(String aArea) {
		area = aArea;
	}

	/**
	 * Access method for landmark.
	 *
	 * @return the current value of landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * Setter method for landmark.
	 *
	 * @param aLandmark the new value for landmark
	 */
	public void setLandmark(String aLandmark) {
		landmark = aLandmark;
	}

	/**
	 * Access method for city.
	 *
	 * @return the current value of city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter method for city.
	 *
	 * @param aCity the new value for city
	 */
	public void setCity(String aCity) {
		city = aCity;
	}

	/**
	 * Access method for state.
	 *
	 * @return the current value of state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter method for state.
	 *
	 * @param aCity the new value for state
	 */
	public void setState(String aState) {
		state = aState;
	}

	/**
	 * Access method for pincode.
	 *
	 * @return the current value of pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * Setter method for pincode.
	 *
	 * @param aPincode the new value for pincode
	 */
	public void setPincode(String aPincode) {
		pincode = aPincode;
	}

	/**
	 * Access method for maritalStatus.
	 *
	 * @return the current value of maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Setter method for maritalStatus.
	 *
	 * @param aMaritalStatus the new value for maritalStatus
	 */
	public void setMaritalStatus(String aMaritalStatus) {
		maritalStatus = aMaritalStatus;
	}

	/**
	 * Access method for jobType.
	 *
	 * @return the current value of jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * Setter method for jobType.
	 *
	 * @param aJobType the new value for jobType
	 */
	public void setJobType(String aJobType) {
		jobType = aJobType;
	}

	/**
	 * Access method for annualIncome.
	 *
	 * @return the current value of annualIncome
	 */
	public float getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * Setter method for annualIncome.
	 *
	 * @param aAnnualIncome the new value for annualIncome
	 */
	public void setAnnualIncome(float aAnnualIncome) {
		annualIncome = aAnnualIncome;
	}

	/**
	 * Access method for education.
	 *
	 * @return the current value of education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * Setter method for education.
	 *
	 * @param aEducation the new value for education
	 */
	public void setEducation(String aEducation) {
		education = aEducation;
	}

	/**
	 * Access method for currentEmi.
	 *
	 * @return the current value of currentEmi
	 */
	public String getCurrentEmi() {
		return currentEmi;
	}

	/**
	 * Setter method for currentEmi.
	 *
	 * @param aCurrentEmi the new value for currentEmi
	 */
	public void setCurrentEmi(String aCurrentEmi) {
		currentEmi = aCurrentEmi;
	}

	/**
	 * Access method for loanReason.
	 *
	 * @return the current value of loanReason
	 */
	public String getLoanReason() {
		return loanReason;
	}

	/**
	 * Setter method for loanReason.
	 *
	 * @param aLoanReason the new value for loanReason
	 */
	public void setLoanReason(String aLoanReason) {
		loanReason = aLoanReason;
	}

	/**
	 * Access method for ownHouse.
	 *
	 * @return true if and only if ownHouse is currently true
	 */
	public boolean getOwnHouse() {
		return ownHouse;
	}

	/**
	 * Setter method for ownHouse.
	 *
	 * @param aOwnHouse the new value for ownHouse
	 */
	public void setOwnHouse(boolean aOwnHouse) {
		ownHouse = aOwnHouse;
	}

	/**
	 * Access method for ownTwowheel.
	 *
	 * @return true if and only if ownTwowheel is currently true
	 */
	public boolean getOwnTwowheel() {
		return ownTwowheel;
	}

	/**
	 * Setter method for ownTwowheel.
	 *
	 * @param aOwnTwowheel the new value for ownTwowheel
	 */
	public void setOwnTwowheel(boolean aOwnTwowheel) {
		ownTwowheel = aOwnTwowheel;
	}

	/**
	 * Access method for ownFourwheel.
	 *
	 * @return true if and only if ownFourwheel is currently true
	 */
	public boolean getOwnFourwheel() {
		return ownFourwheel;
	}

	/**
	 * Setter method for ownFourwheel.
	 *
	 * @param aOwnFourwheel the new value for ownFourwheel
	 */
	public void setOwnFourwheel(boolean aOwnFourwheel) {
		ownFourwheel = aOwnFourwheel;
	}

	/**
	 * Access method for socBankCode.
	 *
	 * @return the current value of socBankCode
	 */
	public String getSocBankCode() {
		return socBankCode;
	}

	/**
	 * Setter method for socBankCode.
	 *
	 * @param aSocBankCode the new value for socBankCode
	 */
	public void setSocBankCode(String aSocBankCode) {
		socBankCode = aSocBankCode;
	}

	/**
	 * Access method for socBankName.
	 *
	 * @return the current value of socBankName
	 */
	public String getSocBankName() {
		return socBankName;
	}

	/**
	 * Setter method for socBankName.
	 *
	 * @param aSocBankName the new value for socBankName
	 */
	public void setSocBankName(String aSocBankName) {
		socBankName = aSocBankName;
	}

	/**
	 * Access method for socBankIfsc.
	 *
	 * @return the current value of socBankIfsc
	 */
	public String getSocBankIfsc() {
		return socBankIfsc;
	}

	/**
	 * Setter method for socBankIfsc.
	 *
	 * @param aSocBankIfsc the new value for socBankIfsc
	 */
	public void setSocBankIfsc(String aSocBankIfsc) {
		socBankIfsc = aSocBankIfsc;
	}

	/**
	 * Access method for socBankCustName.
	 *
	 * @return the current value of socBankCustName
	 */
	public String getSocBankCustName() {
		return socBankCustName;
	}

	/**
	 * Setter method for socBankCustName.
	 *
	 * @param aSocBankCustName the new value for socBankCustName
	 */
	public void setSocBankCustName(String aSocBankCustName) {
		socBankCustName = aSocBankCustName;
	}

	/**
	 * Access method for panFname.
	 *
	 * @return the current value of panFname
	 */
	public String getPanFname() {
		return panFname;
	}

	/**
	 * Setter method for panFname.
	 *
	 * @param aPanFname the new value for panFname
	 */
	public void setPanFname(String aPanFname) {
		panFname = aPanFname;
	}

	/**
	 * Access method for panLname.
	 *
	 * @return the current value of panLname
	 */
	public String getPanLname() {
		return panLname;
	}

	/**
	 * Setter method for panLname.
	 *
	 * @param aPanLname the new value for panLname
	 */
	public void setPanLname(String aPanLname) {
		panLname = aPanLname;
	}

	/**
	 * Access method for panNo.
	 *
	 * @return the current value of panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * Setter method for panNo.
	 *
	 * @param aPanNo the new value for panNo
	 */
	public void setPanNo(String aPanNo) {
		panNo = aPanNo;
	}

	/**
	 * Access method for panDob.
	 *
	 * @return the current value of panDob
	 */
	public Date getPanDob() {
		return panDob;
	}

	/**
	 * Setter method for panDob.
	 *
	 * @param aPanDob the new value for panDob
	 */
	public void setPanDob(Date aPanDob) {
		panDob = aPanDob;
	}

	/**
	 * Access method for panName.
	 *
	 * @return the current value of panName
	 */
	public String getPanName() {
		return panName;
	}

	/**
	 * Setter method for panName.
	 *
	 * @param aPanName the new value for panName
	 */
	public void setPanName(String aPanName) {
		panName = aPanName;
	}

	/**
	 * Access method for panFatherName.
	 *
	 * @return the current value of panFatherName
	 */
	public String getPanFatherName() {
		return panFatherName;
	}

	/**
	 * Setter method for panFatherName.
	 *
	 * @param aPanFatherName the new value for panFatherName
	 */
	public void setPanFatherName(String aPanFatherName) {
		panFatherName = aPanFatherName;
	}

	public String getIdMd5() {
		return idMd5;
	}

	public void setIdMd5(String idMd5) {
		this.idMd5 = idMd5;
	}

	public String getIdSha1() {
		return idSha1;
	}

	public void setIdSha1(String idSha1) {
		this.idSha1 = idSha1;
	}

	public String getIdSuffix() {
		return idSuffix;
	}

	public void setIdSuffix(String idSuffix) {
		this.idSuffix = idSuffix;
	}

	public String getAadharName() {
		return aadharName;
	}

	public void setAadharName(String aadharName) {
		this.aadharName = aadharName;
	}

	public String getAadharPhoneHash() {
		return aadharPhoneHash;
	}

	public void setAadharPhoneHash(String aadharPhoneHash) {
		this.aadharPhoneHash = aadharPhoneHash;
	}

	public String getAadharEmailHash() {
		return aadharEmailHash;
	}

	public void setAadharEmailHash(String aadharEmailHash) {
		this.aadharEmailHash = aadharEmailHash;
	}

	public String getAadharCo() {
		return aadharCo;
	}

	public void setAadharCo(String aadharCo) {
		this.aadharCo = aadharCo;
	}

	public String getAadharHouse() {
		return aadharHouse;
	}

	public void setAadharHouse(String aadharHouse) {
		this.aadharHouse = aadharHouse;
	}

	public String getAadharStreet() {
		return aadharStreet;
	}

	public void setAadharStreet(String aadharStreet) {
		this.aadharStreet = aadharStreet;
	}

	public String getAadharLm() {
		return aadharLm;
	}

	public void setAadharLm(String aadharLm) {
		this.aadharLm = aadharLm;
	}

	public String getAadharLoc() {
		return aadharLoc;
	}

	public void setAadharLoc(String aadharLoc) {
		this.aadharLoc = aadharLoc;
	}

	public String getAadharVtc() {
		return aadharVtc;
	}

	public void setAadharVtc(String aadharVtc) {
		this.aadharVtc = aadharVtc;
	}

	public String getAadharSubdistrict() {
		return aadharSubdistrict;
	}

	public void setAadharSubdistrict(String aadharSubdistrict) {
		this.aadharSubdistrict = aadharSubdistrict;
	}

	public String getAadharDistrict() {
		return aadharDistrict;
	}

	public void setAadharDistrict(String aadharDistrict) {
		this.aadharDistrict = aadharDistrict;
	}

	public String getAadharState() {
		return aadharState;
	}

	public void setAadharState(String aadharState) {
		this.aadharState = aadharState;
	}

	public String getAadharPo() {
		return aadharPo;
	}

	public void setAadharPo(String aadharPo) {
		this.aadharPo = aadharPo;
	}

	public String getAadharGender() {
		return aadharGender;
	}

	public void setAadharGender(String aadharGender) {
		this.aadharGender = aadharGender;
	}

	public Date getAadharDob() {
		return aadharDob;
	}

	public void setAadharDob(Date aadharDob) {
		this.aadharDob = aadharDob;
	}

	public String getAadharPincode() {
		return aadharPincode;
	}

	public void setAadharPincode(String aadharPincode) {
		this.aadharPincode = aadharPincode;
	}

	public String getAadharAddress() {
		return aadharAddress;
	}

	public void setAadharAddress(String aadharAddress) {
		this.aadharAddress = aadharAddress;
	}

	/**
	 * Access method for createUser.
	 *
	 * @return the current value of createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * Setter method for createUser.
	 *
	 * @param aCreateUser the new value for createUser
	 */
	public void setCreateUser(String aCreateUser) {
		createUser = aCreateUser;
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
	 * Access method for modifyUser.
	 *
	 * @return the current value of modifyUser
	 */
	public String getModifyUser() {
		return modifyUser;
	}

	/**
	 * Setter method for modifyUser.
	 *
	 * @param aModifyUser the new value for modifyUser
	 */
	public void setModifyUser(String aModifyUser) {
		modifyUser = aModifyUser;
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

	public String getSocBankAccount() {
		return socBankAccount;
	}

	public void setSocBankAccount(String socBankAccount) {
		this.socBankAccount = socBankAccount;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Access method for loan.
	 *
	 * @return the current value of loan
	 */
	public Set<Loan> getLoan() {
		return loan;
	}

	/**
	 * Setter method for loan.
	 *
	 * @param aLoan the new value for loan
	 */
	public void setLoan(Set<Loan> aLoan) {
		loan = aLoan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(annualIncome);
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((currentEmi == null) ? 0 : currentEmi.hashCode());
		result = prime * result + ((dispName == null) ? 0 : dispName.hashCode());
		result = prime * result + ((doorNo == null) ? 0 : doorNo.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result + ((landmark == null) ? 0 : landmark.hashCode());
		result = prime * result + ((loanReason == null) ? 0 : loanReason.hashCode());
		result = prime * result + losId;
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((modifyUser == null) ? 0 : modifyUser.hashCode());
		result = prime * result + (ownFourwheel ? 1231 : 1237);
		result = prime * result + (ownHouse ? 1231 : 1237);
		result = prime * result + (ownTwowheel ? 1231 : 1237);
		result = prime * result + ((panDob == null) ? 0 : panDob.hashCode());
		result = prime * result + ((panFatherName == null) ? 0 : panFatherName.hashCode());
		result = prime * result + ((panFname == null) ? 0 : panFname.hashCode());
		result = prime * result + ((panLname == null) ? 0 : panLname.hashCode());
		result = prime * result + ((panName == null) ? 0 : panName.hashCode());
		result = prime * result + ((panNo == null) ? 0 : panNo.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((phone3 == null) ? 0 : phone3.hashCode());
		result = prime * result + pid;
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((socBankCode == null) ? 0 : socBankCode.hashCode());
		result = prime * result + ((socBankCustName == null) ? 0 : socBankCustName.hashCode());
		result = prime * result + ((socBankIfsc == null) ? 0 : socBankIfsc.hashCode());
		result = prime * result + ((socBankName == null) ? 0 : socBankName.hashCode());
		result = prime * result + ((socBankAccount == null) ? 0 : socBankAccount.hashCode());
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
		Customer other = (Customer) obj;
		if (annualIncome != other.annualIncome)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (currentEmi == null) {
			if (other.currentEmi != null)
				return false;
		} else if (!currentEmi.equals(other.currentEmi))
			return false;
		if (dispName == null) {
			if (other.dispName != null)
				return false;
		} else if (!dispName.equals(other.dispName))
			return false;
		if (doorNo == null) {
			if (other.doorNo != null)
				return false;
		} else if (!doorNo.equals(other.doorNo))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;

		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;

		if (id != other.id)
			return false;
		if (jobType == null) {
			if (other.jobType != null)
				return false;
		} else if (!jobType.equals(other.jobType))
			return false;
		if (landmark == null) {
			if (other.landmark != null)
				return false;
		} else if (!landmark.equals(other.landmark))
			return false;
		if (loanReason == null) {
			if (other.loanReason != null)
				return false;
		} else if (!loanReason.equals(other.loanReason))
			return false;
		if (losId != other.losId)
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (modifyUser == null) {
			if (other.modifyUser != null)
				return false;
		} else if (!modifyUser.equals(other.modifyUser))
			return false;
		if (ownFourwheel != other.ownFourwheel)
			return false;
		if (ownHouse != other.ownHouse)
			return false;
		if (ownTwowheel != other.ownTwowheel)
			return false;
		if (panDob == null) {
			if (other.panDob != null)
				return false;
		} else if (!panDob.equals(other.panDob))
			return false;
		if (panFatherName == null) {
			if (other.panFatherName != null)
				return false;
		} else if (!panFatherName.equals(other.panFatherName))
			return false;
		if (panFname == null) {
			if (other.panFname != null)
				return false;
		} else if (!panFname.equals(other.panFname))
			return false;
		if (panLname == null) {
			if (other.panLname != null)
				return false;
		} else if (!panLname.equals(other.panLname))
			return false;
		if (panName == null) {
			if (other.panName != null)
				return false;
		} else if (!panName.equals(other.panName))
			return false;
		if (panNo == null) {
			if (other.panNo != null)
				return false;
		} else if (!panNo.equals(other.panNo))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (phone3 == null) {
			if (other.phone3 != null)
				return false;
		} else if (!phone3.equals(other.phone3))
			return false;
		if (pid != other.pid)
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;

		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;

		if (socBankCode == null) {
			if (other.socBankCode != null)
				return false;
		} else if (!socBankCode.equals(other.socBankCode))
			return false;
		if (socBankCustName == null) {
			if (other.socBankCustName != null)
				return false;
		} else if (!socBankCustName.equals(other.socBankCustName))
			return false;
		if (socBankIfsc == null) {
			if (other.socBankIfsc != null)
				return false;
		} else if (!socBankIfsc.equals(other.socBankIfsc))
			return false;
		if (socBankName == null) {
			if (other.socBankName != null)
				return false;
		} else if (!socBankName.equals(other.socBankName))
			return false;
		if (socBankAccount == null) {
			if (other.socBankAccount != null)
				return false;
		} else if (!socBankAccount.equals(other.socBankAccount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", losId=" + losId + ", pid=" + pid + ", dispName=" + dispName + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", email=" + email + ", doorNo=" + doorNo
				+ ", area=" + area + ", landmark=" + landmark + ", city=" + city + ", pincode=" + pincode
				+ ", stateCode=" + stateCode + ", maritalStatus=" + maritalStatus + ", gender=" + gender + ", jobType="
				+ jobType + ", annualIncome=" + annualIncome + ", education=" + education + ", currentEmi=" + currentEmi
				+ ", loanReason=" + loanReason + ", ownHouse=" + ownHouse + ", ownTwowheel=" + ownTwowheel
				+ ", ownFourwheel=" + ownFourwheel + ", socBankCode=" + socBankCode + ", socBankAccount="
				+ socBankAccount + ", socBankName=" + socBankName + ", socBankIfsc=" + socBankIfsc
				+ ", socBankCustName=" + socBankCustName + ", panFname=" + panFname + ", panLname=" + panLname
				+ ", panNo=" + panNo + ", panDob=" + panDob + ", panName=" + panName + ", panFatherName="
				+ panFatherName + ", createUser=" + createUser + ", createTime=" + createTime + ", modifyUser="
				+ modifyUser + ", modifyTime=" + modifyTime + "]";
	}
}
