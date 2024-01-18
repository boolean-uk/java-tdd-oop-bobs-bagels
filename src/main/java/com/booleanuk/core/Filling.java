package com.booleanuk.core;

public class Filling {

    private String filling;

    private String variant;
    private String sku;

    double price;

    public Filling(String variant) {
        this.variant = variant;
        if (variant.equals("Bacon")) {
            this.sku = "FILB";
            this.price = 0.12;
        }
        else if (variant.equals("Egg")) {
            this.sku = "FILE";
            this.price = 0.12;
        }
        else if (variant.equals("Cheese")) {
            this.sku = "FILC";
            this.price = 0.12;
        }
        else if (variant.equals("Cream Cheese")) {
            this.sku = "FILX";
            this.price = 0.12;
        }
        else if (variant.equals("Smoked Salmon")) {
            this.sku = "FILS";
            this.price = 0.12;
        }
        else if (variant.equals("Ham")) {
            this.sku = "FILH";
            this.price = 0.12;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }


}
