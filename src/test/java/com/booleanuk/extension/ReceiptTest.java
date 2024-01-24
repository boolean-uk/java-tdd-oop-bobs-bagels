package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

//    @Test
//    public void testPrint(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        Basket basket = new Basket();
//        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
//        Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
//        Bagel bagelSesame = new  Bagel("BGLS", 0.49, "Sesame");
//        Coffee cofeewhite = new Coffee("COFW", 1.19, "White");
//        Coffee coffeeBlack = new Coffee("COFB", 0.99, "Black");
//        Coffee cappuccino = new Coffee("COFC", 1.29, "Cappuccino");
//
//        //add 14 plain bagels , 7 onion bagels and 7 sesame bagels
//        basket.add(bagelplain, 14);
//        basket.add(bagelOnion, 7);
//        basket.add(bagelSesame, 7);
//
//        //add 3 cappuccinos, 2 white coffees and 1 black coffee
//        basket.add(cappuccino, 3);
//        basket.add(cofeewhite, 2);
//        basket.add(coffeeBlack, 1);
//
//
//        String example = "~~~ Bob's Bagels ~~~\n\n" +
//                "2021-03-16 21:38:44\n\n" +
//                "----------------------------\n" +
//                "Onion Bagel        2   £0.98\n" +
//                "Plain Bagel        12  £3.99\n" +
//                "Everything Bagel   6   £2.49\n" +
//                "Coffee             3   £2.97\n" +
//                "----------------------------\n" +
//                "Total                 £10.43\n\n" +
//                "        Thank you\n" +
//                "      for your order!";
//
//        Receipt receipt = new Receipt(basket.getQuantityMapWithProducts());
//        Assertions.assertEquals(example, receipt.toString());
//    }

    @Test
    public void testPrint(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Basket basket = new Basket();
        Bagel bagelplain = new  Bagel("BGLP", 0.39, "Plain");
        Bagel bagelOnion = new  Bagel("BGLO", 0.49, "Onion");
        Bagel bagelEverything = new  Bagel("BGLE", 0.49, "Everything");

        Coffee coffeeBlack = new Coffee("COFB", 0.99, "Black");


        //add 14 plain bagels , 7 onion bagels and 7 sesame bagels
        basket.add(bagelplain, 12);
        basket.add(bagelOnion, 2);
        basket.add(bagelEverything, 6);

        //add 3 cappuccinos, 2 white coffees and 1 black coffee

        basket.add(coffeeBlack, 3);


        String example = "~~~ Bob's Bagels ~~~\n\n" +
                "2021-03-16 21:38:44\n\n" +
                "----------------------------\n" +
                "Onion Bagel        2   £0.98\n" +
                "Plain Bagel        12  £3.99\n" +
                "Everything Bagel   6   £2.49\n" +
                "Black Coffee       3   £2.97\n" +
                "----------------------------\n" +
                "Total                 £10.43\n\n" +
                "        Thank you\n" +
                "      for your order!";

        Receipt receipt = new Receipt(basket.getQuantityMapWithProducts());
        Assertions.assertEquals(example, receipt.toString());
    }

}