package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void canGetPriceOfItem() {
        Item itemToGetPriceOf = new Item("BGLP", 0.39, "Bagel", "Plain");
        Assertions.assertEquals(0.39, itemToGetPriceOf.getPrice());
    }
}
