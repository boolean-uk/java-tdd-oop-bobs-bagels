package com.booleanuk.core;

public class Bagel extends Item {
    private Filling filling;
    public Bagel(String SKU) {
        super(SKU);
    }

    public void addFilling(Filling filling) {
        this.filling = filling;
    }

    public Item getFilling() {
        return this.filling;
    }

}
