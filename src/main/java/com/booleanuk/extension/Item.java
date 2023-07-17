package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Item {
    private final SKU sku;

    public Item(SKU sku) {
        this.sku = sku;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
