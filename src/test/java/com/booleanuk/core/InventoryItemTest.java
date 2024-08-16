package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryItemTest {

    @Test

    public void testConstructor(){
        InventoryItem product = new InventoryItem("BGLO",0.49, "Bagel","Onion");
        Assertions.assertEquals(product.getName(), "Bagel");
    }
}
