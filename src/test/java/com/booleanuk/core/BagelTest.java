package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {


    @Test
    public void testBagel(){
        Bagel bagel = new Bagel("BGLO",0.49, "Bagel", Bagel.BagelVariant.ONION);
        Assertions.assertEquals("BGLO", bagel.sku);
        Assertions.assertEquals("Bagel", bagel.name);
        Assertions.assertEquals(0.49, bagel.price);
        Assertions.assertEquals(Bagel.BagelVariant.ONION, bagel.variant);
    }
}
