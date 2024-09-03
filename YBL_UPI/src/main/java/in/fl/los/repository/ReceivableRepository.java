package in.fl.los.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.fl.los.model.Receivable;

/**
 * JPA repository class for lms_receivable table Consists of queries to access
 * the table
 * 
 * @author Ashwin Kumar V
 *
 */
@Repository("ReceivableRepository")
public interface ReceivableRepository extends JpaRepository<Receivable, Integer> {

	public Receivable findById(int id);

	public List<Receivable> findByLoanNo(String loanNo);

	@Query(value = "select coalesce(sum(emi - prin_paid -int_paid), 0) from lms_receivable where loan_no = :loanNo and due_date < now()", nativeQuery = true)
	public float getLoanOverdueAmount(@Param("loanNo") String loanNo);

	@Query(value = "select coalesce(count(*), 0) from lms_receivable where loan_no = :loanNo and due_date < now() and status not in ('PAID', 'NOPAY')", nativeQuery = true)
	public int getOverdueEMICount(@Param("loanNo") String loanNo);

	@Query(value = "select * from lms_receivable where loan_no in (select loan_no from lms_loan where type = 'FLMBL' and status = 'ACTIVE') and date(due_date) =:dueDate and status = 'FUTURE'", nativeQuery = true)
	public List<Receivable> getUpliftTmwReceivables(LocalDate dueDate);

	// @Query(value = "select * from lms_receivable where loan_no =:loanNo and
	// date(due_date) <=:dueDate and status in ('FUTURE', 'PART_PAID')", nativeQuery
	// = true)
	// public List<Receivable> getLoanDues(String loanNo, LocalDate dueDate);

	// 12-08-2024
	// @Query(value = "select * from lms_receivable where loan_no =:loanNo and
	// date(due_date) <=:dueDate and status in ('FUTURE', 'PART_PAID') order by
	// due_no", nativeQuery = true)
	// public List<Receivable> getLoanDues(String loanNo, LocalDate dueDate);

	@Query(value = "select * from lms_receivable where loan_no =:loanNo and date(predebit_date) <=:dueDate and status in ('FUTURE', 'PART_PAID') order by due_no", nativeQuery = true)
	public List<Receivable> getLoanDues(String loanNo, LocalDate dueDate);

	public Receivable findByIdAndLoanNo(int id, String loanNo);

	@Query(value = "select loan_no from (select * from (select l.loan_no, count(*) as due_cnt from lms_receivable r, lms_loan l where l.loan_no=r.loan_no and l.type='FLMBL' and l.status='ACTIVE' and l.is_top_up_qual=1 and r.due_date<date(now()) and r.status != 'NOPAY' group by r.loan_no) r where due_cnt > 60 ) t where (due_cnt%15)=1", nativeQuery = true)
	public List<String> getTopUpEligibleLoans();

	@Query(value = "select count(*) from lms_receivable where loan_no = :loanNo and status not in ('PAID', 'NOPAY') and due_date <= NOW()", nativeQuery = true)
	public int getOverdueEDICount(String loanNo);

	// FLMBL
	@Query(value = "select COALESCE(SUM(principal + interest - prin_paid - int_paid), 0) as total_due from lms_receivable where loan_no=:loanNo and due_date <= NOW()", nativeQuery = true)
	public float getDueAmt(String loanNo);

	@Query(value = "select count(*) from lms_receivable where loan_no = :loanNo and status in ('PART_PAID', 'FUTURE') and due_date > NOW()", nativeQuery = true)
	public int getFutureEDICount(String loanNo);

}