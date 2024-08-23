package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BasketItem {
    private String SKU;
    private List<Integer> linkedIds;

    public BasketItem(String SKU) {
        this.SKU = SKU;
        this.linkedIds = new ArrayList<>();
    }

    // TODO: Refactor may not be used
    public BasketItem(String SKU, List<Integer> linkedIds) {
        this.SKU = SKU;
        this.linkedIds = linkedIds;
    }

    public String getSKU() {
        return SKU;
    }

    public List<Integer> getLinkedIds() {
        return linkedIds;
    }

    public void addFillingId(int id) {
        this.linkedIds.add(id);
    }
}
