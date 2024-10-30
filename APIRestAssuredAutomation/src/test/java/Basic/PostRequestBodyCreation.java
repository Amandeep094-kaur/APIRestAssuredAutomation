package Basic;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostRequestBodyCreation {
	

	@Test(priority=1)
	void getUserpostUsingHashMap()
	{
		HashMap<String, String> data = new HashMap <String, String>();
		data.put("name","ram");
		data.put("job", "plumber");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
			.post("https://reqres.in/api/users/12")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("ram"))
			.body("job", equalTo("plumber"))
			
			.log().all();
	}
	
	@Test(priority=2)
	void getUserpostUsingJson()
	{
		JSONObject data = new JSONObject();
		data.put("name","shaam");
		data.put("job", "driver");
		
		given()
		.body(data.toString())
		.contentType("application/json")
		.when()
			.post("https://reqres.in/api/users/5")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("shaam"))
			.body("job", equalTo("driver"))
			
			.log().all();
	}
	


	

}
