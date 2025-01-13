package com.booleanuk.core;

public class Item {
    private Double price;
    private String abbreviation;
    private String name;

    public Item(Double price, String abbreviation, String name){
        this.price = price;
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}
