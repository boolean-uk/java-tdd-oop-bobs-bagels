package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BagelTest {
    @Test
    public void testCountsFilling() {
        Bagel b = new Bagel("A", 11, "Name", "Onion");
        b.setFilling(new Item("B" , 5, "Name", "Variant"));
        assertEquals(16, b.getPrice());
    }
}
