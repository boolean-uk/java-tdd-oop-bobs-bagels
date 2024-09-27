package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasketTest {

    //User story 1
    @Test
    public void shouldReturnTrueIfBagelIsAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        boolean added = basket.addProduct(bagel);
        Assertions.assertTrue(added);
    }

    @Test
    public void shouldReturnFalseIfBagelIsNotAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        boolean added = basket.addProduct(new Bagel("Onion", "BGLO", 0.49));
        Assertions.assertFalse(added);
    }

    //User story 2
    @Test
    public void shouldReturnTrueIfBagelIsRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        basket.addProduct(bagel);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertTrue(removed);
    }

    @Test
    public void shouldReturnFalseIfBagelIsNotRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertFalse(removed);
    }

    //User story 3 is handled in user story 1 test cases

    //User story 4
    @Test
    public void shouldAssertNewBasketSize() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        int originalSize = basket.getMaxCapacity();
        int newSize = basket.extendCapacityOfBasket(3);
        Assertions.assertEquals(newSize, originalSize+3);
    }

    //User story 5 is handled in user story 2 test cases

    //User story 6
    @Test
    public void shouldAssertTotalCostOfAllBagelsInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        basket.addProduct(bagel);
        Bagel bagel2 = new Bagel("Onion", "BGLO", 0.49);
        basket.addProduct(bagel2);
        double expectedCost = 0.98;
        double actualCost = basket.getTotalCost();
        Assertions.assertEquals(expectedCost, actualCost);
    }

    //User story 7
    @Test
    public void shouldAssertPriceOfOneBagel() {
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        double expectedPrice = 0.49;
        double actualPrice = bagel.getPrice();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    //User story 8
    @Test
    public void shouldReturnTrueIfFillingWasAdded() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        basket.addProduct(bagel);
        Filling filling = new Filling("Bacon", "FILB");
        boolean addedFilling = basket.addFillingToBagel(bagel, filling);
        Assertions.assertTrue(addedFilling);
    }

    @Test
    public void shouldReturnFalseIfFillingWasNotAdded() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        Filling filling = new Filling("Bacon", "FILB");
        boolean addedFilling = basket.addFillingToBagel(bagel, filling);
        Assertions.assertFalse(addedFilling);
    }

    //User story 9 is in InventoryTest

    //User story 10
    @Test
    public void shouldReturnTrueIfItemIsInInventory() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Bagel bagel = new Bagel("Onion", "BGLO", 0.49);
        boolean addedBagelThatIsInInventory = basket.addProduct(bagel);
        Assertions.assertTrue(addedBagelThatIsInInventory);

        Filling filling = new Filling("Bacon", "FILB");
        boolean addedFillingThatIsInInventory = basket.addFillingToBagel(bagel, filling);
        Assertions.assertTrue(addedFillingThatIsInInventory);

        Coffee coffee = new Coffee("Black", "COFB", 0.99);
        boolean coffeeIsInInventory = inventory.isProductInInventory(coffee.getSku());
        Assertions.assertTrue(coffeeIsInInventory);
    }

    @Test
    public void shouldReturnFalseIfItemIsNotInInventory() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Bagel bagel = new Bagel("Onion", "ONION", 0.49);
        boolean addedBagelThatIsInInventory = basket.addProduct(bagel);
        Assertions.assertFalse(addedBagelThatIsInInventory);

        Filling filling = new Filling("Bacon", "BACON");
        boolean addedFillingThatIsInInventory = basket.addFillingToBagel(bagel, filling);
        Assertions.assertFalse(addedFillingThatIsInInventory);

        Coffee coffee = new Coffee("Black", "COFFEE", 0.99);
        boolean coffeeIsInInventory = inventory.isProductInInventory(coffee.getSku());
        Assertions.assertFalse(coffeeIsInInventory);
    }
}
