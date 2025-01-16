package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ItemTest {

    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO", 0);
        assertEquals(4900, bagel.getPrice());

        Bagel bagel1 = new Bagel("BGLOF", 0);
        assertNull(bagel1.getVariant());
    }

    @Test
    public void testCoffee() {
        Coffee coffee = new Coffee("COFB", 0);
        assertEquals(9900, coffee.getPrice());

        Coffee coffee1 = new Coffee("COFL", 0);
        assertEquals(12900, coffee1.getPrice());

        Coffee coffee2 = new Coffee("COFBu", 0);
        assertNull(coffee2.getVariant());
    }

    @Test
    public void testFilling() {
        Bagel bagel = new Bagel("BGLO", 0);
        Filling filling0 = new Filling("FILB", 0, bagel);
        assertEquals("Bacon", filling0.getVariant());
        assertEquals("BGLO", filling0.getBagel().getSKU());
        assertEquals("Bacon", bagel.getFillings().getFirst().getVariant());
        assertEquals(1 ,bagel.getFillings().size());

        Filling filling1 = new Filling("FILBu", 0, bagel);
        assertNull(filling1.getVariant());
        assertEquals(1 ,bagel.getFillings().size());
    }
}
