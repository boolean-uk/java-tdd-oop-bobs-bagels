package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.ItemHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemHandlerTest {
    com.booleanuk.core.ItemHandler itemHandler;
    @Test
    public void testCreateItemHandler() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        assertEquals(0, itemHandler.getIdTracker());
        assertEquals(1, itemHandler.getBasketCapacity());
        assertEquals(0, itemHandler.getBasket().size());
        assertEquals("Bagel", itemHandler.getAllItems().get("BGLO"));
    }

    @Test
    public void testAddBagelCoffee() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        com.booleanuk.core.Coffee coffee1 = itemHandler.addCoffee("COFL");
        assertEquals(1.29, coffee1.getPrice());

        itemHandler = new com.booleanuk.core.ItemHandler();
        Coffee coffee2 = itemHandler.addCoffee("WRONGSKU");
        assertNull(coffee2);

        itemHandler.addCoffee("COFL");
        assertEquals(1, itemHandler.getBasket().size());
        itemHandler.addBagel("BGLS");
        assertEquals(1, itemHandler.getBasket().size());

    }


    @Test
    public void testAddFilling() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        com.booleanuk.core.Bagel bagel1 = itemHandler.addBagel("BGLS");
        com.booleanuk.core.Filling filling1 = itemHandler.addFilling("FILC", bagel1);
        assertEquals(0.12, filling1.getPrice());

        assertEquals(filling1, bagel1.getFillings().getFirst());

        itemHandler.addFilling("WRONGSKU", bagel1);
        assertEquals(1, bagel1.getFillings().size());

        com.booleanuk.core.Bagel bagel = new com.booleanuk.core.Bagel("BGLS", 4);
        com.booleanuk.core.Filling filling3 = itemHandler.addFilling("FILC", bagel);
        assertNull(filling3);
    }


    @Test
    public void getTotal() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        double total1 = itemHandler.getTotal();
        assertEquals(0, total1);
        com.booleanuk.core.Bagel bagel1 = itemHandler.addBagel("BGLS");

        double total2 = itemHandler.getTotal();
        assertEquals(0.49, total2);

        itemHandler.addFilling("FILE", bagel1);
        double total3 = itemHandler.getTotal();
        assertEquals(0.61, total3);

        com.booleanuk.core.Filling filling1 = itemHandler.addFilling("FILE", bagel1);
        double total4 = itemHandler.getTotal();
        assertEquals(0.73, total4);

        itemHandler.removeItem(filling1.getId());
        double total5 = itemHandler.getTotal();
        assertEquals(0.61, total5);

        itemHandler.removeItem(bagel1.getId());
        double total6 = itemHandler.getTotal();
        assertEquals(0, total6);
    }


    @Test
    public void testRemoveItem() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        com.booleanuk.core.Bagel bagel1 = itemHandler.addBagel("BGLS");


        assertEquals(1, itemHandler.getBasket().size());
        boolean removed = itemHandler.removeItem(bagel1.getId());
        assertTrue(removed);
        assertEquals(0, itemHandler.getBasket().size());

        boolean removed4 = itemHandler.removeItem(bagel1.getId());
        assertFalse(removed4);

        com.booleanuk.core.Bagel bagel2 = itemHandler.addBagel("BGLS");
        Filling filling1 = itemHandler.addFilling("FILC", bagel2);
        assertEquals(filling1, bagel2.getFillings().getFirst());
        boolean removed2 = itemHandler.removeItem(filling1.getId());
        assertTrue(removed2);
        assertEquals(0, bagel2.getFillings().size());

        boolean removed3 = itemHandler.removeItem(filling1.getId());
        assertFalse(removed3);


    }


    @Test
    public void testSetCapacity() {
        itemHandler = new com.booleanuk.core.ItemHandler();
        com.booleanuk.core.Bagel bagel1 = itemHandler.addBagel("BGLS");
        assertEquals(1, itemHandler.getBasket().size());
        assertNotNull(bagel1);

        com.booleanuk.core.Bagel bagel2 = itemHandler.addBagel("BGLS");
        assertEquals(1, itemHandler.getBasket().size());
        assertNull(bagel2);

        boolean setCapacity = itemHandler.setCapacity(3);
        assertTrue(setCapacity);

        Bagel bagel3 = itemHandler.addBagel("BGLS");
        assertEquals(2, itemHandler.getBasket().size());
        assertNotNull(bagel3);

        boolean setCapacity2 = itemHandler.setCapacity(1);
        assertFalse(setCapacity2);
    }


    @Test
    public void testSearchItem() {
        itemHandler = new ItemHandler();
        double search1 = itemHandler.searchItem("BGLE");
        assertEquals(0.49, search1);

        double search2 = itemHandler.searchItem("BGLEu");
        assertEquals(-1, search2);
    }


}
