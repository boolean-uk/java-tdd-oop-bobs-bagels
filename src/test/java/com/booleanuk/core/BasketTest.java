package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class BasketTest {

    @Test
    public void addingItemsToBasket() {
        Basket basket = new Basket();

        Assertions.assertFalse(basket.addToBasket("FILE"));

        Assertions.assertTrue(basket.addToBasket("BGLO"));
    }

    @Test
    public void removingItemFromBasket() {
        // Testing removing items that exist and does not exist
        Basket basket = new Basket();
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");

        Assertions.assertTrue(basket.removeItem("BGLO"));
        Assertions.assertFalse(basket.removeItem("BGLO"));
        Assertions.assertEquals(1, basket.listOfItems().size());
    }



    @Test
    public void getListOfItems() {
        Basket basket = new Basket();
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");

        Assertions.assertEquals(basket.getBasketList(), basket.listOfItems());
    }

    @Test
    public void getTotalPriceOfBasket() {
        Basket basket = new Basket();
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");

        Assertions.assertEquals(1.48, basket.getTotalCost());
    }

    @Test
    public void changeCapasityOfBasket() {
        Basket basket = new Basket();

        basket.changeCapasity(200);
        Assertions.assertEquals(200, basket.getCapasity());
    }

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

    @Test
    public void testDiscountOnBasketList() {
        Basket basket = new Basket();
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");

        Assertions.assertEquals(5.73,basket.getTotalCost());


    }
}
