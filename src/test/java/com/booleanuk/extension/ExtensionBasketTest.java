package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtensionBasketTest {

    @Test
    public void testCalculateTotalCostOfBasketWithDiscounts(){
        ExtensionBasket basket = new ExtensionBasket();
        Menu menu = new Menu();

        Item item1 = new OnionBagel();
        basket.add(item1, menu);
        Item item2 = new OnionBagel();
        basket.add(item2, menu);
        Item item3 = new PlainBagel();
        basket.add(item3, menu);
        Item item4 = new PlainBagel();
        basket.add(item4, menu);
        Item item5 = new PlainBagel();
        basket.add(item5, menu);
        Item item6 = new PlainBagel();
        basket.add(item6, menu);
        Item item7 = new PlainBagel();
        basket.add(item7, menu);
        Item item8 = new PlainBagel();
        basket.add(item8, menu);
        Item item9 = new PlainBagel();
        basket.add(item9, menu);
        Item item10 = new PlainBagel();
        basket.add(item10, menu);
        Item item11 = new PlainBagel();
        basket.add(item11, menu);
        Item item12 = new PlainBagel();
        basket.add(item12, menu);
        Item item13 = new PlainBagel();
        basket.add(item13, menu);
        Item item14 = new PlainBagel();
        basket.add(item14, menu);
        Item item15 = new EverythingBagel();
        basket.add(item15, menu);
        Item item16 = new EverythingBagel();
        basket.add(item16, menu);
        Item item17 = new EverythingBagel();
        basket.add(item17, menu);
        Item item18 = new EverythingBagel();
        basket.add(item18, menu);
        Item item19 = new EverythingBagel();
        basket.add(item19, menu);
        Item item20 = new EverythingBagel();
        basket.add(item20, menu);
        Item item21 = new BlackCoffee();
        basket.add(item21, menu);
        Item item22 = new BlackCoffee();
        basket.add(item22, menu);
        Item item23 = new BlackCoffee();
        basket.add(item23, menu);

        Assertions.assertEquals(10.43, basket.calculateTotalCostOfBasketWithDiscounts());


    }

    @Test
    public void testCalculateTotalCostOfBasketWithDiscounts2(){
        Menu menu = new Menu();
        ExtensionBasket basket = new ExtensionBasket();

        for(int i = 0; i < 16; i++){
            Item plainBagel = new PlainBagel();
            basket.add(plainBagel, menu);
        }

        Assertions.assertEquals(5.55, basket.calculateTotalCostOfBasketWithDiscounts(), 0.001);
    }

    @Test
    public void testCalculateTotalCostOfBasketWithDiscounts3(){
        Menu menu = new Menu();
        ExtensionBasket basket = new ExtensionBasket();


        Item bagel = new PlainBagel();
        Item coffee = new WhiteCoffee();

        basket.add(bagel, menu);
        basket.add(coffee, menu);

        Assertions.assertEquals(1.25, basket.calculateTotalCostOfBasketWithDiscounts());
    }

    @Test
    public void testCalculateTotalCostOfBasketWithDiscountsAndReceipt(){
        ExtensionBasket basket = new ExtensionBasket();
        Menu menu = new Menu();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);


        Item item1 = new OnionBagel();
        basket.add(item1, menu);
        Item item2 = new OnionBagel();
        basket.add(item2, menu);
        Item item3 = new PlainBagel();
        basket.add(item3, menu);
        Item item4 = new PlainBagel();
        basket.add(item4, menu);
        Item item5 = new PlainBagel();
        basket.add(item5, menu);
        Item item6 = new PlainBagel();
        basket.add(item6, menu);
        Item item7 = new PlainBagel();
        basket.add(item7, menu);
        Item item8 = new PlainBagel();
        basket.add(item8, menu);
        Item item9 = new PlainBagel();
        basket.add(item9, menu);
        Item item10 = new PlainBagel();
        basket.add(item10, menu);
        Item item11 = new PlainBagel();
        basket.add(item11, menu);
        Item item12 = new PlainBagel();
        basket.add(item12, menu);
        Item item13 = new PlainBagel();
        basket.add(item13, menu);
        Item item14 = new PlainBagel();
        basket.add(item14, menu);
        Item item15 = new EverythingBagel();
        basket.add(item15, menu);
        Item item16 = new EverythingBagel();
        basket.add(item16, menu);
        Item item17 = new EverythingBagel();
        basket.add(item17, menu);
        Item item18 = new EverythingBagel();
        basket.add(item18, menu);
        Item item19 = new EverythingBagel();
        basket.add(item19, menu);
        Item item20 = new EverythingBagel();
        basket.add(item20, menu);
        Item item21 = new BlackCoffee();
        basket.add(item21, menu);
        Item item22 = new BlackCoffee();
        basket.add(item22, menu);
        Item item23 = new BlackCoffee();
        basket.add(item23, menu);

        String expectedReceipt =
                "    ~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "    "+ timestamp +"\n" +
                "\n" +
                "----------------------------\n" +
                "\n" +
                "Onion        2  £0.98\n" +
                "Plain        12  £3.99\n" +
                "Everything        6  £2.49\n" +
                "Black        3  £2.97\n" +
                "\n" +
                "----------------------------\n" +
                "Total                  £10.43\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!";

        Assertions.assertEquals(expectedReceipt, basket.calculateTotalCostOfBasketWithDiscountsAndReceipt());


    }

    @Test
    public void testCalculateTotalCostOfBasketWithDiscounts2AndReceipt(){
        Menu menu = new Menu();
        ExtensionBasket basket = new ExtensionBasket();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);



        for(int i = 0; i < 16; i++){
            Item plainBagel = new PlainBagel();
            basket.add(plainBagel, menu);
        }

        String expectedReceipt =
                "    ~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "    " + timestamp + "\n" +
                "\n" +
                "----------------------------\n" +
                "\n" +
                "Plain        16  £5.55\n" +
                "\n" +
                "----------------------------\n" +
                "Total                  £5.55\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!";

        Assertions.assertEquals(expectedReceipt, basket.calculateTotalCostOfBasketWithDiscountsAndReceipt());
    }
}
