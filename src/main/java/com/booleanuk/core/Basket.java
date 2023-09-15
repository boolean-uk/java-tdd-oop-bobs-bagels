package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private int capacity;
    private Map<Item, Integer> itemsMap;



    private Inventory inventory;
    // make static and final and exclude from constructor?

    public Basket( Inventory inventory,int capacity ) {
        this.setCapacity(capacity);
        this.itemsMap = new HashMap<Item,Integer>();
        this.setInventory(inventory);
    }

    public int getBasketSize() {
        int sum = this.itemsMap.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int capacity) {
        if (capacity<this.getBasketSize()) {
            //add a print message for the mistake
            return false;
        }
        this.capacity = capacity;
        return true;
    }

    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<Item, Integer> itemsMap) {
        this.itemsMap = itemsMap;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public boolean addToBasket(Item item, int amount) {
        if (this.inventory.getInventoryList().contains(item)) {
            this.itemsMap.put(item,amount);
            return true;
        }
        return false;
        //handle item already exists
        //handle capacity is (almost) full
    }




    public boolean removeFromBasket(Item item, int amount) {
        if (this.itemsMap.containsKey(item)
//                && this.itemsMap.get(item)<=amount
                && amount>0) {
            if (amount>=this.itemsMap.get(item)) {
                this.itemsMap.remove(item);
            } else {
                this.itemsMap.put(item,this.itemsMap.get(item)-amount);
            }
            return true;
        }
        return false;
    }
    public boolean isFull() {
      return this.capacity<=this.getBasketSize();
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(quantity)));
        }

        return totalPrice;
    }
}
