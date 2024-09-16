package com.booleanuk.core;

public class Item {
    private final String itemName;
    private final double price;
    private final String sku;
    private final String variant;

    public Item(String itemName, double price, String sku, String variant) {
        this.itemName = itemName;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public String getVariant() {
        return variant;
    }
}