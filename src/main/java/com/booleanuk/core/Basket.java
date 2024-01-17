package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    //String type;
    ArrayList<Bagel> bagels;

    HashMap<String, Integer> items;

    HashMap<String, Integer[]> itemsWithQuantity;
    int basketSize = 5;

    public Basket() {
        bagels = new ArrayList<>(5);
        items = new HashMap<>();
        itemsWithQuantity = new HashMap<>();
        //User Story 3
        /*
        bagels.add("Chocolate");
        bagels.add("Vanilla");
        bagels.add("Banana"); */
    }

    //User Story 1
    public boolean addBagelTypeToBasket(Bagel bagelType) {
        if (this.bagels.contains(bagelType)) {
            return false;
        }
        this.bagels.add(bagelType);
        return true;
    }

    //User Story 2
    public boolean removeBagelTypeFromBasket(Bagel bagelType) {
        if (this.bagels.contains(bagelType)) {
            this.bagels.remove(bagelType);
            return true;
        }
        return false;
    }

    //User Story 3
    public String basketIsFull() {
        if (this.bagels.size() >= this.basketSize) {
            return "Basket is full!";
        }
        return "Basket is not full!";
    }

    //User story 4
    public String changeBasketCapacity(int newCapacity) {
        if(this.bagels.size() < newCapacity) {
            this.bagels = new ArrayList<>(newCapacity);
            return "Basket capacity changed!";
        } else if (this.bagels.size() <= newCapacity) {
            return "Basket capacity is not changed.";
        }
        return "Basket capacity is not changed.";

    }

    //User Story 5
    public String canRemoveItemInBasket(Bagel item) {
        if(this.bagels.contains(item)) {
            return "Item is in basket and can be removed.";
        }
        return "Item is not in basket and can't be removed.";
    }

    //User Story 6
    public void addItem(String item, int quantity, int costPerUnit) {
        itemsWithQuantity.put(item, new Integer[] { quantity, costPerUnit });
    }

    public int totalCostOfItems() {
        int totalCost = 0;
        for (Integer[] value : this.itemsWithQuantity.values()) {
            totalCost += value[0] * value[1]; // quantity * cost per unit
        }
        return totalCost;
    }
}
