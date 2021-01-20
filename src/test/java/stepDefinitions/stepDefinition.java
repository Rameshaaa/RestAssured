package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import pojo.AddPlace;
import pojo.Location;
import resources.APIresources;
import resources.Utils;
import testData.TestDataBuild;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@RunWith(Cucumber.class)
public class stepDefinition extends Utils {
	
		TestDataBuild ap =new TestDataBuild();
	
		RequestSpecification res;
		Response response;
		static String place_id;

		 @Given("^Add Place payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		    public void add_place_payload_with_something_something_something(String name, String language, String address) throws IOException
	   
	    {	   
		   res=given().spec(requestSpecification()).body(ap.AddPlacePayloadData(name, language, address));
  
	    }

		 @When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
		    public void user_calls_something_with_something_http_request(String resources, String method) throws Throwable {
		   
	    	APIresources AddplaceResource=APIresources.valueOf(resources);
	    	System.out.println(AddplaceResource.getresources());
	    	
	    	if(method.equalsIgnoreCase("POST"))
	    	response =res.when().post(AddplaceResource.getresources());
	    	else if(method.equalsIgnoreCase("GET"))
	    		response =res.when().get(AddplaceResource.getresources());
	    		
	    }

	    @Then("^API call got success message with Status code 200$")
	    public void api_call_got_success_message_with_status_code_200() throws Throwable {
	        assertEquals(response.getStatusCode(),200);
	    }

	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String KeyValue, String ExpectedValue) throws Throwable {
	           	
	    	System.out.println(KeyValue);
	    	System.out.println(ExpectedValue);
	    	assertEquals(getJSpath(response, KeyValue),ExpectedValue);
	    }
	    
	    @And("^verify place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	    public void verify_placeid_created_maps_to_something_using_something(String Expectedname, String resources) throws Throwable {
	      
	    	place_id=getJSpath(response, "place_id");
	    	System.out.println(place_id);
	    	 res=given().spec(requestSpecification()).queryParam("place_id", place_id);
	    	 user_calls_something_with_something_http_request(resources, "GET");
	    	 String Actualname=getJSpath(response, "name");
	    	 System.out.println(Actualname);
	    	 System.out.println(Expectedname);
	    	 assertEquals(Actualname,Expectedname );
	    }
	    
	    @Given("^DeletePlaceAPI payload$")
	    public void deleteplaceapi_payload() throws Throwable {
	    	 res=given().spec(requestSpecification()).body(ap.DeletePlaceAPI(place_id));
	    }

	}




