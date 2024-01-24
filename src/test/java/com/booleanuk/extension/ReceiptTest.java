package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import com.booleanuk.extension.ReceiptHandler;
import org.junit.jupiter.api.Test;

public class ReceiptTest {
    @Test
    public void testPrintOfReceipt() {
        Basket basket = new Basket();
        basket.changeCapacity(50);
        for (int i = 0; i < 6; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        for (int i = 0; i < 3; i++) {
            basket.add(new Product("Filling", 0.12, "FILB", "Bacon"));
        }
        ReceiptHandler receiptHandler = new ReceiptHandler(basket);
        System.out.println(receiptHandler.print());
    }
}
