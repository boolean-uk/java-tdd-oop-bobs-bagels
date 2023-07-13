package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
        products.put("BGLO", new Product("BGLO", 0.49F, "Bagel", "Onion"));
        products.put("BGLP", new Product("BGLP", 0.39F, "Bagel", "Plain"));
        products.put("BGLE", new Product("BGLE",0.49F, "Bagel", "Everything"));
        products.put("BGLS", new Product("BGLS",0.49F, "Bagel", "Sesame"));

        products.put("COFB", new Product("COFB",0.99F, "Coffee", "Black"));
        products.put("COFW", new Product("COFW", 1.19F, "Coffee", "White"));
        products.put("COFC", new Product("COFC", 1.29F, "Coffee", "Cappuccino"));
        products.put("COFL", new Product("COFL", 1.29F, "Coffee", "Latte"));

        products.put("FILB", new Product("FILB", 0.12F, "Filling", "Bacon"));
        products.put("FILE", new Product("FILE", 0.12F, "Filling", "Egg"));
        products.put("FILC", new Product("FILC", 0.12F, "Filling", "Cheese"));
        products.put("FILX", new Product("FILX", 0.12F, "Filling", "Cream Cheese"));
        products.put("FILS", new Product("FILS", 0.12F, "Filling", "Smoked Salmon"));
        products.put("FILH", new Product("FILH", 0.12F, "Filling", "Ham"));
        products.put("FILNOT", new Product("FILNOT", 0.12F, "NotFilling", "Feeling"));
    }

    public Product getProduct(String sku) {
        return products.get(sku);
    }
}
