package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    /* Test use case 1 */
    @Test
    public void testAddingItemToBasket(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.addItem("Coffee", "Black", 10));


    }

    /*  Test use case 2*/
    @Test
    public void testRemovingItemFromBasket(){
        Basket basket = new Basket();
        basket.addItem("Coffee", "Black", 1);
        Assertions.assertTrue(basket.removeItem("Coffee", "Black"));
    }
}
