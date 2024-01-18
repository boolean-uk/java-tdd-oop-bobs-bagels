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

    public Bagel(Bagel another) {
        super(another);
        this.filling = new ArrayList<>(another.filling);
    }

    public boolean addFilling(Filling filling) {
        return this.filling.add(filling);
    }

    @Override
    public String toString() {
        return "Bagel[" +
                "id=" + System.identityHashCode(this) +
                ", SKU=" + getSKU() +
                ", price=" + getPrice() +
                ", name=" + getName() +
                ", variant=" + getVariant() +
                ", filling=" + filling +
                "]";
    }
}
