package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemTest {
    @Test
    public void testGetPrice(){

        Item newItem = new Item("ABC",20.10,"Any","Any");
        newItem.getFillings().add(new Item("ABC",20.10,"Any","Any"));
        newItem.addFilling(new Item("ABC",0.20,"Filling","Ketchup"));
        newItem.addFilling(new Item("ABC",0.40,"Filling","Mayo"));
        Assertions.assertEquals(40.80,newItem.getPrice(),0.001);

    }

}
