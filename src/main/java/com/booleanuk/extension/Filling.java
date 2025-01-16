package com.booleanuk.extension;

public class Filling extends Item {

    private final Bagel bagel;

    public Filling(String SKU, int id, Bagel bagel) {
        this.bagel = bagel;
        this.setId(id);
        this.setName("Filling");
        this.setPrice(1200);
        this.setDiscountPrice(-1);
        switch (SKU) {
            case "FILB": {
                this.setSKU(SKU);
                this.setVariant("Bacon");
                this.bagel.addFillings(this);
                break;
            }
            case "FILE": {
                this.setSKU(SKU);
                this.setVariant("Egg");
                this.bagel.addFillings(this);
                break;
            }
            case "FILC": {
                this.setSKU(SKU);
                this.setVariant("Cheese");
                this.bagel.addFillings(this);
                break;
            }
            case "FILX": {
                this.setSKU(SKU);
                this.setVariant("Cream Cheese");
                this.bagel.addFillings(this);
                break;
            }
            case "FILS": {
                this.setSKU(SKU);
                this.setVariant("Smoked Salmon");
                this.bagel.addFillings(this);
                break;
            }
            case "FILH": {
                this.setSKU(SKU);
                this.setVariant("Ham");
                this.bagel.addFillings(this);
                break;
            }
        }
    }

    public Bagel getBagel() {
        return bagel;
    }
}
