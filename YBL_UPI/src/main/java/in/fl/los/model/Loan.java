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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * Data model class of lms_loan table Consists access methods for columns
 * present in the lms_loan table
 * 
 * @author Rajesh Kumar
 *
 */
@Entity(name = "lms_loan")
public class Loan implements Serializable {

	private static final long serialVersionUID = 7504966643551469301L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "los_id", nullable = false, precision = 10)
	private int losId;
	@Column(name = "los_cust_id", precision = 10)
	private int losCustId;
	@Column(precision = 10)
	private int pid;
	@Column(name = "loan_no", length = 20)
	private String loanNo;
	@Column(name = "loan_no_hash", length = 20)
	private String loanNoHash;
	@Column(name = "cust_name", length = 100)
	private String custName;
	@Column(nullable = false, length = 5)
	private String type;
	@Column(name = "agmt_date")
	private Date agmtDate;
	@Column(name = "disb_time")
	private Date disbTime;
	@Column(name = "first_due_date")
	private Date firstDueDate;
	@Column(name = "last_due_date")
	private Date lastDueDate;
	@Column(name = "loan_amt", precision = 15)
	private float loanAmt;
	@Column(precision = 3)
	private float tenure;
	@Column(name = "tenure_days")
	private int tenureDays;
	@Column(precision = 5)
	private float irr;
	@Column(name = "irr_daily")
	private float irrDaily;
	@Column(name = "flat_rate", precision = 5)
	private float flatRate;
	@Column(precision = 7)
	private float pf;
	@Column(name = "pf_base", precision = 7)
	private float pfBase;
	@Column(name = "pf_tax", precision = 7)
	private float pfTax;
	@Column(name = "pf_pct", precision = 5)
	private float pfPct;
	@Column(name = "gca_amt", precision = 7)
	private float gcaAmt;
	@Column(name = "gca_pct", precision = 5)
	private float gcaPct;
	@Column(name = "disb_amt", precision = 15)
	private float disbAmt;
	@Column(name = "net_disb_amt", precision = 15)
	private float netDisbAmt;
	@Column(precision = 10)
	private float emi;
	@Column(precision = 10)
	private float edi;
	@Column(name = "adv_emis", precision = 3)
	private int advEmis;
	@Column(name = "excess_paid", precision = 10)
	private float excessPaid;
	@Column(precision = 10)
	private float arrears;
	@Column(precision = 10)
	private float bc;
	@Column(precision = 10)
	private float odc;
	@Column(precision = 10)
	private float oc;
	@Column(length = 24)
	private String status;
	@Column(name = "status_dispo", length = 24)
	private String statusDispo;
	@Column(length = 24)
	private String scheme;
	@Column(length = 3)
	private String book;
	@Column(length = 20)
	private String hypothecation;
	@Column(name = "co_lender", length = 30)
	private String coLender;
	@Column(name = "co_lender_pct", precision = 5)
	private float coLenderPct;
	@Column(precision = 10)
	private float expense;
	@Column(length = 100)
	private String agreement;
	@Column(length = 100)
	private String mandate;
	@Column(length = 100)
	private String noc;
	@Column(length = 32)
	private String umrn;
	@Column(name = "upi_umrn")
	private String upiUmrn;

	@Column(name = "upi_bankname")
	private String upiBankName;

	@Column(name = "mandate_type", length = 10)
	private String mandateType;
	@Column(name = "mandate_arg_1", length = 40)
	private String mandateArg;
	@Column(name = "debit_scheduled_time")
	private Date debtScheduleTime;
	@Column(name = "upi_predebit", nullable = false, length = 3)
	private boolean upiPredebit;
	@Column(name = "upi_debit", nullable = false, length = 3)
	private boolean upiDebit;
	@Column(name = "soc_pq_score", precision = 10)
	private int socPqScore;
	@Column(name = "soc_pq_min_amt", precision = 10)
	private float socPqMinAmt;
	@Column(name = "soc_pq_max_amt", precision = 10)
	private float socPqMaxAmt;
	@Column(name = "soc_cap", precision = 10)
	private float socCap;
	@Column(name = "soc_cred", precision = 5)
	private float socCred;
	@Column(name = "soc_conf", precision = 5)
	private float socConf;
	@Column(name = "soc_emi", precision = 10)
	private float socEmi;
	@Column(name = "soc_irr", precision = 6)
	private float socIrr;
	@Column(name = "soc_repay_day", precision = 3)
	private int socRepayDay;
	@Column(name = "soc_cibil_score", precision = 3)
	private int socCibilScore;
	@Column(name = "loan_amount_req", precision = 10)
	private float reqLoanAmt;
	@Column(length = 24)
	private String bank;
	@Column(name = "human_verified", precision = 3)
	private boolean humanVerified;
	@Column(precision = 3)
	private boolean tvr;
	@Column(precision = 12)
	private float pos;
	@Column(precision = 12)
	private float pod;
	@Column(name = "p_paid", precision = 12)
	private float pPaid;
	@Column(precision = 12)
	private float ios;
	@Column(precision = 12)
	private float iod;
	@Column(name = "i_paid", precision = 12)
	private float iPaid;
	@Column(name = "odc_os", precision = 12)
	private float odcOs;
	@Column(name = "odc_paid", precision = 12)
	private float odcPaid;
	@Column(name = "bc_os", precision = 12)
	private float bcOs;
	@Column(name = "bc_paid", precision = 12)
	private float bcPaid;
	@Column(name = "bc_paid_base", precision = 12)
	private float bcPaidBase;
	@Column(name = "bc_paid_tax", precision = 12)
	private float bcPaidTax;
	@Column(name = "moratorium_int", precision = 12)
	private float moratoriumInt;
	@Column(name = "broken_period_int", precision = 12)
	private float brokenPeriodInt;
	@Column(name = "fcl_charge", precision = 10)
	private float fclCharge;
	@Column(name = "fcl_amt", precision = 10)
	private float fclAmt;
	@Column(precision = 3)
	private int dpd;
	@Column(precision = 3)
	private int bucket;
	@Column(name = "ots_enabled", precision = 3)
	private boolean otsEnabled;
	@Column(name = "ots_amount", precision = 10)
	private int otsAmount;
	@Column(name = "prev_month_bucket", precision = 3)
	private int prevMonthBucket;
	@Column(name = "dues_matured", precision = 3)
	private boolean duesMatured;
	@Column(name = "fl_score", precision = 10)
	private float flScore;
	@Column(name = "closed_time")
	private Date closedTime;
	@Column(name = "cancel_reason", length = 20)
	private String cancelReason;
	@Column(name = "pay_prop_score", precision = 3)
	private int payPropScore;
	@Column(name = "create_user", length = 10)
	private String createUser;
	@Column(name = "disburse_txn_id", length = 50)
	private String disburseTxnId;
	@Column(name = "rrn", length = 24)
	private String rrn;
	@Column(name = "mandate_mode")
	private String mandateMode;
	@Column(name = "upidebit_sheduled_time")
	private int upidebitSheduledTime;

	@Column(name = "upi_mandate_id")
	private int upiMandateId;

	@Column(name = "charges_waive")
	private boolean chargesWaive;

	@Column(name = "upi_mandate_amount")
	private float upiMandateAmount;

	@Column(name = "upi_mandate_expirydt")
	private Date upiMandateExpiryDate;

	@Column(name = "upi_bankaccount")
	private String upiBankAccountNo;

	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "modify_user", length = 10)
	private String modifyUser;
	@Column(name = "modify_time")
	private Date modifyTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loan", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Receivable> receivable;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "loan", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<LmsLoanStatus> loanStatus;

	public Loan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLosId() {
		return losId;
	}

	public void setLosId(int losId) {
		this.losId = losId;
	}

	public int getLosCustId() {
		return losCustId;
	}

	public void setLosCustId(int losCustId) {
		this.losCustId = losCustId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getLoanNoHash() {
		return loanNoHash;
	}

	public void setLoanNoHash(String loanNoHash) {
		this.loanNoHash = loanNoHash;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getAgmtDate() {
		return agmtDate;
	}

	public void setAgmtDate(Date agmtDate) {
		this.agmtDate = agmtDate;
	}

	public Date getDisbTime() {
		return disbTime;
	}

	public void setDisbTime(Date disbTime) {
		this.disbTime = disbTime;
	}

	public Date getFirstDueDate() {
		return firstDueDate;
	}

	public void setFirstDueDate(Date firstDueDate) {
		this.firstDueDate = firstDueDate;
	}

	public Date getLastDueDate() {
		return lastDueDate;
	}

	public void setLastDueDate(Date lastDueDate) {
		this.lastDueDate = lastDueDate;
	}

	public float getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(float loanAmt) {
		this.loanAmt = loanAmt;
	}

	public float getTenure() {
		return tenure;
	}

	public void setTenure(float tenure) {
		this.tenure = tenure;
	}

	public int getTenureDays() {
		return tenureDays;
	}

	public void setTenureDays(int tenureDays) {
		this.tenureDays = tenureDays;
	}

	public float getIrr() {
		return irr;
	}

	public void setIrr(float irr) {
		this.irr = irr;
	}

	public float getIrrDaily() {
		return irrDaily;
	}

	public void setIrrDaily(float irrDaily) {
		this.irrDaily = irrDaily;
	}

	public float getFlatRate() {
		return flatRate;
	}

	public void setFlatRate(float flatRate) {
		this.flatRate = flatRate;
	}

	public float getPf() {
		return pf;
	}

	public void setPf(float pf) {
		this.pf = pf;
	}

	public float getPfBase() {
		return pfBase;
	}

	public void setPfBase(float pfBase) {
		this.pfBase = pfBase;
	}

	public float getPfTax() {
		return pfTax;
	}

	public void setPfTax(float pfTax) {
		this.pfTax = pfTax;
	}

	public float getPfPct() {
		return pfPct;
	}

	public void setPfPct(float pfPct) {
		this.pfPct = pfPct;
	}

	public float getGcaAmt() {
		return gcaAmt;
	}

	public void setGcaAmt(float gcaAmt) {
		this.gcaAmt = gcaAmt;
	}

	public float getGcaPct() {
		return gcaPct;
	}

	public void setGcaPct(float gcaPct) {
		this.gcaPct = gcaPct;
	}

	public float getDisbAmt() {
		return disbAmt;
	}

	public void setDisbAmt(float disbAmt) {
		this.disbAmt = disbAmt;
	}

	public float getNetDisbAmt() {
		return netDisbAmt;
	}

	public void setNetDisbAmt(float netDisbAmt) {
		this.netDisbAmt = netDisbAmt;
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

	public int getAdvEmis() {
		return advEmis;
	}

	public void setAdvEmis(int advEmis) {
		this.advEmis = advEmis;
	}

	public float getExcessPaid() {
		return excessPaid;
	}

	public void setExcessPaid(float excessPaid) {
		this.excessPaid = excessPaid;
	}

	public float getArrears() {
		return arrears;
	}

	public void setArrears(float arrears) {
		this.arrears = arrears;
	}

	public float getBc() {
		return bc;
	}

	public void setBc(float bc) {
		this.bc = bc;
	}

	public float getOdc() {
		return odc;
	}

	public void setOdc(float odc) {
		this.odc = odc;
	}

	public float getOc() {
		return oc;
	}

	public void setOc(float oc) {
		this.oc = oc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDispo() {
		return statusDispo;
	}

	public void setStatusDispo(String statusDispo) {
		this.statusDispo = statusDispo;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getHypothecation() {
		return hypothecation;
	}

	public void setHypothecation(String hypothecation) {
		this.hypothecation = hypothecation;
	}

	public String getCoLender() {
		return coLender;
	}

	public void setCoLender(String coLender) {
		this.coLender = coLender;
	}

	public float getCoLenderPct() {
		return coLenderPct;
	}

	public void setCoLenderPct(float coLenderPct) {
		this.coLenderPct = coLenderPct;
	}

	public float getExpense() {
		return expense;
	}

	public void setExpense(float expense) {
		this.expense = expense;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getMandate() {
		return mandate;
	}

	public void setMandate(String mandate) {
		this.mandate = mandate;
	}

	public String getNoc() {
		return noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getUmrn() {
		return umrn;
	}

	public void setUmrn(String umrn) {
		this.umrn = umrn;
	}

	public String getUpiUmrn() {
		return upiUmrn;
	}

	public void setUpiUmrn(String upiUmrn) {
		this.upiUmrn = upiUmrn;
	}

	public String getMandateType() {
		return mandateType;
	}

	public void setMandateType(String mandateType) {
		this.mandateType = mandateType;
	}

	public String getMandateArg() {
		return mandateArg;
	}

	public void setMandateArg(String mandateArg) {
		this.mandateArg = mandateArg;
	}

	public Date getDebtScheduleTime() {
		return debtScheduleTime;
	}

	public void setDebtScheduleTime(Date debtScheduleTime) {
		this.debtScheduleTime = debtScheduleTime;
	}

	public boolean isUpiPredebit() {
		return upiPredebit;
	}

	public void setUpiPredebit(boolean upiPredebit) {
		this.upiPredebit = upiPredebit;
	}

	public boolean isUpiDebit() {
		return upiDebit;
	}

	public void setUpiDebit(boolean upiDebit) {
		this.upiDebit = upiDebit;
	}

	public int getSocPqScore() {
		return socPqScore;
	}

	public void setSocPqScore(int socPqScore) {
		this.socPqScore = socPqScore;
	}

	public float getSocPqMinAmt() {
		return socPqMinAmt;
	}

	public void setSocPqMinAmt(float socPqMinAmt) {
		this.socPqMinAmt = socPqMinAmt;
	}

	public float getSocPqMaxAmt() {
		return socPqMaxAmt;
	}

	public void setSocPqMaxAmt(float socPqMaxAmt) {
		this.socPqMaxAmt = socPqMaxAmt;
	}

	public float getSocCap() {
		return socCap;
	}

	public void setSocCap(float socCap) {
		this.socCap = socCap;
	}

	public float getSocCred() {
		return socCred;
	}

	public void setSocCred(float socCred) {
		this.socCred = socCred;
	}

	public float getSocConf() {
		return socConf;
	}

	public void setSocConf(float socConf) {
		this.socConf = socConf;
	}

	public float getSocEmi() {
		return socEmi;
	}

	public void setSocEmi(float socEmi) {
		this.socEmi = socEmi;
	}

	public float getSocIrr() {
		return socIrr;
	}

	public void setSocIrr(float socIrr) {
		this.socIrr = socIrr;
	}

	public int getSocRepayDay() {
		return socRepayDay;
	}

	public void setSocRepayDay(int socRepayDay) {
		this.socRepayDay = socRepayDay;
	}

	public int getSocCibilScore() {
		return socCibilScore;
	}

	public void setSocCibilScore(int socCibilScore) {
		this.socCibilScore = socCibilScore;
	}

	public float getReqLoanAmt() {
		return reqLoanAmt;
	}

	public void setReqLoanAmt(float reqLoanAmt) {
		this.reqLoanAmt = reqLoanAmt;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public boolean isHumanVerified() {
		return humanVerified;
	}

	public void setHumanVerified(boolean humanVerified) {
		this.humanVerified = humanVerified;
	}

	public boolean isTvr() {
		return tvr;
	}

	public void setTvr(boolean tvr) {
		this.tvr = tvr;
	}

	public float getPos() {
		return pos;
	}

	public void setPos(float pos) {
		this.pos = pos;
	}

	public float getPod() {
		return pod;
	}

	public void setPod(float pod) {
		this.pod = pod;
	}

	public float getpPaid() {
		return pPaid;
	}

	public void setpPaid(float pPaid) {
		this.pPaid = pPaid;
	}

	public float getIos() {
		return ios;
	}

	public void setIos(float ios) {
		this.ios = ios;
	}

	public float getIod() {
		return iod;
	}

	public void setIod(float iod) {
		this.iod = iod;
	}

	public float getiPaid() {
		return iPaid;
	}

	public void setiPaid(float iPaid) {
		this.iPaid = iPaid;
	}

	public float getOdcOs() {
		return odcOs;
	}

	public void setOdcOs(float odcOs) {
		this.odcOs = odcOs;
	}

	public float getOdcPaid() {
		return odcPaid;
	}

	public void setOdcPaid(float odcPaid) {
		this.odcPaid = odcPaid;
	}

	public float getBcOs() {
		return bcOs;
	}

	public void setBcOs(float bcOs) {
		this.bcOs = bcOs;
	}

	public float getBcPaid() {
		return bcPaid;
	}

	public void setBcPaid(float bcPaid) {
		this.bcPaid = bcPaid;
	}

	public float getBcPaidBase() {
		return bcPaidBase;
	}

	public void setBcPaidBase(float bcPaidBase) {
		this.bcPaidBase = bcPaidBase;
	}

	public float getBcPaidTax() {
		return bcPaidTax;
	}

	public void setBcPaidTax(float bcPaidTax) {
		this.bcPaidTax = bcPaidTax;
	}

	public float getMoratoriumInt() {
		return moratoriumInt;
	}

	public void setMoratoriumInt(float moratoriumInt) {
		this.moratoriumInt = moratoriumInt;
	}

	public float getBrokenPeriodInt() {
		return brokenPeriodInt;
	}

	public void setBrokenPeriodInt(float brokenPeriodInt) {
		this.brokenPeriodInt = brokenPeriodInt;
	}

	public float getFclCharge() {
		return fclCharge;
	}

	public void setFclCharge(float fclCharge) {
		this.fclCharge = fclCharge;
	}

	public float getFclAmt() {
		return fclAmt;
	}

	public void setFclAmt(float fclAmt) {
		this.fclAmt = fclAmt;
	}

	public int getDpd() {
		return dpd;
	}

	public void setDpd(int dpd) {
		this.dpd = dpd;
	}

	public int getBucket() {
		return bucket;
	}

	public void setBucket(int bucket) {
		this.bucket = bucket;
	}

	public boolean isOtsEnabled() {
		return otsEnabled;
	}

	public void setOtsEnabled(boolean otsEnabled) {
		this.otsEnabled = otsEnabled;
	}

	public int getOtsAmount() {
		return otsAmount;
	}

	public void setOtsAmount(int otsAmount) {
		this.otsAmount = otsAmount;
	}

	public int getPrevMonthBucket() {
		return prevMonthBucket;
	}

	public void setPrevMonthBucket(int prevMonthBucket) {
		this.prevMonthBucket = prevMonthBucket;
	}

	public boolean isDuesMatured() {
		return duesMatured;
	}

	public void setDuesMatured(boolean duesMatured) {
		this.duesMatured = duesMatured;
	}

	public float getFlScore() {
		return flScore;
	}

	public void setFlScore(float flScore) {
		this.flScore = flScore;
	}

	public Date getClosedTime() {
		return closedTime;
	}

	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public int getPayPropScore() {
		return payPropScore;
	}

	public void setPayPropScore(int payPropScore) {
		this.payPropScore = payPropScore;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDisburseTxnId() {
		return disburseTxnId;
	}

	public void setDisburseTxnId(String disburseTxnId) {
		this.disburseTxnId = disburseTxnId;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
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

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getUpiBankName() {
		return upiBankName;
	}

	public void setUpiBankName(String upiBankName) {
		this.upiBankName = upiBankName;
	}

	public int getUpiMandateId() {
		return upiMandateId;
	}

	public void setUpiMandateId(int upiMandateId) {
		this.upiMandateId = upiMandateId;
	}

	public float getUpiMandateAmount() {
		return upiMandateAmount;
	}

	public void setUpiMandateAmount(float upiMandateAmount) {
		this.upiMandateAmount = upiMandateAmount;
	}

	public Date getUpiMandateExpiryDate() {
		return upiMandateExpiryDate;
	}

	public void setUpiMandateExpiryDate(Date upiMandateExpiryDate) {
		this.upiMandateExpiryDate = upiMandateExpiryDate;
	}

	public String getUpiBankAccountNo() {
		return upiBankAccountNo;
	}

	public void setUpiBankAccountNo(String upiBankAccountNo) {
		this.upiBankAccountNo = upiBankAccountNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isChargesWaive() {
		return chargesWaive;
	}

	public void setChargesWaive(boolean chargesWaive) {
		this.chargesWaive = chargesWaive;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Receivable> getReceivable() {
		return receivable;
	}

	public void setReceivable(Set<Receivable> receivable) {
		this.receivable = receivable;
	}

	public Set<LmsLoanStatus> getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(Set<LmsLoanStatus> loanStatus) {
		this.loanStatus = loanStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(advEmis, agmtDate, agreement, arrears, bank, bc, bcOs, bcPaid, bcPaidBase, bcPaidTax, book,
				brokenPeriodInt, bucket, cancelReason, chargesWaive, closedTime, coLender, coLenderPct, createTime,
				createUser, custName, customer, debtScheduleTime, disbAmt, disbTime, disburseTxnId, dpd, duesMatured,
				edi, emi, excessPaid, expense, fclAmt, fclCharge, firstDueDate, flScore, flatRate, gcaAmt, gcaPct,
				humanVerified, hypothecation, iPaid, id, iod, ios, irr, irrDaily, lastDueDate, loanAmt, loanNo,
				loanNoHash, loanStatus, losCustId, losId, mandate, mandateArg, mandateMode, mandateType, modifyTime,
				modifyUser, moratoriumInt, netDisbAmt, noc, oc, odc, odcOs, odcPaid, otsAmount, otsEnabled, pPaid,
				payPropScore, pf, pfBase, pfPct, pfTax, pid, pod, pos, prevMonthBucket, receivable, reqLoanAmt, rrn,
				scheme, socCap, socCibilScore, socConf, socCred, socEmi, socIrr, socPqMaxAmt, socPqMinAmt, socPqScore,
				socRepayDay, status, statusDispo, tenure, tenureDays, tvr, type, umrn, upiBankAccountNo, upiBankName,
				upiDebit, upiMandateAmount, upiMandateExpiryDate, upiMandateId, upiPredebit, upiUmrn,
				upidebitSheduledTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return advEmis == other.advEmis && Objects.equals(agmtDate, other.agmtDate)
				&& Objects.equals(agreement, other.agreement)
				&& Float.floatToIntBits(arrears) == Float.floatToIntBits(other.arrears)
				&& Objects.equals(bank, other.bank) && Float.floatToIntBits(bc) == Float.floatToIntBits(other.bc)
				&& Float.floatToIntBits(bcOs) == Float.floatToIntBits(other.bcOs)
				&& Float.floatToIntBits(bcPaid) == Float.floatToIntBits(other.bcPaid)
				&& Float.floatToIntBits(bcPaidBase) == Float.floatToIntBits(other.bcPaidBase)
				&& Float.floatToIntBits(bcPaidTax) == Float.floatToIntBits(other.bcPaidTax)
				&& Objects.equals(book, other.book)
				&& Float.floatToIntBits(brokenPeriodInt) == Float.floatToIntBits(other.brokenPeriodInt)
				&& bucket == other.bucket && Objects.equals(cancelReason, other.cancelReason)
				&& chargesWaive == other.chargesWaive && Objects.equals(closedTime, other.closedTime)
				&& Objects.equals(coLender, other.coLender)
				&& Float.floatToIntBits(coLenderPct) == Float.floatToIntBits(other.coLenderPct)
				&& Objects.equals(createTime, other.createTime) && Objects.equals(createUser, other.createUser)
				&& Objects.equals(custName, other.custName) && Objects.equals(customer, other.customer)
				&& Objects.equals(debtScheduleTime, other.debtScheduleTime)
				&& Float.floatToIntBits(disbAmt) == Float.floatToIntBits(other.disbAmt)
				&& Objects.equals(disbTime, other.disbTime) && Objects.equals(disburseTxnId, other.disburseTxnId)
				&& dpd == other.dpd && duesMatured == other.duesMatured
				&& Float.floatToIntBits(edi) == Float.floatToIntBits(other.edi)
				&& Float.floatToIntBits(emi) == Float.floatToIntBits(other.emi)
				&& Float.floatToIntBits(excessPaid) == Float.floatToIntBits(other.excessPaid)
				&& Float.floatToIntBits(expense) == Float.floatToIntBits(other.expense)
				&& Float.floatToIntBits(fclAmt) == Float.floatToIntBits(other.fclAmt)
				&& Float.floatToIntBits(fclCharge) == Float.floatToIntBits(other.fclCharge)
				&& Objects.equals(firstDueDate, other.firstDueDate)
				&& Float.floatToIntBits(flScore) == Float.floatToIntBits(other.flScore)
				&& Float.floatToIntBits(flatRate) == Float.floatToIntBits(other.flatRate)
				&& Float.floatToIntBits(gcaAmt) == Float.floatToIntBits(other.gcaAmt)
				&& Float.floatToIntBits(gcaPct) == Float.floatToIntBits(other.gcaPct)
				&& humanVerified == other.humanVerified && Objects.equals(hypothecation, other.hypothecation)
				&& Float.floatToIntBits(iPaid) == Float.floatToIntBits(other.iPaid) && id == other.id
				&& Float.floatToIntBits(iod) == Float.floatToIntBits(other.iod)
				&& Float.floatToIntBits(ios) == Float.floatToIntBits(other.ios)
				&& Float.floatToIntBits(irr) == Float.floatToIntBits(other.irr)
				&& Float.floatToIntBits(irrDaily) == Float.floatToIntBits(other.irrDaily)
				&& Objects.equals(lastDueDate, other.lastDueDate)
				&& Float.floatToIntBits(loanAmt) == Float.floatToIntBits(other.loanAmt)
				&& Objects.equals(loanNo, other.loanNo) && Objects.equals(loanNoHash, other.loanNoHash)
				&& Objects.equals(loanStatus, other.loanStatus) && losCustId == other.losCustId && losId == other.losId
				&& Objects.equals(mandate, other.mandate) && Objects.equals(mandateArg, other.mandateArg)
				&& Objects.equals(mandateMode, other.mandateMode) && Objects.equals(mandateType, other.mandateType)
				&& Objects.equals(modifyTime, other.modifyTime) && Objects.equals(modifyUser, other.modifyUser)
				&& Float.floatToIntBits(moratoriumInt) == Float.floatToIntBits(other.moratoriumInt)
				&& Float.floatToIntBits(netDisbAmt) == Float.floatToIntBits(other.netDisbAmt)
				&& Objects.equals(noc, other.noc) && Float.floatToIntBits(oc) == Float.floatToIntBits(other.oc)
				&& Float.floatToIntBits(odc) == Float.floatToIntBits(other.odc)
				&& Float.floatToIntBits(odcOs) == Float.floatToIntBits(other.odcOs)
				&& Float.floatToIntBits(odcPaid) == Float.floatToIntBits(other.odcPaid) && otsAmount == other.otsAmount
				&& otsEnabled == other.otsEnabled && Float.floatToIntBits(pPaid) == Float.floatToIntBits(other.pPaid)
				&& payPropScore == other.payPropScore && Float.floatToIntBits(pf) == Float.floatToIntBits(other.pf)
				&& Float.floatToIntBits(pfBase) == Float.floatToIntBits(other.pfBase)
				&& Float.floatToIntBits(pfPct) == Float.floatToIntBits(other.pfPct)
				&& Float.floatToIntBits(pfTax) == Float.floatToIntBits(other.pfTax) && pid == other.pid
				&& Float.floatToIntBits(pod) == Float.floatToIntBits(other.pod)
				&& Float.floatToIntBits(pos) == Float.floatToIntBits(other.pos)
				&& prevMonthBucket == other.prevMonthBucket && Objects.equals(receivable, other.receivable)
				&& Float.floatToIntBits(reqLoanAmt) == Float.floatToIntBits(other.reqLoanAmt)
				&& Objects.equals(rrn, other.rrn) && Objects.equals(scheme, other.scheme)
				&& Float.floatToIntBits(socCap) == Float.floatToIntBits(other.socCap)
				&& socCibilScore == other.socCibilScore
				&& Float.floatToIntBits(socConf) == Float.floatToIntBits(other.socConf)
				&& Float.floatToIntBits(socCred) == Float.floatToIntBits(other.socCred)
				&& Float.floatToIntBits(socEmi) == Float.floatToIntBits(other.socEmi)
				&& Float.floatToIntBits(socIrr) == Float.floatToIntBits(other.socIrr)
				&& Float.floatToIntBits(socPqMaxAmt) == Float.floatToIntBits(other.socPqMaxAmt)
				&& Float.floatToIntBits(socPqMinAmt) == Float.floatToIntBits(other.socPqMinAmt)
				&& socPqScore == other.socPqScore && socRepayDay == other.socRepayDay
				&& Objects.equals(status, other.status) && Objects.equals(statusDispo, other.statusDispo)
				&& Float.floatToIntBits(tenure) == Float.floatToIntBits(other.tenure) && tenureDays == other.tenureDays
				&& tvr == other.tvr && Objects.equals(type, other.type) && Objects.equals(umrn, other.umrn)
				&& Objects.equals(upiBankAccountNo, other.upiBankAccountNo)
				&& Objects.equals(upiBankName, other.upiBankName) && upiDebit == other.upiDebit
				&& Float.floatToIntBits(upiMandateAmount) == Float.floatToIntBits(other.upiMandateAmount)
				&& Objects.equals(upiMandateExpiryDate, other.upiMandateExpiryDate)
				&& upiMandateId == other.upiMandateId && upiPredebit == other.upiPredebit
				&& Objects.equals(upiUmrn, other.upiUmrn) && upidebitSheduledTime == other.upidebitSheduledTime;
	}

	@Override
	public String toString() {
		return String.format(
				"Loan [id=%s, losId=%s, losCustId=%s, pid=%s, loanNo=%s, loanNoHash=%s, custName=%s, type=%s, agmtDate=%s, disbTime=%s, firstDueDate=%s, lastDueDate=%s, loanAmt=%s, tenure=%s, tenureDays=%s, irr=%s, irrDaily=%s, flatRate=%s, pf=%s, pfBase=%s, pfTax=%s, pfPct=%s, gcaAmt=%s, gcaPct=%s, disbAmt=%s, netDisbAmt=%s, emi=%s, edi=%s, advEmis=%s, excessPaid=%s, arrears=%s, bc=%s, odc=%s, oc=%s, status=%s, statusDispo=%s, scheme=%s, book=%s, hypothecation=%s, coLender=%s, coLenderPct=%s, expense=%s, agreement=%s, mandate=%s, noc=%s, umrn=%s, upiUmrn=%s, upiBankName=%s, mandateType=%s, mandateArg=%s, debtScheduleTime=%s, upiPredebit=%s, upiDebit=%s, socPqScore=%s, socPqMinAmt=%s, socPqMaxAmt=%s, socCap=%s, socCred=%s, socConf=%s, socEmi=%s, socIrr=%s, socRepayDay=%s, socCibilScore=%s, reqLoanAmt=%s, bank=%s, humanVerified=%s, tvr=%s, pos=%s, pod=%s, pPaid=%s, ios=%s, iod=%s, iPaid=%s, odcOs=%s, odcPaid=%s, bcOs=%s, bcPaid=%s, bcPaidBase=%s, bcPaidTax=%s, moratoriumInt=%s, brokenPeriodInt=%s, fclCharge=%s, fclAmt=%s, dpd=%s, bucket=%s, otsEnabled=%s, otsAmount=%s, prevMonthBucket=%s, duesMatured=%s, flScore=%s, closedTime=%s, cancelReason=%s, payPropScore=%s, createUser=%s, disburseTxnId=%s, rrn=%s, mandateMode=%s, upidebitSheduledTime=%s, upiMandateId=%s, chargesWaive=%s, upiMandateAmount=%s, upiMandateExpiryDate=%s, upiBankAccountNo=%s, createTime=%s, modifyUser=%s, modifyTime=%s, customer=%s, receivable=%s, loanStatus=%s, getClass()=%s, toString()=%s]",
				id, losId, losCustId, pid, loanNo, loanNoHash, custName, type, agmtDate, disbTime, firstDueDate,
				lastDueDate, loanAmt, tenure, tenureDays, irr, irrDaily, flatRate, pf, pfBase, pfTax, pfPct, gcaAmt,
				gcaPct, disbAmt, netDisbAmt, emi, edi, advEmis, excessPaid, arrears, bc, odc, oc, status, statusDispo,
				scheme, book, hypothecation, coLender, coLenderPct, expense, agreement, mandate, noc, umrn, upiUmrn,
				upiBankName, mandateType, mandateArg, debtScheduleTime, upiPredebit, upiDebit, socPqScore, socPqMinAmt,
				socPqMaxAmt, socCap, socCred, socConf, socEmi, socIrr, socRepayDay, socCibilScore, reqLoanAmt, bank,
				humanVerified, tvr, pos, pod, pPaid, ios, iod, iPaid, odcOs, odcPaid, bcOs, bcPaid, bcPaidBase,
				bcPaidTax, moratoriumInt, brokenPeriodInt, fclCharge, fclAmt, dpd, bucket, otsEnabled, otsAmount,
				prevMonthBucket, duesMatured, flScore, closedTime, cancelReason, payPropScore, createUser,
				disburseTxnId, rrn, mandateMode, upidebitSheduledTime, upiMandateId, chargesWaive, upiMandateAmount,
				upiMandateExpiryDate, upiBankAccountNo, createTime, modifyUser, modifyTime, customer, receivable,
				loanStatus, getClass(), super.toString());
	}

}
