package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private static final HashMap<String, Product> products = new HashMap<>() {{
        put("Onion", new Product("BGLO", 0.49d, "Bagle", "Onion"));
        put("Plain", new Product("BGLP", 0.39d, "Bagle", "Plain"));
        put("Everything", new Product("BGLE", 0.49d, "Bagle", "Everything"));
        put("Sesame", new Product("BGLS", 0.49d, "Bagle", "Sesame"));

        put("Black", new Product("COFB", 0.99d, "Coffee", "Black"));
        put("White", new Product("COFW", 1.19d, "Coffee", "White"));
        put("Capuccino", new Product("COFC", 1.29d, "Coffee", "Capuccino"));
        put("Latte", new Product("COFL", 1.29d, "Coffee", "Latte"));

        put("Bacon", new Product("FILB", 0.12d, "Filling", "Bacon"));
        put("Egg", new Product("FILE", 0.12d, "Filling", "Egg"));
        put("Cheese", new Product("FILC", 0.12d, "Filling", "Cheese"));
        put("Cream Cheese", new Product("FILX", 0.12d, "Filling", "Cream Cheese"));
        put("Smoked Salmon", new Product("FILS", 0.12d, "Filling", "Smoked Salmon"));
        put("Ham", new Product("FILH", 0.12d, "Filling", "Ham"));
    }};
}
