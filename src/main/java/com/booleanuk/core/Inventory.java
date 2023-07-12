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

    public Product getProduct(String sku) {
        return products.get(sku);
    }
}
