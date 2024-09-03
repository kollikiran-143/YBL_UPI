package in.fl.los.service;

import in.fl.los.response.VersionCheckResponseDTO;

public interface VersionService {

	/***
	 * This api is used to check app version and current live version
	 * 
	 * @param clientVersion
	 * @param appName
	 * @return
	 */
	public VersionCheckResponseDTO getVersion(String clientVersion, String appName);

	/***
	 * THis api is uses to check agent app version and current live version
	 * @param clientVersion
	 * @param appName
	 * @param agentCode
	 * @return
	 */
	VersionCheckResponseDTO getVersion(String clientVersion, String appName, String agentCode);
	
}
