package com.booleanuk.core;

import java.util.Objects;

public class Product {
    private final String type;
    private final double cost;
    private final String sku;

    public Product(String type, double cost, String sku) {
        this.type = type;
        this.cost = cost;
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost ;
    }

    public String getSku() {
        return sku;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return Objects.equals(this.sku, product.getSku());
    }

    @Override
    public int hashCode() {
        int result = this.sku.hashCode();
        return result * 31 + (int)(this.cost * 100);
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                '}';
    }
}
