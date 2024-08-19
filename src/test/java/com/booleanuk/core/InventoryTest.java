package com.booleanuk.core;

import org.junit.jupiter.api.Test;

public class InventoryTest {
    Inventory inventory;

    @Test
    public void checkInventoryInitialization() {
        this.inventory = new Inventory();
        inventory.printMenu();
    }
}
