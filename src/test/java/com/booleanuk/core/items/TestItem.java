package com.booleanuk.core.items;

import com.booleanuk.core.items.*;
import com.booleanuk.core.items.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestItem {
    @Test
    public void testBagel() {
        Item i = new Bagel("nuttela", 10.2);

        // test the methods of the item interface
        Assertions.assertEquals("Nuttela", i.variant());
        Assertions.assertEquals(10.2, i.cost());

        // test the equality of items
        Item i2 = new Bagel("nuttela", 10.2);

        Assertions.assertEquals(i, i2);
    }

    @Test
    public void testCoffee() {
        Item i = new Coffee("cappuccino", 10.2);

        // test the methods of the item interface
        Assertions.assertEquals("Cappuccino", i.variant());
        Assertions.assertEquals(10.2, i.cost());

        // test the equality of items
        Item i2 = new Bagel("cappuccino", 10.2);

        Assertions.assertEquals(i, i2);
    }

    @Test
    public void testFilling() {
        Item i = new BagelFilling("oreo", 10.2);

        // test the methods of the item interface
        Assertions.assertEquals("Oreo", i.variant());
        Assertions.assertEquals(10.2, i.cost());

        // test the equality of items
        Item i2 = new Bagel("oreo", 10.2);

        Assertions.assertEquals(i, i2);
    }

}
