package com.booleanuk.core.Products;

import java.math.BigDecimal;

public class Filling extends Item {
    private FillingType variant;
    public Filling(String SKU, BigDecimal price, String name, FillingType variant) {
        super(SKU, price, name);
        this.variant = variant;
    }

    public FillingType getVariant() {
        return variant;
    }

    public void setVariant(FillingType variant) {
        this.variant = variant;
    }

    // double filling etc.

    @Override
    public String toString() {
        return String.format("%s %s", this.variant, this.name);
    }

}
