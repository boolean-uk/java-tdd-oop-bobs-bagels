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
    public void testAddBagelCoffee() {
        itemHandler = new ItemHandler();
        Coffee coffee1 = itemHandler.addCoffee("COFL");
        assertEquals(1.29, coffee1.getPrice());

        itemHandler = new ItemHandler();
        Coffee coffee2 = itemHandler.addCoffee("WRONGSKU");
        assertNull(coffee2);

        Coffee coffee3 = itemHandler.addCoffee("COFL");
        assertEquals(1, itemHandler.getBasket().size());
        Bagel bagel1 = itemHandler.addBagel("BGLS");
        assertEquals(1, itemHandler.getBasket().size());

    }


    @Test
    public void testAddFilling() {
        itemHandler = new ItemHandler();
        Bagel bagel1 = itemHandler.addBagel("BGLS");
        Filling filling1 = itemHandler.addFilling("FILC", bagel1);
        assertEquals(0.12, filling1.getPrice());

        assertEquals(bagel1.getFillings().getFirst(), filling1);

        Filling filling2 = itemHandler.addFilling("WRONGSKU", bagel1);
        assertNull(bagel1.getFillings().get(1));
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
