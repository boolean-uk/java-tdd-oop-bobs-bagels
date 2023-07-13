package com.booleanuk.core.products;

import java.util.Objects;

public abstract class Product {
    private String SKU;
    private double price;

    public Product(String SKU, double price) {
        this.SKU = SKU;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(SKU, product.SKU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, price);
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
