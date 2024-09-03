package in.fl.los.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.fl.los.model.Charges;

/**
 * JPA repository class for lms_charges table Consists of queries to access the
 * table
 * 
 * @author Ashwin Kumar V
 *
 */
@Repository("ChargesRepository")
public interface ChargesRepository extends JpaRepository<Charges, Integer> {

	public Charges findById(int id);

	@Query
	public List<Charges> findByloanNo(String loanNo);

	@Query(value = "select COALESCE (sum(charge_amount + tax_amount - charge_collected - tax_collected),0.00) as fvc from lms_charges where loan_no=:loanNo and ChargeID='FVC' and status not in ('WAIVED')", nativeQuery = true)
	public float getFVCAmt(String loanNo);

	@Query(value = "select COALESCE (sum(charge_amount + tax_amount - charge_collected - tax_collected),0.00) as fvc from lms_charges where loan_no=:loanNo and ChargeID='BC' and status not in ('WAIVED')", nativeQuery = true)
	public float getBCAmt(String loanNo);

	@Query(value = "select COALESCE (sum(charge_amount + tax_amount - charge_collected - tax_collected),0.00) as fvc from lms_charges where loan_no=:loanNo and ChargeID=:chargeId and status not in ('WAIVED')", nativeQuery = true)
	public float getTotalChargesAmtByType(String loanNo, String chargeId);

	@Query(value = "select distinct(ChargeID) from lms_charges where loan_no=:loanNo", nativeQuery = true)
	public List<String> getChargesList(String loanNo);

	@Query(value = "select * from lms_charges where loan_no=:loanNo and ChargeID=:chargeId and status in ('PART_PAID', 'FUTURE') order by id", nativeQuery = true)
	public List<Charges> getUnpaidChargesListByType(String loanNo, String chargeId);

}