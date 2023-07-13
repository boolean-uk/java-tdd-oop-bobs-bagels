package com.booleanuk.extension;

public class Product {
    private String sku;
    private int price;
    private String name;
    private String variant;

    public Product(String sku, int price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
