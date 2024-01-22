package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item;
import com.booleanuk.core.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class DiscountManagerTest {
    static Store store;
    static Basket basket;

    @BeforeEach
    public void resetTests() throws FileNotFoundException, URISyntaxException {
        store = new Store("Bob's Bagels");
        basket = new Basket(40);
    }

    @Test
    public void doesCalculateTheCorrectDiscount() {
        // EXTENSION 1 - Example 1
        // FIXME Example 1 in the .md file is wrong. It does not apply the coffee-bagel discount to the onion bagels
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

        Assertions.assertEquals(1.6, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(9.97, basket.getTotalCost(),  0.01); // 10.43 is wrong
    }

    @Test
    public void testOneBagelHasMultipleDiscounts() {
        // EXTENSION 1 - Example 2
        Item bagelEverything = store.getItemBySKU("BGLP");
        for (int i = 0; i < 16; i++) {
            basket.addItem(bagelEverything);
        }

        Assertions.assertEquals(16, basket.getBasket().size());
        Assertions.assertEquals(0.69, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(5.55, basket.getTotalCost(),  0.01);

        for (int i = 0; i < 8; i++) {
            basket.addItem(bagelEverything);
        }

        Assertions.assertEquals(24, basket.getBasket().size());
        Assertions.assertEquals(1.38, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(7.98, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testOneBagelHasMultipleDifferentBulkDiscounts() {
        Item bagelEverything = store.getItemBySKU("BGLE");
        for (int i = 0; i < 16; i++) {
            basket.addItem(bagelEverything);
        }

        Assertions.assertEquals(1.89, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(5.95, basket.getTotalCost(),  0.01);

        for (int i = 0; i < 4; i++) {
            basket.addItem(bagelEverything);
        }

        Assertions.assertEquals(20, basket.getBasket().size());
        Assertions.assertEquals(1.89 + 0.45, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(7.46, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testPlainBagelAndCoffeeComboDiscount() {
        basket.addItem(store.getItemBySKU("BGLP"));
        basket.addItem(store.getItemBySKU("COFB"));

        Assertions.assertEquals(0.13, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(1.25, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testOtherBagelAndCoffeeComboDiscount() {
        basket.addItem(store.getItemBySKU("BGLE"));
        basket.addItem(store.getItemBySKU("COFB"));

        Assertions.assertEquals(0.23, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(1.25, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testTwoBagelsAndOneCoffeeComboDiscount() {
        basket.addItem(store.getItemBySKU("BGLE"));
        basket.addItem(store.getItemBySKU("BGLE"));
        basket.addItem(store.getItemBySKU("COFB"));

        Assertions.assertEquals(0.23, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(1.74, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testOneBagelsAndThreeCoffeeComboDiscount() {
        basket.addItem(store.getItemBySKU("BGLP"));
        basket.addItem(store.getItemBySKU("COFB"));
        basket.addItem(store.getItemBySKU("COFB"));
        basket.addItem(store.getItemBySKU("COFB"));

        Assertions.assertEquals(0.13, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(3.23, basket.getTotalCost(),  0.01);
    }
}
