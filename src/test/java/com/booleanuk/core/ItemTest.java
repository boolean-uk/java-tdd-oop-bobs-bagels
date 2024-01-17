package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {


    @Test
    public void testInit() {
        Item item = new Item();
    }

    @Test
    public void setGetPrice() {
        Item item = new Item();

        item.setPrice(2.50);

        Assertions.assertEquals(2.50, item.getPrice());
    }
}
