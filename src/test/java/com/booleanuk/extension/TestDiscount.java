package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiscount {
    ItemHandler itemHandler;
    @Test
    public void testDiscountSixBagels() {
        itemHandler = new ItemHandler();
        for (int i = 0; i < 6; i++) {
            itemHandler.addBagel("BGLE");
        }
        assertEquals(2.49, itemHandler.getTotal());
    }
}
