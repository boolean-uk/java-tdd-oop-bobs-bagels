package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    void shouldGetNewBagelFromInventory() {
        Assertions.assertTrue(Inventory.getProduct("BGLO") instanceof Bagel);
    }

    @Test
    void shouldGetNewFillingFromInventory() {
        Assertions.assertTrue(Inventory.getProduct("FILE") instanceof Filling);
    }

    @Test
    void shouldGetNewCoffeeFromInventory() {
        Assertions.assertTrue(Inventory.getProduct("COFB") instanceof Coffee);
    }

    @Test
    void shouldThrowNoSuchProductException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Inventory.getProduct("BLLLLL"));
    }
}
