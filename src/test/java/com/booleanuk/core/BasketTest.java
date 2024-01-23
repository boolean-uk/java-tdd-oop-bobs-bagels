package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    //User story 1
    @Test
    public void shouldReturnTrueIfBagelIsAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        boolean added = basket.addBagel(bagel);
        Assertions.assertTrue(added);
    }

    @Test
    public void shouldReturnFalseIfBagelIsNotAddedToBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        basket.addBagel(new Bagel("Sesame", "1234", 10));
        boolean added = basket.addBagel(new Bagel("Sesame", "1234", 10));
        Assertions.assertFalse(added);
    }

    //User story 2
    @Test
    public void shouldReturnTrueIfBagelIsRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        basket.addBagel(bagel);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertTrue(removed);
    }

    @Test
    public void shouldReturnFalseIfBagelIsNotRemovedFromBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10);
        boolean removed = basket.removeBagel(bagel);
        Assertions.assertFalse(removed);
    }

    //User story 3 is handled in user story 1 test cases

    //User story 4
    @Test
    public void shouldAssertNewBasketSize() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        int originalSize = basket.maxCapacity;
        int newSize = basket.extendCapacityOfBasket(3);
        Assertions.assertEquals(newSize, originalSize+3);
    }

    //User story 5 is handled in user story 2 test cases

    //User story 6
    @Test
    public void shouldAssertTotalCostOfAllBagelsInBasket() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10.10);
        basket.addBagel(bagel);
        Bagel bagel2 = new Bagel("Sesame", "1234", 20.20);
        basket.addBagel(bagel2);
        double expectedCost = 30.30;
        double actualCost = basket.getTotalCost();
        Assertions.assertEquals(expectedCost, actualCost);
    }

    //User story 7
    @Test
    public void shouldAssertPriceOfOneBagel() {
        Bagel bagel = new Bagel("Sesame", "1234", 10.10);
        double expectedPrice = 10.10;
        double actualPrice = bagel.getPrice();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    //User story 8
    @Test
    public void shouldReturnTrueIfFillingWasAdded() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10.10);
        basket.addBagel(bagel);
        Filling filling = new Filling("Cheese", "4321", 2.30);
        boolean addedFilling = basket.addFillingToBagel(bagel, filling);
        Assertions.assertTrue(addedFilling);
    }

    @Test
    public void shouldReturnFalseIfFillingWasNotAdded() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Bagel bagel = new Bagel("Sesame", "1234", 10.10);
        Filling filling = new Filling("Cheese", "4321", 2.30);
        boolean addedFilling = basket.addFillingToBagel(bagel, filling);
        Assertions.assertFalse(addedFilling);
    }

    //User story 9
    @Test
    public void assertPriceOfEveryFilling() {
        Inventory inventory = new Inventory();

        ArrayList<Filling> returnedFillings = inventory.getAllFillings();

        int allTested = 0;

        for(Filling filling : returnedFillings) {
            switch (filling.getName()) {
                case "Bacon":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Egg":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Cheese":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Cream Cheese":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Smoked Salmon":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Ham":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                default:
                    Assertions.assertEquals(1, 2);
                    break;
            }
        }
        if(allTested != 6) {
            Assertions.assertEquals(1, 2);
        }
    }

    //User story 10
    @Test
    public void shouldReturnTrueIfItemIsInInventory() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);

        Bagel bagel = new Bagel("Sesame", "1234", 10.10);
        boolean addedBagelThatIsInInventory = basket.addBagel(bagel);
        Assertions.assertTrue(addedBagelThatIsInInventory);

        Filling filling = new Filling("Strawberry Jam", "FSTR");
        boolean addedFillingThatIsInInventory = basket.addFillingToBagel(bagel, filling);
        Assertions.assertTrue(addedFillingThatIsInInventory);
    }
}
