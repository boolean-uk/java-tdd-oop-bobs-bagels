package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelTest {
   @Test
    public void testGetSku(){
       Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
       assertEquals("BGLO", bagel.getSku());
   }

    @Test
    public void testGetPrice(){
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals(0.49, bagel.getPrice());
    }

    @Test
    public void testGetVariant(){
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Bagel", bagel.getVariant());
    }

    @Test
    public void testGetName(){
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        assertEquals("Onion", bagel.getName());
    }
}
