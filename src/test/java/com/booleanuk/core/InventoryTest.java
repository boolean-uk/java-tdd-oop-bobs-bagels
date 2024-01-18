package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testInventoryConstructorAddsProducts() {
        Inventory inventory = new Inventory();
        Assertions.assertFalse(inventory.getProducts().isEmpty());
    }

    @Test
    public void testGetExistingProductCost() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0.49, inventory.getProductCost("BGLO"));
    }

    @Test
    public void testGetNoneExistingProductCost() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals(0, inventory.getProductCost("AAAAAHHHH"));
    }

    @Test
    public void testListFillingCosts() {
        Inventory inventory = new Inventory();
        Assertions.assertEquals("Bacon: 0.12$\nEgg: 0.12$\nCheese: 0.12$\nCream Cheese: 0.12$\nSmoked Salmon: 0.12$\nHam: 0.12$", inventory.listFillingCosts());
    }

    @Test
    public void testListFillingCostsWithNoneInProductsList() {
        Inventory inventory = new Inventory();
        inventory.getProducts().removeAll(inventory.getProducts().stream().filter(x -> x.getName().equals("Filling")).toList());
        Assertions.assertEquals("No fillings available", inventory.listFillingCosts());
    }

}