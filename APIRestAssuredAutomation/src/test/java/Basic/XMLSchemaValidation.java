package Basic;

import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;
import static io.restassured.RestAssured.*;




public class XMLSchemaValidation {

	
	@Test
	void xmlschemavalidation()
	{
		given()
		.when()

		.get("https://mocktarget.apigee.net/xml")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
	
	}

}



