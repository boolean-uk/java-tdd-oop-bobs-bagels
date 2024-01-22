package com.booleanuk.core;

public class Filling implements Product {
    private final String SKU;
    private final String name;
    private final String type;
    private final double price;

    public Filling(String SKU){
        switch (SKU){
            case "FILB" -> {
                type = "Filling";
                price = 0.12;
                name = "Bacon";
            }
            case "FILE" -> {
                type = "Filling";
                price = 0.12;
                name = "Egg";
            }
            case "FILC" -> {
                type = "Filling";
                price = 0.12;
                name = "Cheese";
            }
            case "FILX" -> {
                type = "Filling";
                price = 0.12;
                name = "Cream Cheese";
            }
            case "FILS" -> {
                type = "Filling";
                price = 0.12;
                name = "Smoked Salmon";
            }
            case "FILH" -> {
                type = "Filling";
                price = 0.12;
                name = "Ham";
            }
            default -> throw new IllegalStateException("Unexpected value: " + SKU);
        }
        this.SKU = SKU;
    }

    public String getSKU(){
        return SKU;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }
}
