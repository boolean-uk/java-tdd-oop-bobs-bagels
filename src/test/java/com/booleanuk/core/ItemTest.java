package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;

public class ItemTest {

    public void testItemConstructor() {
        String SKU = "BGLS";
        double price = 0.49;
        String name = "Bagel";
        String variant = "Sesame";
        Item item = new Item(SKU, price, name, variant);

        Assertions.assertEquals(SKU, item.getSKU);
        Assertions.assertEquals(price, item.getPrice);
        Assertions.assertEquals(name, item.getName);
        Assertions.assertEquals(variant, item.getVariant);
    }

}
