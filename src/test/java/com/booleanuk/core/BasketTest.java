package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    public void addBagelToBasket(){
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add("plain"));
        Assertions.assertFalse(basket.add(""));
    }

    @Test
    public void testTryRemoveBagelFromList(){
        Basket basket = new Basket();
        basket.add("plain");
        basket.add("onion");
        Assertions.assertEquals(1, basket.basket.size());
        Assertions.assertTrue(basket.remove("onion"));
        Assertions.assertEquals(0, basket.basket.size());
    }
}
