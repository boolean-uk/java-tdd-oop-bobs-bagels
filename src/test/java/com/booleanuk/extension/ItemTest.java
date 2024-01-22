package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private com.booleanuk.core.Basket basket;
    private com.booleanuk.core.Item testItem;
    @Test
    public void testItem(){
        basket = new com.booleanuk.core.Basket(10);
        testItem = new com.booleanuk.core.Item("BGLO","Bagel", 2.5, "test");

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
