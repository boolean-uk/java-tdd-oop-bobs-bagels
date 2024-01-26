package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    public void testPrintExtension2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
        Bagel bagelEverything = new  Bagel("BGLE", 0.49, "Everything");

        Coffee coffeeBlack = new Coffee("COFB", 0.99, "Black");


        //add 14 plain bagels , 7 onion bagels and 7 sesame bagels
        basket.add(bagelOnion, 2);
        basket.add(bagelplain, 12);
        basket.add(bagelEverything, 6);

        //add 3 cappuccinos, 2 white coffees and 1 black coffee

        basket.add(coffeeBlack, 3);

        String example = "~~~ Bob's Bagels ~~~\n\n" +
                java.time.LocalDateTime.now().format(formatter) + "\n" +
                "----------------------------\n" +
                "Everything Bagel     6   £2.49\n" +
                "Plain Bagel         12   £3.99\n" +
                "Bagel & Coffee       2   £2.50\n" +
                "Black Coffee         1   £0.99\n" +
                "----------------------------\n" +
                "Total                 £9.97\n\n" +
                "        Thank you\n" +
                "      for your order!";

        double total = basket.getCostOfBasket();
        System.out.println( );
        Receipt receipt = new Receipt(
                basket.getQuantityMap(), basket.getDiscountedProducts(),
                basket.getAppliedDiscounts(), total);
        Assertions.assertEquals(removeSpaces(example), removeSpaces(receipt.toString()));
    }

    @Test
    public void testPrintExtension3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new Bagel("BGLO", 0.49, "Onion");
        Bagel bagelEverything = new Bagel("BGLE", 0.49, "Everything");

        Coffee coffeeBlack = new Coffee("COFB", 0.99, "Black");


        //add 14 plain bagels , 7 onion bagels and 7 sesame bagels
        basket.add(bagelOnion, 2);
        basket.add(bagelplain, 12);
        basket.add(bagelEverything, 6);

        //add 3 cappuccinos, 2 white coffees and 1 black coffee

        basket.add(coffeeBlack, 3);

        String example = "~~~ Bob's Bagels ~~~\n\n" +
                java.time.LocalDateTime.now().format(formatter) + "\n" +
                "----------------------------\n" +
                "Everything Bagel       6   £2.49\n" +
                "                           -(£0.45)\n" +
                "Plain Bagel            12  £3.99\n" +
                "                           -(£0.69)\n" +
                "Bagel & Coffee         2   £2.50\n" +
                "                           -(£0.46)\n" +
                "Black Coffee           1   £0.99\n" +
                "----------------------------\n" +
                "Total                 £9.97\n\n" +
                "        Thank you\n" +
                "      for your order!";

        double total = basket.getCostOfBasket();
        System.out.println();
        Receipt receipt = new Receipt(
                basket.getQuantityMap(), basket.getDiscountedProducts(),
                basket.getAppliedDiscounts(), total);
        Assertions.assertEquals(removeSpaces(example), removeSpaces(receipt.receiptextension3()));
    }

    // Help methods
    private static String removeSpaces(String input) {
        // Replace all spaces in the string with an empty string
        return input.replaceAll("\\s", "");
    }

    @Test
    public void testPrintExtension3MoreThan1RoundOfbagelDiscounts(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Basket basket = new Basket();
        Basket.setMaxSize(100);
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");

        //add 25 plain bagels

        basket.add(bagelplain, 25);

        //add 3 cappuccinos, 2 white coffees and 1 black coffee

        String example = "~~~ Bob's Bagels ~~~\n\n" +
                java.time.LocalDateTime.now().format(formatter) + "\n" +
                "----------------------------\n" +
                "Plain Bagel         12   £3.99\n" +
                "                           -(£0.69)\n" +
                "Plain Bagel         12   £3.99\n" +
                "                           -(£0.69)\n" +
                "Plain Bagel         1   £0.39\n" +
                "----------------------------\n" +
                "Total                 £8.37\n\n" +
                "        Thank you\n" +
                "      for your order!";

        double total = basket.getCostOfBasket();
        System.out.println( );
        Receipt receipt = new Receipt(
                basket.getQuantityMap(), basket.getDiscountedProducts(),
                basket.getAppliedDiscounts(), total);
        Assertions.assertEquals(removeSpaces(example), removeSpaces(receipt.receiptextension3()));
    }
}