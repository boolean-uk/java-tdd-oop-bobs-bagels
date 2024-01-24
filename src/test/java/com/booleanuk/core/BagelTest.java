package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {


    @Test
    void getSku() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getSku();

        Assertions.assertEquals("BGLO", result);
    }

    @Test
    void setSku() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setSku("BGLP");

        String result = bagel.getSku();

        Assertions.assertEquals("BGLP", result);
    }

    @Test
    void getPrice() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        double result = bagel.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    void setPrice() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setPrice(0.55);

        double result = bagel.getPrice();

        Assertions.assertEquals(0.55, result);
    }

    @Test
    void getVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getVariant();

        Assertions.assertEquals("Onion", result);
    }

    @Test
    void setVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setVariant("Plain");

        String result = bagel.getVariant();

        Assertions.assertEquals("Plain", result);
    }

    @Test
    void getName() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getName();

        Assertions.assertEquals("Bagel", result);
    }

    @Test
    void setName() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setName("Plain Bagel");

        String result = bagel.getName();

        Assertions.assertEquals("Plain Bagel", result);
    }
}