// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

//@Entity(name = "lms_customer")
public class LmsCustomer implements Serializable {

	private static final long serialVersionUID = -6173415598200221376L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "los_id", precision = 10)
	private int losId;
	@Column(precision = 11)
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
	@Column(length = 7)
	private String gender;
	@Column(name = "job_type", length = 50)
	private String jobType;
	@Column(name = "annual_income", precision = 15)
	private double annualIncome;
	@Column(length = 11)
	private String education;
	@Column(name = "current_emi", length = 31)
	private String currentEmi;
	@Column(name = "loan_reason", length = 20)
	private String loanReason;
	@Column(name = "own_house", precision = 1)
	private boolean ownHouse;
	@Column(name = "own_twowheel", precision = 1)
	private boolean ownTwowheel;
	@Column(name = "own_fourwheel", precision = 1)
	private boolean ownFourwheel;
	@Column(name = "soc_bank_code", length = 12)
	private String socBankCode;
	@Column(name = "soc_bank_account", length = 20)
	private String socBankAccount;
	@Column(name = "soc_bank_name", length = 50)
	private String socBankName;
	@Column(name = "soc_bank_ifsc", length = 11)
	private String socBankIfsc;
	@Column(name = "soc_bank_cust_name", length = 100)
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
	@Column(name = "agmt_signer_name", length = 100)
	private String agmtSignerName;
	@Column(name = "agmt_signer_code", length = 12)
	private String agmtSignerCode;
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
	@Column(name = "pan_pic", nullable = false, precision = 1)
	private boolean panPic;
	@Column(name = "customer_pic", nullable = false, precision = 1)
	private boolean customerPic;
	@Column(name = "create_user", length = 10)
	private String createUser;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_user", length = 10)
	private String modifyUser;
	@Column(name = "modify_time")
	private Date modifyTime;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	/** Default constructor. */
	public LmsCustomer() {
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
	 * @param aState the new value for state
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
	 * Access method for stateCode.
	 *
	 * @return the current value of stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Setter method for stateCode.
	 *
	 * @param aStateCode the new value for stateCode
	 */
	public void setStateCode(String aStateCode) {
		stateCode = aStateCode;
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
	 * Access method for gender.
	 *
	 * @return the current value of gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Setter method for gender.
	 *
	 * @param aGender the new value for gender
	 */
	public void setGender(String aGender) {
		gender = aGender;
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
	public double getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * Setter method for annualIncome.
	 *
	 * @param aAnnualIncome the new value for annualIncome
	 */
	public void setAnnualIncome(double aAnnualIncome) {
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
	 * Access method for socBankAccount.
	 *
	 * @return the current value of socBankAccount
	 */
	public String getSocBankAccount() {
		return socBankAccount;
	}

	/**
	 * Setter method for socBankAccount.
	 *
	 * @param aSocBankAccount the new value for socBankAccount
	 */
	public void setSocBankAccount(String aSocBankAccount) {
		socBankAccount = aSocBankAccount;
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

	/**
	 * Access method for idMd5.
	 *
	 * @return the current value of idMd5
	 */
	public String getIdMd5() {
		return idMd5;
	}

	/**
	 * Setter method for idMd5.
	 *
	 * @param aIdMd5 the new value for idMd5
	 */
	public void setIdMd5(String aIdMd5) {
		idMd5 = aIdMd5;
	}

	/**
	 * Access method for idSha1.
	 *
	 * @return the current value of idSha1
	 */
	public String getIdSha1() {
		return idSha1;
	}

	/**
	 * Setter method for idSha1.
	 *
	 * @param aIdSha1 the new value for idSha1
	 */
	public void setIdSha1(String aIdSha1) {
		idSha1 = aIdSha1;
	}

	/**
	 * Access method for idSuffix.
	 *
	 * @return the current value of idSuffix
	 */
	public String getIdSuffix() {
		return idSuffix;
	}

	/**
	 * Setter method for idSuffix.
	 *
	 * @param aIdSuffix the new value for idSuffix
	 */
	public void setIdSuffix(String aIdSuffix) {
		idSuffix = aIdSuffix;
	}

	/**
	 * Access method for agmtSignerName.
	 *
	 * @return the current value of agmtSignerName
	 */
	public String getAgmtSignerName() {
		return agmtSignerName;
	}

	/**
	 * Setter method for agmtSignerName.
	 *
	 * @param aAgmtSignerName the new value for agmtSignerName
	 */
	public void setAgmtSignerName(String aAgmtSignerName) {
		agmtSignerName = aAgmtSignerName;
	}

	/**
	 * Access method for agmtSignerCode.
	 *
	 * @return the current value of agmtSignerCode
	 */
	public String getAgmtSignerCode() {
		return agmtSignerCode;
	}

	/**
	 * Setter method for agmtSignerCode.
	 *
	 * @param aAgmtSignerCode the new value for agmtSignerCode
	 */
	public void setAgmtSignerCode(String aAgmtSignerCode) {
		agmtSignerCode = aAgmtSignerCode;
	}

	/**
	 * Access method for aadharName.
	 *
	 * @return the current value of aadharName
	 */
	public String getAadharName() {
		return aadharName;
	}

	/**
	 * Setter method for aadharName.
	 *
	 * @param aAadharName the new value for aadharName
	 */
	public void setAadharName(String aAadharName) {
		aadharName = aAadharName;
	}

	/**
	 * Access method for aadharPhoneHash.
	 *
	 * @return the current value of aadharPhoneHash
	 */
	public String getAadharPhoneHash() {
		return aadharPhoneHash;
	}

	/**
	 * Setter method for aadharPhoneHash.
	 *
	 * @param aAadharPhoneHash the new value for aadharPhoneHash
	 */
	public void setAadharPhoneHash(String aAadharPhoneHash) {
		aadharPhoneHash = aAadharPhoneHash;
	}

	/**
	 * Access method for aadharEmailHash.
	 *
	 * @return the current value of aadharEmailHash
	 */
	public String getAadharEmailHash() {
		return aadharEmailHash;
	}

	/**
	 * Setter method for aadharEmailHash.
	 *
	 * @param aAadharEmailHash the new value for aadharEmailHash
	 */
	public void setAadharEmailHash(String aAadharEmailHash) {
		aadharEmailHash = aAadharEmailHash;
	}

	/**
	 * Access method for aadharCo.
	 *
	 * @return the current value of aadharCo
	 */
	public String getAadharCo() {
		return aadharCo;
	}

	/**
	 * Setter method for aadharCo.
	 *
	 * @param aAadharCo the new value for aadharCo
	 */
	public void setAadharCo(String aAadharCo) {
		aadharCo = aAadharCo;
	}

	/**
	 * Access method for aadharHouse.
	 *
	 * @return the current value of aadharHouse
	 */
	public String getAadharHouse() {
		return aadharHouse;
	}

	/**
	 * Setter method for aadharHouse.
	 *
	 * @param aAadharHouse the new value for aadharHouse
	 */
	public void setAadharHouse(String aAadharHouse) {
		aadharHouse = aAadharHouse;
	}

	/**
	 * Access method for aadharStreet.
	 *
	 * @return the current value of aadharStreet
	 */
	public String getAadharStreet() {
		return aadharStreet;
	}

	/**
	 * Setter method for aadharStreet.
	 *
	 * @param aAadharStreet the new value for aadharStreet
	 */
	public void setAadharStreet(String aAadharStreet) {
		aadharStreet = aAadharStreet;
	}

	/**
	 * Access method for aadharLm.
	 *
	 * @return the current value of aadharLm
	 */
	public String getAadharLm() {
		return aadharLm;
	}

	/**
	 * Setter method for aadharLm.
	 *
	 * @param aAadharLm the new value for aadharLm
	 */
	public void setAadharLm(String aAadharLm) {
		aadharLm = aAadharLm;
	}

	/**
	 * Access method for aadharLoc.
	 *
	 * @return the current value of aadharLoc
	 */
	public String getAadharLoc() {
		return aadharLoc;
	}

	/**
	 * Setter method for aadharLoc.
	 *
	 * @param aAadharLoc the new value for aadharLoc
	 */
	public void setAadharLoc(String aAadharLoc) {
		aadharLoc = aAadharLoc;
	}

	/**
	 * Access method for aadharVtc.
	 *
	 * @return the current value of aadharVtc
	 */
	public String getAadharVtc() {
		return aadharVtc;
	}

	/**
	 * Setter method for aadharVtc.
	 *
	 * @param aAadharVtc the new value for aadharVtc
	 */
	public void setAadharVtc(String aAadharVtc) {
		aadharVtc = aAadharVtc;
	}

	/**
	 * Access method for aadharSubdistrict.
	 *
	 * @return the current value of aadharSubdistrict
	 */
	public String getAadharSubdistrict() {
		return aadharSubdistrict;
	}

	/**
	 * Setter method for aadharSubdistrict.
	 *
	 * @param aAadharSubdistrict the new value for aadharSubdistrict
	 */
	public void setAadharSubdistrict(String aAadharSubdistrict) {
		aadharSubdistrict = aAadharSubdistrict;
	}

	/**
	 * Access method for aadharDistrict.
	 *
	 * @return the current value of aadharDistrict
	 */
	public String getAadharDistrict() {
		return aadharDistrict;
	}

	/**
	 * Setter method for aadharDistrict.
	 *
	 * @param aAadharDistrict the new value for aadharDistrict
	 */
	public void setAadharDistrict(String aAadharDistrict) {
		aadharDistrict = aAadharDistrict;
	}

	/**
	 * Access method for aadharState.
	 *
	 * @return the current value of aadharState
	 */
	public String getAadharState() {
		return aadharState;
	}

	/**
	 * Setter method for aadharState.
	 *
	 * @param aAadharState the new value for aadharState
	 */
	public void setAadharState(String aAadharState) {
		aadharState = aAadharState;
	}

	/**
	 * Access method for aadharPo.
	 *
	 * @return the current value of aadharPo
	 */
	public String getAadharPo() {
		return aadharPo;
	}

	/**
	 * Setter method for aadharPo.
	 *
	 * @param aAadharPo the new value for aadharPo
	 */
	public void setAadharPo(String aAadharPo) {
		aadharPo = aAadharPo;
	}

	/**
	 * Access method for aadharGender.
	 *
	 * @return the current value of aadharGender
	 */
	public String getAadharGender() {
		return aadharGender;
	}

	/**
	 * Setter method for aadharGender.
	 *
	 * @param aAadharGender the new value for aadharGender
	 */
	public void setAadharGender(String aAadharGender) {
		aadharGender = aAadharGender;
	}

	/**
	 * Access method for aadharDob.
	 *
	 * @return the current value of aadharDob
	 */
	public Date getAadharDob() {
		return aadharDob;
	}

	/**
	 * Setter method for aadharDob.
	 *
	 * @param aAadharDob the new value for aadharDob
	 */
	public void setAadharDob(Date aAadharDob) {
		aadharDob = aAadharDob;
	}

	/**
	 * Access method for aadharPincode.
	 *
	 * @return the current value of aadharPincode
	 */
	public String getAadharPincode() {
		return aadharPincode;
	}

	/**
	 * Setter method for aadharPincode.
	 *
	 * @param aAadharPincode the new value for aadharPincode
	 */
	public void setAadharPincode(String aAadharPincode) {
		aadharPincode = aAadharPincode;
	}

	/**
	 * Access method for aadharAddress.
	 *
	 * @return the current value of aadharAddress
	 */
	public String getAadharAddress() {
		return aadharAddress;
	}

	/**
	 * Setter method for aadharAddress.
	 *
	 * @param aAadharAddress the new value for aadharAddress
	 */
	public void setAadharAddress(String aAadharAddress) {
		aadharAddress = aAadharAddress;
	}

	/**
	 * Access method for panPic.
	 *
	 * @return true if and only if panPic is currently true
	 */
	public boolean getPanPic() {
		return panPic;
	}

	/**
	 * Setter method for panPic.
	 *
	 * @param aPanPic the new value for panPic
	 */
	public void setPanPic(boolean aPanPic) {
		panPic = aPanPic;
	}

	/**
	 * Access method for customerPic.
	 *
	 * @return true if and only if customerPic is currently true
	 */
	public boolean getCustomerPic() {
		return customerPic;
	}

	/**
	 * Setter method for customerPic.
	 *
	 * @param aCustomerPic the new value for customerPic
	 */
	public void setCustomerPic(boolean aCustomerPic) {
		customerPic = aCustomerPic;
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

	@Override
	public int hashCode() {
		return Objects.hash(aadharAddress, aadharCo, aadharDistrict, aadharDob, aadharEmailHash, aadharGender,
				aadharHouse, aadharLm, aadharLoc, aadharName, aadharPhoneHash, aadharPincode, aadharPo, aadharState,
				aadharStreet, aadharSubdistrict, aadharVtc, agmtSignerCode, agmtSignerName, annualIncome, area, city,
				createTime, createUser, currentEmi, customerPic, dispName, doorNo, education, email, gender, id, idMd5,
				idSha1, idSuffix, jobType, landmark, loanReason, losId, maritalStatus, modifyTime, modifyUser,
				ownFourwheel, ownHouse, ownTwowheel, panDob, panFatherName, panFname, panLname, panName, panNo, panPic,
				phone1, phone2, phone3, pid, pincode, socBankAccount, socBankCode, socBankCustName, socBankIfsc,
				socBankName, state, stateCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LmsCustomer other = (LmsCustomer) obj;
		return Objects.equals(aadharAddress, other.aadharAddress) && Objects.equals(aadharCo, other.aadharCo)
				&& Objects.equals(aadharDistrict, other.aadharDistrict) && Objects.equals(aadharDob, other.aadharDob)
				&& Objects.equals(aadharEmailHash, other.aadharEmailHash)
				&& Objects.equals(aadharGender, other.aadharGender) && Objects.equals(aadharHouse, other.aadharHouse)
				&& Objects.equals(aadharLm, other.aadharLm) && Objects.equals(aadharLoc, other.aadharLoc)
				&& Objects.equals(aadharName, other.aadharName)
				&& Objects.equals(aadharPhoneHash, other.aadharPhoneHash)
				&& Objects.equals(aadharPincode, other.aadharPincode) && Objects.equals(aadharPo, other.aadharPo)
				&& Objects.equals(aadharState, other.aadharState) && Objects.equals(aadharStreet, other.aadharStreet)
				&& Objects.equals(aadharSubdistrict, other.aadharSubdistrict)
				&& Objects.equals(aadharVtc, other.aadharVtc) && Objects.equals(agmtSignerCode, other.agmtSignerCode)
				&& Objects.equals(agmtSignerName, other.agmtSignerName)
				&& Double.doubleToLongBits(annualIncome) == Double.doubleToLongBits(other.annualIncome)
				&& Objects.equals(area, other.area) && Objects.equals(city, other.city)
				&& Objects.equals(createTime, other.createTime) && Objects.equals(createUser, other.createUser)
				&& Objects.equals(currentEmi, other.currentEmi) && customerPic == other.customerPic
				&& Objects.equals(dispName, other.dispName) && Objects.equals(doorNo, other.doorNo)
				&& Objects.equals(education, other.education) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(idMd5, other.idMd5)
				&& Objects.equals(idSha1, other.idSha1) && Objects.equals(idSuffix, other.idSuffix)
				&& Objects.equals(jobType, other.jobType) && Objects.equals(landmark, other.landmark)
				&& Objects.equals(loanReason, other.loanReason) && losId == other.losId
				&& Objects.equals(maritalStatus, other.maritalStatus) && Objects.equals(modifyTime, other.modifyTime)
				&& Objects.equals(modifyUser, other.modifyUser) && ownFourwheel == other.ownFourwheel
				&& ownHouse == other.ownHouse && ownTwowheel == other.ownTwowheel
				&& Objects.equals(panDob, other.panDob) && Objects.equals(panFatherName, other.panFatherName)
				&& Objects.equals(panFname, other.panFname) && Objects.equals(panLname, other.panLname)
				&& Objects.equals(panName, other.panName) && Objects.equals(panNo, other.panNo)
				&& panPic == other.panPic && Objects.equals(phone1, other.phone1)
				&& Objects.equals(phone2, other.phone2) && Objects.equals(phone3, other.phone3) && pid == other.pid
				&& Objects.equals(pincode, other.pincode) && Objects.equals(socBankAccount, other.socBankAccount)
				&& Objects.equals(socBankCode, other.socBankCode)
				&& Objects.equals(socBankCustName, other.socBankCustName)
				&& Objects.equals(socBankIfsc, other.socBankIfsc) && Objects.equals(socBankName, other.socBankName)
				&& Objects.equals(state, other.state) && Objects.equals(stateCode, other.stateCode);
	}

	@Override
	public String toString() {
		return String.format(
				"LmsCustomer [id=%s, losId=%s, pid=%s, dispName=%s, phone1=%s, phone2=%s, phone3=%s, email=%s, doorNo=%s, area=%s, landmark=%s, city=%s, state=%s, pincode=%s, stateCode=%s, maritalStatus=%s, gender=%s, jobType=%s, annualIncome=%s, education=%s, currentEmi=%s, loanReason=%s, ownHouse=%s, ownTwowheel=%s, ownFourwheel=%s, socBankCode=%s, socBankAccount=%s, socBankName=%s, socBankIfsc=%s, socBankCustName=%s, panFname=%s, panLname=%s, panNo=%s, panDob=%s, panName=%s, panFatherName=%s, idMd5=%s, idSha1=%s, idSuffix=%s, agmtSignerName=%s, agmtSignerCode=%s, aadharName=%s, aadharPhoneHash=%s, aadharEmailHash=%s, aadharCo=%s, aadharHouse=%s, aadharStreet=%s, aadharLm=%s, aadharLoc=%s, aadharVtc=%s, aadharSubdistrict=%s, aadharDistrict=%s, aadharState=%s, aadharPo=%s, aadharGender=%s, aadharDob=%s, aadharPincode=%s, aadharAddress=%s, panPic=%s, customerPic=%s, createUser=%s, createTime=%s, modifyUser=%s, modifyTime=%s, getClass()=%s, toString()=%s]",
				id, losId, pid, dispName, phone1, phone2, phone3, email, doorNo, area, landmark, city, state, pincode,
				stateCode, maritalStatus, gender, jobType, annualIncome, education, currentEmi, loanReason, ownHouse,
				ownTwowheel, ownFourwheel, socBankCode, socBankAccount, socBankName, socBankIfsc, socBankCustName,
				panFname, panLname, panNo, panDob, panName, panFatherName, idMd5, idSha1, idSuffix, agmtSignerName,
				agmtSignerCode, aadharName, aadharPhoneHash, aadharEmailHash, aadharCo, aadharHouse, aadharStreet,
				aadharLm, aadharLoc, aadharVtc, aadharSubdistrict, aadharDistrict, aadharState, aadharPo, aadharGender,
				aadharDob, aadharPincode, aadharAddress, panPic, customerPic, createUser, createTime, modifyUser,
				modifyTime, getClass(), super.toString());
	}

}
