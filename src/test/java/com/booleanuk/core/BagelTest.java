package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagelTest {

    @BeforeEach
    void setUp() {
        Bagel plain = new Bagel("BGLP");
        Bagel onion = new Bagel("BGLO");
        Bagel everything = new Bagel("BGLE");
        Bagel sesame = new Bagel("BGLS");
    }

    @Test
    public void testGetName(){
        Assertions.assertEquals("Bagel", plain.getName());
        Assertions.assertEquals("Bagel", onion.getName());
        Assertions.assertEquals("Bagel", everything.getName());
        Assertions.assertEquals("Bagel", sesame.getName());
    }

    @Test
    public void testGetVariant(){
        Assertions.assertEquals("Plain", plain.getVariant());
        Assertions.assertEquals("Onion", onion.getVariant());
        Assertions.assertEquals("Everything", everything.getVariant());
        Assertions.assertEquals("Sesame", sesame.getVariant());
    }

    @Test
    public void testGetPrice(){
        Assertions.assertEquals(0.39, plain.getPrice());
        Assertions.assertEquals(0.49, onion.getPrice());
        Assertions.assertEquals(0.49, everything.getPrice());
        Assertions.assertEquals(0.49, sesame.getPrice());
    }
}