package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReceiptTest {
    @Test
    public void receiptTest(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Assert that added items are found in the receipt.
        Basket basketOne = new Basket();
        ArrayList<String> receiptContent = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Item item = Menu.getItemFromMenu("Plain Bagel");
            basketOne.addItemToBasket(item);
            assert item != null;
            receiptContent.add(item.getName());
        }

        Item item = Menu.getItemFromMenu("Black Coffee");
        assert item != null;
        basketOne.addItemToBasket(item);
        receiptContent.add(item.getName());

        Receipt receipt = new Receipt(basketOne);
        receipt.printReceipt();

        String output = out.toString();

        for (String s : receiptContent){
            assert output.contains(s);
        }
    }
}
