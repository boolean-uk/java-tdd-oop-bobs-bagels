package com.booleanuk.core;

public abstract class InventoryItem {
    private String sku;
    private int price;
    private String name;
    private String variant;

    public InventoryItem(String sku,int price,String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    @Override
    public String toString(){
        return this.variant + " " + this.name + " £" + (double)this.price/100 + "\n";
    }

    public String getFullName(){
        return this.variant + " " + this.name;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }
}
