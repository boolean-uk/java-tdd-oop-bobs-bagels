package com.booleanuk.core;

import java.util.Arrays;

public class Bagel {
    private String sku;
    private double price;
    private String name;
    private String variant;
    private String[] fillings;
    public Bagel(String sku, double price, String name, String variant, String[] fillings) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.fillings = fillings;
    }
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String[] getFillings() {
        return fillings;
    }

    public void setFillings(String[] fillings) {
        this.fillings = fillings;
    }

    @Override
    public String toString() {
        return "Bagel{" +
                "sku='" + sku + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", variant='" + variant + '\'' +
                ", fillings='" + Arrays.toString(fillings) + '\'' +
                '}';
    }
}
