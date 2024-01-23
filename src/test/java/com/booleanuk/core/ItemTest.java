package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        Assertions.assertEquals("BGLO", bglo.getSku());
        Assertions.assertEquals("Bagel", bglo.getName());
        Assertions.assertEquals("Onion", bglo.getVariant());
        Assertions.assertEquals(0.49, bglo.getPrice());
    }

    @Test
    public void testGetPrice() {
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        Item bglp = new Bagel("BGLP","Plain", 0.39);
        Item cofl = new Coffee("COFL", "Latte", 1.29);
        Item filx = new Filling("FILX", "Cream Cheese", 0.12);
        Assertions.assertEquals(0.49, bglo.getPrice());
        Assertions.assertEquals(0.39, bglp.getPrice());
        Assertions.assertEquals(1.29, cofl.getPrice());
        Assertions.assertEquals(0.12, filx.getPrice());
    }

    @Test
    public void testAddFillingToBagel() {
        Item bglp = new Bagel("BGLP","Plain", 0.39);
        Item filx = new Filling("FILX", "Cream Cheese", 0.12);
        bglp.addFilling(filx);
        Assertions.assertTrue(bglp.getFillings().contains(filx));
        Assertions.assertEquals(1, bglp.getFillings().size());
    }

}
