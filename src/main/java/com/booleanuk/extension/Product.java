package com.booleanuk.extension;

import java.math.BigDecimal;

public abstract class Product {
    protected BigDecimal price;
    protected String variant;

    public Product(BigDecimal price, String variant) {
        this.price = price;
        this.variant = variant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }

    public int getSize() {
        return 1;
    }
}
