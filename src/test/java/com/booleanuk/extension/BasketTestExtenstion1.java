package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTestExtenstion1 {
    @Test
    public void testDiscount() {
        Basket basket = new Basket ();
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

        Assertions.assertEquals(9.97,basket.discount());
    }
}
