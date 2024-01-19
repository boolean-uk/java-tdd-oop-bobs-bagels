package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagelToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals("Product added to basket", basket.add("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testAddMultipleBagelsToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLP"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLE"));
    }

    @Test
    public void testAddMultipleOffSameBagelToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertEquals(3, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testAddNoneExistingBagelToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testAddBagelToFullBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals("Product not found", basket.add("AAAHHH"));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLO"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testRemoveMultipleBagelsFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLP"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLP"));

    }

    @Test
    public void testRemoveMultipleOffSameBagelFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLO"));
        Assertions.assertEquals(2, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testRemoveNoneExistingBagelFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals("Product is not in basket", basket.remove("AAAHHH"));
    }

    @Test
    public void testRemoveBagelNotInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals("Product is not in basket", basket.remove("BGLO"));
    }

    @Test
    public void testSetBasketCapacity() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertTrue(basket.setCapacity(3));
    }

    @Test
    public void testSetBasketCapacityAndAddMoreThanLimit() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProducts() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProductsThenAdd() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testGetTotalCostForBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLP");
        Assertions.assertEquals(0.49+0.49+0.39, basket.totalCost());
    }

    @Test
    public void testGetTotalCostForEmptyBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals(0, basket.totalCost());
    }

    @Test
    public void testAddFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        Assertions.assertEquals("Filling added", basket.addFilling("FILB"));
    }

    @Test
    public void testAddFillingWithNoBagelInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals("You need to add a bagel to your basket", basket.addFilling("FILB"));
    }

    @Test
    public void testAddNoneExistingFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        Assertions.assertEquals("Filling was not found", basket.addFilling("AAHHHH"));
    }

    @Test
    public void testAddProductThatIsNotFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.add("BGLO");
        Assertions.assertEquals("Product needs to be a filling", basket.addFilling("COFB"));
    }
}