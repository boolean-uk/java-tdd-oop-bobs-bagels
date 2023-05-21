package com.booleanuk.core.basket.items;

import com.booleanuk.core.items.*;
import com.booleanuk.core.items.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInventory {
    Inventory newInventory = new BobsInventory();

    @Test
    public void testContainsBagel(){
        Bagel newBagel = new Bagel("Onion", 0.49);
        Bagel newBagel2 = new Bagel("Honey", 0.49);

        // Bagel exists
        boolean response = newInventory.contains(newBagel);
        Assertions.assertTrue(response);

        // Bagel doesn't exist
        response = newInventory.contains(newBagel2);
        Assertions.assertFalse(response);

        // bagel exists but fillings are not taken into account
        newBagel.add(new BagelFilling("Egg", 0.12));
        Assertions.assertTrue(newInventory.contains(newBagel));
    }

    @Test
    public void testContainsCoffee(){
        Item newCoffee = new Coffee("White", 1.19) ;
        Item newCoffee2 = new Coffee("Latte Macchiato", 1.19) ;

        boolean response = newInventory.contains(newCoffee);
        Assertions.assertTrue(response);

        response = newInventory.contains(newCoffee2);
        Assertions.assertFalse(response);
    }

    @Test
    public void testContainsFilling(){
        Item newFilling = new BagelFilling("Egg", 0.12);
        Item newFilling2 = new BagelFilling("Nutella", 0.12);

        boolean response = newInventory.contains(newFilling);
        Assertions.assertTrue(response);

        response = newInventory.contains(newFilling2);
        Assertions.assertFalse(response);
    }
}
