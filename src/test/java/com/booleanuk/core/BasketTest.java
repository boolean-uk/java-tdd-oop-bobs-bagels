package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddItem(){
        Basket basket = new Basket();
        basket.addItem(new Item("BGLO",0.39,"Bagel","Onion"));
        Assertions.assertEquals(basket.getItems().size(),1);
    }

}
