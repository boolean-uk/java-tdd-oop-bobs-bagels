package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add(new Item("Bagel", "Plain")));
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
}
