package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @Test
    public void testPrintTest() {
        Customer customer = new Customer();

        Basket basket = new Basket(5);
        Receipt receipt = new Receipt(basket, customer);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));



        //I have not formatted string that much before so i dont know how it will turn out, therefore i have no expected value as of yet"


        Assertions.assertEquals("", receipt.formatDate());
        Assertions.assertEquals("", receipt.formatBasketValues(basket.getItemList()));
        Assertions.assertEquals("", receipt.formatSavings(basket.getItemList()));
        Assertions.assertEquals("", receipt.printBasket());

    }
}
