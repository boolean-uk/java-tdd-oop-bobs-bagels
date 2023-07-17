package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void skuSetterAndGetterTest() {
        Item item1 = new Item(BagelType.BGLO);
        Item item2 = new Item(CoffeeType.COFL);
        Assertions.assertEquals("BGLO", item1.getSku());
        Assertions.assertEquals("COFL", item2.getSku());
    }

    @Test
    public void variantSetterAndGetterTest() {
        Item item1 = new Item(BagelType.BGLO);
        Item item2 = new Item(CoffeeType.COFL);
        Assertions.assertEquals("Onion", item1.getVariant());
        Assertions.assertEquals("Latte", item2.getVariant());
    }

    @Test
    public void priceSetterAndGetterTest() {
        Item item1 = new Item(BagelType.BGLO);
        Item item2 = new Item(CoffeeType.COFL);
        Assertions.assertEquals(0.49, item1.getPrice());
        Assertions.assertEquals(1.29, item2.getPrice());
    }
}
