package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Endpoints;
import resources.Util;

public class Registration extends Base {
	static RequestSpecification req;
	static Response res;
	Util utils = new Util();

	@Given("User is given with request payload")
	public void user_is_given_with_request_payload(){

		req = given().spec(requestSpecification()).header("Authorization", Refresh.Btoken)
				.body(payload.RegistrationPayload.getPayload(utils.randomEmail()));

	}

	@When("User hits {string} api with {string} http call")
	public void user_hits_api_with_http_call(String resourceTpe, String method) {

		resources.Endpoints e = Endpoints.valueOf(resourceTpe);
		if (method.equals("GET")) {

			res = req.when().get(e.getName()).then().extract().response();
			Base.res=res;
		}
		else {
			
			res = req.when().post(e.getName()).then().extract().response();
			Base.res=res;

		}
	}

	@Then("API returns status code {int}")
	public static void api_returns_status_code(Integer expCode) {

		Integer actCode = Base.res.getStatusCode();

		assertEquals(expCode, actCode);

	}

}
