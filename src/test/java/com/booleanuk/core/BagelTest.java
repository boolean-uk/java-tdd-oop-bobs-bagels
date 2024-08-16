package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    public BagelTest() {

    }

    @Test
    public void testBagelCreate() {
        Bagel b = new Bagel("BGLP", 0.39);

        Assertions.assertEquals("BGLP", b.getSKU());
        Assertions.assertEquals(0.39, b.getPrice());
    }

    @Test
    public void testCreateOnionBagel() {
        Bagel b = new OnionBagel();

        Assertions.assertEquals(0.49, b.getPrice());
    }

    @Test
    public void testCreatePlainBabel() {
        Bagel b = new PlainBagel();

        Assertions.assertEquals(0.39, b.getPrice());
    }

}
