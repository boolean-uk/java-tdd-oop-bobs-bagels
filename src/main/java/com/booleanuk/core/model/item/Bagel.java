package com.booleanuk.core.model.item;

import com.booleanuk.core.model.Item;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
//@ToString
public class Bagel extends Item {
    ArrayList<Filling> filling;

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
        this.filling = new ArrayList<>();
    }

    public Bagel(Bagel another) {
        super(another);
        this.filling = new ArrayList<>(another.filling);
    }

    public Filling addFillingToBagel(Filling filling) {
        Filling copy = new Filling(filling);
        this.filling.add(copy);
        return copy;
    }
}
