package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ItemTest {
    @Test
    public void createItemTest() {
        Item test = new Item("BGLO");

        Assertions.assertEquals("BGLO", test.getSKU());
    }

    @Test
    public void setPriceListTest() {
        Item item = new Item("BGLO");

        Assertions.assertEquals(0.49, item.getPrice());


    }
}
