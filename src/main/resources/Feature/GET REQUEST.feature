

Feature: Testing GET API with REST Assured

  Scenario: Verify the response of a GET request
    Given the API base URI is "https://petstore.swagger.io/v2/pet/2003"
    When a GET request is made to "/v2/pet/2"
    Then the response status code should be 200
    And the response should contain the user details

