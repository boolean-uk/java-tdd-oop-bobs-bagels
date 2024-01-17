package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private static final int EMPTY = 0;

    public ArrayList<Item> basket;
    public int bagelsInBasket;
    public int fillingsInBasket;
    public int coffeesInBasket;

    public Basket() {
        this.basket = new ArrayList<>();
        this.bagelsInBasket = EMPTY;
        this.fillingsInBasket = EMPTY;
        this.coffeesInBasket = EMPTY;
    }

    public void addItem(Item item) {

    }

    public void removeItem(Item item) {

    }

    public double showTotalCostInBasket() {
        return -1.0;
    }

    public void addBagelFilling(Bagel bagel, Filling filling) {

    }

    public void showCostOfBagel(String name) {

    }

    public void showCostOfFillings() {

    }
}
