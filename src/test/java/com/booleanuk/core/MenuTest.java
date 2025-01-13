package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MenuTest {

    public ArrayList<Item> itemsOnMenu = new ArrayList<>(){{
        // Adding the bagels
        Item onionBagel = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};
        add(onionBagel);
        Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain", "Bagel"){};
        add(plainBagel);
        Item everythingBagel = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel"){};
        add(everythingBagel);
        Item sesameBagel = new SesameBagel(0.49, "BGLS", "Sesame", "Bagel"){};
        add(sesameBagel);

        // Adding the coffees
        Item blackCoffee = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
        add(blackCoffee);
        Item whiteCoffee = new WhiteCoffee(1.19, "COFW", "White", "Coffee"){};
        add(whiteCoffee);
        Item cappucinoCoffee = new CappucinoCoffee(1.29, "COFC", "Cappuccino", "Coffee"){};
        add(cappucinoCoffee);
        Item latteCoffee = new LatteCoffee(1.29, "COFL", "Latte", "Coffee"){};
        add(latteCoffee);

        // Adding the fillings
        Item baconFilling = new BaconFilling(0.12, "FILB", "Bacon", "Filling"){};
        add(baconFilling);
        Item eggFilling = new EggFilling(0.12, "FILE", "Egg", "Filling"){};
        add(eggFilling);
        Item cheeseFilling = new CheeseFilling(0.12, "FILC", "Cheese", "Filling"){};
        add(cheeseFilling);
        Item creamCheeseFilling = new CreamCheeseFilling(0.12, "FILX", "Cream Cheese", "Filling"){};
        add(creamCheeseFilling);
        Item smokedSalmonFilling = new SmokedSalmonFilling(0.12, "FILS", "Smoked Salmon", "Filling"){};
        add(smokedSalmonFilling);
        Item hamFilling = new HamFilling(0.12, "FILH", "Ham", "Filling"){};
        add(hamFilling);
    }};

    @Test
    public void itemDontExistOnMenuSeePrice(){
        Menu menu = new Menu(itemsOnMenu);
        Item itemToCheck = new Item(0.10, "abc", "apple", "Filling");

        Assertions.assertEquals("Item dont exist on the menu!", menu.seePrice(itemToCheck));
    }

    @Test
    public void itemExistOnMenuSeePrice(){
        Menu menu = new Menu(itemsOnMenu);
        Item itemToCheck = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertEquals("The item costs: " + itemToCheck.getPrice(), menu.seePrice(itemToCheck));
    }





    @Test
    public void allFillingsAreReturned(){
        Menu menu = new Menu(itemsOnMenu);
        String allFillingsWithPrices = "Bacon, 0.12$" + "\n" +
                                       "Egg, 0.12$" + "\n" +
                                       "Cheese, 0.12$" + "\n" +
                                       "Cream Cheese, 0.12$" + "\n" +
                                       "Smoked Salmon, 0.12$" + "\n" +
                                       "Ham, 0.12$" + "\n";

        Assertions.assertEquals(allFillingsWithPrices, menu.showAllFillingsWithCosts());
    }




    @Test
    public void itemDontExistOnMenu(){
        Menu menu = new Menu(itemsOnMenu);
        Item itemToCheck = new Item(0.10, "abc", "apple", "Filling");

        Assertions.assertFalse(menu.isContainedInInventory(itemToCheck));
    }

    @Test
    public void itemExistOnMenu(){
        Menu menu = new Menu(itemsOnMenu);
        Item itemToCheck = new OnionBagel(0.49, "BGLO", "Onion", "Bagel"){};

        Assertions.assertTrue(menu.isContainedInInventory(itemToCheck));
    }

}
