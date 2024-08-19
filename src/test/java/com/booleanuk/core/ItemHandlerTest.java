package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemHandlerTest {
    ItemHandler itemHandler;
    @Test
    public void testCreateItemHandler() {
        itemHandler = new ItemHandler();
        assertEquals(0, itemHandler.getIdTracker());
        assertEquals(1, itemHandler.getBasketCapacity());
        assertEquals(0, itemHandler.getBasket().size());
        assertEquals("Bagel", itemHandler.getAllItems().get("BGLO"));
    }

    @Test
    public void testAddBasicItem() {
        itemHandler = new ItemHandler();
        Item coffee1 = itemHandler.addBasicItem("COFL");
        assertEquals(1.29, coffee1.getPrice());

        assertEquals(1, itemHandler.getBasket().size());
        Item bagel1 = itemHandler.addBasicItem("BGLS");
        assertEquals(1, itemHandler.getBasket().size());

        itemHandler = new ItemHandler();
        Item filling1 = itemHandler.addBasicItem("FILC");
        assertEquals(0, itemHandler.getBasket().size());
        assertNull(filling1);
    }


    @Test
    public void testAddFilling() {
        itemHandler = new ItemHandler();
        Item bagel1 = itemHandler.addBasicItem("BGLS");
        Item filling1 = itemHandler.addFilling("FILC", bagel1);
    }


    @Test
    public void testRemoveItem() {

    }


    @Test
    public void testSetCapacity() {

    }


    @Test
    public void testSearchItem() {

    }


}
