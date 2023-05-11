package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void testGetPrice(){
        Item newItem = new Item("ABC",20.10,"Any","Any");
        newItem.getFillings().add(new Item("ABC",20.10,"Any","Any"));

        Assertions.assertEquals(40.20,newItem.getPrice());
    }

}
