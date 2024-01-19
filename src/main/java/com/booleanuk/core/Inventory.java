package com.booleanuk.core;

public class Inventory {
    private String sku;
    private String itemType;
    private String name;
    private double price;

    public Inventory(String sku, String itemType, String name, double price) {

        this.setSku(sku);
        this.setItemType(itemType);
        this.setName(name);
        this.setPrice(price);



    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
