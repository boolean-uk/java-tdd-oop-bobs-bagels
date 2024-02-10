package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testAddFilling(){
        Inventory inventory = new Inventory();
        Filling filling = new Filling("FILB", 0.12, "Bacon");
        inventory.addFilling(filling);
        Assertions.assertTrue(inventory.isItemExisting("FILB"));
    }

    @Test
    public void removeFillingTest(){
        Inventory inventory = new Inventory();
        Filling filling = new Filling("FILB", 0.12, "Bacon");
        inventory.addFilling(filling);
        inventory.removeFilling(filling);
        Assertions.assertFalse(inventory.isItemExisting("FILB"));
    }
}
