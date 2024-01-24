package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.booleanuk.core.Basket;

public class BasketTestExtension2 {
    @Test
    public void test() {
        Basket basket = new Basket();
        basket.changeCapacity(100);
        basket.addItem("BGLO");
        basket.addItem("BGLO");

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");

        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");

        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("COFB");

        Assertions.assertEquals("I don't know how to test a receipt", basket.printReceipt());

    }
}
