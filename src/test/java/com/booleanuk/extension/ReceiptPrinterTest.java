package com.booleanuk.extension;

import com.booleanuk.core.models.Basket;
import com.booleanuk.core.models.Store;
import com.booleanuk.core.models.item.Bagel;
import com.booleanuk.core.models.item.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ReceiptPrinterTest {

    @Test
    public void testCorrectPrintOutput() throws FileNotFoundException {
        Store store = new Store("Bob's Bagels");
        Basket basket = new Basket();

        basket.addItem(store.getItemBySKU("BGLP"));
        Bagel bagelPlain1 = (Bagel) basket.addItem(store.getItemBySKU("BGLP"));
        basket.addItem(store.getItemBySKU("BGLP"));
        Bagel bagelSesame = (Bagel) basket.addItem(store.getItemBySKU("BGLS"));
        basket.addFillingToBagel(bagelPlain1, (Filling) store.getItemBySKU("FILE"));
        basket.addFillingToBagel(bagelSesame, (Filling) store.getItemBySKU("FILB"));
        basket.addItem(store.getItemBySKU("COFL"));

        ReceiptPrinter receiptPrinter = new ReceiptPrinter(store, basket);
        String printedReceipt = receiptPrinter.print();
        System.out.println(printedReceipt);

        // Check for key elements, specific items, and correct cost in the receipt
        Assertions.assertTrue(printedReceipt.contains("~~~ Bob's Bagels ~~~"));
        Assertions.assertTrue(printedReceipt.contains("Total"));
        Assertions.assertTrue(printedReceipt.contains("Thank you"));

        Assertions.assertTrue(printedReceipt.contains("Latte"));
        Assertions.assertTrue(printedReceipt.contains("Egg"));
        Assertions.assertTrue(printedReceipt.contains("Sesame"));

        Assertions.assertTrue(printedReceipt.contains("£3.19"));
    }
}
