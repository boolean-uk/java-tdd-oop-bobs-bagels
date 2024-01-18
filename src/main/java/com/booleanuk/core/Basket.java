package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {


    private ArrayList<String> bagelsList = new ArrayList<>();
    private int basketCapacity = 4;

    public ArrayList<String> getBagelsList() {
        return bagelsList;
    }

    public void setBagelsList(ArrayList<String> bagelsList) {
        this.bagelsList = bagelsList;
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public void setBasketCapacity(int basketCapacity) {
        this.basketCapacity = basketCapacity;
    }

    public boolean isBasketIsFull() {
        return basketIsFull;
    }

    public void setBasketIsFull(boolean basketIsFull) {
        this.basketIsFull = basketIsFull;
    }

    private boolean basketIsFull = false;

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

