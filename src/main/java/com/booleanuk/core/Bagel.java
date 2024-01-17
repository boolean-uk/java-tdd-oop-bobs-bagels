package com.booleanuk.core;

public class Bagel {

    String bagel;

    private String variant;
    private String sku;

    public Bagel(String variant) {
        this.variant = variant;
        if (variant.equals("Onion")) {
            this.sku = "BGLO";
        }
        else if (variant.equals("Plain")) {
            this.sku = "BGLP";
        }
        else if (variant.equals("Everything")) {
            this.sku = "BGLE";
        }
        else if (variant.equals("Sesame")) {
            this.sku = "BGLS";
        }
    }

    // Getters
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
}
