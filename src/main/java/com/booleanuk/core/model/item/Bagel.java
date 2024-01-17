package com.booleanuk.core.model.item;

import com.booleanuk.core.model.Item;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Bagel extends Item {
    ArrayList<Filling> filling;

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
        this.filling = new ArrayList<>();
    }

    public boolean addFillingToBagel(Filling filling) {
        return this.filling.add(filling);
    }
}
