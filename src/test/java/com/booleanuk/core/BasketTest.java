package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    void addItemTest(){

        Basket basket = new Basket();


        Assertions.assertTrue(basket.addItem("BGLO"));
    }

    @Test
    void removeItemTest(){
        Basket basket = new Basket();
        basket.addItem("BGLO");


        Assertions.assertTrue(basket.removeItem("BGLO"));
    }


}
