package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {


    private ArrayList<String> itemList = new ArrayList<>();
    private int basketCapacity = 4;

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
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
        this.itemList = new ArrayList<>();
    }

    public boolean addItem(String item) {
        if (itemList.size() == basketCapacity) {
            System.out.println("Basket is full");
            return false;
        } else {
            return this.itemList.add(item);
        }

    }

    public boolean removeItem(String item) {
        if (itemList.isEmpty()) {
            System.out.println("Can't remove item from empty basket");
            return false;
        }
        return this.itemList.remove(item);

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

