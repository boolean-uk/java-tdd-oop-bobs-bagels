package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testIfBagelInInventory(){
        Inventory inv = new Inventory();
        Assertions.assertFalse(inv.tryFetchBagel("Gingerbread"));
        Assertions.assertTrue(inv.tryFetchBagel("Bacon"));
        Assertions.assertFalse(inv.tryFetchBagel("Black"));
    }
    @Test
    public void testIfCoffeeInInventory(){

    }
    @Test
    public void testGetPriceOfCoffeeInInventory(){

    }
    @Test
    public void testOrderProductIfInInventory(){
    }

}
