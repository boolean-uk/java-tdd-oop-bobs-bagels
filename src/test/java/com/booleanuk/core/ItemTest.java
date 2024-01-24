package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Basket basket;
    private Item testItem;
    @Test
    public void testItem(){
        basket = new Basket(10);
        testItem = new Item("BGLO","Bagel", 2.5, "test");

        Assertions.assertEquals("BGLO", testItem.getSku());
        Assertions.assertEquals("Bagel", testItem.getType());
        Assertions.assertEquals(2.5, testItem.getPrice());
        Assertions.assertEquals("test", testItem.getVariant());
    }
    @Test
    public void itemsToStringTest(){
        basket = new Basket(10);
        testItem = new Item("BGLO","Bagel", 2.5, "test");

        Assertions.assertEquals("BGLO, Bagel, 2.5, test", testItem.toString());
    }
}
