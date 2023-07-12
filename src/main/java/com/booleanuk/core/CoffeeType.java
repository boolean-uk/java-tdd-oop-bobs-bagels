package com.booleanuk.core;

public enum CoffeeType implements IItemType {
    COFB("COFB", 0.99, "Black"),
    COFW("COFW", 1.19, "White"),
    COFL("COFL", 1.29, "Cappuccino"),
    COFC("COFC", 1.29, "Latte");

    CoffeeType(String sku, double price, String variant) {
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
    public String getSku() {
        return sku;
    }
    public final String sku;
    private final double price;
    private final String variant;
}
