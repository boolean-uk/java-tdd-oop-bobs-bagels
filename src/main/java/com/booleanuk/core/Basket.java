package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {

    private List<String> items = new ArrayList<>();

    public int numberOfItems() {
        return items.size();
    }

    public void add(String item) {
        items.add(item);
    }
}
