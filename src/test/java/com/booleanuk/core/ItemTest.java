package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    void getCostShouldBe049() {
        Item item = new Item("BGLO");

        Assertions.assertEquals(0.49, item.getCost());
    }
}
