package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void TestGetItem() {
        //Success test
        Inventory inventory = new Inventory();
        Assertions.assertEquals("Onion", inventory.getItem("BGLO").variant);

        //Failure test
        Assertions.assertNull(inventory.getItem("NXGP"));
    }
}
