package com.booleanuk.core.models;

public class Bagel {
    private String variant;
    private double price;
    private String SKU;
    private Filling filling;

    public Bagel(String variant, double price, String SKU ) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }
}
