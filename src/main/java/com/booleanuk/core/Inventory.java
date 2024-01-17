package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    HashMap<String, String[]> bagelInventory;
    HashMap<String, String[]> coffeeInventory;
    HashMap<String, String[]> fillingInventory;

    HashMap<String, String> mapSKUtoTypeVariant;
    HashMap<String, String> mapTypeVariantToSKU;


    String[][] inventory =     {
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
        bagelInventory = new HashMap<>();
        coffeeInventory = new HashMap<>();
        fillingInventory = new HashMap<>();
        mapSKUtoTypeVariant =  new HashMap<>();
        mapTypeVariantToSKU = new HashMap<>();

        // Fill hasp maps
        for (int i = 0; i < inventory.length; i++) {
            mapSKUtoTypeVariant.put(inventory[i][0], inventory[i][2] + " " + inventory[i][3]);
            mapTypeVariantToSKU.put(inventory[i][2] + " " + inventory[i][3], inventory[i][0]);

            if (inventory[i][3].equals("Bagel"))
                bagelInventory.put(inventory[i][0], inventory[i]);

            else if (inventory[i][3].equals("Coffee"))
                coffeeInventory.put(inventory[i][0], inventory[i]);

            else if (inventory[i][3].equals("Fillings"))
                fillingInventory.put(inventory[i][0], inventory[i]);
        }





    }

    public static void main(String[] args) {
        ArrayList<String[]> inventory = new ArrayList<>();

    }
}
