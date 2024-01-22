package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BagelTest {

    @Test
    public void testGetName(){
        Bagel onion = new  Bagel("BGLO", 0.49, "Onion");
        Bagel plain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel everything = new  Bagel("BGLE", 0.49, "Everything");
        Bagel sesame = new  Bagel("BGLS", 0.49, "Sesame");

        Assertions.assertEquals("Bagel", plain.getName());
        Assertions.assertEquals("Bagel", onion.getName());
        Assertions.assertEquals("Bagel", everything.getName());
        Assertions.assertEquals("Bagel", sesame.getName());
    }

    @Test
    public void testGetVariant(){
         Bagel onion = new  Bagel("BGLO", 0.49, "Onion");
         Bagel plain = new  Bagel("BGLP", 0.39, "Plain");
         Bagel everything = new  Bagel("BGLE", 0.49, "Everything");
         Bagel sesame = new  Bagel("BGLS", 0.49, "Sesame");

        Assertions.assertEquals("Plain", plain.getVariant());
        Assertions.assertEquals("Onion", onion.getVariant());
        Assertions.assertEquals("Everything", everything.getVariant());
        Assertions.assertEquals("Sesame", sesame.getVariant());
    }

    @Test
    public void testGetPrice(){
         Bagel onion = new  Bagel("BGLO", 0.49, "Onion");
         Bagel plain = new  Bagel("BGLP", 0.39, "Plain");
         Bagel everything = new  Bagel("BGLE", 0.49, "Everything");
         Bagel sesame = new  Bagel("BGLS", 0.49, "Sesame");

        Assertions.assertEquals(0.39, plain.getPrice());
        Assertions.assertEquals(0.49, onion.getPrice());
        Assertions.assertEquals(0.49, everything.getPrice());
        Assertions.assertEquals(0.49, sesame.getPrice());
    }

    @Test
    public void testGetFilling(){
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling filling2 = new  Filling("FILE", 0.12, "Egg");
         Filling filling3 = new  Filling("FILC", 0.12, "Cheese");
        ArrayList< Filling> fillings = new ArrayList<>();
        fillings.add(filling1);
        fillings.add(filling2);
        fillings.add(filling3);
         Bagel plain = new  Bagel("BGLP", 0.39, "Plain", fillings);

        ArrayList< Filling> fillingsTest = new ArrayList<>();
        fillingsTest.add(filling1);
        fillingsTest.add(filling2);
        fillingsTest.add(filling3);

        Assertions.assertEquals(fillingsTest, plain.getFillings());
    }
    @Test
    public void testAddFilling(){
         Filling filling1 = new  Filling("FILB", 0.12, "Bacon");
         Filling fillingBad = new  Filling("FIL", 0.12, "Cheese");
         Filling filling2 = new  Filling("FILC", 0.12, "Cheese");
         Bagel plain = new Bagel("BGLP", 0.39, "Plain");

        ArrayList< Filling> fillings = new ArrayList<>();
        fillings.add(filling1);

        ArrayList<Filling> fillingsBad = new ArrayList<>();
        fillingsBad.add(filling1);
        fillingsBad.add(fillingBad);
        fillingsBad.add(filling2);

        //Test list with one wrong filling
        Assertions.assertFalse(plain.addFillings(fillingsBad));

        //Test list with one good fillings
        plain.addFillings(fillings);
        Assertions.assertEquals(plain.getFillings().get(0), filling1);
    }
}