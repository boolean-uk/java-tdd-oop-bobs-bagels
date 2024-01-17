package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    public ArrayList<String> bagelsList = new ArrayList<>();
    int basketCapacity = 4;
    boolean basketIsFull = false;

    public Basket() {
        this.bagelsList = new ArrayList<>();
    }

    public boolean addBagel(String bagel) {
        if (bagelsList.size() == basketCapacity) {
            System.out.println("Basket is full");
            return false;
        } else {
            return this.bagelsList.add(bagel);
        }

    }

    public boolean removeBagel(String bagel) {
        if (bagelsList.isEmpty()) {
            System.out.println("Can't remove item from empty basket");
            return false;
        }
        return this.bagelsList.remove(bagel);

    }

    public int changeBasketCapacity(int change){
        if((this.basketCapacity + change) < 0){
            System.out.println("Can't have negative basket capacity");
            return basketCapacity;
        } else {
            return basketCapacity += change;
        }

    }
}

