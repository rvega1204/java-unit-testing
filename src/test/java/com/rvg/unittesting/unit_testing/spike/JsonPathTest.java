package com.rvg.unittesting.unit_testing.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit test for JsonPath usage.
 * This test demonstrates the usage of JsonPath for querying JSON responses.
 */
public class JsonPathTest {

    /**
     * Demonstrates how to parse and query JSON responses using JsonPath.
     * - Verifies the length of the JSON array.
     * - Retrieves and verifies specific elements based on JSON path queries.
     * - Verifies the existence of elements with specific properties.
     */
    @Test
    public void learning() {
        // Sample JSON response from a service
        String responseFromService = "[{\"id\": 1, \"name\": \"Item1\", \"quantity\": 10}, " +
                "{\"id\": 2, \"name\": \"Item2\", \"quantity\": 20}, " +
                "{\"id\": 3, \"name\": \"Item3\", \"quantity\": 30}]";

        // Read JSON response using JsonPath
        DocumentContext context = JsonPath.parse(responseFromService);

        // Verify the length of the JSON array
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        // Retrieve and verify all ids in the JSON response
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);

        // Query for items with specific quantity and name
        String quantityQuery = context.read("$.[?(@.quantity == 20)]").toString();
        String nameQuery = context.read("$.[?(@.name == 'Item3')]").toString();

        // Ensure that the queries return non-empty results
        assertThat(quantityQuery).isNotEmpty();
        assertThat(nameQuery).isNotEmpty();
    }
}
