package com.booleanuk.core;

public class Inventory {
    private String SKU;
    private double price;
    private String name;
    private String variant;

    public Inventory(String SKU,double price,String name,String variant){
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

    //Setters
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "Inventory: " +
                "SKU='" + SKU + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", variant='" + variant;
    }
}