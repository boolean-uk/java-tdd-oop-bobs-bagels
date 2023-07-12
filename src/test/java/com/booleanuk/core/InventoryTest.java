package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testGetBagelBySKU(){
        Bagle bagel1 = new Bagle("BGLO",0.49,"Onion");
        Bagle bagel2 = new Bagle("BGLP",0.39,"Plain");
        Inventory inventory= new Inventory();
        inventory.addBagel(bagel1);
        inventory.addBagel(bagel2);

        Bagle retrievedBagel = inventory.getBagelBySKU("BGLO");
        Assertions.assertEquals(bagel1, retrievedBagel);
    }
    @Test
    public void testGetCoffeeBySKU() {
        Coffee coffee1 = new Coffee("COFB", 0.99, "Black");
        Coffee coffee2 = new Coffee("COFW", 1.19, "White");
        Inventory inventory = new Inventory();
        inventory.addCoffee(coffee1);
        inventory.addCoffee(coffee2);

        Coffee retrievedCoffee = inventory.getCoffeeBySKU("COFB");
        Assertions.assertEquals(coffee1, retrievedCoffee);
    }
    @Test
    public void testGetFillingBySKU() {
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");
        Inventory inventory = new Inventory();
        inventory.addFilling(filling1);
        inventory.addFilling(filling2);

        Filling retrievedFilling = inventory.getFillingBySKU("FILB");
        Assertions.assertEquals(filling1, retrievedFilling);
    }
    @Test
    public void testcheckAvailability() {
        Bagle bagel = new Bagle("BGLO",0.49,"Onion");
        Inventory inventory = new Inventory();
        inventory.addBagel(bagel);

        boolean isAvailable = inventory.checkAvailability("BGLO");
        Assertions.assertTrue(isAvailable);
    }
    @Test
    public void testgetItemPrice() {
        Bagle bagel = new Bagle("BGLO",0.49,"Onion");
        Inventory inventory = new Inventory();
        inventory.addBagel(bagel);

        double price = inventory.getItemPrice("BGLO");
        Assertions.assertEquals(0.49,price,0.01);
    }
    @Test
    public void testcheckAvailability_NotAvaible() {
        Bagle bagel = new Bagle("BGLO",0.49,"Onion");
        Inventory inventory = new Inventory();
        inventory.addBagel(bagel);

        boolean isAvailable = inventory.checkAvailability("BGLK");
        Assertions.assertFalse(isAvailable);
    }
    @Test
    public void testgetItemPrice_NotFound() {
        Inventory inventory = new Inventory();

        double price = inventory.getItemPrice("BGLO");
        Assertions.assertEquals(0.0,price,0.01);
    }




}
