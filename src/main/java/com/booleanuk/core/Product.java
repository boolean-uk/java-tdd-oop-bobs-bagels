package com.booleanuk.core;

public class Product {
    private String sku;
    private float price;
    private String name;
    private String variant;

    public Product(String sku, float price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public Product(String sku, Inventory inventory) throws Exception {
        this.sku = sku;

        if(!inventory.verifyProduct(sku)) {
            throw new Exception("Product is not in inventory");
        };
    }
}
