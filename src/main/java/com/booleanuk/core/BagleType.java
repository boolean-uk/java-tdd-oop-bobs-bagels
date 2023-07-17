package com.booleanuk.core;

import java.math.BigDecimal;

public enum BagleType {
    BGLO("Onion", BigDecimal.valueOf(0.49)),
    BGLP("Plain", BigDecimal.valueOf(0.39)),
    BGLE("Everything", BigDecimal.valueOf(0.49)),
    BGLS("Sesame", BigDecimal.valueOf(0.49)
    );

    private String variant;
    private BigDecimal price;

    BagleType(String variant, BigDecimal price) {
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
