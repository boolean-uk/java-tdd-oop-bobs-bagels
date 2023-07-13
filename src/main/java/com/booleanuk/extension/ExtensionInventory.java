package com.booleanuk.extension;

import java.util.HashMap;

public class ExtensionInventory {
    private static final HashMap<String, ExtensionProduct> products = new HashMap<>() {{
        put("Onion", new ExtensionProduct("BGLO", 0.49d, "Bagle", "Onion"));
        put("Plain", new ExtensionProduct("BGLP", 0.39d, "Bagle", "Plain"));
        put("Everything", new ExtensionProduct("BGLE", 0.49d, "Bagle", "Everything"));
        put("Sesame", new ExtensionProduct("BGLS", 0.49d, "Bagle", "Sesame"));

        put("Black", new ExtensionProduct("COFB", 0.99d, "Coffee", "Black"));
        put("White", new ExtensionProduct("COFW", 1.19d, "Coffee", "White"));
        put("Capuccino", new ExtensionProduct("COFC", 1.29d, "Coffee", "Capuccino"));
        put("Latte", new ExtensionProduct("COFL", 1.29d, "Coffee", "Latte"));

        put("Bacon", new ExtensionProduct("FILB", 0.12d, "Filling", "Bacon"));
        put("Egg", new ExtensionProduct("FILE", 0.12d, "Filling", "Egg"));
        put("Cheese", new ExtensionProduct("FILC", 0.12d, "Filling", "Cheese"));
        put("Cream Cheese", new ExtensionProduct("FILX", 0.12d, "Filling", "Cream Cheese"));
        put("Smoked Salmon", new ExtensionProduct("FILS", 0.12d, "Filling", "Smoked Salmon"));
        put("Ham", new ExtensionProduct("FILH", 0.12d, "Filling", "Ham"));
    }};

    public static HashMap<String, ExtensionProduct> getProducts() {
        return products;
    }
}
