package Basic;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;





public class JSONSchemaValidation {
	
	@Test
	void jsonschemavalidation()
	{
		given()
		.when()

		.get("https://reqres.in/api/users")
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
	
	}

}
