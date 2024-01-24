package com.booleanuk.core;

public class Coffee extends Inventory {

    private String name;
    private String variant;
    private String sku;
    private double price;

    public Coffee(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        if (variant.equals("Black")) {
            this.sku = "COFB";
            this.name = "Coffee";
            this.price = 0.99;
        }
        else if (variant.equals("White")) {
            this.sku = "COFW";
            this.name = "Coffee";
            this.price = 1.19;
        }
        else if (variant.equals("Capuccino")) {
            this.sku = "COFC";
            this.name = "Coffee";
            this.price = 1.29;
        }
        else if (variant.equals("Latte")) {
            this.sku = "COFL";
            this.name = "Coffee";
            this.price = 1.29;
        }
    }
}
