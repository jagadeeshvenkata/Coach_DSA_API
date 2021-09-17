package resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Util {
	
	protected JsonPath js = new JsonPath("");

	public JsonPath jsonPathRetrieval(Response response) {

		String re = response.asString();
		js = new JsonPath(re);

		return js;
	}
	
	public String randomEmail() {
		String email = "Coach";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");  
		LocalDateTime now = LocalDateTime.now();  
		String time = now.toString();
		time  = time.replace('-', ' ').replace(':', ' ').replaceAll("\\s+", "");
		email = email+time+"@yopmail.com";
		return email;
		
	}

	public <T> List<T> removeNullUsingIterator(List<String> a, Predicate<String> isNull) {

		Iterator<T> itr = (Iterator<T>) a.iterator();
		while (itr.hasNext()) {
			T t = itr.next();
			if (!isNull.test((String) t)) {
				itr.remove();
			}
		}

		return (List<T>) a;
	}
	
	
	
		
		
		

	

	/*
	 * public static JSONObject stringToObjectConverter(String jsonString) throws
	 * ParseException {
	 * 
	 * JSONParser parser = new JSONParser();
	 * 
	 * JSONObject jo = (JSONObject) parser.parse(jsonString);
	 * 
	 * return jo;
	 * 
	 * }
	 * 
	 * public static JSONArray stringArrayToJsonArrayConverter(String jsonString)
	 * throws ParseException {
	 * 
	 * JSONParser jsonParser=new JSONParser();
	 * 
	 * //JSONObject object=(JSONObject) jsonParser.parse(jsonString);
	 * 
	 * JSONArray arrayObj=null;
	 * 
	 * //object=jsonParser.parse(jsonString); arrayObj=(JSONArray)
	 * jsonParser.parse(jsonString);
	 * 
	 * // arrayObj=new JSONArray(object);
	 * 
	 * 
	 * System.out.println("Json object :: "+arrayObj);
	 * 
	 * return arrayObj;
	 * 
	 * }
	 */
}
