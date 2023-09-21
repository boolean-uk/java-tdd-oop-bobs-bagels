package com.booleanuk.core;

public class Bagel extends InventoryItem{

    private String name;

    public Bagel(String sku, double price, String variant) {
        super(sku, price, variant);
        this.name = "Bagel";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
