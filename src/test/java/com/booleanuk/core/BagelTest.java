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
        Assertions.assertTrue(bagel.getFillings(filling).contains());

    }


    @Test
    public void removeFilling() {
        Bagel bagel = new Bagel("Plain");
        Filling filling = new Filling("Bacon");


        Assertions.assertTrue(bagel.addFilling(new Filling("Bacon")));
        Assertions.assertTrue(bagel.getFillings(filling).contains());
        Assertions.assertTrue(bagel.removeFilling(filling));
        Assertions.assertFalse(bagel.getFillings(filling).contains());

    }
}
