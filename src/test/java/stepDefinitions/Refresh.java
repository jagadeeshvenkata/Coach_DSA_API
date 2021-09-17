package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Endpoints;

public class Refresh extends Base {

	static RequestSpecification req;
	static Response response;
	static String Btoken;

	@Given("Bearer token is generated")
	public String bearer_token_is_generated() throws FileNotFoundException {
	
		req = given().spec(requestSpecification()).body(payload.RefreshTkn.getPayload());
		
		resources.Endpoints e = Endpoints.valueOf("refresh");
		
		response = req.when().post(e.getName()).then().extract().response();
		
		Btoken = response.getBody().jsonPath().get("token.value");
		
		return Btoken;
	}

}
