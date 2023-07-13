package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptTest {

    @Test
    void shouldReturnReceiptString() {
        Basket basket = new Basket(100);
        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
        BGLO.setFillings(List.of(new Filling("FILE", BigDecimal.valueOf(3.00), "Egg")));
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
        Coffee COFB = new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");
        basket.add(BGLO);
        basket.add(BGLP);
        basket.add(BGLP);
        basket.add(COFB);
        Receipt receipt = new Receipt(basket);
        String actual = receipt.printReceipt();
        String expected = "";

        Assertions.assertEquals(expected, actual);
    }
}
