package com.booleanuk.core;

public class Coffee implements Inventory{
    private String SKU;
    private double price;
    private String name;
    private String variant;
    public Coffee(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }
    //Getters
    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public String toString() {
        return "Item: " +
                "SKU= " + SKU +
                ", price="  + price +
                ", name= " + name +
                ", variant= " + variant;
    }
}
