package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemCreation() {
    Item item = new Item("BGLP", 0.39, "Plain");
    Assertions.assertEquals("BGLP",item.getId());
    Assertions.assertEquals(0.39, item.getPrice());
    Assertions.assertEquals("Plain", item.getDescription());
    Assertions.assertInstanceOf(Item.class, item);
    }

}
