package com.booleanuk.core;
/*
    @Test
    public void testAddBagel(){
        Basket basket = new Basket();
        // Test if valid bagel is added to basket
        Assertions.assertEquals("Bagel added to basket.", basket.addBagel("Sesame"));
        Assertions.assertEquals("Bagel added to basket.", basket.addBagel("Oat"));
        // Test if invalid bagel is not added to basket
        Assertions.assertEquals("This bagel is not on the menu.", basket.addBagel("Totally not a bagel."));
    }
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddItem(){
        Basket basket = new Basket();

        Assertions.assertEquals("2 Onion Bagel added to basket.", basket.addItem("BGLO", 2));
        Assertions.assertEquals("1 Plain Bagel added to basket.", basket.addItem("BGLP", 1));
        Assertions.assertEquals("This item is not on the menu.", basket.addItem("WRONG", 1));
        Assertions.assertEquals(3, basket.basketItems.size());
    }

    @Test
    public void testRemoveItem(){
        Basket basket = new Basket();

        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);
        Assertions.assertEquals("Plain Bagel removed from basket.", basket.removeItem("BGLP", false));
        Assertions.assertEquals(2, basket.basketItems.size());
        Assertions.assertEquals("2 Onion Bagels removed from basket.", basket.removeItem("BGLO", true));
        Assertions.assertEquals(0, basket.basketItems.size());
    }

    @Test
    public void testSumOrder(){
        Basket basket = new Basket();

        Assertions.assertEquals("Your basket is empty.", basket.sumOrder());
        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 1);

        Assertions.assertEquals("The sum of your order is: 1.37", basket.sumOrder());
    }

    @Test
    public void testSetBasketSize(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.setBasketSize(10));
        Assertions.assertFalse(basket.setBasketSize(-2));
    }
}
