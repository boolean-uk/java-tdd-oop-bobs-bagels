package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void constructorTest() {
        Bagel bagel = new Bagel(BagelType.BGLP);
        Assertions.assertEquals("BGLP", bagel.getSku());
        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Plain", bagel.getVariant());
    }
    @Test
    public void removeFillingTest() {
        Bagel bagel = new Bagel(BagelType.BGLP);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILC);
        Assertions.assertTrue(bagel.removeFilling(FillingType.FILB));
        Assertions.assertTrue(bagel.removeFilling(FillingType.FILB));
        Assertions.assertTrue(bagel.removeFilling(FillingType.FILC));
        Assertions.assertFalse(bagel.removeFilling(FillingType.FILC));
    }
    @Test
    public void priceGetterTest() {
        Bagel bagel = new Bagel(BagelType.BGLP);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILC);
        Assertions.assertEquals(0.87, bagel.getPrice());
        Assertions.assertTrue(bagel.removeFilling(FillingType.FILC));
        Assertions.assertEquals(0.75, bagel.getPrice());
    }
}
