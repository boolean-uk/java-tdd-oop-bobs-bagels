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

    public Bagel(String SKU, List<String> linkedFillingsSKUs) {
        super(SKU);
        this.linkedFillingSKUs = linkedFillingsSKUs;
        linkedFillingIds = new ArrayList<>();
    }

    public List<String> getLinkedFillingSKUs() {
        return linkedFillingSKUs;
    }

    public List<Integer> getLinkedFillingIds() {
        return linkedFillingIds;
    }
}
