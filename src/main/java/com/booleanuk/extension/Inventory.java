package com.booleanuk.extension;

import java.util.HashMap;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("BGLO", new Product("BGLO", 0.49d, "Bagle", "Onion"));
        put("BGLP", new Product("BGLP", 0.39d, "Bagle", "Plain"));
        put("BGLE", new Product("BGLE", 0.49d, "Bagle", "Everything"));
        put("BGLS", new Product("BGLS", 0.49d, "Bagle", "Sesame"));

        put("COFB", new Product("COFB", 0.99d, "Coffee", "Black"));
        put("COFW", new Product("COFW", 1.19d, "Coffee", "White"));
        put("COFC", new Product("COFC", 1.29d, "Coffee", "Capuccino"));
        put("COFL", new Product("COFL", 1.29d, "Coffee", "Latte"));

        put("FILB", new Product("FILB", 0.12d, "Filling", "Bacon"));
        put("FILE", new Product("FILE", 0.12d, "Filling", "Egg"));
        put("FILC", new Product("FILC", 0.12d, "Filling", "Cheese"));
        put("FILX", new Product("FILX", 0.12d, "Filling", "Cream Cheese"));
        put("FILS", new Product("FILS", 0.12d, "Filling", "Smoked Salmon"));
        put("FILH", new Product("FILH", 0.12d, "Filling", "Ham"));
    }};

    public static HashMap<String, Product> getProducts() {
        return products;
    }
}
