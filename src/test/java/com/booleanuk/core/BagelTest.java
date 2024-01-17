package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel(){
        Bagel bagel = new Bagel("plain");
        Assertions.assertEquals("plain", bagel.getName());
        Assertions.assertEquals(2.00, bagel.getPrice());
    }
}
