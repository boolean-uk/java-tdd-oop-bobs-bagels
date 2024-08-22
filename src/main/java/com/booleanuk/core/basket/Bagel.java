package com.booleanuk.core.basket;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends BasketItem {

    private List<String> linkedFillingSKUs;
    private List<Integer> linkedFillingIds;    // Id's for the fillings to this Bagel

    public Bagel(String SKU) {
        super(SKU);
        linkedFillingSKUs = new ArrayList<>();
        linkedFillingIds = new ArrayList<>();
    }

    // TODO: Does it work to overlode this?
    public Bagel(String SKU, List<String> linkedFillingsSKUs) {
        super(SKU);
        this.linkedFillingSKUs = linkedFillingsSKUs;
        linkedFillingIds = new ArrayList<>();
    }

//    public void addFilling(String SKU) {
//        linkedFillingSKUs.add(SKU);
//    }
//
//    public void addFillings(List<String> linkedIds) {
//
////        for (int id : linkedIds) {
////            linkedIds.add(id);
////        }
//        linkedFillingSKUs.addAll(linkedIds);
//    }

    public List<String> getLinkedFillingSKUs() {
        return linkedFillingSKUs;
    }

    public List<Integer> getLinkedFillingIds() {
        return linkedFillingIds;
    }
}
