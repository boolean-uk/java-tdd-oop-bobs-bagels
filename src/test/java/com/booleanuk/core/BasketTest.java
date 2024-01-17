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

    @Test
    public void testCapacityCheck() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("COFB");
        basket.add("COFW");

        Assertions.assertEquals(3,basket.basketList.size());
    }

    @Test
    public void testRemoveItem() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("COFB");

        Assertions.assertEquals(3, basket.basketList.size());
        Assertions.assertTrue(basket.remove("BGLP"));
        Assertions.assertEquals(2, basket.basketList.size());
    }
    @Test
    public void testRemoveFakeItem() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("COFB");

        Assertions.assertEquals(3, basket.basketList.size());
        Assertions.assertFalse(basket.remove("Carrot"));
        Assertions.assertEquals(3, basket.basketList.size());

    }
}
