
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
        basket.addItemToBasket(new Coffee("White"));





        Assertions.assertEquals("     " + new SimpleDateFormat("dd-MM-yyyy : HH-mm-ss").format(new Date()), receipt.formatDate());
        Assertions.assertEquals("Item              Qty      Price\n" + "--------------------------------\n" + "Plain Bagel         3       1.17\n" + "Bacon Filling       1       0.12\n" + "White Coffee        1       1.19\n" + "--------------------------------", receipt.formatBasketValues(basket.getItemList()));

    }
}
