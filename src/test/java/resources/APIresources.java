package resources;

public enum APIresources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	
	private String resources;
	
	APIresources(String resources)
	{
		this.resources=resources;
	}
	
	public String getresources()
	{
		return resources;
	}

}
