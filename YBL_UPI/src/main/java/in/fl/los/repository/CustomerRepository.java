package in.fl.los.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.fl.los.model.UlCustomerDetails;

/**
 * customer_details table repository interface
 *
 * @author Rajesh
 * @version 1
 */
@Repository
public interface CustomerRepository extends JpaRepository<UlCustomerDetails, Integer> {

	public List<UlCustomerDetails> findByPhoneNo(String phoneNo);
	
	public List<UlCustomerDetails> findByUserPan(String userPan);
	
	public UlCustomerDetails findByPidAndIsActiveTrue(int pid);
	
	public UlCustomerDetails findByPhoneNoAndPidAndIsActiveTrue(String phoneNo, int pid);
	
	public UlCustomerDetails findFirstByPhoneNoAndUserPanAndPidAndIsActiveTrue(String phoneNo, String userPan,  int pid);
	
	public UlCustomerDetails findByUserPanAndIsActiveTrue(String userPan);
	
	//public List<UlCustomerDetails> findByUserPanAndCustIdNot(String panNo, int custId);
	
	public List<UlCustomerDetails> findByPhoneNoAndCustIdNot(String phoneNo, int custId);
	
	public UlCustomerDetails findByCustIdAndAgentCode(int  custId, String agentCode);
	
	public UlCustomerDetails findByCustIdAndAgentCodeAndIsActiveTrue(int  custId, String agentCode);

	
	//Duplicate New
	
	public List<UlCustomerDetails> findByUserPanAndCustIdNotAndIsActiveTrue(String panNo, int custId);
	
	public List<UlCustomerDetails> findByPhoneNoAndCustIdNotAndIsActiveTrue(String phoneNo, int custId);
	
	public List<UlCustomerDetails> findByPidAndCustIdNot(int pid, int custId);
	
	public List<UlCustomerDetails> findByPidAndCustIdNotAndIsActiveTrue(int pid, int custId);
	
	@Query(value = "select * from ul_customer_details where  phoneno=:phoneNo and pid is not null order by create_time asc LIMIT 1", nativeQuery = true)
	public UlCustomerDetails findByPhoneNoFirstRecord(String phoneNo);

	@Query(value = "select * from ul_customer_details where  phoneno=:phoneNo and is_active = 1 and pid is not null order by create_time asc LIMIT 1", nativeQuery = true)
	public UlCustomerDetails findByActivePhoneNoFirstRecord(String phoneNo);
	
	public List<UlCustomerDetails> findByPhoneNoAndUserPanNot(String phoneNo, String userPan);

	public List<UlCustomerDetails> findByUserPanAndPhoneNoAndDuplicateOf(String panNo, String PhoneNumber,int duplicatOf);

	@Query(value = "select count(*) from lms_loan where status = 'ACTIVE' and los_cust_id = ?1", nativeQuery = true)
	public int activeLoansCount(int custId);

	public List<UlCustomerDetails> findByAgentCodeAndIsActiveTrue(String agentCode);

	public List<UlCustomerDetails> findByAgentCode(String agentCode);
	
	// Customer List normal Queue
	
	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1 and lead_completed = 0 and lead_active_status='ACTIVE' and lead_status not in ('COLD') order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> findAllOrderByCreateTimeDesc();

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and agent_code = :agentCode and is_active = 1 and lead_completed = 0 and lead_active_status='ACTIVE' and lead_status not in ('COLD') order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> findByAgentCodeOrderByCreateTimeDescending(String agentCode);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1  and lead_completed = 0 and lead_active_status='ACTIVE' and lead_status not in ('COLD') and agent_id in (select id from ul_agent_master where team_id =:teamId ) order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> getAllLeadsByAgency(int teamId);

	// Customer List Search Queue
	
	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1 and lead_active_status='ACTIVE' and lead_status not in ('COLD') and  (cust_id like %:search%  or phoneno like %:search% )  order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> findAllOrderByCreateTimeDescSearch(String search);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and agent_code = :agentCode and is_active = 1 and lead_active_status='ACTIVE' and lead_status not in ('COLD') and (cust_id like %:search%  or phoneno like %:search% ) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> findByAgentCodeOrderByCreateTimeDescendingSearch(String agentCode, String search);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1  and lead_active_status='ACTIVE' and lead_status not in ('COLD') and agent_id in (select id from ul_agent_master where team_id =:teamId ) and (cust_id like %:search%  or phoneno like %:search% ) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getAllLeadsByAgencySearch(int teamId, String search);

	public UlCustomerDetails findByCoapplicantOf(int coapplicantOf);

	public UlCustomerDetails findByCustId(int custId);
	
	//Dashboard

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and date(soc_prequalify_time)=date(now()) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and date(soc_prequalify_time)=date(now()) and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and date(soc_prequalify_time)=date(now()) and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayLeadWithStatus(List<String> agentCode, String leadStatus);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyLeadWithStatus(List<String> agentCode, String leadStatus);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallLeadWithStatus(List<String> agentCode, String leadStatus);
	
	//DashBorad total open applications
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and lead_status not in('PQUAL_FAIL','MOS_DONE','ACTIVE','REJECTED','COLD') and lead_active_status in ('ACTIVE') and hibernate_till is null", nativeQuery = true)
	public int getAgentOpenApplicantionCount(String agentCode);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and cibil_score >:cibilScore and soc_prequalify_status in ('APPROVED','GRAY') and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysValidLeads(String agentCode, int cibilScore);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysLeads(String agentCode);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and soc_prequalify_status= :status and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysLeadByPreQual(String agentCode, String status);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and cibil_score >:cibilScore and date(create_time) = DATE(NOW() - INTERVAL 1 DAY)", nativeQuery = true)
	public int getAgentYesterdaysValidLeads(String agentCode, int cibilScore);
	
	//FI List
	@Query(value = "select * from ul_customer_details where ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFIList();
	
	@Query(value = "select * from ul_customer_details where ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFIListSearchKey(String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent = :agentCode or office_fi_agent = :agentCode) and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgentCodeAndSearchKey(String agentCode, String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent in (select username from ul_agent_master where team_id =:teamId ) or office_fi_agent in (select username from ul_agent_master where team_id =:teamId ))  and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgencyAndSearchKey(int teamId, String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent in (select username from ul_agent_master where team_id =:teamId ) or office_fi_agent in (select username from ul_agent_master where team_id =:teamId ))  and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgency(int teamId);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent = :agentCode or office_fi_agent = :agentCode) and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgentCode(String agentCode);
	
	//Map
	@Query(value="select count(*) from ul_customer_state_status where  cust_id in (select cust_id from ul_customer_details where applicant_type = 'APP' and date(create_time)>=date(now()) and agent_code =:agentCode) and esign_status=1", nativeQuery = true)
	public int getCompletedLoanByAgent(String agentCode);

	@Query(value = "select * from ul_customer_details where  user_pan=:panNumber and cust_id !=:customerId", nativeQuery = true)
	public List<UlCustomerDetails> findByUserPanNotInCustId(String panNumber, String customerId);

	
	/*

	// Customer List normal Queue
	
	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1 and lead_completed = 0 and lead_active_status='ACTIVE' order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> findAllOrderByCreateTimeDesc();

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and agent_code = :agentCode and is_active = 1 and lead_completed = 0 and lead_active_status='ACTIVE' order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> findByAgentCodeOrderByCreateTimeDescending(String agentCode);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1  and lead_completed = 0 and lead_active_status='ACTIVE' and agent_code in (select username from ul_agent_login where agency =:agency ) order by create_time desc LIMIT 10", nativeQuery = true)
	public List<UlCustomerDetails> getAllLeadsByAgency(String agency);

	// Customer List Search Queue
	
	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1 and lead_active_status='ACTIVE' and  (cust_id like %:search%  or phoneno like %:search% )  order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> findAllOrderByCreateTimeDescSearch(String search);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and agent_code = :agentCode and is_active = 1 and lead_active_status='ACTIVE' and (cust_id like %:search%  or phoneno like %:search% ) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> findByAgentCodeOrderByCreateTimeDescendingSearch(String agentCode, String search);

	@Query(value = "select * from ul_customer_details where applicant_type = 'APP' and is_active = 1  and lead_active_status='ACTIVE' and agent_code in (select username from ul_agent_login where agency =:agency ) and (cust_id like %:search%  or phoneno like %:search% ) order by create_time desc", nativeQuery = true)
	public List<UlCustomerDetails> getAllLeadsByAgencySearch(String agency, String search);

	public UlCustomerDetails findByCoapplicantOf(int coapplicantOf);

	public UlCustomerDetails findByCustId(int custId);
	
	//Dashboard

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and date(soc_prequalify_time)=date(now()) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where originator in :agentCode and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallLeads(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and date(soc_prequalify_time)=date(now()) and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and applicant_type = 'APP' and lead_active_status = 'DISBURSED' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallDisbLead(List<String> agentCode);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and date(soc_prequalify_time)=date(now()) and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getTodayLeadWithStatus(List<String> agentCode, String leadStatus);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and MONTH(soc_prequalify_time) = MONTH(CURRENT_DATE())AND YEAR(soc_prequalify_time) = YEAR(CURRENT_DATE()) and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getMonthlyLeadWithStatus(List<String> agentCode, String leadStatus);

	@Query(value = "select count(*) from ul_customer_details where agent_code in :agentCode and (soc_prequalify_status= :leadStatus or manual_credit_status = :leadStatus) and applicant_type = 'APP' and lead_active_status not in('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getOverallLeadWithStatus(List<String> agentCode, String leadStatus);
	
	//DashBorad total open applications
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and lead_status not in('PQUAL_FAIL','MOS_DONE','ACTIVE','REJECTED') and lead_active_status not in ('CANCELLED','DUPLICATE')", nativeQuery = true)
	public int getAgentOpenApplicantionCount(String agentCode);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and cibil_score >:cibilScore and soc_prequalify_status in ('APPROVED','GRAY') and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysValidLeads(String agentCode, int cibilScore);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysLeads(String agentCode);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and soc_prequalify_status= :status and date(create_time) >= DATE(NOW())", nativeQuery = true)
	public int getAgentTodaysLeadByPreQual(String agentCode, String status);
	
	@Query(value = "select count(*) from ul_customer_details where agent_code=:agentCode and applicant_type = 'APP' and cibil_score >:cibilScore and date(create_time) = DATE(NOW() - INTERVAL 1 DAY)", nativeQuery = true)
	public int getAgentYesterdaysValidLeads(String agentCode, int cibilScore);
	
	//FI List
	@Query(value = "select * from ul_customer_details where ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFIList();
	
	@Query(value = "select * from ul_customer_details where ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFIListSearchKey(String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent = :agentCode or office_fi_agent = :agentCode) and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgentCodeAndSearchKey(String agentCode, String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent in (select username from ul_agent_login where agency =:agency ) or office_fi_agent in (select username from ul_agent_login where agency =:agency ))  and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) and (cust_id like %:search%  or phoneno like %:search%) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgencyAndSearchKey(String agency, String search);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent in (select username from ul_agent_login where agency =:agency ) or office_fi_agent in (select username from ul_agent_login where agency =:agency ))  and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgency(String agency);
	
	@Query(value = "select * from ul_customer_details where (home_fi_agent = :agentCode or office_fi_agent = :agentCode) and ((home_fi_req=1 and home_fi_verified=0) or (office_fi_req=1 and office_fi_verified=0)) order by create_time desc LIMIT 20", nativeQuery = true)
	public List<UlCustomerDetails> getFILeadByAgentCode(String agentCode);
	
	//Map
	@Query(value="select count(*) from ul_customer_state_status where  cust_id in (select cust_id from ul_customer_details where applicant_type = 'APP' and date(create_time)>=date(now()) and agent_code =:agentCode) and esign_status=1", nativeQuery = true)
	public int getCompletedLoanByAgent(String agentCode);

	@Query(value = "select * from ul_customer_details where  user_pan=:panNumber and cust_id !=:customerId", nativeQuery = true)
	public List<UlCustomerDetails> findByUserPanNotInCustId(String panNumber, String customerId);
	*/
}