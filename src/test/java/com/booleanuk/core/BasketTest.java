package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagelToBasket() {
        Basket basket = new Basket();
        Assertions.assertEquals("Product added to basket", basket.add("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testAddMultipleBagelsToBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLP"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLE"));
    }

    @Test
    public void testAddMultipleOffSameBagelToBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertEquals(3, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testAddNoneExistingBagelToBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket basket = new Basket();
        Assertions.assertEquals("Product not found", basket.add("AAAHHH"));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testRemoveMultipleBagelsFromBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertTrue(basket.remove("BGLP"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLP"));

    }

    @Test
    public void testRemoveMultipleOffSameBagelFromBasket() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertEquals(2, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testRemoveNoneExistingBagelFromBasket() {
        Basket basket = new Basket();
        Assertions.assertFalse(basket.remove("AAAHHH"));
    }

    @Test
    public void testRemoveBagelNotInBasket() {
        Basket basket = new Basket();
        Assertions.assertFalse(basket.remove("BGLO"));
    }

    @Test
    public void testSetBasketCapacity() {
        Basket basket = new Basket();
        Assertions.assertTrue(basket.setCapacity(3));
    }

    @Test
    public void testSetBasketCapacityAndAddMoreThanLimit() {
        Basket basket = new Basket();
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProducts() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProductsThenAdd() {
        Basket basket = new Basket();
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }
}