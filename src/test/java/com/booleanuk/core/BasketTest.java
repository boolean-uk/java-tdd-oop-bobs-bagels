package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
    @Test
    public void addingBagelToBasketReturnsTrue() {
        Basket basket = new Basket();

        Assertions.assertTrue(basket.add("Plain bagel"));
    }

    @Test
    public void removingBagelToBasketReturnsTrue() {
        Basket basket = new Basket();

        basket.add("Plain bagel");

        Assertions.assertTrue(basket.remove("Plain bagel"));
    }

    @Test
    public void returnsTrueIfBasketIsFull() {
        Basket basket = new Basket();

        basket.add("Plain bagel");
        Assertions.assertFalse(basket.isFull());

        basket.add("Egg bagel");
        Assertions.assertTrue(basket.isFull());

        basket.add("Sourdough bagel");
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    public void testExpandingBasketCapacity() {
        Basket basket = new Basket();

        Assertions.assertEquals(2, basket.getCapacity());

        basket.modifyCapacity(5);

        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void testRemovingNonExistentItem() {
        Basket basket = new Basket();

        basket.add("Egg bagel");

        Assertions.assertFalse(basket.remove("Plain bagel"));
    }
}
