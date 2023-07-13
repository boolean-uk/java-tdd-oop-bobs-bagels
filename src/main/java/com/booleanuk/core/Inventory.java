package com.booleanuk.core;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Bagel> bagels;
    private List<Filling> fillings;

    public Inventory() {
        bagels = new ArrayList<>();
        fillings = new ArrayList<>();
    }

    public void addBagel(Bagel bagel) {
        bagels.add(bagel);
        System.out.println("Added bagel to the inventory.");
    }

    public void removeBagel(Bagel bagel) {
        bagels.remove(bagel);
        System.out.println("Removed bagel from the inventory.");
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
        System.out.println("Added filling to the inventory.");
    }

    public void removeFilling(Filling filling) {
        fillings.remove(filling);
        System.out.println("Removed filling from the inventory.");
    }

    public Bagel getBagelBySKU(String sku) {
        for (Bagel bagel : bagels) {
            if (bagel.getSku().equals(sku)) {
                return bagel;
            }
        }
        return null;
    }

    public Filling getFillingBySKU(String sku) {
        for (Filling filling : fillings) {
            if (filling.getSku().equals(sku)) {
                return filling;
            }
        }
        return null;
    }

    public boolean checkItemExists(String sku) {
        for (Bagel bagel : bagels) {
            if (bagel.getSku().equals(sku)) {
                return true;
            }
        }
        for (Filling filling : fillings) {
            if (filling.getSku().equals(sku)) {
                return true;
            }
        }
        return false;
    }
}
