package Basic;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {
	
	
	@Test
	void testXMLResponse()
	{
		Response res =given()
				
		.when()
		.get(" ");
		XmlPath xmlobj = new XmlPath (res.asString());
		List <String> travellers = xmlobj.getList("TravelerinformationResponse.travellers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		List <String> travellers_names = xmlobj.getList("TravelerinformationResponse.travellers.Travelerinformation.name");
		
		boolean status = false;
		
		for(String travellersname:travellers_names)
		{
			if(travellersname.equals("Aman"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
	

}


