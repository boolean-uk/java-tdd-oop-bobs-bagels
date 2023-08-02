package com.booleanuk.core;

public class Coffee extends Product{
    public Coffee(String SKU, Double price, String variant) {
        super(SKU, price, variant);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "SKU='" + SKU + '\'' +
                ", price=" + price +
                ", variant='" + variant + '\'' +
                '}';
    }

    @Override
    public Coffee clone() {
        return new Coffee(SKU, price, variant);
    }
}
