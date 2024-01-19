package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testIfProductInInventory(){
        Inventory inv = new Inventory();
        Bagel bagel = new Bagel(0.39, "BGLP", "Plain");
        Bagel bagel2 = new Bagel(0.69, "BGLOG", "Chocolate");
        Assertions.assertTrue(inv.ProductInList(bagel.getSku()));
        Assertions.assertFalse(inv.ProductInList(bagel2.getSku()));
        Assertions.assertEquals(bagel.getSku(), inv.getItemBySku(bagel.getSku()).getSku());
    }
    @Test
    public void testGetPriceOfProductInInventory(){
        Inventory inv = new Inventory();
        Bagel bagel = new Bagel(0.39, "BGLP", "Plain");
        Assertions.assertTrue(inv.ProductInList(bagel.getSku()));
        Assertions.assertEquals(bagel.getPrice(), inv.getItemBySku(bagel.getSku()).getPrice());
    }
    @Test
    public void testOrderProductIfInInventory(){
    }

}
