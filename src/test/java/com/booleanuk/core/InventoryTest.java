package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    public InventoryTest() {

    }

    @Test
    public void testCheckIfProductInInventory() {
        Inventory inv = new Inventory();
        Basket basket = new Basket();

        Bagel bagel = new OnionBagel();

        Assertions.assertTrue(inv.productIsInStock(bagel));
    }

}
