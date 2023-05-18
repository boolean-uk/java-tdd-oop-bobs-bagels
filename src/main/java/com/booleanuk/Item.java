package com.booleanuk;

public class Item extends Object {
    private final String variant;
    private final double price;

    public Item(String variant, double price){
        this.variant = variant;
        this.price = price;
    }

    public String getVariant(){
        return this.variant;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Item)) return false;

        Item objItem = (Item) obj;

        return this.variant.equals(objItem.getVariant()) && this.price == objItem.getPrice();
    }
}
