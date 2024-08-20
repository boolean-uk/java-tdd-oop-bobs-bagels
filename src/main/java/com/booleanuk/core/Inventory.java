package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
        setInventory();

    }

    public void setInventory() {
        products.put("BGLO", new Bagel("BGLO", 49, "Onion"));
        products.put("BGLP", new Bagel("BGLP", 39, "Plain"));
        products.put("BGLE", new Bagel("BGLE", 49, "Everything"));
        products.put("BGLS", new Bagel("BGLS", 49, "Sesame"));
        products.put("COFB", new Coffee("COFB", 99, "Black"));
        products.put("COFW", new Coffee("COFW", 119, "White"));
        products.put("COFC", new Coffee("COFC", 129, "Cappuccino"));
        products.put("COFL", new Coffee("COFL", 129, "Latte"));
        products.put("FILB", new Filling("FILB", 12, "Bacon"));
        products.put("FILE", new Filling("FILE", 12, "Egg"));
        products.put("FILC", new Filling("FILC", 12, "Cheese"));
        products.put("FILX", new Filling("FILX", 12, "Cream Cheese"));
        products.put("FILS", new Filling("FILS", 12, "Smoked Salmon"));
        products.put("FILH", new Filling("FILH", 12, "Ham"));

    }
    public Product getProduct(String SKU) {
        return products.get(SKU);
    }
}
