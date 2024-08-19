package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel() {
        Product bagel = new Bagel("SKU", 10, "Variant");
        Assertions.assertNotNull(bagel);
        Assertions.assertEquals(10, bagel.getPrice());
        Assertions.assertEquals("SKU", bagel.getSKU());
        Assertions.assertEquals("Variant", bagel.getVariant());
    }

    @Test
    public void TestAddFillings() {
        Bagel bagel = new Bagel("SKU", 10, "Variant");
        Filling filling = new Filling("SKU", 10, "Variant");
        Assertions.assertTrue(bagel.addFilling(filling));
    }

    @Test
    public void TestAddFillingsFull() {
        Bagel bagel = new Bagel("SKU", 10, "Variant");
        Filling filling = new Filling("SKU", 10, "Variant");
        Filling filling2 = new Filling("SKU2", 20, "Variant2");
        Filling filling3 = new Filling("SKU3", 30, "Variant3");
        Assertions.assertTrue(bagel.addFilling(filling));
        Assertions.assertTrue(bagel.addFilling(filling2));
        Assertions.assertFalse(bagel.addFilling(filling3));
    }

    // test get price with fillings
    @Test
    public void TestGetPriceWithFillings() {
        Bagel bagel = new Bagel("SKU", 10, "Variant");
        Filling filling = new Filling("SKU", 10, "Variant");
        Filling filling2 = new Filling("SKU2", 20, "Variant2");
        bagel.addFilling(filling);
        bagel.addFilling(filling2);
        Assertions.assertEquals(40, bagel.getPrice());
    }
}
