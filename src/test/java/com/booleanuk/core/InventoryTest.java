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
    public void testGetInventoryOfItem(){
        inventory.addToMenu(new Bagel("BGLO","Onion",0.49),20);
        Assertions.assertEquals(20, inventory.getInventory("BGLO"));
    }

    @Test
    public void testAddToMenu(){
        Bagel onionBagel = new Bagel("BGLO", "Onion", 0.49);
        inventory.addToMenu(onionBagel,20);
        Assertions.assertTrue(inventory.isInStock("BGLO"));
        Assertions.assertEquals(20, inventory.getInventory("BGLO"));
    }
    @Test
    public void testIsInStock(){
        inventory.addToMenu(new Bagel("BGLP","Plain",0.39),10);
        inventory.addToMenu(new Bagel("BGLO","Onion",0.49),5);
        Assertions.assertEquals(true,inventory.isInStock("BGLP"));
        Assertions.assertEquals(true,inventory.isInStock("BGLO"));
        Assertions.assertEquals(false,inventory.isInStock("COFB"));

    }

    @Test
    public void testDecreaseStock(){
        Coffee blackCoffee = new Coffee("COFB", "Black",0.99);
        inventory.addToMenu(blackCoffee, 15);
        inventory.decreaseStock("COFB");
        Assertions.assertEquals(14, inventory.getInventory("COFB"));
    }

    @Test
    public void testGetMenu(){
        inventory.addToMenu(new Bagel("BGLP","Plain",0.39),3);
        inventory.addToMenu(new Bagel("BGLO","Onion",0.49),3);
        Assertions.assertEquals("Menu: \n"+"BGLP: Bagel - Plain - 0.39$ \n" + "BGLO: Bagel - Onion - 0.49$ \n",
                inventory.getMenu());
        System.out.println(inventory.getMenu());
    }
}
