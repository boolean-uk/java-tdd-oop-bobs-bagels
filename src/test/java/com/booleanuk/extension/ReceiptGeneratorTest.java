package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptGeneratorTest {

    private static Receipt RECEIPT;
    private static ReceiptGenerator RECEIPT_GENERATOR;
    @BeforeAll
    public static void createReceiptAndReceiptGenerator() {
        Basket basket = new Basket(30);
        basket.add("BGLO", 2);
        basket.add("BGLP", 14);
        basket.add("BGLE", 6);
        basket.add("FILC", 2);
        basket.add("COFB", 2);

        Checkout checkout = new Checkout(basket);

        RECEIPT = checkout.getReceipt();
        RECEIPT_GENERATOR = new ReceiptGenerator();
    }

    @Test
    public void generateReceiptTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss");
        String date = LocalDateTime.now().format(formatter);

        String expectedReceipt = """
                      ~~~ Bob's Bagels ~~~     \s

                      %s      \s

                --------------------------------

                Everything Bagel      6    £2.49
                                         (-£0.45)
                Plain Bagel           12   £3.99
                                         (-£0.69)
                Onion Bagel           2    £0.98
                CoffeePlusPBagel      2    £2.50
                                         (-£0.26)
                Cheese Filling        2    £0.24

                --------------------------------
                Total                     £10.20

                   You saved a total of £1.40  \s
                          on this shop         \s

                           Thank you           \s
                        for your order!        \s""";


        assertEquals(
                expectedReceipt.formatted(date),
                RECEIPT_GENERATOR.generateReceipt(RECEIPT)
        );
    }
}
