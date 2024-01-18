package com.booleanuk.core;

import java.util.HashMap;

public class Coffee {
    private String name;
    private double price;
    private String variant;


    public Coffee(String id){
        this.name = "Coffee";
        switch (id) {
            case "COFB" -> {
                this.variant = "Black";
                this.price = 0.99;
            }
            case "COFW" -> {
                this.variant = "White";
                this.price = 1.19;
            }
            case "COFC" -> {
                this.variant = "Cappuccino";
                this.price = 1.29;
            }
            case "COFL" -> {
                this.variant = "Latte";
                this.price = 1.29;
            }
            default -> throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}
