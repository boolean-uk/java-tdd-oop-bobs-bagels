package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketTest {
    @Test
    public void testAddingBagelToBasket() {
        Basket basket = new Basket();

        assertTrue(basket.add(new Bagel(Bagel.BagelType.PLAIN)));
    }

    @Test
    public void testRemovingBagelFromBasket() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel(Bagel.BagelType.PLAIN);
        basket.add(bagel);

        assertTrue(basket.remove(bagel.getId()));
    }
}
