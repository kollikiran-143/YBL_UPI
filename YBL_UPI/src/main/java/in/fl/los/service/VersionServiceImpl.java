package in.fl.los.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.fl.los.repository.ConfigRepository;
import in.fl.los.response.VersionCheckResponseDTO;
import in.fl.los.util.WebConstants;

/***
 * This is the implementation class for the api exposed as Current Client
 * Application Version
 * 
 * @author Rajesh
 *
 */

@Component
public class VersionServiceImpl implements VersionService {

	@Autowired
	private ConfigRepository configRepository;

	private final Logger log = Logger.getLogger(VersionServiceImpl.class);

	/***
	 * This api is used to check app version and current live version
	 * 
	 * @param clientVersion
	 * @param appName
	 * @return
	 */
	@Override
	public VersionCheckResponseDTO getVersion(String clientVersion, String appName) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering VersionCheckServiceImpl UPLIFT==>" + clientVersion + "App Name: " + appName);
		String version = "";
		VersionCheckResponseDTO response = new VersionCheckResponseDTO();
		if(appName.trim().equalsIgnoreCase("in.fl.uplift.agent")){
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.customer")) {
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_CUSTAPPVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.sales") || appName.trim().equalsIgnoreCase("in.fl.ul.lead")) {
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_SALESAPPVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.collection")){
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_LCSVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.bs.csso")) { 
			version = configRepository.findByconfigKey(WebConstants.BS_CSSO_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.csso")) { 
			version = configRepository.findByconfigKey(WebConstants.CSSO_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}

		String[] versionDetails = version.split("\\,");
		//if (response.getVersion() != null && (response.getVersion().equalsIgnoreCase(clientVersion))) {
		if (response.getVersion() != null && (ArrayUtils.contains(versionDetails, clientVersion))) {
			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
		} else {
			response.setStatusCode(WebConstants.VERSION_MISMATCH_CODE);
			response.setStatusMessage(WebConstants.VERSION_MISMATCH_MSG);
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for SVersionCheckServiceImpl Details is ==>" + timeTaken);
		log.info(" VersionCheckServiceImpl getVersion Response is ==>" + response);
		return response;
	}
	
	@Override
	public VersionCheckResponseDTO getVersion(String clientVersion, String appName, String agentCode) {
		long startTimeInMillis = System.currentTimeMillis();
		log.info("Entering VersionCheckServiceImpl getVersion new ==>" + clientVersion + " | App Name : " + appName + " | Agent  : " + agentCode);
		String version = "";
		VersionCheckResponseDTO response = new VersionCheckResponseDTO();
		if(appName.trim().equalsIgnoreCase("in.fl.uplift.agent")){
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.customer")) {
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_CUSTAPPVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.sales") || appName.trim().equalsIgnoreCase("in.fl.ul.lead")) {
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_SALESAPPVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.fl.uplift.collection")){
			version = configRepository.findByconfigKey(WebConstants.UPLIFT_LCSVERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.bs.csso")) { 
			version = configRepository.findByconfigKey(WebConstants.BS_CSSO_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}else if(appName.trim().equalsIgnoreCase("in.csso")) { 
			version = configRepository.findByconfigKey(WebConstants.CSSO_VERSION_CONFIG_KEY).getConfigValue();
			response.setVersion(version);
		}

		String[] versionDetails = version.split("\\,");
		if (response.getVersion() != null && (ArrayUtils.contains(versionDetails, clientVersion))) {
			response.setStatusCode(WebConstants.SUCCESS_CODE);
			response.setStatusMessage(WebConstants.SUCCESS_MSG);
			/*
			String[] agentList = new String[] {"arun0693","Arumugaraj6956","Jayaprakash","vinoth6412","vasanth6463","madhankumar3453","giribabu7290","arulraj9847","tilakrao7502"}; //{"vinoth6412", "arun0693","banduraja@334"};
			if(agentCode != null && !agentCode.equalsIgnoreCase("") && ArrayUtils.contains(agentList, agentCode) &&  (clientVersion.equalsIgnoreCase("82.00") || clientVersion.equalsIgnoreCase("84.00"))) {
				response.setStatusCode(WebConstants.VERSION_MISMATCH_CODE);
				response.setStatusMessage(WebConstants.VERSION_MISMATCH_MSG);
			}else {
				response.setStatusCode(WebConstants.SUCCESS_CODE);
				response.setStatusMessage(WebConstants.SUCCESS_MSG);
			}
			*/			
		} else {
			response.setStatusCode(WebConstants.VERSION_MISMATCH_CODE);
			response.setStatusMessage(WebConstants.VERSION_MISMATCH_MSG);
		}

		long timeTaken = System.currentTimeMillis() - startTimeInMillis;
		log.info("Time Taken for SVersionCheckServiceImpl Details is ==>" + timeTaken);
		log.info(" VersionCheckServiceImpl getVersion Response is ==>" + response);
		return response;
	}

}
