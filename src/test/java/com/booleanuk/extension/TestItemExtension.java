package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestItemExtension {
    @Test
    void testCorrectVariableSetFromSku() {
        Item item = new Item(SKU.BGLO);

        Assertions.assertEquals(SKU.BGLO, item.getSku());
        Assertions.assertEquals("Bagel", item.getType());
        Assertions.assertEquals(0.49f, item.getPrice());
        Assertions.assertEquals("Onion", item.getVariant());
    }
}
