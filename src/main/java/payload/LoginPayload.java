package payload;

public class LoginPayload {

	private static String payload;

	public static String getPayload() {
		payload =

				"{\r\n" + 
				"  \"type\": \"credentials\",\r\n" + 
				"  \"countryCode\": \"USA\"\r\n" + 
				"}";

		return payload;

	}

}
