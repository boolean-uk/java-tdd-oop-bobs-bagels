package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {
    HashMap<Bagel , Integer> shoppingBasket;
    int capacity;
    int sizeOfBasket;
    double total;

    public Basket() {
        shoppingBasket=new HashMap<>();
        capacity=3;
        sizeOfBasket = 0;
        total =0.0;
    }

    public boolean add(Bagel bagel) {
        if (bagel != null) {
            shoppingBasket.put(bagel,1);
            sizeOfBasket += 1;
            return true;
        }
        return false;
    }
}
