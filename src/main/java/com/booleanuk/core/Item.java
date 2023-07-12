package com.booleanuk.core;

import java.math.BigDecimal;

public class Item {
    private final SKU sku;

    public Item(SKU sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return sku.getPrice();
    }

    public String getName() {
        return sku.getName();
    }

    public String getVariant() {
        return sku.getVariant();
    }
}
