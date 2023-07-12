package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testGetBagelBySKU(){
        Inventory inventory= new Inventory();
        Bagle bagel= inventory.getBagelBySKU("BGLO");
        Assertions.assertEquals("BGLO", bagel.getSKU());
    }
    @Test
    public void testGetCoffeeBySKU() {
        Inventory inventory = new Inventory();


        Coffee coffee = inventory.getCoffeeBySKU("COFB");
        Assertions.assertEquals("COFB", coffee.getSKU());
    }
    @Test
    public void testGetFillingBySKU() {
        Inventory inventory = new Inventory();

        Filling filling = inventory.getFillingBySKU("FILB");
        Assertions.assertEquals("FILB", filling.getSKU());
    }
    @Test
    public void testcheckAvailability() {
        Inventory inventory = new Inventory();

        boolean isAvailable = inventory.checkAvailability("BGLO");
        Assertions.assertTrue(isAvailable);
        boolean isAvailable1 = inventory.checkAvailability("BGLIO");
        Assertions.assertFalse(isAvailable1);
    }
    @Test
    public void testgetItemPrice() {
        Inventory inventory = new Inventory();
        double price = inventory.getItemPrice("BGLO");
        Assertions.assertEquals(0.49,price,0.01);
    }
    @Test
    public void testcheckAvailability_NotAvaible() {
        Inventory inventory = new Inventory();
        boolean isAvailable = inventory.checkAvailability("BGLK");
        Assertions.assertFalse(isAvailable);
    }
    @Test
    public void testgetItemPrice_NotFound() {
        Inventory inventory = new Inventory();

        double price = inventory.getItemPrice("BGLUU");
        Assertions.assertEquals(0.0,price,0.01);
    }




}
