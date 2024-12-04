package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testInit() {
        Bagel bagel = new Bagel("Plain");

        Assertions.assertEquals(0.39, bagel.getPrice());
        Assertions.assertEquals("Bagel", bagel.getName());
    }



    @Test
    public void addFilling() {
        Bagel bagel = new Bagel("Plain");
        Filling filling = new Filling("Bacon");
        Assertions.assertTrue(bagel.addFilling(filling));
        Assertions.assertTrue(bagel.getFillings().contains(filling));

    }


    @Test
    public void removeFilling() {
        Bagel bagel = new Bagel("Plain");
        Filling filling = new Filling("Bacon");


        Assertions.assertTrue(bagel.addFilling(filling));
        Assertions.assertTrue(bagel.getFillings().contains(filling));
        Assertions.assertTrue(bagel.removeFilling(filling));
        Assertions.assertFalse(bagel.getFillings().contains(filling));

    }
}
