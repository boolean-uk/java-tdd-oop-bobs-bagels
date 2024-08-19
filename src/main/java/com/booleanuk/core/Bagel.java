package com.booleanuk.core;

public class Bagel extends Product {

    private Filling currentFilling;

    public Bagel(String SKU, double price) {
        super(SKU, price);
    }

    public Filling getFilling() {
        return this.currentFilling;
    }

    public void setFilling(Filling newFilling) {
        this.currentFilling = newFilling;
    }

}
