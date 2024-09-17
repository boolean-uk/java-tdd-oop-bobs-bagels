package com.booleanuk.core.products;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {
    private String SKU;
    private BigDecimal price;

    public Product(String SKU, BigDecimal price) {
        this.SKU = SKU;
        this.price = price;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(SKU, product.SKU) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "SKU='" + SKU + '\'' +
                ", price=" + price;
    }
}


