package com.booleanuk.core.models;

public class BagelExt extends Bagel{

    private int quantity;

    public BagelExt(String variant, double price, String SKU) {
        super(variant, price, SKU);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
