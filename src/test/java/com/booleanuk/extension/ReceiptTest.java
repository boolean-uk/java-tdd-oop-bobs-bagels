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
        Assertions.assertTrue(receipt.generateReceipt().contains("BGLO\t1\t0.49\n"));

        basket.add(bglo);
        basket.add(bglp);
        Assertions.assertTrue(receipt.generateReceipt().contains("BGLO\t2\t0.98\n"));
        Assertions.assertTrue(receipt.generateReceipt().contains("BGLP\t1\t0.39\n"));
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

    }
}
