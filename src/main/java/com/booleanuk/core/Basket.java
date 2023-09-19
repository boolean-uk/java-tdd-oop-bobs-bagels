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

}