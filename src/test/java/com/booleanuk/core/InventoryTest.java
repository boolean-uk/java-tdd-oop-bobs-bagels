package com.booleanuk.core;

import com.booleanuk.core.products.bagels.Bagel;
import com.booleanuk.core.products.bagels.OnionBagel;
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

    @Test
    public void testCheckIfProductIsNotInInventory() {
        Inventory inv = new Inventory();

        Bagel b = new OnionBagel();
        inv.decreaseQuantity(b); // Assume customer puts this bagel in their basket

        Assertions.assertFalse(inv.productIsInStock(b));
    }

}
