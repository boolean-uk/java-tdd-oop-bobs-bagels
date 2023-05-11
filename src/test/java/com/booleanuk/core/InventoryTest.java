package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testShowPrice(){
        Inventory inventory = new Inventory();
        Assertions.assertEquals(inventory.showPrice(new Item("BGLO",0.49,"Bagel","Onion")),0.49);
    }
}
