package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestInventory {

    @Test
    public void testContainsItems(){
        Inventory newInventory = new Inventory();

        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Honey", 0.49, new Inventory());

        boolean response = newInventory.contains(newBagel);
        Assertions.assertTrue(response);

        response = newInventory.contains(newBagel2);
        Assertions.assertFalse(response);


        Coffee newCoffee = new Coffee("White", 1.19) ;
        Coffee newCoffee2 = new Coffee("Latte Macchiato", 1.19) ;

        response = newInventory.contains(newCoffee);
        Assertions.assertTrue(response);

        response = newInventory.contains(newCoffee2);
        Assertions.assertFalse(response);


        Filling newFilling = new Filling("Egg", 0.12);
        Filling newFilling2 = new Filling("Nutella", 0.12);

        response = newInventory.contains(newFilling);
        Assertions.assertTrue(response);

        response = newInventory.contains(newFilling2);
        Assertions.assertFalse(response);
    }
}
