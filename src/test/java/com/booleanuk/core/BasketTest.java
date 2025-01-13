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
        Assertions.assertEquals(item, basket.getBasket().getFirst());
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
        //check if 6 elements were added despite the max capacity being 5
        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> basket.getBasket().get(5));
    }

    @Test
    public void testRemoveItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        basket.addItem(item);
        boolean successfullyRemoved = basket.removeItem(item);
        Assertions.assertTrue(successfullyRemoved);
        Assertions.assertFalse(basket.getBasket().contains(item));
    }

    @Test
    public void testRemoveNonExistingItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item1 = factory.createItem("BGLO");
        basket.addItem(item1);
        Item item2 = factory.createItem("BGLP"); //Item2 never gets added to basket
        boolean successfullyRemoved = basket.removeItem(item2);
        Assertions.assertFalse(successfullyRemoved);
        Assertions.assertEquals(1, basket.getBasket().size()); //Check if the basket still holds the items it should

    }

    @Test
    public void testChangeCapacity() {
        Basket basket = new Basket(); //basket has capacity of 5 by default
        basket.changeCapacity(7);
        Assertions.assertEquals(7, basket.getMaxCapacity());
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
