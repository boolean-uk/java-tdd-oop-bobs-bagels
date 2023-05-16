package com.booleanuk.extension;

import java.util.ArrayList;

public abstract class AbstractItem {
    private Sku sku;

    private double price;
    private double saving;
    private int quantity;
    private String name;
    private String variant;

    public AbstractItem(Sku sku, double price, double saving, int quantity, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.saving = saving;
        this.quantity = quantity;
        this.name = name;
        this.variant = variant;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public double calculateDiscount(){
        return this.price;
    }
    public ArrayList<Filling> getFillings(){
        return new ArrayList<Filling>();
    }
    abstract void display();
}
