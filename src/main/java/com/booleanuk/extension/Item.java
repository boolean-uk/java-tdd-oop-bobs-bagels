package com.booleanuk.extension;

import java.math.BigDecimal;

public class Item {
    private final SKU sku;

    public Item(SKU sku) {
        this.sku = sku;
    }

    public Item(String name, String variant) {
        SKU ckeckedSKU = SKU.getConstant(new Item(name, variant));
        if (ckeckedSKU == null) {
            throw new IllegalArgumentException("No such item in inventory");
        }
        this.sku = ckeckedSKU;
    }

    public SKU getSku() {
        return sku;
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
