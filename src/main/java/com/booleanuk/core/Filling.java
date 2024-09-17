package com.booleanuk.core;

public class Filling extends Item{
    public Filling(String SKU, String name, String type, double price){
        super(SKU, name, type, price);
    }

    @Override
    public String toString() {
        return "Filling{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
