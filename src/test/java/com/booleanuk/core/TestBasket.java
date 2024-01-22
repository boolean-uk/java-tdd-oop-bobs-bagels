package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
    Item[] Items = {
            new Item("BGLO", 0.49, "Bagel", "Onion"),
            new Item("BGLP", 0.39, "Bagel", "Plain"),
            new Item("BGLE", 0.49, "Bagel", "Everything"),
            new Item("BGLS", 0.49, "Bagel", "Sesame"),
            new Item("COFB", 0.99, "Coffee", "Black"),
            new Item("COFW", 1.19, "Coffee", "White"),
            new Item("COFC", 1.29, "Coffee", "Cappuccino"),
            new Item("COFL", 1.29, "Coffee", "Latte"),
            new Item("FILB", 0.12, "Filling", "Bacon"),
            new Item("FILE", 0.12, "Filling", "Egg"),
            new Item("FILC", 0.12, "Filling", "Cheese"),
            new Item("FILX", 0.12, "Filling", "Cream Cheese"),
            new Item("FILS", 0.12, "Filling", "Smoked Salmon"),
            new Item("FILH", 0.12, "Filling", "Ham"),
            new Item("FILm", 0.12, "Filling", "bacon")
    };
    @Test
    public void addingAnItemToBasketReturnTrue(){
        Basket basket = new Basket();

        Assertions.assertEquals("Item successfully added", basket.add(Items[0]));
        Assertions.assertEquals("This item already exists in the Basket", basket.add(Items[0]));
        Assertions.assertEquals("Item successfully added", basket.add(Items[1]));
        Assertions.assertEquals("Item successfully added", basket.add(Items[2]));
        Assertions.assertEquals("Your Basket is full", basket.add(Items[3]));
    }

    @Test
    public void removingAnItemFromBasketReturnTrue(){
        Basket basket = new Basket();
        basket.add(Items[0]);
        Assertions.assertEquals("Item successfully removed", basket.remove(Items[0]));
    }

    @Test
    public void checkingChangedCapacity() {
        Basket basket = new Basket();
        basket.change(5);
        Assertions.assertEquals("New capacity: 5", basket.change(5));
    }
    @Test
    public void seeTotalCost() {
        Basket basket = new Basket();
        basket.add(Items[0]);
        basket.add(Items[4]);
        basket.add(Items[7]);
        Assertions.assertEquals(2.77, basket.totalCost());
    }
    @Test
    public void addAnotherItem() {
        Basket basket = new Basket();
        Assertions.assertEquals("Item is not in the inventory", basket.add(Items[14]));
    }
    @Test
    public void seeTheCostOfAnItem() {
        Basket basket = new Basket();
        Assertions.assertEquals(0.12, basket.seeCost(Items[9]));
    }
}
