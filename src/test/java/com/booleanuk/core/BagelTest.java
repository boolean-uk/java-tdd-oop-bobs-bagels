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


    //Test Item variants
    @Test
    public void addFilling() {
        Bagel bagel = new Bagel("Plain");


        Assertions.assertTrue(bagel.addFilling(new Filling("Bacon")));

    }


}
