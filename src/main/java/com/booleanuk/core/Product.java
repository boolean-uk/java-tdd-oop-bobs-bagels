package com.booleanuk.core;

public class Product {
    private int id;
    private String SKU;
    private float price;
    private Enum name;
    private Enum variant;

    public Product(int id, String SKU, float price, Enum name, Enum variant) {
        this.id = id;
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public int getId() {
        return this.id;
    }

    public String getSKU() {
        return this.SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Enum getName() {
        return this.name;
    }

    public void setName(Enum name) {
        this.name = name;
    }

    public Enum getVariant() {
        return variant;
    }

    public void setVariant(Enum variant) {
        this.variant = variant;
    }
}
