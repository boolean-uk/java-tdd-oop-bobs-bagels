package com.booleanuk.core.model.item;

import com.booleanuk.core.model.Item;

import java.util.ArrayList;

public class Bagel extends Item {
    ArrayList<Filling> filling;

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }


}
