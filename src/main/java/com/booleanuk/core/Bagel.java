package com.booleanuk.core;

public class Bagel implements Product{
    private final String SKU;
    private final String name;
    private final double price;

    public Bagel(String SKU){
        switch (SKU) {
            case "BGLO" -> {
                price = 0.49;
                name = "Onion";
            }
            case "BGLP" -> {
                price = 0.39;
                name = "Plain";
            }
            case "BGLE" -> {
                price = 0.49;
                name = "Everything";
            }
            case "BGLS" -> {
                price = 0.49;
                name = "Sesame";
            }
            default -> throw new IllegalArgumentException("Unexpected value for SKU: " + SKU);
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
        return "Bagel";
    }

    public double getPrice(){
        return price;
    }
}
