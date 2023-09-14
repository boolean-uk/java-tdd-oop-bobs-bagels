package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void testBagel() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        Assertions.assertEquals("BGLO" , bagel.getSku());
        Assertions.assertEquals(0.49, bagel.getPrice());
        Assertions.assertEquals("Bagel", bagel.getName());
        Assertions.assertEquals("Onion", bagel.getVariant());
        Assertions.assertTrue( bagel.setVariant("Onion-Garlic"));
        Assertions.assertEquals("Onion-Garlic", bagel.getVariant());

    }
}
