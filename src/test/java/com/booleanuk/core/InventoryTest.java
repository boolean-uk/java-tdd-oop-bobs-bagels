package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class InventoryTest {

    @Test
    public void testInventoryInit() {

        Inventory inventory = new Inventory();
        Map<String, Double> fillings = Map.of("FILB", 0.12,"FILE", 0.12,"FILC", 0.12,"FILX", 0.12,"FILS", 0.12,"FILH", 0.12);
        Map<String, Double> coffees = Map.of("COFB", 0.99,"COFW", 1.19,"COFC", 1.29,"COFL", 1.29);
        Map<String, Double> bagels = Map.of("BGLO", 0.49,"BGLP", 0.39,"BGLE", 0.49);


        Assertions.assertTrue(fillings.equals(inventory.getFillings()));
        Assertions.assertTrue(coffees.equals(inventory.getCoffes()));
        Assertions.assertTrue(bagels.equals(inventory.getBagels()));

    }
}
