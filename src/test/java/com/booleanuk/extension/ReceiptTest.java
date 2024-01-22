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
        Assertions.assertTrue(receipt.generateReceipt().contains("Onion Bagel\t\t1\t\u00A30.49\n"));

        basket.add(bglo);
        basket.add(bglp);
        Assertions.assertTrue(receipt.generateReceipt().contains("Onion Bagel\t\t2\t\u00A30.98\n"));
        Assertions.assertTrue(receipt.generateReceipt().contains("Plain Bagel\t\t1\t\u00A30.39\n"));
        Assertions.assertTrue(receipt.generateReceipt().contains("\n----------------------------\nTotal                  \u00A3" + basket.totalCost()));
        System.out.println(receipt.generateReceipt());
    }

    @Test
    public void createHeaderAndFooter() {
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
                "\n\n----------------------------\n\n", receipt.createHeader());
        Assertions.assertEquals("\n\n        Thank you\n      for your order!", receipt.createFooter());
    }

    @Test
    public void printReceipt() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 10);
        testInventory.put(bglp, 10);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 3);
        basket.add(bglo);
        basket.add(bglp);
        basket.add(bglp);
        Receipt receipt = new Receipt(basket);

        Assertions.assertFalse(receipt.printReceipt());

        receipt.generateReceipt();
        Assertions.assertTrue(receipt.printReceipt());
    }

    @Test
    public void generateReceiptWithDiscount() {
        HashMap<Item, Integer> testInventory = new HashMap<>();
        Item bglo = new Item("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Item("BGLP","Bagel", "Plain", 0.39);
        testInventory.put(bglo, 50);
        testInventory.put(bglp, 50);
        BobsBagelsShop shop = new BobsBagelsShop(testInventory);
        Basket basket = new Basket(shop, 20);
        Receipt receipt = new Receipt(basket);

        Assertions.assertEquals("Basket is empty.", receipt.generateReceiptWithDiscount());

        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("Onion Bagel\t\t8\t\u00A33.27\n"));
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("(-\u00A30.65)"));

        basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo); basket.add(bglo);
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("Onion Bagel\t\t16\t\u00A35.95\n"));
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("(-\u00A31.89)"));

        basket.add(bglp); basket.add(bglp);
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("Onion Bagel\t\t16\t\u00A35.95\n"));
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("(-\u00A31.89)"));
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("Plain Bagel\t\t2\t\u00A30.78\n"));
        Assertions.assertFalse(receipt.generateReceiptWithDiscount().contains("(-\u00A30.0)"));
        Assertions.assertTrue(receipt.generateReceiptWithDiscount().contains("\n----------------------------\nTotal               \u00A3" + 6.73));
        System.out.println(receipt.generateReceiptWithDiscount());
    }
}
