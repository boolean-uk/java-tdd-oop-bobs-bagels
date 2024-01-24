package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testGetters() {
        InventoryItem saw = new InventoryItem("Saw", "Handheld", 12.99, 0);
        InventoryItem anotherSaw = new InventoryItem("Saw", "Motor", 52.99, 0);

        Assertions.assertEquals(12.99, saw.getPrice());
        Assertions.assertEquals("Saw", saw.getName());
        Assertions.assertEquals("Handheld", saw.getType());
        Assertions.assertEquals("Saw Handheld", saw.getNametype());

        Assertions.assertEquals(52.99, anotherSaw.getPrice());
        Assertions.assertEquals("Saw", anotherSaw.getName());
        Assertions.assertEquals("Motor", anotherSaw.getType());
        Assertions.assertEquals("Saw Motor", anotherSaw.getNametype());
    }
}
