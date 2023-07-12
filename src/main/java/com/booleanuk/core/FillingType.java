package com.booleanuk.core;

public enum FillingType {
    FILB(0.12, "Bacon"),
    FILE(0.12, "Egg"),
    FILC(0.12, "Cheese"),
    FILX(0.12, "Cream cheese"),
    FILS(0.12, "Smoked salmon"),
    FILH(0.12, "Ham");

    FillingType(double price, String variant) {
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
