package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ItemTest {

    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO", 0);
        assertEquals(bagel.getPrice(), 0.49);

        Bagel bagel1 = new Bagel("BGLOF", 0);
        assertNull(bagel1.getVariant());
    }

    @Test
    public void testCoffee() {
        Coffee coffee = new Coffee("COFB", 0);
        assertEquals(coffee.getPrice(), 0.99);

        Coffee coffee1 = new Coffee("COFL", 0);
        assertEquals(coffee1.getPrice(), 1.29);

        Coffee coffee2 = new Coffee("COFBu", 0);
        assertNull(coffee2.getVariant());


    }
}
