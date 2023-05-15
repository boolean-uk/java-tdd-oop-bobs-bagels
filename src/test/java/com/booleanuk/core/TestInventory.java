package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestInventory {

    @Test
    public void testContainsBagel(){
        Inventory newInventory = new Inventory();

        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Honey", 0.49, new Inventory());

        boolean response = newInventory.contains(newBagel);
        Assertions.assertTrue(response);

        response = newInventory.contains(newBagel2);
        Assertions.assertFalse(response);
    }

    @Test
    public void testContainsCoffee(){
        Inventory newInventory = new Inventory();

        Coffee newCoffee = new Coffee("White", 1.19) ;
        Coffee newCoffee2 = new Coffee("Latte Macchiato", 1.19) ;

        boolean response = newInventory.contains(newCoffee);
        Assertions.assertTrue(response);

        response = newInventory.contains(newCoffee2);
        Assertions.assertFalse(response);
    }

    @Test
    public void testContainsFilling(){
        Inventory newInventory = new Inventory();

        Filling newFilling = new Filling("Egg", 0.12);
        Filling newFilling2 = new Filling("Nutella", 0.12);

        boolean response = newInventory.contains(newFilling);
        Assertions.assertTrue(response);

        response = newInventory.contains(newFilling2);
        Assertions.assertFalse(response);
    }
}
