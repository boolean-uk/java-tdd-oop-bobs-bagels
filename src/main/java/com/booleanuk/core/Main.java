package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<ItemInterface> itemArrayList = new ArrayList<>();
//        ItemInterface bagelItem = new Bagels();
        itemArrayList.add(new Bagels("Bagel", 0.49, "BGLO", "Onion"));
        itemArrayList.add(new Bagels("Bagel", 0.39, "BGLP", "Plain"));
        itemArrayList.add(new Bagels("Bagel", 0.49, "BGLE", "Everything"));
        itemArrayList.add(new Bagels("Bagel", 0.49, "BGLS", "Sesame"));
        itemArrayList.add(new Coffee("Coffee", 0.99, "COFB", "Black"));
        itemArrayList.add(new Coffee("Coffee", 1.19, "COFW", "White"));
        itemArrayList.add(new Coffee("Coffee", 1.29, "COFC", "Cappuccino"));
        itemArrayList.add(new Coffee("Coffee", 1.29, "COFL", "Latte"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILB", "Bacon"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILE", "Egg"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILC", "Cheese"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILX", "Cream Cheese"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILS", "Smoked Salmon"));
        itemArrayList.add(new Fillings("Filling", 0.12, "FILH", "Ham"));

        Inventory inventory = new Inventory(itemArrayList);
        Basket basket = new Basket(inventory);


    }

}
