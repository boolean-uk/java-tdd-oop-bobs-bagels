package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    public BagelTest() {
        Item.fillItemPriceVariants();
        Filling.fillFillingsSkus();
        Bagel.fillBagelsSkus();
    }

    @Test
    public void constructorTest() {
        Bagel bagel = new Bagel("BGLP");
        Assertions.assertEquals("BGLP", bagel.getSku());
        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Plain", bagel.getVariant());
    }

    @Test
    public void addFillingTest() {
        Bagel bagel = new Bagel("BGLP");
        Assertions.assertTrue(bagel.addFilling("FILB"));
        Assertions.assertFalse(bagel.addFilling("COFW"));
        Assertions.assertTrue(bagel.addFilling("FILB"));
        Assertions.assertTrue(bagel.addFilling("FILC"));
    }
}
