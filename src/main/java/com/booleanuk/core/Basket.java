package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Basket {
    private Inventory inventory;
    private ArrayList<Product> basket;
    private int maxCapacity = 5;
    private int currentIndex = 0;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basket = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        if(inventory.isProductInInventory(product.getSku())) {
            if (currentIndex < maxCapacity) {
                basket.add(product);
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

        for(Product product : basket) {
            totalCost += product.getPrice();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return Double.valueOf(decimalFormat.format(totalCost));
    }

    public boolean addFillingToBagel(Bagel bagel, Filling filling) {
        boolean fillingAdded = false;

        if(inventory.isProductInInventory(filling.getSku())) {
            for (Product product : basket) {
                if (product.equals(bagel)) {
                    fillingAdded = bagel.addFilling(filling);
                    break;
                }
            }
        }
        return fillingAdded;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }
}
