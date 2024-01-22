package com.booleanuk.core;

public class Filling implements Item {
    private String SKU;
    private double price;
    private Item.Name name;
    private Item.Variant variant;
    private Item filling;

    public Filling(String SKU, double price, Item.Name name, Item.Variant variant, Item filling) {
        this.setSKU(SKU);
        this.setPrice(price);
        this.setName(name);
        this.setVariant(variant);
        this.setFilling(filling);
    }

    // Overloaded constructor to represent a filling ONLY WHEN inside a Bagel Item
    public Filling(Item.Variant variant) {
        this.setVariant(variant);
    }

    /**
     * Logic: verify that 'this' is a bagel, and that argument is a filling
     * @param filling
     * @return true if filling was added, false if filling not added
     */
    public boolean addFilling(Item filling) {
        if ((this.getName() == Item.Name.BAGEL) && (filling.getName() == Item.Name.FILLING) && (this.getFilling() == null)) {
            setFilling(filling);
            return true;
        }
        System.out.println("This " + this.getVariant() + " " + this.getName() + " already has filling!");
        return false;
    }

    /**
     * Logic: override toString() with custom version.
     * @return my PotAtos in a nicely formatted way. Seems to be useful based on previous exercises
     */
    @Override
    public String toString() {
        return "Item: {" +
                "SKU: '" + SKU + '\'' +
                ", price: " + price +
                ", name: " + name +
                ", variant: " + variant +
                ", filling: " + (filling != null ? filling.getVariant() : "None") +
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

    public Item.Name getName() {
        return name;
    }

    public Item.Variant getVariant() {
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

    public void setName(Item.Name name) {
        this.name = name;
    }

    public void setVariant(Item.Variant variant) {
        this.variant = variant;
    }

    public void setFilling(Item filling) {
        this.filling = filling;
    }
}
