package com.booleanuk.extension;

public class Coffee extends Item {

    public Coffee(SKU SKU) {
        this.SKU = SKU;
        switch (SKU) {
            case COFB:
                this.price = 0.99F;
                this.name = "Coffee";
                this.variant = "Black";
                break;
            case COFW:
                this.price = 1.19F;
                this.name = "Coffee";
                this.variant = "White";
                break;
            case COFC:
                this.price = 1.29F;
                this.name = "Coffee";
                this.variant = "Capuccino";
                break;
            case COFL:
                this.price = 1.29F;
                this.name = "Coffee";
                this.variant = "Latte";
                break;
        }
    }
}
