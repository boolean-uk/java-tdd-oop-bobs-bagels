package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testGetSku(){
        Item item1 = new Item("BGLP", "Bagel", "Plain", 0.39);
        Item item2 = new Item("COFB", "Coffee", "Black", 0.99);
        Item item3 = new Item("FILE", "Filling", "Egg", 0.12);
        Assertions.assertEquals("BGLP", item1.getSku());
        Assertions.assertEquals("COFB", item2.getSku());
        Assertions.assertEquals("FILE", item3.getSku());
    }

    @Test
    public void testGetName(){
        Item item1 = new Item("BGLP", "Bagel", "Plain", 0.39);
        Item item2 = new Item("COFB", "Coffee", "Black", 0.99);
        Item item3 = new Item("FILE", "Filling", "Egg", 0.12);
        Assertions.assertEquals("Bagel", item1.getName());
        Assertions.assertEquals("Coffe", item2.getName());
        Assertions.assertEquals("Filling", item3.getName());
    }

    @Test
    public void testGetVariant(){
        Item item1 = new Item("BGLP", "Bagel", "Plain", 0.39);
        Item item2 = new Item("COFB", "Coffee", "Black", 0.99);
        Item item3 = new Item("FILE", "Filling", "Egg", 0.12);
        Assertions.assertEquals("Plain", item1.getVariant());
        Assertions.assertEquals("Black", item2.getVariant());
        Assertions.assertEquals("Egg", item3.getVariant());
    }

    @Test
    public void testGetPrice(){
        Item item1 = new Item("BGLP", "Bagel", "Plain", 0.39);
        Item item2 = new Item("COFB", "Coffee", "Black", 0.99);
        Item item3 = new Item("FILE", "Filling", "Egg", 0.12);
        Assertions.assertEquals(0.39, item1.getPrice());
        Assertions.assertEquals(0.99, item2.getPrice());
        Assertions.assertEquals(0.12, item3.getPrice());
    }
}
