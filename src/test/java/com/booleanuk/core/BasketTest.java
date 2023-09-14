package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddToBasketSuccessful() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertTrue(basket.addToBasket(bagelItem);
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.getItemsMap().contains(bagelItem));
    }
    @Test
    public void testAddToBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLG", 0.49, "Bagel", "Garlic");
        assertFalse(basket.addToBasket(bagelItem));
        assertEquals(0, basket.getItemsMap().size());
    }
}
