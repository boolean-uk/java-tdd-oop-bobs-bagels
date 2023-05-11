package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {
    @Test
    void bagelAvailableShouldSucceed() {
        Inventory inventory = new Inventory();
        Bagel bagel = new Bagel();
        inventory.bagels = new ArrayList<>() {{ add(bagel); }};

        Assertions.assertTrue(inventory.bagelAvailable(bagel.getType()));
    }
    @Test
    void bagelAvailableShouldFail() {
        Inventory inventory = new Inventory();
        inventory.bagels = new ArrayList<>();

        Assertions.assertFalse(inventory.bagelAvailable(BAGELTYPE.NORMAL));
    }

    @Test
    void fillingAvailableShouldSucceed() {
        Inventory inventory = new Inventory();
        Filling filling = new Filling();
        inventory.fillings = new ArrayList<>() {{ add(filling); }};

        Assertions.assertTrue(inventory.fillingAvailable(filling.getType()));
    }
    @Test
    void fillingAvailableShouldFail() {
        Inventory inventory = new Inventory();
        inventory.fillings = new ArrayList<>();

        Assertions.assertFalse(inventory.fillingAvailable(FILLINGTYPE.NORMAL));
    }
}
