package com.rvg.unittesting.unit_testing.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.rvg.unittesting.unit_testing.model.Item;

/**
 * Unit test for {@link ItemRespository}.
 * This test ensures that the repository can retrieve all items from the
 * database.
 */
@DataJpaTest
public class ItemRespositoryTest {

    @Autowired
    private ItemRespository respository; // Repository being tested

    /**
     * Tests the {@code findAll()} method to ensure it retrieves the expected number
     * of items from the database.
     * Expected result: 3 items.
     */
    @Test
    public void testFindAll() {
        List<Item> items = respository.findAll();
        assertEquals(3, items.size());
    }
}
