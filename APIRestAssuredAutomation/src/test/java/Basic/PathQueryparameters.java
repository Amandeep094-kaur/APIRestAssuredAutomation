package Basic;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Map;


public class PathQueryparameters {

	@Test
	void testQueryPathParameters()
	{
		given()
		.pathParam("mypath", "users")  //path parameters
		.queryParam("page",2)  //query param
		.queryParam("id", 12)
		.when()
		.get("https://reqres.in/api/{mypath}")  //only path param needs to mention in url not the query param it will take automatically
		.then()
		.statusCode(200)
		.log().all();
	}
	
	

	@Test
	void testCookies()
	{
		Response res =given()
		
		.when()
		.get("https://www.google.com") ; //only path param needs to mention in url not the query param it will take automatically
		
		//cooki info
//		String cookie = res.getCookie("AEC");
//		System.out.println("cookie value:  " +cookie);
		
		Map<String, String> cookies_values = res.getCookies();
		
		for(String k :cookies_values.keySet())
		{
			String cookies_vales = res.getCookie(k);
			System.out.println("cookie value:  " +cookies_vales);
			
		}
		
	}
	
	
	

}
