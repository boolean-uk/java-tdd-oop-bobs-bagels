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
    public void doesCalculateTheCorrectDiscount() throws FileNotFoundException, URISyntaxException {
        // EXTENSION 1 - Example 1
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

        Assertions.assertEquals(1.14, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(10.43, basket.getTotalCost(),  0.01);
    }

    @Test
    public void testOneBagelHasMultipleDiscounts() throws FileNotFoundException, URISyntaxException {
        // EXTENSION 1 - Example 2
        Item bagelEverything = store.getItemBySKU("BGLP");
        for (int i = 0; i < 16; i++) {
            basket.addItem(bagelEverything);
        }

        Assertions.assertEquals(16, basket.getBasket().size());
        Assertions.assertEquals(0.69, DiscountManager.calculateBasketBagelDiscounts(basket), 0.01);
        Assertions.assertEquals(5.55, basket.getTotalCost(),  0.01);
    }
}
