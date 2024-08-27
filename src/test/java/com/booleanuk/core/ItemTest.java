package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemGetters() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        Assertions.assertEquals("BGLO", bagel.getSku());
        Assertions.assertEquals(0.49, bagel.getPrice());
        Assertions.assertEquals("Bagel", bagel.getName());

    }

    @Test
    public void testAddItem2() {
        Basket basket = new Basket(2, new Inventory());
        Bagel bagel1 = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addItem(bagel1);
        Assertions.assertTrue(basket.listOfBasket.contains(bagel1));
    }


    @Test
    public void testAddCoffee2() {
        Basket basket = new Basket(2, new Inventory());
        Coffee coffee = new Coffee("COFC", 1.29, "Coffee", "Capuccino");
        basket.addItem(coffee);
        Assertions.assertTrue(basket.listOfBasket.contains(coffee));
    }

    @Test
    public void testCoffeeAttributes() {
        Coffee coffee = new Coffee("COFB", 0.99, "Coffee", "Black");
        Assertions.assertEquals("COFB", coffee.getSku());
        Assertions.assertEquals(0.99, coffee.getPrice());
        Assertions.assertEquals("Coffee", coffee.getName());
        Assertions.assertEquals("Black", coffee.getCoffeeType());
    }
}
