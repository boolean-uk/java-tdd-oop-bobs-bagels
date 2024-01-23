package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Basket {
    Inventory inventory;
    ArrayList<Bagel> basket;
    int maxCapacity = 5;
    int currentIndex = 0;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basket = new ArrayList<>();
    }

    public boolean addBagel(Bagel bagel) {
        if(inventory.isBagelInInventory(bagel.getSku())) {
            if (currentIndex < maxCapacity) {
                basket.add(bagel);
                currentIndex++;
                return true;
            }
        }
        return false;
    }

    public boolean removeBagel(Bagel bagel) {
        if (basket.contains(bagel)) {
            basket.remove(bagel);
            return true;
        }
        return false;
    }

    public int extendCapacityOfBasket(int additionalIndices) {
        maxCapacity += additionalIndices;
        return maxCapacity;
    }

    public double getTotalCost() {
        double totalCost = 0.0;

        for(Bagel bagel : basket) {
            totalCost += bagel.price;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return Double.valueOf(decimalFormat.format(totalCost));
    }

    public boolean addFillingToBagel(Bagel bagel, Filling filling) {
        boolean fillingAdded = false;

        if(inventory.isFillingInInventory(filling.getSku())) {
            for (Bagel b : basket) {
                if (bagel.equals(b)) {
                    fillingAdded = b.addFilling(filling);
                    break;
                }
            }
        }
        return fillingAdded;
    }
}
