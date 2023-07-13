package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptTest {

    @Test
    void shouldReturnReceiptString() {
        Basket basket = new Basket(100);
        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
        Filling FILE = new Filling("FILE", BigDecimal.valueOf(3.00), "Egg");
        BGLO.setFillings(List.of(FILE, FILE));
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
        Coffee COFB = new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");
        basket.add(BGLO);
        basket.add(BGLP);
        basket.add(BGLP);
        basket.add(COFB);
        Receipt receipt = new Receipt(basket);
        String actual = receipt.printReceipt();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = time.format(formatter);
        String expected = "   ~~~ Bob's Bagels ~~~   \n" +
                formattedTime+"\n" +
                "-------------------------------\n" +
                "Onion Bagel        1 6.49\n" +
                "Egg Filling        2 (6.0)\n" +
                "Plain Bagel        2 0.78\n" +
                "Black Coffee        1 0.99\n" +
                "-------------------------------\n" +
                "Total                     8.26\n" +
                "Thank you for your order!";

        Assertions.assertEquals(expected, actual);
    }
}
