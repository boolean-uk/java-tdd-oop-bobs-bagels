package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    Filling filling;

    public Bagel(String sku, float price, String name, String variant) {
        super(sku, price, name, variant);
        filling = null;
    }

    public Bagel(String sku, float price, String name, String variant, int specialOfferQuantity, float specialOfferPrice) {
        super(sku, price, name, variant, specialOfferQuantity, specialOfferPrice);
        filling = null;
    }

    public void addFilling(Filling filling){
        this.filling = filling;
    }

    public Filling getFilling() {
        return filling;
    }
}
