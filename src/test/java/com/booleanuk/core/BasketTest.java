package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BasketTest {
    Inventory inventory;
    Basket basket;

    @Test
    public void checkPrintBasket() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.printBasket();
    }

    @Test
    public void addCoffee() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.addCoffee("COFW");
        basket.printBasket();
        Assertions.assertEquals("COFW", basket.getAll().get(1).getSKU());
    }

    // User story #1 Add a specific type of bagel
    @Test
    public void addBagelAndFilling() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.addBagel("BAGE", Arrays.asList("FILS","FILB"));
        basket.printBasket();
        Assertions.assertEquals("BAGE", basket.getAll().get(1).getSKU());
        Assertions.assertEquals("FILS", basket.getAll().get(101).getSKU());
    }

    // User story #1 Add a specific type of bagel
    @Test
    public void removeBagel() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());
        basket.addBagel("BAGE", Arrays.asList("FILS","FILB"));
        basket.addBagel("BAGE", Arrays.asList("FILS","FILB"));
        basket.printBasket();

        // TODO: Add test
        basket.remove(1);
        basket.printBasket();
    }

//    @Test
//    public void tryToAddProductThatIsNotInInventory() {
//        this.inventory = new Inventory();
//        this.basket = new Basket(new Inventory());
//        basket.addBagel("HELLO", Arrays.asList("FILS","FILB"));
//        basket.printBasket();
//    }

    // User story #3 Notify when max capacity of basket is reached
    @Test
    public void exceedMaxCapacityShouldThrowError() {
        this.inventory = new Inventory();
        this.basket = new Basket(new Inventory());

        basket.changeMaxCapacity(2);
        basket.addBagel("BAGE");
        basket.addBagel("BAGE");

        // TODO: I need to set addToBasket() to protected instead of private and
        // test it because I can't test addBgel()/addCoffe() because they includes a try/catch
        MaxCapacityException exception = Assertions.assertThrows(MaxCapacityException.class, () -> {
            basket.addToBasket(11,new BasketItem("BAGE"));
        });
//        Assertions.assertEquals("Basket is full, can't add more items.", exception.getLocalizedMessage());

        // Print out message from exception instead of checking if its assertEqual
        System.out.println("\nException message:");
        System.out.println("\t" + exception.getMessage() + "\n");

        // Public method that should print out the error
//        basket.addBagel("BAGE");
    }
}
