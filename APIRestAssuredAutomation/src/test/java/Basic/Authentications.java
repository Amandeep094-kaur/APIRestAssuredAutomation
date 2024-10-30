package Basic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class Authentications {
	
	void testBasicAuthentication()
	{
		given()
			.auth().basic("postman","password")
		.when()
			.get("")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}
	
	
	void testdigestAuthentication()
	{
		given()
			.auth().digest("postman","password")
		.when()
			.get("")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}
	
	
	void testpremptiveAuthentication()
	{
		given()
			.auth().preemptive().basic("postman","password")
		.when()
			.get("")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
	}

	
	void testBearerToeknAuthentication()
	{
		String bearerToken = "";
		given()
			.headers("Authorization", "Bearer "+bearerToken)
		.when()
			.get("")
		.then()
			.statusCode(200)
			.log().all();
	}

	
	void testOAuth1Authentication()
	{
	
		given()
			.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
		.when()
			.get("")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	void testOAuth2Authentication()
	{
		
		given()
			.auth().oauth2("")
		.when()
			.get("")
		.then()
			.statusCode(200)
			.log().all();
	}

}
