package com.rvg.unittesting.unit_testing.spike;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit test for AssertJ assertions.
 * This test demonstrates the usage of various AssertJ assertions.
 */
public class AssertJTest {

    /**
     * Demonstrates different AssertJ assertions on collections and strings.
     * - Checks the size and contents of a list of numbers.
     * - Verifies that all elements in the list match a condition.
     * - Verifies string assertions for empty, containment, and case-insensitive
     * checks.
     */
    @Test
    public void learning() {
        // AssertJ assertions on a list of numbers
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        assertThat(numbers)
                .hasSize(3) // Verifies the size of the list
                .contains(12, 15) // Verifies that the list contains 12 and 15
                .allMatch(x -> x > 10) // Verifies that all elements are greater than 10
                .allMatch(x -> x < 100); // Verifies that all elements are less than 100

        // AssertJ assertions on strings
        assertThat("").isEmpty(); // Verifies that an empty string is empty
        assertThat("ABCDE")
                .contains("ABC") // Verifies that the string contains "ABC"
                .startsWithIgnoringCase("ab") // Verifies that the string starts with "ab" ignoring case
                .endsWith("E"); // Verifies that the string ends with "E"
    }
}
