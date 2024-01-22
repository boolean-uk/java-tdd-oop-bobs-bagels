package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class InventoryTest {

    private com.booleanuk.core.Inventory inventory;
    @BeforeEach
    public void setup(){
        inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
    }
    @Test
    public void testInventoryNotNull(){
        HashMap<String, com.booleanuk.core.Item> bagelInventory = inventory.getBagelInventory();
        HashMap<String, com.booleanuk.core.Item> fillingInventory = inventory.getFillingInventory();
        HashMap<String, Item> coffeeInventory = inventory.getCoffeeInventory();
        Assertions.assertNotNull(coffeeInventory);
        Assertions.assertNotNull(fillingInventory);
        Assertions.assertNotNull(bagelInventory);
    }

}
