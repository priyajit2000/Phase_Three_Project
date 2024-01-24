package com.simplilearn.phasethreeproject.petstore;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Assignment_002 {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";

    // HashMap to store environment-specific status values
    private static final HashMap<String, String> statusMap = new HashMap<>();

    static {
        statusMap.put("DEV", "available_DEV");
        statusMap.put("QA", "available_QA");
        statusMap.put("PROD", "available_PROD");
    }

    @Test
    @Parameters("env")
    public void putCallTesting(String env) {
        // Get the status value based on the environment
        String statusValue = statusMap.get(env);

        // PUT Call request JSON body
        String requestBody = "{\n" +
                "  \"id\": 20021,\n" +
                "  \"status\": \"" + statusValue + "\"\n" +
                "}";

        // Perform PUT call
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(BASE_URL);

        // Validate response code
        response.then().statusCode(200);

        // Validate id in the response
        response.then().body("id", equalTo(20021));

        // Validate status value in the response
        response.then().body("status", equalTo(statusValue));
    }
}

