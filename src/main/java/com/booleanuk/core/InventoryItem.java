package com.booleanuk.core;

public class InventoryItem {

    private String sku;
    private double price;
    private String variant;

    public InventoryItem(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }

    public InventoryItem() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
