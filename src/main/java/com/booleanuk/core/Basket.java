package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final int capacity;
    private List<Bagel> items = new ArrayList<>();

    public Basket(){
        this(5);
    }

    public Basket(int capacity) {

        this.capacity = capacity;
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
        return capacity;
    }

    public int spaceLeft() {
        return 10;
    }
}
