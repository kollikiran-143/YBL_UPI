package in.fl.los.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.fl.los.model.UlLoans;

@Repository
public interface LosLoanRepository extends JpaRepository<UlLoans, Integer> {

	@Query(value = "select * from ul_loans where loan_status = 'APPLIED' and cust_id = :custId", nativeQuery = true)
	public UlLoans getAppliedLoans(int custId);

	@Query(value = "select * from ul_loans where cust_id = :custId", nativeQuery = true)
	public Set<UlLoans> getAllLoan(int custId);

	@Query(value = "select * from ul_loans where cust_id = :custId and loan_status in ('APPLIED','ACTIVE','CLLSED', 'FCL_CLOSED', 'FCL_TOPUP')", nativeQuery = true)
	public Set<UlLoans> getAllValidLoan(int custId);

	@Query(value = "select * from ul_loans where cust_id = :custId and loan_status in ('APPLIED','ACTIVE')", nativeQuery = true)
	public Optional<UlLoans> getAppliedAndActiveLoans(int custId);

	public UlLoans findByLoanId(int loanId);

}
