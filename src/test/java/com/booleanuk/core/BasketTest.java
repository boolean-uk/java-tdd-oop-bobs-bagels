package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItem() {
        Basket basket = new Basket();
        String bagel = "BGLO";

        Assertions.assertTrue(basket.addItem(bagel));
    }

    @Test
    public void testAddingFake() {
        Basket basket = new Basket();

        Assertions.assertFalse(basket.addItem("Carrot"));
    }

    @Test
    public void testCapacityCheck() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");
        basket.addItem("COFW");

        Assertions.assertEquals(3,basket.basketList.size());
    }

    @Test
    public void testRemoveItem() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");

        Assertions.assertEquals(3, basket.basketList.size());
        Assertions.assertTrue(basket.remove("BGLP"));
        Assertions.assertEquals(2, basket.basketList.size());
    }
    @Test
    public void testRemoveFakeItem() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");

        Assertions.assertEquals(3, basket.basketList.size());
        Assertions.assertFalse(basket.remove("Carrot"));
        Assertions.assertEquals(3, basket.basketList.size());

    }

    @Test
    public void testTotalPrice() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");

        Assertions.assertEquals(1.87, basket.totalCost());
    }

    @Test
    public void testChangeCapacity() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");

        Assertions.assertEquals("[BGLO, BGLP]", basket.changeCapacity(2));
        Assertions.assertEquals(2,basket.basketList.size());
        basket.addItem("COFB");
        Assertions.assertEquals(2,basket.basketList.size());

    }

    @Test
    public void testCheckPrice() {
        Basket basket = new Basket();

        Assertions.assertEquals(0.39,basket.checkPrice("BGLP"));
    }

    @Test
    public void testChechPriceFakeItem() {
        Basket basket = new Basket();

        Assertions.assertEquals(0.0, basket.checkPrice("Apple"));
    }

    @Test
    public void testAddFilling() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        Assertions.assertEquals("[BGLO, FILE, BGLP]",basket.addFilling("BGLO", "FILE"));
    }
}
