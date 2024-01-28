package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {

    private List<Bagel> items = new ArrayList<>();

    public int numberOfItems() {
        return items.size();
    }

    public void add(Bagel item) {
        items.add(item);
    }
}
