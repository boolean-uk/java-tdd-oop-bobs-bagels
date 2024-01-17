package com.booleanuk.core;

public class Item {

    private String SKU;
    private double price;
    private Name name;
    private Variant variant;
    private Item filling;

    public Item() {

    }

    /**
     * Getters for member variables
     */

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public Name getName() {
        return name;
    }

    public Variant getVariant() {
        return variant;
    }

    public Item getFilling() {
        return filling;
    }

    /**
     * Setters for member variables
     */

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public void setFilling(Item filling) {
        this.filling = filling;
    }
}


enum Name {
    HEARTS, DIAMONDS, CLUBS, SPADES
}
enum Variant {
    HEARTS, DIAMONDS, CLUBS, SPADES
}


