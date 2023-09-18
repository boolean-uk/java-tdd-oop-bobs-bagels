package com.booleanuk.core;

import java.util.Objects;

public abstract class InventoryItem {
    private String SKU;

    private double price;

    private String name;

    private String variant;

    public InventoryItem(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    // needed this because the test wasn't passing due too hashcode not matching
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(SKU, that.SKU) && Objects.equals(name, that.name) && Objects.equals(variant, that.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, price, name, variant);
    }

    // used this override to make visual what the hashcode represents
    @Override
    public String toString() {
        return "SKU: " + SKU + ", Price: " + price + ", Name: " + name + ", Variant: " + variant;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
