package in.fl.los.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.fl.los.model.UlCustomerDetails;
import in.fl.los.model.UlStateStatus;
import jakarta.annotation.PostConstruct;

@Component
public class CommonUtils {

	private static DBHandler DBHandlerV2;

	@Autowired
	private DBHandler dbHandler;

	@PostConstruct
	private void initDBHandler() {
		DBHandlerV2 = this.dbHandler;
	}

	private final static Logger log = Logger.getLogger(CommonUtils.class);

	private static final int R = 6371;

	public static String truncate(String message, int length) {
		if (message != null && message.length() > length)
			message = message.substring(0, length);
		return message;
	}

	public static String cleanNonAscii(String message) {
		if (message == null || message.length() == 0)
			return message;
		return message.replaceAll("[^\\x20-\\x7E]", "");
	}

	public static boolean checkMaskStringMatch(String actualString, String comparable) {
		if (actualString == null || comparable == null || (actualString.length() != comparable.length()))
			return false;
		for (int i = 0; i < actualString.length(); i++) {
			char actualChar = actualString.charAt(i);
			if (actualChar == 'X' || actualChar == comparable.charAt(i))
				continue;
			else
				return false;

		}
		return true;
	}

	public static float round(float value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.floatValue();
	}

	public static void main(String[] args) {
		String plain = decryptPassword("6bxzRiexMjsg8GwrOBOGFg==");
		System.out.println("--" + plain + "--");
		plain = decryptPassword("4vcEXgoW4ufDo8M8b2vND64Ims7/0xJdL9bVXpQqlpQ=");
		System.out.println("--" + plain + "--");
	}

	public static String encryptPassword(String clearText) {
		try {
			byte[] key = Base64.getDecoder().decode("daLYgrRnXj4A1Yhp80Q5EA==");

			// Add salt
			Random r = new Random();
			int rand = 100000 + r.nextInt(200000);
			String sRand = "" + rand;
			sRand = sRand.substring(0, 5);
			clearText += "_" + sRand;

			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(clearText.getBytes());
			return Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clearText;
	}

	public static String decryptPassword(String encrypted) {
		try {
			byte[] key = Base64.getDecoder().decode("daLYgrRnXj4A1Yhp80Q5EA==");
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			byte[] encText = Base64.getDecoder().decode(encrypted);
			byte[] decrypted = cipher.doFinal(encText);
			String decr = new String(decrypted);

			// remove salt (last 6 digits)
			String plainText = decr.substring(0, decr.length() - 6);
			return plainText;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encrypted;
	}

	public static boolean mdcPut(String key, String value) {
		if (value != null) {
			MDC.put(key, value);
		} else {
			return false;
		}
		return true;
	}

	public static String commaSepetator(float val) {
		return NumberFormat.getNumberInstance(Locale.UK).format(val);
	}

	public static String commaSepetatorRupee(float value) {
		long number = (long) value;
		if (value <= 999) {
			return Double.toString(number);
		}
		String numberStr = String.valueOf(number).trim();
		String thousandsPart = numberStr.substring(numberStr.length() - 3, numberStr.length());
		long rest = number / 1000;
		NumberFormat format = new DecimalFormat("##,##");
		String formattedString = format.format(rest);
		return formattedString + "," + thousandsPart;
	}

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	public static String convert(long number) {
		// 0 to 999 999 999 999
		if (number == 0) {
			return "zero";
		}

		String snumber = Long.toString(number);

		// pad with "0"
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = "";
			break;
		case 1:
			tradBillions = convertLessThanOneThousand(billions) + " billion ";
			break;
		default:
			tradBillions = convertLessThanOneThousand(billions) + " billion ";
		}
		String result = tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = "";
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(millions) + " million ";
			break;
		default:
			tradMillions = convertLessThanOneThousand(millions) + " million ";
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = "";
			break;
		case 1:
			tradHundredThousands = "one thousand ";
			break;
		default:
			tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;

		// remove extra spaces!
		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}

	private static String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return numNames[number] + " hundred" + soFar;
	}

	public static UlStateStatus getStateObject(UlCustomerDetails customerDetails, String state) {
		UlStateStatus ulStateStatus = new UlStateStatus();
		ulStateStatus.setCustomerDetails(customerDetails);
		Set<UlStateStatus> stateStatusList = customerDetails.getStateStatus();
		if (stateStatusList != null) {
			if (stateStatusList.size() > 0) {
				UlStateStatus lastStateStatus = (stateStatusList.stream()
						.sorted(Comparator.comparing(UlStateStatus::getId).reversed()).limit(1)
						.collect(Collectors.toList())).get(0);
				log.info("Entering CommonUtils-getStateObject lastStateStatus :" + lastStateStatus);
				Date lastActionTime = lastStateStatus.getCreateTime();
				log.info("Entering CommonUtils-getStateObject lastActionTime :" + lastActionTime);
				long lastActionTimeMillis = lastActionTime.getTime();
				long currentTimeInMillis = System.currentTimeMillis();
				ulStateStatus.setTimeTaken(currentTimeInMillis - lastActionTimeMillis);
			} else {
				ulStateStatus.setTimeTaken(0);
			}
		} else {
			ulStateStatus.setTimeTaken(0);
		}

		ulStateStatus.setPid(customerDetails.getPid());
		ulStateStatus.setAgentId(customerDetails.getAgentId());
		ulStateStatus.setUsername(customerDetails.getAgentCode());
		ulStateStatus.setVisitId(customerDetails.getVisitId());
		ulStateStatus.setState(state);

		// Update Agent Activity
		try {
			if (customerDetails.getApplicantType().equalsIgnoreCase("APP")) {
				if (customerDetails.getAgentCode() != null
						&& !(ulStateStatus.getState().equalsIgnoreCase("NACH_SUCCESS")
								|| ulStateStatus.getState().equalsIgnoreCase("CUST_REFERENCE")
								|| ulStateStatus.getState().equalsIgnoreCase("NACH_FAIL")
								|| ulStateStatus.getState().equalsIgnoreCase("INIT")
								|| ulStateStatus.getState().equalsIgnoreCase("OTP_VERIFY")
								|| ulStateStatus.getState().equalsIgnoreCase("PAN_VERIFY")
								|| ulStateStatus.getState().equalsIgnoreCase("PQUAL_SUCCESS")
								|| ulStateStatus.getState().equalsIgnoreCase("CUST_REFERENCE")
								|| ulStateStatus.getState().equalsIgnoreCase("UPI_RESET")
								|| ulStateStatus.getState().equalsIgnoreCase("ESIGN")
								|| ulStateStatus.getState().equalsIgnoreCase("UPI_SUCCESS")
								|| ulStateStatus.getState().equalsIgnoreCase("MOS_WAIT"))) {
					// current_task =" + customerDetails.getCustId() + ",
					String query = "update ul_agent_master set current_task_status='" + ulStateStatus.getState()
							+ "', last_activity_time= now() where username ='" + customerDetails.getAgentCode() + "'";
					log.info("Agent master Current Task Update query=>" + query);
					if (DBHandlerV2 != null) {
						DBHandlerV2.executeQuery(query);
					}
				}
			}
		} catch (Exception e) {
			log.error("Exception updating agent activity :", e);
		}

		log.info("UlStateStatus Save State :" + customerDetails.getCustId() + ", " + state + " =>"
				+ ulStateStatus.toString());
		return ulStateStatus;
	}

	public static String sendPushNotification(String title, String to, String body, String action) {
		final String uri = "https://fcm.googleapis.com/fcm/send";
		String authorizationToken = "key=AAAAll_7PBU:APA91bHRwSRaLoyb5TZ2cIeJHdWW815zShDQsHD229wW8itK1nZTpy2CLZGmG0ZKrI4zTztP4WD54Njr4BOMaUtMkH_eFnahu1dhDIScQig_qI4DEOhAcCr9qPx_-Nz2j5FEcc5VJQQb";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authorizationToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		String jsonRequest = "{\"to\" : \"" + to + "\", \"data\": {\"title\": \"" + title + "\",\"body\": \"" + body
				+ "\",\"action\":\"" + action + "\"}}";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(jsonRequest, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		String responseBody = result.getBody();
		log.info("sendPushNotification Response=>" + responseBody);
		return responseBody;
	}

	public static String getHash(String message) {
		String input = message + "_" + getRandom();
		String hash = "";
		try {
			hash = getSha1(input);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("Error in hash generation : ", e);
		}
		return hash;
	}

	public static String getRandom() {
		Random random = new Random();
		String randomValue = Integer.toString(100000 + random.nextInt(900000));
		return randomValue;
	}

	public static String getOTPRandom() {
		Random random = new Random();
		String randomValue = Integer.toString(1000 + random.nextInt(9000));
		return randomValue;
	}

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	private static String getSha1(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
		msdDigest.update(message.getBytes("UTF-8"), 0, message.length());
		return DatatypeConverter.printHexBinary(msdDigest.digest());

	}

	public static int getAge(String dob) {
		Date date = new Date();
		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		LocalDate date1 = LocalDate.parse(dob);
		LocalDate date2 = LocalDate.parse(todayDate);
		Period period = date1.until(date2);
		int yearsBetween = period.getYears();
		System.out.println("yearsBetween:" + yearsBetween);
		return yearsBetween;
	}

	public static String correctBankName(String customerBankName) {

		switch (customerBankName.toLowerCase().trim()) {
		case "icici bank ltd":
			customerBankName = "ICICI Bank";
			break;
		case "hdfc bank ltd":
			customerBankName = "HDFC Bank";
			break;
		case "idfc first bank ltd":
			customerBankName = "IDFC FIRST BANK";
			break;
		case "indusind bank ltd":
			customerBankName = "IndusInd Bank";
			break;
		case "indusind bank ltd.":
			customerBankName = "IndusInd Bank";
			break;
		case "standard chartered bank ltd":
			customerBankName = "Standard Chartered Bank";
			break;
		case "tamilnadu mercantile bank ltd":
			customerBankName = "Tamilnadu Mercantile Bank";
			break;
		case "aubank":
			customerBankName = "AU small Finance";
			break;
		case "the catholic syrian bank":
			customerBankName = "Catholic Syrian Bank";
			break;
		case "rbl bank":
			customerBankName = "RBL Bank Ltd";
			break;
		case "karur vysa bank":
			customerBankName = "Karur Vysya Bank";
			break;
		case "axis bank":
			customerBankName = "Axis Bank Ltd";
			break;

		}
		return customerBankName;
	}

	public static int calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		// log.info("calculateDistance Req=> lat1, long1 | lat2, long2 : " + lat1+","+
		// lon1 +","+ lat2+","+ lon2);
		// Convert latitudes and longitudes to radians
		double latDistanceRad = Math.toRadians(lat2 - lat1);
		double lonDistanceRad = Math.toRadians(lon2 - lon1);

		double a = Math.sin(latDistanceRad / 2) * Math.sin(latDistanceRad / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistanceRad / 2) * Math.sin(lonDistanceRad / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double ret = R * c;
		// log.info("calculateDistance Response => Double : " + ret);
		int distance = (int) Math.round(ret);
		// log.info("calculateDistance Response => Int : " + distance);
		return distance;
	}

	public static int calculateDistanceMeters(double lat1, double lon1, double lat2, double lon2) {
		// log.info("calculateDistance Req=> lat1, long1 | lat2, long2 : " + lat1+","+
		// lon1 +","+ lat2+","+ lon2);
		// Convert latitudes and longitudes to radians
		double latDistanceRad = Math.toRadians(lat2 - lat1);
		double lonDistanceRad = Math.toRadians(lon2 - lon1);

		double a = Math.sin(latDistanceRad / 2) * Math.sin(latDistanceRad / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistanceRad / 2) * Math.sin(lonDistanceRad / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double ret = R * c;
		// log.info("calculateDistance Response => Double : " + ret);
		double retMeters = ret * 1000.0;
		int distance = (int) Math.round(retMeters);
		// log.info("calculateDistance Response => Int : " + distance);
		return distance;
	}

	public static double getEdiAmount(int tenure, double loanAmount) {
		double ediAmt = 0;
		int tenureInDays = tenure;

		switch (tenureInDays) {
		case 120:
			ediAmt = Math.ceil(9337 * (loanAmount / 1056637));
			break;
		case 180:
			ediAmt = Math.ceil(6442 * (loanAmount / 1063265));
			break;
		case 240:
			ediAmt = Math.ceil(4968 * (loanAmount / 1063265));
			break;
		case 270:
			ediAmt = Math.ceil(4481 * (loanAmount / 1063265));
			break;
		case 300:
			ediAmt = Math.ceil(4150 * (loanAmount / 1069978));
			break;
		case 360:
			ediAmt = Math.ceil(3524 * (loanAmount / 1069978));
			break;
		case 365:
			ediAmt = Math.ceil(3480 * (loanAmount / 1069978));
			break;
		case 730:
			ediAmt = Math.ceil(2054 * (loanAmount / 1076775));
			break;
		}
		return ediAmt;
	}

}
