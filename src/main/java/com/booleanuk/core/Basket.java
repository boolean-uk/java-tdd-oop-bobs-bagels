package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public boolean addItem(String sku, double price, String name, String variant) {
        return true;
    }

    public boolean removeItem(String sku) {
        return true;
    }

    public List<Item> getItems() {
        return new ArrayList<>();
    }
}
