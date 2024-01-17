package com.booleanuk.core;

public class Item {

    private String SKU;
    private double price;
    private Name name;
    private Variant variant;
    private Item filling;

    public Item(String SKU, double price, Name name, Variant variant, Item filling) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.filling = filling;
    }

    public boolean addFilling(Item filling) {
      setFilling(filling);
      return false;
    }

    @Override
    public String toString() {
        return "Item: {" +
                "SKU: '" + SKU + '\'' +
                ", price: " + price +
                ", name: " + name +
                ", variant: " + variant +
                ", filling: " + (filling != null ? filling.toString() : "None") +
                '}';
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

    enum Name {
        BAGEL, COFFEE, FILLING
    }
    enum Variant {
        ONION, PLAIN, EVERYTHING, SESAME, BLACK, WHITE, CAPUCCINO, LATTE, BACON, EGG, CHEESE, CREAM_CHEESE, SMOKED_SALMON, HAM
    }
}




