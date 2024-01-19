package com.booleanuk.core;

public class Bagel {

    private String bagel;
    private String variant;
    private String sku;
    private double price;

    public Bagel(String variant) {
        this.variant = variant;
        if (variant.equals("Onion")) {
            this.sku = "BGLO";
            this.price = 0.49;
        }
        else if (variant.equals("Plain")) {
            this.sku = "BGLP";
            this.price = 0.39;
        }
        else if (variant.equals("Everything")) {
            this.sku = "BGLE";
            this.price = 0.49;
        }
        else if (variant.equals("Sesame")) {
            this.sku = "BGLS";
            this.price = 0.49;
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


    public String getSku() {
        return sku;
    }

    public String getBagel() {
        return bagel;
    }

    public void setBagel(String bagel) {
        this.bagel = bagel;
    }

    @Override
    public String toString() {
        return variant;
    }


}
