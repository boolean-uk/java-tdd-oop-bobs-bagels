package com.booleanuk.core;

public enum CoffeeType {
    COFB(0.99, "Black"),
    COFW(1.19, "White"),
    COFL(1.29, "Cappuccino"),
    COFC(1.29, "Latte");

    CoffeeType(double price, String variant) {
        this.price = price;
        this.variant = variant;
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

    private double price;
    private String variant;
}
