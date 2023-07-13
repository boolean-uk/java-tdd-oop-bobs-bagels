package com.booleanuk.core;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.receipt.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {


    @Test
    public void shouldCreateReceiptWithOneEntry()
    {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("SKU1",0.51);
        basket.addProduct(bagel);
        Receipt receipt = new Receipt();
        receipt.createReceipt(basket);
        Assertions.assertEquals(1,receipt.getListOfProducts().size());
    }

    @Test
    public void shouldPrintReceiptWithOneEntry()
    {

        Basket basket = new Basket();
        Bagel bagel = new Bagel("SKU1",0.51);
        basket.addProduct(bagel);
        Receipt receipt = new Receipt();

        Assertions.assertNotNull(receipt.printReceipt(basket));
    }
}
