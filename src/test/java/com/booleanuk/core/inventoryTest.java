package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class inventoryTest {

    @Test
    public void TestShouldMakeBagelWithFilling(){
        Inventory inventory = new Inventory();

        Bagel bagel = (Bagel) inventory.getItem("BGLP", "FILS");
        Filling fillingValue = bagel.getFillingSku();

        //This should fail because the filling is not the right one
        Assertions.assertNotEquals(fillingValue.retrieveSku(), "FILB");

        //This should however work.
        Assertions.assertEquals(fillingValue.retrieveSku(), "FILS");

    }

}
