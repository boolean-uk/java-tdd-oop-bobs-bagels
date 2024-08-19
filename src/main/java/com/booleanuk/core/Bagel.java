package com.booleanuk.core;

public class Bagel {
    private BagelVariant variant;

    public Bagel(String sku, double price, String name, BagelVariant variant) {
        this.variant = variant;
    }

    public BagelVariant getVariant() {
        return variant;
    }

    public void setVariant(BagelVariant variant) {
        this.variant = variant;
    }

    public enum BagelVariant {
        ONION, PLAIN, EVERYTHING, SESAME;
    }
}
