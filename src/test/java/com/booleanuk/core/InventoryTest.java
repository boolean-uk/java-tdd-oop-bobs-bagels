package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class InventoryTest {

    private Inventory inventory;
    @BeforeEach
    public void setup(){
        inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
    }
    @Test
    public void testInventoryNotNull(){
        HashMap<String, Item> bagelInventory = inventory.getBagelInventory();
        HashMap<String, Item> fillingInventory = inventory.getFillingInventory();
        HashMap<String, Item> coffeeInventory = inventory.getCoffeeInventory();
        Assertions.assertNotNull(coffeeInventory);
        Assertions.assertNotNull(fillingInventory);
        Assertions.assertNotNull(bagelInventory);
    }

}
