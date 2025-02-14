package com.rvg.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rvg.unittesting.unit_testing.data.ItemRespository;
import com.rvg.unittesting.unit_testing.model.Item;

/**
 * Unit test class for {@link ItemBusinessService} using Mockito.
 */
@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks // Injects the mocked dependencies into the business service
    private ItemBusinessService business;

    @Mock // Creates a mock instance of ItemRepository
    private ItemRespository respository;

    /**
     * Tests the {@code retriveAllItems()} method to ensure it correctly calculates
     * item values.
     * It mocks the repository response and verifies that the computed value is
     * correct.
     */
    @Test
    public void retriveAllItems_basic() {
        // Mocking repository response
        when(respository.findAll()).thenReturn(Arrays.asList(
                new Item(2, "Item2", 5, 30), // Expected value: 5 * 30 = 150
                new Item(3, "Item3", 20, 100) // Expected value: 20 * 100 = 2000
        ));

        // Calling the service method
        List<Item> items = business.retriveAllItems();

        // Verifying the computed values
        assertEquals(150, items.get(0).getValue());
        assertEquals(2000, items.get(1).getValue());
    }
}
