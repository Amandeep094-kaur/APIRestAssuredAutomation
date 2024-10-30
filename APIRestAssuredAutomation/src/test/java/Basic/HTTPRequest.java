package Basic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



/* given()
 content type, set cookies, add auth, add param, set headers infor
 
 when()
 get,post, put, delete
 
 then()
 validate status code, extract respone, extract headers, cookies, response body
 
 */

public class HTTPRequest {
	int id;
	
	@Test(priority=1)
	void getUser()
	{
		given()
		.when()
			.get("https://reqres.in/api/users")
		
		.then()
			.statusCode(200)
	//		.body("id", equalTo("2"))
			.log().all();
	}
	
	
	@Test (priority=2)
	void createUser()
	{
		HashMap<String, String> data = new HashMap <String, String>();
		data.put("name","aman");
		data.put("job", "tester");
			    
		 id = given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		
	}
	
	@Test(priority=3)
	void updateUser()
	{
		HashMap<String, String> data = new HashMap <String, String>();
		data.put("name","teji");
		data.put("job", "tester");
			    
		 given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users/"+id)
			
			.then()
				.statusCode(201)
		
				.log().all();
		}
	
	@Test(priority=4)	
	void deleteUser()
	{
		
			    
		 
		when()
			.delete("https://reqres.in/api/users/"+id)
			
			.then()
				.statusCode(204)
		
				.log().all();
		}
		
		
		
	}
	
	
	


