package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeTest {
    @Test
    public void testCountsDiscountBagel() {
        Coffee c = new Coffee("A", 11, "Name", "Onion");
        Bagel b = new Bagel("A", 11, "Name", "Onion");
        b.setFilling(new Item("B" , 5, "Name", "Variant"));
        c.setDiscountBagel(b);
        assertEquals(27, c.getPrice());
    }
}
