package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {

    private ArrayList<Item> itemsInBasket = new ArrayList<>(){{
        // Adding the bagels
        Item onionBagel1 = new OnionBagel(0.49, "BGLO", "Onion", "Bagel") {};
        add(onionBagel1);
        Item onionBagel2 = new OnionBagel(0.49, "BGLO", "Onion", "Bagel") {};
        add(onionBagel2);

        Item plainBagel1 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel1);
        Item plainBagel2 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel2);
        Item plainBagel3 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel3);
        Item plainBagel4 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel4);
        Item plainBagel5 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel5);
        Item plainBagel6 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel6);
        Item plainBagel7 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel7);
        Item plainBagel8 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel8);
        Item plainBagel9 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel9);
        Item plainBagel10 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel10);
        Item plainBagel11 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel11);
        Item plainBagel12 = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        add(plainBagel12);

        Item everythingBagel1 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel1);
        Item everythingBagel2 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel2);
        Item everythingBagel3 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel3);
        Item everythingBagel4 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel4);
        Item everythingBagel5 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel5);
        Item everythingBagel6 = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        add(everythingBagel6);

        Item blackCoffee1 = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
        add(blackCoffee1);
        Item blackCoffee2 = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
        add(blackCoffee2);
        Item blackCoffee3 = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
        add(blackCoffee3);
    }};

    @Test
    public void basketIsFullWhenAdding(){
        Basket basket = new Basket(itemsInBasket, 23);
        Item itemToAdd = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals("Basket is full!", basket.addItem(itemToAdd));
    }

    @Test
    public void basketIsNotFullWhenAdding(){
        Basket basket = new Basket(itemsInBasket, 25);
        Item itemToAdd = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals(itemToAdd.getName() + " was added to your basket!", basket.addItem(itemToAdd));
    }

    @Test
    public void removingItemThatDoesNotExistInBasket(){
        Basket basket = new Basket(itemsInBasket, 25);
        Item itemToRemove = new OnionBagel(0.49, "BGLO", "Tomato", "Bagel"){};

        Assertions.assertEquals("Item do not exist in basket!", basket.removeItem(itemToRemove));
    }

    @Test
    public void removingItemThatDoExistInBasket(){
        Basket basket = new Basket(itemsInBasket, 25);
        Item itemToRemove = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals(itemToRemove.getName() + " was removed from the basket!", basket.removeItem(itemToRemove));
    }

    @Test
    public void enteringAcceptableBasketSize(){
        Basket basket = new Basket(itemsInBasket, 25);

        Assertions.assertTrue(basket.changeSizeOfBasket(24));
    }

    @Test
    public void enteringANonAcceptableBasketSize(){
        Basket basket = new Basket(itemsInBasket, 25);

        Assertions.assertFalse(basket.changeSizeOfBasket(5));
    }


    @Test
    public void totalCostOfBasketWhenItIsNotEmpty(){
        Basket basket = new Basket(itemsInBasket, 25);

        Assertions.assertEquals(11.57, basket.totalCost());
    }

    @Test
    public void totalCostOfBasketWhenItIsEmpty(){
        ArrayList<Item> emptyList = new ArrayList<>();
        Basket basket = new Basket(emptyList, 6);

        Assertions.assertEquals(0, basket.totalCost());
    }

}
