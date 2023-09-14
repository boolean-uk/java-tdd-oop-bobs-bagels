package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketTest {

    @Test
    public void testAddToBasketWorks() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory, 2);
        InventoryItem itemBGLO = new InventoryItem("BGLO", 0.49, "Bagel", "Onion");

        assertTrue(basket.addToBasket());
        assertEquals(1, basket.getItemBasket().size());
        assertTrue(basket.getItemBasket().contains(itemBGLO));
    }
}
