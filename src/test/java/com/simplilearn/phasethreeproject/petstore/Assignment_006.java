package com.simplilearn.phasethreeproject.petstore;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Assignment_006 {

    @Test
    public void testLogoutAPI() {
        String baseURL = "https://petstore.swagger.io/v2/user/logout";

        // Hit the GET call
        Response response = when().get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate the response message is "OK"
        response.then().assertThat().body("message", equalTo("ok"));
    }
}

