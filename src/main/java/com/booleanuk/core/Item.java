package com.booleanuk.core;

public abstract class Item {
    protected String sku;
    protected Double price;
    protected String name;
    protected String variant;

    public Item(String sku, Double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public boolean setName(String name) {
        if (name.isBlank()) {
            return false;
        }
        this.name = name;
        return true;
    }
// protected setters??
    // abstract methods - do we need different implementation?
    public String getVariant() {
        return this.variant;
    }

    public boolean setVariant(String variant) {
        if (variant.isBlank()) {
            return false;
        }
        this.variant = variant;
        return true;
    }

    public abstract double calculateTotalPrice(int quantity);
    // Either abstract method here or in Sellable interface
}
