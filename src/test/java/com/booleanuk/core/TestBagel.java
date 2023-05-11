package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBagel {

    @Test
    public void testGetName(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Assertions.assertEquals("Onion", newBagel.getType());
    }

    @Test
    public void testGetPrice(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Assertions.assertEquals(0.49, newBagel.getPrice());
    }

    @Test
    public void testAddFilling(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Filling filling = new Filling("Cheese", 0.12);
        boolean response = newBagel.addFilling(filling);
        Assertions.assertTrue(response);
    }
}
