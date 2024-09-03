package in.fl.los.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.fl.los.model.LmsOdcDaily;

@Repository
public interface LmsOdcDailyRepository extends JpaRepository<LmsOdcDaily, Integer> {

	public List<LmsOdcDaily> findByloanNo(String loanNo);

	public List<LmsOdcDaily> findByloanNoAndOdcGreaterThan(String loanNo, float minOdc);

	@Query(value = "select COALESCE (sum(odc),0.00) as odc from lms_odc_daily where loan_no=:loanNo", nativeQuery = true)
	public float getTotalOdcAmt(String loanNo);

}