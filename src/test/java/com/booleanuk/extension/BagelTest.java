package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void checkBagelPriceTest() {
        Bagel bagel = new Bagel(SKU.BGLP);
        Assertions.assertEquals(0.39F, bagel.getPrice());
    }

    @Test
    public void checkWrongBagelPriceTest() {
        Bagel bagel = new Bagel(SKU.BGLS);
        Assertions.assertNotEquals(0.39F, bagel.getPrice());
    }

    @Test
    public void checkBagelNameTest() {
        Bagel bagel = new Bagel(SKU.BGLP);
        Assertions.assertEquals("Bagel", bagel.getName());
    }

    @Test
    public void checkWrongBagelNameTest() {
        Bagel bagel = new Bagel(SKU.FILC);
        Assertions.assertNotEquals("Bagel", bagel.getName());
    }

    @Test
    public void checkBagelVariantTest() {
        Bagel bagel = new Bagel(SKU.BGLP);
        Assertions.assertEquals("Plain", bagel.getVariant());
    }

    @Test
    public void checkWrongBagelVariantTest() {
        Bagel bagel = new Bagel(SKU.BGLE);
        Assertions.assertNotEquals("Plain", bagel.getVariant());
    }
}
