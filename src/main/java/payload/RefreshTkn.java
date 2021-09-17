package payload;

public class RefreshTkn {

	static String payload;

	public static String getPayload() {
		payload =

				"{\r\n" + 
				"  \"type\": \"guest\",\r\n" + 
				"  \"countryCode\": \"USA\"\r\n" + 
				"}";

		return payload;

	}

}
