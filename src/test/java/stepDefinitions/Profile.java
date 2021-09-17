package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.LoginPayload;
import payload.ProfilePayload;
import resources.Endpoints; 

public class Profile extends Base {
	static RequestSpecification req;
	static Response res;
	static String token;
	static String customerID;

	@Given("User is already LoggedIn")
	public void user_is_already_logged_in(DataTable dataTable) throws FileNotFoundException {

		Endpoints e = Endpoints.valueOf("login");
		List<Map<String,String>> cred = dataTable.asMaps();
		
		String usrName = cred.get(0).get("userName");
		String password = cred.get(0).get("password");
		
		req = given().spec(requestSpecification()).body(LoginPayload.getPayload()).auth().preemptive()
				.basic(usrName, password);
		
		res = req.when().post(e.getName()).then().extract().response();
		
		token = res.getBody().jsonPath().get("token.value");
		customerID = res.getBody().jsonPath().get("customer_id");
		customerID="/"+customerID;
	}

	@When("User hits {string} api with firstName as {string}")
	public void user_hits_api_with_firstName_as(String resource, String firstName) throws FileNotFoundException {
		
		Endpoints e = Endpoints.valueOf(resource);
		req = given().spec(requestSpecification()).body(ProfilePayload.getPayload(firstName)).header("Authorization",token);
		Base.res = req.when().post(e.getName()+customerID).then().extract().response();

	}

	@Then("API returns with C360message {string}")
	public void api_returns_with_c360message(String expMessage) {

		String message = Base.res.jsonPath().getString("c360UpdateFlag");
		assertEquals(expMessage, message);

	}
	
}
