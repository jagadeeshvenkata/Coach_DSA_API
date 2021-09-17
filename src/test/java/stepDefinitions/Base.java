package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Configuration;
import resources.Endpoints;

public class Base {

	static RequestSpecification req;
	static Response res;
	String env;
	
	public RequestSpecification requestSpecification() {
		env = Configuration.getEnv();
		
		
		try {
			
			PrintStream log;
			log = new PrintStream(new FileOutputStream("log.txt"));
			
			if (env.equals("dev")) {
				resources.Endpoints e = Endpoints.valueOf("dev");
				req = new RequestSpecBuilder().setBaseUri(e.getName())
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return req;
		

	}
}
