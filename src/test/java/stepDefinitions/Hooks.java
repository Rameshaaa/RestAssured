package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable
	{
		
		if(stepDefinition.place_id==null)
		{
			
		
		stepDefinition sd= new stepDefinition();
		sd.add_place_payload_with_something_something_something("ramesh", "Tamil", "Chennai");
		sd.user_calls_something_with_something_http_request("AddPlaceApi", "POST");
		sd.verify_placeid_created_maps_to_something_using_something("ramesh", "getPlaceApi");
		}
		
	}

}
