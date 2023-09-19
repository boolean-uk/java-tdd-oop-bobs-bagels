package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;


class Basket {

    private List<String> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(String item) {
        items.add(item);
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