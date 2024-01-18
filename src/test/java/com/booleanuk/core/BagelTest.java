package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {

    @Test
    void getPrice() {
        Bagel bagel = new Bagel("Onion");

        double result = bagel.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void setPrice() {
        Bagel bagel = new Bagel("Plain");

        bagel.setPrice(0.55);

        double result = bagel.getPrice();

        Assertions.assertEquals(0.55, result);
    }

    @Test
    void getVariant() {
        Bagel bagel = new Bagel("Everything");

        String result = bagel.getVariant();

        Assertions.assertEquals("Everything", result);
    }

    @Test
    void getSku() {
        Bagel bagel = new Bagel("Sesame");

        String result = bagel.getSku();

        Assertions.assertEquals("BGLS", result);
    }

    @Test
    void getBagel() {
        Bagel bagel = new Bagel("Onion");

        bagel.setBagel("Onion Bagel");

        String result = bagel.getBagel();

        Assertions.assertEquals("Onion Bagel", result);
    }

    @Test
    void setBagel() {
        Bagel bagel = new Bagel("Plain");

        bagel.setBagel("Plain Bagel");

        String result = bagel.getBagel();

        Assertions.assertEquals("Plain Bagel", result);
    }
}
