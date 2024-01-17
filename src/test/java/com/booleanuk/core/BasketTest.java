package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItem() {
        Basket basket = new Basket();
        String bagel = "BGLO";

        Assertions.assertTrue(basket.add(bagel));
    }

    @Test
    public void testAddingFake() {
        Basket basket = new Basket();

        Assertions.assertFalse(basket.add("Carrot"));
    }

}
