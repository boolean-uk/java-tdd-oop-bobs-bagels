package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    private ArrayList<Item> itemsInBasket = new ArrayList<>(){{
        // Adding the bagels
        Item onionBagel = new OnionBagel(0.49, "BGLO", "Onion", "Bagel") {};
        add(onionBagel);
        Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel);
        Item cappucinoCoffee = new CappucinoCoffee(1.29, "COFC", "Cappuccino", "Coffee"){};
        add(cappucinoCoffee);
        Item latteCoffee = new LatteCoffee(1.29, "COFL", "Latte", "Coffee"){};
        add(latteCoffee);
        Item baconFilling = new BaconFilling(0.12, "FILB", "Bacon", "Filling"){};
        add(baconFilling);
        Item eggFilling = new EggFilling(0.12, "FILE", "Egg", "Filling"){};
        add(eggFilling);
    }};

    @Test
    public void basketIsFullWhenAdding(){
        Basket basket = new Basket(itemsInBasket, 6);
        Item itemToAdd = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals("Basket is full!", basket.addItem(itemToAdd));
    }

    @Test
    public void basketIsNotFullWhenAdding(){
        Basket basket = new Basket(itemsInBasket, 10);
        Item itemToAdd = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals(itemToAdd.getName() + " was added to your basket!", basket.addItem(itemToAdd));
    }

    @Test
    public void removingItemThatDoesNotExistInBasket(){
        Basket basket = new Basket(itemsInBasket, 6);
        Item itemToRemove = new OnionBagel(0.49, "BGLO", "Tomato", "Bagel"){};

        Assertions.assertEquals("Item do not exist in basket!", basket.removeItem(itemToRemove));
    }

    @Test
    public void removingItemThatDoExistInBasket(){
        Basket basket = new Basket(itemsInBasket, 6);
        Item itemToRemove = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals(itemToRemove.getName() + " was removed from the basket!", basket.removeItem(itemToRemove));
    }

    @Test
    public void enteringAcceptableBasketSize(){
        Basket basket = new Basket(itemsInBasket, 6);

        Assertions.assertTrue(basket.changeSizeOfBasket(8));
    }

    @Test
    public void enteringANonAcceptableBasketSize(){
        Basket basket = new Basket(itemsInBasket, 6);

        Assertions.assertFalse(basket.changeSizeOfBasket(5));
    }

}
