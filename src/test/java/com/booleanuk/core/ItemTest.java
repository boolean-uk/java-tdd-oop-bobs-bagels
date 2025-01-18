package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testGetSku(){
        Item item1 = new Item("BGLP");
        Item item2 = new Item("COFB");
        Item item3 = new Item("FILE");
        Assertions.assertEquals("BGLP", item1.getSku());
        Assertions.assertEquals("COFB", item2.getSku());
        Assertions.assertEquals("FILE", item3.getSku());
    }

    @Test
    public void testGetName(){
        Item item1 = new Item("BGLP");
        Item item2 = new Item("COFB");
        Item item3 = new Item("FILE");
        Assertions.assertEquals("Bagel", item1.getName());
        Assertions.assertEquals("Coffee", item2.getName());
        Assertions.assertEquals("Filling", item3.getName());
    }

    @Test
    public void testGetVariant(){
        Item item1 = new Item("BGLP");
        Item item2 = new Item("COFB");
        Item item3 = new Item("FILE");
        Assertions.assertEquals("Plain", item1.getVariant());
        Assertions.assertEquals("Black", item2.getVariant());
        Assertions.assertEquals("Egg", item3.getVariant());
    }

    @Test
    public void testGetPrice(){
        Item item1 = new Item("BGLP");
        Item item2 = new Item("COFB");
        Item item3 = new Item("FILE");
        Assertions.assertEquals(0.39f, item1.getPrice());
        Assertions.assertEquals(0.99f, item2.getPrice());
        Assertions.assertEquals(0.12f, item3.getPrice());
    }
}
