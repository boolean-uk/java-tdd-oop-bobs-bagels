package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketTest {

    @Test
    public void testAddToBasketWorks() {
        Basket basket = new Basket("BGLO", 2);

        assertTrue(basket.addToBasket("BGLO"));
        assertEquals(1, basket.itemBasket.size()); // check if it's added successfully
        assertTrue(basket.itemBasket.contains("BGLO")); // check if the correct bagel is in the basket
    }
}
