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
        if (checkCapacity() > 0) {
            getBasket().add(item);
            return item;
        }
        return null;
    }

    public Item remove(Item item) {
        for(Item i : getBasket()) {
            if (i == item) {
                getBasket().remove(i);
                return i;
            }
        }
        return null;
    }

    public int checkCapacity() {
        return getCapacity() - getBasket().size();
    }

    public boolean changeCapacity(int newCapacity) {
        if (newCapacity > 0) {
            while(getBasket().size() > newCapacity){
                getBasket().remove(getBasket().size()-1);
            }
            setCapacity(newCapacity);
            return true;
        }
        return false;
    }

    public boolean checkItemInBasket() {
        return false;
    }

    public boolean checkItemInInventory() {
        return false;
    }

    public double totalCost() {
        double total = 0.0;
        for(Item i : getBasket()) {
            total += i.getPrice();
        }
        System.out.println(total);
        return total;
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
