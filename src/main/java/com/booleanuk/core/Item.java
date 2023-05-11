package com.booleanuk.core;

import java.util.ArrayList;

public class Item {
    private String sku;
    private double price;
    private String name;

    private String variant;
    ArrayList<Item> fillings;

    public Item(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.fillings = new ArrayList<>();
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

    public ArrayList<Item> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<Item> fillings) {
        this.fillings = fillings;
    }
}
