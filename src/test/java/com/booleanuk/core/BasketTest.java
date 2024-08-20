package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addBagel(bagel);
        Assertions.assertEquals(1, basket.size());
    }
}