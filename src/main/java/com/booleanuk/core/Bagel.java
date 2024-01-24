package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item {
    private ArrayList<Filling> fillings;

    public Bagel(String sku, String variant, double price) {
        super(sku, "Bagel", variant, price);
        this.fillings = new ArrayList<>();
    }

    public void addFilling(Filling filling) {
        // Only possible to add 1 filling for each variant.
        if (!this.fillings.contains(filling)) {
            this.fillings.add(filling);
        }
    }

    public void removeFilling(Filling filling) {
        this.fillings.remove(filling);
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }
}
