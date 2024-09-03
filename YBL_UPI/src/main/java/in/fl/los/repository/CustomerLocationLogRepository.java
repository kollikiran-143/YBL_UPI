package in.fl.los.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.fl.los.model.UlCustomerLocationLog;

/**
 * Customer Location Log table repository interface
 *
 * @author Vincy 09-June-2023
 * @version 1
 */
public interface CustomerLocationLogRepository extends JpaRepository<UlCustomerLocationLog, Integer> {

	@Query(value = "select * from ul_customer_location_log where cust_id = :custId and event_type in ('NAMEBOARD','INTERIOR','FRONT','CUSTOMER')  and latitude<>'0.00000000' order by cust_id desc limit 1", nativeQuery = true)
	public UlCustomerLocationLog getCustomerLocation(int custId);

}
