package com.booleanuk.extension;

import java.math.BigDecimal;

public abstract class Product {
    private String sku;
    private BigDecimal price;
    protected String variant;

    public Product(String sku, BigDecimal price, String variant) {
        this.sku = sku;
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

    public String getSku() {
        return sku;
    }
}
