package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

// TODO: Pause work on this, outside scope of exercise
public class BobsBagels {
    private List<Basket> baskets;

    public BobsBagels() {
        this.baskets = new ArrayList<>();
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public String setBasketCapacity(int cap) {
        if (cap < 1) {
            return "Minimum capacity for baskets are 1";
        }
        boolean overCap = false;
        for (Basket basket: this.baskets) {
            if (basket.getNumberOfItems() > cap) {
                overCap = true;
            }
            basket.setCapacity(cap);
        }
        if (overCap) {
            return "Capacity set to 1. There are customers with more than 1 product in basket";
        }
        return "Capacity set to 3";
    }
}