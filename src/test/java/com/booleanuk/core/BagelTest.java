package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BagelTest {
    @Test
    public void testBagel(){
        Bagel bagel = new Bagel("Everything");
        Assertions.assertEquals(bagel.getVariant(), "Everything");
    }

    @Test
    public void testAddFilling(){
        Bagel bagel = new Bagel("Everything");
        bagel.addFilling("Bacon");
        bagel.addFilling("Cheese");
        HashMap<String, Integer> fillings = new HashMap<>();
        fillings.put("Bacon",1);
        fillings.put("Cheese",1);
        Assertions.assertEquals(fillings, bagel.getFillings());
        bagel.addFilling("Everything");
        bagel.addFilling("Truffle");
        Assertions.assertEquals(fillings, bagel.getFillings());
    }

    @Test
    public void testRemoveFilling(){
        Bagel bagel = new Bagel("Everything");
        bagel.addFilling("Bacon");
        bagel.addFilling("Cheese");
        HashMap<String, Integer> fillings = new HashMap<>();
        fillings.put("Bacon",1);
        bagel.removeFilling("Cheese");

        Assertions.assertEquals(fillings, bagel.getFillings());
        bagel.removeFilling("Bacon");
        Assertions.assertEquals(new HashMap<>(), bagel.getFillings());
    }

}
