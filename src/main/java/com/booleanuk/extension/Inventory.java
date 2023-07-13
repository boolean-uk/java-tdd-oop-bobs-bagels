package com.booleanuk.extension;

import java.util.List;

public class Inventory {
    private List<String> itemSkus;

    public Inventory(List<String> itemSkus) {
        this.itemSkus = itemSkus;
    }

    public boolean containsItem(String sku) {
        if(itemSkus.contains(sku)) return true;
        return false;
    }
}
