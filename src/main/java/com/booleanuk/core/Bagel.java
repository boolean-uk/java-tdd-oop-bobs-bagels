package com.booleanuk.core;

public class Bagel extends Product{
    Filling filling;

    public Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        this.filling = null;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }
}
