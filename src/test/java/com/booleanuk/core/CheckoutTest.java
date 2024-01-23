package com.booleanuk.core;

import com.booleanuk.extension.Discounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @Test
    void totalCost() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 6);
        Assertions.assertEquals(0.49*6,checkout.totalCost(basket));
    }

    @Test
    void totalCostDiscountEmptyMap() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        Assertions.assertEquals(0,checkout.totalCostDiscount(basket));
    }

    @Test
    void totalCostDiscountSingleProduct() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 6);
        Assertions.assertEquals(2.49,checkout.totalCostDiscount(basket));
    }

    @Test
    void totalCostDiscountSingleProductNoDiscount() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 5);
        Assertions.assertEquals(0.49*5,checkout.totalCostDiscount(basket));
    }

    @Test
    public void testTotalCostDiscountsMultipleTypeProducts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 2);
        basket.put("BGLP",12);
        basket.put("BGLE", 6);
        basket.put("COFB",3);
        Assertions.assertEquals(10.3, checkout.totalCostDiscount(basket));
    }

    @Test
    void testReceiptDiscountWithDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 2);
        basket.put("BGLP",12);
        basket.put("BGLE", 6);
        basket.put("COFB",3);

        String receipt = checkout.receiptDiscount(basket);
        Assertions.assertTrue(receipt.contains("$10.3"));
        Assertions.assertTrue(receipt.contains("(-$0.69)"));
        Assertions.assertTrue(receipt.contains("(-$0.45)"));
        Assertions.assertTrue(receipt.contains("Onion Bagel"));
        Assertions.assertTrue(receipt.contains("Plain Bagel"));
        Assertions.assertTrue(receipt.contains("Everything Bagel"));
        Assertions.assertTrue(receipt.contains("Coffee"));
        Assertions.assertTrue(receipt.contains("You saved a total of $1.27"));
    }

    @Test
    public void testReceiptDiscountWithoutDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("BGLO", 2);

        String receipt = checkout.receiptDiscount(basket);
        Assertions.assertFalse(receipt.contains("You saved a total of"));
        Assertions.assertFalse(receipt.contains("(-$"));
    }
}