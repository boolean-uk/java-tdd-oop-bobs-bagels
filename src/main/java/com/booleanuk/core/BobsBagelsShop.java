package com.booleanuk.core;

import java.util.HashMap;

public class BobsBagelsShop {
    private HashMap<Item, Integer> inventory;

    public BobsBagelsShop(HashMap<Item, Integer> newInventory) {
        this.inventory = newInventory;
    }

    public String showInventory() {
        if (this.inventory.isEmpty()) {
            return "No items in stock.";
        }
        StringBuilder output;
        output = new StringBuilder("Bob's Bagels\nSKU\t\tPrice\tName\tVariant\n--------------------------------------\n");
        for (Item item : inventory.keySet()) {
            String itemString = item.getSku()+"\t"+item.getPrice()+"\t"+item.getName()+"\t"+item.getVariant()+"\n";
            output.append(itemString);
        }
        return output.toString();
    }

    public HashMap<Item, Integer> getInventory() {
        return this.inventory;
    }

    public void setInventory(HashMap<Item, Integer> newInventory) {
        this.inventory = newInventory;
    }

    public BobsBagelsShop() {
        HashMap<Item, Integer> fullInventory = new HashMap<>();
        Item bglo = new Bagel("BGLO","Bagel", "Onion", 0.49);
        Item bglp = new Bagel("BGLP","Bagel", "Plain", 0.39);
        Item bgle = new Bagel("BGLE","Bagel", "Everything", 0.49);
        Item bgls = new Bagel("BGLS","Bagel", "Sesame", 0.49);
        Item cofb = new Coffee("COFB", "Coffee", "Black", 0.99);
        Item cofw = new Coffee("COFW", "Coffee", "White", 1.19);
        Item cofc = new Coffee("COFC", "Coffee", "Capuccino", 1.29);
        Item cofl = new Coffee("COFL", "Coffee", "Latte", 1.29);
        Item filb = new Filling("FILB", "Filling", "Bacon", 0.12);
        Item file = new Filling("FILE", "Filling", "Egg", 0.12);
        Item filc = new Filling("FILC", "Filling", "Cheese", 0.12);
        Item filx = new Filling("FILX", "Filling", "Cream Cheese", 0.12);
        Item fils = new Filling("FILS", "Filling", "Smoked Salmon", 0.12);
        Item filh = new Filling("FILH", "Filling", "Ham", 0.12);
        fullInventory.put(bglo, 30);
        fullInventory.put(bglp, 30);
        fullInventory.put(bgle, 30);
        fullInventory.put(bgls, 30);
        fullInventory.put(cofb, 30);
        fullInventory.put(cofw, 30);
        fullInventory.put(cofc, 30);
        fullInventory.put(cofl, 30);
        fullInventory.put(filb, 30);
        fullInventory.put(file, 30);
        fullInventory.put(filc, 30);
        fullInventory.put(filx, 30);
        fullInventory.put(fils, 30);
        fullInventory.put(filh, 30);
        this.inventory = fullInventory;
    }
}
