package com.booleanuk.core.basket;


import com.booleanuk.core.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BasketTest {

    Inventory inventory;
    Basket basket;

    // Print exception method function
    // TODO: Duplication from InventoryTest
    public void printExceptionMessageToConsole(Exception e) {
        System.out.println("\nException message:");
        System.out.println("\t" + e.getMessage() + "\n");
    }

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
    // User story #3: Throw exception when trying to add items and maxCapacity of basket is reached
    @Test
    public void exceedMaxCapacityShouldThrowException() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.changeMaxCapacity(2);
        basket.add(new Coffee("COFC"));
        basket.add(new Bagel("BAGE"));

        // TODO: I need to set addToBasket() to 'protected' instead of 'private', is it ok?
        // It's because I can't test private methods.
        // And I want to test this exception
        // If I just test the "parent method" add() it will not throw an exception
        // because I handle the exception with try/catch in add()
        // add() then calls addToBasket() which is the function that can throw exceptions
        MaxCapacityException e = Assertions.assertThrows(
                MaxCapacityException.class,
                () -> { basket.addToBasket(11, new Bagel("BAGE")); }
        );
        Assertions.assertEquals("Basket is full, can't add more items.", e.getMessage());
        printExceptionMessageToConsole(e);
    }

    @Test
    public void exceedMaxCapacityShouldHandleException() {

        // TODO: Check format on this exception

        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.changeMaxCapacity(2);
        basket.add(new Coffee("COFC"));
        basket.add(new Bagel("BAGE"));

        // Check if basket.add() handles error correct (no exception)
        Assertions.assertDoesNotThrow(() -> basket.add(new Bagel("BAGE")));
    }

    // User story #4: Change max capacity for basket
    @Test
    public void changeMaxCapacity() {
        inventory = new Inventory();
        basket = new Basket(new Inventory());

        basket.changeMaxCapacity(3);
        Assertions.assertEquals(3, basket.getMaxCapacity());

        basket.changeMaxCapacity(12);
        Assertions.assertEquals(12, basket.getMaxCapacity());
    }

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

    // TODO: add method for remove and chekc exception
    // TODO: I need to set removeFromBasket() to 'protected' instead of 'private', is it ok?
    // It's because I can't test private methods.
    // And I want to test this exception
    // If I just test the "parent method" remove() it will not throw an exception
    // because I handle the exception with try/catch in remove()
    // remove() then calls removeFromBasket() which is the function that can throw exceptions
}
