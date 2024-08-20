package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagels extends Product{
    private List<Fillings> fillings;

    Bagels(String SKU, double price, String variant) {
        super(SKU, price, variant);
        fillings = new ArrayList<>();
    }

    public List<Fillings> getFillings() {
        return fillings;
    }

    public void addFilling(Fillings filling) {
        fillings.add(filling);
    }

    public void removeFilling(Fillings filling) {
        fillings.remove(filling);
    }

    public void printFillings() {
        if (fillings.isEmpty()) {
            System.out.println("This bagel has no fillings.");
        } else {
            System.out.println("Fillings in this bagel:");
            for (Fillings filling : fillings) {
                System.out.println("Filling SKU: " + filling.getSKU() + ", Variant: " + filling.getVariant() + ", Price: $" + filling.getPrice());
            }
        }
    }


}
