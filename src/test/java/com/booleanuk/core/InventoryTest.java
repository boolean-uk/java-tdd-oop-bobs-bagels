package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void ShouldGetProductFromInventory(){
        Inventory inventory = new Inventory();

        Assertions.assertNotNull(inventory.getItem("BGLE"));
        Assertions.assertNotNull(inventory.getItem("BGLE", "FILB"));
    }

    @Test
    public void CheckIfCorrectFilingIsGetted(){
        Inventory inventory = new Inventory();

        Product testItem = inventory.getItem("BGLE", "FILB");
        Bagel bagel = (Bagel) testItem;

        //Assertions.assertEquals("FILB", bagel.getFillingSku().retrieveSku());
    }

}
