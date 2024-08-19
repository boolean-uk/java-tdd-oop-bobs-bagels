package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void createBagel() {
        Bagel bagel = new Bagel("BGLO");

        Assertions.assertEquals(0.49, bagel.getPrice());
    }

    @Test
    public void checkTypeBagelTest() {
        Bagel bagel = new Bagel("BGLO");

        Assertions.assertEquals("Bagel", bagel.getType());
    }

    @Test
    public void checkNameBagelTest() {
        Bagel bagel = new Bagel("BGLO");

        Assertions.assertEquals("Onion", bagel.getName());
    }
}
