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
        products.put("BGLO", new Product("BGLO", 49, "Onion"));
        products.put("BGLP", new Product("BGLP", 39, "Plain"));
        products.put("BGLE", new Product("BGLE", 49, "Everything"));
        products.put("BGLS", new Product("BGLS", 49, "Sesame"));
        products.put("COFB", new Product("COFB", 99, "Black"));
        products.put("COFW", new Product("COFW", 119, "White"));
        products.put("COFC", new Product("COFC", 129, "Cappuccino"));
        products.put("COFL", new Product("COFL", 129, "Latte"));
        products.put("FILB", new Product("FILB", 12, "Bacon"));
        products.put("FILE", new Product("FILE", 12, "Egg"));
        products.put("FILC", new Product("FILC", 12, "Cheese"));
        products.put("FILX", new Product("FILX", 12, "Cream Cheese"));
        products.put("FILS", new Product("FILS", 12, "Smoked Salmon"));
        products.put("FILH", new Product("FILH", 12, "Ham"));

    }
    public Product getProduct(String SKU) {
        return products.get(SKU);
    }
}
