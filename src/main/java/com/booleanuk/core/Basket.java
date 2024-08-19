package com.booleanuk.core;

import java.util.ArrayList;


public class Basket {

    private final ArrayList<String> items = new ArrayList<>();
    private final int capacity;

    public Basket(int capacity){

        this.capacity = capacity;

    }

    public boolean addItem(String bagel){
        if (items.size() < capacity){
            items.add(bagel);
            return true;
        }
        else{
            return false;
        }
    }

}

