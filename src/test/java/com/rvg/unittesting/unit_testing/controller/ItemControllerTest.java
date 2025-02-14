package com.rvg.unittesting.unit_testing.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rvg.unittesting.unit_testing.business.ItemBusinessService;
import com.rvg.unittesting.unit_testing.model.Item;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

/**
 * Test class for ItemController.
 * This class contains unit tests for the ItemController using MockMvc.
 */
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    /**
     * MockMvc instance used to perform HTTP requests and verify responses.
     */
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    /**
     * Test method for the /dummy-item endpoint.
     * This test performs a GET request to /dummy-item and verifies that the response status is OK
     * and the response content matches the expected JSON.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    public void dummyItem_basic() throws Exception {
        // Perform GET request to /dummy-item and expect JSON response
        mockMvc.perform(get("/dummy-item"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }


    /**
     * Test method for the /item-form-business-service endpoint
     * @throws Exception if an error occurs during the request
     */
    @Test
    public void itemFromBusinessService_basic() throws Exception {
        when(businessService.retriveHardcodedItem()).thenReturn(new Item(2, "Item2", 5, 20));

        // Perform GET request to /item-form-business-service and expect JSON response
        mockMvc.perform(get("/item-form-business-service"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Item2\",\"price\":5,\"quantity\":20}"))
                .andReturn();
    }

    @Test
    public void retriveAllItems_basic() throws Exception {
        when(businessService.retriveAllItems()).thenReturn(
            Arrays.asList(new Item(2, "Item2", 5, 30),
            new Item(3, "Item3", 20, 100))
        );

        mockMvc.perform(get("/all-items-from-database"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:5}]"))
        .andReturn();
    }
}
