package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {


    @Test
    public void testAddItem() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item item = factory.createItem("BGLP");
        boolean successfullyAdded = basket.addItem(item); // add item
        Assertions.assertTrue(successfullyAdded);
    }


    @Test
    public void testRemoveItem() {

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
