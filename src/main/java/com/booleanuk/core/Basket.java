package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {

    private final int initCapacity;
    private List<Bagel> items = new ArrayList<>();

    public Basket(){
        this(5);
    }

    public Basket(int initCapacity) {

        this.initCapacity = initCapacity;
    }


    public int numberOfItems() {
        return items.size();
    }

    public void add(Bagel item) {
        items.add(item);
    }

    public void remove(Bagel item) {
        items.remove(item);
    }


    public int capacity() {
        return 0;
    }
}
