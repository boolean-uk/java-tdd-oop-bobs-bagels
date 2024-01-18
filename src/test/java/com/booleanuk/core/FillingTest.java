package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FillingTest {

    @Test
    public void testGetName(){
        Bagel bacon = new Bagel("BGLP");
        Bagel egg = new Bagel("BGLO");
        Bagel cheese = new Bagel("BGLE");


        Assertions.assertEquals("Bagel", bacon.getName());
        Assertions.assertEquals("Bagel", egg.getName());
        Assertions.assertEquals("Bagel", cheese.getName());

    }

    @Test
    public void testGetVariant(){
        Bagel bacon = new Bagel("BGLP");
        Bagel egg = new Bagel("BGLO");
        Bagel cheese = new Bagel("BGLE");

        Assertions.assertEquals("Bagel", bacon.getVariant());
        Assertions.assertEquals("Bagel", egg.getVariant());
        Assertions.assertEquals("Bagel", cheese.getVariant());
    }

    @Test
    public void testGetPrice(){
        Bagel bacon = new Bagel("BGLP");
        Bagel egg = new Bagel("BGLO");
        Bagel cheese = new Bagel("BGLE");

        Assertions.assertEquals(0.12, bacon.getPrice());
        Assertions.assertEquals(0.12, egg.getPrice());
        Assertions.assertEquals(0.12, cheese.getPrice());
    }
}