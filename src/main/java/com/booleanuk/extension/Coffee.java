package com.booleanuk.extension;

public class Coffee extends Item {
    public Coffee(String SKU, String name, String type, double price){
        super(SKU, name, type, price);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
