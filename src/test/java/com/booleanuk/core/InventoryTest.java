package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {
    @Test
    void bagelAvailableShouldSucceed() {
        Inventory.reset();
        Bagel bagel = new Bagel(BAGELTYPE.ONION);
        Inventory.bagels = new ArrayList<>() {{ add(bagel); }};

        Assertions.assertTrue(Inventory.bagelAvailable(bagel.getType()));
    }
    @Test
    void bagelAvailableShouldFail() {
        Inventory.reset();

        Assertions.assertFalse(Inventory.bagelAvailable(BAGELTYPE.ONION));
    }

    @Test
    void fillingAvailableShouldSucceed() {
        Inventory.reset();
        Filling filling = new Filling(FILLINGTYPE.BACON);
        Inventory.fillings = new ArrayList<>() {{ add(filling); }};

        Assertions.assertTrue(Inventory.fillingAvailable(filling.getType()));
    }
    @Test
    void fillingAvailableShouldFail() {
        Inventory.reset();

        Assertions.assertFalse(Inventory.fillingAvailable(FILLINGTYPE.BACON));
    }

    @Test
    void coffeeAvailableShouldSucceed() {
        Inventory.reset();
        Coffee coffee = new Coffee(COFFEETYPE.BLACK);
        Inventory.coffees = new ArrayList<>() {{ add(coffee); }};

        Assertions.assertTrue(Inventory.coffeeAvailable(coffee.getType()));
    }
    @Test
    void coffeeAvailableShouldFail() {
        Inventory.reset();

        Assertions.assertFalse(Inventory.coffeeAvailable(COFFEETYPE.BLACK));
    }
}
