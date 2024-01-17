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
        basket = new Basket(5);
    }

    @BeforeEach
    public void resetBasket() {
        basket.clear();
    }

    @Test
    public void canCreateEmptyBasket() {
        Basket newBasket = new Basket();
        Assertions.assertEquals(new ArrayList<Item>(), newBasket.getBasket());
    }

    @Test
    public void canAddItemToBasket() {
        Item itemToAdd = bobsTest.getItemBySKU(bagelPlainSKU);
        basket.add(itemToAdd);
        Assertions.assertEquals(1, basket.getBasket().size());
        Assertions.assertEquals(itemToAdd, basket.getBasket().get(0));
    }
}
