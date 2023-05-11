package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItemSucces() {
        Basket basket = new Basket();
        Item order = new Item("Bagel", "Plain");
        Assertions.assertTrue(basket.add(order));
    }
}
