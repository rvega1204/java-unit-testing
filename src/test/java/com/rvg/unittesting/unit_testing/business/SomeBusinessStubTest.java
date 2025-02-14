package com.rvg.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rvg.unittesting.unit_testing.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { 1, 2, 3 };
    }
}

/**
 * Unit tests for the SomeBusinessImpl class using stubs.
 */
public class SomeBusinessStubTest {

    SomeBusinessImpl business = new SomeBusinessImpl();

    /**
     * Test case for calculateSumUsingDataService method with basic input.
     * Uses a stub implementation of SomeDataService.
     * Expected result is the sum of the array elements.
     */
    @Test
    public void calculateSumUsingDataService_basic() {
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test case for calculateSumUsingDataService method with an empty array.
     * Uses an anonymous inner class to provide the stub implementation.
     * Expected result is 0.
     */
    @Test
    public void calculateSumUsingDataService_empty() {
        business.setSomeDataService(new SomeDataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[] {};
            }
        });
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test case for calculateSumUsingDataService method with a single value in the array.
     * Uses an anonymous inner class to provide the stub implementation.
     * Expected result is the single value itself.
     */
    @Test
    public void calculateSumUsingDataService_oneValue() {
        business.setSomeDataService(new SomeDataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[] { 5 };
            }
        });
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test case for calculateSumUsingDataService method with negative values in the array.
     * Uses an anonymous inner class to provide the stub implementation.
     * Expected result is the sum of the negative values.
     */
    @Test
    public void calculateSumUsingDataService_negativeValues() {
        business.setSomeDataService(new SomeDataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[] { -1, -2, -3 };
            }
        });
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = -6;
        assertEquals(expectedResult, actualResult);
    }
}
