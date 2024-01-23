package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
    Item[] Items = {
            new Bagel("BGLO", 0.49, "Bagel", "Onion"),
            new Bagel("BGLP", 0.39, "Bagel", "Plain"),
            new Bagel("BGLE", 0.49, "Bagel", "Everything"),
            new Bagel("BGLS", 0.49, "Bagel", "Sesame"),
            new Coffee("COFB", 0.99, "Coffee", "Black"),
            new Coffee("COFW", 1.19, "Coffee", "White"),
            new Coffee("COFC", 1.29, "Coffee", "Cappuccino"),
            new Coffee("COFL", 1.29, "Coffee", "Latte"),
            new Filling("FILB", 0.12, "Filling", "Bacon"),
            new Filling("FILE", 0.12, "Filling", "Egg"),
            new Filling("FILC", 0.12, "Filling", "Cheese"),
            new Filling("FILX", 0.12, "Filling", "Cream Cheese"),
            new Filling("FILS", 0.12, "Filling", "Smoked Salmon"),
            new Filling("FILH", 0.12, "Filling", "Ham"),
            new Filling("FILm", 0.12, "Filling", "bacon")
    };
    @Test
    public void addingAnItemToBasketReturnTrue(){
        Member customer = new Member();
        Basket basket = new Basket(customer);

        Assertions.assertEquals("Item successfully added", basket.add(Items[0]));
        Assertions.assertEquals("This item already exists in the Basket", basket.add(Items[0]));
        Assertions.assertEquals("Item successfully added", basket.add(Items[1]));
        Assertions.assertEquals("Item successfully added", basket.add(Items[2]));
        Assertions.assertEquals("Your Basket is full", basket.add(Items[3]));
    }

    @Test
    public void removingAnItemFromBasketReturnTrue(){
        Member customer = new Member();
        Basket basket = new Basket(customer);
        basket.add(Items[0]);
        Assertions.assertEquals("Item successfully removed", basket.remove(Items[0]));
    }

    @Test
    public void checkingChangedCapacity() throws UserException {
        Member manager = new Member();
        Basket basket = new Basket(manager);
        basket.change(5);
        Assertions.assertEquals("New capacity: 5", basket.change(5));
    }
    @Test
    public void seeTotalCost() {
        Member customer = new Member();
        Basket basket = new Basket(customer);
        basket.add(Items[0]);
        basket.add(Items[4]);
        basket.add(Items[7]);
        Assertions.assertEquals(2.77, basket.totalCost());
    }
    @Test
    public void addAnotherItem() {
        Member customer = new Member();
        Basket basket = new Basket(customer);
        Assertions.assertEquals("Item is not in the inventory", basket.add(Items[14]));
    }
    @Test
    public void seeTheCostOfAnItem() {
        Member customer = new Member();
        Basket basket = new Basket(customer);
        Assertions.assertEquals(0.12, basket.seeCost(Items[9]));
    }
}
