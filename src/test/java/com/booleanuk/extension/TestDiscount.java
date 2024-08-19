package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiscount {
    ItemHandler itemHandler;
    @Test
    public void testDiscountSixBagels() {
        Bagel bagel1 = new Bagel("BGLE", 0);
        itemHandler = new ItemHandler();
        itemHandler.setCapacity(100);
        for (int i = 0; i < 6; i++) {
            bagel1 = itemHandler.addBagel("BGLE");
        }
        assertEquals(2.49, itemHandler.getTotal());

        Bagel bagel2 = itemHandler.addBagel("BGLP");
        assertEquals(2.98, itemHandler.getTotal());

        itemHandler.removeItem(bagel1.getId());
        assertEquals(2.49, itemHandler.getTotal());

        itemHandler.removeItem(bagel2.getId());
        assertEquals(0.49*5, itemHandler.getTotal());
    }

    @Test
    public void testDiscountTwelveBagels() {

    }
}
