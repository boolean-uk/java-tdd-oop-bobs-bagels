package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testGetInventoryList(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(14, inventory.getInventoryList().size());
    }
}
