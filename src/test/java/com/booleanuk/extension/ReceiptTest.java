package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.BobsBagelsShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ReceiptTest {
    @Test
    public void generateReceipt() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 10);
        testInventory.put(bglp, 10);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        Receipt receipt = new Receipt(basket);

        Assertions.assertEquals("Basket is empty.", receipt.generateReceipt());
        basket.add(bglo);
        Assertions.assertEquals("Header\nBGLO\nFooter", receipt.generateReceipt());
        basket.add(bglo);
        basket.add(bglp);
        Assertions.assertEquals("Header\nBGLO\nBGLP\nFooter", receipt.generateReceipt());
    }

    @Test
    public void createHeader() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 10);
        testInventory.put(bglp, 10);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        Receipt receipt = new Receipt(basket);

        Assertions.assertEquals("    ~~~ Bob's Bagels ~~~\n\n    " +
                receipt.getDateAndTime().toString().replace("T", " ")+
                "\n\n----------------------------\n", receipt.createHeader());
    }

    @Test
    public void createFooter() {
    }

    @Test
    public void printReceipt() {
    }
}
