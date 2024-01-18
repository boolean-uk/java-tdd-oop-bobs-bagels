package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Inventory {

    private LinkedHashMap<String, Double> bagelPrices;
    private LinkedHashMap<String, Double> fillingPrices;
    private LinkedHashMap<String, Double> coffeePrices;
    private ArrayList<String> inventoryStock;

    public Inventory() {
        this.bagelPrices = new LinkedHashMap<>();
        createBagelPrices();
        this.fillingPrices = new LinkedHashMap<>();
        createFillingPrices();
        this.coffeePrices = new LinkedHashMap<>();
        createCoffeePrices();
        this.inventoryStock = new ArrayList<>();
        createInventoryStock();
    }

    public boolean isInInventory(String sKU) {
        return inventoryStock.contains(sKU);
    }

    public double getPrice(String name) {
        if (this.bagelPrices.containsKey(name)) {
            return this.bagelPrices.get(name);
        }
        else if (this.coffeePrices.containsKey(name)) {
            return this.coffeePrices.get(name);
        }
        return this.fillingPrices.get(name);
    }

    public HashMap<String, Double> getBagelPrices() {
        return this.bagelPrices;
    }

    public HashMap<String, Double> getFillingPrices() {
        return this.fillingPrices;
    }

    public HashMap<String, Double> getCoffeePrices() {
        return this.coffeePrices;
    }

    private void createBagelPrices() {
        this.bagelPrices.put("Onion", 0.49);
        this.bagelPrices.put("Plain", 0.39);
        this.bagelPrices.put("Everything", 0.49);
        this.bagelPrices.put("Sesame", 0.49);
    }

    private void createFillingPrices() {
        this.fillingPrices.put("Bacon", 0.12);
        this.fillingPrices.put("Egg", 0.12);
        this.fillingPrices.put("Cheese", 0.12);
        this.fillingPrices.put("Cream Cheese", 0.12);
        this.fillingPrices.put("Smoked Salmon", 0.12);
        this.fillingPrices.put("Ham", 0.12);
    }

    private void createCoffeePrices() {
        this.coffeePrices.put("Black", 0.99);
        this.coffeePrices.put("White", 1.19);
        this.coffeePrices.put("Cappuccino", 1.29);
        this.coffeePrices.put("Latte", 1.29);
    }

    private void createInventoryStock() {
        this.inventoryStock.add("BGLO");
        this.inventoryStock.add("BGLP");
        this.inventoryStock.add("BGLE");
        this.inventoryStock.add("BGLS");
        this.inventoryStock.add("FILB");
        this.inventoryStock.add("FILE");
        this.inventoryStock.add("FILC");
        this.inventoryStock.add("FILX");
        this.inventoryStock.add("FILS");
        this.inventoryStock.add("FILH");
        this.inventoryStock.add("COFB");
        this.inventoryStock.add("COFW");
        this.inventoryStock.add("COFC");
        this.inventoryStock.add("COFL");
    }
}
