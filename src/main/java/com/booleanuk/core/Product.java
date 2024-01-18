package com.booleanuk.core;

public class Product {


    protected String sku;
    protected String name;
    protected String variant;
    protected double price;

    public Product(String name, String variant, double price, String sku) {
        this.name = name;
        this.variant = variant;
        this.price = price;
        this.sku = sku.toUpperCase();
    }
    public Product(String variant, double price) {
        this.name = "Other";
        this.variant = variant;
        this.price = price;
        this.sku = this.name.substring(0,3).toUpperCase() + this.variant.substring(0,1).toUpperCase();
    }

    public Product(String name, String variant, double price) {
        this.name = name;
        this.variant = variant;
        this.price = price;
        this.sku = this.name.substring(0,2).toUpperCase() + this.variant.substring(0,1).toUpperCase();
    }


}
