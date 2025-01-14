package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        String SKU = "BGLS";
        double price = 0.49;
        String name = "Bagel";
        String variant = "Sesame";
        Item item = new Item(SKU, price, name, variant);

        Assertions.assertEquals(SKU, item.getSKU());
        Assertions.assertEquals(price, item.getPrice());
        Assertions.assertEquals(name, item.getName());
        Assertions.assertEquals(variant, item.getVariant());
    }

}
