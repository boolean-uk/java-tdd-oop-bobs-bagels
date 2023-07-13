package com.booleanuk.core.products;

public class Filling extends Product {
    private FillingVariant variant;

    public Filling(String SKU, double price) {
        super(SKU, price);
    }

    @Override
    public String toString() {
        return variant + " filling";
    }

    public FillingVariant getVariant() {
        return variant;
    }

    public void setVariant(FillingVariant variant) {
        this.variant = variant;
    }
}
