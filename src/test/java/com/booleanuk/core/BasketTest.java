package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {
    @Test
    public void testAddToBasketSuccessful() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertTrue(basket.addToBasket(bagelItem,1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.getItemsMap().containsKey(bagelItem));
    }
    @Test
    public void testAddToBasketFailed() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLG", 0.49, "Bagel", "Garlic");
        assertFalse(basket.addToBasket(bagelItem,1));
        assertEquals(0, basket.getItemsMap().size());
    }

    // test add to basket -> product already exists -> increase quantity


    @Test
    public void testRemoveFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 5);
        Item bagelItem = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Item bagelItem2 = new Bagel("BGLP",	0.39,	"Bagel",	"Plain");

        assertTrue(basket.addToBasket(bagelItem,2));
        assertEquals(1, basket.getItemsMap().size());
        assertFalse(basket.removeFromBasket(bagelItem2,1));
        assertEquals(1, basket.getItemsMap().size());
        assertTrue(basket.removeFromBasket(bagelItem,1));
        assertEquals(1, basket.getItemsMap().size());
        assertEquals(1, basket.getItemsMap().get(bagelItem));
        assertTrue(basket.removeFromBasket(bagelItem,1));
        assertEquals(0, basket.getItemsMap().size());

    }
}
