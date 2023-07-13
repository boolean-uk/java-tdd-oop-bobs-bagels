package com.booleanuk.extension;

import java.util.HashMap;

public class ExtensionInventory {
    private static final HashMap<String, com.booleanuk.extension.ExtensionProduct> products = new HashMap<>() {{
        put("BGLO", new ExtensionProduct("BGLO", 0.49d, "Bagle", "Onion"));
        put("BGLP", new ExtensionProduct("BGLP", 0.39d, "Bagle", "Plain"));
        put("BGLE", new ExtensionProduct("BGLE", 0.49d, "Bagle", "Everything"));
        put("BGLS", new ExtensionProduct("BGLS", 0.49d, "Bagle", "Sesame"));

        put("COFB", new ExtensionProduct("COFB", 0.99d, "Coffee", "Black"));
        put("COFW", new ExtensionProduct("COFW", 1.19d, "Coffee", "White"));
        put("COFC", new ExtensionProduct("COFC", 1.29d, "Coffee", "Capuccino"));
        put("COFL", new ExtensionProduct("COFL", 1.29d, "Coffee", "Latte"));

        put("FILB", new ExtensionProduct("FILB", 0.12d, "Filling", "Bacon"));
        put("FILE", new ExtensionProduct("FILE", 0.12d, "Filling", "Egg"));
        put("FILC", new ExtensionProduct("FILC", 0.12d, "Filling", "Cheese"));
        put("FILX", new ExtensionProduct("FILX", 0.12d, "Filling", "Cream Cheese"));
        put("FILS", new ExtensionProduct("FILS", 0.12d, "Filling", "Smoked Salmon"));
        put("FILH", new ExtensionProduct("FILH", 0.12d, "Filling", "Ham"));
    }};

    public static HashMap<String, com.booleanuk.extension.ExtensionProduct> getProducts() {
        return products;
    }
}
