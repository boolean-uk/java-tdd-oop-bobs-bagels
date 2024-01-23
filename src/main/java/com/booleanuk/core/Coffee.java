package com.booleanuk.core;

public class Coffee implements Product{
    private final String SKU;
    private final String name;
    private final double price;

    public Coffee(String SKU){
        switch (SKU){
            case "COFB" -> {
                price = 0.99;
                name = "Black";
            }
            case "COFW" -> {
                price = 1.19;
                name = "White";
            }
            case "COFC" -> {
                price = 1.29;
                name = "Cappuccino";
            }
            case "COFL" -> {
                price = 1.29;
                name = "Latte";
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
        return "Coffee";
    }

    public double getPrice(){
        return price;
    }
}
