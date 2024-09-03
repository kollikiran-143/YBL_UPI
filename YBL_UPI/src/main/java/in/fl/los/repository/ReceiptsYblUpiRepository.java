package in.fl.los.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.fl.los.model.ReceiptsYblUpi;

/**
 * config_details table repository interface
 *
 * @author Rajesh
 * @version 1
 */
@Repository
public interface ReceiptsYblUpiRepository extends JpaRepository<ReceiptsYblUpi, Integer> {

	public ReceiptsYblUpi findByCpMdtRefNoAndExecTrxnNo(String refNo, String txnNo);

	// public List<ReceiptsYblUpi>
	// findByPreDebitStatusAndPreDebitTimeBeforeAndMndtExecStatusIsNull(String
	// string,LocalDateTime oneDayB4);

	// @Query(value = "select * from receipts_ybl_upi where
	// cp_mdt_ref_no=:cpMdtRefNo and (status='PREDEBIT_SUCCESS' or
	// status='DEBIT_SUCCESS' or status like '%ALREADY%') and date(predebit_date)
	// =:preDebitTime", nativeQuery = true)
	// public List<ReceiptsYblUpi> getPredebitSuccessResult(String cpMdtRefNo,
	// LocalDate preDebitTime);

	@Query(value = "select * from receipts_ybl_upi where receivable_id = :receivableId and cp_mdt_ref_no=:cpMdtRefNo and status='PREDEBIT_SUCCESS'", nativeQuery = true)
	public List<ReceiptsYblUpi> getPredebitSuccessResultSet(String cpMdtRefNo, int receivableId);

	@Query(value = "select * from receipts_ybl_upi where loan_no in (select loan_no from lms_loan where upidebit_sheduled_time <=:debitTime and type = 'FLMBL' and status = 'ACTIVE') and status='PREDEBIT_SUCCESS' and receipt_mode in ('NEW', 'REPEAT') and pre_debit_time < (now() - INTERVAL 1 DAY) order by predebit_date asc", nativeQuery = true)
	public List<ReceiptsYblUpi> getSuccessfulPredebitsAll(int debitTime);

	@Query(value = "select * from receipts_ybl_upi where status='DEBIT_FAILURE' and receipt_mode in ('NEW', 'REPEAT') and mndt_exec_time > (NOW() - INTERVAL 1 DAY)", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitFailureCases();

	@Query(value = "select * from receipts_ybl_upi where status='DEBIT_INIT_SUCCESS' and date(mndt_exec_time) > (NOW() - INTERVAL 1 DAY)", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitInitCases();

	@Query(value = "select * from receipts_ybl_upi where loan_no in (select loan_no from lms_loan where type = 'FLMBL' and status = 'ACTIVE') and (status='DEBIT_FAILURE' or mndt_exec_status='TIMEDOUT') and mndt_exec_time > (NOW() - INTERVAL 10 DAY);", nativeQuery = true)
	public List<ReceiptsYblUpi> getAllDebitFailureCases();

	@Query(value = "select * from receipts_ybl_upi where loan_no in (select loan_no from lms_loan where type = 'FLMBL' and status = 'ACTIVE') and status = 'DEBIT_FAILURE' and (bank_error = 'MANDATE REQUEST LIMIT HAS BREACHED' or debit_try_count >=3) and mndt_exec_time > (NOW() - INTERVAL 10 DAY);", nativeQuery = true)
	public List<ReceiptsYblUpi> getAllDebitFailureAndBankErrorCases();

	@Query(value = "select * from receipts_ybl_upi where loan_no in (select loan_no from lms_loan where type = 'FLMBL' and status = 'ACTIVE') and status in ('DEBIT_FAILURE') and receipt_mode in ('NEW', 'REPEAT') and mndt_exec_time > (NOW() - INTERVAL 1 DAY);", nativeQuery = true)
	public List<ReceiptsYblUpi> getTodaysDebitFailureCases();

	@Query(value = "select * from receipts_ybl_upi where status='PREDEBIT_SUCCESS' and receipt_mode in ('NEW', 'REPEAT') and pre_debit_time > (now() - INTERVAL 1 DAY) order by predebit_date asc", nativeQuery = true)
	public List<ReceiptsYblUpi> getTodaysRepeatPredebitSuccess();

	@Query(value = "select * from receipts_ybl_upi where receivable_id = :receivableId and cp_mdt_ref_no=:cpMdtRefNo and status='DEBIT_SUCCESS'", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitSuccessResultSetByReceivableID(String cpMdtRefNo, int receivableId);

	@Query(value = "select count(*) from (select count(*) as cnt from receipts_ybl_upi where loan_no = :loanNo and debit_date < now() and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS') group by debit_date)tmp", nativeQuery = true)
	public int getOverdueDebitCount(@Param("loanNo") String loanNo);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date < now() and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS') and receipt_mode in ('NEW', 'REPEAT') order by debit_date asc", nativeQuery = true)
	public List<ReceiptsYblUpi> getOverdueDebits(@Param("loanNo") String loanNo);

	@Query(value = "select count(*) from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS')", nativeQuery = true)
	public int getOverdueDebitsCountOnSameDay(String loanNo, Date debitDate);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS')", nativeQuery = true)
	public List<ReceiptsYblUpi> getOverdueDebitsOnSameDay(String loanNo, Date debitDate);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status='PREDEBIT_SUCCESS' and receipt_mode = 'ETP'", nativeQuery = true)
	public List<ReceiptsYblUpi> getSuccessPredebits(String loanNo, LocalDate debitDate);

	// @Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and
	// debit_date =:debitDate and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE',
	// 'DEBIT_INIT_SUCCESS') and receipt_mode = 'ETP' order by debit_try_count limit
	// 1", nativeQuery = true)
	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS') and receipt_mode = 'ETP' and TIMESTAMPDIFF(HOUR, pre_debit_time, now()) >= 24 order by debit_try_count limit 1", nativeQuery = true)
	public ReceiptsYblUpi getPredebitReceipt(String loanNo, LocalDate debitDate);

	@Query(value = "select * from receipts_ybl_upi where status in ('DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS')  and mndt_exec_time >= date(NOW())", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitUnknownCases();

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('DEBIT_SUCCESS', 'DEBIT_INIT_SUCCESS') and receipt_mode = 'ETP'", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitSuccessReceipts(String loanNo, LocalDate debitDate);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status='PREDEBIT_SUCCESS' and receipt_mode = 'ETP' and receipt_type =:receiptType", nativeQuery = true)
	public List<ReceiptsYblUpi> getSuccessPredebitsByRcptType(String loanNo, LocalDate debitDate, String receiptType);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('DEBIT_SUCCESS', 'DEBIT_INIT_SUCCESS') and receipt_mode = 'ETP' and receipt_type =:receiptType", nativeQuery = true)
	public List<ReceiptsYblUpi> getDebitSuccessReceiptsByRcptType(String loanNo, LocalDate debitDate,
			String receiptType);

	@Query(value = "select * from receipts_ybl_upi where loan_no = :loanNo and debit_date =:debitDate and status in ('PREDEBIT_SUCCESS', 'DEBIT_FAILURE', 'DEBIT_INIT_SUCCESS') and receipt_mode = 'ETP' and receipt_type =:receiptType and TIMESTAMPDIFF(HOUR, pre_debit_time, now()) >= 24 order by debit_try_count limit 1", nativeQuery = true)
	public ReceiptsYblUpi getPredebitReceiptByRcptType(String loanNo, LocalDate debitDate, String receiptType);

	@Query(value = "select * from receipts_ybl_upi where exec_trxn_no = :trxnNo order by id desc limit 1", nativeQuery = true)
	public ReceiptsYblUpi findByExecTrxnNo(String trxnNo);

}