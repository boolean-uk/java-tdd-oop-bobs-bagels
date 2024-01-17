package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testCreateBagel(){
        Bagel bagel = new Bagel("plain");
        Bagel bagel2 = new Bagel("chocolate", 5.00);

        Assertions.assertEquals("plain", bagel.getName());
        Assertions.assertEquals(2.00, bagel.getPrice());

        Assertions.assertEquals("chocolate", bagel2.getName());
        Assertions.assertEquals(5.00, bagel2.getPrice());

    }
}
