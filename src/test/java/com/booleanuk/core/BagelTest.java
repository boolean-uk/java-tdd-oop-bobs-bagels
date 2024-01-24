package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel(){
        Bagel bagel = new Bagel(5.00, "BGLP", "Plain");
        Assertions.assertEquals("Plain", bagel.getVariant());
        Assertions.assertEquals(5.00, bagel.getPrice());
        Assertions.assertEquals("Bagel", bagel.getItemName());
        Assertions.assertEquals("BGLP", bagel.getSku());
    }
}
