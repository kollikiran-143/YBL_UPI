package in.fl.los.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.fl.los.model.Loan;

@Repository
public interface LmsLoanRepository extends JpaRepository<Loan, Integer> {

	public Loan findBylosId(int losId);

	public Loan findByLoanNo(String loanNo);

}