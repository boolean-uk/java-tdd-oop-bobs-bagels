package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddingBagel() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.add(new Bagel(Bagel.BagelType.PLAIN)));
    }
}
