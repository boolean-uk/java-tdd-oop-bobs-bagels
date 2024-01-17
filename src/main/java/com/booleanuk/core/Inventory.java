package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {

    public HashMap<String, Double> bagels;
    public HashMap<String, Double> fillings;
    public HashMap<String, Double> coffees;

    public Inventory() {
        this.bagels = new HashMap<>();
        createBagelInventory();
        this.fillings = new HashMap<>();
        createFillingInventory();
        this.coffees = new HashMap<>();
        createCoffeeInventory();
    }

    public boolean isInInventory(String sKU) {
        if (bagels.containsKey(sKU)) {
            return true;
        }
        if (fillings.containsKey(sKU)) {
            return true;
        }
        return coffees.containsKey(sKU);
    }

    private void createBagelInventory() {
        this.bagels.put("BGLO", 0.49);
        this.bagels.put("BGLP", 0.39);
        this.bagels.put("BGLE", 0.49);
        this.bagels.put("BGLS", 0.49);
    }

    private void createFillingInventory() {
        this.fillings.put("FILB", 0.12);
        this.fillings.put("FILE", 0.12);
        this.fillings.put("FILC", 0.12);
        this.fillings.put("FILX", 0.12);
        this.fillings.put("FILS", 0.12);
        this.fillings.put("FILH", 0.12);
    }

    private void createCoffeeInventory() {
        this.coffees.put("COFB", 0.99);
        this.coffees.put("COFW", 0.99);
        this.coffees.put("COFC", 0.99);
        this.coffees.put("COFL", 0.99);
    }
}
