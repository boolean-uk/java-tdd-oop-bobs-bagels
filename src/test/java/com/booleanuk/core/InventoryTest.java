package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testGetInventoryList(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(14, inventory.getInventoryList().size());
    }

    @Test
    public void testGetItemPrice() {
        Inventory inventory = new Inventory();
        Item item = new Item("BGLS", 0.49,"Bagel", "Sesame");

        Assertions.assertEquals(0.49, inventory.getPrice(item));
    }
}
