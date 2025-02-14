package com.rvg.unittesting.unit_testing.business;

import java.util.Arrays;

import com.rvg.unittesting.unit_testing.data.SomeDataService;

/**
 * Business implementation class that performs calculations using provided data.
 */
public class SomeBusinessImpl {

    private SomeDataService someDataService;

    /**
     * Sets the data service dependency.
     * 
     * @param someDataService the service used to retrieve data
     */
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    /**
     * Calculates the sum of the given integer array using Java Streams.
     * 
     * @param data an array of integers
     * @return the sum of the elements, or 0 if the array is empty
     */
    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    /**
     * Retrieves data from SomeDataService and calculates the sum.
     * 
     * @return the sum of the retrieved data, or 0 if no data is available
     */
    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
