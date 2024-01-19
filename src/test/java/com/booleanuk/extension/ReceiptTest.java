
package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @Test
    public void testPrintTest() {
        Customer customer = new Customer();

        Basket basket = new Basket(5);
        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));



        //I have not formatted string that much before so i dont know how it will turn out, therefore i have no expected value as of yet"
        Assertions.assertEquals("19-01-2024", receipt.formatDate());
        Assertions.assertEquals("--------------------\n" + "Plain Bagel       1  £0.39\n" + "Plain Bagel       1  £0.39\n" + "Plain Bagel       1  £0.39\n" + "Bacon Filling       1  £0.12\n" + "White Coffee       1  £1.19\n" + "--------------------", receipt.formatBasketValues(basket.getItemList()));
        Assertions.assertEquals("", receipt.formatSavings(basket.getItemList()));
        Assertions.assertEquals("", receipt.printBasket());

    }
}
