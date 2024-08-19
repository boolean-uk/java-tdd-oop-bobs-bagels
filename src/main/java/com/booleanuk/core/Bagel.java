package com.booleanuk.core;

public class Bagel extends Item {
    private Filling filling = null;
    public Bagel(String SKU) {
        super(SKU);
    }

    public void addFilling(Filling filling) {
        this.filling = filling;
    }

    public Filling getFilling() {
        return this.filling;
    }

    public void removeFilling() {
        this.filling = null;
    }

}
