package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Item {
    protected String sku;
    protected BigDecimal price;
    protected String name;
    protected String variant;

    public Item(String sku, BigDecimal  price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public boolean setName(String name) {
        if (name.isBlank()) {
            return false;
        }
        this.name = name;
        return true;
    }
// protected setters??
    // abstract methods - do we need different implementation?
    public String getVariant() {
        return this.variant;
    }

    public boolean setVariant(String variant) {
        if (variant.isBlank()) {
            return false;
        }
        this.variant = variant;
        return true;
    }

    public abstract double calculateTotalPrice(int quantity);
    // Either abstract method here or in Sellable interface


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku) && Objects.equals(price, item.price) && Objects.equals(name, item.name) && Objects.equals(variant, item.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, price, name, variant);
    }
}
