package com.booleanuk.core.model;

import com.booleanuk.core.model.item.Bagel;
import com.booleanuk.core.model.item.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BasketTest {
    private static final int DEFAULT_CAPACITY = 12;
    private static final String coffeeBlackSKU = "COFB";
    private static final String bagelPlainSKU = "BGLP";
    private static final String fillingCheeseSKU = "FILC";

    private static Basket basket;
    private static Item item1;
    private static Item item2;
    private static Item item3;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        Store bobsTest = new Store("TesT Store");
        basket = new Basket();
        item1 = bobsTest.getItemBySKU(bagelPlainSKU);
        item2 = bobsTest.getItemBySKU(coffeeBlackSKU);
        item3 = bobsTest.getItemBySKU(fillingCheeseSKU);
    }
    @BeforeEach
    public void resetBasket() {
        basket.setBasket(new ArrayList<>());
        basket.setCapacity(DEFAULT_CAPACITY);
    }

    @Test
    public void canCreateEmptyBasket() {
        Basket newBasket = new Basket();
        Assertions.assertEquals(new ArrayList<Item>(), newBasket.getBasket());
    }

    @Test
    public void canAddItemToBasket() {
        Item addedItem = basket.addItem(item1);
        Assertions.assertEquals(1, basket.getBasket().size());
        Assertions.assertEquals(addedItem, basket.getBasket().get(0));
    }

    @Test
    public void canChangeBasketCapacity() {
        Assertions.assertEquals(12, basket.getCapacity());
        basket.setCapacity(5);
        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void canNotAddItemsWhenBasketIsFull() {
        basket.setCapacity(2);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item1);
        Assertions.assertEquals(2, basket.getBasket().size());
    }

    @Test
    public void canRemoveItemFromBasket() {
        Item addedItem = basket.addItem(item2);
        Assertions.assertTrue(basket.removeItem(addedItem));
        Assertions.assertEquals(0, basket.getBasket().size());
    }

    @Test
    public void canNotRemoveItemFromBasketIfItDoesNotExist() {
        basket.addItem(item1);
        Assertions.assertFalse(basket.removeItem(item2));
    }

    @Test
    public void getTotalCost() {
        Assertions.assertEquals(0, basket.getTotalCost());
        basket.addItem(item1);
        Assertions.assertEquals(0.39, basket.getTotalCost());
        basket.addItem(item1);
        Assertions.assertEquals(0.78, basket.getTotalCost());
        basket.addItem(item2);
        Assertions.assertEquals(1.77, basket.getTotalCost());
    }

    @Test
    public void canAddFillingToOneBagelAndNotOthersOfTheSameVariant() {
        // Add two of the same items
        Bagel firstItem = (Bagel) basket.addItem(item1);
        Bagel secondItem = (Bagel) basket.addItem(item1);
        System.out.println(firstItem);
        System.out.println(secondItem);
        // Change the filling of one of them
        basket.addFillingToBagel(firstItem, (Filling) item3);
        System.out.println(firstItem);
        System.out.println(secondItem);
        // Check that filling was not set for the second item
        Assertions.assertEquals(0, secondItem.getFilling().size());
        // Check that filling was set for first item
        Assertions.assertEquals(1, firstItem.getFilling().size());
    }
}
