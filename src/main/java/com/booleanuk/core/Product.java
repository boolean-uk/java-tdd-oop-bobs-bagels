package com.booleanuk.core;

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
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                '}';
    }
}
