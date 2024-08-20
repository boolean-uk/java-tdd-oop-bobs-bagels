package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class InventoryTest {
    Inventory inventory;

    @Test
    public void checkInventoryInitialization() {

        // TODO: How to test print statements
        this.inventory = new Inventory();
        inventory.printMenu();
    }

    // TODO: Add more tests
}
