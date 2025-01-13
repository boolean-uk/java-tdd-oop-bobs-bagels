package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testAddItem() {
        //Don't need to test for invalid items because they cannot be created according to the item factory tests
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        boolean successfullyAdded = basket.addItem(item); // add item
        Assertions.assertTrue(successfullyAdded);
    }

    @Test
    public void testAddingTooManyItems() {
        //Max capacity is 5, so adding should fail after 5 elements are present in the basket list
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        basket.addItem(item);
        basket.addItem(item);
        basket.addItem(item);
        basket.addItem(item);
        boolean successfullyAdded5 = basket.addItem(item);
        boolean successfullyAdded6 = basket.addItem(item);
        Assertions.assertTrue(successfullyAdded5);
        Assertions.assertFalse(successfullyAdded6);
    }

    @Test
    public void testRemoveItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        basket.addItem(item);
        boolean successfullyRemoved = basket.removeItem(item);
        Assertions.assertTrue(successfullyRemoved);
    }

    @Test
    public void testRemoveNonExistingItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP"); //Item never gets added to basket
        boolean successfullyRemoved = basket.removeItem(item);
        Assertions.assertFalse(successfullyRemoved);
    }

    @Test
    public void testChangeCapacity() {

    }

    @Test
    public void testCheckCost() {

    }

    @Test
    public void testAddFilling() {

    }

    @Test
    public void testGetBasket() {

    }
}
