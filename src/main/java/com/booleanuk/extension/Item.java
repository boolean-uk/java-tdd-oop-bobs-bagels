package com.booleanuk.extension;

public class Item {
    private String sku;
    private String type;
    private double price;
    private String variant;
    private int quantity;
    public Item(String sku, String type, double price, String variant){
        this.sku = sku;
        this.type = type;
        this.price = price;
        this.variant = variant;
        this.quantity = 1;
    }

    public String getSku() {
        return sku;
    }
    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }
    public String getVariant(){
        return variant;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getTotalCost(){
        return price * quantity;
    }
    @Override
    public String toString() {
        return getVariant() + " " + getType() + " " + getQuantity() + " " + getPrice();
    }

}
