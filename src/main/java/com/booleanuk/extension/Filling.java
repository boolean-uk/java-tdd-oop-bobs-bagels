package com.booleanuk.extension;

public class Filling extends Item {

    public Filling(SKU SKU) {
        this.SKU = SKU;
        switch (SKU) {
            case FILB:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Bacon";
                break;
            case FILE:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Egg";
                break;
            case FILC:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Cheese";
                break;
            case FILX:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Cream Cheese";
                break;
            case FILS:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Smoked Salmon";
                break;
            case FILH:
                this.price = 0.12F;
                this.name = "Filling";
                this.variant = "Ham";
                break;
        }
    }
}
