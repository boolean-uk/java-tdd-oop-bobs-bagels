package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add(new Item("Bagel", "Plain")));
        Assertions.assertEquals(1, basket.items.size());
    }

    @Test
    public void testAddItemFailReachedMaxCapacity() {
        Basket basket = new Basket();
        basket.add(new Item("Bagel", "Sesame"));
        basket.add(new Item("Coffee", "Black"));
        basket.add(new Item("Filling", "Egg"));
        Assertions.assertFalse(basket.add(new Item("Bagel", "Plain")));
    }

    @Test
    public void testAddItemFailNotExistInInventory(){
        Basket basket = new Basket();
        Assertions.assertFalse(basket.add(new Item("Sandwich", "Plain")));
    }

    @Test
    public void testRemoveItemSuccess() {
        Basket basket = new Basket();
        basket.add(new Item("Bagel", "Sesame"));
        basket.add(new Item("Coffee", "Black"));
        Assertions.assertTrue(basket.remove(new Item("Bagel", "Sesame")));
    }
}
