package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    void itemAvailableShouldSucceed() {
        Inventory.reset();
        Item item = new Item("BGLO");
        Inventory.add(item);

        Assertions.assertTrue(Inventory.itemAvailable(item));
    }
    @Test
    void itemAvailableShouldFail() {
        Inventory.reset();
        Item item = new Item("BGLO");

        Assertions.assertFalse(Inventory.itemAvailable(item));
    }
}
