package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemHandlerTest {
    ItemHandler itemHandler = new ItemHandler();
    @Test
    public void testCreateItemHandler() {
        assertEquals(0, itemHandler.getIdTracker());
        assertEquals(1, itemHandler.getBasketCapacity());
        assertEquals(0, itemHandler.getBasket().size());
        assertEquals("Bagel", itemHandler.getAllItems().get("BGLO"));
    }

    @Test
    public void testAddBasicItem() {
        Item coffee1 = itemHandler.addBasicItem("COFL");
        assertEquals(1.29, coffee1.getPrice());
    }
}
