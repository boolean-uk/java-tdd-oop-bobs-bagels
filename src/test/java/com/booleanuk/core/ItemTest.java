package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    public ItemTest() {
        Item.fillItemPriceVariants();
    }
    @Test
    public void skuSetterAndGetterTest() {
        Item item1 = new Item("BGLO");
        Item item2 = new Item("COFL");
        Assertions.assertEquals("BGLO", item1.getSku());
        Assertions.assertEquals("COFL", item2.getSku());

    }
}
