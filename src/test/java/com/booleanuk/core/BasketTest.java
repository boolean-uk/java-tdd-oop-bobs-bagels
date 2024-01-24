package com.booleanuk.core;

import com.booleanuk.extension.Discounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void testAddBagelToBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("Product added to basket", basket.add("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testAddMultipleBagelsToBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLP"));
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLE"));
    }

    @Test
    public void testAddMultipleOffSameBagelToBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.getBasketMap().containsKey("BGLO"));
        Assertions.assertEquals(3, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testAddNoneExistingBagelToBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testAddBagelToFullBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("Product not found", basket.add("AAAHHH"));
    }

    @Test
    public void testAddFillingDirectlyToBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("Filling must be added to a bagel", basket.add("FILE"));

    }

    @Test
    public void testRemoveBagelFromBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLO"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLO"));
    }

    @Test
    public void testRemoveMultipleBagelsFromBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLP");
        basket.add("BGLE");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLP"));
        Assertions.assertFalse(basket.getBasketMap().containsKey("BGLP"));

    }

    @Test
    public void testRemoveMultipleOffSameBagelFromBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertEquals("Product removed from basket", basket.remove("BGLO"));
        Assertions.assertEquals(2, (int) basket.getBasketMap().get("BGLO"));
    }

    @Test
    public void testRemoveNoneExistingBagelFromBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("Product is not in basket", basket.remove("AAAHHH"));
    }

    @Test
    public void testRemoveBagelNotInBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("Product is not in basket", basket.remove("BGLO"));
    }

    @Test
    public void testSetBasketCapacity() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertTrue(basket.setCapacity(3));
    }

    @Test
    public void testSetBasketCapacityAndAddMoreThanLimit() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProducts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
    }

    @Test
    public void testSetBasketCapacityBelowNumberOfProductsThenAdd() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        Assertions.assertTrue(basket.setCapacity(1));
        Assertions.assertEquals("Basket is full", basket.add("BGLO"));
    }

    @Test
    public void testGetTotalCostForBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLP");
        Assertions.assertEquals(0.49+0.49+0.39, basket.totalCost());
    }

    @Test
    public void testGetTotalCostForEmptyBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals(0, basket.totalCost());
    }

    @Test
    public void testAddFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        Assertions.assertEquals("Filling added", basket.addFilling("FILB"));
    }

    @Test
    public void testAddFillingWithNoBagelInBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        Assertions.assertEquals("You need to add a bagel to your basket", basket.addFilling("FILB"));
    }

    @Test
    public void testAddNoneExistingFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        Assertions.assertEquals("Filling was not found", basket.addFilling("AAHHHH"));
    }

    @Test
    public void testAddProductThatIsNotFillingWithBagelInBasket() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.add("BGLO");
        Assertions.assertEquals("Product needs to be a filling", basket.addFilling("COFB"));
    }

    @Test
    public void testTotalCostDiscountsMultipleTypeProducts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.setCapacity(30);
        basket.add("BGLO"); basket.add("BGLO");
        for(int i = 0; i < 12; i++) {
            basket.add("BGLP");
        }
        for(int i = 0; i < 6; i++) {
            basket.add("BGLE");
        }
        basket.add("COFB"); basket.add("COFB"); basket.add("COFB");
        Assertions.assertEquals(10.3, basket.totalCostDiscount());
    }

    @Test
    public void testTotalCostDiscountsOneTypeProduct() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.setCapacity(30);
        for(int i = 0; i < 16; i++) {
            basket.add("BGLP");
        }
        Assertions.assertEquals(5.55, basket.totalCostDiscount());
    }

    @Test
    public void testTotalCostDiscountsNoDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.setCapacity(30);
        for(int i = 0; i < 16; i++) {
            basket.add("BGLS");
        }
        Assertions.assertEquals(0.49*16.0, basket.totalCostDiscount());
    }

    @Test
    public void testReceiptDiscountWithDiscounts() {
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket basket = new Basket(inventory, checkout);
        basket.setCapacity(30);
        basket.add("BGLO"); basket.add("BGLO");
        for(int i = 0; i < 12; i++) {
            basket.add("BGLP");
        }
        for(int i = 0; i < 6; i++) {
            basket.add("BGLE");
        }
        basket.add("COFB"); basket.add("COFB"); basket.add("COFB");
        String receipt = basket.receiptDiscount();
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
        Basket basket = new Basket(inventory, checkout);
        basket.setCapacity(30);
        basket.add("BGLO"); basket.add("BGLO");

        String receipt = basket.receiptDiscount();
        Assertions.assertFalse(receipt.contains("You saved a total of"));
        Assertions.assertFalse(receipt.contains("(-$"));
    }
}