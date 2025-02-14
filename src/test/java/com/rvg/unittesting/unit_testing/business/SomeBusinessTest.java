/**
 * Unit tests for the SomeBusinessImpl class.
 */
package com.rvg.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test class for {@link SomeBusinessImpl}.
 * Tests different scenarios for the {@code calculateSum()} method.
 */
public class SomeBusinessTest {

    // Instance of the business logic class being tested
    SomeBusinessImpl business = new SomeBusinessImpl();

    /**
     * Tests {@code calculateSum()} with a basic input of multiple positive
     * integers.
     * Expected sum: 1 + 2 + 3 = 6.
     */
    @Test
    public void calculateSum_basic() {
        int actualResult = business.calculateSum(new int[] { 1, 2, 3 });
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests {@code calculateSum()} with an empty array.
     * Expected sum: 0.
     */
    @Test
    public void calculateSum_empty() {
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests {@code calculateSum()} with an array containing a single value.
     * Expected sum: 5.
     */
    @Test
    public void calculateSum_oneValue() {
        int actualResult = business.calculateSum(new int[] { 5 });
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests {@code calculateSum()} with an array of negative integers.
     * Expected sum: -1 + (-2) + (-3) = -6.
     */
    @Test
    public void calculateSum_negativeValues() {
        int actualResult = business.calculateSum(new int[] { -1, -2, -3 });
        int expectedResult = -6;
        assertEquals(expectedResult, actualResult);
    }
}
