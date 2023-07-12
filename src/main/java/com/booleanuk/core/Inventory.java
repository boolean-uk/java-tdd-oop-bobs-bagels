package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(String sku, float price, String name, String variant) {
        products.put(sku, new Product(sku, price, name, variant));
    }

    public boolean verifyProduct(String sku) {
        return products.containsKey(sku);
    }
}
