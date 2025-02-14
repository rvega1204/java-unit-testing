package com.rvg.unittesting.unit_testing.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * This class contains unit tests for JSON assertions using the JSONAssert library.
 */
public class JsonAssertTest {

    /**
     * JSON string to be used in the tests.
     */
    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    /**
     * Tests JSON assertion with strict mode enabled.
     * The test will pass if the actual JSON string matches the expected JSON string exactly, including spaces.
     *
     * @throws JSONException if there is an error parsing the JSON strings.
     */
    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

    /**
     * Tests JSON assertion with strict mode disabled.
     * The test will pass if the actual JSON string contains all the fields in the expected JSON string, 
     * but may contain additional fields.
     *
     * @throws JSONException if there is an error parsing the JSON strings.
     */
    @Test
    public void jsonassert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }

    /**
     * Tests JSON assertion without escape characters.
     * The test will pass if the actual JSON string matches the expected JSON string exactly, 
     * including spaces, even if the expected JSON string does not have escape characters.
     *
     * @throws JSONException if there is an error parsing the JSON strings.
     */
    @Test
    public void jsonassert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1, name:Ball, price:10, quantity:100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

}
