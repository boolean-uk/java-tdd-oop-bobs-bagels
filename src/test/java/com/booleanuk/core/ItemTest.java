package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testGetSKU() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        Assertions.assertEquals("ABC", item.getSku());
    }

    @Test
    public void testSetSKU() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        item.setSku("DEF");
        Assertions.assertEquals("DEF", item.getSku());
    }

    @Test
    public void testGetPrice() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        Assertions.assertEquals(0.50, item.getPrice());
    }

    @Test
    public void testSetPrice() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        item.setPrice(1.50);
        Assertions.assertEquals(1.50, item.getPrice());
    }

    @Test
    public void testGetName() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        Assertions.assertEquals("Bagel", item.getName());
    }

    @Test
    public void testSetName() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        item.setName("Coffee");
        Assertions.assertEquals("Coffee", item.getName());
    }

    @Test
    public void testGetType() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        Assertions.assertEquals("Sesame", item.getType());
    }

    @Test
    public void testSetType() {
        Item item = new Item("ABC", 0.50, "Bagel", "Sesame");
        item.setType("Plain");
        Assertions.assertEquals("Plain", item.getType());
    }

}
