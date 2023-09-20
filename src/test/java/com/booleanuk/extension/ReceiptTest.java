package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReceiptTest {

    Inventory inventory;
    Basket basket;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        basket = new Basket(20);

        inventory.addProduct(new Product("Onion", 0.49, "BGLO"));
        inventory.addProduct(new Product("Plain", 0.39, "BGLP"));
        inventory.addSpecialOffer(new SpecialOffer("BGLP", 12, 3.99));
    }

    @Test
    public void testGenerateReceipt() {
        for (int i = 0; i < 12; i++) {
            basket.addProduct(new Product("Plain", 0.39, "BGLP"));
        }
        basket.addProduct(new Product("Onion", 0.49, "BGLO"));
        basket.addProduct(new Product("Onion", 0.49, "BGLO"));

        Receipt receipt = basket.generateReceipt("Bob's Bagels", inventory);

        receipt.printReceipt();

        List<ReceiptItem> items = receipt.getItems();
        double actualTotal = 0.0;
        for (ReceiptItem item : items) {
            actualTotal += item.getCost();
        }

        Assertions.assertEquals(4.97, actualTotal, 0.01);
    }

}
