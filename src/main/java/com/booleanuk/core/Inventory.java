package com.booleanuk.core;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Inventory {

    private final LinkedHashMap<String, Double> bagelPrices;
    private final LinkedHashMap<String, Double> fillingPrices;
    private final LinkedHashMap<String, Double> coffeePrices;
    private final HashMap<String, String> inventoryStock;

    public Inventory() {
        this.bagelPrices = new LinkedHashMap<>();
        createBagelPrices();
        this.fillingPrices = new LinkedHashMap<>();
        createFillingPrices();
        this.coffeePrices = new LinkedHashMap<>();
        createCoffeePrices();
        this.inventoryStock = new HashMap<>();
        createInventoryStock();
    }

    public boolean isInInventory(String sKU) {
        for (String item : this.inventoryStock.values()) {
            if (sKU.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean canItemBeOrdered(String name) {
        return (this.inventoryStock.containsKey(name));
    }

    public String getSKU(String name) {
        return this.inventoryStock.get(name);
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
        this.inventoryStock.put("Onion", "BGLO");
        this.inventoryStock.put("Plain", "BGLP");
        this.inventoryStock.put("Everything", "BGLE");
        this.inventoryStock.put("Sesame", "BGLS");
        this.inventoryStock.put("Bacon", "FILB");
        this.inventoryStock.put("Egg", "FILE");
        this.inventoryStock.put("Cheese", "FILC");
        this.inventoryStock.put("Cream Cheese", "FILX");
        this.inventoryStock.put("Smoked Salmon", "FILS");
        this.inventoryStock.put("Ham", "FILH");
        this.inventoryStock.put("Black", "COFB");
        this.inventoryStock.put("White", "COFW");
        this.inventoryStock.put("Cappuccino", "COFC");
        this.inventoryStock.put("Latte", "COFL");
    }
}
