package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BagelTest {
    @Test
    public void testBagel(){
        Bagel bagel = new Bagel("Everything");
        Assertions.assertEquals(bagel.getBagelVariant(), "Everything");
    }

    @Test
    public void testAddFilling(){
        Bagel bagel = new Bagel("Everything");
        bagel.addFilling("FILB");
        bagel.addFilling("FILC");
        HashMap<String, Integer> fillings = new HashMap<>();
        fillings.put("FILB",1);
        fillings.put("FILC",1);
        Assertions.assertEquals(fillings, bagel.getFillings());
        bagel.addFilling("BGLE");
        bagel.addFilling("Truffle");
        Assertions.assertEquals(fillings, bagel.getFillings());
    }

    @Test
    public void testRemoveFilling(){
        Bagel bagel = new Bagel("Everything");
        bagel.addFilling("FILB");
        bagel.addFilling("FILC");
        HashMap<String, Integer> fillings = new HashMap<>();
        fillings.put("FILB",1);
        bagel.removeFilling("FILC");

        Assertions.assertEquals(fillings, bagel.getFillings());
        bagel.removeFilling("FILB");
        Assertions.assertEquals(new HashMap<>(), bagel.getFillings());
    }

}
