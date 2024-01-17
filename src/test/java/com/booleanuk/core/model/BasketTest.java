package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BasketTest {
    private static final String coffeeBlackSKU = "COFB";
    private static final String bagelPlainSKU = "BGLP";

    private static Basket basket;
    private static Item item1;
    private static Item item2;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        Store bobsTest = new Store("TesT Store");
        basket = new Basket(2);
        item1 = bobsTest.getItemBySKU(bagelPlainSKU);
        item2 = bobsTest.getItemBySKU(coffeeBlackSKU);
    }
    @BeforeEach
    public void resetBasket() {
        basket.setBasket(new ArrayList<>());
        basket.setCapacity(2);
    }

    @Test
    public void canCreateEmptyBasket() {
        Basket newBasket = new Basket();
        Assertions.assertEquals(new ArrayList<Item>(), newBasket.getBasket());
    }

    @Test
    public void canAddItemToBasket() {
        Assertions.assertTrue(basket.addItem(item1));
        Assertions.assertEquals(1, basket.getBasket().size());
        Assertions.assertEquals(item1, basket.getBasket().get(0));
    }

    @Test
    public void canNotAddItemsWhenBasketIsFull() {
        Assertions.assertTrue(basket.addItem(item1));
        Assertions.assertTrue(basket.addItem(item1));
        Assertions.assertFalse(basket.addItem(item1));
        Assertions.assertEquals(2, basket.getBasket().size());
    }

    @Test
    public void canRemoveItemFromBasket() {
        Assertions.assertTrue(basket.addItem(item2));
        Assertions.assertTrue(basket.removeItem(item2));
        Assertions.assertEquals(0, basket.getBasket().size());
    }

    @Test
    public void canNotRemoveItemFromBasketIfItDoesNotExist() {
        Assertions.assertTrue(basket.addItem(item1));
        Assertions.assertFalse(basket.removeItem(item2));
    }

    @Test
    public void canChangeBasketCapacity() {
        Assertions.assertEquals(2, basket.getCapacity());
        basket.setCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void getTotalCost() {
        Assertions.assertEquals(0, basket.getTotalCost());
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item2);
        Assertions.assertEquals((0.39 + 0.39 + 0.99), basket.getTotalCost());
    }
}
