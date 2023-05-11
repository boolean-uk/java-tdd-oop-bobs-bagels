package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Filling;

import java.util.HashMap;
import java.util.List;

public class Basket {
    HashMap<Bagel, Integer> shoppingBasket;
    int capacity;
    int sizeOfBasket;
    double total;

    public Basket() {
        shoppingBasket = new HashMap<>();
        capacity = 3;
        sizeOfBasket = 0;
        total = 0.0;

    }

    public boolean add(Bagel bagel) {
        if (sizeOfBasket == capacity) {
            return false;
        }
        List<Filling> fils = bagel.getFillings();
        double priceOfFillings = 0.0;
        for (Filling fil : fils) {
            priceOfFillings += fil.getPrice();
        }
        if (shoppingBasket.containsKey(bagel)) {
            shoppingBasket.put(bagel, shoppingBasket.get(bagel) + 1);
        } else {
            shoppingBasket.put(bagel, 1);
        }
        sizeOfBasket += 1;
        total += bagel.getPrice() + priceOfFillings;
        total = (double) Math.round(total * 100) / 100;
        return true;

    }

    boolean remove(Bagel bagel) {

        if (!shoppingBasket.containsKey(bagel)) {
            return false;
        }
        List<Filling> fils = bagel.getFillings();
        double priceOfFillings = 0.0;
        for (Filling fil : fils) {
            priceOfFillings += fil.getPrice();
        }

        if (shoppingBasket.containsKey(bagel)) {
            if (shoppingBasket.get(bagel) == 1) {
                shoppingBasket.remove(bagel);
            } else {
                shoppingBasket.put(bagel, shoppingBasket.get(bagel) - 1);
            }
        }
        sizeOfBasket -= 1;
        total -= bagel.getPrice() - priceOfFillings;
        total = (double) Math.round(total * 100) / 100;
        return true;

    }

    boolean setCapacity(int newCap) {
        if (sizeOfBasket > newCap || newCap == 0) {
            return false;
        }
        this.capacity = newCap;
        return true;
    }

}
