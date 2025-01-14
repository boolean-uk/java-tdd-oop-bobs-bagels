package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillingTest {
    @Test
    public void checkFillingPriceTest() {
        Filling filling = new Filling(SKU.FILB);
        Assertions.assertEquals(0.12F, filling.getPrice());
    }

    @Test
    public void checkWrongFillingPriceTest() {
        Filling filling = new Filling(SKU.FILB);
        Assertions.assertNotEquals(0.99F, filling.getPrice());
    }

    @Test
    public void checkFillingNameTest() {
        Filling filling = new Filling(SKU.FILB);
        Assertions.assertEquals("Filling", filling.getName());
    }

    @Test
    public void checkWrongFillingNameTest() {
        Filling filling = new Filling(SKU.FILC);
        Assertions.assertNotEquals("Bagel", filling.getName());
    }

    @Test
    public void checkFillingVariantTest() {
        Filling filling = new Filling(SKU.FILB);
        Assertions.assertEquals("Bacon", filling.getVariant());
    }

    @Test
    public void checkWrongFillingVariantTest() {
        Filling filling = new Filling(SKU.FILH);
        Assertions.assertNotEquals("Bacon", filling.getVariant());
    }
}
