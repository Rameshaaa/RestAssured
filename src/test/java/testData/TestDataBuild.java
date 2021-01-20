package testData;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayloadData(String Name, String Language, String Address)
	
	{
		AddPlace ap = new AddPlace();
		   ap.setAccuracy(50);
		   ap.setAddress(Address);
		   ap.setLanguage(Language);
		   ap.setPhone_number("(+91) 983 893 3937");
		   ap.setWebsite("https://rahulshettyacademy.com");
		   ap.setName(Name);
		   
		   List<String> mylist = new ArrayList<String>();
		   mylist.add("Shoe park");
		   mylist.add("shop");		   
		   ap.setTypes(mylist);
		   
		   Location l =new Location();
		   l.setLat(-38.383494);
		   l.setLng(33.427362);
		   ap.setLocation(l);
		   
		   return ap;
	}
	
	public String DeletePlaceAPI(String placeid)
	{
		return "{\r\n" + 
				"    \"place_id\":\""+placeid+"\"   	 \r\n" + 
				"}\r\n" + 
				"";
		
		
	}
}
