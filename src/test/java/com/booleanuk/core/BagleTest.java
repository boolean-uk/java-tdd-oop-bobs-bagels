package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class BagleTest {

    private Bagle bagle;


    public BagleTest() {
        this.bagle = new Bagle("BGLO", 0.49, "Onion");
    }

    @Test
    public void getSKUTest() {
        Assertions.assertEquals("bglo", bagle.getSKU().toLowerCase());
        Assertions.assertNotEquals("BGLOO", bagle.getSKU().toLowerCase());
    }

    @Test
    public void getPriceTest() {
        Assertions.assertEquals(0.49, bagle.getPrice());
        Assertions.assertNotEquals(1,bagle.getPrice());
    }
    @Test
    public void getVariantTest() {
        Assertions.assertEquals("onion", bagle.getVariant().toLowerCase());
        Assertions.assertNotEquals("everything",bagle.getVariant().toLowerCase());
    }
}
