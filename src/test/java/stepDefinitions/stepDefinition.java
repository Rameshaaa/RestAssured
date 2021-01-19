package stepDefinitions;

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

	    @Given("^Add Place payload$")
	    public void add_place_payload() throws Throwable 
	   
	    {	   
		   res=given().spec(requestSpecification()).body(ap.AddPlacePayloadData());
  
	    }

	    @When("^User calls \"([^\"]*)\" with Post http request$")
	    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
	    	
	    	response =res.when().post("/maps/api/place/add/json").
					   then().spec(responseSpecification()).extract().response();
	    }

	    @Then("^API call got success message with Status code 200$")
	    public void api_call_got_success_message_with_status_code_200() throws Throwable {
	        assertEquals(response.getStatusCode(),200);
	    }

	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String KeyValue, String ExpectedValue) throws Throwable {
	        
	    	String resp = response.asString();
	    	System.out.println(resp+"output AT 81 LINE");
	    	JsonPath js = new JsonPath(resp);
	    	System.out.println(js.get(KeyValue).toString());
	    	assertEquals(js.get(KeyValue).toString(),ExpectedValue);
	    }

	}




