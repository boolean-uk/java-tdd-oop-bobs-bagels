package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testGetInventoryList(){
        Inventory inventory = new BagelShopInventory();
        Assertions.assertEquals(14, inventory.getInventoryList().size());
    }

    @Test
    public void testGetItemPrice() {
        Inventory inventory = new BagelShopInventory();
        Item item = new Bagel("BGLS", 0.49,"Bagel", "Sesame");
        Assertions.assertEquals("The price of Sesame Bagel is 0.49", inventory.showPrice(item));
    }
}