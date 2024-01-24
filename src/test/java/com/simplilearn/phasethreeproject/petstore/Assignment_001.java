package com.simplilearn.phasethreeproject.petstore;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Assignment_001 {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";

    @Test
    public void testGetRequest() {
        // Perform GET call
        Response response = given()
                .get(BASE_URL);

        // Validate response code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Expected status code 200, but found " + statusCode);

    }
}
