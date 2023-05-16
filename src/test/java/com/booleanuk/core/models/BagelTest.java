package com.booleanuk.core.models;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    Inventory inventory = new Inventory();


    @Test
    void setFillingsTest() {
        Bagel bagel = inventory.getBagels().get(0);
        Filling fill1 = inventory.getFillings().get(0);
        Filling fillError = new Filling("Error",0.0,"error");

        Assertions.assertTrue(bagel.setFillings(fill1, inventory));
        Assertions.assertFalse(bagel.setFillings(fillError, inventory));
        Assertions.assertEquals(1, bagel.fillings.size());




    }
}
