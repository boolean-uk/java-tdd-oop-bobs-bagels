package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void createItemTest() {
        Item test = new Item("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertEquals("BGLO", test.getSKU());
    }
}
