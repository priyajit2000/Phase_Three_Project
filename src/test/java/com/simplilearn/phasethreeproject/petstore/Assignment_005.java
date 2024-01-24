package com.simplilearn.phasethreeproject.petstore;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Assignment_005 {

    @Test
    public void testFindByStatusAvailable() {
        String baseURL = "https://petstore.swagger.io/v2/pet/findByStatus";

        // Hit the GET call with status = available
        Response response = given()
                .param("status", "available")
                .when()
                .get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate each pet's status is available
        response.then().assertThat().body("status", everyItem(equalTo("available")));
    }

    @Test
    public void testFindByStatusPending() {
        String baseURL = "https://petstore.swagger.io/v2/pet/findByStatus";

        // Hit the GET call with status = pending
        Response response = given()
                .param("status", "pending")
                .when()
                .get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate each pet's status is pending
        response.then().assertThat().body("status", everyItem(equalTo("pending")));
    }

    @Test
    public void testFindByStatusSold() {
        String baseURL = "https://petstore.swagger.io/v2/pet/findByStatus";

        // Hit the GET call with status = sold
        Response response = given()
                .param("status", "sold")
                .when()
                .get(baseURL);

        // Validate the response code is 200
        response.then().assertThat().statusCode(200);

        // Validate each pet's status is sold
        response.then().assertThat().body("status", everyItem(equalTo("sold")));
    }
}

