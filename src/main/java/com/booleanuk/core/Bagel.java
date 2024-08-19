package com.booleanuk.core;

public class Bagel extends Item {
    private Filling filling;
    public Bagel(String SKU) {
        super(SKU);
    }

    public void addFilling(String fillingSKU) {
        this.filling = new Filling(fillingSKU);
    }

    public Item getFilling() {
        return this.filling;
    }

}
