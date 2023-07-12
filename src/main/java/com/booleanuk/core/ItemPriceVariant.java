package com.booleanuk.core;

public class ItemPriceVariant {
    private final String variant;
    private final double price;
    public ItemPriceVariant(String variant, double price) {
        this.variant = variant;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getVariant() {
        return variant;
    }
}
