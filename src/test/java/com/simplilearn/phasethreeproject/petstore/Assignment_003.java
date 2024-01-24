package com.simplilearn.phasethreeproject.petstore;



import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Assignment_003 {

    @Test
    public void testGetUserDetails() {
        String baseURL = "https://petstore.swagger.io/v2/user/Uname001";

        // Hit the GET call
        Response response = when().get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate username, email, and userStatus in the JSON response
        response.then()
                .assertThat().body("username", equalTo("Uname001"))
                .assertThat().body("email", equalTo("Positive@Attitude.com"))
                .assertThat().body("userStatus", equalTo(1));
    }
}

