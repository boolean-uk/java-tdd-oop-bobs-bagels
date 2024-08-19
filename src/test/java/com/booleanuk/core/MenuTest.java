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

public class MenuTest {
    @Test
    public void testGetItemPrice(){
        Menu menu = new Menu();

        Assertions.assertEquals(0.49f, getItemPrice("BGLO"));
    }
}
