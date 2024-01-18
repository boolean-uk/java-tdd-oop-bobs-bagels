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

    public String getType() {
        return type;
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
}

class Bagel extends Product{
    private List<String> fillings;

    public Bagel(String sku, String variant, double price) {
        super("Bagel", sku, variant, price);
        this.fillings = new ArrayList<>();
    }
    public List<String> getFillings() {
        return fillings;
    }
    public void addFillings(String filling) {
        fillings.add(filling);
    }
}

class Coffee extends Product{
    private String type;

    public Coffee(String sku, String variant, double price) {
        super("Coffee", sku, variant, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Filling extends Product{
    public Filling(String sku, String variant, double price) {
        super("Filling", sku, variant, price);
    }
}


