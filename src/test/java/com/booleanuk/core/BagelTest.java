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
}
