package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class BagleTest {

    private Bagle bagle;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public BagleTest() {
        this.bagle = new Bagle("BGLO", 0.49, "Onion");
    }

    @Test
    public void getSKUTest() {
        Assertions.assertEquals("BGLO", bagle.getSKU());
        Assertions.assertNotEquals("BGLOO", bagle.getSKU());
    }

    @Test
    public void getPriceTest() {
        Assertions.assertEquals(0.49, bagle.getPrice());
        Assertions.assertNotEquals(1,bagle.getPrice());
    }

    public void
}
