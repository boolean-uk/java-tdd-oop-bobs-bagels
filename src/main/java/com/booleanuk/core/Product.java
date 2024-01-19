package com.booleanuk.core;

public class Product {
    final String SKU;
    private final String type;
    private final double price;
    private final String name;


    public Product(String SKU) throws IllegalStateException{

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
            case "COFB" -> {
                type = "Coffee";
                price = 0.99;
                name = "Black";
            }
            case "COFW" -> {
                type = "Coffee";
                price = 1.19;
                name = "White";
            }
            case "COFC" -> {
                type = "Coffee";
                price = 1.29;
                name = "Cappuccino";
            }
            case "COFL" -> {
                type = "Coffee";
                price = 1.29;
                name = "Latte";
            }
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

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object otherObj){
        if (getClass() == otherObj.getClass()){
            return this.SKU.equals(((Product) otherObj).SKU);
        } else if (otherObj instanceof String){
            return this.SKU.equals(otherObj);
        } else {
            return false;
        }
    }
}
