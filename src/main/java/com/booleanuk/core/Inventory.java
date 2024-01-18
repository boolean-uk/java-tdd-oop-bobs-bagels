package com.booleanuk.core;

public class Inventory {

    String SKU;
    double price;
    String name;
    String variant;

    public Inventory(String SKU, double price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }
    public Inventory(String SKU) {
        this.SKU = SKU;
        this.price = 0.0;
        this.name = "unknown";
        this.variant = "unknown";
    }
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
        String inv = " ";

        inv +=  "SKU='" + this.SKU + '\n' ;
        inv += ", price='" + this.price + '\n' ;
        inv += ", price=" + this.price + '\n';
        inv += ", name=" + this.name + '\n';
        inv += ", variant='" + this.variant + '\n';
        return inv;
    }
}
