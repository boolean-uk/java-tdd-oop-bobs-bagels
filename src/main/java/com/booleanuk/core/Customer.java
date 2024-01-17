package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    public double getTotalCost(ArrayList<Item> items) {
        return items.stream()
                .map(Item::getPrice)
                .reduce(0.00, Double::sum);
    }

    public double getCostOfItem(Bagel bagel) {
        return bagel.getPrice();
    }
}
