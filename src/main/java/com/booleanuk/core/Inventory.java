package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {

    private HashMap<String, Bagel> bagelInventory = new HashMap<>();
    private HashMap<String, Filling> fillingInventory = new HashMap<>();

    public Inventory() {}

    public Inventory(HashMap<String, Bagel> bagelInventory, HashMap<String, Filling> fillingInventory) {
        this.bagelInventory = bagelInventory;
        this.fillingInventory = fillingInventory;
    }

    public HashMap<String, Bagel> getBagelInventory() {
        return bagelInventory;
    }

    public HashMap<String, Filling> getFillingInventory() {
        return fillingInventory;
    }

    public void addBagelType(String bagelType, double cost) {
        if (!bagelInventory.containsKey(bagelType)) {
            Bagel bagel = new Bagel(bagelType, cost);
            bagelInventory.put(bagelType, bagel);
        }
    }

    public void addFilling(String filling, double price) {
        if (!fillingInventory.containsKey(filling)) {
            Filling newFilling = new Filling(filling, price);
            fillingInventory.put(filling, newFilling);
        }
    }

    public boolean isBagelAvailable(String type) {
        return bagelInventory.containsKey(type);
    }

    public double getBagelsPrice(String type) {
        return bagelInventory.get(type).getPrice();
    }

    public double getFillingPrice(String name) {
        return fillingInventory.get(name).getCost();

    }

}
