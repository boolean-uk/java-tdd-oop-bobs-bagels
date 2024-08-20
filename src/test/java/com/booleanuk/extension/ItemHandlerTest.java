package com.booleanuk.extension;

import com.booleanuk.extension.Bagel;
import com.booleanuk.extension.Coffee;
import com.booleanuk.extension.Filling;
import com.booleanuk.extension.ItemHandler;
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
        Item coffee1 = itemHandler.addItem("COFL");
        assertEquals("COFL", coffee1.getSKU());

        itemHandler = new ItemHandler();
        Item coffee2 = itemHandler.addItem("WRONGSKU");
        assertNull(coffee2);

        itemHandler.addItem("COFL");
        assertEquals(1, itemHandler.getBasket().size());
        itemHandler.addItem("BGLS");
        assertEquals(1, itemHandler.getBasket().size());

    }


    @Test
    public void testAddFilling() {
        itemHandler = new ItemHandler();
        Item bagel1 = itemHandler.addItem("BGLS");
        Filling filling1 = itemHandler.addItem("FILC", bagel1);
        assertEquals("FILC", filling1.getSKU());

        assertEquals(filling1, bagel1.getFillings().getFirst());

        itemHandler.addItem("WRONGSKU", bagel1);
        assertEquals(1, bagel1.getFillings().size());

        Bagel bagel = new Bagel("BGLS", 4);
        Filling filling3 = itemHandler.addItem("FILC", bagel);
        assertNull(filling3);
    }


    @Test
    public void getTotal() {
        itemHandler = new ItemHandler();
        double total1 = itemHandler.getTotal();
        assertEquals(0, total1);
        Item bagel1 = itemHandler.addItem("BGLS");

        double total2 = itemHandler.getTotal();
        assertEquals(0.49, total2);

        itemHandler.addItem("FILE", bagel1);
        double total3 = itemHandler.getTotal();
        assertEquals(0.61, total3);

        Filling filling1 = itemHandler.addItem("FILE", bagel1);
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
        itemHandler = new ItemHandler();
        Item bagel1 = itemHandler.addItem("BGLS");


        assertEquals(1, itemHandler.getBasket().size());
        boolean removed = itemHandler.removeItem(bagel1.getId());
        assertTrue(removed);
        assertEquals(0, itemHandler.getBasket().size());

        boolean removed4 = itemHandler.removeItem(bagel1.getId());
        assertFalse(removed4);

        Item bagel2 = itemHandler.addItem("BGLS");
        Filling filling1 = itemHandler.addItem("FILC", bagel2);
        assertEquals(filling1, bagel2.getFillings().getFirst());
        boolean removed2 = itemHandler.removeItem(filling1.getId());
        assertTrue(removed2);
        assertEquals(0, bagel2.getFillings().size());

        boolean removed3 = itemHandler.removeItem(filling1.getId());
        assertFalse(removed3);


    }


    @Test
    public void testSetCapacity() {
        itemHandler = new ItemHandler();
        Item bagel1 = itemHandler.addItem("BGLS");
        assertEquals(1, itemHandler.getBasket().size());
        assertNotNull(bagel1);

        Item bagel2 = itemHandler.addItem("BGLS");
        assertEquals(1, itemHandler.getBasket().size());
        assertNull(bagel2);

        boolean setCapacity = itemHandler.setCapacity(3);
        assertTrue(setCapacity);

        Item bagel3 = itemHandler.addItem("BGLS");
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
