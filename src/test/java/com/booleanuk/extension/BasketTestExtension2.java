package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.booleanuk.core.Basket;

public class BasketTestExtension2 {
    @Test
    public void test() {
        Basket basket = new Basket();
        basket.changeCapacity(25);
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

        Assertions.assertEquals("", basket.receipt());

    }
}
