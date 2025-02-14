package com.rvg.unittesting.unit_testing.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Integration test for {@link ItemController}.
 * It uses {@code SpringBootTest} to start the application context and perform
 * HTTP requests.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate; // Used for making HTTP requests to the application

    private String response = "";

    /**
     * Tests if the application context loads correctly.
     * This test calls the endpoint {@code /all-items-from-database} and verifies
     * the response contains expected item IDs.
     * 
     * @throws JSONException if JSON parsing fails
     */
    @Test
    public void contextLoads() throws JSONException {
        response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:1}, {id:2}, {id:3}]", response, false);
    }

    /**
     * Tests if the {@code /all-items-from-database} endpoint returns the correct
     * product names.
     * 
     * @throws JSONException if JSON parsing fails
     */
    @Test
    public void getProductName_basic() throws JSONException {
        response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{name:ProductA}, {name:ProductB}, {name:ProductC}]", response, false);
    }
}