package in.fl.los.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlCustomerLocationLog;
import in.fl.los.repository.CustomerLocationLogRepository;
import in.fl.los.repository.CustomerRepository;
import in.fl.los.request.BaseRequestDTO;

@Component
public class CustomerLocationServiceImpl implements CustomerLocationService{
	@Autowired
	private CustomerLocationLogRepository customerLocationLogRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	private final Logger log = Logger.getLogger(CustomerLocationServiceImpl.class);

	@Override
	public void saveCustomerLocationLog(BaseRequestDTO baseRequestDTO) {
		try {
			log.info("saveLocationDetails UPLIFT :" + baseRequestDTO);
			UlCustomerLocationLog ulCustomerLocationLog = new UlCustomerLocationLog();
			if (baseRequestDTO != null && baseRequestDTO.getLocationRequestDTO() != null
					&& baseRequestDTO.getCustomerId() != null && !baseRequestDTO.getCustomerId().equalsIgnoreCase("")) {
				UlCustomerDetails customerDetails = customerRepository
						.findById(Integer.parseInt(baseRequestDTO.getCustomerId())).get();
				int custId = Integer.parseInt(baseRequestDTO.getCustomerId());
				log.info("saveLocationDetails UPLIFT CUSTID : " + customerDetails.getCustId());
				ulCustomerLocationLog.setCustomerDetails(customerDetails);
				ulCustomerLocationLog.setEventType(baseRequestDTO.getLocationRequestDTO().getEventType());
				ulCustomerLocationLog.setLatitude(baseRequestDTO.getLocationRequestDTO().getLatitude());
				ulCustomerLocationLog.setLongitude(baseRequestDTO.getLocationRequestDTO().getLongitude());
				ulCustomerLocationLog.setAltitude(baseRequestDTO.getLocationRequestDTO().getAltitude());
				ulCustomerLocationLog.setLocationDetails(baseRequestDTO.getLocationRequestDTO().getLocationDetails());
				ulCustomerLocationLog.setCreateTime(new Date());
				ulCustomerLocationLog.setUpdateTime(new Date());

				customerLocationLogRepository.save(ulCustomerLocationLog);
			}
		} catch (Exception e) {
			log.error("Error occured while parsing location response : ", e);
		}
	}

	@Override
	public void saveMyVisitLocationLog(BaseRequestDTO baseRequestDTO) {
		try {
			log.info("saveLocationDetails UPLIFT :" + baseRequestDTO);
			UlCustomerLocationLog ulCustomerLocationLog = new UlCustomerLocationLog();
			if (baseRequestDTO != null && baseRequestDTO.getLocationRequestDTO() != null
					&& baseRequestDTO.getCustomerId() != null && !baseRequestDTO.getCustomerId().equalsIgnoreCase("")) {
			
				log.info("saveMyVisitLocationLog UPLIFT MY VISIT ID : " + baseRequestDTO.getCustomerId());
				
				ulCustomerLocationLog.setEventType(baseRequestDTO.getLocationRequestDTO().getEventType());
				ulCustomerLocationLog.setLatitude(baseRequestDTO.getLocationRequestDTO().getLatitude());
				ulCustomerLocationLog.setLongitude(baseRequestDTO.getLocationRequestDTO().getLongitude());
				ulCustomerLocationLog.setAltitude(baseRequestDTO.getLocationRequestDTO().getAltitude());
				ulCustomerLocationLog.setLocationDetails(baseRequestDTO.getLocationRequestDTO().getLocationDetails());
				ulCustomerLocationLog.setCreateTime(new Date());
				ulCustomerLocationLog.setUpdateTime(new Date());

				customerLocationLogRepository.save(ulCustomerLocationLog);
			}
		} catch (Exception e) {
			log.error("Error occured while parsing location response : ", e);
		}
		
	}

}
