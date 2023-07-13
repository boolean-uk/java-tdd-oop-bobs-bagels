package com.booleanuk.core;

import java.util.Currency;
import java.util.Locale;

public class Item implements IProduct {
    final String SKU;
    final String type;
    final String variant;
    final double cost;

    public Item(String SKU) {
        this.SKU = SKU;
        switch(SKU) {
            case "BGLO":
                this.type = "Bagel"; this.variant = "Onion"; this.cost = 0.49; break;
            case "BGLP":
                this.type = "Bagel"; this.variant = "Plain"; this.cost = 0.39; break;
            case "BGLE":
                this.type = "Bagel"; this.variant = "Everything"; this.cost = 0.49; break;
            case "BGLS":
                this.type = "Bagel"; this.variant = "Sesame"; this.cost = 0.49; break;
            case "COFB":
                this.type = "Coffee"; this.variant = "Black"; this.cost = 0.99; break;
            case "COFW":
                this.type = "Coffee"; this.variant = "White"; this.cost = 1.19; break;
            case "COFC":
                this.type = "Coffee"; this.variant = "Cappuccino"; this.cost = 1.29; break;
            case "COFL":
                this.type = "Coffee"; this.variant = "Latte"; this.cost = 1.29; break;
            case "FILB":
                this.type = "Filling"; this.variant = "Bacon"; this.cost = 0.12; break;
            case "FILE":
                this.type = "Filling"; this.variant = "Egg"; this.cost = 0.12; break;
            case "FILC":
                this.type = "Filling"; this.variant = "Cheese"; this.cost = 0.12; break;
            case "FILX":
                this.type = "Filling"; this.variant = "Cream Cheese"; this.cost = 0.12; break;
            case "FILS":
                this.type = "Filling"; this.variant = "Smoked Salmon"; this.cost = 0.12; break;
            case "FILH":
                this.type = "Filling"; this.variant = "Ham"; this.cost = 0.12; break;
            default:
                this.type = "None"; this.variant = "None"; this.cost = -1.0; break;
        }
    }

    @Override
    public double getCost() { return cost; }

    @Override
    public boolean getAvailable() { return Inventory.itemAvailable(this); }

    public String toString() {
        String result = String.format(
            "\n%s %s  %s",
                this.variant,
                this.type,
                Currency.getInstance(Locale.UK).getSymbol() + this.cost
        );
        return result;
    }
}
