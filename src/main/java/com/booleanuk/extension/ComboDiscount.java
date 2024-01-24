package com.booleanuk.extension;

public class ComboDiscount extends Discount{
    private String name;

    public ComboDiscount(String sku, String name, double price) {
        super(sku, price);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}