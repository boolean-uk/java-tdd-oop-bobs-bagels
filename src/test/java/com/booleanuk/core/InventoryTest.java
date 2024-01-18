package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testInventoryConstructorAddsProducts() {
        Inventory inventory = new Inventory();
        Assertions.assertFalse(inventory.getProducts().isEmpty());
    }

    @Test
    public void testGetExistingProductCost() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0.49, inventory.getProductCost("BGLO"));
    }

    @Test
    public void testGetNoneExistingProductCost() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0, inventory.getProductCost("AAAAHHHH"));
    }

}