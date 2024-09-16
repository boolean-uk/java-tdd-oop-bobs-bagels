package com.booleanuk.extension.extension2;

import java.math.BigDecimal;

public enum FillingType {
    FILB("Bacon", BigDecimal.valueOf(0.12)),
    FILE("Egg", BigDecimal.valueOf(0.12)),
    FILC("Cheese", BigDecimal.valueOf(0.12)),
    FILX("Cream Cheese", BigDecimal.valueOf(0.12)),
    FILS("Smoked Salmon", BigDecimal.valueOf(0.12)),
    FILH("Ham", BigDecimal.valueOf(0.12)
    );

    private String variant;
    private BigDecimal price;

    FillingType(String variant, BigDecimal price) {
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