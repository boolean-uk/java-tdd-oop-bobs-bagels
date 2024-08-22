package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    Inventory inventory;


    @Test
    public void checkInventoryInitialization() {

        // TODO: How to test print statements
        this.inventory = new Inventory();
        inventory.printMenu();
    }

    @Test
    public void getProductBasedOnSKU() {
        this.inventory = new Inventory();

        Coffee coffee = inventory.getCoffeeProduct("COFC");
        Assertions.assertEquals(ProductName.COFFEE, coffee.getName());

        Bagel bagel = inventory.getBagelProduct("BAGE");
        Assertions.assertEquals(ProductName.BAGEL, bagel.getName());

        Filling filling = inventory.getFillingProduct("FILB");
        Assertions.assertEquals(ProductName.FILLING, filling.getName());
    }
    // TODO: Add test for exception returned when SKU is invalid / Does npt exist
    //TODO: Add test for only product no specific version

//    @Test
//    public void getProductPrice() {
//        this.inventory.getItemPrice();
//    }
}
