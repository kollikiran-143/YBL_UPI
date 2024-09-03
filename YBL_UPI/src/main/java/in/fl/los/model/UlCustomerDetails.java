// Generated with g9.

package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_customer_details")
public class UlCustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id", unique = true, nullable = false)
	private int custId;
	@Column(name = "visit_id")
	private int visitId;
	@Column(name = "agent_code", length = 30)
	private String agentCode;
	@Column(name = "agent_id")
	private int agentId;
	@Column(name = "team_id")
	private int teamId;
	@Column(name = "originator")
	private String originator;
	@Column(name = "lms_id")
	private int lmsId;
	private int pid;
	@Column(name = "customer_name", length = 50)
	private String customerName;
	@Column(name = "applicant_type", length = 15)
	private String applicantType;
	@Column(name = "lead_source")
	private String leadSource;
	@Column(name = "phoneno", length = 15)
	private String phoneNo;
	@Column(length = 15)
	private String phone1;
	@Column(length = 15)
	private String phone2;
	@Column(name = "aa_mobile", length = 15)
	private String aaMobile;
	@Column(length = 60)
	private String email;
	@Column(length = 15)
	private String phonemodel;
	@Column(length = 20)
	private String imei;
	@Column(length = 100)
	private String osbuild;
	@Column(length = 50)
	private String network;
	@Column(length = 100)
	private String devicemake;
	@Column(length = 50)
	private String deviceid;
	@Column(length = 10)
	private String gender;
	@Column(name = "business_name")
	private String businessName;
	@Column(name = "dob")
	private Date dob;

	@Column(name = "daily_upi", precision = 15)
	private double dailyUPI;

	@Column(name = "daily_cash", precision = 15)
	private double dailyCash;

	@Column(name = "daily_business", precision = 15)
	private double dailyBusiness;

	@Column(name = "working_days")
	private int workingDays;

	@Column(name = "id_md5", length = 32)
	private String idMd5;
	@Column(name = "id_sha1", length = 200)
	private String idSha1;
	@Column(name = "id_suffix", length = 12)
	private String idSuffix;
	@Column(name = "karza_req_id", length = 50)
	private String karzaReqId;
	@Column(name = "karza_share_code", length = 15)
	private String karzaShareCode;
	@Column(name = "karza_masked_vid", length = 15)
	private String karzaMaskedVid;
	@Column(name = "perm_no", length = 12)
	private String permNo;
	@Column(name = "marital_status", length = 15)
	private String maritalStatus;
	@Column(name = "spouse_name", length = 50)
	private String spouseName;
	@Column(name = "father_name", length = 50)
	private String fatherName;
	@Column(name = "mother_name", length = 50)
	private String motherName;
	@Column(name = "noof_child")
	private int noofChild;
	@Column(name = "noof_dependent")
	private int noofDependent;
	@Column(name = "father_alive", precision = 1)
	private boolean fatherAlive;
	@Column(name = "father_living_together", precision = 1)
	private boolean fatherLivingTogether;
	@Column(name = "father_age")
	private int fatherAge;
	@Column(name = "father_job", length = 100)
	private String fatherJob;
	@Column(name = "father_income", precision = 15)
	private double fatherIncome;
	@Column(name = "father_phone", length = 15)
	private String fatherPhone;
	@Column(name = "mother_alive", precision = 1)
	private boolean motherAlive;
	@Column(name = "mother_living_together", precision = 1)
	private boolean motherLivingTogether;
	@Column(name = "mother_age")
	private int motherAge;
	@Column(name = "mother_job", length = 100)
	private String motherJob;
	@Column(name = "mother_income", precision = 15)
	private double motherIncome;
	@Column(name = "mother_phone", length = 15)
	private String motherPhone;
	@Column(name = "spouse_alive", precision = 1)
	private boolean spouseAlive;
	@Column(name = "spouse_living_together", precision = 1)
	private boolean spouseLivingTogether;
	@Column(name = "spouse_age")
	private int spouseAge;
	@Column(name = "spouse_job", length = 100)
	private String spouseJob;
	@Column(name = "spouse_income", precision = 15)
	private double spouseIncome;
	@Column(name = "spouse_phone", length = 15)
	private String spousePhone;
	@Column(name = "child1_living_together", precision = 1)
	private boolean child1LivingTogether;
	@Column(name = "child1_name", length = 100)
	private String child1Name;
	@Column(name = "child1_age")
	private int child1Age;
	@Column(name = "child1_job", length = 100)
	private String child1Job;
	@Column(name = "child1_income", precision = 15)
	private double child1Income;
	@Column(name = "child1_phone", length = 15)
	private String child1Phone;
	@Column(name = "child2_living_together", precision = 1)
	private boolean child2LivingTogether;
	@Column(name = "child2_name", length = 100)
	private String child2Name;
	@Column(name = "child2_age")
	private int child2Age;
	@Column(name = "child2_job", length = 100)
	private String child2Job;
	@Column(name = "child2_income", precision = 15)
	private double child2Income;
	@Column(name = "child2_phone", length = 15)
	private String child2Phone;
	@Column(name = "child3_living_together", precision = 1)
	private boolean child3LivingTogether;
	@Column(name = "child3_name", length = 100)
	private String child3Name;
	@Column(name = "child3_age")
	private int child3Age;
	@Column(name = "child3_job", length = 100)
	private String child3Job;
	@Column(name = "child3_income", length = 100)
	private String child3Income;
	@Column(name = "child3_phone", length = 15)
	private String child3Phone;
	@Column(name = "user_pan", length = 10)
	private String userPan;
	@Column(name = "pan_first_name", length = 50)
	private String panFirstName;
	@Column(name = "pan_last_name", length = 50)
	private String panLastName;
	@Column(name = "loan_purpose", length = 50)
	private String loanPurpose;
	@Column(name = "requested_loan", precision = 15)
	private double requestedLoan;
	@Column(name = "cibil_score")
	private int cibilScore;
	@Column(name = "crif_score")
	private int crifScore;
	@Column(name = "efax_score")
	private int efaxScore;
	@Column(name = "gst_no", length = 20)
	private String gstNo;
	@Column(name = "perm_address", length = 1000)
	private String permAddress;
	@Column(name = "perm_city", length = 50)
	private String permCity;
	@Column(name = "perm_district", length = 50)
	private String permDistrict;
	@Column(name = "perm_state", length = 50)
	private String permState;
	@Column(name = "perm_pincode", length = 6)
	private String permPincode;
	@Column(name = "home_address", length = 1000)
	private String homeAddress;
	@Column(name = "home_city", length = 50)
	private String homeCity;
	@Column(name = "home_district", length = 50)
	private String homeDistrict;
	@Column(name = "home_state", length = 50)
	private String homeState;
	@Column(name = "home_pincode", length = 6)
	private String homePincode;
	@Column(name = "busi_address", length = 1000)
	private String busiAddress;
	@Column(name = "busi_city", length = 50)
	private String busiCity;
	@Column(name = "busi_district", length = 50)
	private String busiDistrict;
	@Column(name = "busi_state", length = 50)
	private String busiState;
	@Column(name = "busi_pincode", length = 6)
	private String busiPincode;
	@Column(name = "house_type", length = 50)
	private String houseType;
	@Column(name = "house_rent", precision = 15)
	private double houseRent;
	@Column(name = "residency_type", length = 50)
	private String residencyType;
	@Column(name = "home_location_years", length = 20)
	private String homeLocationYears;
	@Column(name = "busi_experience_years")
	private int busiExperienceYears;
	@Column(name = "busi_location_years")
	private int busiLocationYears;
	@Column(name = "declared_turnover", precision = 15)
	private double declaredTurnover;
	@Column(precision = 1)
	private boolean cash;
	@Column(precision = 1)
	private boolean phonepay;
	@Column(precision = 1)
	private boolean gpay;
	@Column(precision = 1)
	private boolean paytm;
	@Column(precision = 1)
	private boolean bhim;
	@Column(name = "credit_card", precision = 1)
	private boolean creditCard;
	@Column(name = "debit_card", precision = 1)
	private boolean debitCard;
	@Column(precision = 1)
	private boolean pos;
	@Column(name = "business_type", length = 50)
	private String businessType;
	@Column(name = "business_upi_daycoll", precision = 15)
	private double businessUPIDayCollection;
	@Column(name = "business_cash_daycoll", precision = 15)
	private double businessCashDayCollection;
	@Column(name = "business_rental_type")
	private String businessRentalType;
	@Column(name = "business_rent", precision = 15)
	private double businessRent;
	@Column(name = "business_sqft")
	private int businessSqft;
	@Column(name = "business_monthly_eb", precision = 15)
	private double businessMonthlyEb;
	@Column(name = "employee_count_observed")
	private int employeeCountObserved;
	@Column(name = "employee_count_seen")
	private int employeeCountSeen;
	@Column(name = "employee_salary", precision = 15)
	private double employeeSalary;
	@Column(length = 30)
	private String status;
	@Column(name = "duplicate_of")
	private int duplicateOf;
	@Column(name = "duplicate_count")
	private int duplicateCount;
	@Column(name = "direct_bank_urn")
	private boolean direct_bank_urn;
	@Column(name = "callback_date")
	private Date callBackDate;
	@Column(name = "callback_time")
	private Date callBackTime;
	@Column(name = "app_completed")
	private boolean appCompleted;
	@Column(name = "lead_completed")
	private boolean leadCompleted;
	@Column(name = "lead_date")
	private Date leadDate;
	@Column(name = "lead_status")
	private String leadStatus;
	@Column(name = "soc_cibil_score")
	private int socCibilScore;
	@Column(name = "soc_credit_status")
	private String socCreditStatus;
	@Column(name = "soc_credit_minamt", precision = 15)
	private double socCreditMinAmt;
	@Column(name = "soc_credit_maxamt", precision = 15)
	private double socCreditmaxAmt;
	@Column(name = "soc_repay_day")
	private int socRepayDay;
	@Column(name = "soc_credit_reason")
	private String socCreditReason;
	@Column(name = "soc_score_time")
	private Date socScoreTime;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "prequalify_result")
	private String preQualifyResult;
	@Column(name = "soc_pq_score")
	private int socPqScore;
	@Column(name = "soc_bank_name")
	private String socBankName;
	@Column(name = "soc_bank_ifsc")
	private String socBankIfcs;
	@Column(name = "soc_bank_account")
	private String socBankAccount;
	@Column(name = "soc_verified_acc_no")
	private String socVerifiedAccNo;
	@Column(name = "soc_masked_acc_no")
	private String socMaskedAccNo;
	@Column(name = "soc_bank_cust_name")
	private String socBankCustName;
	@Column(name = "soc_bank_phone")
	private String socBankPhone;
	@Column(name = "soc_version")
	private String socVersion;
	@Column(name = "statement_provider")
	private String statementProvider;
	@Column(name = "mandate_type", length = 20)
	private String mandateType;
	@Column(name = "pennydrop_result")
	private String pennydropResult;
	@Column(name = "pennydrop_benef_name")
	private String pennydropBenefName;
	@Column(name = "vpa")
	private String vpa;
	@Column(name = "vpa_payer_name")
	private String vpaPayerName;
	@Column(name = "vpa_ifsc")
	private String vpaIfsc;
	@Column(name = "coapplicant_of")
	private int coapplicantOf;
	@Column(name = "coapplicant_present")
	private boolean coapplicantPresent;
	@Column(name = "coapplicant_count")
	private int coapplicantCount;
	@Column(name = "coapplicant_completed")
	private boolean coapplicantCompleted;
	@Column(name = "familyapplicant_of")
	private int familyapplicantOf;
	@Column(name = "familyapplicant_present")
	private boolean familyapplicantPresent;
	@Column(name = "relationship_applicant")
	private String relationshipApplicant;
	@Column(name = "manual_credit_flag")
	private boolean manualCreditFlag;
	@Column(name = "qrpay_gpay_trans")
	private boolean qrpayGpayTrans;
	@Column(name = "qrpay_phonepe_trans")
	private boolean qrpayPhonepeTrans;
	@Column(name = "qrpay_paytm_trans")
	private boolean qrpayPaytmTrans;
	@Column(name = "qrpay_bharatpe_trans")
	private boolean qrpayBharatpeTrans;
	@Column(name = "lead_active_status")
	private String leadActiveStatus;
	@Column(name = "lead_closed_time")
	private Date leadClosedTime;
	@Column(name = "soc_prequalify_status")
	private String socPrequalifyStatus;
	@Column(name = "soc_prequalify_reason")
	private String socPrequalifyReason;
	@Column(name = "soc_prequalify_time")
	private Date socPrequalifyTime;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "remarks_others")
	private String remarksOthers;
	@Column(name = "disposition")
	private String disposition;
	@Column(name = "disposition_callback_date")
	private Date dispositionCallbackDate;
	@Column(name = "disposition_callback_time")
	private Date dispositionCallbackTime;
	@Column(name = "ref1_name")
	private String ref1Name;
	@Column(name = "ref1_phone")
	private String ref1Phone;
	@Column(name = "ref2_name")
	private String ref2Name;
	@Column(name = "ref2_phone")
	private String ref2Phone;
	@Column(name = "ref3_name")
	private String ref3Name;
	@Column(name = "ref3_phone")
	private String ref3Phone;
	@Column(name = "ref4_name")
	private String ref4Name;
	@Column(name = "ref4_phone")
	private String ref4Phone;
	@Column(name = "home_fi_req")
	private boolean homeFiReq;
	@Column(name = "home_fi_verified")
	private boolean homeFiVerified;
	@Column(name = "home_fi_verified_time")
	private Date homeFiVerifiedTime;
	@Column(name = "office_fi_req")
	private boolean officeFiReq;
	@Column(name = "office_fi_verified")
	private boolean officeFiVerified;
	@Column(name = "office_fi_verified_time")
	private Date officeFiVerifiedTime;
	@Column(name = "office_fi_agent")
	private String officeFIAgent;
	@Column(name = "home_fi_agent")
	private String homeFIAgent;
	@Column(name = "activation_code")
	private int activationCode;
	@Column(name = "activation_code_gendate")
	private Date activationCodeGenDate;
	@Column(name = "fcmid")
	private String fcmid;
	@Column(name = "hibernate_till")
	private Date hibernateTill;

	@Column(name = "source")
	private int source;

	@Column(name = "reject_remarks")
	private String rejectRemarks;
	@Column(name = "reject_date")
	private Date rejectDate;
	@Column(name = "reject_reason")
	private String rejectReason;
	@Column(name = "stmnt_manualdoc")
	private boolean stmntManualdoc;

	@Column(name = "business_latitude", precision = 11)
	private double businessLatitude;
	@Column(name = "business_longitude", precision = 11)
	private double businessLongitude;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<UlLoans> loans;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<UlStateStatus> stateStatus;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinColumn(name = "cust_id")
	private UlCustomerStateStatus customerStateStatus;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinColumn(name = "cust_id")
	private UlPersonalAsset personalAsset;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinColumn(name = "cust_id")
	private UlBusinessAsset businessAsset;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinColumn(name = "cust_id")
	private UlCustomerDependent customerDependent;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	@JoinColumn(name = "cust_id")
	private UlOtherIncome customerOtherIncome;

	/*
	 * @OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = {
	 * CascadeType.PERSIST, CascadeType.MERGE })
	 * 
	 * @JoinColumn(name = "cust_id") private UlAadhaarDetails
	 * customerAadhaarDetails;
	 */

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customerDetails", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<UlCustomerLocationLog> customerLocationLog;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	public UlCustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public int getLmsId() {
		return lmsId;
	}

	public void setLmsId(int lmsId) {
		this.lmsId = lmsId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAaMobile() {
		return aaMobile;
	}

	public void setAaMobile(String aaMobile) {
		this.aaMobile = aaMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonemodel() {
		return phonemodel;
	}

	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getOsbuild() {
		return osbuild;
	}

	public void setOsbuild(String osbuild) {
		this.osbuild = osbuild;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getDevicemake() {
		return devicemake;
	}

	public void setDevicemake(String devicemake) {
		this.devicemake = devicemake;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getKarzaReqId() {
		return karzaReqId;
	}

	public void setKarzaReqId(String karzaReqId) {
		this.karzaReqId = karzaReqId;
	}

	public String getKarzaShareCode() {
		return karzaShareCode;
	}

	public void setKarzaShareCode(String karzaShareCode) {
		this.karzaShareCode = karzaShareCode;
	}

	public String getKarzaMaskedVid() {
		return karzaMaskedVid;
	}

	public void setKarzaMaskedVid(String karzaMaskedVid) {
		this.karzaMaskedVid = karzaMaskedVid;
	}

	public String getPermNo() {
		return permNo;
	}

	public void setPermNo(String permNo) {
		this.permNo = permNo;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getNoofChild() {
		return noofChild;
	}

	public void setNoofChild(int noofChild) {
		this.noofChild = noofChild;
	}

	public int getNoofDependent() {
		return noofDependent;
	}

	public void setNoofDependent(int noofDependent) {
		this.noofDependent = noofDependent;
	}

	public boolean isFatherAlive() {
		return fatherAlive;
	}

	public void setFatherAlive(boolean fatherAlive) {
		this.fatherAlive = fatherAlive;
	}

	public boolean isFatherLivingTogether() {
		return fatherLivingTogether;
	}

	public void setFatherLivingTogether(boolean fatherLivingTogether) {
		this.fatherLivingTogether = fatherLivingTogether;
	}

	public int getFatherAge() {
		return fatherAge;
	}

	public void setFatherAge(int fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getFatherJob() {
		return fatherJob;
	}

	public void setFatherJob(String fatherJob) {
		this.fatherJob = fatherJob;
	}

	public double getFatherIncome() {
		return fatherIncome;
	}

	public void setFatherIncome(double fatherIncome) {
		this.fatherIncome = fatherIncome;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public boolean isMotherAlive() {
		return motherAlive;
	}

	public void setMotherAlive(boolean motherAlive) {
		this.motherAlive = motherAlive;
	}

	public boolean isMotherLivingTogether() {
		return motherLivingTogether;
	}

	public void setMotherLivingTogether(boolean motherLivingTogether) {
		this.motherLivingTogether = motherLivingTogether;
	}

	public int getMotherAge() {
		return motherAge;
	}

	public void setMotherAge(int motherAge) {
		this.motherAge = motherAge;
	}

	public String getMotherJob() {
		return motherJob;
	}

	public void setMotherJob(String motherJob) {
		this.motherJob = motherJob;
	}

	public double getMotherIncome() {
		return motherIncome;
	}

	public void setMotherIncome(double motherIncome) {
		this.motherIncome = motherIncome;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public boolean isSpouseAlive() {
		return spouseAlive;
	}

	public void setSpouseAlive(boolean spouseAlive) {
		this.spouseAlive = spouseAlive;
	}

	public boolean isSpouseLivingTogether() {
		return spouseLivingTogether;
	}

	public void setSpouseLivingTogether(boolean spouseLivingTogether) {
		this.spouseLivingTogether = spouseLivingTogether;
	}

	public int getSpouseAge() {
		return spouseAge;
	}

	public void setSpouseAge(int spouseAge) {
		this.spouseAge = spouseAge;
	}

	public String getSpouseJob() {
		return spouseJob;
	}

	public void setSpouseJob(String spouseJob) {
		this.spouseJob = spouseJob;
	}

	public double getSpouseIncome() {
		return spouseIncome;
	}

	public void setSpouseIncome(double spouseIncome) {
		this.spouseIncome = spouseIncome;
	}

	public String getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(String spousePhone) {
		this.spousePhone = spousePhone;
	}

	public boolean isChild1LivingTogether() {
		return child1LivingTogether;
	}

	public void setChild1LivingTogether(boolean child1LivingTogether) {
		this.child1LivingTogether = child1LivingTogether;
	}

	public String getChild1Name() {
		return child1Name;
	}

	public void setChild1Name(String child1Name) {
		this.child1Name = child1Name;
	}

	public int getChild1Age() {
		return child1Age;
	}

	public void setChild1Age(int child1Age) {
		this.child1Age = child1Age;
	}

	public String getChild1Job() {
		return child1Job;
	}

	public void setChild1Job(String child1Job) {
		this.child1Job = child1Job;
	}

	public double getChild1Income() {
		return child1Income;
	}

	public void setChild1Income(double child1Income) {
		this.child1Income = child1Income;
	}

	public String getChild1Phone() {
		return child1Phone;
	}

	public void setChild1Phone(String child1Phone) {
		this.child1Phone = child1Phone;
	}

	public boolean isChild2LivingTogether() {
		return child2LivingTogether;
	}

	public void setChild2LivingTogether(boolean child2LivingTogether) {
		this.child2LivingTogether = child2LivingTogether;
	}

	public String getChild2Name() {
		return child2Name;
	}

	public void setChild2Name(String child2Name) {
		this.child2Name = child2Name;
	}

	public int getChild2Age() {
		return child2Age;
	}

	public void setChild2Age(int child2Age) {
		this.child2Age = child2Age;
	}

	public String getChild2Job() {
		return child2Job;
	}

	public void setChild2Job(String child2Job) {
		this.child2Job = child2Job;
	}

	public double getChild2Income() {
		return child2Income;
	}

	public void setChild2Income(double child2Income) {
		this.child2Income = child2Income;
	}

	public String getChild2Phone() {
		return child2Phone;
	}

	public void setChild2Phone(String child2Phone) {
		this.child2Phone = child2Phone;
	}

	public boolean isChild3LivingTogether() {
		return child3LivingTogether;
	}

	public void setChild3LivingTogether(boolean child3LivingTogether) {
		this.child3LivingTogether = child3LivingTogether;
	}

	public String getChild3Name() {
		return child3Name;
	}

	public void setChild3Name(String child3Name) {
		this.child3Name = child3Name;
	}

	public int getChild3Age() {
		return child3Age;
	}

	public void setChild3Age(int child3Age) {
		this.child3Age = child3Age;
	}

	public String getChild3Job() {
		return child3Job;
	}

	public void setChild3Job(String child3Job) {
		this.child3Job = child3Job;
	}

	public String getChild3Income() {
		return child3Income;
	}

	public void setChild3Income(String child3Income) {
		this.child3Income = child3Income;
	}

	public String getChild3Phone() {
		return child3Phone;
	}

	public void setChild3Phone(String child3Phone) {
		this.child3Phone = child3Phone;
	}

	public String getUserPan() {
		return userPan;
	}

	public void setUserPan(String userPan) {
		this.userPan = userPan;
	}

	public String getPanFirstName() {
		return panFirstName;
	}

	public void setPanFirstName(String panFirstName) {
		this.panFirstName = panFirstName;
	}

	public String getPanLastName() {
		return panLastName;
	}

	public void setPanLastName(String panLastName) {
		this.panLastName = panLastName;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public double getRequestedLoan() {
		return requestedLoan;
	}

	public void setRequestedLoan(double requestedLoan) {
		this.requestedLoan = requestedLoan;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public int getCrifScore() {
		return crifScore;
	}

	public void setCrifScore(int crifScore) {
		this.crifScore = crifScore;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getPermCity() {
		return permCity;
	}

	public void setPermCity(String permCity) {
		this.permCity = permCity;
	}

	public String getPermDistrict() {
		return permDistrict;
	}

	public void setPermDistrict(String permDistrict) {
		this.permDistrict = permDistrict;
	}

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getPermPincode() {
		return permPincode;
	}

	public void setPermPincode(String permPincode) {
		this.permPincode = permPincode;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeDistrict() {
		return homeDistrict;
	}

	public void setHomeDistrict(String homeDistrict) {
		this.homeDistrict = homeDistrict;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomePincode() {
		return homePincode;
	}

	public void setHomePincode(String homePincode) {
		this.homePincode = homePincode;
	}

	public String getBusiAddress() {
		return busiAddress;
	}

	public void setBusiAddress(String busiAddress) {
		this.busiAddress = busiAddress;
	}

	public String getBusiCity() {
		return busiCity;
	}

	public void setBusiCity(String busiCity) {
		this.busiCity = busiCity;
	}

	public String getBusiDistrict() {
		return busiDistrict;
	}

	public void setBusiDistrict(String busiDistrict) {
		this.busiDistrict = busiDistrict;
	}

	public String getBusiState() {
		return busiState;
	}

	public void setBusiState(String busiState) {
		this.busiState = busiState;
	}

	public String getBusiPincode() {
		return busiPincode;
	}

	public void setBusiPincode(String busiPincode) {
		this.busiPincode = busiPincode;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}

	public String getResidencyType() {
		return residencyType;
	}

	public void setResidencyType(String residencyType) {
		this.residencyType = residencyType;
	}

	public String getHomeLocationYears() {
		return homeLocationYears;
	}

	public void setHomeLocationYears(String homeLocationYears) {
		this.homeLocationYears = homeLocationYears;
	}

	public int getBusiExperienceYears() {
		return busiExperienceYears;
	}

	public void setBusiExperienceYears(int busiExperienceYears) {
		this.busiExperienceYears = busiExperienceYears;
	}

	public int getBusiLocationYears() {
		return busiLocationYears;
	}

	public void setBusiLocationYears(int busiLocationYears) {
		this.busiLocationYears = busiLocationYears;
	}

	public double getDeclaredTurnover() {
		return declaredTurnover;
	}

	public void setDeclaredTurnover(double declaredTurnover) {
		this.declaredTurnover = declaredTurnover;
	}

	public boolean isCash() {
		return cash;
	}

	public void setCash(boolean cash) {
		this.cash = cash;
	}

	public boolean isPhonepay() {
		return phonepay;
	}

	public void setPhonepay(boolean phonepay) {
		this.phonepay = phonepay;
	}

	public boolean isGpay() {
		return gpay;
	}

	public void setGpay(boolean gpay) {
		this.gpay = gpay;
	}

	public boolean isPaytm() {
		return paytm;
	}

	public void setPaytm(boolean paytm) {
		this.paytm = paytm;
	}

	public boolean isBhim() {
		return bhim;
	}

	public void setBhim(boolean bhim) {
		this.bhim = bhim;
	}

	public boolean isCreditCard() {
		return creditCard;
	}

	public void setCreditCard(boolean creditCard) {
		this.creditCard = creditCard;
	}

	public boolean isDebitCard() {
		return debitCard;
	}

	public void setDebitCard(boolean debitCard) {
		this.debitCard = debitCard;
	}

	public boolean isPos() {
		return pos;
	}

	public void setPos(boolean pos) {
		this.pos = pos;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public double getBusinessRent() {
		return businessRent;
	}

	public void setBusinessRent(double businessRent) {
		this.businessRent = businessRent;
	}

	public int getBusinessSqft() {
		return businessSqft;
	}

	public void setBusinessSqft(int businessSqft) {
		this.businessSqft = businessSqft;
	}

	public double getBusinessMonthlyEb() {
		return businessMonthlyEb;
	}

	public void setBusinessMonthlyEb(double businessMonthlyEb) {
		this.businessMonthlyEb = businessMonthlyEb;
	}

	public int getEmployeeCountObserved() {
		return employeeCountObserved;
	}

	public void setEmployeeCountObserved(int employeeCountObserved) {
		this.employeeCountObserved = employeeCountObserved;
	}

	public int getEmployeeCountSeen() {
		return employeeCountSeen;
	}

	public void setEmployeeCountSeen(int employeeCountSeen) {
		this.employeeCountSeen = employeeCountSeen;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDuplicateOf() {
		return duplicateOf;
	}

	public void setDuplicateOf(int duplicateOf) {
		this.duplicateOf = duplicateOf;
	}

	public int getDuplicateCount() {
		return duplicateCount;
	}

	public void setDuplicateCount(int duplicateCount) {
		this.duplicateCount = duplicateCount;
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

	public UlCustomerStateStatus getCustomerStateStatus() {
		if (customerStateStatus == null && this.custId != 0) {
			customerStateStatus = new UlCustomerStateStatus();
			customerStateStatus.setCustomerDetails(this);
			if (this.phone1 != null && !this.phone1.trim().equalsIgnoreCase("")) {
				customerStateStatus.setOtpStatus(true);
			}
		}
		return customerStateStatus;
	}

	public void setCustomerStateStatus(UlCustomerStateStatus customerStateStatus) {
		this.customerStateStatus = customerStateStatus;
	}

	public UlPersonalAsset getPersonalAsset() {
		return personalAsset;
	}

	public void setPersonalAsset(UlPersonalAsset personalAsset) {
		this.personalAsset = personalAsset;
	}

	public UlBusinessAsset getBusinessAsset() {
		return businessAsset;
	}

	public void setBusinessAsset(UlBusinessAsset businessAsset) {
		this.businessAsset = businessAsset;
	}

	public UlCustomerDependent getCustomerDependent() {
		return customerDependent;
	}

	public void setCustomerDependent(UlCustomerDependent customerDependent) {
		this.customerDependent = customerDependent;
	}

	public UlOtherIncome getCustomerOtherIncome() {
		return customerOtherIncome;
	}

	public void setCustomerOtherIncome(UlOtherIncome customerOtherIncome) {
		this.customerOtherIncome = customerOtherIncome;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Set<UlLoans> getLoans() {
		return loans;
	}

	public void setLoans(Set<UlLoans> loans) {
		this.loans = loans;
	}

	public boolean getDirect_bank_urn() {
		return direct_bank_urn;
	}

	public void setDirect_bank_urn(boolean direct_bank_urn) {
		this.direct_bank_urn = direct_bank_urn;
	}

	public Date getCallBackDate() {
		return callBackDate;
	}

	public void setCallBackDate(Date callBackDate) {
		this.callBackDate = callBackDate;
	}

	public Date getCallBackTime() {
		return callBackTime;
	}

	public void setCallBackTime(Date callBackTime) {
		this.callBackTime = callBackTime;
	}

	public String getRef1Name() {
		return ref1Name;
	}

	public void setRef1Name(String ref1Name) {
		this.ref1Name = ref1Name;
	}

	public String getRef1Phone() {
		return ref1Phone;
	}

	public void setRef1Phone(String ref1Phone) {
		this.ref1Phone = ref1Phone;
	}

	public String getRef2Name() {
		return ref2Name;
	}

	public void setRef2Name(String ref2Name) {
		this.ref2Name = ref2Name;
	}

	public String getRef2Phone() {
		return ref2Phone;
	}

	public void setRef2Phone(String ref2Phone) {
		this.ref2Phone = ref2Phone;
	}

	public String getRef3Name() {
		return ref3Name;
	}

	public void setRef3Name(String ref3Name) {
		this.ref3Name = ref3Name;
	}

	public String getRef3Phone() {
		return ref3Phone;
	}

	public void setRef3Phone(String ref3Phone) {
		this.ref3Phone = ref3Phone;
	}

	public String getRef4Name() {
		return ref4Name;
	}

	public void setRef4Name(String ref4Name) {
		this.ref4Name = ref4Name;
	}

	public String getRef4Phone() {
		return ref4Phone;
	}

	public void setRef4Phone(String ref4Phone) {
		this.ref4Phone = ref4Phone;
	}

	public boolean isAppCompleted() {
		return appCompleted;
	}

	public void setAppCompleted(boolean appCompleted) {
		this.appCompleted = appCompleted;
	}

	public boolean isLeadCompleted() {
		return leadCompleted;
	}

	public void setLeadCompleted(boolean leadCompleted) {
		this.leadCompleted = leadCompleted;
	}

	public Date getLeadDate() {
		return leadDate;
	}

	public void setLeadDate(Date leadDate) {
		this.leadDate = leadDate;
	}

	public String getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}

	public int getSocCibilScore() {
		return socCibilScore;
	}

	public void setSocCibilScore(int socCibilScore) {
		this.socCibilScore = socCibilScore;
	}

	public String getSocCreditStatus() {
		return socCreditStatus;
	}

	public void setSocCreditStatus(String socCreditStatus) {
		this.socCreditStatus = socCreditStatus;
	}

	public int getSocRepayDay() {
		return socRepayDay;
	}

	public void setSocRepayDay(int socRepayDay) {
		this.socRepayDay = socRepayDay;
	}

	public String getSocCreditReason() {
		return socCreditReason;
	}

	public void setSocCreditReason(String socCreditReason) {
		this.socCreditReason = socCreditReason;
	}

	public Date getSocScoreTime() {
		return socScoreTime;
	}

	public void setSocScoreTime(Date socScoreTime) {
		this.socScoreTime = socScoreTime;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPreQualifyResult() {
		return preQualifyResult;
	}

	public void setPreQualifyResult(String preQualifyResult) {
		this.preQualifyResult = preQualifyResult;
	}

	public Set<UlCustomerLocationLog> getCustomerLocationLog() {
		return customerLocationLog;
	}

	public void setCustomerLocationLog(Set<UlCustomerLocationLog> customerLocationLog) {
		this.customerLocationLog = customerLocationLog;
	}

	public int getSocPqScore() {
		return socPqScore;
	}

	public void setSocPqScore(int socPqScore) {
		this.socPqScore = socPqScore;
	}

	public String getSocBankName() {
		return socBankName;
	}

	public void setSocBankName(String socBankName) {
		this.socBankName = socBankName;
	}

	public String getSocBankIfcs() {
		return socBankIfcs;
	}

	public void setSocBankIfsc(String socBankIfsc) {
		this.socBankIfcs = socBankIfsc;
	}

	public String getSocBankAccount() {
		return socBankAccount;
	}

	public void setSocBankAccount(String socBankAccount) {
		this.socBankAccount = socBankAccount;
	}

	public String getSocBankCustName() {
		return socBankCustName;
	}

	public void setSocBankCustName(String socBankCustName) {
		this.socBankCustName = socBankCustName;
	}

	public String getSocBankPhone() {
		return socBankPhone;
	}

	public void setSocBankPhone(String socBankPhone) {
		this.socBankPhone = socBankPhone;
	}

	public String getSocVersion() {
		return socVersion;
	}

	public void setSocVersion(String socVersion) {
		this.socVersion = socVersion;
	}

	public String getMandateType() {
		return mandateType;
	}

	public void setMandateType(String mandateType) {
		this.mandateType = mandateType;
	}

	public void setSocBankIfcs(String socBankIfcs) {
		this.socBankIfcs = socBankIfcs;
	}

	public String getSocVerifiedAccNo() {
		return socVerifiedAccNo;
	}

	public void setSocVerifiedAccNo(String socVerifiedAccNo) {
		this.socVerifiedAccNo = socVerifiedAccNo;
	}

	public String getSocMaskedAccNo() {
		return socMaskedAccNo;
	}

	public void setSocMaskedAccNo(String socMaskedAccNo) {
		this.socMaskedAccNo = socMaskedAccNo;
	}

	public String getPennydropResult() {
		return pennydropResult;
	}

	public void setPennydropResult(String pennydropResult) {
		this.pennydropResult = pennydropResult;
	}

	public String getPennydropBenefName() {
		return pennydropBenefName;
	}

	public void setPennydropBenefName(String pennydropBenefName) {
		this.pennydropBenefName = pennydropBenefName;
	}

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	public String getVpaPayerName() {
		return vpaPayerName;
	}

	public void setVpaPayerName(String vpaPayerName) {
		this.vpaPayerName = vpaPayerName;
	}

	public String getVpaIfsc() {
		return vpaIfsc;
	}

	public void setVpaIfsc(String vpaIfsc) {
		this.vpaIfsc = vpaIfsc;
	}

	public String getBusinessRentalType() {
		return businessRentalType;
	}

	public void setBusinessRentalType(String businessRentalType) {
		this.businessRentalType = businessRentalType;
	}

	public int getCoapplicantOf() {
		return coapplicantOf;
	}

	public void setCoapplicantOf(int coapplicantOf) {
		this.coapplicantOf = coapplicantOf;
	}

	public boolean isCoapplicantPresent() {
		return coapplicantPresent;
	}

	public void setCoapplicantPresent(boolean coapplicantPresent) {
		this.coapplicantPresent = coapplicantPresent;
	}

	public int getCoapplicantCount() {
		return coapplicantCount;
	}

	public void setCoapplicantCount(int coapplicantCount) {
		this.coapplicantCount = coapplicantCount;
	}

	public boolean isCoapplicantCompleted() {
		return coapplicantCompleted;
	}

	public void setCoapplicantCompleted(boolean coapplicantCompleted) {
		this.coapplicantCompleted = coapplicantCompleted;
	}

	public String getStatementProvider() {
		return statementProvider;
	}

	public void setStatementProvider(String statementProvider) {
		this.statementProvider = statementProvider;
	}

	public boolean isManualCreditFlag() {
		return manualCreditFlag;
	}

	public void setManualCreditFlag(boolean manualCreditFlag) {
		this.manualCreditFlag = manualCreditFlag;
	}

	public boolean isQrpayGpayTrans() {
		return qrpayGpayTrans;
	}

	public void setQrpayGpayTrans(boolean qrpayGpayTrans) {
		this.qrpayGpayTrans = qrpayGpayTrans;
	}

	public boolean isQrpayPhonepeTrans() {
		return qrpayPhonepeTrans;
	}

	public void setQrpayPhonepeTrans(boolean qrpayPhonepeTrans) {
		this.qrpayPhonepeTrans = qrpayPhonepeTrans;
	}

	public boolean isQrpayPaytmTrans() {
		return qrpayPaytmTrans;
	}

	public void setQrpayPaytmTrans(boolean qrpayPaytmTrans) {
		this.qrpayPaytmTrans = qrpayPaytmTrans;
	}

	public boolean isQrpayBharatpeTrans() {
		return qrpayBharatpeTrans;
	}

	public void setQrpayBharatpeTrans(boolean qrpayBharatpeTrans) {
		this.qrpayBharatpeTrans = qrpayBharatpeTrans;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksOthers() {
		return remarksOthers;
	}

	public void setRemarksOthers(String remarksOthers) {
		this.remarksOthers = remarksOthers;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public Date getDispositionCallbackDate() {
		return dispositionCallbackDate;
	}

	public void setDispositionCallbackDate(Date dispositionCallbackDate) {
		this.dispositionCallbackDate = dispositionCallbackDate;
	}

	public Date getDispositionCallbackTime() {
		return dispositionCallbackTime;
	}

	public void setDispositionCallbackTime(Date dispositionCallbackTime) {
		this.dispositionCallbackTime = dispositionCallbackTime;
	}

	public String getLeadActiveStatus() {
		return leadActiveStatus;
	}

	public void setLeadActiveStatus(String leadActiveStatus) {
		this.leadActiveStatus = leadActiveStatus;
	}

	public Date getLeadClosedTime() {
		return leadClosedTime;
	}

	public void setLeadClosedTime(Date leadClosedTime) {
		this.leadClosedTime = leadClosedTime;
	}

	public String getSocPrequalifyStatus() {
		return socPrequalifyStatus;
	}

	public void setSocPrequalifyStatus(String socPrequalifyStatus) {
		this.socPrequalifyStatus = socPrequalifyStatus;
	}

	public String getSocPrequalifyReason() {
		return socPrequalifyReason;
	}

	public void setSocPrequalifyReason(String socPrequalifyReason) {
		this.socPrequalifyReason = socPrequalifyReason;
	}

	public Date getSocPrequalifyTime() {
		return socPrequalifyTime;
	}

	public void setSocPrequalifyTime(Date socPrequalifyTime) {
		this.socPrequalifyTime = socPrequalifyTime;
	}

	public double getBusinessUPIDayCollection() {
		return businessUPIDayCollection;
	}

	public void setBusinessUPIDayCollection(double businessUPIDayCollection) {
		this.businessUPIDayCollection = businessUPIDayCollection;
	}

	public double getBusinessCashDayCollection() {
		return businessCashDayCollection;
	}

	public void setBusinessCashDayCollection(double businessCashDayCollection) {
		this.businessCashDayCollection = businessCashDayCollection;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public double getSocCreditMinAmt() {
		return socCreditMinAmt;
	}

	public void setSocCreditMinAmt(double socCreditMinAmt) {
		this.socCreditMinAmt = socCreditMinAmt;
	}

	public double getSocCreditmaxAmt() {
		return socCreditmaxAmt;
	}

	public void setSocCreditmaxAmt(double socCreditmaxAmt) {
		this.socCreditmaxAmt = socCreditmaxAmt;
	}

	public Set<UlStateStatus> getStateStatus() {
		return stateStatus;
	}

	public void setStateStatus(Set<UlStateStatus> stateStatus) {
		this.stateStatus = stateStatus;
	}

	public boolean isHomeFiReq() {
		return homeFiReq;
	}

	public void setHomeFiReq(boolean homeFiReq) {
		this.homeFiReq = homeFiReq;
	}

	public boolean isHomeFiVerified() {
		return homeFiVerified;
	}

	public void setHomeFiVerified(boolean homeFiVerified) {
		this.homeFiVerified = homeFiVerified;
	}

	public Date getHomeFiVerifiedTime() {
		return homeFiVerifiedTime;
	}

	public void setHomeFiVerifiedTime(Date homeFiVerifiedTime) {
		this.homeFiVerifiedTime = homeFiVerifiedTime;
	}

	public boolean isOfficeFiReq() {
		return officeFiReq;
	}

	public void setOfficeFiReq(boolean officeFiReq) {
		this.officeFiReq = officeFiReq;
	}

	public boolean isOfficeFiVerified() {
		return officeFiVerified;
	}

	public void setOfficeFiVerified(boolean officeFiVerified) {
		this.officeFiVerified = officeFiVerified;
	}

	public Date getOfficeFiVerifiedTime() {
		return officeFiVerifiedTime;
	}

	public void setOfficeFiVerifiedTime(Date officeFiVerifiedTime) {
		this.officeFiVerifiedTime = officeFiVerifiedTime;
	}

	public String getOfficeFIAgent() {
		return officeFIAgent;
	}

	public void setOfficeFIAgent(String officeFIAgent) {
		this.officeFIAgent = officeFIAgent;
	}

	public String getHomeFIAgent() {
		return homeFIAgent;
	}

	public void setHomeFIAgent(String homeFIAgent) {
		this.homeFIAgent = homeFIAgent;
	}

	public int getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}

	public Date getActivationCodeGenDate() {
		return activationCodeGenDate;
	}

	public void setActivationCodeGenDate(Date activationCodeGenDate) {
		this.activationCodeGenDate = activationCodeGenDate;
	}

	public String getFcmid() {
		return fcmid;
	}

	public void setFcmid(String fcmid) {
		this.fcmid = fcmid;
	}

	public int getEfaxScore() {
		return efaxScore;
	}

	public void setEfaxScore(int efaxScore) {
		this.efaxScore = efaxScore;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Date getHibernateTill() {
		return hibernateTill;
	}

	public void setHibernateTill(Date hibernateTill) {
		this.hibernateTill = hibernateTill;
	}

	public String getRejectRemarks() {
		return rejectRemarks;
	}

	public void setRejectRemarks(String rejectRemarks) {
		this.rejectRemarks = rejectRemarks;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public int getFamilyapplicantOf() {
		return familyapplicantOf;
	}

	public void setFamilyapplicantOf(int familyapplicantOf) {
		this.familyapplicantOf = familyapplicantOf;
	}

	public boolean isFamilyapplicantPresent() {
		return familyapplicantPresent;
	}

	public void setFamilyapplicantPresent(boolean familyapplicantPresent) {
		this.familyapplicantPresent = familyapplicantPresent;
	}

	public String getRelationshipApplicant() {
		return relationshipApplicant;
	}

	public void setRelationshipApplicant(String relationshipApplicant) {
		this.relationshipApplicant = relationshipApplicant;
	}

	public boolean isStmntManualdoc() {
		return stmntManualdoc;
	}

	public void setStmntManualdoc(boolean stmntManualdoc) {
		this.stmntManualdoc = stmntManualdoc;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	public double getDailyUPI() {
		return dailyUPI;
	}

	public void setDailyUPI(double dailyUPI) {
		this.dailyUPI = dailyUPI;
	}

	public double getDailyCash() {
		return dailyCash;
	}

	public void setDailyCash(double dailyCash) {
		this.dailyCash = dailyCash;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public double getDailyBusiness() {
		return dailyBusiness;
	}

	public void setDailyBusiness(double dailyBusiness) {
		this.dailyBusiness = dailyBusiness;
	}

	public double getBusinessLatitude() {
		return businessLatitude;
	}

	public void setBusinessLatitude(double businessLatitude) {
		this.businessLatitude = businessLatitude;
	}

	public double getBusinessLongitude() {
		return businessLongitude;
	}

	public void setBusinessLongitude(double businessLongitude) {
		this.businessLongitude = businessLongitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aaMobile, agentCode, appCompleted, applicantType, bhim, busiAddress, busiCity, busiDistrict,
				busiExperienceYears, busiLocationYears, busiPincode, busiState, businessAsset,
				businessCashDayCollection, businessMonthlyEb, businessName, businessRent, businessRentalType,
				businessSqft, businessType, businessUPIDayCollection, callBackDate, callBackTime, cash, child1Age,
				child1Income, child1Job, child1LivingTogether, child1Name, child1Phone, child2Age, child2Income,
				child2Job, child2LivingTogether, child2Name, child2Phone, child3Age, child3Income, child3Job,
				child3LivingTogether, child3Name, child3Phone, cibilScore, coapplicantCompleted, coapplicantCount,
				coapplicantOf, coapplicantPresent, createTime, creditCard, crifScore, custId, customerDependent,
				customerLocationLog, customerName, customerOtherIncome, customerStateStatus, debitCard,
				declaredTurnover, deviceid, devicemake, direct_bank_urn, disposition, dispositionCallbackDate,
				dispositionCallbackTime, dob, duplicateCount, duplicateOf, email, employeeCountObserved,
				employeeCountSeen, employeeSalary, fatherAge, fatherAlive, fatherIncome, fatherJob,
				fatherLivingTogether, fatherName, fatherPhone, gender, gpay, gstNo, homeAddress, homeCity, homeDistrict,
				homeFiReq, homeFiVerified, homeFiVerifiedTime, homeLocationYears, homePincode, homeState, houseRent,
				houseType, idMd5, idSha1, idSuffix, imei, isActive, karzaMaskedVid, karzaReqId, karzaShareCode,
				leadActiveStatus, leadClosedTime, leadCompleted, leadDate, leadStatus, lmsId, loanPurpose, loans,
				mandateType, manualCreditFlag, maritalStatus, modifyTime, motherAge, motherAlive, motherIncome,
				motherJob, motherLivingTogether, motherName, motherPhone, network, noofChild, noofDependent,
				officeFiReq, officeFiVerified, officeFiVerifiedTime, originator, osbuild, panFirstName, panLastName,
				paytm, pennydropBenefName, pennydropResult, permAddress, permCity, permDistrict, permNo, permPincode,
				permState, personalAsset, phone1, phone2, phoneNo, phonemodel, phonepay, pid, pos, preQualifyResult,
				qrpayBharatpeTrans, qrpayGpayTrans, qrpayPaytmTrans, qrpayPhonepeTrans, ref1Name, ref1Phone, ref2Name,
				ref2Phone, ref3Name, ref3Phone, ref4Name, ref4Phone, remarks, remarksOthers, requestedLoan,
				residencyType, socBankAccount, socBankCustName, socBankIfcs, socBankName, socBankPhone, socCibilScore,
				socCreditMinAmt, socCreditReason, socCreditStatus, socCreditmaxAmt, socMaskedAccNo, socPqScore,
				socPrequalifyReason, socPrequalifyStatus, socPrequalifyTime, socRepayDay, socScoreTime,
				socVerifiedAccNo, socVersion, spouseAge, spouseAlive, spouseIncome, spouseJob, spouseLivingTogether,
				spouseName, spousePhone, stateStatus, statementProvider, status, userPan, visitId, vpa, vpaIfsc,
				vpaPayerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UlCustomerDetails other = (UlCustomerDetails) obj;
		return Objects.equals(aaMobile, other.aaMobile) && Objects.equals(agentCode, other.agentCode)
				&& appCompleted == other.appCompleted && Objects.equals(applicantType, other.applicantType)
				&& bhim == other.bhim && Objects.equals(busiAddress, other.busiAddress)
				&& Objects.equals(busiCity, other.busiCity) && Objects.equals(busiDistrict, other.busiDistrict)
				&& busiExperienceYears == other.busiExperienceYears && busiLocationYears == other.busiLocationYears
				&& Objects.equals(busiPincode, other.busiPincode) && Objects.equals(busiState, other.busiState)
				&& Objects.equals(businessAsset, other.businessAsset)
				&& Double.doubleToLongBits(businessCashDayCollection) == Double
						.doubleToLongBits(other.businessCashDayCollection)
				&& Double.doubleToLongBits(businessMonthlyEb) == Double.doubleToLongBits(other.businessMonthlyEb)
				&& Objects.equals(businessName, other.businessName)
				&& Double.doubleToLongBits(businessRent) == Double.doubleToLongBits(other.businessRent)
				&& Objects.equals(businessRentalType, other.businessRentalType) && businessSqft == other.businessSqft
				&& Objects.equals(businessType, other.businessType)
				&& Double.doubleToLongBits(businessUPIDayCollection) == Double
						.doubleToLongBits(other.businessUPIDayCollection)
				&& Objects.equals(callBackDate, other.callBackDate) && Objects.equals(callBackTime, other.callBackTime)
				&& cash == other.cash && child1Age == other.child1Age
				&& Double.doubleToLongBits(child1Income) == Double.doubleToLongBits(other.child1Income)
				&& Objects.equals(child1Job, other.child1Job) && child1LivingTogether == other.child1LivingTogether
				&& Objects.equals(child1Name, other.child1Name) && Objects.equals(child1Phone, other.child1Phone)
				&& child2Age == other.child2Age
				&& Double.doubleToLongBits(child2Income) == Double.doubleToLongBits(other.child2Income)
				&& Objects.equals(child2Job, other.child2Job) && child2LivingTogether == other.child2LivingTogether
				&& Objects.equals(child2Name, other.child2Name) && Objects.equals(child2Phone, other.child2Phone)
				&& child3Age == other.child3Age && Objects.equals(child3Income, other.child3Income)
				&& Objects.equals(child3Job, other.child3Job) && child3LivingTogether == other.child3LivingTogether
				&& Objects.equals(child3Name, other.child3Name) && Objects.equals(child3Phone, other.child3Phone)
				&& cibilScore == other.cibilScore && coapplicantCompleted == other.coapplicantCompleted
				&& coapplicantCount == other.coapplicantCount && coapplicantOf == other.coapplicantOf
				&& coapplicantPresent == other.coapplicantPresent && Objects.equals(createTime, other.createTime)
				&& creditCard == other.creditCard && crifScore == other.crifScore && custId == other.custId
				&& Objects.equals(customerDependent, other.customerDependent)
				&& Objects.equals(customerLocationLog, other.customerLocationLog)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerOtherIncome, other.customerOtherIncome)
				&& Objects.equals(customerStateStatus, other.customerStateStatus) && debitCard == other.debitCard
				&& Double.doubleToLongBits(declaredTurnover) == Double.doubleToLongBits(other.declaredTurnover)
				&& Objects.equals(deviceid, other.deviceid) && Objects.equals(devicemake, other.devicemake)
				&& direct_bank_urn == other.direct_bank_urn && Objects.equals(disposition, other.disposition)
				&& Objects.equals(dispositionCallbackDate, other.dispositionCallbackDate)
				&& Objects.equals(dispositionCallbackTime, other.dispositionCallbackTime)
				&& Objects.equals(dob, other.dob) && duplicateCount == other.duplicateCount
				&& duplicateOf == other.duplicateOf && Objects.equals(email, other.email)
				&& employeeCountObserved == other.employeeCountObserved && employeeCountSeen == other.employeeCountSeen
				&& Double.doubleToLongBits(employeeSalary) == Double.doubleToLongBits(other.employeeSalary)
				&& fatherAge == other.fatherAge && fatherAlive == other.fatherAlive
				&& Double.doubleToLongBits(fatherIncome) == Double.doubleToLongBits(other.fatherIncome)
				&& Objects.equals(fatherJob, other.fatherJob) && fatherLivingTogether == other.fatherLivingTogether
				&& Objects.equals(fatherName, other.fatherName) && Objects.equals(fatherPhone, other.fatherPhone)
				&& Objects.equals(gender, other.gender) && gpay == other.gpay && Objects.equals(gstNo, other.gstNo)
				&& Objects.equals(homeAddress, other.homeAddress) && Objects.equals(homeCity, other.homeCity)
				&& Objects.equals(homeDistrict, other.homeDistrict) && homeFiReq == other.homeFiReq
				&& homeFiVerified == other.homeFiVerified
				&& Objects.equals(homeFiVerifiedTime, other.homeFiVerifiedTime)
				&& Objects.equals(homeLocationYears, other.homeLocationYears)
				&& Objects.equals(homePincode, other.homePincode) && Objects.equals(homeState, other.homeState)
				&& Double.doubleToLongBits(houseRent) == Double.doubleToLongBits(other.houseRent)
				&& Objects.equals(houseType, other.houseType) && Objects.equals(idMd5, other.idMd5)
				&& Objects.equals(idSha1, other.idSha1) && Objects.equals(idSuffix, other.idSuffix)
				&& Objects.equals(imei, other.imei) && isActive == other.isActive
				&& Objects.equals(karzaMaskedVid, other.karzaMaskedVid) && Objects.equals(karzaReqId, other.karzaReqId)
				&& Objects.equals(karzaShareCode, other.karzaShareCode)
				&& Objects.equals(leadActiveStatus, other.leadActiveStatus)
				&& Objects.equals(leadClosedTime, other.leadClosedTime) && leadCompleted == other.leadCompleted
				&& Objects.equals(leadDate, other.leadDate) && Objects.equals(leadStatus, other.leadStatus)
				&& lmsId == other.lmsId && Objects.equals(loanPurpose, other.loanPurpose)
				&& Objects.equals(loans, other.loans) && Objects.equals(mandateType, other.mandateType)
				&& manualCreditFlag == other.manualCreditFlag && Objects.equals(maritalStatus, other.maritalStatus)
				&& Objects.equals(modifyTime, other.modifyTime) && motherAge == other.motherAge
				&& motherAlive == other.motherAlive
				&& Double.doubleToLongBits(motherIncome) == Double.doubleToLongBits(other.motherIncome)
				&& Objects.equals(motherJob, other.motherJob) && motherLivingTogether == other.motherLivingTogether
				&& Objects.equals(motherName, other.motherName) && Objects.equals(motherPhone, other.motherPhone)
				&& Objects.equals(network, other.network) && noofChild == other.noofChild
				&& noofDependent == other.noofDependent && officeFiReq == other.officeFiReq
				&& officeFiVerified == other.officeFiVerified
				&& Objects.equals(officeFiVerifiedTime, other.officeFiVerifiedTime)
				&& Objects.equals(originator, other.originator) && Objects.equals(osbuild, other.osbuild)
				&& Objects.equals(panFirstName, other.panFirstName) && Objects.equals(panLastName, other.panLastName)
				&& paytm == other.paytm && Objects.equals(pennydropBenefName, other.pennydropBenefName)
				&& Objects.equals(pennydropResult, other.pennydropResult)
				&& Objects.equals(permAddress, other.permAddress) && Objects.equals(permCity, other.permCity)
				&& Objects.equals(permDistrict, other.permDistrict) && Objects.equals(permNo, other.permNo)
				&& Objects.equals(permPincode, other.permPincode) && Objects.equals(permState, other.permState)
				&& Objects.equals(personalAsset, other.personalAsset) && Objects.equals(phone1, other.phone1)
				&& Objects.equals(phone2, other.phone2) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(phonemodel, other.phonemodel) && phonepay == other.phonepay && pid == other.pid
				&& pos == other.pos && Objects.equals(preQualifyResult, other.preQualifyResult)
				&& qrpayBharatpeTrans == other.qrpayBharatpeTrans && qrpayGpayTrans == other.qrpayGpayTrans
				&& qrpayPaytmTrans == other.qrpayPaytmTrans && qrpayPhonepeTrans == other.qrpayPhonepeTrans
				&& Objects.equals(ref1Name, other.ref1Name) && Objects.equals(ref1Phone, other.ref1Phone)
				&& Objects.equals(ref2Name, other.ref2Name) && Objects.equals(ref2Phone, other.ref2Phone)
				&& Objects.equals(ref3Name, other.ref3Name) && Objects.equals(ref3Phone, other.ref3Phone)
				&& Objects.equals(ref4Name, other.ref4Name) && Objects.equals(ref4Phone, other.ref4Phone)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(remarksOthers, other.remarksOthers)
				&& Double.doubleToLongBits(requestedLoan) == Double.doubleToLongBits(other.requestedLoan)
				&& Objects.equals(residencyType, other.residencyType)
				&& Objects.equals(socBankAccount, other.socBankAccount)
				&& Objects.equals(socBankCustName, other.socBankCustName)
				&& Objects.equals(socBankIfcs, other.socBankIfcs) && Objects.equals(socBankName, other.socBankName)
				&& Objects.equals(socBankPhone, other.socBankPhone) && socCibilScore == other.socCibilScore
				&& Double.doubleToLongBits(socCreditMinAmt) == Double.doubleToLongBits(other.socCreditMinAmt)
				&& Objects.equals(socCreditReason, other.socCreditReason)
				&& Objects.equals(socCreditStatus, other.socCreditStatus)
				&& Double.doubleToLongBits(socCreditmaxAmt) == Double.doubleToLongBits(other.socCreditmaxAmt)
				&& Objects.equals(socMaskedAccNo, other.socMaskedAccNo) && socPqScore == other.socPqScore
				&& Objects.equals(socPrequalifyReason, other.socPrequalifyReason)
				&& Objects.equals(socPrequalifyStatus, other.socPrequalifyStatus)
				&& Objects.equals(socPrequalifyTime, other.socPrequalifyTime) && socRepayDay == other.socRepayDay
				&& Objects.equals(socScoreTime, other.socScoreTime)
				&& Objects.equals(socVerifiedAccNo, other.socVerifiedAccNo)
				&& Objects.equals(socVersion, other.socVersion) && spouseAge == other.spouseAge
				&& spouseAlive == other.spouseAlive
				&& Double.doubleToLongBits(spouseIncome) == Double.doubleToLongBits(other.spouseIncome)
				&& Objects.equals(spouseJob, other.spouseJob) && spouseLivingTogether == other.spouseLivingTogether
				&& Objects.equals(spouseName, other.spouseName) && Objects.equals(spousePhone, other.spousePhone)
				&& Objects.equals(stateStatus, other.stateStatus)
				&& Objects.equals(statementProvider, other.statementProvider) && Objects.equals(status, other.status)
				&& Objects.equals(userPan, other.userPan) && visitId == other.visitId && Objects.equals(vpa, other.vpa)
				&& Objects.equals(vpaIfsc, other.vpaIfsc) && Objects.equals(vpaPayerName, other.vpaPayerName);
	}

	@Override
	public String toString() {
		return String.format(
				"UlCustomerDetails [custId=%s, visitId=%s, agentCode=%s, originator=%s, lmsId=%s, pid=%s, customerName=%s, applicantType=%s, phoneNo=%s, phone1=%s, phone2=%s, aaMobile=%s, email=%s, phonemodel=%s, imei=%s, osbuild=%s, network=%s, devicemake=%s, deviceid=%s, gender=%s, businessName=%s, dob=%s, idMd5=%s, idSha1=%s, idSuffix=%s, karzaReqId=%s, karzaShareCode=%s, karzaMaskedVid=%s, permNo=%s, maritalStatus=%s, spouseName=%s, fatherName=%s, motherName=%s, noofChild=%s, noofDependent=%s, fatherAlive=%s, fatherLivingTogether=%s, fatherAge=%s, fatherJob=%s, fatherIncome=%s, fatherPhone=%s, motherAlive=%s, motherLivingTogether=%s, motherAge=%s, motherJob=%s, motherIncome=%s, motherPhone=%s, spouseAlive=%s, spouseLivingTogether=%s, spouseAge=%s, spouseJob=%s, spouseIncome=%s, spousePhone=%s, child1LivingTogether=%s, child1Name=%s, child1Age=%s, child1Job=%s, child1Income=%s, child1Phone=%s, child2LivingTogether=%s, child2Name=%s, child2Age=%s, child2Job=%s, child2Income=%s, child2Phone=%s, child3LivingTogether=%s, child3Name=%s, child3Age=%s, child3Job=%s, child3Income=%s, child3Phone=%s, userPan=%s, panFirstName=%s, panLastName=%s, loanPurpose=%s, requestedLoan=%s, cibilScore=%s, crifScore=%s, efaxScore=%s, gstNo=%s, permAddress=%s, permCity=%s, permDistrict=%s, permState=%s, permPincode=%s, homeAddress=%s, homeCity=%s, homeDistrict=%s, homeState=%s, homePincode=%s, busiAddress=%s, busiCity=%s, busiDistrict=%s, busiState=%s, busiPincode=%s, houseType=%s, houseRent=%s, residencyType=%s, homeLocationYears=%s, busiExperienceYears=%s, busiLocationYears=%s, declaredTurnover=%s, cash=%s, phonepay=%s, gpay=%s, paytm=%s, bhim=%s, creditCard=%s, debitCard=%s, pos=%s, businessType=%s, businessUPIDayCollection=%s, businessCashDayCollection=%s, businessRentalType=%s, businessRent=%s, businessSqft=%s, businessMonthlyEb=%s, employeeCountObserved=%s, employeeCountSeen=%s, employeeSalary=%s, status=%s, duplicateOf=%s, duplicateCount=%s, direct_bank_urn=%s, callBackDate=%s, callBackTime=%s, appCompleted=%s, leadCompleted=%s, leadDate=%s, leadStatus=%s, socCibilScore=%s, socCreditStatus=%s, socCreditMinAmt=%s, socCreditmaxAmt=%s, socRepayDay=%s, socCreditReason=%s, socScoreTime=%s, isActive=%s, preQualifyResult=%s, socPqScore=%s, socBankName=%s, socBankIfcs=%s, socBankAccount=%s, socVerifiedAccNo=%s, socMaskedAccNo=%s, socBankCustName=%s, socBankPhone=%s, socVersion=%s, statementProvider=%s, mandateType=%s, pennydropResult=%s, pennydropBenefName=%s, vpa=%s, vpaPayerName=%s, vpaIfsc=%s, coapplicantOf=%s, coapplicantPresent=%s, coapplicantCount=%s, coapplicantCompleted=%s, manualCreditFlag=%s, qrpayGpayTrans=%s, qrpayPhonepeTrans=%s, qrpayPaytmTrans=%s, qrpayBharatpeTrans=%s, leadActiveStatus=%s, leadClosedTime=%s, socPrequalifyStatus=%s, socPrequalifyReason=%s, socPrequalifyTime=%s, remarks=%s, remarksOthers=%s, disposition=%s, dispositionCallbackDate=%s, dispositionCallbackTime=%s, ref1Name=%s, ref1Phone=%s, ref2Name=%s, ref2Phone=%s, ref3Name=%s, ref3Phone=%s, ref4Name=%s, ref4Phone=%s, homeFiReq=%s, homeFiVerified=%s, homeFiVerifiedTime=%s, officeFiReq=%s, officeFiVerified=%s, officeFiVerifiedTime=%s, officeFIAgent=%s, homeFIAgent=%s, activationCode=%s, activationCodeGenDate=%s, fcmid=%s, createTime=%s, modifyTime=%s]",
				custId, visitId, agentCode, originator, lmsId, pid, customerName, applicantType, phoneNo, phone1,
				phone2, aaMobile, email, phonemodel, imei, osbuild, network, devicemake, deviceid, gender, businessName,
				dob, idMd5, idSha1, idSuffix, karzaReqId, karzaShareCode, karzaMaskedVid, permNo, maritalStatus,
				spouseName, fatherName, motherName, noofChild, noofDependent, fatherAlive, fatherLivingTogether,
				fatherAge, fatherJob, fatherIncome, fatherPhone, motherAlive, motherLivingTogether, motherAge,
				motherJob, motherIncome, motherPhone, spouseAlive, spouseLivingTogether, spouseAge, spouseJob,
				spouseIncome, spousePhone, child1LivingTogether, child1Name, child1Age, child1Job, child1Income,
				child1Phone, child2LivingTogether, child2Name, child2Age, child2Job, child2Income, child2Phone,
				child3LivingTogether, child3Name, child3Age, child3Job, child3Income, child3Phone, userPan,
				panFirstName, panLastName, loanPurpose, requestedLoan, cibilScore, crifScore, efaxScore, gstNo,
				permAddress, permCity, permDistrict, permState, permPincode, homeAddress, homeCity, homeDistrict,
				homeState, homePincode, busiAddress, busiCity, busiDistrict, busiState, busiPincode, houseType,
				houseRent, residencyType, homeLocationYears, busiExperienceYears, busiLocationYears, declaredTurnover,
				cash, phonepay, gpay, paytm, bhim, creditCard, debitCard, pos, businessType, businessUPIDayCollection,
				businessCashDayCollection, businessRentalType, businessRent, businessSqft, businessMonthlyEb,
				employeeCountObserved, employeeCountSeen, employeeSalary, status, duplicateOf, duplicateCount,
				direct_bank_urn, callBackDate, callBackTime, appCompleted, leadCompleted, leadDate, leadStatus,
				socCibilScore, socCreditStatus, socCreditMinAmt, socCreditmaxAmt, socRepayDay, socCreditReason,
				socScoreTime, isActive, preQualifyResult, socPqScore, socBankName, socBankIfcs, socBankAccount,
				socVerifiedAccNo, socMaskedAccNo, socBankCustName, socBankPhone, socVersion, statementProvider,
				mandateType, pennydropResult, pennydropBenefName, vpa, vpaPayerName, vpaIfsc, coapplicantOf,
				coapplicantPresent, coapplicantCount, coapplicantCompleted, manualCreditFlag, qrpayGpayTrans,
				qrpayPhonepeTrans, qrpayPaytmTrans, qrpayBharatpeTrans, leadActiveStatus, leadClosedTime,
				socPrequalifyStatus, socPrequalifyReason, socPrequalifyTime, remarks, remarksOthers, disposition,
				dispositionCallbackDate, dispositionCallbackTime, ref1Name, ref1Phone, ref2Name, ref2Phone, ref3Name,
				ref3Phone, ref4Name, ref4Phone, homeFiReq, homeFiVerified, homeFiVerifiedTime, officeFiReq,
				officeFiVerified, officeFiVerifiedTime, officeFIAgent, homeFIAgent, activationCode,
				activationCodeGenDate, fcmid, createTime, modifyTime);
	}

}
