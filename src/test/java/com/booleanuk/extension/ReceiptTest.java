package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @Test
    public void testPrintTest() {
        Receipt receipt = new Receipt();
        Basket basket = new Basket(5);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));



        //I have not formatted string that much before so i dont know how it will turn out, therefore i have no expected value as of yet"


        Assertions.assertEquals("", receipt.formatDate());
        Assertions.assertEquals("", receipt.formatTotal());
        Assertions.assertEquals("", receipt.formatSavings());
        Assertions.assertEquals("", receipt.printBasket(basket));

    }
}
