package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    public BagelTest() {
        Item.fillItemPriceVariants();
        Filling.fillItemPriceVariants();
        Bagel.fillItemPriceVariants();
    }

    @Test
    public void constructorTest() {
        Bagel bagel = new Bagel("BGLP");
        Assertions.assertEquals("BGLP", bagel.getSku());
        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Plain", bagel.getVariant());
    }
}
