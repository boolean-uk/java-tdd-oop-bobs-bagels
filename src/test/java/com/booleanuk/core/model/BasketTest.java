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
    private static Store bobsTest;
    private static Basket basket;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        bobsTest = new Store("TesT Store");
        basket = new Basket(2);
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
        Item itemToAdd = bobsTest.getItemBySKU(bagelPlainSKU);
        Assertions.assertTrue(basket.addItem(itemToAdd));
        Assertions.assertEquals(1, basket.getBasket().size());
        Assertions.assertEquals(itemToAdd, basket.getBasket().get(0));
    }

    @Test
    public void canNotAddItemsWhenBasketIsFull() {
        Item itemToAdd = bobsTest.getItemBySKU(bagelPlainSKU);
        Assertions.assertTrue(basket.addItem(itemToAdd));
        Assertions.assertTrue(basket.addItem(itemToAdd));
        Assertions.assertFalse(basket.addItem(itemToAdd));
        Assertions.assertEquals(2, basket.getBasket().size());
    }

    @Test
    public void canRemoveItemFromBasket() {
        Item itemToAdd = bobsTest.getItemBySKU(coffeeBlackSKU);
        Assertions.assertTrue(basket.addItem(itemToAdd));
        Assertions.assertTrue(basket.removeItem(itemToAdd));
        Assertions.assertEquals(0, basket.getBasket().size());
    }

    @Test
    public void canNotRemoveItemFromBasketIfItDoesNotExist() {
        Item itemToAdd = bobsTest.getItemBySKU(coffeeBlackSKU);
        Item itemNotToAdd = bobsTest.getItemBySKU(bagelPlainSKU);

        Assertions.assertTrue(basket.addItem(itemToAdd));
        Assertions.assertFalse(basket.removeItem(itemNotToAdd));
    }

    @Test
    public void canChangeBasketCapacity() {
        Assertions.assertEquals(2, basket.getCapacity());
        basket.setCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }
}
