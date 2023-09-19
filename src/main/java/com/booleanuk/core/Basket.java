package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;


class Basket {

    private List<String> items;
    private int avSpace = 0;

    public Basket() {
        this.items = new ArrayList<>();

    }

    public Basket(int space) {
        this.items = new ArrayList<>();
        this.avSpace = space;
    }

    public boolean add(String item) {
        if (items.size() < avSpace) {
            items.add(item);
            System.out.println("item has been added");
            return true;
        }
        return false;
    }



    public boolean contains(String item) {
        return items.contains(item);
    }



    public void remove(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + "has been deleted from the list");
        } else {
            System.out.println("This item has not been found");
        }
    }

}