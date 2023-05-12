package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBagel {

    @Test
    public void testGetName(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Assertions.assertEquals("Onion", newBagel.getVariant());
    }

    @Test
    public void testGetPrice(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Assertions.assertEquals(0.49, newBagel.getPrice());

        newBagel.addFilling(new Filling("f1", 0.1));
        newBagel.addFilling(new Filling("f2", 0.4));
        newBagel.addFilling(new Filling("f3", 0.5));

        Assertions.assertEquals(1.49, newBagel.getPrice());
    }

    @Test
    public void testAddFilling(){
        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());

        Filling filling = new Filling("Cheese", 0.12);
        Filling response = newBagel.addFilling(filling);
        Assertions.assertEquals(response.getVariant(), "Cheese");
        Assertions.assertEquals(response.getPrice(), 0.12);
    }
}
