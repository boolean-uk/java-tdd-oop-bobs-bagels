package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BasketManager {

    private List<Item> basket;
    private int capacity;

    public BasketManager() {
        this.basket = new ArrayList<>();
        this.capacity = 10;
    }

    public Item add(Item item) {
        return null;
    }

    public Item remove(Item item) {
        return null;
    }

    public int checkCapacity() {
        return 0;
    }

    public void changeCapacity() {

    }

    public boolean checkItemInBasket() {
        return false;
    }

    public boolean checkItemInInventory() {
        return false;
    }

    public double totalCost() {
        return 0.0;
    }

    /**
     * Getters for member variables
     */

    public List<Item> getBasket() {
        return basket;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Setters for member variables
     */

    public void setBasket(List<Item> basket) {
        this.basket = basket;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
