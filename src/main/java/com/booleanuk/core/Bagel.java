package com.booleanuk.core;

public class Bagel extends Item {
    private BagelVariant variant;
    private Filling filling;

    public Bagel(String sku, double price, String name, BagelVariant variant) {
        super(sku, price, name);
        this.variant = variant;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public BagelVariant getVariant() {
        return variant;
    }


    public enum BagelVariant {
        ONION, PLAIN, EVERYTHING, SESAME;
    }
}
