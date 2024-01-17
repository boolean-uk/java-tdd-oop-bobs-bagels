package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        Item bglo = new Item("Bagel", "Onion", 0.49);
        Assertions.assertEquals("Bagel", bglo.name);
        Assertions.assertEquals("Onion", bglo.variant);
        Assertions.assertEquals(0.49, bglo.price);
    }
}
