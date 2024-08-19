package com.booleanuk.core;

public class Item {

    private String SKU;
    private double price;
    private String variant;
    private String name;
    private int id;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item itemObjekt){
            return itemObjekt.getId() == this.getId();
        }
        return false;
    }

    public boolean removeFilling(int id){
        return false;
    }
}
