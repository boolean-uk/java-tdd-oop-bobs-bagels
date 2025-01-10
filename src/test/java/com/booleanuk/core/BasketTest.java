package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAddItem(){
        Basket basket = new Basket();
        basket.addItem("BGLP");
        basket.addItem("FILE");
        Assertions.assertTrue();
    }

    @Test
    public void testRemoveItem(){

    }

    @Test
    public void testCheckCapacity(){

    }

    @Test
    public void testChangeCapacity(){

    }

    @Test
    public void testTotalCost(){

    }

}
