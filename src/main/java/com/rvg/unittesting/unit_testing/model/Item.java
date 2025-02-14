package com.rvg.unittesting.unit_testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 * Entity class representing an Item.
 */
@Entity
public class Item {

    @Id // Marks this field as the primary key
    private int id;

    private String name;
    private int price;
    private int quantity;

    @Transient // This field will not be persisted in the database
    private int value;

    /**
     * Default constructor required for JPA.
     */
    public Item() {
    }

    /**
     * Parameterized constructor to initialize an Item.
     * 
     * @param id       the item ID
     * @param name     the item name
     * @param price    the item price
     * @param quantity the item quantity
     */
    public Item(int id, String name, int price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the item ID.
     * 
     * @return the item ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the item name.
     * 
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the item price.
     * 
     * @return the item price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the item quantity.
     * 
     * @return the item quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the computed value of the item (price * quantity).
     * 
     * @return the computed value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the computed value of the item.
     * 
     * @param value the computed value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the item.
     * 
     * @return a formatted string with item details
     */
    @Override
    public String toString() {
        return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
    }

    /**
     * Checks if two Item objects are equal based on their attributes.
     * 
     * @param obj the object to compare with
     * @return true if the items are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Item item = (Item) obj;
        return id == item.id && price == item.price && quantity == item.quantity && name.equals(item.name);
    }

    /**
     * Generates a hash code based on the item ID.
     * 
     * @return the hash code of the item
     */
    @Override
    public int hashCode() {
        return id;
    }
}
