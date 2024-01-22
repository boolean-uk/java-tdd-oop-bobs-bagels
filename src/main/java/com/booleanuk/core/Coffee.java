package com.booleanuk.core;

public class Coffee implements Product{
    private final String SKU;
    private final String name;
    private final String type;
    private final double price;

    public Coffee(String SKU){
        switch (SKU){
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
