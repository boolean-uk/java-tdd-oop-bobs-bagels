package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
        Assertions.assertFalse(invetory.containsItem("BLLLLL"));
        Assertions.assertTrue(invetory.containsItem("BGLO"));
    }
}
