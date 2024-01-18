package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Item> items;
    HashMap<String, String> mapTypeVariantToSKU;
    String[][] itemsArray =     {
            {"BGLO", "0.49", "Bagel", "Onion"},
            {"BGLP", "0.39", "Bagel", "Plain"},
            {"BGLE", "0.49", "Bagel", "Everything"},
            {"BGLS", "0.49", "Bagel", "Sesame"},

            {"COFB", "0.99", "Coffee", "Black"},
            {"COFW", "1.19", "Coffee", "White"},
            {"COFC", "1.29", "Coffee", "Capuccino"},
            {"COFL", "1.29", "Coffee", "Latte"},

            {"FILB", "0.12", "Filling", "Bacon"},
            {"FILE", "0.12", "Filling", "Egg"},
            {"FILC", "0.12", "Filling", "Cheese"},
            {"FILX", "0.12", "Filling", "Cream Cheese"},
            {"FILS", "0.12", "Filling", "Smoked Salmon"},
            {"FILH", "0.12", "Filling", "Ham"}};

    public Inventory() {
        // Initiate hash maps
        items = new HashMap<>();
        mapTypeVariantToSKU = new HashMap<>();

        // Fill hash map
        for (String[] item: itemsArray) {
            // Fills ut items map with sku as key, the value is the object containing price, name, type, and nametype
            items.put(item[0], new Item(Double.parseDouble(item[1]), item[2], item[3]));
            // Map go from typevariant to sku. Items can be used to go other way
            mapTypeVariantToSKU.put(items.get(item[0]).getNametype(), item[0]);
        }
    }

    public static class BasketItem {
    }
}
