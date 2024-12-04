
package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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




        Assertions.assertEquals("     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date()), receipt.formatDate());
        Assertions.assertEquals("Item              Qty      Price\n" + "--------------------------------\n" + "Plain Bagel         3       1.17\n" + "Bacon Filling       1       0.12\n" + "--------------------------------", receipt.formatBasketValues(basket.getItemList()));

    }

    @Test
    public void testDiscountPrint() {
        Customer customer = new Customer();

        Basket basket = new Basket(5);
        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));




        Assertions.assertEquals("     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date()), receipt.formatDate());
        Assertions.assertEquals("Item              Qty      Price\n" + "--------------------------------\n" + "Plain Bagel         6       2.49\n" + "                         (+0.15)\n" + "--------------------------------", receipt.formatBasketValues(basket.getItemList()));

    }

    @Test
    public void testDiscountPrintCoffeeBagelDeal() {
        Customer customer = new Customer();

        Basket basket = new Basket(5);
        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Coffee("Black"));
        basket.addItemToBasket(new Coffee("Black"));
        basket.addItemToBasket(new Coffee("Black"));




        Assertions.assertEquals("     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date()), receipt.formatDate());
        Assertions.assertEquals("Item              Qty      Price\n" + "--------------------------------\n" + "CoffeeBagelDeal     3       3.75\n" + "                         (-0.39)\n" + "--------------------------------", receipt.formatBasketValues(basket.getItemList()));

    }
}
