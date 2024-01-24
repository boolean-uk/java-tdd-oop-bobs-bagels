package com.booleanuk.core;

public class Coffee implements Item {
    private String SKU;
    private double price;
    private Item.Name name;
    private Item.Variant variant;

    public Coffee(String SKU, double price, Item.Name name, Item.Variant variant, Item filling) {
        this.setSKU(SKU);
        this.setPrice(price);
        this.setName(name);
        this.setVariant(variant);
    }

    public Item copy() {
        return new Coffee(getSKU(), getPrice(), getName(), getVariant(), getFilling());
    }

//    /**
//     * Logic: verify that 'this' is a bagel, and that argument is a filling
//     * @param filling
//     * @return true if filling was added, false if filling not added
//     */
//    public boolean addFilling(Item filling) {
//        System.out.println("Can't add filling to Coffee you moron!");
//        return false;
//    }

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

    @Override
    public Item getFilling() {
        return null;
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

    @Override
    public void setFilling(Item filling) {

    }

}
