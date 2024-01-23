package com.booleanuk.core;

public class Filling implements Product {
    private final String SKU;
    private final String name;

    public Filling(String SKU){
        switch (SKU){
            case "FILB" -> name = "Bacon";
            case "FILE" -> name = "Egg";
            case "FILC" -> name = "Cheese";
            case "FILX" -> name = "Cream Cheese";
            case "FILS" -> name = "Smoked Salmon";
            case "FILH" -> name = "Ham";
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
        return "Filling";
    }

    public double getPrice(){
        return 0.12;
    }
}
