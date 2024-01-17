package com.booleanuk.core;

public class Filling {

    String fillingType;

    private String variant;
    private String sku;

    public Filling(String variant) {
        this.variant = variant;
        if (variant.equals("Bacon")) {
            this.sku = "FILB";
        }
        else if (variant.equals("Egg")) {
            this.sku = "FILE";
        }
        else if (variant.equals("Cheese")) {
            this.sku = "FILC";
        }
        else if (variant.equals("Cream Cheese")) {
            this.sku = "FILX";
        }
        else if (variant.equals("Smoked Salmon")) {
            this.sku = "FILS";
        }
        else if (variant.equals("Ham")) {
            this.sku = "FILH";
        }

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

    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }
}
