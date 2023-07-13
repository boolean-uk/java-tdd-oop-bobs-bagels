package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Bagel> bagles;
    Bagel bagel;
    int capacity;
    public Basket(int capacity){
        bagles = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean add(Bagel bagel) {
        if(bagles.size() < capacity){
            bagles.add(bagel);
            return true;
        }
        else{
            return false;
        }
    }

}
