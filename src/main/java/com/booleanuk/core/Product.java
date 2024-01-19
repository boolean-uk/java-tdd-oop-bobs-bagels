package com.booleanuk.core;

public class Product {
    private String itemName;
    private double price;
    private String sku;
    private String variant;

    public Product(String itemName, double price, String sku, String variant) {
        this.itemName = itemName;
        this.price = price;
        this.sku = sku;
        this.variant = variant;
    }

    public String getItemName() {
        System.out.println("Name: " + this.itemName);
        return this.itemName;
    }

    public double getPrice() {
        System.out.println("Price:" + this.price);
        return this.price;
    }

    public String getSku() {
        System.out.println("SKU:" + this.sku);
        return this.sku;
    }

    public String getVariant() {
        System.out.println("Variant: " + this.variant);
        return this.variant;
    }

    public String toString() {
        return "This " + getItemName() + " with SKU " + getSku() + " costs " + getPrice();
    }
}