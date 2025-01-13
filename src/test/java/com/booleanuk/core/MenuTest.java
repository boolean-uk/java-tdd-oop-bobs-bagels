package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MenuTest {

//    ArrayList<Item> fillMenu(){
//        ArrayList<Item> menu = new ArrayList<>();
//        Item onionBagel = new OnionBagel();
//        menu.add(onionBagel);
//        Item plainBagel = new PlainBagel();
//        menu.add(plainBagel);
//        Item everythingBagel = new EverythingBagel();
//        menu.add(everythingBagel);
//        Item sesameBagel = new SesameBagel();
//        menu.add(sesameBagel);
//        Item blackCoffee = new BlackCoffee();
//        menu.add(blackCoffee);
//        Item whiteCoffee = new WhiteCoffee();
//        menu.add(whiteCoffee);
//        Item cappuccino = new CappuccinoCoffee();
//        menu.add(cappuccino);
//        Item latte = new LatteCoffee();
//        menu.add(latte);
//        Item bacon = new BaconFilling();
//        menu.add(bacon);
//        Item egg = new EggFilling();
//        menu.add(egg);
//        Item cheese = new CheeseFilling();
//        menu.add(cheese);
//        Item creamCheese = new CreamCheeseFilling();
//        menu.add(creamCheese);
//        Item smokedSalmon = new SmokedSalmonFilling();
//        menu.add(smokedSalmon);
//        Item ham = new HamFilling();
//        menu.add(ham);
//
//        return menu;
//    }

    @Test
    public void testListAllFillingPrices(){
        Menu menu = new Menu();

        Assertions.assertEquals(" ", menu.listAllFillingPrices());
    }

    @Test
    public void testCheckCostOfItemThatDoesExist(){
        Menu menu = new Menu();

        String itemName = "Ham";

        Assertions.assertEquals("Price: 0.12", menu.checkCostOfItem(itemName));
    }

    @Test
    public void testCheckCostOfItemThatDoesNotExist(){
        Menu menu = new Menu();

        String itemName = "Sausage";

        Assertions.assertEquals("No item found", menu.checkCostOfItem(itemName));
    }

    @Test
    public void testIsInInventoryWhenThereIs(){
        Menu menu = new Menu();

        //fillMenu();
        Item ham = new HamFilling();

        Assertions.assertTrue(menu.isInMenu(ham));


    }
    @Test
    public void testIsInInventoryWhenThereIsNot(){

        Menu inventory = new Menu();


        Assertions.assertFalse(inventory.isInMenu("Sausage"));

    }
}
