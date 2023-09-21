package com.booleanuk.core;

public class Coffee extends InventoryItem{

    private String name;

    public Coffee(String sku, double price, String variant) {
        super(sku, price, variant);
        this.name = "Coffee";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
