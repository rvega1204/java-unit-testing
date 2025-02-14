package com.rvg.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * This class contains unit tests for mocking a List object using Mockito.
 * It demonstrates various mocking techniques such as returning fixed values,
 * handling multiple return values, and using parameterized return values.
 */
public class ListMockTest {

    // Mocking a List object
    @SuppressWarnings("unchecked")
    private List<String> listMock = mock(List.class);
    
    @Test
    public void size_basic() {
        // Mocking the size method to return 2
        when(listMock.size()).thenReturn(2);
        // Verifying that the size method returns 2
        assertEquals(2, listMock.size());
    }

    @Test
    public void multipleReturns() {
        // Mocking the size method to return 5 the first time and 10 the second time
        when(listMock.size()).thenReturn(5).thenReturn(10);
        // Verifying that the size method returns 5 the first time
        assertEquals(5, listMock.size());
        // Verifying that the size method returns 10 the second time
        assertEquals(10, listMock.size());
    }

    @Test
    public void returnWithParameters() {
        // Mocking the get method to return "rvg" when the index is 0
        when(listMock.get(0)).thenReturn("rvg");
        // Verifying that the get method returns "rvg" for index 0
        assertEquals("rvg", listMock.get(0));
        // Verifying that the get method returns null for any other index
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        // Mocking the get method to return "listMock" for any integer index
        when(listMock.get(anyInt())).thenReturn("listMock");
        // Verifying that the get method returns "listMock" for index 0
        assertEquals("listMock", listMock.get(0));
        // Verifying that the get method returns "listMock" for index 1
        assertEquals("listMock", listMock.get(1));
    }

    @Test
    public void verificationsBasics() {
        // Calling the get method with index 0
        listMock.get(0);

        // Verifying that the get method was called with index 0 exactly once
        verify(listMock, times(1)).get(0);
        
        // Verifying that the get method was called at least once
        verify(listMock, atLeast(1)).get(anyInt());
        verify(listMock, never()).get(2);
        
        verify(listMock).get(anyInt());
    }

    @Test
    public void argumentCapturing() {
        //SUT
        listMock.add("rvg");

        //Verification
        // ArgumentCaptor is used to capture the argument passed to the add method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Verifying that the add method was called with "rvg"
        verify(listMock).add(captor.capture());

        // Verifying that the argument passed to the add method is "rvg"
        assertEquals("rvg", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        listMock.add("rvg");
        listMock.add("test");

        //Verification
        // ArgumentCaptor is used to capture the argument passed to the add method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Verifying that the add method was called with "rvg" and "test"
        verify(listMock, times(2)).add(captor.capture());

        // Verifying that the arguments passed to the add method are "rvg" and "test"
        assertEquals("rvg", captor.getAllValues().get(0));
        assertEquals("test", captor.getAllValues().get(1));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void spying() {
        @SuppressWarnings("rawtypes")
        ArrayList arrayListSpy = spy(ArrayList.class);
        // Adding elements to the spy list
        arrayListSpy.add("rvg");
        arrayListSpy.add("test");

        // Verifying the size of the spy list
        assertEquals(2, arrayListSpy.size());

        // Overriding the size method to return 5
        when(arrayListSpy.size()).thenReturn(5);

        // Verifying that the size method returns 5
        assertEquals(5, arrayListSpy.size());

        // Verifying that the add method was called with "rvg" and "test"
        verify(arrayListSpy).add("rvg");
        verify(arrayListSpy).add("test");
    }

}
