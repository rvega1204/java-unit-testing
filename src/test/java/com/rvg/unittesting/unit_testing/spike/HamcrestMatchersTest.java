package com.rvg.unittesting.unit_testing.spike;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Hamcrest matchers.
 * This test demonstrates the usage of various Hamcrest matchers for assertions.
 */
public class HamcrestMatchersTest {

    /**
     * Demonstrates different Hamcrest matchers for asserting collections and
     * strings.
     * - Verifies the size, element conditions, and specific items in a list of
     * numbers.
     * - Verifies string assertions for containing, starting with, and ending with
     * specific substrings.
     */
    @Test
    public void learning() {
        // Hamcrest matchers on a list of numbers
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        assertThat(numbers, hasSize(3)); // Verifies the size of the list
        assertThat(numbers, everyItem(greaterThan(10))); // Verifies that every item is greater than 10
        assertThat(numbers, everyItem(lessThan(100))); // Verifies that every item is less than 100
        assertThat(numbers, hasItems(12, 45)); // Verifies that the list contains 12 and 45

        // Hamcrest matchers on strings
        assertThat("ABCDE", containsString("CD")); // Verifies that the string contains "CD"
        assertThat("ABCDE", startsWith("AB")); // Verifies that the string starts with "AB"
        assertThat("ABCDE", endsWith("DE")); // Verifies that the string ends with "DE"
    }
}
