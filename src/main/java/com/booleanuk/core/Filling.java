package com.booleanuk.core;

import java.math.BigDecimal;

public class Filling {
    private BigDecimal price;

    private String variant;

    public Filling(BigDecimal price, String variant) {
        this.price = price;
        this.variant = variant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }
}
