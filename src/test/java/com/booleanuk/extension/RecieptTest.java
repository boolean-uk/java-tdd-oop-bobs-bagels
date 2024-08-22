package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Reciept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecieptTest {

    @Test
    public void TestShouldPrintReciept(){
        Basket basket = new Basket();

        basket.add("BGLO");

        Assertions.assertEquals(1, basket.retrieveProductCount());

        Reciept reciept = new Reciept(basket);
        reciept.printReciept();
    }

    @Test
    public void TestShouldPrintRecieptInCorrectFormat(){
        Basket basket = new Basket();
        basket.changeCapacity(30);

        int o = 2;
        int p = 12;
        int e = 6;
        int bc = 3;

        for(int i = 0; i < o; i++){
            basket.add("BGLO");
        }

        for(int i = 0; i < p; i++){
            basket.add("BGLP");
        }

        for(int i = 0; i < e; i++){
            basket.add("BGLE");
        }

        for(int i = 0; i < bc; i++){
            basket.add("COFB");
        }

        Reciept reciept = new Reciept(basket);
        reciept.printReciept();
    }

}
