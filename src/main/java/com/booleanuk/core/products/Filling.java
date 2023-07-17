package com.booleanuk.core.products;

import java.math.BigDecimal;

public class Filling extends Product {
    private FillingVariant variant;

    public Filling(String SKU, BigDecimal price, FillingVariant variant) {
        super(SKU, price);
        this.variant = variant;
    }

    @Override
    public String toString() {
        return variant.toString() + " filling";
    }

    public FillingVariant getVariant() {
        return variant;
    }

    public void setVariant(FillingVariant variant) {
        this.variant = variant;
    }
}
