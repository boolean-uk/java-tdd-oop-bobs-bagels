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

    @Test
    public void testCheckPrice() {
        Item bglo = new Item("Bagel", "Onion", 0.49);
        Item bglp = new Item("Bagel", "Plain", 0.39);
        Assertions.assertEquals(0.49, bglo.checkPrice());
        Assertions.assertEquals(0.39, bglp.checkPrice());
    }
}
