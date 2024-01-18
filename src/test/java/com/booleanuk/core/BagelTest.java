package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BagelTest {

    @Test
    public void testGetName(){
        Bagel plain = new Bagel("BGLP");
        Bagel onion = new Bagel("BGLO");
        Bagel everything = new Bagel("BGLE");
        Bagel sesame = new Bagel("BGLS");

        Assertions.assertEquals("Bagel", plain.getName());
        Assertions.assertEquals("Bagel", onion.getName());
        Assertions.assertEquals("Bagel", everything.getName());
        Assertions.assertEquals("Bagel", sesame.getName());
    }

    @Test
    public void testGetVariant(){
        Bagel plain = new Bagel("BGLP");
        Bagel onion = new Bagel("BGLO");
        Bagel everything = new Bagel("BGLE");
        Bagel sesame = new Bagel("BGLS");

        Assertions.assertEquals("Plain", plain.getVariant());
        Assertions.assertEquals("Onion", onion.getVariant());
        Assertions.assertEquals("Everything", everything.getVariant());
        Assertions.assertEquals("Sesame", sesame.getVariant());
    }

    @Test
    public void testGetPrice(){
        Bagel plain = new Bagel("BGLP");
        Bagel onion = new Bagel("BGLO");
        Bagel everything = new Bagel("BGLE");
        Bagel sesame = new Bagel("BGLS");

        Assertions.assertEquals(0.39, plain.getPrice());
        Assertions.assertEquals(0.49, onion.getPrice());
        Assertions.assertEquals(0.49, everything.getPrice());
        Assertions.assertEquals(0.49, sesame.getPrice());
    }

    @Test
    public void testGetFilling(){
        Filling filling1 = new Filling("FILX");
        Filling filling2 = new Filling("FILS");
        Filling filling3 = new Filling("FILC");
        Bagel plain = new Bagel("BGLP", new Filling[]{filling1,filling2,filling3});
        ArrayList<Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);
        fillings.add(filling3);

        Assertions.assertEquals(fillings, plain.getFillings());
    }
    @Test
    public void testAddFilling(){
        Filling filling1 = new Filling("FILX");
        Bagel plain = new Bagel("BGLP");
        plain.addFilling(filling1);
        Assertions.assertEquals(plain.getFillings().get(0), filling1);
    }
}