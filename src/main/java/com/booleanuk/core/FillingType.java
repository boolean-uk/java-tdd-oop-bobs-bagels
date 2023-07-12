package com.booleanuk.core;

public enum FillingType implements IItemType {
    FILB("FILB", 0.12, "Bacon"),
    FILE("FILE", 0.12, "Egg"),
    FILC("FILC", 0.12, "Cheese"),
    FILX("FILX", 0.12, "Cream cheese"),
    FILS("FILS", 0.12, "Smoked salmon"),
    FILH("FILH", 0.12, "Ham");

    FillingType(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }

    public double getPrice() {
        return price;
    }
    public String getVariant() {
        return variant;
    }
    public String getSku() { return sku; }
    public final String sku;
    private final double price;
    private final String variant;
}
