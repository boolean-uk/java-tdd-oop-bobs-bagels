package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class ReceiptTest {
    @Test
    public void testGetReceipt() {
        StringBuilder sb = new StringBuilder();
        Basket basket = new Basket();
        Receipt receipt = new Receipt();

        sb.append("~~~ Bob's Bagels ~~~\n");
        sb.append(java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm\n")));
        sb.append("\n----------------------------\n");
        sb.append("Onion Bagel " + 2+ " 0.98£\n");
        sb.append("Black Coffee " + 3+ " 2.97£\n");
        sb.append("Egg Filling " + 4+ " 0.48£\n");
        sb.append("\n----------------------------\n");
        sb.append("Total cost: " + 4.43+"£\n");

        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");
        basket.addToBasket("COFB");
        basket.addToBasket("COFB");
        basket.addToBasket("FILE");
        basket.addToBasket("FILE");
        basket.addToBasket("FILE");
        basket.addToBasket("FILE");

        //sb.compare return 0 if the stringbuilder contains same character sequence
        Assertions.assertEquals(0, sb.compareTo(receipt.printReceipt(basket)));
    }
}
