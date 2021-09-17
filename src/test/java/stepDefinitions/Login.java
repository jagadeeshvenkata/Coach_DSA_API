package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.LoginPayload;
import resources.Endpoints;

public class Login extends Base{

	RequestSpecification req;
	Response res;
	String resourceTpe;
	
	@Given("User is given with {string} and {string}")
	public void user_is_given_with_and(String userName, String password){
	
		req = given().spec(requestSpecification()).body(LoginPayload.getPayload()).auth().preemptive().basic(userName, password);
		
	}

	@When("User hits Login {string} api with {string} http call")
	public void user_hits_Login_api_with_http_call(String resourceTpe, String method) {

		Endpoints e = Endpoints.valueOf(resourceTpe);

			res = req.when().post(e.getName()).then().extract().response();
			
			Base.res=res;
			
	}
	
	@Then("API response has the message {string}")
	public void api_response_has_the_message(String successMessage) {

		String message = res.getBody().jsonPath().get("auth_type");
		
		assertEquals(message, successMessage);
		
	}


}



