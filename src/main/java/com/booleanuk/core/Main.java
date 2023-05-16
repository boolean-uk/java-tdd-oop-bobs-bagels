package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> itemArrayList = new ArrayList<>();
//        ItemInterface bagelItem = new Bagels();
        itemArrayList.add(new Item("Bagel", 0.49, "BGLO", "Onion"));
        itemArrayList.add(new Item("Bagel", 0.39, "BGLP", "Plain"));
        itemArrayList.add(new Item("Bagel", 0.49, "BGLE", "Everything"));
        itemArrayList.add(new Item("Bagel", 0.49, "BGLS", "Sesame"));
        itemArrayList.add(new Item("Coffee", 0.99, "COFB", "Black"));
        itemArrayList.add(new Item("Coffee", 1.19, "COFW", "White"));
        itemArrayList.add(new Item("Coffee", 1.29, "COFC", "Cappuccino"));
        itemArrayList.add(new Item("Coffee", 1.29, "COFL", "Latte"));
        itemArrayList.add(new Item("Filling", 0.12, "FILB", "Bacon"));
        itemArrayList.add(new Item("Filling", 0.12, "FILE", "Egg"));
        itemArrayList.add(new Item("Filling", 0.12, "FILC", "Cheese"));
        itemArrayList.add(new Item("Filling", 0.12, "FILX", "Cream Cheese"));
        itemArrayList.add(new Item("Filling", 0.12, "FILS", "Smoked Salmon"));
        itemArrayList.add(new Item("Filling", 0.12, "FILH", "Ham"));

        Inventory inventory = new Inventory(itemArrayList);
        Basket basket = new Basket(inventory);


    }

}
