package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    HashMap<String, String[]> inventory;

    HashMap<String, String> mapSKUtoTypeVariant;
    HashMap<String, String> mapTypeVariantToSKU;


    String[][] inventoryArray =     {
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
        inventory = new HashMap<>();

        // Fill hash map
        for (int i = 0; i < inventoryArray.length; i++) {
            mapSKUtoTypeVariant.put(inventoryArray[i][0], inventoryArray[i][2] + " " + inventoryArray[i][3]);
            mapTypeVariantToSKU.put(inventoryArray[i][2] + " " + inventoryArray[i][3], inventoryArray[i][0]);
            inventory.put(inventoryArray[i][0], inventoryArray[i]);
        }





    }

    public static void main(String[] args) {
        ArrayList<String[]> inventory = new ArrayList<>();

    }
}
