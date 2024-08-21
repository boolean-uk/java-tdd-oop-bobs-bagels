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
        products.put("BGLO", new Bagel("BGLO", 49, "Onion Bagel"));
        products.put("BGLP", new Bagel("BGLP", 39, "Plain Bagel"));
        products.put("BGLE", new Bagel("BGLE", 49, "Everything Bagel"));
        products.put("BGLS", new Bagel("BGLS", 49, "Sesame Bagel"));
        products.put("COFB", new Coffee("COFB", 99, "Black Coffee"));
        products.put("COFW", new Coffee("COFW", 119, "White Coffee"));
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
        if (SKU == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }

        if (SKU.startsWith("BGL")) {
            return new Bagel(products.get(SKU).getSKU(), products.get(SKU).getPrice(), products.get(SKU).getVariant());
        }
        if (SKU.startsWith("COF")) {
            return new Coffee(products.get(SKU).getSKU(), products.get(SKU).getPrice(), products.get(SKU).getVariant());
        }
        return new Filling(products.get(SKU).getSKU(), products.get(SKU).getPrice(), products.get(SKU).getVariant());
    }
}
