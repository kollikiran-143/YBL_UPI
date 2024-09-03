package in.fl.los.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.fl.los.model.Customer;
import in.fl.los.model.Loan;

/**
 * JPA repository class for lms_loan table Consists of queries to access the
 * table
 * 
 * @author Ashwin Kumar V
 *
 */
@Repository("LoanRepository")
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	public List<Loan> findByCustomer(Customer customer);

//	public Loan findByCustIdAndStatus(int custId, String status);

	public Loan findBylosCustIdAndStatus(int custId, String status);

	public List<Loan> findBylosCustId(int losCustId);

	public List<Loan> findByLosCustIdOrderByIdDesc(int losCustId);

	public Loan findByloanNo(String loanNo);

	public Loan findBylosId(int losId);

	public Loan findBylosIdAndStatusIn(int losId, List<String> status);

	public Loan findFirstBylosIdAndStatusInOrderByIdDesc(int losId, List<String> status);

	public List<Loan> findBystatusAndNocIsNull(String status);

	public List<Loan> findBystatus(String status);

	public List<Loan> findByLoanNoHash(String loanNoHash);

	@Query(value = "select loan_no from lms_loan where (loan_no_hash is null or loan_no_hash='') and cust_id>0", nativeQuery = true)
	public List<String> findAllLoanNo();

	@Transactional
	@Modifying
	@Query(value = "update lms_loan ll set pos = (select coalesce(sum(principal - prin_paid), 0) from lms_receivable where loan_no = ll.loan_no), pod = (select coalesce(sum(principal - prin_paid), 0) from lms_receivable where loan_no = ll.loan_no and due_date < now()), p_paid = (select coalesce(sum(prin_paid), 0) from lms_receivable where loan_no = ll.loan_no), ios = (select coalesce(sum(interest - int_paid), 0) from lms_receivable where loan_no = ll.loan_no), iod = (select coalesce(sum(interest - int_paid), 0) from lms_receivable where loan_no = ll.loan_no and due_date < now()), i_paid = (select coalesce(sum(int_paid), 0) from lms_receivable where loan_no = ll.loan_no), bucket = (select coalesce(count(*), 0) from lms_receivable where loan_no = ll.loan_no and due_date<now() and status <> 'paid'), dues_matured = (select coalesce(count(*), 0) from lms_receivable where loan_no = ll.loan_no and due_date<now()) where loan_no=:loanNo", nativeQuery = true)
	public void updateLoanStats(@Param("loanNo") String loanNo);

	@Transactional
	@Modifying
	@Query(value = "update lms_loan set prev_month_bucket=bucket where status='ACTIVE'", nativeQuery = true)
	public void updatePrevMonthBucket();

	public List<Loan> findBystatusAndUpiUmrnIsNotNull(String status);

	public List<Loan> findBytypeAndStatus(String type, String status);

	@Query(value = "select * from lms_loan where cust_id =:lmsId", nativeQuery = true)
	public List<Loan> findByLmsIdOrderById(int lmsId);

	@Query(value = "select count(*) from lms_loan where type = 'FLMBL' and status = 'ACTIVE' and collection_score > 0", nativeQuery = true)
	public int totalTopUpEligibleLoans();

	@Query(value = "select min(id) from lms_loan where type = 'FLMBL' and status = 'ACTIVE'", nativeQuery = true)
	public int getMinRecordId();

	@Query(value = "select max(id) from lms_loan where type = 'FLMBL' and status = 'ACTIVE'", nativeQuery = true)
	public int getMaxRecordId();

	@Query(value = "select * from lms_loan where id >= :startIndex and id <= :endIndex and type = 'FLMBL' and status = 'ACTIVE'", nativeQuery = true)
	List<Loan> getLoanList(int startIndex, int endIndex);

	@Query(value = "select * from lms_loan where id >= :startIndex and id <= :endIndex and type = 'FLMBL' and status = 'ACTIVE' and dpd >= :dpd", nativeQuery = true)
	List<Loan> getDelinquentLoanList(int startIndex, int endIndex, int dpd);

}
