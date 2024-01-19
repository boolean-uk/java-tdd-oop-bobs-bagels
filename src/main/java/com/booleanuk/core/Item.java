package com.booleanuk.core;

public class Item {

    private final String SKU;
    private String name;
    private double cost;
    private String variant;

    public Item(String SKU, double cost, String name, String variant) {
        this.SKU = SKU;
        this.cost = cost;
        this.name = name;
        this.variant = variant;
    }
    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Class getInstance() {
        return getClass();
    }

    @Override
    public String toString() {
        return this.SKU + "\t" + this.cost + "\t" + this.name + "\t" + this.variant;
    }
}
