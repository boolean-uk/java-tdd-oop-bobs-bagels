package com.booleanuk.core;

import com.booleanuk.core.items.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void canGetPriceOfItem() {
        Bagel itemToGetPriceOf = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        Assertions.assertEquals(0.39, itemToGetPriceOf.getPrice());
    }
}
