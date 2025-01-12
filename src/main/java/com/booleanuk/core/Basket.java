package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> basket = new ArrayList<>();
    private int maxCapacity = 10;
    private double totalCost;

    public boolean addItem(Item item) {
        return true;

    }
    public boolean removeItem(Item item) {
        return true;
    }

    public boolean changeCapacity(int newCapacity) {
        return true;
    }

    public double checkCost(Item item) {
        return 0.0;
    }

    public void addFilling(Bagel bagel, Filling filling) {

    }

    public ArrayList<Item> getBasket(){
        return this.basket;
    }

}
