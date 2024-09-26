package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
        products.put("BGLO", new Bagel("BGLO", 0.49F, "Bagel", "Onion", 6, 2.49F));
        products.put("BGLP", new Bagel("BGLP", 0.39F, "Bagel", "Plain", 12, 3.99F));
        products.put("BGLE", new Bagel("BGLE",0.49F, "Bagel", "Everything", 6, 2.49F));
        products.put("BGLS", new Bagel("BGLS",0.49F, "Bagel", "Sesame"));

        products.put("COFB", new Coffee("COFB",0.99F, "Coffee", "Black"));
        products.put("COFW", new Coffee("COFW", 1.19F, "Coffee", "White"));
        products.put("COFC", new Coffee("COFC", 1.29F, "Coffee", "Cappuccino"));
        products.put("COFL", new Coffee("COFL", 1.29F, "Coffee", "Latte"));

        products.put("FILB", new Filling("FILB", 0.12F, "Filling", "Bacon"));
        products.put("FILE", new Filling("FILE", 0.12F, "Filling", "Egg"));
        products.put("FILC", new Filling("FILC", 0.12F, "Filling", "Cheese"));
        products.put("FILX", new Filling("FILX", 0.12F, "Filling", "Cream Cheese"));
        products.put("FILS", new Filling("FILS", 0.12F, "Filling", "Smoked Salmon"));
        products.put("FILH", new Filling("FILH", 0.12F, "Filling", "Ham"));
        products.put("FILNOT", new Filling("FILNOT", 0.12F, "NotFilling", "Feeling"));
    }

    public Product getProduct(String sku) {
        return products.get(sku);
    }
}
