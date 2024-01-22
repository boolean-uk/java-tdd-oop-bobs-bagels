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
        Assertions.assertTrue(basket.removeItem("BGLP"));
        Assertions.assertEquals(2, basket.basketList.size());
    }
    @Test
    public void testRemoveFakeItem() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");

        Assertions.assertEquals(3, basket.basketList.size());
        Assertions.assertFalse(basket.removeItem("Carrot"));
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
    public void testCapacityBeforeAdd() {
        Basket basket = new Basket();
        basket.changeCapacity(5);
        Assertions.assertEquals(5,basket.capacity);
    }

    @Test
    public void testCheckPrice() {
        Basket basket = new Basket();

        Assertions.assertEquals(0.39,basket.checkPrice("BGLP"));
    }

    @Test
    public void testCheckPriceFilling() {
        Basket basket = new Basket();

        Assertions.assertEquals(0.12, basket.checkPrice("FILE"));
    }


    @Test
    public void testCheckPriceFakeItem() {
        Basket basket = new Basket();

        Assertions.assertEquals(0.0, basket.checkPrice("Apple"));
    }

    @Test
    public void testAddFillingToBagel() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        Assertions.assertEquals("[BGLO, FILE, BGLP]",basket.addFilling("BGLO", "FILE"));
    }

    @Test
    public void testAddFillingToBagel2() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        Assertions.assertEquals("[BGLO, BGLP, FILE]",basket.addFilling("BGLP", "FILE"));
    }
    @Test
    public void testAddMoreFillingToBagel() {
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("COFB");
        basket.addFilling("BGLO","FILC");
        basket.addFilling("BGLO","FILX");
        basket.addFilling("BGLP","FILX");
        Assertions.assertEquals("[BGLO, FILE, FILX, FILC, BGLP, FILX, COFB]",basket.addFilling("BGLO", "FILE"));
    }
}
