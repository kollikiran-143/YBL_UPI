package in.fl.los.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity(name = "ul_loans")
public class UlLoans implements Serializable {

	private static final long serialVersionUID = -5899984400206114373L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id", unique = true, nullable = false, precision = 10)
	private int loanId;
	@Column(name = "lms_loan_id", precision = 10)
	private int lmsLoanId;
	@Column(precision = 10)
	private float amount;
	@Column(precision = 5)
	private float irr;
	@Column(name = "irr_daily")
	private float irrDaily;
	@Column(name = "flat_rate", precision = 5)
	private float flatRate;
	@Column(precision = 5)
	private float tenure;
	@Column(name = "tenure_days")
	private int tenureDays;
	@Column(name = "proc_fee", precision = 10)
	private float procFee;
	@Column(name = "proc_fee_percent", precision = 5)
	private float procFeePercent;
	@Column(name = "gca_amount", precision = 10)
	private float gcaAmount;
	@Column(name = "gca_percent", precision = 10)
	private float gcaPercent;
	@Column(precision = 10)
	private float emi;
	@Column(precision = 10)
	private float edi;
	@Column(name = "disb_amount", precision = 10)
	private float disbAmount;
	@Column(name = "settlement_amt", precision = 15)
	private float settlementAmt;
	@Column(name = "int_paid")
	private float intPaid;
	@Column(name = "loan_status", length = 10)
	private String loanStatus;
	@Column(name = "loan_amount_req", precision = 15)
	private float loanAmountReq;
	@Column(name = "loan_scheme", length = 20)
	private String loanScheme;
	@Column(length = 100)
	private String agreement;
	@Column(name = "mandate_mode")
	private String mandateMode;
	@Column(name = "upidebit_sheduled_time")
	private int upidebitSheduledTime;
	@Column(name = "upimandate_amount", precision = 12)
	private float upiMandateAmount;
	@Column(name = "app_esign_status", precision = 1)
	private boolean appEsignStatus;
	@Column(name = "coapp_esign_status", precision = 1)
	private boolean coAppEsignStatus;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_time")
	private Date modifyTime;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable = false)
	private UlCustomerDetails customerDetails;

	@PrePersist
	protected void onCreate() {
		createTime = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyTime = new Date();
	}

	public UlLoans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getLmsLoanId() {
		return lmsLoanId;
	}

	public void setLmsLoanId(int lmsLoanId) {
		this.lmsLoanId = lmsLoanId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getIrr() {
		return irr;
	}

	public void setIrr(float irr) {
		this.irr = irr;
	}

	public float getFlatRate() {
		return flatRate;
	}

	public void setFlatRate(float flatRate) {
		this.flatRate = flatRate;
	}

	public float getTenure() {
		return tenure;
	}

	public void setTenure(float tenure) {
		this.tenure = tenure;
	}

	public float getProcFee() {
		return procFee;
	}

	public void setProcFee(float procFee) {
		this.procFee = procFee;
	}

	public float getProcFeePercent() {
		return procFeePercent;
	}

	public void setProcFeePercent(float procFeePercent) {
		this.procFeePercent = procFeePercent;
	}

	public float getGcaAmount() {
		return gcaAmount;
	}

	public void setGcaAmount(float gcaAmount) {
		this.gcaAmount = gcaAmount;
	}

	public float getGcaPercent() {
		return gcaPercent;
	}

	public void setGcaPercent(float gcaPercent) {
		this.gcaPercent = gcaPercent;
	}

	public float getEmi() {
		return emi;
	}

	public void setEmi(float emi) {
		this.emi = emi;
	}

	public float getEdi() {
		return edi;
	}

	public void setEdi(float edi) {
		this.edi = edi;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public float getLoanAmountReq() {
		return loanAmountReq;
	}

	public void setLoanAmountReq(float loanAmountReq) {
		this.loanAmountReq = loanAmountReq;
	}

	public String getLoanScheme() {
		return loanScheme;
	}

	public void setLoanScheme(String loanScheme) {
		this.loanScheme = loanScheme;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getMandateMode() {
		return mandateMode;
	}

	public void setMandateMode(String mandateMode) {
		this.mandateMode = mandateMode;
	}

	public int getUpidebitSheduledTime() {
		return upidebitSheduledTime;
	}

	public void setUpidebitSheduledTime(int upidebitSheduledTime) {
		this.upidebitSheduledTime = upidebitSheduledTime;
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

	public float getDisbAmount() {
		return disbAmount;
	}

	public void setDisbAmount(float disbAmount) {
		this.disbAmount = disbAmount;
	}

	public boolean isAppEsignStatus() {
		return appEsignStatus;
	}

	public void setAppEsignStatus(boolean appEsignStatus) {
		this.appEsignStatus = appEsignStatus;
	}

	public boolean isCoAppEsignStatus() {
		return coAppEsignStatus;
	}

	public void setCoAppEsignStatus(boolean coAppEsignStatus) {
		this.coAppEsignStatus = coAppEsignStatus;
	}

	public int getTenureDays() {
		return tenureDays;
	}

	public void setTenureDays(int tenureDays) {
		this.tenureDays = tenureDays;
	}

	public float getUpiMandateAmount() {
		return upiMandateAmount;
	}

	public void setUpiMandateAmount(float upiMandateAmount) {
		this.upiMandateAmount = upiMandateAmount;
	}

	public float getIrrDaily() {
		return irrDaily;
	}

	public void setIrrDaily(float irrDaily) {
		this.irrDaily = irrDaily;
	}

	public float getIntPaid() {
		return intPaid;
	}

	public void setIntPaid(float intPaid) {
		this.intPaid = intPaid;
	}

	public float getSettlementAmt() {
		return settlementAmt;
	}

	public void setSettlementAmt(float settlementAmt) {
		this.settlementAmt = settlementAmt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreement == null) ? 0 : agreement.hashCode());
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + (appEsignStatus ? 1231 : 1237);
		result = prime * result + (coAppEsignStatus ? 1231 : 1237);
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + Float.floatToIntBits(disbAmount);
		result = prime * result + Float.floatToIntBits(edi);
		result = prime * result + Float.floatToIntBits(emi);
		result = prime * result + Float.floatToIntBits(flatRate);
		result = prime * result + Float.floatToIntBits(gcaAmount);
		result = prime * result + Float.floatToIntBits(gcaPercent);
		result = prime * result + Float.floatToIntBits(irr);
		result = prime * result + lmsLoanId;
		result = prime * result + Float.floatToIntBits(loanAmountReq);
		result = prime * result + loanId;
		result = prime * result + ((loanScheme == null) ? 0 : loanScheme.hashCode());
		result = prime * result + ((loanStatus == null) ? 0 : loanStatus.hashCode());
		result = prime * result + ((mandateMode == null) ? 0 : mandateMode.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + Float.floatToIntBits(procFee);
		result = prime * result + Float.floatToIntBits(procFeePercent);
		result = prime * result + Float.floatToIntBits(tenure);
		result = prime * result + tenureDays;
		result = prime * result + upidebitSheduledTime;
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
		UlLoans other = (UlLoans) obj;
		if (agreement == null) {
			if (other.agreement != null)
				return false;
		} else if (!agreement.equals(other.agreement))
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (appEsignStatus != other.appEsignStatus)
			return false;
		if (coAppEsignStatus != other.coAppEsignStatus)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (Float.floatToIntBits(disbAmount) != Float.floatToIntBits(other.disbAmount))
			return false;
		if (Float.floatToIntBits(edi) != Float.floatToIntBits(other.edi))
			return false;
		if (Float.floatToIntBits(emi) != Float.floatToIntBits(other.emi))
			return false;
		if (Float.floatToIntBits(flatRate) != Float.floatToIntBits(other.flatRate))
			return false;
		if (Float.floatToIntBits(gcaAmount) != Float.floatToIntBits(other.gcaAmount))
			return false;
		if (Float.floatToIntBits(gcaPercent) != Float.floatToIntBits(other.gcaPercent))
			return false;
		if (Float.floatToIntBits(irr) != Float.floatToIntBits(other.irr))
			return false;
		if (lmsLoanId != other.lmsLoanId)
			return false;
		if (Float.floatToIntBits(loanAmountReq) != Float.floatToIntBits(other.loanAmountReq))
			return false;
		if (loanId != other.loanId)
			return false;
		if (loanScheme == null) {
			if (other.loanScheme != null)
				return false;
		} else if (!loanScheme.equals(other.loanScheme))
			return false;
		if (loanStatus == null) {
			if (other.loanStatus != null)
				return false;
		} else if (!loanStatus.equals(other.loanStatus))
			return false;
		if (mandateMode == null) {
			if (other.mandateMode != null)
				return false;
		} else if (!mandateMode.equals(other.mandateMode))
			return false;
		if (modifyTime == null) {
			if (other.modifyTime != null)
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			return false;
		if (Float.floatToIntBits(procFee) != Float.floatToIntBits(other.procFee))
			return false;
		if (Float.floatToIntBits(procFeePercent) != Float.floatToIntBits(other.procFeePercent))
			return false;
		if (Float.floatToIntBits(tenure) != Float.floatToIntBits(other.tenure))
			return false;
		if (tenureDays != other.tenureDays)
			return false;
		if (upidebitSheduledTime != other.upidebitSheduledTime)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UlLoans [loanId=%s, lmsLoanId=%s, amount=%s, irr=%s, flatRate=%s, tenure=%s, tenureDays=%s, procFee=%s, procFeePercent=%s, gcaAmount=%s, gcaPercent=%s, emi=%s, edi=%s, disbAmount=%s, loanStatus=%s, loanAmountReq=%s, loanScheme=%s, agreement=%s, mandateMode=%s, upidebitSheduledTime=%s, upiMandateAmount=%s, appEsignStatus=%s, coAppEsignStatus=%s, createTime=%s, modifyTime=%s, customerDetails=%s]",
				loanId, lmsLoanId, amount, irr, flatRate, tenure, tenureDays, procFee, procFeePercent, gcaAmount,
				gcaPercent, emi, edi, disbAmount, loanStatus, loanAmountReq, loanScheme, agreement, mandateMode,
				upidebitSheduledTime, upiMandateAmount, appEsignStatus, coAppEsignStatus, createTime, modifyTime,
				customerDetails);
	}

}