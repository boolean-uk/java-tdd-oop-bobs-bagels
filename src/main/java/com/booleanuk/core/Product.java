package com.booleanuk.core;

import java.util.Objects;

public abstract class Product {
    protected String SKU;
    protected Double price;
    protected String variant;

    public Product(String SKU, Double price, String variant){
        this.SKU = SKU;
        this.price = price;
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public Double getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(SKU, product.SKU) &&
                Objects.equals(price, product.price) &&
                Objects.equals(variant, product.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, price, variant);
    }
}
