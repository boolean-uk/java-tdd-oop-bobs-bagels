package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagelTest {
    @Test
    public void getSkuTest() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("BGLO", bagel.getSku());
    }

    @Test
    public void getPriceTest() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals(0.49, bagel.getPrice(), 0.001);
    }

    @Test
    public void getNameTest() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Onion", bagel.getName());
    }

    @Test
    public void getVariantTest() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Bagel", bagel.getVariant());
    }
}
