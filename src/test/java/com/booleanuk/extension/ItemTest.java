package com.booleanuk.extension;

import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testGetSku(){
        com.booleanuk.core.Item item1 = new com.booleanuk.core.Item("BGLP");
        com.booleanuk.core.Item item2 = new com.booleanuk.core.Item("COFB");
        com.booleanuk.core.Item item3 = new com.booleanuk.core.Item("FILE");
        Assertions.assertEquals("BGLP", item1.getSku());
        Assertions.assertEquals("COFB", item2.getSku());
        Assertions.assertEquals("FILE", item3.getSku());
    }

    @Test
    public void testGetName(){
        com.booleanuk.core.Item item1 = new com.booleanuk.core.Item("BGLP");
        com.booleanuk.core.Item item2 = new com.booleanuk.core.Item("COFB");
        com.booleanuk.core.Item item3 = new com.booleanuk.core.Item("FILE");
        Assertions.assertEquals("Bagel", item1.getName());
        Assertions.assertEquals("Coffee", item2.getName());
        Assertions.assertEquals("Filling", item3.getName());
    }

    @Test
    public void testGetVariant(){
        com.booleanuk.core.Item item1 = new com.booleanuk.core.Item("BGLP");
        com.booleanuk.core.Item item2 = new com.booleanuk.core.Item("COFB");
        com.booleanuk.core.Item item3 = new com.booleanuk.core.Item("FILE");
        Assertions.assertEquals("Plain", item1.getVariant());
        Assertions.assertEquals("Black", item2.getVariant());
        Assertions.assertEquals("Egg", item3.getVariant());
    }

    @Test
    public void testGetPrice(){
        com.booleanuk.core.Item item1 = new com.booleanuk.core.Item("BGLP");
        com.booleanuk.core.Item item2 = new com.booleanuk.core.Item("COFB");
        com.booleanuk.core.Item item3 = new Item("FILE");
        Assertions.assertEquals(0.39f, item1.getPrice());
        Assertions.assertEquals(0.99f, item2.getPrice());
        Assertions.assertEquals(0.12f, item3.getPrice());
    }
}
