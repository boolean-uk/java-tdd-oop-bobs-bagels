package com.booleanuk.core;

public class Filling {

    private String type;
    private double price;

    public Filling(String type, double price) {
        this.type = type;
        this.price = price;
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

    @Override
    public String toString() {
        return "Filling{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
