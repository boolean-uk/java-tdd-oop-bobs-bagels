package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ItemTest {

    @Test
    public void testBagel() {
        com.booleanuk.core.Bagel bagel = new com.booleanuk.core.Bagel("BGLO", 0);
        assertEquals(0.49, bagel.getPrice());

        com.booleanuk.core.Bagel bagel1 = new com.booleanuk.core.Bagel("BGLOF", 0);
        assertNull(bagel1.getVariant());
    }

    @Test
    public void testCoffee() {
        com.booleanuk.core.Coffee coffee = new com.booleanuk.core.Coffee("COFB", 0);
        assertEquals(0.99, coffee.getPrice());

        com.booleanuk.core.Coffee coffee1 = new com.booleanuk.core.Coffee("COFL", 0);
        assertEquals(1.29, coffee1.getPrice());

        com.booleanuk.core.Coffee coffee2 = new Coffee("COFBu", 0);
        assertNull(coffee2.getVariant());
    }

    @Test
    public void testFilling() {
        com.booleanuk.core.Bagel bagel = new Bagel("BGLO", 0);
        com.booleanuk.core.Filling filling0 = new com.booleanuk.core.Filling("FILB", 0, bagel);
        assertEquals("Bacon", filling0.getVariant());
        assertEquals("BGLO", filling0.getBagel().getSKU());
        assertEquals("Bacon", bagel.getFillings().getFirst().getVariant());
        assertEquals(1 ,bagel.getFillings().size());

        com.booleanuk.core.Filling filling1 = new Filling("FILBu", 0, bagel);
        assertNull(filling1.getVariant());
        assertEquals(1 ,bagel.getFillings().size());
    }
}
