package com.booleanuk.core;

public class Filling {
    private String name;
    private double price;
    private String variant;


    public Filling(String id){
        this.name = "Filling";
        switch (id) {
            case "FILB" -> {
                this.variant = "Bacon";
                this.price = 0.12;
            }
            case "FILE" -> {
                this.variant = "Egg";
                this.price = 0.12;
            }
            case "FILC" -> {
                this.variant = "Cheese";
                this.price = 0.12;
            }
            case "FILX" -> {
                this.variant = "Cream Cheese";
                this.price = 0.12;
            }
            case "FILS" -> {
                this.variant = "Smoked Salmon";
                this.price = 0.12;
            }
            case "FILH" -> {
                this.variant = "Ham";
                this.price = 0.12;
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
