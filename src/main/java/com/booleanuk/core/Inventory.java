package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> allItems;
    private ArrayList<Item> itemArrayList;
    public Inventory(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.allItems = new HashMap<>();
//        this.allItems.put


        for (int i = 0; i < this.itemArrayList.size(); i++) {
                this.allItems.put(this.itemArrayList.get(i).getSku(),this.itemArrayList.get(i));
        }
    }


//    private Item onionBagel = new Item("Bagel", 0.49, "BGLO", "Onion");
//    private Item plainBagel = new Item("Bagel", 0.39, "BGLP", "Plain");
//    private Item everythingBagel = new Item("Bagel", 0.49, "BGLE", "Everything");
//    private Item sesameBagel = new Item("Bagel", 0.49, "BGLS", "Sesame");
//    private Item blackCoffee = new Item("Coffee", 0.99, "COFB", "Black");
//    private Item whiteCoffee = new Item("Coffee", 1.19, "COFW", "White");
//    private Item cappuccinoCoffee = new Item("Coffee", 1.29, "COFC", "Cappuccino");
//    private Item latteCoffee = new Item("Coffee", 1.29, "COFL", "Latte");
//    private Item baconFilling = new Item("Filling", 0.12, "FILB", "Bacon");
//    private Item eggFilling = new Item("Filling", 0.12, "FILE", "Egg");
//    private Item cheeseFilling = new Item("Filling", 0.12, "FILC", "Cheese");
//    private Item creamCheeseFilling = new Item("Filling", 0.12, "FILX", "Cream Cheese");
//    private Item smokedSalmonFilling = new Item("Filling", 0.12, "FILS", "Smoked Salmon");
//    private Item hamFilling = new Item("Filling", 0.12, "FILH", "Ham");

//
    public Item searchItem(String sku) {
//        getAllItems().put("BGLO", getOnionBagel());
//        getAllItems().put("BGLP", getPlainBagel());
//        getAllItems().put("BGLE", getEverythingBagel());
//        getAllItems().put("BGLS", getSesameBagel());
//        getAllItems().put("COFB", getBlackCoffee());
//        getAllItems().put("COFW", getWhiteCoffee());
//        getAllItems().put("COFC", getCappuccinoCoffee());
//        getAllItems().put("COFL", getLatteCoffee());
//        getAllItems().put("FILB", getBaconFilling());
//        getAllItems().put("FILE", getEggFilling());
//        getAllItems().put("FILC", getCheeseFilling());
//        getAllItems().put("FILX", getCreamCheeseFilling());
//        getAllItems().put("FILS", getSmokedSalmonFilling());
//        getAllItems().put("FILH", getHamFilling());

        if(getAllItems().containsKey(sku)) {
            return getAllItems().get(sku);
        }
        System.out.println("This item does not exist");
        return null;
    }
//
//    public Item getOnionBagel() {
//        return onionBagel;
//    }
//
//    public void setOnionBagel(Item onionBagel) {
//        this.onionBagel = onionBagel;
//    }
//
//    public Item getPlainBagel() {
//        return plainBagel;
//    }
//
//    public void setPlainBagel(Item plainBagel) {
//        this.plainBagel = plainBagel;
//    }
//
//    public Item getEverythingBagel() {
//        return everythingBagel;
//    }
//
//    public void setEverythingBagel(Item everythingBagel) {
//        this.everythingBagel = everythingBagel;
//    }
//
//    public Item getSesameBagel() {
//        return sesameBagel;
//    }
//
//    public void setSesameBagel(Item sesameBagel) {
//        this.sesameBagel = sesameBagel;
//    }
//
//    public Item getBlackCoffee() {
//        return blackCoffee;
//    }
//
//    public void setBlackCoffee(Item blackCoffee) {
//        this.blackCoffee = blackCoffee;
//    }
//
//    public Item getWhiteCoffee() {
//        return whiteCoffee;
//    }
//
//    public void setWhiteCoffee(Item whiteCoffee) {
//        this.whiteCoffee = whiteCoffee;
//    }
//
//    public Item getCappuccinoCoffee() {
//        return cappuccinoCoffee;
//    }
//
//    public void setCappuccinoCoffee(Item cappuccinoCoffee) {
//        this.cappuccinoCoffee = cappuccinoCoffee;
//    }
//
//    public Item getLatteCoffee() {
//        return latteCoffee;
//    }
//
//    public void setLatteCoffee(Item latteCoffee) {
//        this.latteCoffee = latteCoffee;
//    }
//
//    public Item getBaconFilling() {
//        return baconFilling;
//    }
//
//    public void setBaconFilling(Item baconFilling) {
//        this.baconFilling = baconFilling;
//    }
//
//    public Item getEggFilling() {
//        return eggFilling;
//    }
//
//    public void setEggFilling(Item eggFilling) {
//        this.eggFilling = eggFilling;
//    }
//
//    public Item getCheeseFilling() {
//        return cheeseFilling;
//    }
//
//    public void setCheeseFilling(Item cheeseFilling) {
//        this.cheeseFilling = cheeseFilling;
//    }
//
//    public Item getCreamCheeseFilling() {
//        return creamCheeseFilling;
//    }
//
//    public void setCreamCheeseFilling(Item creamCheeseFilling) {
//        this.creamCheeseFilling = creamCheeseFilling;
//    }
//
//    public Item getSmokedSalmonFilling() {
//        return smokedSalmonFilling;
//    }
//
//    public void setSmokedSalmonFilling(Item smokedSalmonFilling) {
//        this.smokedSalmonFilling = smokedSalmonFilling;
//    }
//
//    public Item getHamFilling() {
//        return hamFilling;
//    }
//
//    public void setHamFilling(Item hamFilling) {
//        this.hamFilling = hamFilling;
//    }
//
    public HashMap<String, Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(HashMap<String, Item> allItems) {
        this.allItems = allItems;
    }
}
