package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testGettingAThing(){
        Bagel bagel = new Bagel("BGLP");

        Bagel bagel2 = Inventory.getBagels().get("BGLP");

        Assertions.assertEquals(bagel, bagel2);


    }

}