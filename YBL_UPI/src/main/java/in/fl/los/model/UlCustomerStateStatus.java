package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_customer_state_status")
public class UlCustomerStateStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6769087952664162362L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(name = "agent_id")
	private int agentId;
	@Column(name = "profile1_status")
	private boolean profile1Status;
	@Column(name = "otp_status")
	private boolean otpStatus;
	@Column(name = "pan_status")
	private boolean panStatus;
	@Column(name = "pan_val_try_count")
	private int panValTryCount;
	@Column(name = "prequalify_status")
	private boolean prequalifyStatus;
	@Column(name = "prequalify_approve_status")
	private boolean prequalifyApproveStatus;
	@Column(name = "creditqualify_status")
	private boolean creditQualifyStatus;
	@Column(name = "pan_aadhaar_seed_status")
	private boolean panAadhaarSeedStatus;
	@Column(name = "bank_stmnt_upicredit_status")
	private boolean bankStmntUpicreditStatus;
	@Column(name = "stmnt_status")
	private boolean stmntStatus;
	@Column(name = "stmnt_status_trycount")
	private int stmntStatusTrycount;
	@Column(name = "stmnt_status_manualdoc")
	private boolean stmntDocStatus;
	@Column(name = "manualdoc_txn_status")
	private boolean manualdocTxnStatus;
	@Column(name = "personal_asset_status")
	private boolean personalAssetStatus;
	@Column(name = "business_asset_status")
	private boolean businessAssetStatus;
	@Column(name = "business_credit_status")
	private boolean businessCreditStatus;
	@Column(name = "pincode_status")
	private boolean pincodeStatus;
	@Column(name = "aadhaar_status")
	private boolean aadhaarStatus;
	@Column(name = "qualified_bureau_status")
	private boolean qualifiedBureauStatus;
	@Column(name = "qualified_aa_status")
	private boolean qualifiedAaStatus;
	@Column(name = "get_offer_status")
	private boolean getOfferStatus;
	@Column(name = "mandate_status")
	private boolean mandateStatus;
	@Column(name = "mandate_approval_status")
	private boolean mandateApprovalStatus;
	@Column(name = "manual_credit_approve_status")
	private boolean manualCreditApproveStatus;
	@Column(name = "vkyc_status")
	private boolean vkycStatus;
	@Column(name = "okyc_status")
	private boolean okycStatus;
	@Column(name = "ckyc_status")
	private boolean ckycStatus;
	@Column(name = "sfi_status")
	private boolean sfiStatus;
	@Column(name = "esign_status")
	private boolean esignStatus;
	@Column(name = "enach_status")
	private boolean enachStatus;
	@Column(name = "board_image_status")
	private boolean boardImageStatus;
	@Column(name = "pan_image_status")
	private boolean panImageStatus;
	@Column(name = "interior_image_status")
	private boolean interiorImageStatus;
	@Column(name = "front_image_status")
	private boolean frontImageStatus;
	@Column(name = "back_image_status")
	private boolean backImageStatus;
	@Column(name = "ownership_status")
	private boolean ownershipStatus;
	@Column(name = "selfie_image_status")
	private boolean selfieImageStatus;
	@Column(name = "disburse_status")
	private boolean disburseStatus;
	@Column(name = "disburse_approval_status")
	private boolean disburseApprovalStatus;
	@Column(name = "pennydrop_status")
	private boolean pennydropStatus;
	@Column(name = "penny_drop_try_count")
	private int pennyDropTryCount;
	@Column(name = "other_income_status")
	private boolean otherIncomeStatus;
	@Column(name = "customer_dependent_status")
	private boolean customerDependentStatus;
	@Column(name = "aa_mobile_otp_status")
	private boolean aaMobileOtpStatus;
	@Column(name = "loan_offered")
	private boolean loanOffered;
	@Column(name = "loan_applied")
	private boolean loanApplied;
	@Column(name = "application_status")
	private boolean applicationStatus;
	@Column(name = "home_image_status")
	private boolean homeImageStatus;
	@Column(name = "qr1_image_status")
	private boolean qr1ImageStatus;
	@Column(name = "qr2_image_status")
	private boolean qr2ImageStatus;
	@Column(name = "qr3_image_status")
	private boolean qr3ImageStatus;
	@Column(name = "billbook_image")
	private boolean billbookImage;
	@Column(name = "ebbill_image")
	private boolean ebbillImage;
	@Column(name = "lms_status")
	private boolean lmsStatus;
	@Column(name = "vpa_status")
	private boolean vpaStatus;
	@Column(name = "upi_mandate_status")
	private boolean upiMandateStatus;
	@Column(name = "coapplicant_completed_satus")
	private boolean coapplicantCompletedSatus;
	@Column(name = "familyapplicant_status")
	private boolean familyapplicantStatus;
	@Column(name = "family_status")
	private boolean familyStatus;
	@Column(name = "video_status")
	private boolean videoStatus;
	@Column(name = "video_360_status")
	private boolean video360Status;
	@Column(name = "stmnt_finduit_trycount")
	private int stmntFinduitTrycount;
	@Column(name = "stmnt_finvu_trycount")
	private int stmntFinvuTrycount;
	@Column(name = "qrpay_gpaymerch_phstatus")
	private boolean qrpayGpaymerchPhstatus;
	@Column(name = "qrpay_gpaymerch_phcnt")
	private int qrpayGpaymerchPhcnt;
	@Column(name = "qrpay_phonepemerch_phstatus")
	private boolean qrpayPhonepemerchPhstatus;
	@Column(name = "qrpay_phonepemerch_phcnt")
	private int qrpayPhonepemerchPhcnt;
	@Column(name = "qrpay_paytmmerch_phstatus")
	private boolean qrpayPaytmmerchPhstatus;
	@Column(name = "qrpay_paytmmerch_phcnt")
	private int qrpayPaytmmerchPhcnt;
	@Column(name = "qrpay_bharatpemerch_phstatus")
	private boolean qrpayBharatpemerchPhstatus;
	@Column(name = "qrpay_bharatpemerch_phcnt")
	private int qrpayBharatpemerchPhcnt;
	@Column(name = "rationcard_image_status")
	private boolean rationcardImageStatus;
	@Column(name = "gasbill_image_status")
	private boolean gasbillImageStatus;
	@Column(name = "qrpay_gpay_doc")
	private boolean qrpayGpayDoc;
	@Column(name = "qrpay_phonepe_doc")
	private boolean qrpayPhonepeDoc;
	@Column(name = "qrpay_paytm_doc")
	private boolean qrpayPaytmDoc;
	@Column(name = "qrpay_bharatpe_doc")
	private boolean qrpayBharatpeDoc;
	@Column(name = "qrpay_gpay_banklist")
	private boolean qrpayGpayBanklist;
	@Column(name = "qrpay_gpay_profile")
	private boolean qrpayGpayProfile;
	@Column(name = "qrpay_gpay_bankdetails")
	private boolean qrpayGpayBankdetails;
	@Column(name = "qrpay_phonepe_banklist")
	private boolean qrpayPhonepeBanklist;
	@Column(name = "qrpay_phonepe_profile")
	private boolean qrpayPhonepeProfile;
	@Column(name = "qrpay_phonepe_bankdetails")
	private boolean qrpayPhonepeBankdetails;
	@Column(name = "qrpay_paytm_banklist")
	private boolean qrpayPaytmBanklist;
	@Column(name = "qrpay_paytm_profile")
	private boolean qrpayPaytmProfile;
	@Column(name = "qrpay_paytm_bankdetails")
	private boolean qrpayPaytmBankdetails;
	@Column(name = "qrpay_bharatpe_banklist")
	private boolean qrpayBharatpeBanklist;
	@Column(name = "qrpay_bharatpe_profile")
	private boolean qrpayBharatpeProfile;
	@Column(name = "qrpay_bharatpe_bankdetails")
	private boolean qrpayBharatpeBankdetails;
	@Column(name = "referenceStatus")
	private boolean referenceStatus;
	@Column(name = "address_verification_status")
	private boolean addressVerificationStatus;
	@Column(name = "upi_amt_sufficient_status")
	private boolean upiAmtSufficientStatus;
	@Column(name = "call_log_status")
	private boolean callLogStatus;
	@Column(name = "cust_calllog_datetime")
	private Date callLofDateTime;

	@Column(name = "contact_status")
	private boolean contactStatus;
	@Column(name = "cust_contact_datetime")
	private Date contactDateTime;

	@Column(name = "sms_status")
	private boolean smsStatus;
	@Column(name = "cust_sms_datetime")
	private Date smsDateTime;

	@Column(name = "esign_time")
	private Date esignTime;

	@Column(name = "cust_app_status")
	private boolean custAppStatus;
	@Column(name = "cust_app_datetime")
	private Date custAppDateTime;

	@Column(name = "enable_stmnt_upload")
	private boolean enableStmntUpload;

	@Column(name = "photo_credit_status")
	private boolean photoCreditStatus;

	@Column(name = "photo_ops_status")
	private boolean photoOpsStatus;

	@Column(name = "glead_status")
	private boolean gleadStatus;

	@Column(name = "mos_status")
	private boolean mosStatus;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;
	@OneToOne(optional = false)
	@JoinColumn(name = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@OneToOne(optional = false)

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	public boolean isProfile1Status() {
		return profile1Status;
	}

	public void setProfile1Status(boolean profile1Status) {
		this.profile1Status = profile1Status;
	}

	public boolean isOtpStatus() {
		return otpStatus;
	}

	public void setOtpStatus(boolean otpStatus) {
		this.otpStatus = otpStatus;
	}

	public boolean isPanStatus() {
		return panStatus;
	}

	public void setPanStatus(boolean panStatus) {
		this.panStatus = panStatus;
	}

	public int getPanValTryCount() {
		return panValTryCount;
	}

	public void setPanValTryCount(int panValTryCount) {
		this.panValTryCount = panValTryCount;
	}

	public boolean isPrequalifyStatus() {
		return prequalifyStatus;
	}

	public void setPrequalifyStatus(boolean prequalifyStatus) {
		this.prequalifyStatus = prequalifyStatus;
	}

	public boolean isPanAadhaarSeedStatus() {
		return panAadhaarSeedStatus;
	}

	public void setPanAadhaarSeedStatus(boolean panAadhaarSeedStatus) {
		this.panAadhaarSeedStatus = panAadhaarSeedStatus;
	}

	public boolean isStmntStatus() {
		return stmntStatus;
	}

	public void setStmntStatus(boolean stmntStatus) {
		this.stmntStatus = stmntStatus;
	}

	public boolean isPersonalAssetStatus() {
		return personalAssetStatus;
	}

	public void setPersonalAssetStatus(boolean personalAssetStatus) {
		this.personalAssetStatus = personalAssetStatus;
	}

	public boolean isBusinessAssetStatus() {
		return businessAssetStatus;
	}

	public void setBusinessAssetStatus(boolean businessAssetStatus) {
		this.businessAssetStatus = businessAssetStatus;
	}

	public boolean isPincodeStatus() {
		return pincodeStatus;
	}

	public void setPincodeStatus(boolean pincodeStatus) {
		this.pincodeStatus = pincodeStatus;
	}

	public boolean isAadhaarStatus() {
		return aadhaarStatus;
	}

	public void setAadhaarStatus(boolean aadhaarStatus) {
		this.aadhaarStatus = aadhaarStatus;
	}

	public boolean isBankStmntUpicreditStatus() {
		return bankStmntUpicreditStatus;
	}

	public void setBankStmntUpicreditStatus(boolean bankStmntUpicreditStatus) {
		this.bankStmntUpicreditStatus = bankStmntUpicreditStatus;
	}

	public boolean isQualifiedBureauStatus() {
		return qualifiedBureauStatus;
	}

	public void setQualifiedBureauStatus(boolean qualifiedBureauStatus) {
		this.qualifiedBureauStatus = qualifiedBureauStatus;
	}

	public boolean isQualifiedAaStatus() {
		return qualifiedAaStatus;
	}

	public void setQualifiedAaStatus(boolean qualifiedAaStatus) {
		this.qualifiedAaStatus = qualifiedAaStatus;
	}

	public boolean isGetOfferStatus() {
		return getOfferStatus;
	}

	public void setGetOfferStatus(boolean getOfferStatus) {
		this.getOfferStatus = getOfferStatus;
	}

	public boolean isMandateStatus() {
		return mandateStatus;
	}

	public void setMandateStatus(boolean mandateStatus) {
		this.mandateStatus = mandateStatus;
	}

	public boolean isMandateApprovalStatus() {
		return mandateApprovalStatus;
	}

	public void setMandateApprovalStatus(boolean mandateApprovalStatus) {
		this.mandateApprovalStatus = mandateApprovalStatus;
	}

	public boolean isVkycStatus() {
		return vkycStatus;
	}

	public void setVkycStatus(boolean vkycStatus) {
		this.vkycStatus = vkycStatus;
	}

	public boolean isOkycStatus() {
		return okycStatus;
	}

	public void setOkycStatus(boolean okycStatus) {
		this.okycStatus = okycStatus;
	}

	public boolean isEsignStatus() {
		return esignStatus;
	}

	public void setEsignStatus(boolean esignStatus) {
		this.esignStatus = esignStatus;
	}

	public boolean isEnachStatus() {
		return enachStatus;
	}

	public void setEnachStatus(boolean enachStatus) {
		this.enachStatus = enachStatus;
	}

	public boolean isBoardImageStatus() {
		return boardImageStatus;
	}

	public void setBoardImageStatus(boolean boardImageStatus) {
		this.boardImageStatus = boardImageStatus;
	}

	public boolean isPanImageStatus() {
		return panImageStatus;
	}

	public void setPanImageStatus(boolean panImageStatus) {
		this.panImageStatus = panImageStatus;
	}

	public boolean isInteriorImageStatus() {
		return interiorImageStatus;
	}

	public void setInteriorImageStatus(boolean interiorImageStatus) {
		this.interiorImageStatus = interiorImageStatus;
	}

	public boolean isFrontImageStatus() {
		return frontImageStatus;
	}

	public void setFrontImageStatus(boolean frontImageStatus) {
		this.frontImageStatus = frontImageStatus;
	}

	public boolean isBackImageStatus() {
		return backImageStatus;
	}

	public void setBackImageStatus(boolean backImageStatus) {
		this.backImageStatus = backImageStatus;
	}

	public boolean isOwnershipStatus() {
		return ownershipStatus;
	}

	public void setOwnershipStatus(boolean ownershipStatus) {
		this.ownershipStatus = ownershipStatus;
	}

	public boolean isSelfieImageStatus() {
		return selfieImageStatus;
	}

	public void setSelfieImageStatus(boolean selfieImageStatus) {
		this.selfieImageStatus = selfieImageStatus;
	}

	public boolean isDisburseStatus() {
		return disburseStatus;
	}

	public void setDisburseStatus(boolean disburseStatus) {
		this.disburseStatus = disburseStatus;
	}

	public boolean isDisburseApprovalStatus() {
		return disburseApprovalStatus;
	}

	public void setDisburseApprovalStatus(boolean disburseApprovalStatus) {
		this.disburseApprovalStatus = disburseApprovalStatus;
	}

	public boolean isPennydropStatus() {
		return pennydropStatus;
	}

	public void setPennydropStatus(boolean pennydropStatus) {
		this.pennydropStatus = pennydropStatus;
	}

	public int getPennyDropTryCount() {
		return pennyDropTryCount;
	}

	public void setPennyDropTryCount(int pennyDropTryCount) {
		this.pennyDropTryCount = pennyDropTryCount;
	}

	public boolean isOtherIncomeStatus() {
		return otherIncomeStatus;
	}

	public void setOtherIncomeStatus(boolean otherIncomeStatus) {
		this.otherIncomeStatus = otherIncomeStatus;
	}

	public boolean isCustomerDependentStatus() {
		return customerDependentStatus;
	}

	public void setCustomerDependentStatus(boolean customerDependentStatus) {
		this.customerDependentStatus = customerDependentStatus;
	}

	public boolean isAaMobileOtpStatus() {
		return aaMobileOtpStatus;
	}

	public void setAaMobileOtpStatus(boolean aaMobileOtpStatus) {
		this.aaMobileOtpStatus = aaMobileOtpStatus;
	}

	public boolean isApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(boolean applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public boolean isHomeImageStatus() {
		return homeImageStatus;
	}

	public void setHomeImageStatus(boolean homeImageStatus) {
		this.homeImageStatus = homeImageStatus;
	}

	public boolean isQr1ImageStatus() {
		return qr1ImageStatus;
	}

	public void setQr1ImageStatus(boolean qr1ImageStatus) {
		this.qr1ImageStatus = qr1ImageStatus;
	}

	public boolean isQr2ImageStatus() {
		return qr2ImageStatus;
	}

	public void setQr2ImageStatus(boolean qr2ImageStatus) {
		this.qr2ImageStatus = qr2ImageStatus;
	}

	public boolean isQr3ImageStatus() {
		return qr3ImageStatus;
	}

	public void setQr3ImageStatus(boolean qr3ImageStatus) {
		this.qr3ImageStatus = qr3ImageStatus;
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

	public UlCustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(UlCustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public boolean isLoanOffered() {
		return loanOffered;
	}

	public void setLoanOffered(boolean loanOffered) {
		this.loanOffered = loanOffered;
	}

	public boolean isLoanApplied() {
		return loanApplied;
	}

	public void setLoanApplied(boolean loanApplied) {
		this.loanApplied = loanApplied;
	}

	public boolean isLmsStatus() {
		return lmsStatus;
	}

	public void setLmsStatus(boolean lmsStatus) {
		this.lmsStatus = lmsStatus;
	}

	public boolean isCreditQualifyStatus() {
		return creditQualifyStatus;
	}

	public void setCreditQualifyStatus(boolean creditQualifyStatus) {
		this.creditQualifyStatus = creditQualifyStatus;
	}

	public boolean isVpaStatus() {
		return vpaStatus;
	}

	public void setVpaStatus(boolean vpaStatus) {
		this.vpaStatus = vpaStatus;
	}

	public boolean isUpiMandateStatus() {
		return upiMandateStatus;
	}

	public void setUpiMandateStatus(boolean upiMandateStatus) {
		this.upiMandateStatus = upiMandateStatus;
	}

	public boolean isCoapplicantCompletedSatus() {
		return coapplicantCompletedSatus;
	}

	public void setCoapplicantCompletedSatus(boolean coapplicantCompletedSatus) {
		this.coapplicantCompletedSatus = coapplicantCompletedSatus;
	}

	public boolean isFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(boolean familyStatus) {
		this.familyStatus = familyStatus;
	}

	public boolean isVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(boolean videoStatus) {
		this.videoStatus = videoStatus;
	}

	public int getStmntFinduitTrycount() {
		return stmntFinduitTrycount;
	}

	public void setStmntFinduitTrycount(int stmntFinduitTrycount) {
		this.stmntFinduitTrycount = stmntFinduitTrycount;
	}

	public int getStmntFinvuTrycount() {
		return stmntFinvuTrycount;
	}

	public void setStmntFinvuTrycount(int stmntFinvuTrycount) {
		this.stmntFinvuTrycount = stmntFinvuTrycount;
	}

	public boolean isVideo360Status() {
		return video360Status;
	}

	public void setVideo360Status(boolean video360Status) {
		this.video360Status = video360Status;
	}

	public boolean isQrpayGpaymerchPhstatus() {
		return qrpayGpaymerchPhstatus;
	}

	public void setQrpayGpaymerchPhstatus(boolean qrpayGpaymerchPhstatus) {
		this.qrpayGpaymerchPhstatus = qrpayGpaymerchPhstatus;
	}

	public int getQrpayGpaymerchPhcnt() {
		return qrpayGpaymerchPhcnt;
	}

	public void setQrpayGpaymerchPhcnt(int qrpayGpaymerchPhcnt) {
		this.qrpayGpaymerchPhcnt = qrpayGpaymerchPhcnt;
	}

	public boolean isQrpayPhonepemerchPhstatus() {
		return qrpayPhonepemerchPhstatus;
	}

	public void setQrpayPhonepemerchPhstatus(boolean qrpayPhonepemerchPhstatus) {
		this.qrpayPhonepemerchPhstatus = qrpayPhonepemerchPhstatus;
	}

	public int getQrpayPhonepemerchPhcnt() {
		return qrpayPhonepemerchPhcnt;
	}

	public void setQrpayPhonepemerchPhcnt(int qrpayPhonepemerchPhcnt) {
		this.qrpayPhonepemerchPhcnt = qrpayPhonepemerchPhcnt;
	}

	public boolean isQrpayPaytmmerchPhstatus() {
		return qrpayPaytmmerchPhstatus;
	}

	public void setQrpayPaytmmerchPhstatus(boolean qrpayPaytmmerchPhstatus) {
		this.qrpayPaytmmerchPhstatus = qrpayPaytmmerchPhstatus;
	}

	public int getQrpayPaytmmerchPhcnt() {
		return qrpayPaytmmerchPhcnt;
	}

	public void setQrpayPaytmmerchPhcnt(int qrpayPaytmmerchPhcnt) {
		this.qrpayPaytmmerchPhcnt = qrpayPaytmmerchPhcnt;
	}

	public boolean isQrpayBharatpemerchPhstatus() {
		return qrpayBharatpemerchPhstatus;
	}

	public void setQrpayBharatpemerchPhstatus(boolean qrpayBharatpemerchPhstatus) {
		this.qrpayBharatpemerchPhstatus = qrpayBharatpemerchPhstatus;
	}

	public int getQrpayBharatpemerchPhcnt() {
		return qrpayBharatpemerchPhcnt;
	}

	public void setQrpayBharatpemerchPhcnt(int qrpayBharatpemerchPhcnt) {
		this.qrpayBharatpemerchPhcnt = qrpayBharatpemerchPhcnt;
	}

	public boolean isRationcardImageStatus() {
		return rationcardImageStatus;
	}

	public void setRationcardImageStatus(boolean rationcardImageStatus) {
		this.rationcardImageStatus = rationcardImageStatus;
	}

	public boolean isGasbillImageStatus() {
		return gasbillImageStatus;
	}

	public void setGasbillImageStatus(boolean gasbillImageStatus) {
		this.gasbillImageStatus = gasbillImageStatus;
	}

	public boolean isQrpayGpayDoc() {
		return qrpayGpayDoc;
	}

	public void setQrpayGpayDoc(boolean qrpayGpayDoc) {
		this.qrpayGpayDoc = qrpayGpayDoc;
	}

	public boolean isQrpayPhonepeDoc() {
		return qrpayPhonepeDoc;
	}

	public void setQrpayPhonepeDoc(boolean qrpayPhonepeDoc) {
		this.qrpayPhonepeDoc = qrpayPhonepeDoc;
	}

	public boolean isQrpayPaytmDoc() {
		return qrpayPaytmDoc;
	}

	public void setQrpayPaytmDoc(boolean qrpayPaytmDoc) {
		this.qrpayPaytmDoc = qrpayPaytmDoc;
	}

	public boolean isQrpayBharatpeDoc() {
		return qrpayBharatpeDoc;
	}

	public void setQrpayBharatpeDoc(boolean qrpayBharatpeDoc) {
		this.qrpayBharatpeDoc = qrpayBharatpeDoc;
	}

	public boolean isQrpayGpayBanklist() {
		return qrpayGpayBanklist;
	}

	public void setQrpayGpayBanklist(boolean qrpayGpayBanklist) {
		this.qrpayGpayBanklist = qrpayGpayBanklist;
	}

	public boolean isQrpayGpayProfile() {
		return qrpayGpayProfile;
	}

	public void setQrpayGpayProfile(boolean qrpayGpayProfile) {
		this.qrpayGpayProfile = qrpayGpayProfile;
	}

	public boolean isQrpayGpayBankdetails() {
		return qrpayGpayBankdetails;
	}

	public void setQrpayGpayBankdetails(boolean qrpayGpayBankdetails) {
		this.qrpayGpayBankdetails = qrpayGpayBankdetails;
	}

	public boolean isQrpayPhonepeBanklist() {
		return qrpayPhonepeBanklist;
	}

	public void setQrpayPhonepeBanklist(boolean qrpayPhonepeBanklist) {
		this.qrpayPhonepeBanklist = qrpayPhonepeBanklist;
	}

	public boolean isQrpayPhonepeProfile() {
		return qrpayPhonepeProfile;
	}

	public void setQrpayPhonepeProfile(boolean qrpayPhonepeProfile) {
		this.qrpayPhonepeProfile = qrpayPhonepeProfile;
	}

	public boolean isQrpayPhonepeBankdetails() {
		return qrpayPhonepeBankdetails;
	}

	public void setQrpayPhonepeBankdetails(boolean qrpayPhonepeBankdetails) {
		this.qrpayPhonepeBankdetails = qrpayPhonepeBankdetails;
	}

	public boolean isQrpayPaytmBanklist() {
		return qrpayPaytmBanklist;
	}

	public void setQrpayPaytmBanklist(boolean qrpayPaytmBanklist) {
		this.qrpayPaytmBanklist = qrpayPaytmBanklist;
	}

	public boolean isQrpayPaytmProfile() {
		return qrpayPaytmProfile;
	}

	public void setQrpayPaytmProfile(boolean qrpayPaytmProfile) {
		this.qrpayPaytmProfile = qrpayPaytmProfile;
	}

	public boolean isQrpayPaytmBankdetails() {
		return qrpayPaytmBankdetails;
	}

	public void setQrpayPaytmBankdetails(boolean qrpayPaytmBankdetails) {
		this.qrpayPaytmBankdetails = qrpayPaytmBankdetails;
	}

	public boolean isQrpayBharatpeBanklist() {
		return qrpayBharatpeBanklist;
	}

	public void setQrpayBharatpeBanklist(boolean qrpayBharatpeBanklist) {
		this.qrpayBharatpeBanklist = qrpayBharatpeBanklist;
	}

	public boolean isQrpayBharatpeProfile() {
		return qrpayBharatpeProfile;
	}

	public void setQrpayBharatpeProfile(boolean qrpayBharatpeProfile) {
		this.qrpayBharatpeProfile = qrpayBharatpeProfile;
	}

	public boolean isQrpayBharatpeBankdetails() {
		return qrpayBharatpeBankdetails;
	}

	public void setQrpayBharatpeBankdetails(boolean qrpayBharatpeBankdetails) {
		this.qrpayBharatpeBankdetails = qrpayBharatpeBankdetails;
	}

	public boolean isReferenceStatus() {
		return referenceStatus;
	}

	public void setReferenceStatus(boolean referenceStatus) {
		this.referenceStatus = referenceStatus;
	}

	public boolean isBillbookImage() {
		return billbookImage;
	}

	public void setBillbookImage(boolean billbookImage) {
		this.billbookImage = billbookImage;
	}

	public boolean isAddressVerificationStatus() {
		return addressVerificationStatus;
	}

	public void setAddressVerificationStatus(boolean addressVerificationStatus) {
		this.addressVerificationStatus = addressVerificationStatus;
	}

	public boolean isStmntDocStatus() {
		return stmntDocStatus;
	}

	public void setStmntDocStatus(boolean stmntDocStatus) {
		this.stmntDocStatus = stmntDocStatus;
	}

	public boolean isEbbillImage() {
		return ebbillImage;
	}

	public void setEbbillImage(boolean ebbillImage) {
		this.ebbillImage = ebbillImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCallLogStatus() {
		return callLogStatus;
	}

	public void setCallLogStatus(boolean callLogStatus) {
		this.callLogStatus = callLogStatus;
	}

	public boolean isContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(boolean contactStatus) {
		this.contactStatus = contactStatus;
	}

	public boolean isSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(boolean smsStatus) {
		this.smsStatus = smsStatus;
	}

	public boolean isCustAppStatus() {
		return custAppStatus;
	}

	public void setCustAppStatus(boolean custAppStatus) {
		this.custAppStatus = custAppStatus;
	}

	public Date getCallLofDateTime() {
		return callLofDateTime;
	}

	public void setCallLofDateTime(Date callLofDateTime) {
		this.callLofDateTime = callLofDateTime;
	}

	public Date getContactDateTime() {
		return contactDateTime;
	}

	public void setContactDateTime(Date contactDateTime) {
		this.contactDateTime = contactDateTime;
	}

	public Date getSmsDateTime() {
		return smsDateTime;
	}

	public void setSmsDateTime(Date smsDateTime) {
		this.smsDateTime = smsDateTime;
	}

	public Date getCustAppDateTime() {
		return custAppDateTime;
	}

	public void setCustAppDateTime(Date custAppDateTime) {
		this.custAppDateTime = custAppDateTime;
	}

	public boolean isEnableStmntUpload() {
		return enableStmntUpload;
	}

	public void setEnableStmntUpload(boolean enableStmntUpload) {
		this.enableStmntUpload = enableStmntUpload;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public boolean isPhotoCreditStatus() {
		return photoCreditStatus;
	}

	public void setPhotoCreditStatus(boolean photoCreditStatus) {
		this.photoCreditStatus = photoCreditStatus;
	}

	public boolean isPhotoOpsStatus() {
		return photoOpsStatus;
	}

	public void setPhotoOpsStatus(boolean photoOpsStatus) {
		this.photoOpsStatus = photoOpsStatus;
	}

	public boolean isPrequalifyApproveStatus() {
		return prequalifyApproveStatus;
	}

	public void setPrequalifyApproveStatus(boolean prequalifyApproveStatus) {
		this.prequalifyApproveStatus = prequalifyApproveStatus;
	}

	public Date getEsignTime() {
		return esignTime;
	}

	public void setEsignTime(Date esignTime) {
		this.esignTime = esignTime;
	}

	public boolean isGleadStatus() {
		return gleadStatus;
	}

	public void setGleadStatus(boolean gleadStatus) {
		this.gleadStatus = gleadStatus;
	}

	public boolean isFamilyapplicantStatus() {
		return familyapplicantStatus;
	}

	public void setFamilyapplicantStatus(boolean familyapplicantStatus) {
		this.familyapplicantStatus = familyapplicantStatus;
	}

	public boolean isManualdocTxnStatus() {
		return manualdocTxnStatus;
	}

	public void setManualdocTxnStatus(boolean manualdocTxnStatus) {
		this.manualdocTxnStatus = manualdocTxnStatus;
	}

	public boolean isMosStatus() {
		return mosStatus;
	}

	public void setMosStatus(boolean mosStatus) {
		this.mosStatus = mosStatus;
	}

	public boolean isSfiStatus() {
		return sfiStatus;
	}

	public void setSfiStatus(boolean sfiStatus) {
		this.sfiStatus = sfiStatus;
	}

	public int getStmntStatusTrycount() {
		return stmntStatusTrycount;
	}

	public void setStmntStatusTrycount(int stmntStatusTrycount) {
		this.stmntStatusTrycount = stmntStatusTrycount;
	}

	public boolean isBusinessCreditStatus() {
		return businessCreditStatus;
	}

	public void setBusinessCreditStatus(boolean businessCreditStatus) {
		this.businessCreditStatus = businessCreditStatus;
	}

	public boolean isUpiAmtSufficientStatus() {
		return upiAmtSufficientStatus;
	}

	public void setUpiAmtSufficientStatus(boolean upiAmtSufficientStatus) {
		this.upiAmtSufficientStatus = upiAmtSufficientStatus;
	}

	public boolean isManualCreditApproveStatus() {
		return manualCreditApproveStatus;
	}

	public void setManualCreditApproveStatus(boolean manualCreditApproveStatus) {
		this.manualCreditApproveStatus = manualCreditApproveStatus;
	}

	public boolean isCkycStatus() {
		return ckycStatus;
	}

	public void setCkycStatus(boolean ckycStatus) {
		this.ckycStatus = ckycStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aaMobileOtpStatus, aadhaarStatus, addressVerificationStatus, agentId, applicationStatus,
				backImageStatus, bankStmntUpicreditStatus, billbookImage, boardImageStatus, businessAssetStatus,
				businessCreditStatus, callLofDateTime, callLogStatus, ckycStatus, coapplicantCompletedSatus,
				contactDateTime, contactStatus, createTime, creditQualifyStatus, custAppDateTime, custAppStatus,
				customerDependentStatus, disburseApprovalStatus, disburseStatus, ebbillImage, enableStmntUpload,
				enachStatus, esignStatus, esignTime, familyStatus, familyapplicantStatus, frontImageStatus,
				gasbillImageStatus, getOfferStatus, gleadStatus, homeImageStatus, id, interiorImageStatus, lmsStatus,
				loanApplied, loanOffered, mandateApprovalStatus, mandateStatus, manualCreditApproveStatus,
				manualdocTxnStatus, modifyTime, mosStatus, okycStatus, otherIncomeStatus, otpStatus, ownershipStatus,
				panAadhaarSeedStatus, panImageStatus, panStatus, panValTryCount, pennyDropTryCount, pennydropStatus,
				personalAssetStatus, photoCreditStatus, photoOpsStatus, pincodeStatus, prequalifyApproveStatus,
				prequalifyStatus, profile1Status, qr1ImageStatus, qr2ImageStatus, qr3ImageStatus,
				qrpayBharatpeBankdetails, qrpayBharatpeBanklist, qrpayBharatpeDoc, qrpayBharatpeProfile,
				qrpayBharatpemerchPhcnt, qrpayBharatpemerchPhstatus, qrpayGpayBankdetails, qrpayGpayBanklist,
				qrpayGpayDoc, qrpayGpayProfile, qrpayGpaymerchPhcnt, qrpayGpaymerchPhstatus, qrpayPaytmBankdetails,
				qrpayPaytmBanklist, qrpayPaytmDoc, qrpayPaytmProfile, qrpayPaytmmerchPhcnt, qrpayPaytmmerchPhstatus,
				qrpayPhonepeBankdetails, qrpayPhonepeBanklist, qrpayPhonepeDoc, qrpayPhonepeProfile,
				qrpayPhonepemerchPhcnt, qrpayPhonepemerchPhstatus, qualifiedAaStatus, qualifiedBureauStatus,
				rationcardImageStatus, referenceStatus, selfieImageStatus, sfiStatus, smsDateTime, smsStatus,
				stmntDocStatus, stmntFinduitTrycount, stmntFinvuTrycount, stmntStatus, stmntStatusTrycount,
				upiAmtSufficientStatus, upiMandateStatus, video360Status, videoStatus, vkycStatus, vpaStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UlCustomerStateStatus other = (UlCustomerStateStatus) obj;
		return aaMobileOtpStatus == other.aaMobileOtpStatus && aadhaarStatus == other.aadhaarStatus
				&& addressVerificationStatus == other.addressVerificationStatus && agentId == other.agentId
				&& applicationStatus == other.applicationStatus && backImageStatus == other.backImageStatus
				&& bankStmntUpicreditStatus == other.bankStmntUpicreditStatus && billbookImage == other.billbookImage
				&& boardImageStatus == other.boardImageStatus && businessAssetStatus == other.businessAssetStatus
				&& businessCreditStatus == other.businessCreditStatus
				&& Objects.equals(callLofDateTime, other.callLofDateTime) && callLogStatus == other.callLogStatus
				&& ckycStatus == other.ckycStatus && coapplicantCompletedSatus == other.coapplicantCompletedSatus
				&& Objects.equals(contactDateTime, other.contactDateTime) && contactStatus == other.contactStatus
				&& Objects.equals(createTime, other.createTime) && creditQualifyStatus == other.creditQualifyStatus
				&& Objects.equals(custAppDateTime, other.custAppDateTime) && custAppStatus == other.custAppStatus
				&& customerDependentStatus == other.customerDependentStatus
				&& disburseApprovalStatus == other.disburseApprovalStatus && disburseStatus == other.disburseStatus
				&& ebbillImage == other.ebbillImage && enableStmntUpload == other.enableStmntUpload
				&& enachStatus == other.enachStatus && esignStatus == other.esignStatus
				&& Objects.equals(esignTime, other.esignTime) && familyStatus == other.familyStatus
				&& familyapplicantStatus == other.familyapplicantStatus && frontImageStatus == other.frontImageStatus
				&& gasbillImageStatus == other.gasbillImageStatus && getOfferStatus == other.getOfferStatus
				&& gleadStatus == other.gleadStatus && homeImageStatus == other.homeImageStatus && id == other.id
				&& interiorImageStatus == other.interiorImageStatus && lmsStatus == other.lmsStatus
				&& loanApplied == other.loanApplied && loanOffered == other.loanOffered
				&& mandateApprovalStatus == other.mandateApprovalStatus && mandateStatus == other.mandateStatus
				&& manualCreditApproveStatus == other.manualCreditApproveStatus
				&& manualdocTxnStatus == other.manualdocTxnStatus && Objects.equals(modifyTime, other.modifyTime)
				&& mosStatus == other.mosStatus && okycStatus == other.okycStatus
				&& otherIncomeStatus == other.otherIncomeStatus && otpStatus == other.otpStatus
				&& ownershipStatus == other.ownershipStatus && panAadhaarSeedStatus == other.panAadhaarSeedStatus
				&& panImageStatus == other.panImageStatus && panStatus == other.panStatus
				&& panValTryCount == other.panValTryCount && pennyDropTryCount == other.pennyDropTryCount
				&& pennydropStatus == other.pennydropStatus && personalAssetStatus == other.personalAssetStatus
				&& photoCreditStatus == other.photoCreditStatus && photoOpsStatus == other.photoOpsStatus
				&& pincodeStatus == other.pincodeStatus && prequalifyApproveStatus == other.prequalifyApproveStatus
				&& prequalifyStatus == other.prequalifyStatus && profile1Status == other.profile1Status
				&& qr1ImageStatus == other.qr1ImageStatus && qr2ImageStatus == other.qr2ImageStatus
				&& qr3ImageStatus == other.qr3ImageStatus && qrpayBharatpeBankdetails == other.qrpayBharatpeBankdetails
				&& qrpayBharatpeBanklist == other.qrpayBharatpeBanklist && qrpayBharatpeDoc == other.qrpayBharatpeDoc
				&& qrpayBharatpeProfile == other.qrpayBharatpeProfile
				&& qrpayBharatpemerchPhcnt == other.qrpayBharatpemerchPhcnt
				&& qrpayBharatpemerchPhstatus == other.qrpayBharatpemerchPhstatus
				&& qrpayGpayBankdetails == other.qrpayGpayBankdetails && qrpayGpayBanklist == other.qrpayGpayBanklist
				&& qrpayGpayDoc == other.qrpayGpayDoc && qrpayGpayProfile == other.qrpayGpayProfile
				&& qrpayGpaymerchPhcnt == other.qrpayGpaymerchPhcnt
				&& qrpayGpaymerchPhstatus == other.qrpayGpaymerchPhstatus
				&& qrpayPaytmBankdetails == other.qrpayPaytmBankdetails
				&& qrpayPaytmBanklist == other.qrpayPaytmBanklist && qrpayPaytmDoc == other.qrpayPaytmDoc
				&& qrpayPaytmProfile == other.qrpayPaytmProfile && qrpayPaytmmerchPhcnt == other.qrpayPaytmmerchPhcnt
				&& qrpayPaytmmerchPhstatus == other.qrpayPaytmmerchPhstatus
				&& qrpayPhonepeBankdetails == other.qrpayPhonepeBankdetails
				&& qrpayPhonepeBanklist == other.qrpayPhonepeBanklist && qrpayPhonepeDoc == other.qrpayPhonepeDoc
				&& qrpayPhonepeProfile == other.qrpayPhonepeProfile
				&& qrpayPhonepemerchPhcnt == other.qrpayPhonepemerchPhcnt
				&& qrpayPhonepemerchPhstatus == other.qrpayPhonepemerchPhstatus
				&& qualifiedAaStatus == other.qualifiedAaStatus && qualifiedBureauStatus == other.qualifiedBureauStatus
				&& rationcardImageStatus == other.rationcardImageStatus && referenceStatus == other.referenceStatus
				&& selfieImageStatus == other.selfieImageStatus && sfiStatus == other.sfiStatus
				&& Objects.equals(smsDateTime, other.smsDateTime) && smsStatus == other.smsStatus
				&& stmntDocStatus == other.stmntDocStatus && stmntFinduitTrycount == other.stmntFinduitTrycount
				&& stmntFinvuTrycount == other.stmntFinvuTrycount && stmntStatus == other.stmntStatus
				&& stmntStatusTrycount == other.stmntStatusTrycount
				&& upiAmtSufficientStatus == other.upiAmtSufficientStatus && upiMandateStatus == other.upiMandateStatus
				&& video360Status == other.video360Status && videoStatus == other.videoStatus
				&& vkycStatus == other.vkycStatus && vpaStatus == other.vpaStatus;
	}

	@Override
	public String toString() {
		return "UlCustomerStateStatus [id=" + id + ", agentId=" + agentId + ", profile1Status=" + profile1Status
				+ ", otpStatus=" + otpStatus + ", panStatus=" + panStatus + ", panValTryCount=" + panValTryCount
				+ ", prequalifyStatus=" + prequalifyStatus + ", prequalifyApproveStatus=" + prequalifyApproveStatus
				+ ", creditQualifyStatus=" + creditQualifyStatus + ", panAadhaarSeedStatus=" + panAadhaarSeedStatus
				+ ", bankStmntUpicreditStatus=" + bankStmntUpicreditStatus + ", stmntStatus=" + stmntStatus
				+ ", stmntStatusTrycount=" + stmntStatusTrycount + ", stmntDocStatus=" + stmntDocStatus
				+ ", manualdocTxnStatus=" + manualdocTxnStatus + ", personalAssetStatus=" + personalAssetStatus
				+ ", businessAssetStatus=" + businessAssetStatus + ", businessCreditStatus=" + businessCreditStatus
				+ ", pincodeStatus=" + pincodeStatus + ", aadhaarStatus=" + aadhaarStatus + ", qualifiedBureauStatus="
				+ qualifiedBureauStatus + ", qualifiedAaStatus=" + qualifiedAaStatus + ", getOfferStatus="
				+ getOfferStatus + ", mandateStatus=" + mandateStatus + ", mandateApprovalStatus="
				+ mandateApprovalStatus + ", manualCreditApproveStatus=" + manualCreditApproveStatus + ", vkycStatus="
				+ vkycStatus + ", okycStatus=" + okycStatus + ", ckycStatus=" + ckycStatus + ", sfiStatus=" + sfiStatus
				+ ", esignStatus=" + esignStatus + ", enachStatus=" + enachStatus + ", boardImageStatus="
				+ boardImageStatus + ", panImageStatus=" + panImageStatus + ", interiorImageStatus="
				+ interiorImageStatus + ", frontImageStatus=" + frontImageStatus + ", backImageStatus="
				+ backImageStatus + ", ownershipStatus=" + ownershipStatus + ", selfieImageStatus=" + selfieImageStatus
				+ ", disburseStatus=" + disburseStatus + ", disburseApprovalStatus=" + disburseApprovalStatus
				+ ", pennydropStatus=" + pennydropStatus + ", pennyDropTryCount=" + pennyDropTryCount
				+ ", otherIncomeStatus=" + otherIncomeStatus + ", customerDependentStatus=" + customerDependentStatus
				+ ", aaMobileOtpStatus=" + aaMobileOtpStatus + ", loanOffered=" + loanOffered + ", loanApplied="
				+ loanApplied + ", applicationStatus=" + applicationStatus + ", homeImageStatus=" + homeImageStatus
				+ ", qr1ImageStatus=" + qr1ImageStatus + ", qr2ImageStatus=" + qr2ImageStatus + ", qr3ImageStatus="
				+ qr3ImageStatus + ", billbookImage=" + billbookImage + ", ebbillImage=" + ebbillImage + ", lmsStatus="
				+ lmsStatus + ", vpaStatus=" + vpaStatus + ", upiMandateStatus=" + upiMandateStatus
				+ ", coapplicantCompletedSatus=" + coapplicantCompletedSatus + ", familyapplicantStatus="
				+ familyapplicantStatus + ", familyStatus=" + familyStatus + ", videoStatus=" + videoStatus
				+ ", video360Status=" + video360Status + ", stmntFinduitTrycount=" + stmntFinduitTrycount
				+ ", stmntFinvuTrycount=" + stmntFinvuTrycount + ", qrpayGpaymerchPhstatus=" + qrpayGpaymerchPhstatus
				+ ", qrpayGpaymerchPhcnt=" + qrpayGpaymerchPhcnt + ", qrpayPhonepemerchPhstatus="
				+ qrpayPhonepemerchPhstatus + ", qrpayPhonepemerchPhcnt=" + qrpayPhonepemerchPhcnt
				+ ", qrpayPaytmmerchPhstatus=" + qrpayPaytmmerchPhstatus + ", qrpayPaytmmerchPhcnt="
				+ qrpayPaytmmerchPhcnt + ", qrpayBharatpemerchPhstatus=" + qrpayBharatpemerchPhstatus
				+ ", qrpayBharatpemerchPhcnt=" + qrpayBharatpemerchPhcnt + ", rationcardImageStatus="
				+ rationcardImageStatus + ", gasbillImageStatus=" + gasbillImageStatus + ", qrpayGpayDoc="
				+ qrpayGpayDoc + ", qrpayPhonepeDoc=" + qrpayPhonepeDoc + ", qrpayPaytmDoc=" + qrpayPaytmDoc
				+ ", qrpayBharatpeDoc=" + qrpayBharatpeDoc + ", qrpayGpayBanklist=" + qrpayGpayBanklist
				+ ", qrpayGpayProfile=" + qrpayGpayProfile + ", qrpayGpayBankdetails=" + qrpayGpayBankdetails
				+ ", qrpayPhonepeBanklist=" + qrpayPhonepeBanklist + ", qrpayPhonepeProfile=" + qrpayPhonepeProfile
				+ ", qrpayPhonepeBankdetails=" + qrpayPhonepeBankdetails + ", qrpayPaytmBanklist=" + qrpayPaytmBanklist
				+ ", qrpayPaytmProfile=" + qrpayPaytmProfile + ", qrpayPaytmBankdetails=" + qrpayPaytmBankdetails
				+ ", qrpayBharatpeBanklist=" + qrpayBharatpeBanklist + ", qrpayBharatpeProfile=" + qrpayBharatpeProfile
				+ ", qrpayBharatpeBankdetails=" + qrpayBharatpeBankdetails + ", referenceStatus=" + referenceStatus
				+ ", addressVerificationStatus=" + addressVerificationStatus + ", upiAmtSufficientStatus="
				+ upiAmtSufficientStatus + ", callLogStatus=" + callLogStatus + ", callLofDateTime=" + callLofDateTime
				+ ", contactStatus=" + contactStatus + ", contactDateTime=" + contactDateTime + ", smsStatus="
				+ smsStatus + ", smsDateTime=" + smsDateTime + ", esignTime=" + esignTime + ", custAppStatus="
				+ custAppStatus + ", custAppDateTime=" + custAppDateTime + ", enableStmntUpload=" + enableStmntUpload
				+ ", photoCreditStatus=" + photoCreditStatus + ", photoOpsStatus=" + photoOpsStatus + ", gleadStatus="
				+ gleadStatus + ", mosStatus=" + mosStatus + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ "]";
	}

}
