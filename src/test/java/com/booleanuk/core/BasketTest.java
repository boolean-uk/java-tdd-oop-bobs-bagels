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
        basket.removeItem("BGLO"); //overloaded the remove item to take the sku as well
        Assertions.assertEquals(0,basket.getItems().size());
    }
    @Test
    public void testSetCapacity(){
        Basket basket = new Basket();
        Assertions.assertEquals(5,basket.getCapacity());
        basket.setCapacity(10);
        Assertions.assertEquals(10,basket.getCapacity());
        basket.setCapacity(1);
        Assertions.assertEquals(1,basket.getCapacity());
        basket.addItem("BGLO");
        basket.setCapacity(2);
        basket.addItem("BGLE");
        basket.setCapacity(1);
        Assertions.assertEquals(2,basket.getCapacity());
    }

    @Test
    public void testGetTotalCost(){
        Basket basket = new Basket();
        basket.addItem("BGLO");
        basket.addItem("BGLO");
        Assertions.assertEquals(0.98,basket.getTotalPrice());
    }

}
