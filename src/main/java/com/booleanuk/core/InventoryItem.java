package com.booleanuk.core;

public abstract class InventoryItem {
    public String sku;
    public int price;
    public String name;
    public String variant;

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
}
