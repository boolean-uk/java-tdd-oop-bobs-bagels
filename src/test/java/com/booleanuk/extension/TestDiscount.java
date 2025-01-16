package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiscount {
    ItemHandler itemHandler;
    @Test
    public void testDiscountSixBagels() {
        Item bagel1 = new Bagel("BGLE", 0);
        itemHandler = new ItemHandler();
        itemHandler.setCapacity(100);
        for (int i = 0; i < 6; i++) {
            bagel1 = itemHandler.addItem("BGLE");
        }
        assertEquals(2.49, itemHandler.getTotal());

        Item bagel2 = itemHandler.addItem("BGLP");
        assertEquals(2.98, itemHandler.getTotal());

        itemHandler.removeItem(bagel1.getId());
        assertEquals(2.49, itemHandler.getTotal());

        itemHandler.removeItem(bagel2.getId());
        assertEquals(0.49*5, itemHandler.getTotal());
    }

    @Test
    public void testDiscountTwelveBagels() {
        Item bagel1 = new Bagel("BGLE", 0);
        itemHandler = new ItemHandler();
        itemHandler.setCapacity(100);
        for (int i = 0; i < 12; i++) {
            bagel1 = itemHandler.addItem("BGLE");
        }

        assertEquals(3.99, itemHandler.getTotal());

        for (int i = 0; i < 12; i++) {
            bagel1 = itemHandler.addItem("BGLE");
        }

        assertEquals(3.99*2, itemHandler.getTotal());

        itemHandler.removeItem(bagel1.getId());
        assertEquals(8.93, itemHandler.getTotal());
    }

    @Test
    public void testCoffeeAndBagelDiscount() {
        Item bagel1 = new Bagel("BGLE", 0);
        itemHandler = new ItemHandler();
        itemHandler.setCapacity(100);
        for (int i = 0; i < 6; i++) {
            bagel1 = itemHandler.addItem("BGLE");
        }
        Item coffee1 = new Coffee("COFB", 0);
        for (int i = 0; i < 6; i++) {
            coffee1 = itemHandler.addItem("COFB");
        }
        assertEquals(8.43, itemHandler.getTotal());

        itemHandler.removeItem(bagel1.getId());
        assertEquals(7.24, itemHandler.getTotal());

        itemHandler.removeItem(coffee1.getId());
        assertEquals(6.25, itemHandler.getTotal());
    }
}
