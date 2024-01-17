package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel(){
        Bagel bagel = new Bagel("plain");
        Assertions.assertTrue("plain", bagel.getName());
        Assertions.assertTrue(2.00, bagel.getPrice());
        Assertions.assertFalse("chocolate", bagel.getName());
        Assertions.assertFalse(4.20, bagel.getPrice());
    }
}
