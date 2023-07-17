package com.booleanuk.core;

public class Product {
    protected String name;
    protected double price;
    protected String variant;

    public Product(String name, double price, String variant) {
        this.name = name;
        this.price = price;
        this.variant = variant;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public String toString() {
        return variant + " " + name;
    }

    public String toStringExtended() {
        return "Name: " + name + " | Price: " + price + " | Variant: " + variant;
    }
}
