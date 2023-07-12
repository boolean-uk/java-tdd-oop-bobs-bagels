package com.booleanuk.core;

public enum BagelType implements IItemType {
    BGLO("BGLO", 0.49, "Onion"),
    BGLP("BGLP", 0.39, "Plain"),
    BGLE("BGLE", 0.49, "Everything"),
    BGLS("BGLS", 0.49, "Sesame");
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
    public String getSku() {
        return sku;
    }
    public String sku;
    private double price;
    private String variant;
    BagelType(String sku, double price, String variant) {
        this.sku = sku;
        this.price = price;
        this.variant = variant;
    }
}
