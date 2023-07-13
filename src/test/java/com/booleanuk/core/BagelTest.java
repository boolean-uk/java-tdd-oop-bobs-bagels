package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BagelTest {
    @Test
    public void testGetSKU() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("BGLO", bagel.getSKU());
    }

    @Test
    public void testGetPrice() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals(0.49, bagel.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Bagel", bagel.getName());
    }

    @Test
    public void testGetVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Onion", bagel.getVariant());
    }
}
