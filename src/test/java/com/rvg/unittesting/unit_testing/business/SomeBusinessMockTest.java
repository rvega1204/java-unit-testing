/**
 * Unit tests for the SomeBusinessImpl class using Mockito to mock the SomeDataService dependency.
 * 
 * This test class contains the following test cases:
 * 
 * 1. calculateSumUsingDataService_basic: Tests the calculateSumUsingDataService method with a basic set of data.
 * 2. calculateSumUsingDataService_empty: Tests the calculateSumUsingDataService method with an empty data set.
 * 3. calculateSumUsingDataService_oneValue: Tests the calculateSumUsingDataService method with a single value in the data set.
 * 4. calculateSumUsingDataService_negativeValues: Tests the calculateSumUsingDataService method with negative values in the data set.
 * 
 * The @ExtendWith(MockitoExtension.class) annotation is used to enable Mockito support.
 * The @InjectMocks annotation is used to create and inject the mock dependencies into the SomeBusinessImpl instance.
 * The @Mock annotation is used to create a mock instance of SomeDataService.
 */
package com.rvg.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rvg.unittesting.unit_testing.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;
    
    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
        assertEquals(5, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_negativeValues() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { -1, -2, -3 });
        assertEquals(-6, business.calculateSumUsingDataService());
    }
}
