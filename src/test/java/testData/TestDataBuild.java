package testData;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayloadData()
	
	{
		AddPlace ap = new AddPlace();
		   ap.setAccuracy(50);
		   ap.setAddress("29, side layout, cohen 09");
		   ap.setLanguage("French-IN");
		   ap.setPhone_number("(+91) 983 893 3937");
		   ap.setWebsite("https://rahulshettyacademy.com");
		   ap.setName("Frontline house");
		   
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
}
