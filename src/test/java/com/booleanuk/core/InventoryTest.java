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

}