package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagelToBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        Assertions.assertTrue(basket.basketMap.containsKey("BGLO"));
    }

    @Test
    public void testAddMultipleBagelsToBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertTrue(basket.basketMap.containsKey("BGLO"));
        Assertions.assertTrue(basket.basketMap.containsKey("BGLP"));
        Assertions.assertTrue(basket.basketMap.containsKey("BGLE"));
    }

    @Test
    public void testAddNoneExistingBagelToBasket() {
        Basket basket = new Basket();
        Assertions.assertFalse(basket.add("AAAHHH"));
    }
}