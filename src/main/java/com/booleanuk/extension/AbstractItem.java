package com.booleanuk.extension;

import java.util.ArrayList;

public abstract class AbstractItem {
    private Sku sku;
    private double price;

    private int quantity;
    private String name;
    private String variant;

    public AbstractItem(Sku sku, double price, int quantity, String name, String variant) {
        this.sku = sku;
        this.price = price;

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
   public ArrayList<Filling> getFillings(){
       return new ArrayList<Filling>();
   }

    public String toString(){
        return this.getVariant()+" "+this.getName()+"\t"+this.getQuantity()+"\t| $"+this.getPrice()*this.getQuantity();
    }
}
