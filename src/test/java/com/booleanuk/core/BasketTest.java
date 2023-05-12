package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddItem(){
        Basket basket = new Basket();
        basket.addItem(new Item("BGLO",0.49,"Bagel","Onion"));
        basket.addItem(new Item("BGLO",0.49,"Bagel","Onion"));
        basket.addItem(new Item("BGLW",0.49,"Bagel","Onion"));
        basket.addItem("BGLO");//overloaded the addItem method
        Assertions.assertEquals(3,basket.getItems().size());
    }

}
