package com.booleanuk.core;

public class Bagel implements Product{
    private final String SKU;
    private final String name;
    private double price;
    private boolean appliedDiscount = false;
    private double moneySaved = 0;

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

    public void setPrice(double price){
        moneySaved = this.price - price;
        this.price = price;
        appliedDiscount = true;
    }
    public double getMoneySaved(){
        return moneySaved;
    }

    public boolean hasDiscount(){
        return appliedDiscount;
    }
}
