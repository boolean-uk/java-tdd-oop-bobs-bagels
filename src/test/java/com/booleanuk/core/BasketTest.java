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

    @Test
    public void testRemoveItem(){
        Basket basket = new Basket();
        basket.addItem(new Item("BGLO",0.49,"Bagel","Onion"));
        basket.addItem(new Item("BGLO",0.49,"Bagel","Onion"));
        basket.removeItem(new Item("BGLO",0.49,"Bagel","Onion"));
        Assertions.assertEquals(1,basket.getItems().size());
        // Remove item failed! message
        basket.removeItem(new Item("BGL233",0.49,"Bagel","Onion"));
        Assertions.assertEquals(1,basket.getItems().size());
    }


}
