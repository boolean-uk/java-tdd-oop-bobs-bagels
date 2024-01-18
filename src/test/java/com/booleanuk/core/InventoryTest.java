package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class InventoryTest {
    private Inventory inventory;
    @BeforeEach
    void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void testAddToMenu(){
        Bagel onionBagel = new Bagel("BGLO", "Onion", 0.49);
        inventory.addToMenu(onionBagel,20);
        Assertions.assertTrue(inventory.isInStock("BGLO"));
        Assertions.assertEquals(20, inventory.getInventory("BGLO"));
    }

    @Test
    public void testDecreaseStock(){
        Coffee blackCoffee = new Coffee("COFB", "Black",0.99);
        inventory.addToMenu(blackCoffee, 15);
        inventory.decreaseStock("COFB");
        Assertions.assertEquals(14, inventory.getInventory("COFB"));
    }

    @Test
    public void testOutOfStock(){
        Filling egg = new Filling("FILE","Egg",0.12);
        inventory.addToMenu(egg,0);
        Assertions.assertEquals(0, inventory.getInventory("FILE"));
    }

}
