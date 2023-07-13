package com.booleanuk.core;

public class Bagel {
    private String type;
    private double price;

    private Filling filling;

    public Bagel(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Bagel(String type, double price, Filling filling) {
        this.type = type;
        this.price = price;
        this.filling = filling;
    }

    public void chooseFilling(Filling filling){
        //TODO: check if in inventory
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
