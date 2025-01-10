package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {

    ArrayList<Item> fillInventory(){
        ArrayList<Item> inventory = new ArrayList<>();
        Item onionBagel = new OnionBagel();
        inventory.add(onionBagel);
        Item plainBagel = new PlainBagel();
        inventory.add(plainBagel);
        Item everythingBagel = new EverythingBagel();
        inventory.add(everythingBagel);
        Item sesameBagel = new SesameBagel();
        inventory.add(sesameBagel);
        Item blackCoffee = new BlackCoffee();
        inventory.add(blackCoffee);
        Item whiteCoffee = new WhiteCoffee();
        inventory.add(whiteCoffee);
        Item cappuccino = new CappuccinoCoffee();
        inventory.add(cappuccino);
        Item latte = new LatteCoffee();
        inventory.add(latte);
        Item bacon = new BaconFilling();
        inventory.add(bacon);
        Item egg = new EggFilling();
        inventory.add(egg);
        Item cheese = new CheeseFilling();
        inventory.add(cheese);
        Item creamCheese = new CreamCheeseFilling();
        inventory.add(creamCheese);
        Item smokedSalmon = new SmokedSalmonFilling();
        inventory.add(smokedSalmon);
        Item ham = new HamFilling();
        inventory.add(ham);

        return inventory;
    }

    @Test
    public void testIsInInventoryWhenThereIs(){
        Inventory inventory = new Inventory();
        Item ham = new HamFilling();

        inventory.addItems(fillInventory());

        Assertions.assertTrue(inventory.isInInventory(ham));


    }
    @Test
    public void testIsInInventoryWhenThereIsNot(){

        Inventory inventory = new Inventory();
        Item ham = new HamFilling();

        inventory.addItems(fillInventory());
        inventory.removeItem(ham);

        Assertions.assertFalse(inventory.isInInventory(ham));

    }

    @Test
    public void testAddItem(){
        Inventory inventory = new Inventory();
        Item ham = new HamFilling();

        Assertions.assertEquals("Successfully added", inventory.addItem(ham));


    }

    @Test
    public void testAddItems(){
        Inventory inventory = new Inventory();
        Item ham = new HamFilling();

        Assertions.assertEquals("Successfully added", inventory.addItems(fillInventory()));


    }

    @Test
    public void testRemoveItem(){
        Inventory inventory = new Inventory();
        inventory.addItems(fillInventory());
        Item ham = new HamFilling();

        Assertions.assertEquals("Successfully removed", inventory.removeItem(ham));

    }

    @Test
    public void testRemoveItems(){
        Inventory inventory = new Inventory();
        inventory.addItems(fillInventory());

        Assertions.assertEquals("Successfully removed", inventory.removeItems(fillInventory()));

    }
}
