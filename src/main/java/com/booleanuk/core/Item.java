package com.booleanuk.core;

public class Item {
    private Double price;
    private String abbreviation;
    private String name;
    private String typeOfItem;

    public Item(Double price, String abbreviation, String name, String typeOfItem){
        this.price = price;
        this.abbreviation = abbreviation;
        this.name = name;
        this.typeOfItem = typeOfItem;
    }

    public String getTypeOfItem() {
        return typeOfItem;
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
