package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    protected String type;
    protected String variant;
    protected String sku;
    protected double price;

    public Product(String type, String sku, String variant, double price) {
        this.type = type;
        this.sku = sku;
        this.variant = variant;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }
    public String getVariant() {
        return variant;
    }
    public double getPrice() {
        return price;
    }

    public String getType(){
        return type;
    }
}

class Bagel extends Product{
    public Bagel(String sku, String variant, double price) {
        super("Bagel", sku, variant, price);
    }
}

class Coffee extends Product{

    public Coffee(String sku, String variant, double price) {
        super("Coffee", sku, variant, price);
    }

}

class Filling extends Product{
    public Filling(String sku, String variant, double price) {
        super("Filling", sku, variant, price);
    }
}


