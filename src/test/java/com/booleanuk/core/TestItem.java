package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestItem {
    @Test
    void testCorrectVariableSetFromSku() {
        Item item = new Bagel(SKU.BGLO);

        Assertions.assertEquals(SKU.BGLO, item.getSku());
        Assertions.assertEquals("Bagel", item.getType());
        Assertions.assertEquals(0.49f, item.getPrice());
        Assertions.assertEquals("Onion", item.getVariant());
    }
}
