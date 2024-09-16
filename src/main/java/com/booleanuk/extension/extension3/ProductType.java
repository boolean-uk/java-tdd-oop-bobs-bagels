package com.booleanuk.extension.extension3;

import java.math.BigDecimal;

public enum ProductType {

    BGLO("Onion", BigDecimal.valueOf(0.49)),
    BGLP("Plain", BigDecimal.valueOf(0.39)),
    BGLE("Everything", BigDecimal.valueOf(0.49)),
    BGLS("Sesame", BigDecimal.valueOf(0.49)),
    COFB("Black", BigDecimal.valueOf(0.99)),
    COFW("White", BigDecimal.valueOf(1.19)),
    COFC("Capuccino", BigDecimal.valueOf(1.29)),
    COFL("Latte", BigDecimal.valueOf(1.29)),
    CBD("Coffee & Bagel", BigDecimal.valueOf(1.25));
    private String variant;
    private BigDecimal price;

    ProductType(String variant, BigDecimal price) {
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
