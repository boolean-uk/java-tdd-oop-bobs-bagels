package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {


    @Test
    public void getSku() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getSku();

        Assertions.assertEquals("BGLO", result);
    }

    @Test
    public void setSku() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setSku("BGLP");

        String result = bagel.getSku();

        Assertions.assertEquals("BGLP", result);
    }

    @Test
    public void getPrice() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        double result = bagel.getPrice();

        Assertions.assertEquals(0.49, result);
    }

    @Test
    public void setPrice() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setPrice(0.55);

        double result = bagel.getPrice();

        Assertions.assertEquals(0.55, result);
    }

    @Test
    public void getVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getVariant();

        Assertions.assertEquals("Onion", result);
    }

    @Test
    public void setVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setVariant("Plain");

        String result = bagel.getVariant();

        Assertions.assertEquals("Plain", result);
    }

    @Test
    public void getName() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        String result = bagel.getName();

        Assertions.assertEquals("Bagel", result);
    }

    @Test
    public void setName() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        bagel.setName("Plain Bagel");

        String result = bagel.getName();

        Assertions.assertEquals("Plain Bagel", result);
    }
}