package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Assertions.assertEquals("BGLO", bglo.getSku());
        Assertions.assertEquals("Bagel", bglo.getName());
        Assertions.assertEquals("Onion", bglo.getVariant());
        Assertions.assertEquals(0.49, bglo.getPrice());
    }

    @Test
    public void testCheckPrice() {
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        Assertions.assertEquals(0.49, bglo.getPrice());
        Assertions.assertEquals(0.39, bglp.getPrice());
    }
}
