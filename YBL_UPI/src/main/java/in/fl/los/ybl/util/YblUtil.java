package in.fl.los.ybl.util;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vTransact.upi.service.EncryptionMainClass;

public class YblUtil {

	// UAT credentials
	public static final String merchId = "YBL000000152901";
	public static final String encDecKey = "15a6bc76ca16f2fd1a7bc1b391b3597258738f52ee6d5d759ec4bd44cf81868c";
	public static final String merchVpa = "sampathi@yesipay";
	public static final String yblPayUrl = "https://yes-uat.anypayz.in";

	public static final Logger log = Logger.getLogger(YblUtil.class);

	public static String encodeWrapString(Object request) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequest = null;
		try {
			jsonRequest = mapper.writeValueAsString(request);
			log.info("Entering encodeWrapString request :\n" + jsonRequest);
		} catch (Exception e) {
			log.error("encodeWrapString exception=>" + e.getMessage());
		}
		String ecnRequeString = null;
		try {
			EncryptionMainClass encDec = new EncryptionMainClass();
			ecnRequeString = encDec.encrypt(jsonRequest, encDecKey);
		} catch (Exception e) {
			log.error("error in using EncryptionMainClass from external jar file:" + e.getMessage());
		}
		log.info("Exiting encodeWrapString Encrypted Request string :\n" + ecnRequeString);
		return ecnRequeString;
	}

	public static <T> T decryptAndExtract(String resp, Class<T> type) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//		T wrappedResp = null;
//		try {
//			wrappedResp = objectMapper.readValue(resp, type);
//		} catch (Exception e) {
//			log.error("payload :Incorrect Json format:" + e.getMessage());
//			throw new Exception(" payload :Incorrect Json format", e);
//		}
		log.info("encrypted response: \n" + resp);
		EncryptionMainClass encDec = new EncryptionMainClass();
		String decResp = encDec.decrypt(resp, encDecKey);
		log.info(" decrypted respose: \n" + decResp);

		T nachResponseDTO = null;
		try {
			nachResponseDTO = objectMapper.readValue(decResp, type);
		} catch (Exception e) {
			log.error(" decrypted payload :Incorrect Json format:" + e.getMessage());
//			throw new Exception(" decrypted payload :Incorrect Json format", e);
		}
		return nachResponseDTO;
	}

	public static String decrypt(String resp) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		log.info("encrypted response: \n" + resp);
		EncryptionMainClass encDec = new EncryptionMainClass();
		String decResp = encDec.decrypt(resp, encDecKey);
		log.info(" decrypted respose: \n" + decResp);

		return decResp;
	}

	public static <T> T Extract(String decResp, Class<T> type) throws Exception {

		T nachResponseDTO = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			nachResponseDTO = objectMapper.readValue(decResp, type);
		} catch (Exception e) {
			log.error(" decrypted payload :Incorrect Json format:" + e.getMessage());
			throw new Exception(" decrypted payload :Incorrect Json format", e);
		}
		return nachResponseDTO;
	}

	public static <T> T executeCheckVpaRequest(Object request, String urlEnpoint, Class<T> type) {
		try {
			CheckVpaRequestYblDTO checkVpaRequestYblDTO = new CheckVpaRequestYblDTO();
			checkVpaRequestYblDTO.setPgMerchantId(YblUtil.merchId);
			checkVpaRequestYblDTO.setRequestMsg(YblUtil.encodeWrapString(request));

			final String url = YblUtil.yblPayUrl + urlEnpoint;

			RestTemplate restTemplate = new RestTemplate();

			// HttpsURLConnection.setDefaultHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			// javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((hostname,
			// sslSession) -> true);
			/*
			 * ((HttpComponentsClientHttpRequestFactory)
			 * restTemplate.getRequestFactory()).setHttpClient( (
			 * HttpClientBuilder.create()).setSSLHostnameVerifier(NoopHostnameVerifier.
			 * INSTANCE).build());
			 */

			((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000 * 120);
			((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 120);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Cookie", "SameSite=None; path=/i/");
			headers.add("Content-Type", "application/json");

			HttpEntity<Object> entity = new HttpEntity<Object>(checkVpaRequestYblDTO, headers);
			log.info("YBL UPI executeCheckVpaRequest createVpaRestRequest=>" + entity);
			CheckVpaResponseYblDTO checkVpaResponseYblDTO = restTemplate.postForObject(url, entity,
					CheckVpaResponseYblDTO.class);
			log.info("YBL UPI executeCheckVpaRequest createVpaRestResponse=>" + checkVpaResponseYblDTO);
			T response = YblUtil.decryptAndExtract(checkVpaResponseYblDTO.getResp(), type);
			log.info("YBL UPI executeCheckVpaRequest Response=>" + response);
			return response;
		} catch (Exception ex) {
			log.error("error in external Check Vpa API :" + ex.getMessage());
			return null;
		}

	}

	public static <T> T executeRequest(Object request, String urlEnpoint, Class<T> type) {
		try {
			RequestYblDTO requestYblDTO = new RequestYblDTO();
			requestYblDTO.setPayload(YblUtil.encodeWrapString(request));
			requestYblDTO.setPgMerchantId(YblUtil.merchId);

			final String url = YblUtil.yblPayUrl + urlEnpoint;

			RestTemplate restTemplate = new RestTemplate();
			((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000 * 120);
			((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 120);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Cookie", "SameSite=None; path=/i/");
			headers.add("Content-Type", "application/json");

			HttpEntity<Object> entity = new HttpEntity<Object>(requestYblDTO, headers);
			log.info("YBL UPI executeRequest External API Request: " + entity);
			ResponseYblDTO responseYblDTO = restTemplate.postForObject(url, entity, ResponseYblDTO.class);
			log.info("YBL UPI executeRequest External API Response: " + responseYblDTO);
			T response = YblUtil.decryptAndExtract(responseYblDTO.getPayload(), type);
			log.info("YBL UPI executeReqeust Response=> " + response);
			return response;
		} catch (Exception e) {
			log.error("Error in YblUtil executeRequest :" + e.getMessage());
			return null;
		}
	}
}
