package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void beforeEach() {
        inventory = new Inventory(List.of("BGLO", "BGLP", "BGLE"));
    }

    @Test
    void shouldCheckIfInvetoryContainsItem() {
        Assertions.assertFalse(inventory.containsItem("BLLLLL"));
        Assertions.assertTrue(inventory.containsItem("BGLO"));
    }
}
