package payload;

public class ProfilePayload {

	private static String payload;

	public static String getPayload(String firstName) {
		payload =

				"{\r\n" + 
				"    \"first_name\": \""+firstName+"\",\r\n" + 
				"    \"last_name\": \"venkatagf\",\r\n" + 
				"    \"countryCode\": \"USA\" \r\n" + 
				"}";

		return payload;

	}
}
