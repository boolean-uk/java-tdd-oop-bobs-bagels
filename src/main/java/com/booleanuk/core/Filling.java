package com.booleanuk.core;

public class Filling extends Inventory{

    private String name;
    private String variant;
    private String sku;
    double price;

    public Filling(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        if (variant.equals("Bacon")) {
            this.sku = "FILB";
            this.name = "Filling";
            this.price = 0.12;
        }
        else if (variant.equals("Egg")) {
            this.sku = "FILE";
            this.name = "Filling";
            this.price = 0.12;
        }
        else if (variant.equals("Cheese")) {
            this.sku = "FILC";
            this.name = "Filling";
            this.price = 0.12;
        }
        else if (variant.equals("Cream Cheese")) {
            this.sku = "FILX";
            this.name = "Filling";
            this.price = 0.12;
        }
        else if (variant.equals("Smoked Salmon")) {
            this.sku = "FILS";
            this.name = "Filling";
            this.price = 0.12;
        }
        else if (variant.equals("Ham")) {
            this.sku = "FILH";
            this.name = "Filling";
            this.price = 0.12;
        }
    }
}
