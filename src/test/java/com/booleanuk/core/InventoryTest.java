package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testIsValidBagel(){
        Bagel valid = new Bagel("BGLO", 0.49, "Onion");
        Bagel wrongPrice = new Bagel("BGLO", 0.39, "Onion");
        Bagel wrongVariant = new Bagel("BGLO", 0.49, "Plain");
        Bagel wrongId = new Bagel("BGL", 0.49, "Onion");

        Assertions.assertTrue(Inventory.isValidBagel(valid));
        Assertions.assertFalse(Inventory.isValidBagel(wrongId));
        Assertions.assertFalse(Inventory.isValidBagel(wrongVariant));
        Assertions.assertFalse(Inventory.isValidBagel(wrongPrice));
    }
    @Test
    public void testIsValidCoffee(){
        Coffee valid = new Coffee("COFB", 0.99, "Black");
        Coffee wrongPrice = new Coffee("COFB", 1.99, "Black");
        Coffee wrongVariant = new Coffee("COF", 0.99, "Black");
        Coffee wrongId = new Coffee("COFB", 0.99, "White");

        Assertions.assertTrue(Inventory.isValidCoffee(valid));
        Assertions.assertFalse(Inventory.isValidCoffee(wrongId));
        Assertions.assertFalse(Inventory.isValidCoffee(wrongVariant));
        Assertions.assertFalse(Inventory.isValidCoffee(wrongPrice));
    }
    @Test
    public void testIsValidFilling(){
        Filling valid = new Filling("FILB", 0.12, "Bacon");
        Filling wrongPrice = new Filling("FILB", 0.32, "Bacon");
        Filling wrongVariant = new Filling("FIL", 0.12, "Bacon");
        Filling wrongId = new Filling("FILB", 0.12, "Cheese");

        Assertions.assertTrue(Inventory.isValidFilling(valid));
        Assertions.assertFalse(Inventory.isValidFilling(wrongId));
        Assertions.assertFalse(Inventory.isValidFilling(wrongVariant));
        Assertions.assertFalse(Inventory.isValidFilling(wrongPrice));
    }
}