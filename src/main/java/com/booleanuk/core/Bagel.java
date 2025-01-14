package com.booleanuk.core;

public class Bagel extends Item {

    public Bagel(SKU SKU) {
        this.SKU = SKU;
        switch (SKU) {
            case BGLO:
                this.price = 0.49F;
                this.name = "Bagel";
                this.variant = "Onion";
                break;
            case BGLP:
                this.price = 0.39F;
                this.name = "Bagel";
                this.variant = "Plain";
                break;
            case BGLE:
                this.price = 0.49F;
                this.name = "Bagel";
                this.variant = "Everything";
                break;
            case BGLS:
                this.price = 0.49F;
                this.name = "Bagel";
                this.variant = "Sesame";
                break;
        }
    }


}
