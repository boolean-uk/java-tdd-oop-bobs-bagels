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

    /**
     * Logic: check if available capacity is larger than 0, otherwise do not add to basket.
     * @param item
     * @return item
     */
    public Item add(Item item) {
        if (checkCapacity() > 0) {
            getBasket().add(item);
            return item;
        }
        return null;
    }

    /**
     * Logic: check if basket contains item, if true: remove and return item.
     * @param item
     * @return item
     */
    public Item remove(Item item) {
        for(Item i : getBasket()) {
            if (i == item) {
                getBasket().remove(i);
                return i;
            }
        }
        return null;
    }

    /**
     * Logic: the current available capacity of an instance of a basket, by subtracting the current size from capacity
     * @return available capacity.
     */
    public int checkCapacity() {
        return getCapacity() - getBasket().size();
    }

    /**
     * Logic: change capacity of a basket to newCapacity. If newCapacity is smaller than amount of items in basket,
     * it will behave like a stack a remove the most recently added items. @Dave mentioned this as good idea to implement.
     * @param newCapacity
     * @return true, unless newCapacity is less than 0
     */
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

    /**
     * Dont know if NEEDED - LOOK ON USER STORIES WITH MARIT
     * @return
     */
    public boolean checkItemInBasket() {
        return false;
    }

    /**
     * Logic: Create instance of InventoryManager which in its constructer initializes its stockpile.
     * Do a constant time lookup if @param item is in stock or not.
     * @param item
     * @return Sys.out and false if item is not in stock, else true.
     */
    public boolean checkItemInInventory(Item item) {
        InventoryManager inv = new InventoryManager();
        if (inv.getInventory().containsKey(item.getSKU())) {
            return true;
        }
        System.out.println("We do not stock the following " + item.toString());
        return false;
    }

    /**
     * Logic: self-explanatory
     * @return total cost of items currently in basket.
     */
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
