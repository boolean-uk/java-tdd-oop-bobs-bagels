package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PackageTest {
    @Test
    void getAvailableShouldBeTrue() {
        Inventory.reset();
        Inventory.add(new Item("BGLO"));
        Inventory.add(new Item("COFB"));
        ArrayList<Item> items = new ArrayList<>() {{
           add(new Item("BGLO"));
           add(new Item("COFB"));
        }};
        Package pack = new Package(items, 1.25, -0.23);

        Assertions.assertTrue(pack.getAvailable());
    }
    @Test
    void getAvailableShouldBeFalse() {
        Inventory.reset();
        ArrayList<Item> items = new ArrayList<>() {{
            add(new Item("BGLO"));
            add(new Item("COFB"));
        }};
        Package pack = new Package(items, 1.25, -0.23);

        Assertions.assertFalse(pack.getAvailable());
    }
}
