package com.booleanuk.core;

import java.math.BigDecimal;

public enum CoffeeType {
    COFB("Black", BigDecimal.valueOf(0.99)),
    COFW("White", BigDecimal.valueOf(1.19)),
    COFC("Capuccino", BigDecimal.valueOf(1.29)),
    COFL("Latte", BigDecimal.valueOf(1.29));

    private String variant;
    private BigDecimal price;

    CoffeeType(String variant, BigDecimal price) {
        this.variant = variant;
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public BigDecimal getPrice() {
        return price;
    }
}