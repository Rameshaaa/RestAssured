package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification req;
	ResponseSpecification resspec;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		 if(req==null)
		 {
			 PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req =new RequestSpecBuilder().setBaseUri(getGlobalProperty()).addQueryParam("key", "qaclick123")
					 .addFilter(RequestLoggingFilter.logRequestTo(log))
					 .addFilter(ResponseLoggingFilter.logResponseTo(log))
					   .setContentType(ContentType.JSON).build();
					return req;
		 }
		 return req;
	}
	
	public ResponseSpecification responseSpecification()
	{
		
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 return resspec;
	}
	
	public String getGlobalProperty() throws IOException
	
	{
		Properties prop;
		FileInputStream fis;
		
		prop = new Properties();
		fis = new FileInputStream("C:\\SeleniumWebDriver\\RESTAssured\\APIAutomation\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		String key = prop.getProperty("Endpoint");
		
		return key;
		
	}
	
	public String getJSpath(Response response, String key)
	{
		
		String resp = response.asString();    	
    	JsonPath js = new JsonPath(resp);
    	return js.get(key).toString();
	}
	
	
	
	
	
	
	
	

}
