package com.rvg.unittesting.unit_testing.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rvg.unittesting.unit_testing.data.ItemRespository;
import com.rvg.unittesting.unit_testing.model.Item;

@Component // Marks this class as a Spring component for automatic detection and management
public class ItemBusinessService {

    @Autowired // Automatically injects the ItemRespository dependency
    private ItemRespository itemRespository;

    /**
     * Returns a hardcoded Item object.
     * This method is useful for testing or as a default value.
     */
    public Item retriveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    /**
     * Retrieves all items from the database, calculates their value
     * (price * quantity), and returns the updated list.
     * 
     * @return List of Item objects with the calculated value.
     */
    public List<Item> retriveAllItems() {
        List<Item> items = itemRespository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity()); // Compute total value
        }

        return items;
    }
}
