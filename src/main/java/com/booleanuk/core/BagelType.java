package com.booleanuk.core;

public enum BagelType {
    BGLO(0.49, "Onion"),
    BGLP(0.39, "Plain"),
    BGLE(0.49, "Everything"),
    BGLS(0.49, "Sesame");
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
    private double price;
    private String variant;
    BagelType(double price, String variant) {
        this.price = price;
        this.variant = variant;
    }
}

