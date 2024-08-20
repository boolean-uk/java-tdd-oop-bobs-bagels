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

    @Test
    void changeBasketSizeTest(){
        Basket basket = new Basket();
        basket.addItem("BGLO");


        Assertions.assertEquals(12, basket.changeBasketSize(12));
    }

    @Test
    void checkPriceTest(){
        Basket basket = new Basket();
        basket.addItem("BGLO");


        Assertions.assertEquals(0.49, basket.getTotalPrice());
    }

    @Test
    void addFilling(){
        Basket basket = new Basket();
        basket.changeBasketSize(20);
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLE");
        basket.addItem("BGLE");


        basket.addFilling("BGLE", "FILC");
        basket.addFilling("BGLE", "FILC");

        Assertions.assertTrue(basket.addFilling("BGLO", "FILS"));

    }

    @Test
    void addDiscountTest(){
        Basket basket = new Basket();
        basket.changeBasketSize(20);
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLE");
        basket.addItem("COFB");
        basket.addItem("BGLE");
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLE");
        basket.addItem("COFB");
        basket.addItem("BGLE");
        basket.addItem("BGLP");
        basket.addItem("BGLE");

        basket.addFilling("BGLE", "FILC");
        basket.addFilling("BGLE", "FILC");


        double newTotal = basket.addDiscount();


    }


}
