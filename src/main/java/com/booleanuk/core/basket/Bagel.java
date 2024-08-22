package com.booleanuk.core.basket;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends BasketItem {

    private List<Integer> linkedIds;    // Id's for the fillings to this Bagel

    public Bagel(String SKU) {
        super(SKU);
        linkedIds = new ArrayList<>();
    }

    // TODO: Does it work to overlode this?
//    public Bagel(String SKU, List<Integer> linkedIds) {
//        super(SKU);
//        this.linkedIds = linkedIds;
//    }

    public void addFillings(int id) {
        linkedIds.add(id);
    }

    public void addFillings(List<Integer> linkedIds) {

//        for (int id : linkedIds) {
//            linkedIds.add(id);
//        }
        linkedIds.addAll(linkedIds);
    }
}
