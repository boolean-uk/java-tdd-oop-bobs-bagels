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
        output = new StringBuilder("Bob's Bagels\nAmount\tSKU\t\tPrice\tName\tVariant\n--------------------------------------\n");
        for (Item item : this.inventory.keySet()) {
            String itemString = this.inventory.get(item) + "\t\t" + item.getSku()+"\t"+item.getPrice()+"\t"+item.getName()+"\t"+item.getVariant() +"\n";
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
        Item bglo = new Bagel("BGLO", "Onion", 0.49);
        Item bglp = new Bagel("BGLP","Plain", 0.39);
        Item bgle = new Bagel("BGLE","Everything", 0.49);
        Item bgls = new Bagel("BGLS", "Sesame", 0.49);
        Item cofb = new Coffee("COFB",  "Black", 0.99);
        Item cofw = new Coffee("COFW",  "White", 1.19);
        Item cofc = new Coffee("COFC",  "Capuccino", 1.29);
        Item cofl = new Coffee("COFL",  "Latte", 1.29);
        Item filb = new Filling("FILB",  "Bacon", 0.12);
        Item file = new Filling("FILE",  "Egg", 0.12);
        Item filc = new Filling("FILC",  "Cheese", 0.12);
        Item filx = new Filling("FILX",  "Cream Cheese", 0.12);
        Item fils = new Filling("FILS",  "Smoked Salmon", 0.12);
        Item filh = new Filling("FILH",  "Ham", 0.12);
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
