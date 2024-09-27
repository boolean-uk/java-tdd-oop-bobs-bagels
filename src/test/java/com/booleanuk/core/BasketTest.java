package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void testAddToBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
    }

    @Test
    public void testAddToBasketFails() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 1);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
        assertFalse(basket.addToBasket(itemBGLP));
        assertEquals(1, basket.getItemBasket().size());

    }

    @Test
    public void testRemoveFromBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 1);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.removeFromBasket(itemBGLO));
        assertEquals(0, basket.getItemBasket().size());
    }

    @Test
    public void testRemoveFromBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertFalse(basket.removeFromBasket(itemBGLP));
        assertEquals(1, basket.getItemBasket().size());
    }
    
    @Test
    public void testChangeBasketSize() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory,1);
        
        assertTrue(basket.addToBasketSize(1));
        assertEquals(2, basket.getBasketSize());

        assertFalse(basket.addToBasketSize(-2));
        assertEquals(2, basket.getBasketSize());

    }

    @Test
    public void testGetTotalCost() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem itemBGLP = new Bagel("BGLP", 0.39, "Bagel", "Plain");

        assertTrue(basket.addToBasket(itemBGLO));
        assertTrue(basket.addToBasket(itemBGLP));
        assertEquals(2, basket.getItemBasket().size());

        double expectedCost = itemBGLO.getPrice() +itemBGLP.getPrice();
        assertEquals(expectedCost, basket.getTotalCost());

    }

    @Test
    //this works because of the addToBasket method, it may need to change when the items are separate?
    public void testAddBagelFillingWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem itemFILH = new BagelFilling("FILH", 0.12, "Filling", "Ham");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
        assertTrue(basket.addToBasket(itemFILH));
        assertEquals(2, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemFILH));
    }
}
