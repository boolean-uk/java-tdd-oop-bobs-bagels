package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {

    private List<OnionBagel> items = new ArrayList<>();

    public int numberOfItems() {
        return items.size();
    }

    public void add(OnionBagel item) {
        items.add(item);
    }
}
