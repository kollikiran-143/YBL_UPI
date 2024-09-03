package in.fl.los.service;

import in.fl.los.request.BaseRequestDTO;

public interface CustomerLocationService {
	/***
	 * This api is used to update current location
	 * 
	 * @param clientVersion
	 * @param appName
	 * @return
	 */
	public void saveCustomerLocationLog(BaseRequestDTO baseRequestDTO);
	
	public void saveMyVisitLocationLog(BaseRequestDTO baseRequestDTO);
}
