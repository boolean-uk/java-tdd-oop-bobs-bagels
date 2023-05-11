package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    private int capacity;
    Inventory inventory;
    public Basket(){
        this.items = new ArrayList<>();
        this.capacity = 5; //default value?
        this.inventory = new Inventory();
    }

    public Basket(int capacity) {
        setCapacity(capacity);
        this.items = new ArrayList<>();
        this.inventory = new Inventory();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setCapacity(int capacity) {
        if(capacity<=0){
            System.out.println("Cannot change the basket capacity to something negative!");
        }else if(capacity<this.items.size()){
            System.out.println("Cannot change capacity to something smaller than the current number of items in the basket!");
        }else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

}
