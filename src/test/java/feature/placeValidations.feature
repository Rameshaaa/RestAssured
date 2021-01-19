Feature: Validating Place API's

Scenario: Verify place is added successfully using AddPlaceAPI
	Given Add Place payload
	When User calls "AddPlaceApi" with Post http request
	Then API call got success message with Status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"