package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void testAddToBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new InventoryItem("BGLO", 0.49, "Bagel", "Onion");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
    }

    @Test
    public void testAddToBasketFails() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 1);
        InventoryItem itemBGLO = new InventoryItem("BGLO", 0.49, "Bagel", "Onion");
        InventoryItem itemBGLP = new InventoryItem("BGLP", 0.39, "Bagel", "Plain");

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
        InventoryItem itemBGLO = new InventoryItem("BGLO", 0.49, "Bagel", "Onion");

        assertTrue(basket.addToBasket(itemBGLO));
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.removeFromBasket(itemBGLO));
        assertEquals(0, basket.getItemBasket().size());
    }
}
