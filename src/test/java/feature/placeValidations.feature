Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify place is added successfully using AddPlaceAPI
	Given Add Place payload with "<Name>" "<Language>" "<Address>"
	When User calls "AddPlaceApi" with "Post" http request
	Then API call got success message with Status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<Name>" using "getPlaceApi"
	
Examples:
|Name	  |Language		|Address		|
|AA House |Tamil		|Paris Corner	|

@DeletePlace
Scenario: Verify if Deleteplace API is working
	Given DeletePlaceAPI payload
	When User calls "deletePlaceApi" with "Post" http request
	Then API call got success message with Status code 200
	And "status" in response body is "OK"