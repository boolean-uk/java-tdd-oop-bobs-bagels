package com.booleanuk.core.models;

public class CoffeelExt extends Coffee {

    private int quantity;

    public CoffeelExt(String variant, double price, String SKU) {
        super(variant, price, SKU);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
