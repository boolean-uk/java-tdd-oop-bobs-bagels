package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelsExtensionTest {

    @Test
    public void testReceiptExistsAndCharacters() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);

        basket.changeBasketCapacity(6);

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLO");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("FILB");

        String receipt = order.generateReceipt(basket.getItemList());
        System.out.println(receipt);
        Assertions.assertNotNull(receipt);
        Assertions.assertTrue(receipt.length() > 50);

    }

    @Test
    public void testReceiptWithNoItems() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);

        String receipt = order.generateReceipt(basket.getItemList());
//        System.out.println(receipt);
        Assertions.assertNotNull(receipt);
        Assertions.assertFalse(receipt.length() < 150);
        Assertions.assertFalse(receipt.length() > 155);


    }
    @Test
    public void testDiscounts() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Order order = new Order(inventory);

        basket.addItem("BGLP");
        basket.addItem("BGLP");
    }
}
