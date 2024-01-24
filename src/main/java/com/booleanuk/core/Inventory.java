package com.booleanuk.core;

public class Inventory extends Product {
    private String variant;

    public Inventory(String SKU, double price, String name, String variant) {
        super(SKU, price, name);
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public double applyDiscount() {
        // didn't get the time to finish
        return 0;
    }
}

