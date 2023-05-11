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

        Assertions.assertFalse(inventory.bagelAvailable(BAGELTYPE.ONION));
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

        Assertions.assertFalse(inventory.fillingAvailable(FILLINGTYPE.BACON));
    }

    @Test
    void coffeeAvailableShouldSucceed() {
        Inventory inventory = new Inventory();
        Coffee coffee = new Coffee();
        inventory.coffees = new ArrayList<>() {{ add(coffee); }};

        Assertions.assertTrue(inventory.coffeeAvailable(coffee.getType()));
    }
    @Test
    void coffeeAvailableShouldFail() {
        Inventory inventory = new Inventory();
        inventory.coffees = new ArrayList<>();

        Assertions.assertFalse(inventory.coffeeAvailable(COFFEETYPE.BLACK));
    }
}
