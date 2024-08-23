package com.booleanuk.core.basket;


import com.booleanuk.core.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BasketTest {

    Inventory inventory;
    Basket basket;

    @Test
    public void printBasket() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());
        basket.printBasket();
    }

    // User story #1: Add specific bagel
    // Specific type is here to select SKU for specific bagel variant
    @Test
    public void addProductsToBasket() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.add(new Coffee("COFC"));
        basket.add(new Bagel("BAGE"));
        basket.add(new Filling("FILB"));

        // Fillings should not be able to be added without a bagel
        Assertions.assertEquals(2, basket.getAll().size());
        Assertions.assertEquals(2, basket.getSize());

        basket.printBasket();
    }

    // TODO: Add test for adding something that do not exist

    // TODO: Add test for maxcapacity error

    @Test
    public void addBagelAndFilling() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.printBasket();

        Assertions.assertEquals("BAGE", basket.getAll().get(1).getSKU());
        Assertions.assertEquals("FILS", basket.getAll().get(101).getSKU());
    }

    // User story #2: Remove a bagel
    @Test
    public void removeBagelShouldAlsoRemoveFillings() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());
        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.printBasket();

        // TODO: Add test
        basket.remove(1);
        Assertions.assertNull(basket.getAll().get(1));
        Assertions.assertNull(basket.getAll().get(101));
        basket.printBasket();
    }
}
