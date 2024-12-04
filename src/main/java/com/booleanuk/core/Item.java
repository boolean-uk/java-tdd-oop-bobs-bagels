package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    protected String SKU;
    protected String name;
    protected BigDecimal price;
    protected String variant;

    public Item(String SKU, String name, BigDecimal price, String variant) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.variant = variant;
    }
    public BigDecimal getPrice() {
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getVariant() {
        return variant;
    }
    public String getSKU() {
        return this.SKU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(SKU, item.SKU) && Objects.equals(getName(), item.getName()) && Objects.equals(price, item.price) && Objects.equals(getVariant(), item.getVariant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, getName(), price, getVariant());
    }
}
