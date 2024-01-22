package com.booleanuk.core;

public class Bagel implements Product{
    private final String SKU;
    private final String name;
    private final String type;
    private final double price;

    public Bagel(String SKU){
        switch (SKU) {
            case "BGLO" -> {
                type = "Bagel";
                price = 0.49;
                name = "Onion";
            }
            case "BGLP" -> {
                type = "Bagel";
                price = 0.39;
                name = "Plain";
            }
            case "BGLE" -> {
                type = "Bagel";
                price = 0.49;
                name = "Everything";
            }
            case "BGLS" -> {
                type = "Bagel";
                price = 0.49;
                name = "Sesame";
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
