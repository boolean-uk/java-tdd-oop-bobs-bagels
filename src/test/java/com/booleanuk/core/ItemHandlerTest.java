package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemHandlerTest {
    ItemHandler itemHandler = new ItemHandler();
    @Test
    public void testCreateItemHandler() {
        assertEquals(0, itemHandler.getIdTracker());
        assertEquals(1, itemHandler.getBasketCapacity());
    }
}
