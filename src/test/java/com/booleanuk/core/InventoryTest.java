package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddBagelType() {
        inventory.addBagelType("Plain", 2.0);

        Assertions.assertTrue(inventory.isBagelAvailable("Plain"));
        Assertions.assertEquals(2.0, inventory.getBagelsPrice("Plain"));
    }

    @Test
    public void testAddFilling() {
        inventory.addFilling("egg", 0.12);
        Assertions.assertEquals(0.12, inventory.getFillingPrice("egg"));
    }

    @Test
    public void testAddDuplicateBagelType() {
        inventory.addBagelType("everything", 0.49);
        inventory.addBagelType("everything", 0.39);

        Assertions.assertEquals(0.49, inventory.getBagelsPrice("everything"));
    }

    @Test
    public void testAddDuplicateFilling() {
        inventory.addFilling("ham", 0.12);
        inventory.addFilling("ham", 0.25);

        Assertions.assertEquals(0.12, inventory.getFillingPrice("ham"));
    }

}