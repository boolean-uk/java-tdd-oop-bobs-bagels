package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        Bagel bglo = new Bagel("BGLO", "Onion", 0.49);
        Assertions.assertEquals("BGLO", bglo.getSku());
        Assertions.assertEquals("Bagel", bglo.getName());
        Assertions.assertEquals("Onion", bglo.getVariant());
        Assertions.assertEquals(0.49, bglo.getPrice());
    }

    @Test
    public void testGetPrice() {
        Bagel bglo = new Bagel("BGLO", "Onion", 0.49);
        Bagel bglp = new Bagel("BGLP","Plain", 0.39);
        Coffee cofl = new Coffee("COFL", "Latte", 1.29);
        Filling filx = new Filling("FILX", "Cream Cheese", 0.12);
        Assertions.assertEquals(0.49, bglo.getPrice());
        Assertions.assertEquals(0.39, bglp.getPrice());
        Assertions.assertEquals(1.29, cofl.getPrice());
        Assertions.assertEquals(0.12, filx.getPrice());
    }

    @Test
    public void testAddFillingToBagel() {
        Bagel bglp = new Bagel("BGLP","Plain", 0.39);
        Filling filx = new Filling("FILX", "Cream Cheese", 0.12);
        bglp.addFilling(filx);
        Assertions.assertTrue(bglp.getFillings().contains(filx));
        Assertions.assertEquals(1, bglp.getFillings().size());
    }

    @Test
    public void testAddMultipleFillingsToBagel() {
        Bagel bglp = new Bagel("BGLP","Plain", 0.39);
        Filling filx = new Filling("FILX", "Cream Cheese", 0.12);
        Filling filb = new Filling("FILB", "Bacon", 0.12);
        Filling filh = new Filling("FILH", "Ham", 0.12);
        bglp.addFilling(filx);
        bglp.addFilling(filb);

        Assertions.assertTrue(bglp.getFillings().contains(filx));
        Assertions.assertTrue(bglp.getFillings().contains(filb));
        Assertions.assertEquals(2, bglp.getFillings().size());

        bglp.addFilling(filh);
        bglp.addFilling(filx);

        Assertions.assertTrue(bglp.getFillings().contains(filh));
        Assertions.assertEquals(3, bglp.getFillings().size());
    }

    @Test
    public void testRemoveFillingFromBagel() {
        Bagel bglp = new Bagel("BGLP","Plain", 0.39);
        Filling filx = new Filling("FILX", "Cream Cheese", 0.12);
        bglp.addFilling(filx);
        bglp.removeFilling(filx);
        Assertions.assertFalse(bglp.getFillings().contains(filx));
        Assertions.assertEquals(0, bglp.getFillings().size());
    }

}
