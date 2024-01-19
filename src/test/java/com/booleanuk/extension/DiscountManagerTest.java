package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class DiscountManagerTest {
    static Store store;
    static Basket basket;

    @BeforeAll
    public static void setupBasketWithDiscounts() throws FileNotFoundException, URISyntaxException {
        store = new Store("Bob's Bagels");
        basket = new Basket(40);

        Item bagelOnion = store.getItemBySKU("BGLO");
        basket.addItem(bagelOnion);
        basket.addItem(bagelOnion);
        Item bagelPlain = store.getItemBySKU("BGLP");
        for (int i = 0; i < 12; i++) {
            basket.addItem(bagelPlain);
        }
        Item bagelEverything = store.getItemBySKU("BGLE");
        for (int i = 0; i < 6; i++) {
            basket.addItem(bagelEverything);
        }
        Item coffeeBlack = store.getItemBySKU("COFB");
        basket.addItem(coffeeBlack);
        basket.addItem(coffeeBlack);
        basket.addItem(coffeeBlack);
    }

    @Test
    public void doesCalculateTheCorrectDiscount() throws FileNotFoundException, URISyntaxException {
        Assertions.assertEquals(1.14, DiscountManager.getBasketDiscount(basket), 0.01);
        Assertions.assertEquals(10.43, basket.getTotalCost(),  0.01);
    }

    @Test
    public void doesPrintReceiptWithDiscounts() throws FileNotFoundException, URISyntaxException {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter(store, basket);
        String printedReceipt = receiptPrinter.print();
        System.out.println(printedReceipt);

        Assertions.assertTrue(printedReceipt.contains("Bob's Bagels"));
        Assertions.assertTrue(printedReceipt.contains("Total"));
        Assertions.assertTrue(printedReceipt.contains("Thank you"));

        Assertions.assertTrue(printedReceipt.contains("Plain\t\t12"));
        Assertions.assertTrue(printedReceipt.contains("Discount\t   -£1.14"));
        Assertions.assertTrue(printedReceipt.contains("You saved £1.14\n\t on this shop"));

        Assertions.assertTrue(printedReceipt.contains("£10.43"));
    }
}
