package com.simplilearn.phasethreeproject.petstore;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class Assignment_004 {

    @Test
    public void testLoginAPI() {
        // Base URL for the Pet Store API
        String baseURL = "https://petstore.swagger.io/v2/user/login";

        // Username and password for basic authentication
        String username = "Uname001";
        String password = "@tt!tude";

        // Hit the GET call with basic authentication
        Response response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate the response message contains the expected text
        response.then().assertThat().body("message", containsString("logged in user session"));
    }
}

