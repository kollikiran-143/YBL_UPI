package in.fl.los.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.fl.los.model.MandateApiAuditYblUpi;

@Repository
public interface APIMandateYblUpiRepository extends JpaRepository<MandateApiAuditYblUpi, Integer> {

	@Query(value = "select * from mandate_audit_upi_ybl where cust_id =:custId and loan_id =:loanId order by id desc", nativeQuery = true)
	public List<MandateApiAuditYblUpi> findBycustIdAndLoanIdOrderByIdDesc(int custId, int loanId);

	public MandateApiAuditYblUpi findByTrxnNo(String trxnNo);

	public List<MandateApiAuditYblUpi> findBycustIdAndLoanIdAndStatusOrderByIdDesc(int custId, int custId2,
			String string);

	@Query(value = "select * from mandate_audit_upi_ybl where status = 'ACTIVE' and umrn=:umrn and cust_id =:custId limit 1", nativeQuery = true)
	public MandateApiAuditYblUpi getUpiMandateDetails(int custId, String umrn);

	@Query(value = "select * from mandate_audit_upi_ybl where status = 'PENDING'", nativeQuery = true)
	public List<MandateApiAuditYblUpi> getPendingMandateDetails();

	@Query(value = "select * from mandate_audit_upi_ybl where rrn_no = :rrnNo limit 1", nativeQuery = true)
	public MandateApiAuditYblUpi findByRrnNo(String rrnNo);
}
