package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testType () {
        Item item = new Item("Bagel", 0.29, "BGLG", "Gluten-free");
        Assertions.assertEquals("Bagel", item.getType());
        item.setType("Coffee");
        Assertions.assertEquals("Coffee", item.getType());
    }


}
