package com.booleanuk.extension;

import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemExTest {

    @Test
    public void testGetters() {
        ItemEx saw = new ItemEx(12.99, "Saw", "Handheld");
        Item anotherSaw = new Item(52.99, "Saw", "Motor");

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
