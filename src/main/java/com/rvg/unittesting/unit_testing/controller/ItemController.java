package com.rvg.unittesting.unit_testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvg.unittesting.unit_testing.business.ItemBusinessService;
import com.rvg.unittesting.unit_testing.model.Item;

/**
 * REST controller that handles HTTP requests related to items.
 */
@RestController
public class ItemController {

    @Autowired // Injects the ItemBusinessService dependency
    private ItemBusinessService businessService;

    /**
     * Returns a hardcoded Item object.
     * 
     * @return an Item with predefined values.
     */
    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    /**
     * Retrieves a hardcoded Item from the business service.
     * 
     * @return an Item object retrieved from the business logic.
     */
    @GetMapping("/item-form-business-service")
    public Item itemFromBusinessService() {
        return businessService.retriveHardcodedItem();
    }

    /**
     * Retrieves all items from the database.
     * 
     * @return a list of Item objects retrieved from the database.
     */
    @GetMapping("/all-items-from-database")
    public List<Item> retriveallItems() {
        return businessService.retriveAllItems();
    }
}
