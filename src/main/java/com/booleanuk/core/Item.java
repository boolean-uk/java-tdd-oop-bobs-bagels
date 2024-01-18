package com.booleanuk.core;

public class Item {
    private String itemName;
    private double price;
    private String sku;
    private String variant;

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

    public String toString() {
        return "This " + itemName + " with SKU " + sku + " costs " + price;
    }
}
