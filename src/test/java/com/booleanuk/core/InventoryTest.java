package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testSearchItem() {
        //Success test
        Inventory inventory = new Inventory();
        Assertions.assertEquals("Onion", inventory.searchItem("BGLO").getVariant());

        //Failure test
        Assertions.assertNull(inventory.searchItem("NXGP"));
    }
}
