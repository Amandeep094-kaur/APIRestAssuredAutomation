package Basic;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserilization {
	
	//java--to Json--- Serilization
	
	@Test(priority=1)
	void convertJava2json() throws JsonProcessingException
	{
		HashMap<String, String> data = new HashMap <String, String>();
		data.put("name","ram");
		data.put("job", "plumber");
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsondata);

}
	
	
	//json--to Java--- deSerilization
	@Test(priority=1)
	void convertJson2java() throws JsonProcessingException
	{
	
	String jsondata = "{\r\n"
			+ "  \"name\" : \"ram\",\r\n"
			+ "  \"job\" : \"plumber\"\r\n"
			+ "}";
	ObjectMapper objmapper = new ObjectMapper();
	
//	Student stu = objmapper.readValue(jsondata, data.class);
}
	
}