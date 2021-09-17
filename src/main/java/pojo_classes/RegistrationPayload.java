package pojo_classes;

public class RegistrationPayload {

	static String payload;

	public static String getPayload() {
		payload =

				"{\n" + "  \"password\": \"asdf1234\",\n" + "  \"customer\": {\n"
						+ "    \"login\": \"jay@dev711.com\",\n" + "    \"email\": \"jay@dev711.com\",\n"
						+ "    \"last_name\": \"hb\",\n" + "    \"first_name\": \"hbhb\",\n" + "    \"gender\": 2,\n"
						+ "    \"c_brand\": \"Coach\",\n" + "    \"c_emailOptIn\": 1,\n"
						+ "    \"c_directMailOptIn\": 2,\n" + "    \"c_homePhoneOptIn\": 2,\n"
						+ "    \"c_marketingSource\": \"OTL_LSS_REG\",\n" + "    \"c_messageType\": 1,\n"
						+ "    \"c_mobilePhoneOptIn\": 2,\n" + "    \"c_officePhoneOptIn\": 2,\n"
						+ "    \"c_smsOptIn\": 2,\n" + "    \"c_sourceCode\": \"DWEOS\",\n"
						+ "    \"c_systemCountryCode\": \"US\",\n" + "    \"c_customerGroup\": \"ACTIVEDW\",\n"
						+ "    \"c_lastModifiedDate\": \"2020-08-06T07:39:14.000Z\",\n"
						+ "    \"c_membershipID\": \"\",\n" + "    \"c_preferredStore\": \"\"\n" + "  }\n" + "}";

		return payload;

	}

}
