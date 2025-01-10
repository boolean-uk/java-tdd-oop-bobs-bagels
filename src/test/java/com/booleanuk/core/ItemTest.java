package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void checkBagelPriceTest() {
        Item item = new Item("BGLP");
        Assertions.assertEquals(0.39F, item.checkBagelPrice());
    }

    @Test
    public void checkBagelPriceOfNotBagelTest() {
        Item item = new Item("COFW");
        Assertions.assertEquals(-1.0F, item.checkBagelPrice());
    }
}
